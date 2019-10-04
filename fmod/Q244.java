package fmod;

public class Q244 {
   public float d;
   public float g;
   public float q;

   public Q244(float var1, float var2, float var3) {
      this.g = var1;
      this.d = var2;
      this.q = var3;
   }

   public Q244() {
      this.g = this.d = this.q = 0.0F;
   }

   public Q244(Q244 var1) {
      this.g = var1.g;
      this.d = var1.d;
      this.q = var1.q;
   }

   public String toString() {
      return "X = " + this.g + ", Y = " + this.d + ", Z = " + this.q;
   }
}
