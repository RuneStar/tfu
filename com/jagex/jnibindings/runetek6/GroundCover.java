/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.Js5NativeInterface;
import com.jagex.js5.js5;

public class GroundCover {
    public static final native void destroyEngine(long var0);

    public static final native void populateFromMediaPath(long var0);

    public static final native long createGrid();

    public static final native void destroyGrid(long var0, long var2);

    public static final native void setGridWorldOrigin(long var0, float var2, float var3, float var4);

    public static final native void populateMeshesFromMemory(long var0, byte[][] var2);

    public static final native void loadLayerInstancesFromMemory(long var0, long var2, String var4, String var5);

    public static final native long createEngine();

    public static final native void populateLayerTypesFromMemory(long var0, byte[][] var2);

    public static final native void updateGrid(long var0, float var2);

    public static final native void populateMaterialsFromMemory(long var0, byte[][] var2);

    public static final void g(long l, js5 js52) {
        byte[][] arrby = Js5NativeInterface.d(js52, "GroundCoverMaterials");
        byte[][] arrby2 = Js5NativeInterface.d(js52, "GroundCoverMeshes");
        byte[][] arrby3 = Js5NativeInterface.d(js52, "LayerTypes");
        if (arrby != null) {
            GroundCover.populateMaterialsFromMemory(l, arrby);
        }
        if (arrby2 != null) {
            GroundCover.populateMeshesFromMemory(l, arrby2);
        }
        if (arrby3 != null) {
            GroundCover.populateLayerTypesFromMemory(l, arrby3);
        }
    }
}

