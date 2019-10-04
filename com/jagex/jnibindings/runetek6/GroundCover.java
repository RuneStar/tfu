// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class GroundCover
{
    public static final native void destroyEngine(final long p0);
    
    public static final native void populateFromMediaPath(final long p0);
    
    public static final native long createGrid();
    
    public static final native void destroyGrid(final long p0, final long p1);
    
    public static final native void setGridWorldOrigin(final long p0, final float p1, final float p2, final float p3);
    
    public static final native void populateMeshesFromMemory(final long p0, final byte[][] p1);
    
    public static final native void loadLayerInstancesFromMemory(final long p0, final long p1, final String p2, final String p3);
    
    public static final native long createEngine();
    
    public static final native void populateLayerTypesFromMemory(final long p0, final byte[][] p1);
    
    public static final native void updateGrid(final long p0, final float p1);
    
    public static final native void populateMaterialsFromMemory(final long p0, final byte[][] p1);
    
    public static final void g(final long n, final js5 js5) {
        final byte[][] d = Js5NativeInterface.d(js5, "GroundCoverMaterials");
        final byte[][] d2 = Js5NativeInterface.d(js5, "GroundCoverMeshes");
        final byte[][] d3 = Js5NativeInterface.d(js5, "LayerTypes");
        if (d != null) {
            populateMaterialsFromMemory(n, d);
        }
        if (d2 != null) {
            populateMeshesFromMemory(n, d2);
        }
        if (d3 != null) {
            populateLayerTypesFromMemory(n, d3);
        }
    }
}
