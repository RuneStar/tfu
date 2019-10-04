// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class Hy431 implements Runnable
{
    private InputStream d;
    private int e;
    private Thread g;
    private int h;
    private byte[] j;
    private int q;
    private IOException s;
    
    @Override
    public void run() {
        while (true) {
            int read = 0;
            Label_0102: {
                int len;
                synchronized (this) {
                    while (this.s == null) {
                        if (this.e == 0) {
                            len = this.q - this.h - 1;
                        }
                        else if (this.e <= this.h) {
                            len = this.q - this.h;
                        }
                        else {
                            len = this.e - this.h - 1;
                        }
                        if (len > 0) {
                            break Label_0102;
                        }
                        try {
                            this.wait();
                        }
                        catch (InterruptedException ex) {}
                    }
                    return;
                }
                try {
                    read = this.d.read(this.j, this.h, len);
                    if (read == -1) {
                        throw new EOFException();
                    }
                }
                catch (IOException s) {
                    synchronized (this) {
                        this.s = s;
                        return;
                    }
                }
            }
            synchronized (this) {
                this.h = (this.h + read) % this.q;
            }
        }
    }
    
    Hy431(final InputStream d, final int n) {
        this.e = 0;
        this.h = 0;
        this.d = d;
        this.q = n + 1;
        this.j = new byte[this.q];
        (this.g = new Thread(this)).setDaemon(true);
        this.g.setName("ClientStreamReader");
        this.g.start();
    }
    
    public boolean q(final int n) throws IOException {
        if (n <= 0 || n >= this.q) {
            throw new IOException();
        }
        synchronized (this) {
            int n2;
            if (this.e <= this.h) {
                n2 = this.h - this.e;
            }
            else {
                n2 = this.q - this.e + this.h;
            }
            if (n2 >= n) {
                return true;
            }
            if (this.s != null) {
                throw new IOException(this.s.toString());
            }
            this.notifyAll();
            return false;
        }
    }
    
    public int j() throws IOException {
        synchronized (this) {
            int n;
            if (this.e <= this.h) {
                n = this.h - this.e;
            }
            else {
                n = this.q - this.e + this.h;
            }
            if (this.s != null) {
                throw new IOException(this.s.toString());
            }
            this.notifyAll();
            return n;
        }
    }
    
    public int e(final byte[] array, final int n, int n2) throws IOException {
        if (n2 < 0 || n < 0 || n + n2 > array.length) {
            throw new IOException();
        }
        synchronized (this) {
            int n3;
            if (this.e <= this.h) {
                n3 = this.h - this.e;
            }
            else {
                n3 = this.q - this.e + this.h;
            }
            if (n2 > n3) {
                n2 = n3;
            }
            if (n2 == 0 && this.s != null) {
                throw new IOException(this.s.toString());
            }
            if (this.e + n2 <= this.q) {
                System.arraycopy(this.j, this.e, array, n, n2);
            }
            else {
                final int n4 = this.q - this.e;
                System.arraycopy(this.j, this.e, array, n, n4);
                System.arraycopy(this.j, 0, array, n + n4, n2 - n4);
            }
            this.e = (this.e + n2) % this.q;
            this.notifyAll();
            return n2;
        }
    }
    
    public void h() {
        synchronized (this) {
            if (this.s == null) {
                this.s = new IOException("Closed");
            }
            this.notifyAll();
        }
        try {
            this.g.join();
        }
        catch (InterruptedException ex) {}
    }
    
    public void s() {
        this.d = new Ho429();
    }
}
