package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;

class A207 implements State {
   final float b;
   final float d;
   final float e;
   final float g;
   final boolean h;
   final float j;
   final float l;
   final float q;
   final float s;

   public int hashCode() {
      return (int)(this.g * 65536.0F + this.d * 31.0F + this.q + this.j * 257.0F + this.e * 8191.0F);
   }

   public String toString() {
      String var1 = "dpos=(" + this.g + "," + this.d + "," + this.q + ") maxAccelPerTick=" + this.j + " faceAngle=" + this.e;
      if (this.h) {
         var1 = var1 + " isUnpushable=true";
      }

      if (this.s != 0.0F || this.b != 0.0F || this.l != 0.0F) {
         var1 = var1 + " impulse=(" + this.s + "," + this.b + "," + this.l + ")";
      }

      return var1;
   }

   A207(float var1, float var2, float var3, float var4, float var5, boolean var6, float var7, float var8, float var9) {
      if (var6) {
         var1 = 0.0F;
         var2 = 0.0F;
         var3 = 0.0F;
         var7 = 0.0F;
         var8 = 0.0F;
         var9 = 0.0F;
      }

      this.g = var1;
      this.d = var2;
      this.q = var3;
      this.j = var4;
      this.e = var5;
      this.h = var6;
      this.s = var7;
      this.b = var8;
      this.l = var9;
   }

   public boolean equals(Object var1) {
      A207 var2 = (A207)var1;
      return this.g == var2.g && this.d == var2.d && this.q == var2.q && this.j == var2.j && this.e == var2.e && this.h == var2.h && this.s == var2.s && this.b == var2.b && this.l == var2.l;
   }
}
