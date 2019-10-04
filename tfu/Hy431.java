/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import tfu.Ho429;

class Hy431
implements Runnable {
    private InputStream d;
    private int e = 0;
    private Thread g;
    private int h = 0;
    private byte[] j;
    private int q;
    private IOException s;

    @Override
    public void run() {
        do {
            int n;
            int n2;
            Hy431 hy431 = this;
            synchronized (hy431) {
                do {
                    if (this.s != null) {
                        return;
                    }
                    n2 = this.e == 0 ? this.q - this.h - 1 : (this.e <= this.h ? this.q - this.h : this.e - this.h - 1);
                    if (n2 > 0) break;
                    try {
                        this.wait();
                    }
                    catch (InterruptedException interruptedException) {}
                } while (true);
            }
            try {
                n = this.d.read(this.j, this.h, n2);
                if (n == -1) {
                    throw new EOFException();
                }
            }
            catch (IOException iOException) {
                Hy431 hy4312 = this;
                synchronized (hy4312) {
                    this.s = iOException;
                    return;
                }
            }
            Hy431 hy4313 = this;
            synchronized (hy4313) {
                this.h = (this.h + n) % this.q;
            }
        } while (true);
    }

    Hy431(InputStream inputStream, int n) {
        this.d = inputStream;
        this.q = n + 1;
        this.j = new byte[this.q];
        this.g = new Thread(this);
        this.g.setDaemon(true);
        this.g.setName("ClientStreamReader");
        this.g.start();
    }

    public boolean q(int n) throws IOException {
        if (n <= 0 || n >= this.q) {
            throw new IOException();
        }
        Hy431 hy431 = this;
        synchronized (hy431) {
            int n2 = this.e <= this.h ? this.h - this.e : this.q - this.e + this.h;
            if (n2 < n) {
                if (this.s != null) {
                    throw new IOException(this.s.toString());
                }
                this.notifyAll();
                return false;
            }
            return true;
        }
    }

    public int j() throws IOException {
        Hy431 hy431 = this;
        synchronized (hy431) {
            int n = this.e <= this.h ? this.h - this.e : this.q - this.e + this.h;
            if (this.s != null) {
                throw new IOException(this.s.toString());
            }
            this.notifyAll();
            return n;
        }
    }

    public int e(byte[] arrby, int n, int n2) throws IOException {
        if (n2 < 0 || n < 0 || n + n2 > arrby.length) {
            throw new IOException();
        }
        Hy431 hy431 = this;
        synchronized (hy431) {
            int n3 = this.e <= this.h ? this.h - this.e : this.q - this.e + this.h;
            if (n2 > n3) {
                n2 = n3;
            }
            if (n2 == 0 && this.s != null) {
                throw new IOException(this.s.toString());
            }
            if (this.e + n2 <= this.q) {
                System.arraycopy(this.j, this.e, arrby, n, n2);
            } else {
                int n4 = this.q - this.e;
                System.arraycopy(this.j, this.e, arrby, n, n4);
                System.arraycopy(this.j, 0, arrby, n + n4, n2 - n4);
            }
            this.e = (this.e + n2) % this.q;
            this.notifyAll();
            return n2;
        }
    }

    public void h() {
        Hy431 hy431 = this;
        synchronized (hy431) {
            if (this.s == null) {
                this.s = new IOException("Closed");
            }
            this.notifyAll();
        }
        try {
            this.g.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public void s() {
        this.d = new Ho429();
    }
}

