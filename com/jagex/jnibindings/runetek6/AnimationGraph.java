/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.Skeleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;

public class AnimationGraph {
    private static final Logger logger = LoggerFactory.getLogger(AnimationGraph.class);
    private final Ao128 d = new Ao128("Instantiated here");
    private long q = AnimationGraph.Create();

    public static void d(AnimationGraph animationGraph, long l) {
        AnimationGraph.ConfigureSkinnedModel(animationGraph.q, l);
    }

    public static boolean g(AnimationGraph animationGraph, String string, Skeleton skeleton, long l, int n) {
        return AnimationGraph.ConfigureAndPopulate(animationGraph.q, Skeleton.e(skeleton), string, l, n);
    }

    private static final native int GetMoreEvents(long var0, int var2, long var3, int var5);

    public static int q(AnimationGraph animationGraph, float f, long l, int n) {
        return AnimationGraph.Update(animationGraph.q, f, l, n);
    }

    protected void finalize() {
        try {
            if (this.q != 0L) {
                logger.error("Native memory leak - " + this.getClass().getSimpleName() + " garbage-collected without destroy()!", this.d);
            }
        }
        catch (Throwable throwable) {
            logger.error("", throwable);
        }
    }

    public static int j(AnimationGraph animationGraph, int n, long l, int n2) {
        return AnimationGraph.GetMoreEvents(animationGraph.q, n, l, n2);
    }

    public static long h(AnimationGraph animationGraph) {
        return animationGraph.q;
    }

    private static final native long Create();

    public static void e(AnimationGraph animationGraph) {
        if (animationGraph.q != 0L) {
            AnimationGraph.Destroy(animationGraph.q);
            animationGraph.q = 0L;
        }
    }

    private static final native void Destroy(long var0);

    private static final native void ConfigureSkinnedModel(long var0, long var2);

    private static final native int Update(long var0, float var2, long var3, int var5);

    private static final native boolean ConfigureAndPopulate(long var0, long var2, String var4, long var5, int var7);
}

