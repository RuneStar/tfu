/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.G211;

public class NativeResourceLoader {
    private static Thread g;

    private static native void InitNative();

    public static void g() {
        NativeResourceLoader.InitNative();
        g = new Thread(new G211());
        g.setName("Native Data Acquisition Thread");
        g.start();
    }

    public static void d() {
        NativeResourceLoader.PurgeNative();
        try {
            g.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public static native void ComandeerThreadForDataAcquisition();

    private static native void PurgeNative();
}

