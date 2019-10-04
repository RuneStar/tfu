/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

public class Terrain {
    public static final native long create();

    public static final native void destroy(long var0);

    public static final native void loadFromXMLString(long var0, String var2);

    public static final native void setWorldPosition(long var0, float var2, float var3, float var4);

    public static final native void loadHeightmapIfNotLoadedYet(long var0);
}

