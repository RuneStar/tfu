package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.B45;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.maths.I48;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class P185 {
   private static final Logger logger = LoggerFactory.getLogger(P185.class);
   float b = 0.0F;
   private B45 d;
   public float e = 0.0F;
   private float h = 0.0F;
   public float j = 0.0F;
   float l = 0.0F;
   public I48 p = new I48(0.0F, 1.0F, 0.0F);
   private float q = 0.0F;
   float r = 1.0F;
   private boolean s;
   float v = 1.0F;
   float w = 1.0F;
   float y = 1.0F;

   public static float e(P185 var0) {
      return var0.q;
   }

   public static void g(P185 var0, B45 var1) {
      var0.d = var1;
      h(var0, 0.0F);
      var0.b = var1.az;
      var0.l = var1.ah;
      var0.w = 1.0F;
      var0.r = 1.0F;
      var0.v = 1.0F;
      var0.y = 1.0F;
   }

   public void d(BulletVehicle var1, float var2, float var3, float var4, float var5, float var6, boolean var7, C184 var8) {
      this.e = var4;
      if (this.d != null) {
         Vector3 var9 = new Vector3(0.0F, 0.0F, 1.0F);
         Quaternion var10 = var1.e.as().q();
         var9 = Vector3.al(var9, var10);
         float var11 = var2;
         float var12 = Vector3.o(var9, var1.e.l());
         if (var12 * var4 < -1.0F) {
            var11 = 0.0F;
         }

         float var13 = var4 > 0.0F ? this.b : this.l;
         boolean var14 = false;
         float var15;
         float var16;
         if (var14) {
            var16 = 0.5F * var13;
            if (var11 < var16) {
               var15 = this.d.ag / (var11 + 0.001F);
            } else {
               var15 = this.d.ag * (var13 - var11) / (var16 * var16);
            }
         } else {
            ArrayList var27 = var4 >= 0.0F ? this.d.ai : this.d.af;
            ArrayList var17 = var4 >= 0.0F ? this.d.al : this.d.av;
            if (var17.size() > 0) {
               float var18 = var4 > 0.0F ? this.w : this.v;
               float var19 = var4 > 0.0F ? this.r : this.y;
               float var20 = (double)var19 != 0.0D ? Math.abs(var12) / var19 : 1000000.0F;
               if (var12 * var4 < -1.0F) {
                  var20 = 0.0F;
               }

               int var21;
               for(var21 = var17.size() - 1; var21 >= 0 && (Float)var17.get(var21) > var20; --var21) {
               }

               float var22;
               if (var21 == var17.size() - 1) {
                  var22 = (Float)var27.get(var21);
               } else if (var21 == -1) {
                  var22 = (Float)var27.get(0) * var20 / (Float)var17.get(0);
               } else {
                  var22 = (Float)var27.get(var21) + ((Float)var27.get(var21 + 1) - (Float)var27.get(var21)) * (var20 - (Float)var17.get(var21)) / ((Float)var17.get(var21 + 1) - (Float)var17.get(var21));
               }

               var22 *= var18;
               var15 = var22 * var1.e.q / this.d.x;
               if (var11 > var13) {
                  var15 = 0.0F;
               }
            } else {
               var15 = 0.0F;
            }
         }

         if (var15 < 0.0F) {
            var15 = 0.0F;
         }

         var16 = var1.e.q * -DiscreteDynamicsWorld.af(var1.q).y * this.d.v * (this.d.aq / 4.0F);
         if (var15 > var16) {
            var15 = var16;
         }

         int var28 = 0;
         if (this.d.ap) {
            var28 += 2;
         }

         if (this.d.ao) {
            var28 += 2;
         }

         if (var28 == 0) {
            var15 = 0.0F;
         } else {
            var15 /= (float)var28 / 4.0F;
         }

         var15 *= var4;
         h(this, var15 * this.d.x);
         var11 = 0.0F;
         if (var2 > this.d.ax) {
            var11 = this.d.au;
         } else {
            var12 = var2 / this.d.ax;
            var11 = (1.0F - var12) * this.d.ar + var12 * this.d.au;
         }

         var12 = var11 * this.d.aj * var3;
         var11 *= var5;
         if (q(this) > var11) {
            j(this, q(this) - var12);
            if (q(this) < var11) {
               j(this, var11);
            }
         }

         if (q(this) < var11) {
            j(this, q(this) + var12);
            if (q(this) > var11) {
               j(this, var11);
            }
         }

         int var23;
         if (var6 > 0.0F) {
            var11 = 0.0F;
            var23 = 0;
            if (this.d.aa) {
               var11 += this.d.l;
               ++var23;
            }

            if (this.d.an) {
               var11 += this.d.v;
               ++var23;
            }

            if (var23 > 0) {
               var11 /= (float)var23;
               this.h = var6 * this.d.ak * var1.e.q * -DiscreteDynamicsWorld.af(var1.q).y * var11;
            } else {
               this.h = 0.0F;
            }
         } else {
            this.h = 0.0F;
         }

         this.s = var7;
         I48 var26 = I48.d();
         var23 = 0;

         for(int var24 = 0; var24 < BulletVehicle.g(var1); ++var24) {
            Vector3 var25 = var1.m(var24);
            if (Vector3.f(var25) > 0.01F) {
               I48.i(var26, var25.x, var25.y, var25.z);
               ++var23;
            }
         }

         if (var23 > 0) {
            if (I48.c(var26) > 0.0F) {
               I48.m(var26);
            }

            var13 = this.d.bc;
         } else {
            I48.p(var26, 0.0F, 1.0F, 0.0F);
            var13 = this.d.bz;
         }

         this.p.j = var26.j * var13 + this.p.j * (1.0F - var13);
         this.p.e = var26.e * var13 + this.p.e * (1.0F - var13);
         this.p.h = var26.h * var13 + this.p.h * (1.0F - var13);
         if (I48.c(this.p) > 0.0F) {
            I48.m(this.p);
         }

         I48.y(var26);
         var1.v(this.p);
         var11 = q(this);
         if (var8 != null) {
            var8.d("vehicle.control", e(this), this.h, this.s, var11);
         }

         var1.d(e(this), this.h, this.s, var11);
      }
   }

   public static float q(P185 var0) {
      return var0.j;
   }

   public static void h(P185 var0, float var1) {
      var0.q = var1;
   }

   public static void j(P185 var0, float var1) {
      var0.j = var1;
   }
}
