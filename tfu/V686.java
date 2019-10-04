package tfu;

public class V686 {
   public int b;
   public byte[] d;
   public int e;
   public byte[] g;
   public int h;
   public int j;
   public int l;
   public int q;
   public int s;

   public V686() {
   }

   public V686(V686 var1) {
      if (var1.g != null) {
         this.g = (byte[])var1.g.clone();
      }

      if (var1.d != null) {
         this.d = (byte[])var1.d.clone();
      }

      this.q = var1.q;
      this.j = var1.j;
      this.e = var1.e;
      this.h = var1.h;
      this.s = var1.s;
      this.b = var1.b;
      this.l = var1.l;
   }
}
