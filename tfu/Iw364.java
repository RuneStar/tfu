package tfu;

public class Iw364 {
   public static final int d = 64;
   private static long[][] e = new long[8][256];
   public static final int g = 512;
   private static long[] h = new long[11];
   private static final String j = "ᠣ웨螸ŏ㚦틵祯酒悼鮎ꌌ笵ᷠퟂ\u2e4b﹗ᕷ㟥\u9ff0䫚壉⤊놠殅뵝ჴ쬾է\ue427䆋Ᵹ闘ﯮ籦\udd17䞞쨭뼇굚茳挂ꩱ젙䧙\uf2e3守騦㊰\ue90f햀뻍㑈ｺ遟\u2068\u1aae둔錢擱猒䀈쏬\udba1贽需켫皂혛떯橐䗳ワ㽕ꋪ斺⿀\ude1c\ufd4d鉵ڊ닦ฟ拔ꢖ暈╙葲㥌幸㢌톥\ue261댡鰞䏇ﰄ写洍\ufadf縤㮫츑轎럫㲁铷뤓ⳓ\ue76e쐃噄義⪻셓\udc0b鵬ㅴ\uf646겉ᓡᘺ椉炶탭챂颤⡜\uf886";
   protected static final int q = 10;
   protected byte[] b = new byte[64];
   protected int l = 0;
   protected long[] p = new long[8];
   protected long[] r = new long[8];
   protected byte[] s = new byte[32];
   protected long[] v = new long[8];
   protected int w = 0;
   protected long[] x = new long[8];
   protected long[] y = new long[8];

   public static byte[] e(byte[] var0, int var1, int var2) {
      byte[] var3;
      if (var1 > 0) {
         var3 = new byte[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var0[var1 + var4];
         }
      } else {
         var3 = var0;
      }

      Iw364 var6 = new Iw364();
      d(var6);
      var6.q(var3, (long)(var2 * 8));
      byte[] var5 = new byte[64];
      j(var6, var5, 0);
      return var5;
   }

   protected static void g(Iw364 var0) {
      int var1 = 0;

      int var2;
      for(var2 = 0; var1 < 8; var2 += 8) {
         var0.p[var1] = (long)var0.b[var2] << 56 ^ ((long)var0.b[var2 + 1] & 255L) << 48 ^ ((long)var0.b[var2 + 2] & 255L) << 40 ^ ((long)var0.b[var2 + 3] & 255L) << 32 ^ ((long)var0.b[var2 + 4] & 255L) << 24 ^ ((long)var0.b[var2 + 5] & 255L) << 16 ^ ((long)var0.b[var2 + 6] & 255L) << 8 ^ (long)var0.b[var2 + 7] & 255L;
         ++var1;
      }

      for(var1 = 0; var1 < 8; ++var1) {
         var0.x[var1] = var0.p[var1] ^ (var0.v[var1] = var0.r[var1]);
      }

      long[] var10000;
      for(var1 = 1; var1 <= 10; ++var1) {
         int var3;
         int var4;
         for(var2 = 0; var2 < 8; ++var2) {
            var0.y[var2] = 0L;
            var3 = 0;

            for(var4 = 56; var3 < 8; var4 -= 8) {
               var10000 = var0.y;
               var10000[var2] ^= e[var3][(int)(var0.v[var2 - var3 & 7] >>> var4) & 255];
               ++var3;
            }
         }

         for(var2 = 0; var2 < 8; ++var2) {
            var0.v[var2] = var0.y[var2];
         }

         var10000 = var0.v;
         var10000[0] ^= h[var1];

         for(var2 = 0; var2 < 8; ++var2) {
            var0.y[var2] = var0.v[var2];
            var3 = 0;

            for(var4 = 56; var3 < 8; var4 -= 8) {
               var10000 = var0.y;
               var10000[var2] ^= e[var3][(int)(var0.x[var2 - var3 & 7] >>> var4) & 255];
               ++var3;
            }
         }

         for(var2 = 0; var2 < 8; ++var2) {
            var0.x[var2] = var0.y[var2];
         }
      }

      for(var1 = 0; var1 < 8; ++var1) {
         var10000 = var0.r;
         var10000[var1] ^= var0.x[var1] ^ var0.p[var1];
      }

   }

   public static void d(Iw364 var0) {
      int var1;
      for(var1 = 0; var1 < 32; ++var1) {
         var0.s[var1] = 0;
      }

      var0.l = var0.w = 0;
      var0.b[0] = 0;

      for(var1 = 0; var1 < 8; ++var1) {
         var0.r[var1] = 0L;
      }

   }

