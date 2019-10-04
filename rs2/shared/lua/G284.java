package rs2.shared.lua;

public class G284 {
   private long d = 0L;
   private long e = 0L;
   private long g = 0L;
   private long h = 0L;
   private long j = 0L;
   private long q = 0L;
   private long s = 0L;

   private static void d(G284 var0) {
      long var1 = System.currentTimeMillis();
      if (var0.s == 0L || var1 > var0.s + 1000L) {
         var0.s = var1;
         var0.h = var0.q;
         var0.e = var0.j;
         var0.q = 0L;
         var0.j = 0L;
      }

   }

   public static void g(G284 var0, long var1) {
      d(var0);
      ++var0.d;
      ++var0.q;
      var0.j += var1;
      var0.g += var1;
   }

   private static String q(G284 var0, long var1) {
      if (var1 > 1048576L) {
         return String.format("%.2fMb", (double)((float)var1) / 1024.0D / 1024.0D);
      } else {
         return var1 > 1024L ? String.format("%.2fKb", (double)((float)var1) / 1024.0D) : String.format("%d bytes", var1);
      }
   }

   public String j() {
      d(this);
      StringBuilder var1 = new StringBuilder(16);
      var1.append("Sec: ");
      var1.append(q(this, this.e));
      var1.append(" in ");
      var1.append(this.h);
      var1.append(" message");
      if (this.h != 1L) {
         var1.append("s");
      }

      var1.append(", Total: ");
      var1.append(q(this, this.g));
      var1.append(" in ");
      var1.append(this.d);
      var1.append(" message");
      if (this.d != 1L) {
         var1.append("s");
      }

      return var1.toString();
   }
}
