package tfu;

import com.jagex.core.stringtools.general.J173;
import java.math.BigInteger;
import java.util.UUID;

public class Gg3 extends Ln265 {
   public static final int b = 100;
   protected static final boolean e = true;
   private static final char[] h = new char[]{'\u0000', '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   public static final int l = 5000;
   private static final int p = -306674912;
   public static final int s = 50;
   private static final long u = -3932672073523589310L;
   public static final int w = 30000;
   public static long[] x;
   private static int[] y = new int[256];
   public byte[] r;
   public int v;

   public static String bk(Gg3 var0) {
      int var1 = var0.v;

      while(var0.r[var0.v++] != 0) {
      }

      int var2 = var0.v - var1 - 1;
      return var2 == 0 ? "" : J173.s(var0.r, var1, var2);
   }

   public static int m(byte[] var0, int var1) {
      return t(var0, 0, var1);
   }

   public Gg3(int var1) {
      this.r = Mv477.d(var1);
      this.v = 0;
   }

   public Gg3(byte[] var1) {
      this.r = var1;
      this.v = 0;
   }

   public Gg3(byte[] var1, int var2) {
      this.r = var1;
      this.v = var2;
   }

   public static void n(Gg3 var0) {
      if (var0.r != null) {
         Mv477.q(var0.r);
      }

      var0.r = null;
   }

   public static void k(Gg3 var0, int var1) {
      var0.r[var0.v++] = (byte)var1;
   }

   public static void i(Gg3 var0, int var1) {
      var0.r[var0.v++] = (byte)(var1 >> 8);
      var0.r[var0.v++] = (byte)var1;
   }

   public static void f(Gg3 var0, int var1) {
      var0.r[var0.v++] = (byte)var1;
      var0.r[var0.v++] = (byte)(var1 >> 8);
      var0.r[var0.v++] = (byte)(var1 >> 16);
      var0.r[var0.v++] = (byte)(var1 >> 24);
   }

   public static void ag(Gg3 var0, long var1) {
      var0.r[var0.v++] = (byte)((int)(var1 >> 56));
      var0.r[var0.v++] = (byte)((int)(var1 >> 48));
      var0.r[var0.v++] = (byte)((int)(var1 >> 40));
      var0.r[var0.v++] = (byte)((int)(var1 >> 32));
      var0.r[var0.v++] = (byte)((int)(var1 >> 24));
      var0.r[var0.v++] = (byte)((int)(var1 >> 16));
      var0.r[var0.v++] = (byte)((int)(var1 >> 8));
      var0.r[var0.v++] = (byte)((int)var1);
   }

   public static int al(String var0) {
      return var0.length() + 1;
   }

   public static void ai(Gg3 var0, double var1) {
      ag(var0, Double.doubleToRawLongBits(var1));
   }

   public void af(String var1) {
      int var2 = var1.indexOf(0);
      if (var2 >= 0) {
         throw new IllegalArgumentException("NUL character at " + var2 + " - cannot pjstr");
      } else {
         this.v += J173.e(var1, 0, var1.length(), this.r, this.v);
         this.r[this.v++] = 0;
      }
   }

   public static int av(String var0) {
      return var0.length() + 2;
   }

   public static void aq(Gg3 var0, float var1) {
      int var2 = Float.floatToIntBits(var1);
      a(var0, var2);
   }

   public static void ao(Gg3 var0, CharSequence var1) {
      int var2 = Mj383.g(var1);
      var0.r[var0.v++] = 0;
      ab(var0, var2);
      var0.v += Mj383.d(var0.r, var0.v, var1);
   }

   public static void aa(Gg3 var0, byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var0.r[var0.v++] = var1[var4];
      }

   }

   public static void an(Gg3 var0, Gg3 var1) {
      aa(var0, var1.r, 0, var1.v);
   }

   public static void am(Gg3 var0, int var1) {
      var0.r[var0.v - var1 - 4] = (byte)(var1 >> 24);
      var0.r[var0.v - var1 - 3] = (byte)(var1 >> 16);
      var0.r[var0.v - var1 - 2] = (byte)(var1 >> 8);
      var0.r[var0.v - var1 - 1] = (byte)var1;
   }

   public static void a(Gg3 var0, int var1) {
      var0.r[var0.v++] = (byte)(var1 >> 24);
      var0.r[var0.v++] = (byte)(var1 >> 16);
      var0.r[var0.v++] = (byte)(var1 >> 8);
      var0.r[var0.v++] = (byte)var1;
   }

   public static void ac(Gg3 var0, int var1) {
      var0.r[var0.v - var1 - 1] = (byte)var1;
   }

   public void at(int var1) {
      if (var1 >= 0 && var1 < 128) {
         k(this, var1);
      } else if (var1 >= 0 && var1 < 32768) {
         i(this, '耀' + var1);
      } else {
         throw new IllegalArgumentException("psmarts out of range - val:" + var1);
      }
   }

