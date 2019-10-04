/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.IOException;
import java.io.OutputStream;
import tfu.Hj423;

class Ht433
implements Runnable {
    private boolean b;
    private OutputStream d;
    private int e = 0;
    private Thread g;
    private int h = 0;
    private byte[] j;
    private int q;
    private IOException s;

    public void h() {
        this.d = new Hj423();
    }

    private boolean q() {
        if (this.b) {
            block4 : {
                try {
                    this.d.close();
                    if (this.s == null) {
                        this.s = new IOException("Closed");
                    }
                }
                catch (IOException iOException) {
                    if (this.s != null) break block4;
                    this.s = new IOException(iOException);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        do {
            int n;
            Ht433 ht433 = this;
            synchronized (ht433) {
                do {
                    if (this.s != null) {
                        return;
                    }
                    n = this.e <= this.h ? this.h - this.e : this.q - this.e + this.h;
                    if (n > 0) break;
                    try {
                        this.d.flush();
                    }
                    catch (IOException iOException) {
                        this.s = iOException;
                        return;
                    }
                    if (this.q()) {
                        return;
                    }
                    try {
                        this.wait();
                    }
                    catch (InterruptedException interruptedException) {}
                } while (true);
            }
            try {
                if (this.e + n <= this.q) {
                    this.d.write(this.j, this.e, n);
                } else {
                    int n2 = this.q - this.e;
                    this.d.write(this.j, this.e, n2);
                    this.d.write(this.j, 0, n - n2);
                }
            }
            catch (IOException iOException) {
                Ht433 ht4332 = this;
                synchronized (ht4332) {
                    this.s = iOException;
                    return;
                }
            }
            ht433 = this;
            synchronized (ht433) {
                this.e = (this.e + n) % this.q;
            }
        } while (!this.q());
    }

    Ht433(OutputStream outputStream, int n) {
        this.d = outputStream;
        this.q = n + 1;
        this.j = new byte[this.q];
        this.g = new Thread(this);
        this.g.setDaemon(true);
        this.g.setName("ClientStreamWriter");
        this.g.start();
    }

    public static void e(Ht433 ht433) {
        Ht433 ht4332 = ht433;
        synchronized (ht4332) {
            ht433.b = true;
            ht433.notifyAll();
        }
        try {
            ht433.g.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public void j(byte[] arrby, int n, int n2) throws IOException {
        if (n2 < 0 || n < 0 || n + n2 > arrby.length) {
            throw new IOException();
        }
        Ht433 ht433 = this;
        synchronized (ht433) {
            if (this.s != null) {
                throw new IOException(this.s.toString());
            }
            int n3 = this.e <= this.h ? this.q - this.h + this.e - 1 : this.e - this.h - 1;
            if (n3 < n2) {
                throw new IOException("Buffer overflow " + n2 + " " + n3);
            }
            if (this.h + n2 <= this.q) {
                System.arraycopy(arrby, n, this.j, this.h, n2);
            } else {
                int n4 = this.q - this.h;
                System.arraycopy(arrby, n, this.j, this.h, n4);
                System.arraycopy(arrby, n + n4, this.j, 0, n2 - n4);
            }
            this.h = (this.h + n2) % this.q;
            this.notifyAll();
        }
    }
}

