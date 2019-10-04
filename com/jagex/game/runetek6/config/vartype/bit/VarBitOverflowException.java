// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.bit;

public final class VarBitOverflowException extends Exception
{
    public VarBitOverflowException(final int i, final int j, final int k) {
        super("Varbit oveflow on varbit " + i + " Value " + j + " is outside the range 0-" + k);
    }
    
    public VarBitOverflowException(final String str, final int i, final int j) {
        super("Varbit oveflow on varbit '" + str + "' Value " + i + " is outside the range 0-" + j);
    }
}
