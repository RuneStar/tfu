package com.jagex.game.runetek6.xelement;

import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

public class T101 implements Hp62 {
   public static final Ia63 d = new At100();
   private static final Logger logger = LoggerFactory.getLogger(T101.class);
   private static int t = 7;
   public final int b;
   public final float e;
   public final int h;
   public Av106 j;
   public final float l;
   public int p = 0;
   public String q;
   public String r;
   public final int s;
   public Ar110 u;
   public String v;
   public String w;
   public int x = 0;
   public String y;
   public final LinkedList z = new LinkedList();

   public T101(float var1, int var2, int var3, int var4, float var5, Av106 var6) {
      this.e = var1;
      this.s = var2;
      this.b = var3;
      this.h = var4;
      this.l = var5;
      this.j = var6;
   }

   public void onAllRefsReleased() {
   }

   public static T101 g(Gg3 var0) throws Id102 {
      int var1 = Gg3.ar(var0);
      if (var1 > t) {
         throw new Id102("Unsupported version " + var1);
      } else {
         float var2 = Gg3.bl(var0);
         int var3 = Gg3.bd(var0);
         int var4 = Gg3.bd(var0);
         Av106 var5 = Av106.FULL;
         if (var1 >= 7) {
            var5 = Av106.values()[Gg3.ar(var0)];
         }

         Gg3.bl(var0);
         float var6 = Gg3.bl(var0);
         int var7 = Gg3.bd(var0);
         T101 var8 = new T101(var2, var3, var4, 1, var6, var5);

         for(int var9 = 0; var9 < var7; ++var9) {
            int var10 = Gg3.bd(var0);
            int var11 = Gg3.bd(var0);
            int var12 = Gg3.bd(var0);
            int var13 = Gg3.bd(var0);
            int var14 = Gg3.bd(var0);
            boolean var15 = false;
            if (var1 >= 4) {
               var15 = Gg3.ax(var0) != 0;
            }

            var8.z.add(new As109(var10, var11, var12, var13, var14, var15));
         }

         if (var1 >= 2) {
            var8.q = var0.bh();
            if (var1 < 7) {
               if (var8.q.equals("main")) {
                  var8.j = Av106.UIONLY;
               } else {
                  var8.j = Av106.FULL;
               }
            }
         }

         if (var1 >= 3) {
            var8.p = Gg3.bd(var0);
            var8.x = Gg3.bd(var0);
         }

         if (var1 >= 5) {
            boolean var16 = Gg3.ar(var0) == 1;
            if (var16) {
               var8.u = Ar110.g(var0);
            }
         }

         if (var1 >= 6) {
            if (Gg3.ar(var0) == 1) {
               var8.w = var0.bh();
            }

            if (Gg3.ar(var0) == 1) {
               var8.r = var0.bh();
            }

            if (Gg3.ar(var0) == 1) {
               var8.v = var0.bh();
            }

            if (Gg3.ar(var0) == 1) {
               var8.y = var0.bh();
            }
         }

         return var8;
      }
   }
}
