// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

public class F511
{
    private int d;
    private I512 g;
    
    public static void g(final F511 f511) {
        f511.g = I512.UNUSED;
        ++f511.d;
    }
    
    public F511() {
        this.g = I512.UNUSED;
        this.d = 0;
    }
    
    public static void q(final F511 f511) {
        f511.g = I512.ENDED;
    }
    
    public static boolean j(final F511 f511) {
        return f511.g.compareTo(I512.STARTED) >= 0;
    }
    
    public static int h(final F511 f511) {
        return f511.d;
    }
    
    public static boolean e(final F511 f511) {
        return f511.g.compareTo(I512.ENDED) >= 0;
    }
    
    public static void d(final F511 f511) {
        f511.g = I512.STARTED;
    }
}
