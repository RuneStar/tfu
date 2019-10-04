package tfu;

import java.lang.reflect.Array;
import java.util.Arrays;

class Iq422 implements Br121 {
   private final Object[] d;
   private final Ir421 e;
   private Ao128 g;
   private final int h;
   private final Class j;
   private final Class q;
   private final Mz200 s;
   // $FF: synthetic field
   final Hi86 b;

   Iq422(Hi86 var1, Class var2, Class var3, Object[] var4, Ir421 var5, int var6, Mz200 var7) {
      this.b = var1;
      this.q = var2;
      this.j = var3;
      this.d = var4;
      this.e = var5;
      this.h = var6;
      this.s = var7;
   }

   public static void j(Iq422 var0, Hp62 var1) {
      if (var1 != null && var0.e.resourceNeedsRefCounting()) {
         Hi86.l(var0.b, var1);
      }

   }

   public int e() {
      return this.s != null ? this.s.g() : this.h;
   }

   public boolean d() {
      return true;
   }

   public boolean q() {
      return this.e.resourceNeedsRefCounting();
   }

   public Hp62 g() throws Exception {
      Hm417 var1 = new Hm417(this.q, this.d);

      try {
         Hi86.z().trace("{}:{}-> Asynchronous load+combine...", this.q.getSimpleName(), Arrays.deepToString(this.d));
         Hp62 var2 = this.b.e.j(var1, this.g);
         if (var2 != null) {
            Hi86.z().trace("{}:{}-> Cache hit", this.q.getSimpleName(), Arrays.deepToString(this.d));
            return var2;
         } else {
            Hi86.z().trace("{}:{}-> Cache miss", this.q.getSimpleName(), Arrays.deepToString(this.d));
            Bn279[] var3 = new Bn279[this.d.length];

            for(int var4 = 0; var4 < this.d.length; ++var4) {
               var3[var4] = this.b.e(this.j, this.d[var4], Integer.MAX_VALUE, (Bv351)null, (Object)null);
            }

            Hp62[] var7 = (Hp62[])((Hp62[])Array.newInstance(this.j, this.d.length));

            for(int var5 = 0; var5 < this.d.length; ++var5) {
               var7[var5] = (Hp62)var3[var5].d();
            }

            var2 = this.e.d(var7, this.b);
            this.b.e.e(var1, var2, this.e);
            Hi86.z().trace("{}:{}-> Asynchronously loaded+combined", this.q.getSimpleName(), Arrays.deepToString(this.d));
            return var2;
         }
      } catch (Throwable var6) {
         this.b.e.h(var1, var6);
         if (var6 instanceof Exception) {
            throw (Exception)var6;
         } else if (var6 instanceof Error) {
            throw (Error)var6;
         } else {
            throw new RuntimeException(var6);
         }
      }
   }
}
