/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.constants.J204;

public enum Ig436 implements J204
{
    OPAQUE(0),
    ALPHA_TESTED(1),
    ALPHA_BLENDED(2);
    
    private final int j;

    private Ig436(int n2) {
        this.j = n2;
    }

    @Override
    public int getId() {
        return this.j;
    }
}

