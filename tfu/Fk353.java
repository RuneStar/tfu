package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fk353 implements Hp62 {
   public static final int d = 6;
   public static final int e = 2047;
   public static final float h = 2048.0F;
   public static final int j = 2048;
   public static final Ia63 k = new Fu461();
   private static final Logger logger = LoggerFactory.getLogger(Fk353.class);
   public static final int q = 11;
   public int[] b;
   public int[] l;
   public int m;
   public float n = 1.0F;
   public byte[] p;
   public short[] r;
   public int s;
   public int t;
   public int u;
   public short[] v;
   public int[] w;
   public byte[] x;
   public byte[] y;
   public Fp460[] z;
   // $FF: synthetic field
   static final boolean i = !Fk353.class.desiredAssertionStatus();

   public Fk353(byte[] var1) {
      Gg3 var2 = new Gg3(var1);
      Gg3 var3 = new Gg3(var1);
      Gg3 var4 = new Gg3(var1);
      Gg3 var5 = new Gg3(var1);
      Gg3 var6 = new Gg3(var1);
      Gg3 var7 = new Gg3(var1);
      Gg3 var8 = new Gg3(var1);
      Gg3 var9 = new Gg3(var1);
      Gg3 var10 = new Gg3(var1);
      int var11 = Gg3.ar(var2);
      if (var11 > 6) {
         throw new RuntimeException();
      } else {
         this.s = Gg3.au(var2);
         this.u = Gg3.au(var2);
         Gg3.au(var2);
         int var12 = Gg3.ay(var2);
         int var13 = Gg3.ay(var2);
         this.t = Gg3.ay(var2);
         int var14 = Gg3.ay(var2);
         int var15 = Gg3.ay(var2);
         int var16 = Gg3.ay(var2);
         int var17 = Gg3.ay(var2);
         int var18 = Gg3.ay(var2);
         int var19 = Gg3.ay(var2);
         int var20 = Gg3.ay(var2);
         int var21 = Gg3.ay(var2);
         if (var11 >= 6) {
            this.n = Gg3.bl(var2);
         }

         var3.v = var2.v + this.u * (var11 >= 4 ? 6 : 4);
         var4.v = var3.v + var12;
         var5.v = var4.v + var12 * 2;
         var6.v = var5.v + var12;
         var7.v = var6.v + var12;
         this.z = new Fp460[this.u];

         int var22;
         int var23;
         int var32;
         int var33;
         for(var22 = 0; var22 < this.u; ++var22) {
            var23 = Gg3.au(var2);
            Fp460 var24 = this.z[var22] = new Fp460(var23);
            short[] var25 = var24.e;
            short[] var26 = var24.h;
            short[] var27 = var24.s;
            var24.b = Gg3.au(var2);
            if (var24.b == 65535) {
               var24.b = -1;
            }

            if (var11 >= 4) {
               var24.l = Gg3.au(var2);
               if (var24.l == 65535) {
                  var24.l = -1;
               }
            }

            short var28 = 0;
            short var29 = 0;
            short var30 = 0;
            short var31 = 0;

            for(var32 = 0; var32 < var24.g; ++var32) {
               var33 = Gg3.ar(var6);
               int var34;
               if (var33 == 1) {
                  var34 = var11 >= 5 ? Gg3.bg(var7) : Gg3.by(var7);
                  int var35 = var11 >= 5 ? Gg3.bg(var7) : Gg3.by(var7);
                  int var36 = var11 >= 5 ? Gg3.bg(var7) : Gg3.by(var7);
                  var28 = (short)(var34 + var31);
                  var29 = (short)(var35 + var28);
                  var30 = (short)(var36 + var29);
                  var31 = var30;
                  var25[var32] = var28;
                  var26[var32] = var29;
                  var27[var32] = var30;
               }

               if (var33 == 2) {
                  var34 = var11 >= 5 ? Gg3.bg(var7) : Gg3.by(var7);
                  var29 = var30;
                  var30 = (short)(var34 + var31);
                  var31 = var30;
                  var25[var32] = var28;
                  var26[var32] = var29;
                  var27[var32] = var30;
               }

               if (var33 == 3) {
                  var34 = var11 >= 5 ? Gg3.bg(var7) : Gg3.by(var7);
                  var28 = var30;
                  var30 = (short)(var34 + var31);
                  var31 = var30;
                  var25[var32] = var28;
                  var26[var32] = var29;
                  var27[var32] = var30;
               }

               if (var33 == 4) {
                  var34 = var11 >= 5 ? Gg3.bg(var7) : Gg3.by(var7);
                  short var46 = var28;
                  var28 = var29;
                  var29 = var46;
                  var30 = (short)(var34 + var31);
                  var31 = var30;
                  var25[var32] = var28;
                  var26[var32] = var46;
                  var27[var32] = var30;
               }

               var24.j[var32] = Gg3.ax(var3);
               var24.d[var32] = var11 > 1 ? (short)Gg3.au(var4) : 127;
               var24.q[var32] = var11 > 1 ? Gg3.ax(var5) : -1;
               this.m += 3;
            }
         }

         var2.v = var7.v;
         var3.v = var2.v + this.s;
         var5.v = var3.v + var14;
         var6.v = var5.v + var15;
         var7.v = var6.v + var16;
         var8.v = var7.v + var17;
         this.r = new short[this.s];
         this.v = new short[this.s];
         this.b = new int[this.s];
         this.l = new int[this.s];
         this.w = new int[this.s];
         var22 = 0;
         var23 = 0;
         int var37 = 0;
         short var38 = 0;
         short var39 = 0;
         int var40;
         int var41;
         int var42;
         int var43;
         int var45;
         if (var11 > 1) {
            for(var40 = 0; var40 < this.s; ++var40) {
               var41 = Gg3.ar(var2);
               var42 = 0;
               if ((var41 & 1) != 0) {
                  var42 = Gg3.bg(var3);
               }

               var43 = 0;
               if ((var41 & 2) != 0) {
                  var43 = Gg3.bg(var5);
               }

               var45 = 0;
               if ((var41 & 4) != 0) {
                  var45 = Gg3.bg(var6);
               }

               var32 = 0;
               if ((var41 & 8) != 0) {
                  var32 = Gg3.bg(var7);
               }

               var33 = 0;
               if ((var41 & 16) != 0) {
                  var33 = Gg3.bg(var8);
               }

               this.r[var40] = (short)(var38 + var32);
               var38 = this.r[var40];
               this.v[var40] = (short)(var39 + var33);
               var39 = this.v[var40];
               this.b[var40] = var22 + var42;
               var22 = this.b[var40];
               this.l[var40] = var23 + var43;
               var23 = this.l[var40];
               this.w[var40] = var37 + var45;
               var37 = this.w[var40];
            }
         } else {
            for(var40 = 0; var40 < this.s; ++var40) {
               var41 = Gg3.ar(var2);
               var42 = 0;
               if ((var41 & 1) != 0) {
                  var42 = Gg3.by(var3);
               }

               var43 = 0;
               if ((var41 & 2) != 0) {
                  var43 = Gg3.by(var5);
               }

               var45 = 0;
               if ((var41 & 4) != 0) {
                  var45 = Gg3.by(var6);
               }

               var32 = 0;
               if ((var41 & 8) != 0) {
                  var32 = Gg3.by(var7);
               }

               var33 = 0;
               if ((var41 & 16) != 0) {
                  var33 = Gg3.by(var8);
               }

               this.r[var40] = (short)(var38 + var32);
               var38 = this.r[var40];
               this.v[var40] = (short)(var39 + var33);
               var39 = this.v[var40];
               this.b[var40] = var22 + var42;
               var22 = this.b[var40];
               this.l[var40] = var23 + var43;
               var23 = this.l[var40];
               this.w[var40] = var37 + var45;
               var37 = this.w[var40];
            }
         }

         if (var13 > 0) {
            this.p = new byte[var13];
            this.x = new byte[var13];
            this.y = new byte[this.s];
            var2.v = var8.v;
            var3.v = var2.v + this.s;
            var4.v = var3.v + var18;
            var5.v = var4.v + var19;
            var6.v = var5.v + var20;
            var7.v = var6.v + var21;
            var8.v = var7.v + var18;
            var9.v = var8.v + var19;
            var10.v = var9.v + var20;
            var40 = 0;

            for(var41 = 0; var41 < this.s; ++var41) {
               byte var44 = this.y[var41] = Gg3.ax(var2);
               if (var44 > 0) {
                  this.p[var40] = Gg3.ax(var3);
                  this.x[var40] = Gg3.ax(var7);
                  ++var40;
               }

               if (var44 > 1) {
                  this.p[var40] = Gg3.ax(var4);
                  this.x[var40] = Gg3.ax(var8);
                  ++var40;
               }

               if (var44 > 2) {
                  this.p[var40] = Gg3.ax(var5);
                  this.x[var40] = Gg3.ax(var9);
                  ++var40;
               }

               if (var44 > 3) {
                  this.p[var40] = Gg3.ax(var6);
                  this.x[var40] = Gg3.ax(var10);
                  ++var40;
               }
            }
         }

      }
   }

   public void onAllRefsReleased() {
   }

   public Fk353() {
   }
}
