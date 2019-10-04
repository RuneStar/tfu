// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.constants.Language;

public abstract class Ff259 implements Fe459
{
    public final Language d;
    public final Gd27 g;
    protected int q;
    
    @Override
    public int length() {
        return this.q;
    }
    
    protected Ff259(final Gd27 g, final Language d, final int q) {
        this.g = g;
        this.d = d;
        this.q = q;
    }
}