   public void q(byte[] var1, long var2) {
      int var4 = 0;
      int var5 = 8 - ((int)var2 & 7) & 7;
      int var6 = this.l & 7;
      long var8 = var2;
      int var10 = 31;

      for(int var11 = 0; var10 >= 0; --var10) {
         var11 += (this.s[var10] & 255) + ((int)var8 & 255);
         this.s[var10] = (byte)var11;
         var11 >>>= 8;
         var8 >>>= 8;
      }

      byte[] var10000;
      int var10001;
      int var7;
      while(var2 > 8L) {
         var7 = var1[var4] << var5 & 255 | (var1[var4 + 1] & 255) >>> 8 - var5;
         if (var7 < 0 || var7 >= 256) {
            throw new RuntimeException();
         }

         var10000 = this.b;
         var10001 = this.w;
         var10000[var10001] = (byte)(var10000[var10001] | var7 >>> var6);
         ++this.w;
         this.l += 8 - var6;
         if (this.l == 512) {
            g(this);
            this.l = this.w = 0;
         }

         this.b[this.w] = (byte)(var7 << 8 - var6 & 255);
         this.l += var6;
         var2 -= 8L;
         ++var4;
      }

      if (var2 > 0L) {
         var7 = var1[var4] << var5 & 255;
         var10000 = this.b;
         var10001 = this.w;
         var10000[var10001] = (byte)(var10000[var10001] | var7 >>> var6);
      } else {
         var7 = 0;
      }

      if ((long)var6 + var2 < 8L) {
         this.l = (int)((long)this.l + var2);
      } else {
         ++this.w;
         this.l += 8 - var6;
         var2 -= (long)(8 - var6);
         if (this.l == 512) {
            g(this);
            this.l = this.w = 0;
         }

         this.b[this.w] = (byte)(var7 << 8 - var6 & 255);
         this.l += (int)var2;
      }

   }

   public static void j(Iw364 var0, byte[] var1, int var2) {
      byte[] var10000 = var0.b;
      int var10001 = var0.w;
      var10000[var10001] = (byte)(var10000[var10001] | 128 >>> (var0.l & 7));
      ++var0.w;
      if (var0.w > 32) {
         while(true) {
            if (var0.w >= 64) {
               g(var0);
               var0.w = 0;
               break;
            }

            var0.b[var0.w++] = 0;
         }
      }

      while(var0.w < 32) {
         var0.b[var0.w++] = 0;
      }

      System.arraycopy(var0.s, 0, var0.b, 32, 32);
      g(var0);
      int var3 = 0;

      for(int var4 = var2; var3 < 8; var4 += 8) {
         long var5 = var0.r[var3];
         var1[var4] = (byte)((int)(var5 >>> 56));
         var1[var4 + 1] = (byte)((int)(var5 >>> 48));
         var1[var4 + 2] = (byte)((int)(var5 >>> 40));
         var1[var4 + 3] = (byte)((int)(var5 >>> 32));
         var1[var4 + 4] = (byte)((int)(var5 >>> 24));
         var1[var4 + 5] = (byte)((int)(var5 >>> 16));
         var1[var4 + 6] = (byte)((int)(var5 >>> 8));
         var1[var4 + 7] = (byte)((int)var5);
         ++var3;
      }

   }

   static {
      int var0;
      for(var0 = 0; var0 < 256; ++var0) {
         char var1 = "ᠣ웨螸ŏ㚦틵祯酒悼鮎ꌌ笵ᷠퟂ\u2e4b﹗ᕷ㟥\u9ff0䫚壉⤊놠殅뵝ჴ쬾է\ue427䆋Ᵹ闘ﯮ籦\udd17䞞쨭뼇굚茳挂ꩱ젙䧙\uf2e3守騦㊰\ue90f햀뻍㑈ｺ遟\u2068\u1aae둔錢擱猒䀈쏬\udba1贽需켫皂혛떯橐䗳ワ㽕ꋪ斺⿀\ude1c\ufd4d鉵ڊ닦ฟ拔ꢖ暈╙葲㥌幸㢌톥\ue261댡鰞䏇ﰄ写洍\ufadf縤㮫츑轎럫㲁铷뤓ⳓ\ue76e쐃噄義⪻셓\udc0b鵬ㅴ\uf646겉ᓡᘺ椉炶탭챂颤⡜\uf886".charAt(var0 / 2);
         long var2 = (var0 & 1) == 0 ? (long)(var1 >>> 8) : (long)(var1 & 255);
         long var4 = var2 << 1;
         if (var4 >= 256L) {
            var4 ^= 285L;
         }

         long var6 = var4 << 1;
         if (var6 >= 256L) {
            var6 ^= 285L;
         }

         long var8 = var6 ^ var2;
         long var10 = var6 << 1;
         if (var10 >= 256L) {
            var10 ^= 285L;
         }

         long var12 = var10 ^ var2;
         e[0][var0] = var2 << 56 | var2 << 48 | var6 << 40 | var2 << 32 | var10 << 24 | var8 << 16 | var4 << 8 | var12;

         for(int var14 = 1; var14 < 8; ++var14) {
            e[var14][var0] = e[var14 - 1][var0] >>> 8 | e[var14 - 1][var0] << 56;
         }
      }

      h[0] = 0L;

      for(var0 = 1; var0 <= 10; ++var0) {
         int var15 = 8 * (var0 - 1);
         h[var0] = e[0][var15] & -72057594037927936L ^ e[1][var15 + 1] & 71776119061217280L ^ e[2][var15 + 2] & 280375465082880L ^ e[3][var15 + 3] & 1095216660480L ^ e[4][var15 + 4] & 4278190080L ^ e[5][var15 + 5] & 16711680L ^ e[6][var15 + 6] & 65280L ^ e[7][var15 + 7] & 255L;
      }

   }
}
