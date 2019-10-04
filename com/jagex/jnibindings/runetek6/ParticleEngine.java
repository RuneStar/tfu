/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.Js5NativeInterface;
import com.jagex.js5.js5;

public class ParticleEngine {
    public static final native void populateMaterialsFromMemory(byte[][] var0);

    public static final native long createSystem(String var0);

    public static final native void deleteSystem(long var0);

    public static final void g(js5 js52, String string) {
        ParticleEngine.populateFromMemory(Js5NativeInterface.d(js52, string));
    }

    public static final native void populateFromMediaPath();

    public static final native void populateFromMemory(byte[][] var0);

    public static final native void populateMeshesFromMemory(byte[][] var0);

    public static final native void reset(long var0);

    public static final native void setEnabled(long var0, boolean var2);

    public static final void d(js5 js52, String string) {
        ParticleEngine.populateMeshesFromMemory(Js5NativeInterface.d(js52, string));
    }

    public static final void q(js5 js52, String string) {
        ParticleEngine.populateMaterialsFromMemory(Js5NativeInterface.d(js52, string));
    }
}

