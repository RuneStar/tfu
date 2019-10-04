package rs2.client;

import com.jagex.game.runetek6.client.GameShell3;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rs2.client.loading.Q162;
import tfu.Gz143;

class B402 {
   Image b;
   BufferedImage[] d;
   Canvas e;
   private Thread g;
   Q162 h;
   private int i = 0;
   private Runnable j = new S401(this);
   private long k = 0L;
   Image l;
   private long m = 0L;
   private long n = 0L;
   private int p = 0;
   volatile boolean q;
   private int r = 0;
   Font s;
   private int t = 0;
   private int u = 0;
   private int v = 0;
   private int w = 0;
   private int x = 0;
   private int y = 0;
   private boolean z = true;

   public List g() {
      ArrayList var1 = new ArrayList();
      var1.add("loadingscreen_box_anim.png");

      for(int var2 = 1; var2 <= 4; ++var2) {
         var1.add("loadingscreen_middle" + String.format("%02d", var2) + ".png");
      }

      var1.add("loadingscreen_top.png");
      var1.add("loadingscreen_bottom.png");
      return var1;
   }

   public void d(Canvas var1, Q162 var2, int var3, int var4, List var5) {
      if (this.g == null) {
         this.d = new BufferedImage[7];
         int var6 = 0;

         BufferedImage var8;
         for(Iterator var7 = var5.iterator(); var7.hasNext(); this.d[var6++] = var8) {
            var8 = (BufferedImage)var7.next();
            if (var6 >= this.d.length) {
               break;
            }
         }

         j(this, var1, var2, var3, var4);
         MediaTracker var10 = new MediaTracker(this.e);

         for(int var11 = 0; var11 < this.d.length; ++var11) {
            var10.addImage(this.d[var11], var11);
         }

         try {
            var10.waitForAll();
         } catch (InterruptedException var9) {
            var9.printStackTrace();
         }

         this.v = 0;
         this.z = true;
         this.g = new Thread(this.j);
         this.g.start();
         this.k = Gz143.g() + 40000L;
         this.i = 1;
      }

   }

   static void e(B402 var0) {
      var0.b = var0.e.createImage(var0.e.getWidth(), var0.e.getHeight());
      Graphics var1 = var0.b.getGraphics();
      var1.setColor(Av403.q);
      var1.fillRect(0, 0, var0.e.getWidth(), var0.e.getHeight());
   }

   public static void q(B402 var0) {
      if (var0.g != null) {
         var0.q = true;
         var0.g.interrupt();

         try {
            var0.g.join();
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }

         var0.g = null;
         e(var0);
      }

   }

   public static synchronized void j(B402 var0, Canvas var1, Q162 var2, int var3, int var4) {
      var0.e = var1;
      var0.h = var2;
      var0.w = var3;
      var0.r = var4;
      if (var0.d[1] != null && var0.d[5] != null && var0.d[6] != null) {
         var0.y = var0.d[1].getWidth();
         var0.x = var0.d[5].getHeight();
         var0.u = var0.d[6].getHeight();
         var0.p = var0.d[1].getHeight() + var0.x + var0.u;
      }
   }

