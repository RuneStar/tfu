package tfu;

public class Cj551 extends Cw634 {
   public byte[] e;

   public Cj551(int var1, byte[] var2, int var3, int var4) {
      super.g = var1;
      this.e = var2;
      super.d = var3;
      super.q = var4;
   }

   public int g() {
      return this.e.length;
   }

   public Cv549 b(int var1, int var2, int var3) {
      return this.e != null && this.e.length != 0 ? new Cv549(this, var1, var2, var3) : null;
   }

   public Cj551(int var1, int var2) {
      super.g = var1;
      this.e = new byte[var2];
      super.d = 0;
      super.q = var2;
   }

   public Cj551(int var1, byte[] var2, int var3, int var4, boolean var5) {
      super.g = var1;
      this.e = var2;
      super.d = var3;
      super.q = var4;
      super.j = var5;
   }
}
