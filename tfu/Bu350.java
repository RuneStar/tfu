package tfu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Bu350 {
   private final PriorityBlockingQueue d;
   private final String g;
   private int j;
   private final ThreadPoolExecutor q;

   public void d() {
      ArrayList var1 = new ArrayList(this.d.size());
      this.d.drainTo(var1);
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Runnable var3 = (Runnable)var2.next();
         Bg653 var4 = (Bg653)var3;
         if (!var4.d.d()) {
            Bn279.j(var4.g);
         } else {
            Bg653.q(var4);
            this.d.add(var3);
         }
      }

   }

   public Bn279 g(Br121 var1, Bv351 var2, Object var3) {
      if (!var1.d()) {
         throw new IllegalStateException();
      } else {
         if (var2 != null) {
            var2.d |= var1.q();
         }

         Bn279 var4 = new Bn279(var1, var3);
         Bf654 var5 = new Bf654(this, var4, var1, var2);
         Bg653 var6 = new Bg653(var5, var4, var1, this.j++);
         var4.e = var6;
         this.q.execute(var6);
         return var4;
      }
   }

   public Bu350(int var1, String var2) {
      this.g = var2;
      Mw514 var3 = new Mw514(this.g);
      this.d = new PriorityBlockingQueue(11);
      this.q = new ThreadPoolExecutor(var1, var1, 0L, TimeUnit.MILLISECONDS, this.d, var3);
   }

   public Bu350(String var1) {
      this(1, var1);
   }

   public static Object[] q(Bu350 var0, Object[] var1) {
      if (var1 == null) {
         var1 = var0.d.toArray();
      } else {
         var1 = var0.d.toArray(var1);
      }

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Object var3 = var1[var2];
         if (var3 == null) {
            break;
         }

         Bg653 var4 = (Bg653)var3;
         if (!var4.d.d()) {
            Bn279.j(var4.g);
         }

         var1[var2] = null;
      }

      return var1;
   }

   public String toString() {
      return this.getClass().getName() + " \"" + this.g + "\"";
   }
}
