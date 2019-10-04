package tfu;

import com.jagex.jnibindings.runetek6.Graphics;
import com.jagex.jnibindings.runetek6.GroundCover;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.maths.H303;
import com.jagex.maths.Matrix4;
import com.jagex.maths.ScaleRotTrans;
import java.awt.Canvas;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class H149 {
   private static int b = 0;
   public static int d = 4;
   public static int e = 0;
   public static long h = 0L;
   public static long j = 0L;
   private static float[] l;
   private static final Logger logger = LoggerFactory.getLogger(H149.class);
   public static int p;
   private static int q = 4194304;
   private static int[] r;
   private static int s = 128;
   public static long u;
   public static final Object v;
   private static long[] w;
   public static int x;
   public static boolean y;
   public static String z;

   public static void g(String var0, Canvas var1) {
      Lb33.g(Lb33.InitGraphicsJava);

      try {
         try {
            Gy491.g(false, true);
            d = Kc180.e();
            j = Kc180.g((long)q);
            Lb33.g(Lb33.GetDefaultCamera);
            boolean var70 = false;

            try {
               var70 = true;
               h = Graphics.getDefaultCamera();
               Lb33.d(Lb33.GetDefaultCamera);
               var70 = false;
            } finally {
               if (var70) {
                  Lb33.d(Lb33.GetDefaultCamera);
               }
            }

            z = var0 + File.separatorChar;
            Lb33.g(Lb33.AddBaseMediaPath);
            boolean var61 = false;

            try {
               var61 = true;
               Graphics.addBaseMediaPath(var0 + File.separatorChar);
               Lb33.d(Lb33.AddBaseMediaPath);
               var61 = false;
            } finally {
               if (var61) {
                  Lb33.d(Lb33.AddBaseMediaPath);
               }
            }

            Lb33.g(Lb33.AddBaseShaderPath);
            boolean var52 = false;

            try {
               var52 = true;
               Graphics.addBaseShaderPath((new File(var0, "HLSL")).getPath() + File.separatorChar);
               Lb33.d(Lb33.AddBaseShaderPath);
               var52 = false;
            } finally {
               if (var52) {
                  Lb33.d(Lb33.AddBaseShaderPath);
               }
            }

            Lb33.g(Lb33.InitFromCanvas);
            boolean var43 = false;

            try {
               var43 = true;
               Graphics.initFromCanvas(var1, 0, 0, 2, 0, 0, 0);
               Lb33.d(Lb33.InitFromCanvas);
               var43 = false;
            } finally {
               if (var43) {
                  Lb33.d(Lb33.InitFromCanvas);
               }
            }

            p = var1.getWidth();
            x = var1.getHeight();
            Lb33.g(Lb33.InitDrawHelper);
            boolean var34 = false;

            try {
               var34 = true;
               C340.g();
               Lb33.d(Lb33.InitDrawHelper);
               var34 = false;
            } finally {
               if (var34) {
                  Lb33.d(Lb33.InitDrawHelper);
               }
            }

            Lb33.g(Lb33.CreateGroundCover);
            boolean var25 = false;

            try {
               var25 = true;
               u = GroundCover.createEngine();
               Lb33.d(Lb33.CreateGroundCover);
               var25 = false;
            } finally {
               if (var25) {
                  Lb33.d(Lb33.CreateGroundCover);
               }
            }

            y = true;
         } catch (Exception var77) {
            logger.error("", var77);
            Lb33.d(Lb33.InitGraphicsJava);
            return;
         }

         Lb33.d(Lb33.InitGraphicsJava);
      } finally {
         Lb33.d(Lb33.InitGraphicsJava);
      }
   }

   public static void e(H303 var0, Matrix4 var1, Collection var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, Collection var10, Collection var11) {
      Object var12 = v;
      synchronized(var12) {
         Lb33.g(Lb33.zGraphicsSync);
         boolean var33 = false;

         try {
            var33 = true;
            int var13 = var2 != null ? var2.size() : 0;
            int var14 = var10 != null ? var10.size() : 0;
            int var15 = var11 != null ? var11.size() : 0;
            int var16 = d + 88 + 4 + var13 * (d + 32) + 4 + var14 * d + 4 + var15 * d + 4 + b * (64 + d + 4);
            if (q < var16) {
               int var17 = var16 * 3 / 2;
               Kc180.d(j);
               j = Kc180.g((long)var17);
               q = var17;
            }

            long var36 = j;
            Kc180.s(var36, h);
            var36 += (long)d;
            Kc180.v(var36, var1.f00);
            var36 += 4L;
            Kc180.v(var36, var1.f01);
            var36 += 4L;
            Kc180.v(var36, var1.f02);
            var36 += 4L;
            Kc180.v(var36, var1.f03);
            var36 += 4L;
            Kc180.v(var36, var1.f10);
            var36 += 4L;
            Kc180.v(var36, var1.f11);
            var36 += 4L;
            Kc180.v(var36, var1.f12);
            var36 += 4L;
            Kc180.v(var36, var1.f13);
            var36 += 4L;
            Kc180.v(var36, var1.f20);
            var36 += 4L;
            Kc180.v(var36, var1.f21);
            var36 += 4L;
            Kc180.v(var36, var1.f22);
            var36 += 4L;
            Kc180.v(var36, var1.f23);
            var36 += 4L;
            Kc180.v(var36, var1.f30);
            var36 += 4L;
            Kc180.v(var36, var1.f31);
            var36 += 4L;
            Kc180.v(var36, var1.f32);
            var36 += 4L;
            Kc180.v(var36, var1.f33);
            var36 += 4L;
            Kc180.v(var36, var4);
            var36 += 4L;
            Kc180.v(var36, var5);
            var36 += 4L;
            Kc180.v(var36, var6);
            var36 += 4L;
            Kc180.v(var36, var7);
            var36 += 4L;
            Kc180.v(var36, var8);
            var36 += 4L;
            Kc180.v(var36, var9);
            var36 += 4L;
            int var19 = 0;
            long var20 = var36;
            var36 += 4L;
            if (var2 != null) {
               Iterator var22 = var2.iterator();

               while(var22.hasNext()) {
                  L253 var23 = (L253)var22.next();
                  long var24 = var23.g();
                  if (var24 != 0L) {
                     ScaleRotTrans var26 = var23.getObjectTransform();
                     Kc180.s(var36, var24);
                     var36 += (long)d;
                     Kc180.v(var36, var26.scale);
                     var36 += 4L;
                     Kc180.v(var36, var26.rot.x);
                     var36 += 4L;
                     Kc180.v(var36, var26.rot.y);
                     var36 += 4L;
                     Kc180.v(var36, var26.rot.z);
                     var36 += 4L;
                     Kc180.v(var36, var26.rot.w);
                     var36 += 4L;
                     Kc180.v(var36, var26.trans.x);
                     var36 += 4L;
                     Kc180.v(var36, var26.trans.y);
                     var36 += 4L;
                     Kc180.v(var36, var26.trans.z);
                     var36 += 4L;
                     ++var19;
                  }
               }
            }

            Kc180.r(var20, var19);
            int var37 = 0;
            long var38 = var36;
            var36 += 4L;
            Iterator var25;
            long var27;
            L253 var40;
            if (var10 != null) {
               var25 = var10.iterator();

               while(var25.hasNext()) {
                  var40 = (L253)var25.next();
                  var27 = var40.g();
                  if (var27 != 0L) {
                     Kc180.s(var36, var27);
                     var36 += (long)d;
                     ++var37;
                  }
               }
            }

            Kc180.r(var38, var37);
            var37 = 0;
            var38 = var36;
            var36 += 4L;
            if (var11 != null) {
               var25 = var11.iterator();

               while(var25.hasNext()) {
                  var40 = (L253)var25.next();
                  var27 = var40.g();
                  if (var27 != 0L) {
                     Kc180.s(var36, var27);
                     var36 += (long)d;
                     ++var37;
                  }
               }
            }

            Kc180.r(var38, var37);
            Kc180.r(var36, b);
            var36 += 4L;

            for(var37 = 0; var37 < b; ++var37) {
               for(int var39 = 0; var39 < 16; ++var39) {
                  Kc180.v(var36, l[var37 * 16 + var39]);
                  var36 += 4L;
               }

               Kc180.s(var36, w[var37]);
               var36 += (long)d;
               Kc180.r(var36, r[var37]);
               var36 += 4L;
            }

            if (var36 > j + (long)var16) {
               logger.error("Buffer size was estimated as " + var16 + ", but we used " + (var36 - j));
               if (var36 > j + (long)q) {
                  throw new Error("The above wrong estimate has caused a buffer overrun - bailing out!");
               }
            }

            Graphics.processFrame(j, (int)(var36 - j), var3, e);
            b = 0;
            Lb33.d(Lb33.zGraphicsSync);
            var33 = false;
         } finally {
            if (var33) {
               Lb33.d(Lb33.zGraphicsSync);
            }
         }

      }
   }

   public static void h() {
      b = 0;
   }

   public static void d() {
      if (Scripting.g()) {
         Kc180.d(j);
         GroundCover.destroyEngine(u);
         Graphics.purge();
      }

   }

   public static void j(long var0, float var2) {
      Lb33.g(Lb33.ProcessScript);

      try {
         Graphics.runPreRenderScripts(var0, var2);
         Lb33.d(Lb33.ProcessScript);
      } finally {
         Lb33.d(Lb33.ProcessScript);
      }
   }

   public static void s(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, long var8, int var10) {
      if ((var10 & -16777216) != 0) {
         float var11 = -0.5F;
         var0 += var11;
         var1 += var11;
         var2 += var11;
         var3 += var11;
         if (var0 <= (float)C340.r) {
            if (var1 <= (float)C340.l) {
               if (var2 >= (float)C340.w) {
                  if (var3 >= (float)C340.b) {
                     float var12 = var2 - var0;
                     float var13 = var3 - var1;
                     float var14 = var6 - var4;
                     float var15 = var7 - var5;
                     if (var0 < (float)C340.w) {
                        var4 += ((float)C340.w - var0) / var12 * var14;
                        var0 = (float)C340.w;
                     }

                     if (var1 < (float)C340.b) {
                        var5 += ((float)C340.b - var1) / var13 * var15;
                        var1 = (float)C340.b;
                     }

                     if (var2 > (float)C340.r) {
                        var6 -= (var2 - (float)C340.r) / var12 * var14;
                        var2 = (float)C340.r;
                     }

                     if (var3 > (float)C340.l) {
                        var7 -= (var3 - (float)C340.l) / var13 * var15;
                        var3 = (float)C340.l;
                     }

                     if (b == s) {
                        s *= 2;
                        float[] var16 = new float[s * 16];
                        System.arraycopy(l, 0, var16, 0, b * 16);
                        l = var16;
                        long[] var17 = new long[s];
                        System.arraycopy(w, 0, var17, 0, b);
                        w = var17;
                        int[] var18 = new int[s];
                        System.arraycopy(r, 0, var18, 0, b);
                        r = var18;
                     }

                     l[b * 16 + 0] = Ai354.j(var0);
                     l[b * 16 + 1] = Ai354.e(var1);
                     l[b * 16 + 2] = var4;
                     l[b * 16 + 3] = var5;
                     l[b * 16 + 4] = Ai354.j(var2);
                     l[b * 16 + 5] = Ai354.e(var1);
                     l[b * 16 + 6] = var6;
                     l[b * 16 + 7] = var5;
                     l[b * 16 + 8] = Ai354.j(var0);
                     l[b * 16 + 9] = Ai354.e(var3);
                     l[b * 16 + 10] = var4;
                     l[b * 16 + 11] = var7;
                     l[b * 16 + 12] = Ai354.j(var2);
                     l[b * 16 + 13] = Ai354.e(var3);
                     l[b * 16 + 14] = var6;
                     l[b * 16 + 15] = var7;
                     w[b] = var8;
                     r[b] = var10 & -16711936 | (var10 & 16711680) >> 16 | (var10 & 255) << 16;
                     ++b;
                  }
               }
            }
         }
      }
   }

   public static void b(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, long var16, int var18) {
      if ((var18 & -16777216) != 0) {
         float var19 = -0.5F;
         var0 += var19;
         var1 += var19;
         var2 += var19;
         var3 += var19;
         var4 += var19;
         var5 += var19;
         var6 += var19;
         var7 += var19;
         if (b == s) {
            s *= 2;
            float[] var20 = new float[s * 16];
            System.arraycopy(l, 0, var20, 0, b * 16);
            l = var20;
            long[] var21 = new long[s];
            System.arraycopy(w, 0, var21, 0, b);
            w = var21;
            int[] var22 = new int[s];
            System.arraycopy(r, 0, var22, 0, b);
            r = var22;
         }

         l[b * 16 + 0] = Ai354.j(var0);
         l[b * 16 + 1] = Ai354.e(var1);
         l[b * 16 + 2] = var8;
         l[b * 16 + 3] = var9;
         l[b * 16 + 4] = Ai354.j(var2);
         l[b * 16 + 5] = Ai354.e(var3);
         l[b * 16 + 6] = var10;
         l[b * 16 + 7] = var11;
         l[b * 16 + 8] = Ai354.j(var4);
         l[b * 16 + 9] = Ai354.e(var5);
         l[b * 16 + 10] = var12;
         l[b * 16 + 11] = var13;
         l[b * 16 + 12] = Ai354.j(var6);
         l[b * 16 + 13] = Ai354.e(var7);
         l[b * 16 + 14] = var14;
         l[b * 16 + 15] = var15;
         w[b] = var16;
         r[b] = var18 & -16711936 | (var18 & 16711680) >> 16 | (var18 & 255) << 16;
         ++b;
      }
   }

   static {
      l = new float[s * 16];
      w = new long[s];
      r = new int[s];
      v = new Object();
      y = false;
   }

   public static void q(long var0, float var2) {
      Lb33.g(Lb33.ProcessScript);

      try {
         Graphics.runPreGameplayScripts(var0, var2);
         Lb33.d(Lb33.ProcessScript);
      } finally {
         Lb33.d(Lb33.ProcessScript);
      }
   }
}
