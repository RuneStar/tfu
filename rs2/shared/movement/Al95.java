/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import rs2.shared.movement.W94;

class Al95 {
    static final /* synthetic */ int[] g;

    static {
        g = new int[W94.values().length];
        try {
            Al95.g[W94.BOX.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Al95.g[W94.SPHERE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Al95.g[W94.CAPSULE_Y.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

