package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class Decals {
   public static final void g(js5 var0, String var1) {
      populateTemplatesFromMemory(Js5NativeInterface.d(var0, var1));
   }

   public static final native void freeVehicleTyreTrackDecalSlot(int var0);

   public static final native void populateFromMediaPath();

   public static final native void populateTemplatesFromMemory(byte[][] var0);

   public static final native void populateMaterialsFromMemory(byte[][] var0);

   public static final native int allocVehicleTyreTrackDecalSlot(String var0);

   public static final void d(js5 var0, String var1) {
      populateMaterialsFromMemory(Js5NativeInterface.d(var0, var1));
   }
}
