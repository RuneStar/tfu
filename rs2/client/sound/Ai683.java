package rs2.client.sound;

import java.util.ArrayList;

class Ai683 {
   H591 b;
   public float d;
   int e;
   ArrayList g;
   float h;
   int j;
   float l;
   float q;
   float s;
   float w;
   // $FF: synthetic field
   final H591 r;

   public Ai683(H591 var1, H591 var2, int var3, int var4) {
      this.r = var1;
      this.g = new ArrayList();
      this.d = 0.0F;
      this.q = 0.25F;
      this.w = (float)var3;
      this.l = (float)var4;
      this.b = var2;
   }

   public static int g(Ai683 var0, String[] var1, int var2) {
      String var3 = var1[var2++];
      String[] var4 = var3.split("\\|");
      var0.j = Integer.parseInt(var4[0]);
      var0.e = Integer.parseInt(var4[1]);
      var0.h = Float.parseFloat(var4[2]);
      var0.s = Float.parseFloat(var4[3]);
      int var5 = Integer.parseInt(var4[4]);

      for(int var6 = 0; var6 < var5; ++var6) {
      }

      return var2;
   }
}
