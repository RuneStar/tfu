package tfu;

import com.jagex.js5.js5;
import java.io.IOException;

public class Cg550 extends Ln265 {
   private static float[] a;
   private static int[] af;
   private static float[] ag;
   private static float[] ai;
   private static float[] al;
   private static float[] aq;
   private static int[] av;
   private static byte[] b;
   private static float[] c;
   private static float[] f;
   private static final boolean g = false;
   private static int l;
   private static boolean m = false;
   private static Cy632[] p;
   private static int r;
   private static int[] t;
   private static Ck642[] u;
   private static int v;
   private static int w;
   private static Ct636[] x;
   static Cn647[] y;
   private static boolean[] z;
   private int aa = 0;
   private int ah;
   private int am = 0;
   private int an;
   private float[] ao;
   private int ap;
   private byte[] az;
   private byte[][] d;
   private int e;
   private int h;
   private int i;
   public int j;
   private int k;
   private float[] n;
   private boolean o;
   private int q;
   private boolean s;

   private void e(byte[] var1) throws IOException {
      Gg3 var2 = new Gg3(var1);
      this.q = Gg3.bd(var2);
      this.j = Gg3.bd(var2);
      this.e = Gg3.bd(var2);
      this.h = Gg3.bd(var2);
      if (this.h < 0) {
         this.h = ~this.h;
         this.s = true;
      }

      int var3 = Gg3.bd(var2);
      if (var3 < 0) {
         throw new IOException();
      } else {
         this.d = new byte[var3][];

         for(int var4 = 0; var4 < var3; ++var4) {
            int var5 = 0;

            int var6;
            do {
               var6 = Gg3.ar(var2);
               var5 += var6;
            } while(var6 >= 255);

            byte[] var7 = new byte[var5];
            Gg3.bx(var2, var7, 0, var5);
            this.d[var4] = var7;
         }

      }
   }

   static void d(byte[] var0, int var1) {
      b = var0;
      l = var1;
      w = 0;
   }

   static int q() {
      int var0 = b[l] >> w & 1;
      ++w;
      l += w >> 3;
      w &= 7;
      return var0;
   }

   static int j(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - w; var0 -= var3) {
         var3 = 8 - w;
         int var4 = (1 << var3) - 1;
         var1 += (b[l] >> w & var4) << var2;
         w = 0;
         ++l;
         var2 += var3;
      }

      if (var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (b[l] >> w & var3) << var2;
         w += var0;
      }

      return var1;
   }

   public Cg550(byte[] var1) throws IOException {
      this.e(var1);
   }

   public static void h(byte[] var0) {
      d(var0, 0);
      r = 1 << j(4);
      v = 1 << j(4);
      a = new float[v];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0 ? v : r;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var13 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var13[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var13[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var14 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var14[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var14[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var15 = new int[var5];
         int var10 = Jz233.s(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var15[var11] = Jz233.b(var11, var10);
         }

         if (var1 != 0) {
            aq = var6;
            ai = var13;
            al = var14;
            av = var15;
         } else {
            f = var6;
            c = var13;
            ag = var14;
            af = var15;
         }
      }

      var1 = j(8) + 1;
      y = new Cn647[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         y[var2] = new Cn647();
      }

      var2 = j(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         j(16);
      }

      var2 = j(6) + 1;
      p = new Cy632[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         p[var3] = new Cy632();
      }

      var3 = j(6) + 1;
      x = new Ct636[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         x[var4] = new Ct636();
      }

      var4 = j(6) + 1;
      u = new Ck642[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         u[var5] = new Ck642();
      }

      var5 = j(6) + 1;
      z = new boolean[var5];
      t = new int[var5];

      for(int var12 = 0; var12 < var5; ++var12) {
         z[var12] = q() != 0;
         j(16);
         j(16);
         t[var12] = j(8);
      }

      m = true;
   }

   private static boolean s(js5 var0) {
      if (!m) {
         byte[] var1 = var0.getfile(0, 0);
         if (var1 == null) {
            return false;
         }

         h(var1);
      }

      return true;
   }

   public static Cg550 b(js5 var0, int var1, int var2) {
      if (!s(var0)) {
         var0.requestdownload(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getfile(var1, var2);
         if (var3 == null) {
            return null;
         } else {
            Cg550 var4 = null;

            try {
               var4 = new Cg550(var3);
            } catch (IOException var6) {
               var6.printStackTrace();
            }

            return var4;
         }
      }
   }

   public static int w(Cg550 var0) {
      return var0.aa;
   }

   public static boolean r(Cg550 var0) {
      return var0.aa < var0.j - 1;
   }

   public Ci646 l() {
      Cr641.g(this);
      return r(this) && (this.aa <= this.q || this.am <= this.q / Dl463.x()) ? null : new Ci646(this.q, this, this.ao, this.e, this.h, this.s);
   }

   static float g(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if (var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }
}
