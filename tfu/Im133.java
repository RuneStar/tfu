package tfu;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;

public class Im133 {
   private static final boolean d = true;
   private static final boolean g = false;
   private static final int j = 200000000;
   private static final boolean q = true;
   private byte[] b;
   private Is139 e;
   private int h;
   private long l = -1L;
   private long p;
   private byte[] r;
   private int s;
   private long u;
   private long v = -1L;
   private int w;
   private long x;
   private int y = 0;
   private long z;

   private static void w(Im133 var0, long var1) throws IOException {
      long var3 = (var1 + (long)var0.h - 1L) / (long)var0.h * (long)var0.h + (long)var0.s;
      Is139.s(var0.e, var3);
      var0.x = var3;
   }

   public static void g(Im133 var0) throws IOException {
      l(var0);
      Is139.j(var0.e);
   }

   public Im133(Is139 var1, int var2, int var3) throws IOException {
      this.e = var1;
      this.u = this.x = Is139.e(var1);
      this.b = new byte[var2];
      this.r = new byte[var3];
      this.h = 0;
      this.s = 0;
      this.p = 0L;
   }

   public long q() {
      if (this.h > 0) {
         throw new IllegalArgumentException("Cannot calculate simulated length because prealloc is on");
      } else {
         return this.u;
      }
   }

   public static final File j(Im133 var0) {
      return Is139.g(var0.e);
   }

