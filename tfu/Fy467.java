/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.constants.J204;

public enum Fy467 implements J204
{
    PREBLEND_MODULATE(0),
    PREBLEND_NORMAL(1),
    PREBLEND_FOGGED(2),
    PREBLEND_ADD(3),
    PREBLEND_SUBTRACT(4);
    
    private final int h;

    @Override
    public int getId() {
        return this.h;
    }

    private Fy467(int n2) {
        this.h = n2;
    }
}

