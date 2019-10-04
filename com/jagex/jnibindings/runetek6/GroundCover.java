package com.jagex.jnibindings.runetek6;

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

   public static final void g(long var0, js5 var2) {
      byte[][] var3 = Js5NativeInterface.d(var2, "GroundCoverMaterials");
      byte[][] var4 = Js5NativeInterface.d(var2, "GroundCoverMeshes");
      byte[][] var5 = Js5NativeInterface.d(var2, "LayerTypes");
      if (var3 != null) {
         populateMaterialsFromMemory(var0, var3);
      }

      if (var4 != null) {
         populateMeshesFromMemory(var0, var4);
      }

      if (var5 != null) {
         populateLayerTypesFromMemory(var0, var5);
      }

   }
}
