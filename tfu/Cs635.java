package tfu;

public abstract class Cs635 extends Cx556 {
   protected static final boolean q = false;
   int b;
   int e;
   int h;
   int j;
   int l;
   int m;
   int p;
   int r;
   int s;
   boolean t;
   int u;
   int v;
   int x;
   int y;
   int z;

   public static final synchronized void bq(Cs635 var0, int var1) {
      var0.x = var1;
   }

   private static final int ay(int var0, int var1) {
      return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   protected final Cx556 d() {
      return null;
   }

   protected static final void bd(Cs635 var0) {
      var0.b = var0.h;
      var0.l = ay(var0.h, var0.s);
      var0.r = ad(var0.h, var0.s);
   }

   protected final int cd() {
      int var1 = this.b * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if (this.x == 0) {
         var1 -= var1 * this.j / (((Cw634)super.bm).g() << 8);
      } else if (this.x >= 0) {
         var1 -= var1 * this.u / ((Cw634)super.bm).g();
      }

      return var1 > 255 ? 255 : var1;
   }

   public static final synchronized void by(Cs635 var0, int var1, int var2) {
      br(var0, var1, var2, bj(var0));
   }

   public static final synchronized void bo(Cs635 var0, int var1) {
      bl(var0, var1, bj(var0));
   }

   private static final int ad(int var0, int var1) {
      return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   public static final synchronized int bw(Cs635 var0) {
      return var0.h == Integer.MIN_VALUE ? 0 : var0.h;
   }

   public static final synchronized int bj(Cs635 var0) {
      return var0.s < 0 ? -1 : var0.s;
   }

   protected final int q() {
      return this.h == 0 && this.m == 0 ? 0 : 1;
   }

   public static final synchronized boolean bp(Cs635 var0) {
      return var0.j < 0 || var0.j >= ((Cw634)var0.bm).g() << 8;
   }

   protected static final void bx(Cs635 var0) {
      if (var0.m != 0) {
         if (var0.h == Integer.MIN_VALUE) {
            var0.h = 0;
         }

         var0.m = 0;
         bd(var0);
      }

   }

   public static final synchronized void bh(Cs635 var0, boolean var1) {
      var0.e = (var0.e ^ var0.e >> 31) + (var0.e >>> 31);
      if (var1) {
         var0.e = -var0.e;
      }

   }

   public static final synchronized void br(Cs635 var0, int var1, int var2, int var3) {
      if (var1 == 0) {
         bl(var0, var2, var3);
      } else {
         int var4 = ay(var2, var3);
         int var5 = ad(var2, var3);
         if (var0.l == var4 && var0.r == var5) {
            var0.m = 0;
         } else {
            int var6 = var2 - var0.b;
            if (var0.b - var2 > var6) {
               var6 = var0.b - var2;
            }

            if (var4 - var0.l > var6) {
               var6 = var4 - var0.l;
            }

            if (var0.l - var4 > var6) {
               var6 = var0.l - var4;
            }

            if (var5 - var0.r > var6) {
               var6 = var5 - var0.r;
            }

            if (var0.r - var5 > var6) {
               var6 = var0.r - var5;
            }

            if (var1 > var6) {
               var1 = var6;
            }

            var0.m = var1;
            var0.h = var2;
            var0.s = var3;
            var0.v = (var2 - var0.b) / var1;
            var0.y = (var4 - var0.l) / var1;
            var0.p = (var5 - var0.r) / var1;
         }
      }
   }

   public static final synchronized void bl(Cs635 var0, int var1, int var2) {
      var0.h = var1;
      var0.s = var2;
      var0.m = 0;
      bd(var0);
   }

   public static final synchronized void bf(Cs635 var0, int var1) {
      if (var0.e < 0) {
         var0.e = -var1;
      } else {
         var0.e = var1;
      }

   }

   public static final synchronized int bn(Cs635 var0) {
      return var0.e < 0 ? -var0.e : var0.e;
   }

   public static final synchronized void bv(Cs635 var0, int var1) {
      if (var1 == 0) {
         bo(var0, 0);
         ef(var0);
      } else if (var0.l == 0 && var0.r == 0) {
         var0.m = 0;
         var0.h = 0;
         var0.b = 0;
         ef(var0);
      } else {
         int var2 = -var0.b;
         if (var0.b > var2) {
            var2 = var0.b;
         }

         if (-var0.l > var2) {
            var2 = -var0.l;
         }

         if (var0.l > var2) {
            var2 = var0.l;
         }

         if (-var0.r > var2) {
            var2 = -var0.r;
         }

         if (var0.r > var2) {
            var2 = var0.r;
         }

         if (var1 > var2) {
            var1 = var2;
         }

         var0.m = var1;
         var0.h = Integer.MIN_VALUE;
         var0.v = -var0.b / var1;
         var0.y = -var0.l / var1;
         var0.p = -var0.r / var1;
      }
   }

   protected final Cx556 g() {
      return null;
   }

   public abstract void j(int[] var1, int var2, int var3);

   public static final synchronized boolean bm(Cs635 var0) {
      return var0.m != 0;
   }

   public final synchronized void e(int var1) {
      if (this.m > 0) {
         if (var1 >= this.m) {
            if (this.h == Integer.MIN_VALUE) {
               this.h = 0;
               this.b = this.l = this.r = 0;
               ef(this);
               var1 = this.m;
            }

            this.m = 0;
            bd(this);
         } else {
            this.b += this.v * var1;
            this.l += this.y * var1;
            this.r += this.p * var1;
            this.m -= var1;
         }
      }

      int var2 = this.u << 8;
      int var3 = this.z << 8;
      int var4 = ((Cw634)super.bm).g() << 8;
      int var5 = var3 - var2;
      if (var5 <= 0) {
         this.x = 0;
      }

      if (this.j < 0) {
         if (this.e <= 0) {
            bx(this);
            ef(this);
            return;
         }

         this.j = 0;
      }

      if (this.j >= var4) {
         if (this.e >= 0) {
            bx(this);
            ef(this);
            return;
         }

         this.j = var4 - 1;
      }

      this.j += this.e * var1;
      if (this.x < 0) {
         if (!this.t) {
            if (this.e < 0) {
               if (this.j >= var2) {
                  return;
               }

               this.j = var3 - 1 - (var3 - 1 - this.j) % var5;
            } else {
               if (this.j < var3) {
                  return;
               }

               this.j = var2 + (this.j - var2) % var5;
            }

         } else {
            if (this.e < 0) {
               if (this.j >= var2) {
                  return;
               }

               this.j = var2 + var2 - 1 - this.j;
               this.e = -this.e;
            }

            while(this.j >= var3) {
               this.j = var3 + var3 - 1 - this.j;
               this.e = -this.e;
               if (this.j >= var2) {
                  return;
               }

               this.j = var2 + var2 - 1 - this.j;
               this.e = -this.e;
            }

         }
      } else {
         if (this.x > 0) {
            if (this.t) {
               label121: {
                  if (this.e < 0) {
                     if (this.j >= var2) {
                        return;
                     }

                     this.j = var2 + var2 - 1 - this.j;
                     this.e = -this.e;
                     if (--this.x == 0) {
                        break label121;
                     }
                  }

                  do {
                     if (this.j < var3) {
                        return;
                     }

                     this.j = var3 + var3 - 1 - this.j;
                     this.e = -this.e;
                     if (--this.x == 0) {
                        break;
                     }

                     if (this.j >= var2) {
                        return;
                     }

                     this.j = var2 + var2 - 1 - this.j;
                     this.e = -this.e;
                  } while(--this.x != 0);
               }
            } else {
               label153: {
                  int var6;
                  if (this.e < 0) {
                     if (this.j >= var2) {
                        return;
                     }

                     var6 = (var3 - 1 - this.j) / var5;
                     if (var6 >= this.x) {
                        this.j += var5 * this.x;
                        this.x = 0;
                        break label153;
                     }

                     this.j += var5 * var6;
                     this.x -= var6;
                  } else {
                     if (this.j < var3) {
                        return;
                     }

                     var6 = (this.j - var2) / var5;
                     if (var6 >= this.x) {
                        this.j -= var5 * this.x;
                        this.x = 0;
                        break label153;
                     }

                     this.j -= var5 * var6;
                     this.x -= var6;
                  }

                  return;
               }
            }
         }

         if (this.e < 0) {
            if (this.j < 0) {
               this.j = -1;
               bx(this);
               ef(this);
            }
         } else if (this.j >= var4) {
            this.j = var4;
            bx(this);
            ef(this);
         }

      }
   }

   protected static final boolean bg(Cs635 var0) {
      int var1 = var0.h;
      int var2;
      int var3;
      if (var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = ay(var1, var0.s);
         var3 = ad(var1, var0.s);
      }

      if (var0.b == var1 && var0.l == var2 && var0.r == var3) {
         if (var0.h == Integer.MIN_VALUE) {
            var0.h = 0;
            var0.b = var0.l = var0.r = 0;
            ef(var0);
            return true;
         } else {
            bd(var0);
            return false;
         }
      } else {
         if (var0.b < var1) {
            var0.v = 1;
            var0.m = var1 - var0.b;
         } else if (var0.b > var1) {
            var0.v = -1;
            var0.m = var0.b - var1;
         } else {
            var0.v = 0;
         }

         if (var0.l < var2) {
            var0.y = 1;
            if (var0.m == 0 || var0.m > var2 - var0.l) {
               var0.m = var2 - var0.l;
            }
         } else if (var0.l > var2) {
            var0.y = -1;
            if (var0.m == 0 || var0.m > var0.l - var2) {
               var0.m = var0.l - var2;
            }
         } else {
            var0.y = 0;
         }

         if (var0.r < var3) {
            var0.p = 1;
            if (var0.m == 0 || var0.m > var3 - var0.r) {
               var0.m = var3 - var0.r;
            }
         } else if (var0.r > var3) {
            var0.p = -1;
            if (var0.m == 0 || var0.m > var0.r - var3) {
               var0.m = var0.r - var3;
            }
         } else {
            var0.p = 0;
         }

         return false;
      }
   }

   public static final synchronized void bk(Cs635 var0, int var1) {
      int var2 = ((Cw634)var0.bm).g() << 8;
      if (var1 < -1) {
         var1 = -1;
      }

      if (var1 > var2) {
         var1 = var2;
      }

      var0.j = var1;
   }
}
