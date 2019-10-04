package rs2.client;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ea395;
import tfu.El328;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Gx298;
import tfu.Hx339;
import tfu.Ic327;

public class N272 {
   public static final int g = 15000;
   private static final Logger logger = LoggerFactory.getLogger(N272.class);
   public Gs329 b = new Gs329(15000);
   public int e = 0;
   public Gg3 h = new Gg3(1350);
   public Ea395 i;
   public Gx298 j = new Gx298();
   public Ea395 k;
   public Ic327 l;
   public int m;
   public Ea395 n;
   public boolean o = false;
   public float p = 0.0F;
   public Hx339 q;
   public Ea395 r = null;
   public Ic327 s;
   public int t;
   public int u;
   public int v = 0;
   public Ic327 w;
   private long x = 0L;
   public boolean y = true;
   public int z;

   public static final void d(N272 var0, long var1) {
      var0.x = var1;
   }

   public static final void q(N272 var0) {
      Gx298.z(var0.j);
      var0.e = 0;
   }

   public final void j() throws IOException {
      if (this.q != null && this.e > 0) {
         this.h.v = 0;

         while(true) {
            El328 var1 = (El328)Gx298.i(this.j);
            if (var1 == null) {
               break;
            }

            if (var1.j > this.h.r.length) {
               logger.error("Dropping client -> server message of type " + var1.g + " and size " + var1.j + " as it too long for buffer!");
               El328.ef(var1);
               Gs329.n(var1.q);
               El328.j(var1);
            } else {
               if (var1.j > this.h.r.length - this.h.v) {
                  break;
               }

               Gg3.aa(this.h, var1.q.r, 0, var1.j);
               this.e -= var1.j;
               El328.ef(var1);
               Gs329.n(var1.q);
               El328.j(var1);
            }
         }

         this.q.e(this.h.r, 0, this.h.v);
         this.u += this.h.v;
         this.x = 0L;
      }

   }

   public static final long g(N272 var0) {
      if (var0.x == 0L) {
         var0.x = System.currentTimeMillis();
      }

      return var0.x;
   }

   public static void s(N272 var0) {
      if (var0.q != null) {
         var0.q.h();
         var0.q = null;
         var0.p = 0.0F;
      }

   }

   public static void h(N272 var0) {
      if (client.bj % 50 == 0) {
         var0.t = var0.u;
         var0.u = 0;
         var0.m = var0.z;
         var0.z = 0;
      }

   }

   public static final void e(N272 var0, El328 var1) {
      Gx298.t(var0.j, var1);
      var1.j = var1.q.v;
      var1.q.v = 0;
      var0.e += var1.j;
   }
}
