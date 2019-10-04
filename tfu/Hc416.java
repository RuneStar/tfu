package tfu;

class Hc416 implements Br121 {
   private final Object d;
   private final Mz200 e;
   private Ao128 g;
   private final int j;
   private final Class q;
   // $FF: synthetic field
   final Hi86 h;

   public boolean q() {
      Ia63 var1 = Hi86.x(this.h, this.q);
      return var1.resourceNeedsRefCounting();
   }

   public Hp62 g() throws Exception {
      Hi86.z().trace("{}:{} -> Asynchronous loading...", this.q.getSimpleName(), this.d);
      Hm417 var1 = new Hm417(this.q, this.d);

      try {
         Hp62 var2 = this.h.e.j(var1, this.g);
         if (var2 != null) {
            Hi86.z().trace("{}:{} -> Cache hit", this.q.getSimpleName(), this.d);
            return var2;
         } else {
            Hi86.z().trace("{}:{} -> Cache miss", this.q.getSimpleName(), this.d);
            Ib29 var7 = Hi86.y(this.h, this.q);
            Ia63 var4 = Hi86.x(this.h, this.q);
            byte[] var5 = var7.getData(this.d);
            var2 = var4.constructResource(var5, this.d, this.h);
            this.h.e.e(var1, var2, var4);
            Hi86.z().trace("{}:{} -> Asynchronously loaded", this.q.getSimpleName(), this.d);
            return var2;
         }
      } catch (Throwable var6) {
         this.h.e.h(var1, var6);
         Object var3 = Hi86.t(this.h).get(this.q);
         if (var3 != null && !var3.equals(this.d)) {
            return this.h.j(this.q, var3);
         } else if (var6 instanceof Exception) {
            throw (Exception)var6;
         } else if (var6 instanceof Error) {
            throw (Error)var6;
         } else {
            throw new RuntimeException(var6);
         }
      }
   }

   public boolean d() {
      return true;
   }

   public static void j(Hc416 var0, Hp62 var1) {
      if (var1 != null) {
         Ia63 var2 = Hi86.x(var0.h, var0.q);
         if (var2.resourceNeedsRefCounting()) {
            Hi86.l(var0.h, var1);
         }
      }

   }

   Hc416(Hi86 var1, Class var2, Object var3, int var4, Mz200 var5) {
      this.h = var1;
      this.q = var2;
      this.d = var3;
      this.j = var4;
      this.e = var5;
   }

   public int e() {
      return this.e != null ? this.e.g() : this.j;
   }
}
