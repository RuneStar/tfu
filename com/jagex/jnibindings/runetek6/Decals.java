/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.Js5NativeInterface;
import com.jagex.js5.js5;

public class Decals {
    public static final void g(js5 js52, String string) {
        Decals.populateTemplatesFromMemory(Js5NativeInterface.d(js52, string));
    }

    public static final native void freeVehicleTyreTrackDecalSlot(int var0);

    public static final native void populateFromMediaPath();

    public static final native void populateTemplatesFromMemory(byte[][] var0);

    public static final native void populateMaterialsFromMemory(byte[][] var0);

    public static final native int allocVehicleTyreTrackDecalSlot(String var0);

    public static final void d(js5 js52, String string) {
        Decals.populateMaterialsFromMemory(Js5NativeInterface.d(js52, string));
    }
}

