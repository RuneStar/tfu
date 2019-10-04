// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.IOException;
import java.io.OutputStream;

class Ht433 implements Runnable
{
    private boolean b;
    private OutputStream d;
    private int e;
    private Thread g;
    private int h;
    private byte[] j;
    private int q;
    private IOException s;
    
    public void h() {
        this.d = new Hj423();
    }
    
    private boolean q() {
        if (this.b) {
            try {
                this.d.close();
                if (this.s == null) {
                    this.s = new IOException("Closed");
                }
            }
            catch (IOException cause) {
                if (this.s == null) {
                    this.s = new IOException(cause);
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void run() {
        do {
            int len = 0;
            Label_0112: {
                synchronized (this) {
                    while (this.s == null) {
                        if (this.e <= this.h) {
                            len = this.h - this.e;
                        }
                        else {
                            len = this.q - this.e + this.h;
                        }
                        if (len > 0) {
                            break Label_0112;
                        }
                        try {
                            this.d.flush();
                        }
                        catch (IOException s) {
                            this.s = s;
                            return;
                        }
                        if (this.q()) {
                            return;
                        }
                        try {
                            this.wait();
                        }
                        catch (InterruptedException ex) {}
                    }
                    return;
                }
                try {
                    if (this.e + len <= this.q) {
                        this.d.write(this.j, this.e, len);
                    }
                    else {
                        final int len2 = this.q - this.e;
                        this.d.write(this.j, this.e, len2);
                        this.d.write(this.j, 0, len - len2);
                    }
                }
                catch (IOException s2) {
                    synchronized (this) {
                        this.s = s2;
                        return;
                    }
                }
            }
            synchronized (this) {
                this.e = (this.e + len) % this.q;
            }
        } while (!this.q());
    }
    
    Ht433(final OutputStream d, final int n) {
        this.e = 0;
        this.h = 0;
        this.d = d;
        this.q = n + 1;
        this.j = new byte[this.q];
        (this.g = new Thread(this)).setDaemon(true);
        this.g.setName("ClientStreamWriter");
        this.g.start();
    }
    
    public static void e(final Ht433 ht433) {
        synchronized (ht433) {
            ht433.b = true;
            ht433.notifyAll();
        }
        try {
            ht433.g.join();
        }
        catch (InterruptedException ex) {}
    }
    
    public void j(final byte[] array, final int n, final int i) throws IOException {
        if (i < 0 || n < 0 || n + i > array.length) {
            throw new IOException();
        }
        synchronized (this) {
            if (this.s != null) {
                throw new IOException(this.s.toString());
            }
            int j;
            if (this.e <= this.h) {
                j = this.q - this.h + this.e - 1;
            }
            else {
                j = this.e - this.h - 1;
            }
            if (j < i) {
                throw new IOException("Buffer overflow " + i + " " + j);
            }
            if (this.h + i <= this.q) {
                System.arraycopy(array, n, this.j, this.h, i);
            }
            else {
                final int n2 = this.q - this.h;
                System.arraycopy(array, n, this.j, this.h, n2);
                System.arraycopy(array, n + n2, this.j, 0, i - n2);
            }
            this.h = (this.h + i) % this.q;
            this.notifyAll();
        }
    }
}
