/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.Skeleton;

public class StaticModel {
    public static final native void destroy(long var0);

    public static final native long create(int var0);

    public static final native void getBoneWorldTransform(long var0, int var2, long var3);

    public static final native void show(long var0, long var2);

    public static final native void setIsStatic(long var0, boolean var2);

    public static final native void replaceMeshes(long var0, long var2, int var4, int var5);

    public static final void g(long l, Skeleton skeleton) {
        StaticModel.setSkeleton(l, Skeleton.e(skeleton));
    }

    public static final native void setSkeleton(long var0, long var2);

    public static final native void attachNodeToBone(long var0, long var2, int var4);

    public static final native void getBoneObjectTransform(long var0, int var2, long var3);

    public static final native void hide(long var0, long var2);

    public static final native float getAnimatedSgnScale(long var0);
}

