package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class IrradianceVolumes {
   public static final native void initiateIrradianceBake();

   public static final boolean g(js5 var0, String var1) {
      int var2 = var0.getgroupid("IrradianceVolumes");
      byte[][] var3 = new byte[1][];
      int var4 = var1.lastIndexOf(46);
      if (var4 >= 0) {
         var1 = var1.substring(0, var4);
      }

      int var5 = var0.getfileid(var2, var1);
      var3[0] = var0.getfile(var2, var5);
      return var3[0] != null ? loadFromFileInMemory(var3, var3[0].length) : false;
   }

   public static final native void destroyAllVolumes();

   public static final native boolean loadFromFileInMemory(byte[][] var0, int var1);
}
