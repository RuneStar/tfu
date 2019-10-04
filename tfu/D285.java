package tfu;

import com.jagex.game.runetek6.xelement.As109;
import com.jagex.game.runetek6.xelement.Av106;
import com.jagex.game.runetek6.xelement.Bh77;
import com.jagex.game.runetek6.xelement.T101;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;

public class D285 {
   private static final Logger logger = LoggerFactory.getLogger(D285.class);
   public final Bt286 b;
   private final int d;
   final int e;
   final float h;
   final int j;
   private final List l = new LinkedList();
   private final int q;
   private List r;
   private T101 s;
   private Bn279 w;

   public boolean g() {
      try {
         if (this.s == null) {
            if (this.w == null) {
               this.w = client.lh.e(T101.class, this.q, 0, (Bv351)null, (Object)null);
            }

            if (!Bn279.g(this.w)) {
               return false;
            }

            this.s = (T101)this.w.d();
         }

         if (this.r == null) {
            float var1 = (float)this.j + this.h;
            float var2 = (float)this.e + this.h;
            HashSet var3 = new HashSet();
            Iterator var4 = this.s.z.iterator();

            while(var4.hasNext()) {
               As109 var5 = (As109)var4.next();
               float var6 = (float)var5.g * this.s.e - (float)this.j;
               float var7 = (float)var5.d * this.s.e - (float)this.e;
               this.l.add(new G289((Integer)var5.e, var6, var7));
               if (!var3.contains(var5.e)) {
                  var3.add(var5.e);
               }
            }

            this.r = new LinkedList();
            var4 = var3.iterator();

            while(var4.hasNext()) {
               int var13 = (Integer)var4.next();
               Bn279 var15 = client.lh.e(Bh77.class, var13, 0, (Bv351)null, var13);
               this.r.add(var15);
            }
         }

         if (!this.r.isEmpty()) {
            Iterator var9 = this.r.iterator();

            while(true) {
               Bn279 var10;
               do {
                  if (!var9.hasNext()) {
                     if (!this.r.isEmpty()) {
                        return false;
                     }

                     return true;
                  }

                  var10 = (Bn279)var9.next();
               } while(!Bn279.g(var10));

               int var11 = (Integer)var10.j;
               Bh77 var12 = (Bh77)var10.d();
               Iterator var14 = this.l.iterator();

               while(var14.hasNext()) {
                  G289 var16 = (G289)var14.next();
                  if (var16.g == var11) {
                     var16.j = var12;
                  }
               }

               var9.remove();
            }
         }
      } catch (ExecutionException var8) {
         logger.error("", var8);
      }

      return true;
   }

   public static List q(D285 var0) {
      return var0.l;
   }

   public D285(int var1, int var2, Bt286 var3, int var4, int var5, float var6) {
      this.d = var1;
      this.q = var2;
      this.b = var3;
      this.j = var4;
      this.e = var5;
      this.h = var6;
   }

   public static int d(D285 var0) {
      return var0.d;
   }

   public static boolean j(D285 var0) {
      if (var0.s == null) {
         return true;
      } else {
         return var0.s.j == Av106.FULL;
      }
   }
}
