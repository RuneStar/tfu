/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.constants.J204;

public enum Go485 implements J204
{
    EOF(-1),
    NONE(-2),
    INPROGRESS(-3),
    IOERROR(-4),
    TIMEOUT(-5),
    OK(2),
    SERVERERROR(3),
    SERVERFULL(7),
    IP_BLOCKED1(9),
    OUTOFDATE(37);
    
    private final int r;

    private Go485(int n2) {
        this.r = n2;
    }

    @Override
    public int getId() {
        return this.r;
    }
}

