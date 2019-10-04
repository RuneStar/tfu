/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import java.awt.Canvas;

public final class Graphics {
    public static native void addBaseShaderPath(String var0);

    public static native void addBaseMediaPath(String var0);

    public static native void purge();

    public static final native void runPreRenderScripts(long var0, float var2);

    public static native int initFromCanvas(Canvas var0, int var1, int var2, int var3, int var4, int var5, int var6);

    public static final native void runPreGameplayScripts(long var0, float var2);

    public static final native void processFrame(long var0, int var2, float var3, int var4);

    public static native int resetFromCanvas(Canvas var0, int var1, int var2, int var3, int var4, int var5, int var6);

    public static final native long getDefaultCamera();

    public static final native long createTexture2D(int var0, int var1, int var2, int var3, int var4, long var5, int var7);

    public static final native void setEnvSettings(long var0, long var2);
}

