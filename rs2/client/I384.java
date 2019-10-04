/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.core.constants.J204;

public enum I384 implements J204
{
    ANY(0),
    _1024X768(1),
    _800X600(2);
    
    private final int j;

    private I384(int n2) {
        this.j = n2;
    }

    @Override
    public int getId() {
        return this.j;
    }
}

