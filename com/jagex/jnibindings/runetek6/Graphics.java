// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import java.awt.Canvas;

public final class Graphics
{
    public static native void addBaseShaderPath(final String p0);
    
    public static native void addBaseMediaPath(final String p0);
    
    public static native void purge();
    
    public static final native void runPreRenderScripts(final long p0, final float p1);
    
    public static native int initFromCanvas(final Canvas p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6);
    
    public static final native void runPreGameplayScripts(final long p0, final float p1);
    
    public static final native void processFrame(final long p0, final int p1, final float p2, final int p3);
    
    public static native int resetFromCanvas(final Canvas p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6);
    
    public static final native long getDefaultCamera();
    
    public static final native long createTexture2D(final int p0, final int p1, final int p2, final int p3, final int p4, final long p5, final int p6);
    
    public static final native void setEnvSettings(final long p0, final long p1);
}
