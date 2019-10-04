// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public abstract class Lv148
{
    private static Lv148 g;
    
    public static void d(final boolean b) {
        if (Lv148.g != null) {
            Lv148.g.h(b);
        }
    }
    
    public static Lm295 q(final String s) {
        return (Lv148.g != null) ? Lv148.g.s(s) : null;
    }
    
    public abstract Lm295 s(final String p0);
    
    protected abstract void h(final boolean p0);
    
    public static La499 j(final String s) {
        return (Lv148.g != null) ? Lv148.g.b(s) : null;
    }
    
    public abstract La499 b(final String p0);
    
    protected abstract void e(final boolean p0);
    
    public static void g(final boolean b) {
        if (Lv148.g != null) {
            Lv148.g.e(b);
        }
    }
}