   public void h(byte[] var1, int var2, int var3) throws IOException {
      try {
         if (var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if (this.v != -1L && this.p >= this.v && this.p + (long)var3 <= this.v + (long)this.y) {
            System.arraycopy(this.r, (int)(this.p - this.v), var1, var2, var3);
            this.p += (long)var3;
            return;
         }

         long var4 = this.p;
         int var7 = var3;
         int var8;
         if (this.p >= this.l && this.p < this.l + (long)this.w) {
            var8 = (int)((long)this.w - (this.p - this.l));
            if (var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.b, (int)(this.p - this.l), var1, var2, var8);
            this.p += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if (var3 > this.b.length) {
            Is139.d(this.e, this.p);

            for(this.z = this.p; var3 > 0; var3 -= var8) {
               var8 = Is139.h(this.e, var1, var2, var3);
               if (var8 == -1) {
                  break;
               }

               this.z += (long)var8;
               this.p += (long)var8;
               var2 += var8;
            }
         } else if (var3 > 0) {
            s(this);
            var8 = var3;
            if (var3 > this.w) {
               var8 = this.w;
            }

            System.arraycopy(this.b, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.p += (long)var8;
         }

         if (this.v != -1L) {
            if (this.v > this.p && var3 > 0) {
               var8 = var2 + (int)(this.v - this.p);
               if (var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.p;
               }
            }

            long var14 = -1L;
            long var10 = -1L;
            if (this.v >= var4 && this.v < var4 + (long)var7) {
               var14 = this.v;
            } else if (var4 >= this.v && var4 < this.v + (long)this.y) {
               var14 = var4;
            }

            if (this.v + (long)this.y > var4 && this.v + (long)this.y <= var4 + (long)var7) {
               var10 = this.v + (long)this.y;
            } else if (var4 + (long)var7 > this.v && var4 + (long)var7 <= this.v + (long)this.y) {
               var10 = var4 + (long)var7;
            }

            if (var14 > -1L && var10 > var14) {
               int var12 = (int)(var10 - var14);
               System.arraycopy(this.r, (int)(var14 - this.v), var1, var2 + (int)(var14 - var4), var12);
               if (var10 > this.p) {
                  var3 = (int)((long)var3 - (var10 - this.p));
                  this.p = var10;
               }
            }
         }
      } catch (IOException var13) {
         this.z = -1L;
         throw var13;
      }

      if (var3 > 0) {
         throw new EOFException();
      }
   }

   private static void s(Im133 var0) throws IOException {
      var0.w = 0;
      if (var0.z != var0.p) {
         Is139.d(var0.e, var0.p);
         var0.z = var0.p;
      }

      int var2;
      for(var0.l = var0.p; var0.w < var0.b.length; var0.w += var2) {
         int var1 = var0.b.length - var0.w;
         if (var1 > 200000000) {
            var1 = 200000000;
         }

         var2 = Is139.h(var0.e, var0.b, var0.w, var1);
         if (var2 == -1) {
            break;
         }

         var0.z += (long)var2;
      }

   }

   public static void b(Im133 var0, byte[] var1, int var2, int var3) throws IOException {
      try {
         if (var0.p + (long)var3 > var0.u) {
            var0.u = var0.p + (long)var3;
         }

         if (var0.v != -1L && (var0.p < var0.v || var0.p > var0.v + (long)var0.y)) {
            l(var0);
         }

         if (var0.v != -1L && var0.p + (long)var3 > var0.v + (long)var0.r.length) {
            int var4 = (int)((long)var0.r.length - (var0.p - var0.v));
            System.arraycopy(var1, var2, var0.r, (int)(var0.p - var0.v), var4);
            var0.p += (long)var4;
            var2 += var4;
            var3 -= var4;
            var0.y = var0.r.length;
            l(var0);
         }

         if (var3 > var0.r.length) {
            if (var0.z != var0.p) {
               Is139.d(var0.e, var0.p);
               var0.z = var0.p;
            }

            if (var0.h > 0 && var0.z + (long)var3 > var0.x) {
               w(var0, var0.z + (long)var3);
            }

            var0.e.q(var1, var2, var3);
            var0.z += (long)var3;
            if (var0.z > var0.x) {
               var0.x = var0.z;
            }

            long var10 = -1L;
            long var6 = -1L;
            if (var0.p >= var0.l && var0.p < var0.l + (long)var0.w) {
               var10 = var0.p;
            } else if (var0.l >= var0.p && var0.l < var0.p + (long)var3) {
               var10 = var0.l;
            }

            if (var0.p + (long)var3 > var0.l && var0.p + (long)var3 <= var0.l + (long)var0.w) {
               var6 = var0.p + (long)var3;
            } else if (var0.l + (long)var0.w > var0.p && var0.l + (long)var0.w <= var0.p + (long)var3) {
               var6 = var0.l + (long)var0.w;
            }

            if (var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)((long)var2 + var10 - var0.p), var0.b, (int)(var10 - var0.l), var8);
            }

            var0.p += (long)var3;
         } else if (var3 > 0) {
            if (var0.v == -1L) {
               var0.v = var0.p;
            }

            System.arraycopy(var1, var2, var0.r, (int)(var0.p - var0.v), var3);
            var0.p += (long)var3;
            if (var0.p - var0.v > (long)var0.y) {
               var0.y = (int)(var0.p - var0.v);
            }

         }
      } catch (IOException var9) {
         var0.z = -1L;
         throw var9;
      }
   }

   public static void l(Im133 var0) throws IOException {
      if (var0.v != -1L) {
         if (var0.z != var0.v) {
            Is139.d(var0.e, var0.v);
            var0.z = var0.v;
         }

         if (var0.h > 0 && var0.z + (long)var0.y > var0.x) {
            w(var0, var0.z + (long)var0.y);
         }

         var0.e.q(var0.r, 0, var0.y);
         if (Io438.g(Is139.g(var0.e))) {
            Is139.b(var0.e);
         }

         var0.z += (long)var0.y;
         if (var0.z > var0.x) {
            var0.x = var0.z;
         }

         long var1 = -1L;
         long var3 = -1L;
         if (var0.v >= var0.l && var0.v < var0.l + (long)var0.w) {
            var1 = var0.v;
         } else if (var0.l >= var0.v && var0.l < var0.v + (long)var0.y) {
            var1 = var0.l;
         }

         if (var0.v + (long)var0.y > var0.l && var0.v + (long)var0.y <= var0.l + (long)var0.w) {
            var3 = var0.v + (long)var0.y;
         } else if (var0.l + (long)var0.w > var0.v && var0.l + (long)var0.w <= var0.v + (long)var0.y) {
            var3 = var0.l + (long)var0.w;
         }

         if (var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(var0.r, (int)(var1 - var0.v), var0.b, (int)(var1 - var0.l), var5);
         }

         var0.v = -1L;
         var0.y = 0;
      }

   }

   public static void e(Im133 var0, byte[] var1) throws IOException {
      var0.h(var1, 0, var1.length);
   }

   public void d(long var1) throws IOException {
      if (var1 < 0L) {
         throw new IOException();
      } else {
         this.p = var1;
      }
   }

   public Im133(File var1, String var2, int var3, int var4, int var5, int var6) throws IOException {
      this.e = new Is139(var1, var2, -1L);
      this.u = this.x = var1.length();
      this.b = new byte[var3];
      this.r = new byte[var4];
      this.h = var5;
      this.s = var6;
      this.p = 0L;
   }
}
