package tfu;

import com.jagex.core.stringtools.general.StringTools;
import jaclib.nanotime.QueryPerformanceCounter;
import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.URL;

public abstract class Dl463 implements Do629, Runnable, FocusListener, WindowListener {
   public static int a;
   public static Applet aa;
   public static Hw321 ab;
   public static volatile boolean ac = false;
   private static File ad;
   private static File ae;
   public static int af = 0;
   public static int ag;
   public static Frame ah;
   public static int ai;
   private static final int aj = 786432000;
   private static final int ak = 1048576;
   public static int al = 0;
   public static Image am;
   public static volatile boolean an = true;
   public static Canvas ao;
   public static Frame ap;
   public static int aq;
   private static volatile boolean ar = true;
   private static int as = 500;
   private static volatile long at = 0L;
   public static Dv322 au;
   private static Font av;
   public static boolean aw = false;
   public static boolean ax;
   private static final String ay = "rw";
   public static String az = null;
   static final boolean b = true;
   public static int ba = 1;
   public static int bb = -1;
   public static String bc;
   private static int bd;
   public static String be;
   public static Du625 bf = null;
   private static boolean bg = false;
   public static Im133[] bh;
   public static Im133 bj = null;
   public static Im133 bk = null;
   private static final String bl = "random.dat";
   private static final String bm = "main_file_cache.dat2";
   private static long bn = 0L;
   private static final String bo = "main_file_cache.idx255";
   private static int bp;
   private static final String bq = "main_file_cache.idx";
   private static final int br = 0;
   public static String bs;
   public static String bt;
   private static final int bv = 1;
   private static Im133 bw = null;
   private static String[] bx;
   private static String[] by;
   public static String bz;
   public static int c;
   public static EventQueue cp;
   public static String cq;
   public static String cw;
   private static final boolean d = true;
   static final boolean e = true;
   public static int f;
   private static final boolean g = true;
   static final boolean h = true;
   private static long[] i = new long[32];
   static final boolean j = true;
   private static int k;
   private static final boolean l = true;
   private static final int m = 32;
   private static long[] n = new long[32];
   private static int o;
   static int p;
   static final boolean q = true;
   private static final boolean r = true;
   static final boolean s = true;
   public static Ds621 t;
   public static int u = 0;
   private static final boolean v = true;
   private static final boolean w = true;
   static long x = 20000000L;
   private static final boolean y = true;
   public static int z = 0;
   public boolean bi = false;
   public boolean bu = false;

   public static Container s() {
      if (ap != null) {
         return ap;
      } else {
         return (Container)(ah != null ? ah : aa);
      }
   }

   public static void b(Dl463 var0, Container var1) {
      var1.setBackground(Color.black);
      var1.setLayout((LayoutManager)null);
      var1.add(ao);
      ao.setSize(c, ag);
      ao.setVisible(true);
      if (var1 == ah) {
         Insets var2 = ah.getInsets();
         ao.setLocation(var2.left + al, var2.top + af);
      } else {
         ao.setLocation(al, af);
      }

      ao.addFocusListener(var0);
      ao.requestFocus();
      ax = true;
      ar = true;
      ao.setFocusTraversalKeysEnabled(false);
      an = true;
      ac = false;
      at = Gz143.g();
   }

   private static void y(Dl463 var0) {
      long var1 = Gz143.g();
      long var3 = n[k];
      n[k] = var1;
      k = k + 1 & 31;
      if (var3 != 0L && var1 > var3) {
         int var5 = (int)(var1 - var3);
         u = (32000 + (var5 >> 1)) / var5;
      }

      if (as++ > 50) {
         as -= 50;
         an = true;
         ao.setSize(c, ag);
         ao.setVisible(true);
         if (ah != null && ap == null) {
            Insets var6 = ah.getInsets();
            ao.setLocation(var6.left + al, var6.top + af);
         } else {
            ao.setLocation(al, af);
         }
      }

      var0.t();
   }

