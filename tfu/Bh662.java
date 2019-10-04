// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class Bh662 implements Jj524
{
    private final String d;
    private final js5 g;
    
    @Override
    public Jb525 d() {
        return Jb525.JS5_FILE;
    }
    
    public Bh662(final js5 g, final String d) {
        this.g = g;
        this.d = d;
    }
    
    @Override
    public int g() {
        if (js5.aq(this.g, this.d)) {
            return 100;
        }
        return 0;
    }
}
