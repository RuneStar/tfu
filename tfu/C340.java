package tfu;

import com.jagex.maths.H303;
import com.jagex.maths.Matrix4;
import com.jagex.maths.U316;

public class C340 {
   public static int b = 0;
   static U316 d = new U316();
   static float e;
   static A672 g;
   static float h;
   static float j;
   public static int l = 0;
   static U316 q = new U316();
   public static int r = 0;
   static float s;
   static float[] v = new float[4];
   public static int w = 0;
   static float[] y = new float[4];

   public static void d(H303 var0, Matrix4 var1) {
      j = h = (float)H149.p / 2.0F;
      e = s = (float)H149.x / 2.0F;
      s = -s;
      U316.e(d, var0);
      U316.q(q, d);
      U316.j(q, var1);
   }

   public static final void q() {
      b = 0;
      w = 0;
      r = H149.p;
      l = H149.x;
   }

   public static final void j(int var0, int var1, int var2, int var3) {
      w = var0 >= 0 ? var0 : 0;
      r = var2 <= H149.p ? var2 : H149.p;
      b = var1 >= 0 ? var1 : 0;
      l = var3 <= H149.x ? var3 : H149.x;
   }

   public static final void e(float var0, float var1, float var2, float var3, int var4) {
      b(var0, var1, var2, var3, var4, Fb341.BLEND_NORMAL);
   }

   public static final void h(float var0, float var1, float var2, int var3) {
      l(var0, var1, var2, var3, Fb341.BLEND_NORMAL);
   }

   public static final void s(float var0, float var1, float var2, int var3) {
      w(var0, var1, var2, var3, Fb341.BLEND_NORMAL);
   }

   public static void y(int var0, int var1, int var2, int var3) {
   }

   public static final void g() {
      int[] var0 = new int[]{-1};
      g = new A672(1, 1, var0, 0, 1);
   }

   public static final void w(float var0, float var1, float var2, int var3, Fb341 var4) {
      r(var0, var1, var0, var1 + var2, var3, var4);
   }

   public static final void r(float var0, float var1, float var2, float var3, int var4, Fb341 var5) {
      v(var0, var1, var2, var3, var4, 1, var5);
   }

   public static final void v(float var0, float var1, float var2, float var3, int var4, int var5, Fb341 var6) {
      ++var0;
      ++var1;
      ++var2;
      ++var3;
      float var7 = var2 - var0;
      float var8 = var3 - var1;
      float var9 = 1.0F / (float)Math.sqrt((double)(var7 * var7 + var8 * var8));
      var7 *= var9;
      var8 *= var9;
      var0 -= var7;
      var1 -= var8;
      float var10 = -var8;
      var10 *= 0.5F * (float)var5;
      float var11 = var7 * 0.5F * (float)var5;
      A672.g(g, var0 - var10, var1 - var11, var2 - var10, var3 - var11, var0 + var10, var1 + var11, Fy467.PREBLEND_MODULATE, var4, var6);
   }

   public static final void l(float var0, float var1, float var2, int var3, Fb341 var4) {
      r(var0, var1, var0 + var2, var1, var3, var4);
   }

   public static final void b(float var0, float var1, float var2, float var3, int var4, Fb341 var5) {
      A672.h(g, var0, var1, var2, var3, Fy467.PREBLEND_MODULATE, var4, var5);
   }
}
