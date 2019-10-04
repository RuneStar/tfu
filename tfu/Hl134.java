package tfu;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;

public final class Hl134 {
   private static final boolean g = true;
   private static byte[] q = new byte[520];
   private Im133 d = null;
   private int e;
   private int h = 65000;
   private Im133 j = null;
   File[] s = new File[256];

   public static byte[] g(Hl134 var0, int var1) {
      Im133 var2 = var0.j;
      synchronized(var2) {
         try {
            if (var0.d.q() < (long)(var1 * 6 + 6)) {
               return null;
            } else {
               var0.d.d((long)(var1 * 6));
               var0.d.h(q, 0, 6);
               int var3 = ((q[0] & 255) << 16) + ((q[1] & 255) << 8) + (q[2] & 255);
               int var4 = ((q[3] & 255) << 16) + ((q[4] & 255) << 8) + (q[5] & 255);
               if (var3 >= 0 && var3 <= var0.h) {
                  if (var4 > 0 && (long)var4 <= var0.j.q() / 520L) {
                     byte[] var5 = new byte[var3];
                     int var6 = 0;
                     int var7 = 0;

                     while(var6 < var3) {
                        if (var4 == 0) {
                           return null;
                        }

                        var0.j.d((long)var4 * 520L);
                        int var8 = var3 - var6;
                        int var9;
                        int var10;
                        int var11;
                        int var12;
                        byte var13;
                        if (var1 > 65535) {
                           if (var8 > 510) {
                              var8 = 510;
                           }

                           var13 = 10;
                           var0.j.h(q, 0, var8 + var13);
                           var9 = ((q[0] & 255) << 24) + ((q[1] & 255) << 16) + ((q[2] & 255) << 8) + (q[3] & 255);
                           var10 = ((q[4] & 255) << 8) + (q[5] & 255);
                           var11 = ((q[6] & 255) << 16) + ((q[7] & 255) << 8) + (q[8] & 255);
                           var12 = q[9] & 255;
                        } else {
                           if (var8 > 512) {
                              var8 = 512;
                           }

                           var13 = 8;
                           var0.j.h(q, 0, var8 + var13);
                           var9 = ((q[0] & 255) << 8) + (q[1] & 255);
                           var10 = ((q[2] & 255) << 8) + (q[3] & 255);
                           var11 = ((q[4] & 255) << 16) + ((q[5] & 255) << 8) + (q[6] & 255);
                           var12 = q[7] & 255;
                        }

                        if (var9 == var1 && var10 == var7 && var12 == var0.e) {
                           if (var11 >= 0 && (long)var11 <= var0.j.q() / 520L) {
                              int var14 = var13 + var8;

                              for(int var15 = var13; var15 < var14; ++var15) {
                                 var5[var6++] = q[var15];
                              }

                              var4 = var11;
                              ++var7;
                              continue;
                           }

                           return null;
                        }

                        return null;
                     }

                     byte[] var10000 = var5;
                     return var10000;
                  } else {
                     return null;
                  }
               } else {
                  return null;
               }
            }
         } catch (IOException var17) {
            var17.printStackTrace();
            return null;
         }
      }
   }

