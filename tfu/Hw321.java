package tfu;

import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.Field;
import sun.awt.Win32GraphicsDevice;

public class Hw321 {
   private static final boolean d = true;
   private static final boolean g = true;
   private DisplayMode j;
   private GraphicsDevice q;

   public static int[] g(Hw321 var0) {
      DisplayMode[] var1 = var0.q.getDisplayModes();
      int[] var2 = new int[var1.length << 2];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2[var3 << 2] = var1[var3].getWidth();
         var2[(var3 << 2) + 1] = var1[var3].getHeight();
         var2[(var3 << 2) + 2] = var1[var3].getBitDepth();
         var2[(var3 << 2) + 3] = var1[var3].getRefreshRate();
      }

      return var2;
   }

   public void d(Frame var1, int var2, int var3, int var4, int var5) {
      System.out.println("fullscreen.fsimp14: w=" + var2 + " h=" + var3 + " bits=" + var4 + " refreshrate=" + var5);
      this.j = this.q.getDisplayMode();
      if (this.j == null) {
         throw new NullPointerException();
      } else {
         var1.setUndecorated(true);
         var1.enableInputMethods(false);
         j(this, var1);
         if (var5 == 0) {
            int var6 = this.j.getRefreshRate();
            DisplayMode[] var7 = this.q.getDisplayModes();
            boolean var8 = false;

            for(int var9 = 0; var9 < var7.length; ++var9) {
               if (var7[var9].getWidth() == var2 && var7[var9].getHeight() == var3 && var7[var9].getBitDepth() == var4) {
                  int var10 = var7[var9].getRefreshRate();
                  if (!var8 || Math.abs(var10 - var6) < Math.abs(var5 - var6)) {
                     var5 = var10;
                     var8 = true;
                  }
               }
            }

            if (var8) {
               System.out.println("fullscreen.fsimp14: using refreshrate=" + var5 + " - closest found to currentrate=" + var6);
            } else {
               var5 = var6;
               System.out.println("fullscreen.fsimp14: no refreshrate found, falling back to current refreshrate=" + var6);
            }
         }

         this.q.setDisplayMode(new DisplayMode(var2, var3, var4, var5));
         System.out.println("fullscreen.fsimp14: mode set successfully");
      }
   }

   public Hw321() throws Exception {
      GraphicsEnvironment var1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
      this.q = var1.getDefaultScreenDevice();
      if (!this.q.isFullScreenSupported()) {
         GraphicsDevice[] var2 = var1.getScreenDevices();
         GraphicsDevice[] var3 = var2;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            GraphicsDevice var6 = var3[var5];
            if (var6 != null && var6.isFullScreenSupported()) {
               this.q = var6;
               return;
            }
         }

         throw new Exception();
      }
   }

   private static void j(Hw321 var0, Frame var1) {
      boolean var2 = false;

      Field var3;
      try {
         var3 = Win32GraphicsDevice.class.getDeclaredField("valid");
         var3.setAccessible(true);
         boolean var4 = (Boolean)var3.get(var0.q);
         if (var4) {
            var3.set(var0.q, Boolean.FALSE);
            var2 = true;
         }
      } catch (Throwable var13) {
      }

      try {
         var0.q.setFullScreenWindow(var1);
         if (var2) {
            try {
               var3 = Win32GraphicsDevice.class.getDeclaredField("valid");
               var3.set(var0.q, Boolean.TRUE);
            } catch (Throwable var12) {
            }
         }

      } finally {
         if (var2) {
            try {
               Field var6 = Win32GraphicsDevice.class.getDeclaredField("valid");
               var6.set(var0.q, Boolean.TRUE);
            } catch (Throwable var11) {
            }
         }

      }
   }

   public static void q(Hw321 var0) {
      System.out.println("fullscreen.fsimp14: exiting");
      if (var0.j != null) {
         DisplayMode[] var1 = var0.q.getDisplayModes();
         boolean var2 = false;
         DisplayMode[] var3 = var1;
         int var4 = var1.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            DisplayMode var6 = var3[var5];
            if (var6.equals(var0.j)) {
               var0.q.setDisplayMode(var0.j);
               var2 = true;
               break;
            }
         }

         if (!var2) {
            try {
               Field var8 = Win32GraphicsDevice.class.getDeclaredField("defaultDisplayMode");
               var8.setAccessible(true);
               var8.set(var0.q, (Object)null);
            } catch (Throwable var7) {
            }
         }

         var0.j = null;
      }

      j(var0, (Frame)null);
      System.out.println("fullscreen.fsimp14: exited");
   }
}
