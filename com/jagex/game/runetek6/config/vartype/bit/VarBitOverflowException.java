/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.bit;

public final class VarBitOverflowException
extends Exception {
    public VarBitOverflowException(int n, int n2, int n3) {
        super("Varbit oveflow on varbit " + n + " Value " + n2 + " is outside the range 0-" + n3);
    }

    public VarBitOverflowException(String string, int n, int n2) {
        super("Varbit oveflow on varbit '" + string + "' Value " + n + " is outside the range 0-" + n2);
    }
}

