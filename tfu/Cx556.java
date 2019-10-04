// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public abstract class Cx556 extends Ln265
{
    Cx556 ae;
    int bd;
    public Cb633 bm;
    public volatile boolean w;
    
    protected abstract Cx556 g();
    
    public abstract void j(final int[] p0, final int p1, final int p2);
    
    protected abstract Cx556 d();
    
    public Cx556() {
        this.w = true;
    }
    
    public static final void ck(final Cx556 cx556, final int[] array, final int n, final int n2) {
        if (cx556.w) {
            cx556.j(array, n, n2);
        }
        else {
            cx556.e(n2);
        }
    }
    
    protected abstract int q();
    
    public abstract void e(final int p0);
    
    protected int cd() {
        return 255;
    }
}
