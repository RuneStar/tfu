// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import tfu.Hi86;
import tfu.Ia63;

public class Skeleton implements D91
{
    public static final Ia63 d;
    public Hi86 g;
    private long q;
    static final /* synthetic */ boolean j;
    
    private static final native int LoadFromIntermediate(final long p0, final byte[] p1, final float p2);
    
    private static final native int GetBoneIndex(final long p0, final String p1);
    
    @Override
    public int g() {
        if (!Skeleton.j && this.q == 0L) {
            throw new AssertionError();
        }
        return GetBoneCount(this.q);
    }
    
    public Skeleton(final Hi86 g) {
        this(Create());
        this.g = g;
    }
    
    public static int q(final Skeleton skeleton, final byte[] array, final float n) {
        return LoadFromIntermediate(skeleton.q, array, n);
    }
    
    public static void j(final Skeleton skeleton) {
        Destroy(skeleton.q);
        skeleton.q = 0L;
    }
    
    @Override
    public void onAllRefsReleased() {
        j(this);
    }
    
    Skeleton(final long q) {
        this.q = q;
    }
    
    static long e(final Skeleton skeleton) {
        return skeleton.q;
    }
    
    private static final native void Destroy(final long p0);
    
    private static final native int GetBoneCount(final long p0);
    
    private static final native long Create();
    
    static {
        j = !Skeleton.class.desiredAssertionStatus();
        d = new J372();
    }
    
    public Skeleton() {
        this(null);
    }
    
    @Override
    public int d(final String s) {
        if (!Skeleton.j && this.q == 0L) {
            throw new AssertionError();
        }
        return GetBoneIndex(this.q, s);
    }
}