   private final void p(boolean var1) {
      synchronized(this) {
         if (bg) {
            return;
         }

         bg = true;
      }

      System.out.println("Shutdown start - clean:" + var1);

      try {
         this.m();
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      try {
         Im133.g(bj);

         for(int var2 = 0; var2 < bd; ++var2) {
            Im133.g(bh[var2]);
         }

         Im133.g(bk);
         Im133.g(bw);
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      if (this.bi) {
         try {
            QueryPerformanceCounter.quit();
         } catch (Throwable var5) {
            var5.printStackTrace();
         }
      }

      if (Kt125.q()) {
         Kt125.d().b();
      }

      if (ao != null) {
         try {
            ao.removeFocusListener(this);
            ao.getParent().remove(ao);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      if (ah != null) {
         ah.setVisible(false);
         ah.dispose();
         ah = null;
      }

      System.out.println("Shutdown complete - clean:" + var1);
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      ar = true;
      an = true;
   }

   public final void focusLost(FocusEvent var1) {
      ar = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public abstract void u();

   public final void windowClosing(WindowEvent var1) {
      aw = true;
      this.q();
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public void q() {
      if (!bg) {
         bn = Gz143.g();
         Gi430.g(5000L);
         this.p(false);
      }
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void z();

   public abstract void t();

   public abstract void m();

   public void n(String var1) {
      if (!this.bu) {
         this.bu = true;
         System.out.println("error_game_" + var1);

         try {
            Mu209.g(aa, "loggedout");
         } catch (Throwable var4) {
         }

         try {
            aa.getAppletContext().showDocument(new URL(aa.getCodeBase(), "error_game_" + var1 + ".ws"), "_top");
         } catch (Exception var3) {
            var3.printStackTrace();
         }

      }
   }

   public static void r(Object var0) {
      if (cp != null) {
         for(int var1 = 0; var1 < 50 && cp.peekEvent() != null; ++var1) {
            Gi430.g(1L);
         }

         try {
            if (var0 != null) {
               cp.postEvent(new ActionEvent(var0, 1001, "dummy"));
            }
         } catch (Exception var2) {
         }

      }
   }

   public static final int x() {
      return (int)(1000000000L / x);
   }

   public void run() {
      w(this);
      this.p(true);
   }

   private static void v(Dl463 var0) {
      long var1 = Gz143.g();
      long var3 = i[o];
      i[o] = var1;
      o = o + 1 & 31;
      if (var3 != 0L && var1 > var3) {
         int var5 = (int)(var1 - var3);
         z = (32000 + (var5 >> 1)) / var5;
      }

      synchronized(var0) {
         ax = ar;
      }

      var0.z();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   private static void w(Dl463 var0) {
      if (bt != null) {
         String var1 = bt.toLowerCase();
         if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
            String var2 = bz;
            if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
               var0.n("wrongjava");
               return;
            }

            if (var2.startsWith("1.6.0_")) {
               int var3;
               for(var3 = 6; var3 < var2.length() && StringTools.w(var2.charAt(var3)); ++var3) {
               }

               String var4 = var2.substring(6, var3);
               if (StringTools.d(var4) && StringTools.j(var4) < 10) {
                  var0.n("wrongjava");
                  return;
               }
            }
         }
      }

      s().setFocusCycleRoot(true);
      bb = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      ba = Runtime.getRuntime().availableProcessors();
      var0.h();
      var0.u();
      t = Ds621.r();

      while(bn == 0L || Gz143.g() < bn) {
         p = Ds621.v(t, x);

         for(int var5 = 0; var5 < p; ++var5) {
            v(var0);
         }

         y(var0);
         r(ao);
      }

   }

   public synchronized void h() {
      l(this);
      Container var1 = s();
      ao = new Dq324(var1);
      b(this, var1);
   }

   public static void l(Dl463 var0) {
      if (ao != null) {
         ao.removeFocusListener(var0);
         ao.getParent().setBackground(Color.black);
         ao.getParent().remove(ao);
      }

   }
}
