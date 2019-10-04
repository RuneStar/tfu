/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.D91;
import com.jagex.jnibindings.runetek6.J372;
import tfu.Hi86;
import tfu.Ia63;

public class Skeleton
implements D91 {
    public static final Ia63 d = new J372();
    public Hi86 g;
    private long q;

    private static final native int LoadFromIntermediate(long var0, byte[] var2, float var3);

    private static final native int GetBoneIndex(long var0, String var2);

    @Override
    public int g() {
        assert (this.q != 0L);
        return Skeleton.GetBoneCount(this.q);
    }

    public Skeleton(Hi86 hi86) {
        this(Skeleton.Create());
        this.g = hi86;
    }

    public static int q(Skeleton skeleton, byte[] arrby, float f) {
        return Skeleton.LoadFromIntermediate(skeleton.q, arrby, f);
    }

    public static void j(Skeleton skeleton) {
        Skeleton.Destroy(skeleton.q);
        skeleton.q = 0L;
    }

    @Override
    public void onAllRefsReleased() {
        Skeleton.j(this);
    }

    Skeleton(long l) {
        this.q = l;
    }

    static long e(Skeleton skeleton) {
        return skeleton.q;
    }

    private static final native void Destroy(long var0);

    private static final native int GetBoneCount(long var0);

    private static final native long Create();

    public Skeleton() {
        this(null);
    }

    @Override
    public int d(String string) {
        assert (this.q != 0L);
        return Skeleton.GetBoneIndex(this.q, string);
    }
}

