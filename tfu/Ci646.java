// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Ci646 extends Cw634
{
    private float[] e;
    private Cg550 s;
    
    public Ci646(final int g, final float[] e, final int d, final int q, final boolean j) {
        super.g = g;
        this.e = e;
        super.d = d;
        super.q = q;
        super.j = j;
    }
    
    @Override
    public int g() {
        return this.e.length;
    }
    
    public Cm645 b(final int n, final int n2, final int n3) {
        if (this.e == null || this.e.length == 0) {
            return null;
        }
        return new Cm645(this, n, n2, n3);
    }
    
    public static float[] l(final Ci646 ci646) {
        return ci646.e;
    }
    
    public static boolean w(final Ci646 ci646) {
        if (ci646.s != null && !Cg550.r(ci646.s)) {
            ci646.s = null;
        }
        return ci646.s != null;
    }
    
    public Ci646(final int g, final Cg550 s, final float[] e, final int d, final int q, final boolean j) {
        super.g = g;
        this.s = s;
        this.e = e;
        super.d = d;
        super.q = q;
        super.j = j;
    }
    
    public static int r(final Ci646 ci646) {
        if (!w(ci646)) {
            return ci646.e.length - 1;
        }
        return Cg550.w(ci646.s);
    }
}
