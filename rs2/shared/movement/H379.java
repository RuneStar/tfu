/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import rs2.shared.movement.J93;

class H379 {
    static final /* synthetic */ int[] g;

    static {
        g = new int[J93.values().length];
        try {
            H379.g[J93.BODY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            H379.g[J93.CHARACTERCONTROLLER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            H379.g[J93.VEHICLE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

