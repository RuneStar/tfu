// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

public class StaticModel
{
    public static final native void destroy(final long p0);
    
    public static final native long create(final int p0);
    
    public static final native void getBoneWorldTransform(final long p0, final int p1, final long p2);
    
    public static final native void show(final long p0, final long p1);
    
    public static final native void setIsStatic(final long p0, final boolean p1);
    
    public static final native void replaceMeshes(final long p0, final long p1, final int p2, final int p3);
    
    public static final void g(final long n, final Skeleton skeleton) {
        setSkeleton(n, Skeleton.e(skeleton));
    }
    
    public static final native void setSkeleton(final long p0, final long p1);
    
    public static final native void attachNodeToBone(final long p0, final long p1, final int p2);
    
    public static final native void getBoneObjectTransform(final long p0, final int p1, final long p2);
    
    public static final native void hide(final long p0, final long p1);
    
    public static final native float getAnimatedSgnScale(final long p0);
}
