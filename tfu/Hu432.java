/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import tfu.Ht433;
import tfu.Hx339;
import tfu.Hy431;

class Hu432
extends Hx339 {
    private static final boolean g = true;
    private Socket d;
    private Ht433 j;
    private Hy431 q;

    @Override
    public void h() {
        Ht433.e(this.j);
        try {
            this.d.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this.q.h();
    }

    @Override
    public boolean d(int n) throws IOException {
        return this.q.q(n);
    }

    @Override
    public void s() {
        this.q.s();
        this.j.h();
    }

    @Override
    public int q() throws IOException {
        return this.q.j();
    }

    @Override
    public void e(byte[] arrby, int n, int n2) throws IOException {
        this.j.j(arrby, n, n2);
    }

    public Hu432(Socket socket, int n) throws IOException {
        this.d = socket;
        this.d.setSoTimeout(30000);
        this.d.setTcpNoDelay(true);
        this.q = new Hy431(this.d.getInputStream(), n);
        this.j = new Ht433(this.d.getOutputStream(), n);
    }

    @Override
    public int j(byte[] arrby, int n, int n2) throws IOException {
        return this.q.e(arrby, n, n2);
    }

    protected void finalize() {
        this.h();
    }
}

