package tfu;

public abstract class Cx556 extends Ln265 {
   Cx556 ae;
   int bd;
   public Cb633 bm;
   public volatile boolean w = true;

   protected abstract Cx556 g();

   public abstract void j(int[] var1, int var2, int var3);

   protected abstract Cx556 d();

   public static final void ck(Cx556 var0, int[] var1, int var2, int var3) {
      if (var0.w) {
         var0.j(var1, var2, var3);
      } else {
         var0.e(var3);
      }

   }

   protected abstract int q();

   public abstract void e(int var1);

   protected int cd() {
      return 255;
   }
}
