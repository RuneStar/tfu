package tfu;

public class Ci646 extends Cw634 {
   private float[] e;
   private Cg550 s;

   public Ci646(int var1, float[] var2, int var3, int var4, boolean var5) {
      super.g = var1;
      this.e = var2;
      super.d = var3;
      super.q = var4;
      super.j = var5;
   }

   public int g() {
      return this.e.length;
   }

   public Cm645 b(int var1, int var2, int var3) {
      return this.e != null && this.e.length != 0 ? new Cm645(this, var1, var2, var3) : null;
   }

   public static float[] l(Ci646 var0) {
      return var0.e;
   }

   public static boolean w(Ci646 var0) {
      if (var0.s != null && !Cg550.r(var0.s)) {
         var0.s = null;
      }

      return var0.s != null;
   }

   public Ci646(int var1, Cg550 var2, float[] var3, int var4, int var5, boolean var6) {
      super.g = var1;
      this.s = var2;
      this.e = var3;
      super.d = var4;
      super.q = var5;
      super.j = var6;
   }

   public static int r(Ci646 var0) {
      return !w(var0) ? var0.e.length - 1 : Cg550.w(var0.s);
   }
}
