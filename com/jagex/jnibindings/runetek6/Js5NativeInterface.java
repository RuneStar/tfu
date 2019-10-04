package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;
import tfu.Be2;
import tfu.Lb33;

@Be2
public class Js5NativeInterface {
   public static boolean g() {
      Lb33.g(Lb33.InitNative);

      try {
         boolean var0 = InitNative(js5.class);
         Lb33.d(Lb33.InitNative);
         return var0;
      } finally {
         Lb33.d(Lb33.InitNative);
      }
   }

   public static native boolean RegisterAnimationGraphJs5(js5 var0);

   public static native boolean RegisterTextureJs5(js5 var0, boolean var1);

   public static native boolean RegisterScaleformJs5(js5 var0, js5 var1);

   public static native boolean RegisterAnimationJs5(js5 var0);

   public static native boolean RegisterLuaJs5(js5 var0, js5 var1);

   public static native boolean RegisterGroundCoverLayerInstanceJs5(js5 var0);

   public static native boolean BindToThread();

   private static native boolean InitNative(Class var0);

   public static final byte[][] d(js5 var0, String var1) {
      int var2 = var0.getgroupid(var1);
      if (var2 == -1) {
         System.err.println("Group " + var1 + " missing from js5");
         return (byte[][])null;
      } else {
         int[] var3 = js5.u(var0, var2);
         byte[][] var4 = new byte[var3.length][];

         for(int var5 = 0; var5 < var3.length; ++var5) {
            var4[var5] = var0.getfile(var2, var3[var5]);
         }

         return var4;
      }
   }

   public static native boolean RegisterShaderJs5(js5 var0);
}
