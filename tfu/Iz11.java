package tfu;

import com.jagex.maths.Matrix4;
import com.jagex.maths.O166;
import com.jagex.maths.Q10;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Z165;
import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iz11 implements Hp62 {
   public static final int d = 4;
   public static final Ia63 e = new Ih437();
   private static final Logger logger = LoggerFactory.getLogger(Iz11.class);
   public final RotTrans[] j;
   public final It12[] q;

   public static Iz11 g(Gg3 var0, Hi86 var1, boolean var2, boolean var3, boolean var4) {
      // $FF: Couldn't be decompiled
   }

   public static Iz11 d(Q10 var0) {
      It12[] var1 = new It12[1];
      RotTrans[] var2 = new RotTrans[1];
      Z165 var3 = new Z165();
      Matrix4 var4 = var0.g;
      double var5 = Math.sqrt((double)(var4.f00 * var4.f00 + var4.f01 * var4.f01 + var4.f02 * var4.f02));
      double var7 = Math.sqrt((double)(var4.f10 * var4.f10 + var4.f11 * var4.f11 + var4.f12 * var4.f12));
      double var9 = Math.sqrt((double)(var4.f20 * var4.f20 + var4.f21 * var4.f21 + var4.f22 * var4.f22));
      float var11 = 0.05F;
      if (var5 < 0.05000000074505806D) {
         var5 = 0.05000000074505806D;
      }

      if (var7 < 0.05000000074505806D) {
         var7 = 0.05000000074505806D;
      }

      if (var9 < 0.05000000074505806D) {
         var9 = 0.05000000074505806D;
      }

      var1[0] = new Kx22((float)var5, (float)var7, (float)var9, "");
      var3.d.j = var4.f30;
      var3.d.e = var4.f31;
      var3.d.h = var4.f32;
      float var12 = (float)((double)var4.f00 / var5);
      float var13 = (float)((double)var4.f01 / var5);
      float var14 = (float)((double)var4.f02 / var5);
      float var15 = (float)((double)var4.f10 / var7);
      float var16 = (float)((double)var4.f11 / var7);
      float var17 = (float)((double)var4.f12 / var7);
      float var18 = (float)((double)var4.f20 / var9);
      float var19 = (float)((double)var4.f21 / var9);
      float var20 = (float)((double)var4.f22 / var9);
      O166 var21 = var3.g;
      double var22 = (double)(1.0F + var12 + var16 + var20);
      float var24;
      if (var22 > 1.0E-8D) {
         var24 = (float)(Math.sqrt(var22) * 2.0D);
         var21.j = (var19 - var17) / var24;
         var21.e = (var14 - var18) / var24;
         var21.h = (var15 - var13) / var24;
         var21.s = 0.25F * var24;
      } else if (var12 > var16 && var12 > var20) {
         var24 = (float)(Math.sqrt((double)(1.0F + var12 - var16 - var20)) * 2.0D);
         var21.j = 0.25F * var24;
         var21.e = (var15 + var13) / var24;
         var21.h = (var14 + var18) / var24;
         var21.s = (var19 - var17) / var24;
      } else if (var16 > var20) {
         var24 = (float)(Math.sqrt((double)(1.0F + var16 - var12 - var20)) * 2.0D);
         var21.j = (var15 + var13) / var24;
         var21.e = 0.25F * var24;
         var21.h = (var19 + var17) / var24;
         var21.s = (var14 - var18) / var24;
      } else {
         var24 = (float)(Math.sqrt((double)(1.0F + var20 - var12 - var16)) * 2.0D);
         var21.j = (var14 + var18) / var24;
         var21.e = (var19 + var17) / var24;
         var21.h = 0.25F * var24;
         var21.s = (var15 - var13) / var24;
      }

      O166.x(var21);
      var2[0] = var3.b();
      return new Iz11(var1, var2);
   }

   public void onAllRefsReleased() {
   }

   public Iz11(It12[] var1, RotTrans[] var2) {
      this.q = var1;
      this.j = var2;
   }
}