   private static boolean q(Hl134 var0, int var1, byte[] var2, int var3, boolean var4) {
      Im133 var5 = var0.j;
      synchronized(var5) {
         boolean var10000;
         try {
            int var6;
            if (var4) {
               if (var0.d.q() < (long)(var1 * 6 + 6)) {
                  return false;
               }

               var0.d.d((long)(var1 * 6));
               var0.d.h(q, 0, 6);
               var6 = ((q[3] & 255) << 16) + ((q[4] & 255) << 8) + (q[5] & 255);
               if (var6 <= 0 || (long)var6 > var0.j.q() / 520L) {
                  return false;
               }
            } else {
               var6 = (int)((var0.j.q() + 519L) / 520L);
               if (var6 == 0) {
                  var6 = 1;
               }
            }

            q[0] = (byte)(var3 >> 16);
            q[1] = (byte)(var3 >> 8);
            q[2] = (byte)var3;
            q[3] = (byte)(var6 >> 16);
            q[4] = (byte)(var6 >> 8);
            q[5] = (byte)var6;
            var0.d.d((long)(var1 * 6));
            Im133.b(var0.d, q, 0, 6);
            int var7 = 0;

            for(int var8 = 0; var7 < var3; ++var8) {
               int var9 = 0;
               int var10;
               if (var4) {
                  label110: {
                     var0.j.d((long)var6 * 520L);
                     int var11;
                     int var12;
                     if (var1 > 65535) {
                        try {
                           var0.j.h(q, 0, 10);
                        } catch (EOFException var16) {
                           break;
                        }

                        var10 = ((q[0] & 255) << 24) + ((q[1] & 255) << 16) + ((q[2] & 255) << 8) + (q[3] & 255);
                        var11 = ((q[4] & 255) << 8) + (q[5] & 255);
                        var9 = ((q[6] & 255) << 16) + ((q[7] & 255) << 8) + (q[8] & 255);
                        var12 = q[9] & 255;
                     } else {
                        try {
                           var0.j.h(q, 0, 8);
                        } catch (EOFException var15) {
                           break;
                        }

                        var10 = ((q[0] & 255) << 8) + (q[1] & 255);
                        var11 = ((q[2] & 255) << 8) + (q[3] & 255);
                        var9 = ((q[4] & 255) << 16) + ((q[5] & 255) << 8) + (q[6] & 255);
                        var12 = q[7] & 255;
                     }

                     if (var10 == var1 && var11 == var8 && var12 == var0.e) {
                        if (var9 >= 0 && (long)var9 <= var0.j.q() / 520L) {
                           break label110;
                        }

                        return false;
                     }

                     return false;
                  }
               }

               if (var9 == 0) {
                  var4 = false;
                  var9 = (int)((var0.j.q() + 519L) / 520L);
                  if (var9 == 0) {
                     ++var9;
                  }

                  if (var9 == var6) {
                     ++var9;
                  }
               }

               if (var3 - var7 <= 512) {
                  var9 = 0;
               }

               if (var1 > 65535) {
                  q[0] = (byte)(var1 >> 24);
                  q[1] = (byte)(var1 >> 16);
                  q[2] = (byte)(var1 >> 8);
                  q[3] = (byte)var1;
                  q[4] = (byte)(var8 >> 8);
                  q[5] = (byte)var8;
                  q[6] = (byte)(var9 >> 16);
                  q[7] = (byte)(var9 >> 8);
                  q[8] = (byte)var9;
                  q[9] = (byte)var0.e;
                  var0.j.d((long)var6 * 520L);
                  Im133.b(var0.j, q, 0, 10);
                  var10 = var3 - var7;
                  if (var10 > 510) {
                     var10 = 510;
                  }

                  Im133.b(var0.j, var2, var7, var10);
                  var7 += var10;
               } else {
                  q[0] = (byte)(var1 >> 8);
                  q[1] = (byte)var1;
                  q[2] = (byte)(var8 >> 8);
                  q[3] = (byte)var8;
                  q[4] = (byte)(var9 >> 16);
                  q[5] = (byte)(var9 >> 8);
                  q[6] = (byte)var9;
                  q[7] = (byte)var0.e;
                  var0.j.d((long)var6 * 520L);
                  Im133.b(var0.j, q, 0, 8);
                  var10 = var3 - var7;
                  if (var10 > 512) {
                     var10 = 512;
                  }

                  Im133.b(var0.j, var2, var7, var10);
                  var7 += var10;
               }

               var6 = var9;
            }

            var10000 = true;
         } catch (IOException var17) {
            var17.printStackTrace();
            return false;
         }

         return var10000;
      }
   }

   public String toString() {
      return "Cache:" + this.e;
   }

   public boolean d(int var1, byte[] var2, int var3) {
      Im133 var4 = this.j;
      synchronized(var4) {
         if (var3 >= 0 && var3 <= this.h) {
            boolean var5 = q(this, var1, var2, var3, true);
            if (!var5) {
               var5 = q(this, var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException("Error in filesystem_client.save invalid len - len:" + var3 + " maxlen:" + this.h);
         }
      }
   }

   public Hl134(int var1, Im133 var2, Im133 var3, int var4) {
      this.e = var1;
      this.j = var2;
      this.d = var3;
      this.h = var4;
      if (this.s[var1] != null && !this.s[var1].equals(Im133.j(var3))) {
         throw new RuntimeException("filesystem_client: duplicate fsid - fsid:" + this.e + " idx1:" + this.s[var1] + " idx2:" + Im133.j(var3));
      } else {
         this.s[var1] = Im133.j(var3);
      }
   }
}
