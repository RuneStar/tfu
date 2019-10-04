package rs2.client.sound;

import com.jagex.maths.Vector3;
import fmod.D564;
import fmod.E245;
import fmod.X243;
import java.util.ArrayList;
import java.util.Iterator;
import rs2.client.ScriptCamera;

public class F594 {
   public static final int d = 1;
   public static final int g = 0;
   private static final ArrayList m = new ArrayList();
   private static final ArrayList t = new ArrayList();
   private static float u = 0.0F;
   private static int x = 0;
   private static float z = 1.0F;
   public D564 b;
   public String e;
   public String h = "";
   public String j;
   public float l = 1.0F;
   public boolean p = false;
   public Vector3 q;
   public float r = 500.0F;
   public X243 s;
   public float v = 1000.0F;
   public int w;
   public boolean y = false;

   // $FF: synthetic method
   static float b(float var0) {
      z = var0;
      return var0;
   }

   public static synchronized ArrayList g() {
      return t;
   }

   public static void d(F594 var0) {
      t.add(var0);
   }

   public static void j() {
      u += (z - u) * 0.01F;
      if (SoundManager.c != null) {
         if (t.size() == 0) {
            return;
         }

         if (x >= t.size()) {
            x = 0;
         }

         F594 var0 = (F594)t.get(x);
         if (var0.w == 0) {
            ScriptCamera var1 = ScriptCamera.getActiveCamera();
            if (var1 != null) {
               float var2 = Vector3.f(Vector3.k(var0.q, var1.getWorldTransform().trans));
               if (var0.s == null) {
                  if (var2 <= var0.v) {
                     X243 var3 = SoundManager.c.r(var0.j, 4);
                     if (X243.h(var3)) {
                        X243.t(var3, var0.r, var0.v);
                        X243.av(var3, 16, 2097152);
                        X243.i(var3, var0.l * u);
                        var3.z(var0.q.x, var0.q.y, var0.q.z);
                        var0.p = X243.al(var3, 14) == 16;
                        var0.s = E245.v(SoundManager.c, var0.j);
                        if (X243.h(var0.s)) {
                           var0.s.a();
                        } else {
                           var0.s = null;
                        }
                     }
                  }
               } else if (var2 > var0.v) {
                  X243.c(var0.s);
                  var0.s = null;
               }

               if (var0.s != null && X243.y(var0.s) && !var0.p) {
                  float var4;
                  if (var2 >= var0.v) {
                     var4 = 0.0F;
                  } else if (var2 <= var0.r) {
                     var4 = 1.0F;
                  } else {
                     var2 = (var2 - var0.r) / (var0.v - var0.r);
                     var4 = 1.0F - var2;
                  }

                  X243.i(var0.s, var4 * u);
                  var0.s.ag("space", var2);
               }
            }
         }

         ++x;
      }

   }

   public static void e() {
      q();
   }

   public static void h(String var0) {
      Af685 var1 = new Af685();
      G593.g(var0 + ".dat", 100000L, false, var1, (Object)null);
   }

   // $FF: synthetic method
   static float s(float var0) {
      u = var0;
      return var0;
   }

   public static void q() {
      Iterator var0 = t.iterator();

      while(var0.hasNext()) {
         F594 var1 = (F594)var0.next();
         if (var1.s != null) {
            X243.c(var1.s);
         }
      }

      t.clear();
      var0 = m.iterator();

      while(var0.hasNext()) {
         D564 var2 = (D564)var0.next();
         D564.q(var2, false);
         D564.d(var2);
      }

      m.clear();
   }

   // $FF: synthetic method
   static ArrayList l() {
      return m;
   }

   public F594(Vector3 var1, String var2) {
      this.q = var1;
      this.j = var2;
      String[] var3 = var2.split("/");
      if (var3.length > 0) {
         this.e = var3[var3.length - 1];
      }

   }
}
