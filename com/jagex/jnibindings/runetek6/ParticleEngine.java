package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class ParticleEngine {
   public static final native void populateMaterialsFromMemory(byte[][] var0);

   public static final native long createSystem(String var0);

   public static final native void deleteSystem(long var0);

   public static final void g(js5 var0, String var1) {
      populateFromMemory(Js5NativeInterface.d(var0, var1));
   }

   public static final native void populateFromMediaPath();

   public static final native void populateFromMemory(byte[][] var0);

   public static final native void populateMeshesFromMemory(byte[][] var0);

   public static final native void reset(long var0);

   public static final native void setEnabled(long var0, boolean var2);

   public static final void d(js5 var0, String var1) {
      populateMeshesFromMemory(Js5NativeInterface.d(var0, var1));
   }

   public static final void q(js5 var0, String var1) {
      populateMaterialsFromMemory(Js5NativeInterface.d(var0, var1));
   }
}