   public static void ab(Gg3 var0, int var1) {
      if ((var1 & -128) != 0) {
         if ((var1 & -16384) != 0) {
            if ((var1 & -2097152) != 0) {
               if ((var1 & -268435456) != 0) {
                  k(var0, var1 >>> 28 | 128);
               }

               k(var0, var1 >>> 21 | 128);
            }

            k(var0, var1 >>> 14 | 128);
         }

         k(var0, var1 >>> 7 | 128);
      }

      k(var0, var1 & 127);
   }

   public static void aw(Gg3 var0, int var1) {
      byte var3 = 6;
      byte var2;
      if (var1 < 0) {
         var1 = -var1;
         var2 = 64;
      } else {
         var2 = 0;
      }

      while(true) {
         int var4 = (1 << var3) - 1;
         int var5 = var1 > var4 ? 128 : 0;
         k(var0, var5 | var1 & var4 | var2);
         var1 >>= var3;
         if (var1 <= 0) {
            return;
         }

         var3 = 7;
         var2 = 0;
      }
   }

   public static int ar(Gg3 var0) {
      return var0.r[var0.v++] & 255;
   }

   public static int aj(Gg3 var0) {
      var0.v += 2;
      return ((var0.r[var0.v - 1] & 255) << 8) + (var0.r[var0.v - 2] & 255);
   }

   public static int ak(Gg3 var0) {
      var0.v += 2;
      int var1 = ((var0.r[var0.v - 2] & 255) << 8) + (var0.r[var0.v - 1] & 255);
      if (var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   public String bp() {
      byte var1 = this.r[this.v++];
      if (var1 != 0) {
         throw new IllegalStateException("Bad version number in gUTF8");
      } else {
         int var2 = bn(this);
         if (var2 + this.v > this.r.length) {
            throw new IllegalStateException("Length of string is longer than available data");
         } else {
            String var3 = Mj383.j(this.r, this.v, var2);
            this.v += var2;
            return var3;
         }
      }
   }

   public static int bd(Gg3 var0) {
      var0.v += 4;
      return ((var0.r[var0.v - 4] & 255) << 24) + ((var0.r[var0.v - 3] & 255) << 16) + ((var0.r[var0.v - 2] & 255) << 8) + (var0.r[var0.v - 1] & 255);
   }

   public static int bm(Gg3 var0) {
      var0.v += 4;
      return ((var0.r[var0.v - 1] & 255) << 24) + ((var0.r[var0.v - 2] & 255) << 16) + ((var0.r[var0.v - 3] & 255) << 8) + (var0.r[var0.v - 4] & 255);
   }

   public static long bq(Gg3 var0) {
      long var1 = (long)bd(var0) & 4294967295L;
      long var3 = (long)bd(var0) & 4294967295L;
      return (var1 << 32) + var3;
   }

   public UUID bo() {
      long var1 = bq(this);
      long var3 = bq(this);
      return new UUID(var1, var3);
   }

   public static float bl(Gg3 var0) {
      return Float.intBitsToFloat(bd(var0));
   }

   public static float bw(Gg3 var0) {
      return Float.intBitsToFloat(bm(var0));
   }

   public void ap(String var1) {
      int var2 = var1.indexOf(0);
      if (var2 >= 0) {
         throw new IllegalArgumentException("NUL character at " + var2 + " - cannot pjstr2");
      } else {
         this.r[this.v++] = 0;
         this.v += J173.e(var1, 0, var1.length(), this.r, this.v);
         this.r[this.v++] = 0;
      }
   }

   public String bh() {
      byte var1 = this.r[this.v++];
      if (var1 != 0) {
         throw new IllegalStateException("Bad version number in gjstr2");
      } else {
         int var2 = this.v;

         while(this.r[this.v++] != 0) {
         }

         int var3 = this.v - var2 - 1;
         return var3 == 0 ? "" : J173.s(this.r, var2, var3);
      }
   }

   public static void bx(Gg3 var0, byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = var0.r[var0.v++];
      }

   }

   public static int br(Gg3 var0) {
      int var1 = var0.r[var0.v] & 255;
      return var1 < 128 ? ar(var0) : au(var0) - '耀';
   }

   public static int bv(Gg3 var0) {
      return var0.r[var0.v] < 0 ? bd(var0) & Integer.MAX_VALUE : au(var0);
   }

   public static int bf(Gg3 var0) {
      if (var0.r[var0.v] < 0) {
         return bd(var0) & Integer.MAX_VALUE;
      } else {
         int var1 = au(var0);
         return var1 == 32767 ? -1 : var1;
      }
   }

   public static byte ax(Gg3 var0) {
      return var0.r[var0.v++];
   }

   public static int bg(Gg3 var0) {
      int var1 = ar(var0);
      int var2 = var1 & 63;
      int var3 = var1 & 64;

      for(int var4 = 6; var1 > 127; var4 += 7) {
         var1 = ar(var0);
         var2 |= (var1 & 127) << var4;
      }

      return var3 == 0 ? var2 : -var2;
   }

   public static void bu(Gg3 var0, int[] var1) {
      int var2 = var0.v / 8;
      var0.v = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = bd(var0);
         int var5 = bd(var0);
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         var0.v -= 8;
         a(var0, var4);
         a(var0, var5);
      }

   }

