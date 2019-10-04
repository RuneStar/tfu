// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class Bj661 implements Jj524
{
    private final String d;
    private final js5 g;
    
    @Override
    public Jb525 d() {
        return Jb525.JS5_GROUP;
    }
    
    public Bj661(final js5 g, final String d) {
        this.g = g;
        this.d = d;
    }
    
    @Override
    public int g() {
        if (js5.ai(this.g, this.d)) {
            return 100;
        }
        return js5.al(this.g, this.d);
    }
}
