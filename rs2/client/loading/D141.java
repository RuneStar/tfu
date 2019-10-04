/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.loading;

import com.jagex.game.runetek6.config.vartype.constants.BaseVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;

class D141 {
    static final /* synthetic */ int[] d;
    static final /* synthetic */ int[] g;

    static {
        d = new int[BaseVarType.values().length];
        try {
            D141.d[BaseVarType.INTEGER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            D141.d[BaseVarType.LONG.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            D141.d[BaseVarType.STRING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            D141.d[BaseVarType.VECTOR3.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        g = new int[VarDomainType.values().length];
        try {
            D141.g[VarDomainType.CLIENT.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            D141.g[VarDomainType.CLAN.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

