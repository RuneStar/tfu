// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import tfu.Gz143;

class X513
{
    private static final long g;
    private String d;
    private long j;
    private long q;
    
    static void d(final X513 x513) {
        x513.q = g(x513);
    }
    
    static long b(final X513 x513) {
        long n;
        if (j(x513)) {
            n = x513.j - x513.q;
        }
        else {
            n = g(x513) - x513.q;
        }
        return n;
    }
    
    static boolean j(final X513 x513) {
        return x513.j > 0L;
    }
    
    static void e(final X513 x513, final String d) {
        x513.d = d;
    }
    
    String h() {
        return (j(this) ? "ended,  " : "in progress,  ") + this.d;
    }
    
    static long s(final X513 x513) {
        return x513.q - X513.g;
    }
    
    static {
        g = Gz143.g();
    }
    
    static long g(final X513 x513) {
        return Gz143.g();
    }
    
    X513() {
        this.d = "";
        this.q = 0L;
        this.j = 0L;
    }
    
    static void q(final X513 x513) {
        x513.j = g(x513);
    }
}
