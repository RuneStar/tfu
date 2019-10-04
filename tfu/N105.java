package tfu;

import com.jagex.jnibindings.runetek6.Mesh;
import java.util.UUID;

public class N105 implements Hp62, S671 {
   public final boolean d;
   private Aq544[] e;
   public final Hi86 g;
   public int h;
   private long j;
   public final long[] q;
   public int[] s;

   public static void e(N105 var0, int var1, int var2) {
      var0.s[var1] = var2;
   }

   public static void h(N105 var0, int var1, Aq544 var2) {
      var0.e[var1] = var2;
   }

   public static void s(N105 var0, UUID var1) {
      var0.h = var1.hashCode();
   }

   public void g() {
      if (this.j != 0L) {
         for(int var1 = 0; var1 < this.e.length; ++var1) {
            Aq544 var2 = this.e[var1];
            this.q[var1] = Mesh.create(var2.g, var2.d, var2.j.getId());
         }

         Kc180.d(this.j);
         this.j = 0L;
      }
   }

   public static long j(N105 var0) {
      return var0.j;
   }

   public void onAllRefsReleased() {
      if (this.j != 0L) {
         Kc180.d(this.j);
         this.j = 0L;
      }

      for(int var1 = 0; var1 < this.q.length; ++var1) {
         if (this.q[var1] != 0L) {
            Mesh.destroy(this.q[var1]);
            this.q[var1] = 0L;
         }
      }

   }

   public N105(Hi86 var1, int var2, boolean var3, int var4) {
      this.g = var1;
      this.q = new long[var2];
      this.d = var3;
      this.e = new Aq544[var2];
      this.s = new int[var2];
      this.j = Kc180.g((long)var4);
   }
}
