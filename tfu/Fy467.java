// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.constants.J204;

public enum Fy467 implements J204
{
    PREBLEND_NORMAL("PREBLEND_NORMAL", 1, 1), 
    PREBLEND_SUBTRACT("PREBLEND_SUBTRACT", 4, 4), 
    PREBLEND_MODULATE("PREBLEND_MODULATE", 0, 0), 
    PREBLEND_ADD("PREBLEND_ADD", 3, 3), 
    PREBLEND_FOGGED("PREBLEND_FOGGED", 2, 2);
    
    private final int h;
    
    @Override
    public int getId() {
        return this.h;
    }
    
    private Fy467(final String name, final int ordinal, final int h) {
        this.h = h;
    }
}
