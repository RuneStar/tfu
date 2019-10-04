// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.constants.J204;

public enum Ig436 implements J204
{
    ALPHA_TESTED("ALPHA_TESTED", 1, 1), 
    OPAQUE("OPAQUE", 0, 0), 
    ALPHA_BLENDED("ALPHA_BLENDED", 2, 2);
    
    private final int j;
    
    private Ig436(final String name, final int ordinal, final int j) {
        this.j = j;
    }
    
    @Override
    public int getId() {
        return this.j;
    }
}