   synchronized void h(int var1, String var2, Color var3, Color var4, Color var5, Color var6) {
      try {
         Graphics var7 = this.e.getGraphics();
         if (this.s == null) {
            this.s = new Font("Helvetica", 1, 13);
         }

         if (var4 == null) {
            var4 = new Color(140, 17, 17);
         }

         if (var5 == null) {
            var5 = new Color(140, 17, 17);
         }

         if (var6 == null) {
            var6 = new Color(255, 255, 255);
         }

         long var8 = Gz143.g();

         int var12;
         try {
            e(this);
            this.l = this.e.createImage(this.y, this.p);
            Graphics var10 = this.l.getGraphics();
            BufferedImage var28 = this.d[this.i];
            if (this.k < var8) {
               this.k = var8 + 15000L;
               ++this.i;
               if (this.i > 4) {
                  this.i = 1;
               }
            }

            if (var28 != null) {
               var10.drawImage(var28, 0, this.x, (ImageObserver)null);
               if (this.d[5] != null) {
                  var10.drawImage(this.d[5], 0, 0, (ImageObserver)null);
               }

               if (this.d[5] != null) {
                  var10.drawImage(this.d[6], 0, this.p - this.u, (ImageObserver)null);
               }

               if (this.n < var8 && this.t < 80 && (this.t < 5 || (float)this.t < 3.0F * (float)var1)) {
                  this.n = var8 + 300L;
                  this.t = this.t >= var1 ? this.t + 1 : var1;
               }

               this.t = this.t > 100 ? 100 : this.t;
               var12 = this.t * 21 / 100;
               BufferedImage var13 = this.d[0];
               int var17;
               boolean var18;
               int var19;
               int var20;
               if (var13 != null) {
                  int var14 = var13.getWidth() / 12;
                  int var15 = var13.getHeight();

                  for(int var16 = 0; var16 < 21; ++var16) {
                     var17 = 511 + var16 * (var14 + -7);
                     var18 = true;
                     var19 = var17 + var14;
                     var20 = 653 + var15;
                     int var21 = var16 < var12 ? this.v : 11;
                     int var22 = var21 * var14;
                     boolean var23 = false;
                     int var24 = var22 + var14;
                     int var25 = 0 + var15;
                     var10.drawImage(var13, var17, 653, var19, var20, var22, 0, var24, var25, (ImageObserver)null);
                  }

                  if (this.m < var8) {
                     this.m = var8 + 80L;
                     if (this.z) {
                        ++this.v;
                        if (this.v >= 10) {
                           this.z = !this.z;
                           --this.v;
                        }
                     } else {
                        --this.v;
                        if (this.v < 0) {
                           this.z = !this.z;
                           this.v = 0;
                        }
                     }
                  }
               }

               Graphics var30 = this.b.getGraphics();
               if (this.w > this.y && this.r > this.p) {
                  var30.drawImage(this.l, (this.w - this.y) / 2, (this.r - this.p) / 2, (ImageObserver)null);
               } else {
                  float var31 = (float)this.w / (float)this.y;
                  float var32 = (float)this.r / (float)this.p;
                  if (var31 < var32) {
                     boolean var33 = false;
                     int var34 = (this.r - (int)((float)this.p * var31)) / 2;
                     var19 = 0 + (int)((float)this.y * var31);
                     var20 = var34 + (int)((float)this.p * var31);
                     var30.drawImage(this.l, 0, var34, var19, var20, 0, 0, this.y, this.p, (ImageObserver)null);
                  } else {
                     var17 = (this.w - (int)((float)this.y * var32)) / 2;
                     var18 = false;
                     var19 = var17 + (int)((float)this.y * var32);
                     var20 = 0 + (int)((float)this.p * var32);
                     var30.drawImage(this.l, var17, 0, var19, var20, 0, 0, this.y, this.p, (ImageObserver)null);
                  }
               }

               var7.drawImage(this.b, 0, 0, (ImageObserver)null);
            } else {
               var12 = this.w / 2 - 152;
               int var29 = this.r / 2 - 18;
               var10.setColor(var5);
               var10.drawRect(var12, var29, 303, 33);
               var10.setColor(var3);
               var10.fillRect(var12 + 2, var29 + 2, var1 * 3, 30);
               var10.setColor(var4);
               var10.drawRect(var12 + 1, var29 + 1, 301, 31);
               var10.fillRect(var12 + 2 + var1 * 3, var29 + 2, 300 - var1 * 3, 30);
               var10.setFont(this.s);
               var10.setColor(var6);
               var10.drawString(var2, var12 + (304 - var2.length() * 6) / 2, var29 + 50);
               if (GameShell3.loadingTitle != null) {
                  var10.setFont(this.s);
                  var10.setColor(var6);
                  var10.drawString(GameShell3.loadingTitle, this.w / 2 - GameShell3.loadingTitle.length() * 6 / 2, this.r / 2 - 26);
               }

               var7.drawImage(this.l, 0, 0, (ImageObserver)null);
            }
         } catch (Exception var26) {
            var7.setColor(var4);
            var7.fillRect(0, 0, this.w, this.r);
            int var11 = this.w / 2 - 152;
            var12 = this.r / 2 - 18;
            var7.setColor(var5);
            var7.drawRect(var11, var12, 303, 33);
            var7.setColor(var3);
            var7.fillRect(var11 + 2, var12 + 2, var1 * 3, 30);
            var7.setColor(var4);
            var7.drawRect(var11 + 1, var12 + 1, 301, 31);
            var7.fillRect(var11 + 2 + var1 * 3, var12 + 2, 300 - var1 * 3, 30);
            var7.setFont(this.s);
            var7.setColor(var6);
            var7.drawString(var2, var11 + (304 - var2.length() * 6) / 2, var12 + 22);
            if (GameShell3.loadingTitle != null) {
               var7.setFont(this.s);
               var7.setColor(var6);
               var7.drawString(GameShell3.loadingTitle, this.w / 2 - GameShell3.loadingTitle.length() * 6 / 2, this.r / 2 - 26);
            }
         }
      } catch (Exception var27) {
         GameShell3.canvas.repaint();
      }

   }
}
