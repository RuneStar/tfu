// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import org.slf4j.LoggerFactory;
import tfu.Ao128;
import org.slf4j.Logger;

public class AnimationGraph
{
    private static final Logger logger;
    private final Ao128 d;
    private long q;
    
    public static void d(final AnimationGraph animationGraph, final long n) {
        ConfigureSkinnedModel(animationGraph.q, n);
    }
    
    public static boolean g(final AnimationGraph animationGraph, final String s, final Skeleton skeleton, final long n, final int n2) {
        return ConfigureAndPopulate(animationGraph.q, Skeleton.e(skeleton), s, n, n2);
    }
    
    private static final native int GetMoreEvents(final long p0, final int p1, final long p2, final int p3);
    
    public static int q(final AnimationGraph animationGraph, final float n, final long n2, final int n3) {
        return Update(animationGraph.q, n, n2, n3);
    }
    
    @Override
    protected void finalize() {
        try {
            if (this.q != 0L) {
                AnimationGraph.logger.error("Native memory leak - " + this.getClass().getSimpleName() + " garbage-collected without destroy()!", this.d);
            }
        }
        catch (Throwable t) {
            AnimationGraph.logger.error("", t);
        }
    }
    
    public static int j(final AnimationGraph animationGraph, final int n, final long n2, final int n3) {
        return GetMoreEvents(animationGraph.q, n, n2, n3);
    }
    
    public static long h(final AnimationGraph animationGraph) {
        return animationGraph.q;
    }
    
    private static final native long Create();
    
    public static void e(final AnimationGraph animationGraph) {
        if (animationGraph.q != 0L) {
            Destroy(animationGraph.q);
            animationGraph.q = 0L;
        }
    }
    
    private static final native void Destroy(final long p0);
    
    private static final native void ConfigureSkinnedModel(final long p0, final long p1);
    
    private static final native int Update(final long p0, final float p1, final long p2, final int p3);
    
    private static final native boolean ConfigureAndPopulate(final long p0, final long p1, final String p2, final long p3, final int p4);
    
    static {
        logger = LoggerFactory.getLogger(AnimationGraph.class);
    }
    
    public AnimationGraph() {
        this.d = new Ao128("Instantiated here");
        this.q = Create();
    }
}
