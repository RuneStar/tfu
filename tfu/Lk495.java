package tfu;

import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rs2.client.client;

public class Lk495 {
   private static Lk495 j;
   private List d = new ArrayList();
   private boolean e;
   private List g = new ArrayList();
   private List q = new ArrayList();

   public static void q(Lk495 var0) {
      if (h(var0)) {
         Iterator var1 = var0.g.iterator();

         Lu496 var2;
         while(var1.hasNext()) {
            var2 = (Lu496)var1.next();
            Lu496.d(var2);
         }

         var1 = var0.q.iterator();

         while(var1.hasNext()) {
            var2 = (Lu496)var1.next();
            Lu496.d(var2);
         }
      }

   }

   public static Lk495 g() {
      if (j == null) {
         j = new Lk495();
      }

      return j;
   }

   private Lk495() {
   }

   public void e(Gs329 var1) {
      this.g.clear();
      int var2 = Gs329.au(var1);

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = Gs329.au(var1);
         Lu496 var5 = new Lu496();
         this.g.add(var5);

         for(int var6 = 0; var6 < var4; ++var6) {
            int var7 = Gs329.bd(var1) - client.gn;
            int var8 = Gs329.bd(var1) - client.gj;
            float var9 = Gs329.bl(var1);
            Vector3 var10 = new Vector3((float)var7, var9, (float)var8);
            Lu496.g(var5).add(var10);
         }
      }

   }

   public static void d(int var0, int var1) {
      Lu496.b(var0, var1);
   }

   public void j(Gs329 var1) {
      this.q.clear();
      Lu496 var2 = new Lu496();
      Lu496.s(var2, false);
      Lu496.e(var2, -16776961);
      this.q.add(var2);
      int var3 = Gs329.au(var1);

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = Gs329.bd(var1) - client.gn;
         int var6 = Gs329.bd(var1) - client.gj;
         float var7 = Gs329.bl(var1);
         Vector3 var8 = new Vector3((float)var5, var7, (float)var6);
         Lu496.g(var2).add(var8);
      }

   }

   public static boolean h(Lk495 var0) {
      return var0.e;
   }
}
