// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class Gv486 implements Ip424
{
    private final js5 g;
    
    public Gv486(final js5 g) {
        this.g = g;
        if (!js5.i(this.g)) {
            throw new IllegalArgumentException();
        }
    }
    
    public static int g(final Gv486 gv486, final String s) {
        return gv486.g.getgroupid(s);
    }
}
