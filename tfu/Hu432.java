// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.IOException;
import java.net.Socket;

class Hu432 extends Hx339
{
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
        catch (IOException ex) {}
        this.q.h();
    }
    
    @Override
    public boolean d(final int n) throws IOException {
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
    public void e(final byte[] array, final int n, final int n2) throws IOException {
        this.j.j(array, n, n2);
    }
    
    public Hu432(final Socket d, final int n) throws IOException {
        (this.d = d).setSoTimeout(30000);
        this.d.setTcpNoDelay(true);
        this.q = new Hy431(this.d.getInputStream(), n);
        this.j = new Ht433(this.d.getOutputStream(), n);
    }
    
    @Override
    public int j(final byte[] array, final int n, final int n2) throws IOException {
        return this.q.e(array, n, n2);
    }
    
    @Override
    protected void finalize() {
        this.h();
    }
}
