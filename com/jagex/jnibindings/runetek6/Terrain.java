// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

public class Terrain
{
    public static final native long create();
    
    public static final native void destroy(final long p0);
    
    public static final native void loadFromXMLString(final long p0, final String p1);
    
    public static final native void setWorldPosition(final long p0, final float p1, final float p2, final float p3);
    
    public static final native void loadHeightmapIfNotLoadedYet(final long p0);
}
