// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import rs2.client.client;

public class Bx652 implements Jj524
{
    private boolean d;
    private final String g;
    
    @Override
    public int g() {
        if (this.d) {
            return 100;
        }
        final int d = client.el.d(this.g);
        if (d >= 0 && d <= 100) {
            return d;
        }
        this.d = true;
        return 100;
    }
    
    public static boolean w(final Bx652 bx652) {
        return bx652.d;
    }
    
    @Override
    public Jb525 d() {
        return Jb525.NATIVE_LIBRARY;
    }
    
    public Bx652(final String g) {
        this.g = g;
    }
}
