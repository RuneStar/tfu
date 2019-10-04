package rs2.client.sound;

import fmod.E245;
import fmod.Q244;
import fmod.X243;
import java.util.ArrayList;

class P679 {
   private int b;
   private ArrayList d;
   private float e;
   private String g;
   private float h;
   private X243 j;
   private int l;
   H591 p;
   private float q;
   private int r;
   private int s;
   public int u;
   private String v;
   private int w;
   private String x;
   private int y;
   public float z;
   // $FF: synthetic field
   final H591 t;

   public static void g(P679 var0) {
      if (var0.j != null && X243.h(var0.j)) {
         X243.f(var0.j);
      }

   }

   public P679(H591 var1, int var2, String var3, H591 var4, int var5, int var6, int var7, int var8) {
      this.t = var1;
      this.d = new ArrayList();
      this.h = 1.0F;
      this.r = 0;
      this.x = "";
      this.z = 0.0F;
      this.y = var2;
      this.s = var5;
      this.b = var6;
      this.l = var7;
      this.w = var8;
      this.p = var4;
      this.e = (float)Math.pow(2.0D, 8.333333535119891E-4D);
      this.g = var3;
   }

   public static void q(P679 var0, float var1, float var2, float var3) {
      var1 = Math.max(var1, (float)var0.s);
      var1 = Math.min(var1, (float)var0.b);
      float var4 = (var1 - (float)var0.s) / (float)(var0.b - var0.s);
      float var5 = (float)var0.l + (float)(var0.w - var0.l) * var4;
      var5 *= var0.h;
      if (var0.j != null && X243.h(var0.j)) {
         X243.k(var0.j, (var5 + var0.q) / 100.0F, 2);
      }

      float var6 = var4;
      float var7 = 0.0F;
      int var8 = var0.d.size();
      if (var4 > ((R676)var0.d.get(var8 - 1)).g) {
         var6 = ((R676)var0.d.get(var8 - 1)).g;
      }

      if (var6 < ((R676)var0.d.get(0)).g) {
         var6 = ((R676)var0.d.get(0)).g;
      }

      for(int var9 = 0; var9 < var8 - 1; ++var9) {
         R676 var10 = (R676)var0.d.get(var9);
         R676 var11 = (R676)var0.d.get(var9 + 1);
         if (var6 >= var10.g && var6 <= var11.g) {
            var4 = (var6 - var10.g) / (var11.g - var10.g);
            var7 = var10.d + (var11.d - var10.d) * var4;
            break;
         }
      }

      float var12;
      if (var0.r == 0) {
         var12 = var2;
      } else {
         var12 = var3;
      }

      float var13 = var12 * var7;
      var13 *= var0.p.ai;
      if (var0.j == null && var13 > 0.01F) {
         var0.j = E245.v(SoundManager.c, var0.x);
         if (X243.h(var0.j)) {
            X243.u(var0.j, var0.t.av);
            var0.j.a();
         } else {
            var0.j = null;
         }
      }

      if (var0.j != null && var13 == 0.0F) {
         X243.c(var0.j);
         var0.j = null;
      }

      if (var0.j != null) {
         X243.i(var0.j, Math.min(1.0F, Math.abs(var13)));
      }

      var0.z = 0.0F;
      if (var0.j != null && X243.y(var0.j)) {
         ++var0.t.d;
         var0.z = var13;
      }

   }

   public int j(String[] var1, int var2) {
      ++var2;
      this.q = Float.parseFloat(var1[var2++]);
      this.r = 0;
      String var3 = var1[var2++];
      if (var3.equals("L")) {
         this.r = 0;
      } else if (var3.equals("U")) {
         this.r = 1;
      }

      this.v = var1[var2++];
      this.h = Float.parseFloat(var1[var2++]);
      int var4 = Integer.parseInt(var1[var2++]);
      float var5 = -12345.0F;

      for(int var6 = 0; var6 < var4; ++var6) {
         String[] var7 = var1[var2++].split("\\|");
         float var8 = Math.min(Float.parseFloat(var7[0]), 1.0F);
         if (var8 != var5) {
            var5 = var8;
            this.d.add(new R676(this.t, var8, Float.parseFloat(var7[1])));
         }
      }

      this.x = "VEHICLES/A" + this.y + "/" + this.g;
      this.j = null;
      return var2;
   }

   public static void d(P679 var0, Q244 var1) {
      if (var0.j != null && X243.h(var0.j)) {
         X243.u(var0.j, var1);
      }

   }
}