   public static void bb(Gg3 var0, int[] var1) {
      int var2 = var0.v / 8;
      var0.v = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = bd(var0);
         int var5 = bd(var0);
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3]) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         var0.v -= 8;
         a(var0, var4);
         a(var0, var5);
      }

   }

   public static void ba(Gg3 var0, int[] var1, int var2, int var3) {
      int var4 = var0.v;
      var0.v = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = bd(var0);
         int var8 = bd(var0);
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         var0.v -= 8;
         a(var0, var7);
         a(var0, var8);
      }

      var0.v = var4;
   }

   public static void bi(Gg3 var0, int[] var1, int var2, int var3) {
      int var4 = var0.v;
      var0.v = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = bd(var0);
         int var8 = bd(var0);
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3]) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         var0.v -= 8;
         a(var0, var7);
         a(var0, var8);
      }

      var0.v = var4;
   }

   public void bt(BigInteger var1, BigInteger var2) {
      int var3 = this.v;
      this.v = 0;
      byte[] var4 = new byte[var3];
      bx(this, var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.v = 0;
      i(this, var7.length);
      aa(this, var7, 0, var7.length);
   }

   static {
      int var2;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var0 = var1;

         for(var2 = 0; var2 < 8; ++var2) {
            if ((var0 & 1) == 1) {
               var0 = var0 >>> 1 ^ -306674912;
            } else {
               var0 >>>= 1;
            }
         }

         y[var1] = var0;
      }

      x = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if ((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         x[var2] = var4;
      }

   }

   public static void c(Gg3 var0, long var1) {
      var0.r[var0.v++] = (byte)((int)(var1 >> 32));
      var0.r[var0.v++] = (byte)((int)(var1 >> 24));
      var0.r[var0.v++] = (byte)((int)(var1 >> 16));
      var0.r[var0.v++] = (byte)((int)(var1 >> 8));
      var0.r[var0.v++] = (byte)((int)var1);
   }

   public static int bn(Gg3 var0) {
      byte var1 = var0.r[var0.v++];

      int var2;
      for(var2 = 0; var1 < 0; var1 = var0.r[var0.v++]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   public static String bj(Gg3 var0) {
      if (var0.r[var0.v] == 0) {
         ++var0.v;
         return null;
      } else {
         return bk(var0);
      }
   }

   public static int au(Gg3 var0) {
      var0.v += 2;
      return ((var0.r[var0.v - 2] & 255) << 8) + (var0.r[var0.v - 1] & 255);
   }

   public static int by(Gg3 var0) {
      int var1 = var0.r[var0.v] & 255;
      return var1 < 128 ? ar(var0) - 64 : au(var0) - '쀀';
   }

   public static int bz(Gg3 var0, int var1) {
      int var2 = t(var0.r, var1, var0.v);
      a(var0, var2);
      return var2;
   }

   public static int ay(Gg3 var0) {
      var0.v += 3;
      return ((var0.r[var0.v - 3] & 255) << 16) + ((var0.r[var0.v - 2] & 255) << 8) + (var0.r[var0.v - 1] & 255);
   }

   public static void as(Gg3 var0, int var1) {
      var0.r[var0.v - var1 - 2] = (byte)(var1 >> 8);
      var0.r[var0.v - var1 - 1] = (byte)var1;
   }

   public static void o(Gg3 var0, int var1) {
      var0.r[var0.v++] = (byte)(var1 >> 16);
      var0.r[var0.v++] = (byte)(var1 >> 8);
      var0.r[var0.v++] = (byte)var1;
   }

   public static int t(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ y[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   public static int ad(Gg3 var0) {
      var0.v += 3;
      int var1 = ((var0.r[var0.v - 3] & 255) << 16) + ((var0.r[var0.v - 2] & 255) << 8) + (var0.r[var0.v - 1] & 255);
      if (var1 > 8388607) {
         var1 -= 16777216;
      }

      return var1;
   }

   public static boolean bc(Gg3 var0) {
      var0.v -= 4;
      int var1 = t(var0.r, 0, var0.v);
      int var2 = bd(var0);
      return var1 == var2;
   }
}
