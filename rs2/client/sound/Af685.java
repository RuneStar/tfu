package rs2.client.sound;

import com.jagex.maths.Vector3;
import fmod.D564;
import fmod.Q244;
import tfu.Gg3;

final class Af685 implements Z674 {
   public void g(String var1, Object var2) {
   }

   public void q() {
      F594.q();
   }

   public void d(byte[] var1, Object var2) {
      Gg3 var3 = new Gg3(var1);
      int var4 = Gg3.au(var3);
      F594.q();
      F594.s(F594.b(0.0F));

      int var5;
      int var6;
      float var11;
      float var12;
      float var13;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = Gg3.ar(var3);
         byte var7 = (byte)Gg3.ar(var3);
         char[] var8 = new char[var7];

         for(int var9 = 0; var9 < var7; ++var9) {
            var8[var9] = (char)Gg3.ar(var3);
         }

         String var18 = String.valueOf(var8);
         var7 = (byte)Gg3.ar(var3);
         var8 = new char[var7];

         for(int var10 = 0; var10 < var7; ++var10) {
            var8[var10] = (char)Gg3.ar(var3);
         }

         String var20 = String.valueOf(var8);
         var11 = (float)Gg3.bd(var3) / 100.0F;
         var12 = (float)Gg3.bd(var3) / 100.0F;
         var13 = (float)Gg3.bd(var3) / 100.0F;
         F594 var14 = new F594(new Vector3(var11, var12, var13), var18);
         var14.h = var20;
         var14.r = (float)Gg3.bd(var3);
         var14.v = (float)Gg3.bd(var3);
         var14.w = var6;
         var14.p = true;
         var14.l = (float)Gg3.ar(var3);
         var14.l /= 100.0F;
         F594.d(var14);
      }

      if (var3.v < var3.r.length) {
         var5 = Gg3.au(var3);

         for(var6 = 0; var6 < var5; ++var6) {
            String var16 = Gg3.bk(var3);
            String var17 = Gg3.bk(var3);
            String[] var19 = var16.split(",");
            float var21 = Float.parseFloat(var19[1]);
            var11 = Float.parseFloat(var19[2]);
            var12 = Float.parseFloat(var19[3]);
            var13 = Float.parseFloat(var19[4]);
            float var22 = Float.parseFloat(var19[5]);
            D564 var15 = SoundManager.c.z(var17);
            if (D564.g(var15)) {
               D564.j(var15, new Q244(var21, var11, var12), var13, var22);
               D564.q(var15, true);
               F594.l().add(var15);
            }
         }
      }

      F594.b(1.0F);
   }
}
