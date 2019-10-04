package fmod;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.Vector3;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gz143;

public class X243 {
   private static List a = new ArrayList();
   private static long ah = 10000L;
   public static List aj = new ArrayList();
   static int an = 0;
   public static final int b = 5;
   private static List c = new ArrayList();
   public static String d = "";
   public static final int e = 2;
   public static final int h = 3;
   public static final int j = 1;
   public static final int l = 5;
   private static final Logger logger = LoggerFactory.getLogger(X243.class);
   private static Hashtable o = new Hashtable();
   public static final int p = 10;
   public static final int q = 0;
   public static final int r = 7;
   public static final int s = 4;
   public static final int v = 8;
   public static final int w = 6;
   private static int x = 0;
   public static final int y = 9;
   String[] aa = null;
   private Q244 ab = new Q244();
   private float ac = 0.0F;
   public int af;
   private String ag = "";
   public String ai = "";
   public E245 al;
   private boolean am;
   private long ao = 0L;
   private Y246 ap = null;
   public String aq;
   private Q244 ar = new Q244();
   private boolean as;
   private float at = 1.0F;
   private GameEntity au = null;
   private Object av = null;
   private Q244 aw = new Q244();
   private int ax;
   public boolean az = false;
   private List f = new ArrayList();
   private N247 i = new N247();
   public X243 k = null;
   public long m = 0L;
   public long n = 0L;
   public int t = -1;
   public int u = 0;
   public int z = 0;

   public String toString() {
      return this.i.d;
   }

   public static void d() {
      try {
         Iterator var0 = c.iterator();

         while(var0.hasNext()) {
            X243 var1 = (X243)var0.next();
            X243 var2 = var1.al.r(var1.aq, var1.af);
            if (h(var2)) {
               var1.m = var2.m;
               o(var1);
               c.remove(var1);
               break;
            }
         }
      } catch (ConcurrentModificationException var8) {
         logger.info("Two things trying to play with event list");
      }

      Enumeration var9 = o.keys();
      new N247();
      long var11 = Gz143.g();

      X243 var6;
      while(var9.hasMoreElements()) {
         String var4 = (String)var9.nextElement();
         P248 var5 = (P248)o.get(var4);
         if (var5 != null && var5.d != 0L) {
            N247 var10 = g(var5.d);
            if (var10.j == 0 && var5.g + ah < var11) {
               logger.trace("Flushed {} from events. {} used", var4, fmod.getMemoryUsed());
               o.remove(var4);
               var6 = new X243(var5.d);
               f(var6);
               p(var6, true, true);
               q(var6);
               break;
            }
         }
      }

      int var12 = a.size() - 1;
      if (var12 >= 0) {
         for(int var13 = var12; var13 >= 0; --var13) {
            var6 = (X243)a.get(var13);
            if (var6.ao > 0L && Gz143.g() > var6.ao) {
               c(var6);
            } else if ((v(var6) & 64) != 0) {
               c(var6);
            } else if (!y(var6)) {
               c(var6);
            } else if (var6.au != null) {
               Vector3 var7 = var6.au.getWorldTransform().trans;
               var6.z(var7.x, var7.y, var7.z);
            }
         }
      }

   }

   public static int x(X243 var0, Q244 var1, Q244 var2, Q244 var3) {
      var0.ab = var1;
      var0.aw = var2;
      var0.ar = var3;
      return h(var0) ? fmod.Event_set3DAttributes(var0.m, var1.g, var1.d, var1.q, var2.g, var2.d, var2.q, var3.g, var3.d, var3.q) : 0;
   }

   public static void j(long var0) {
      ah = var0;
   }

   public static boolean h(X243 var0) {
      return var0.m > 0L;
   }

   public static String s(X243 var0) {
      return var0.ai;
   }

   public static N247 b(X243 var0) {
      return g(var0.m);
   }

   public M249 l() {
      return this.m == -1L ? null : new M249(fmod.Event_getCategory(this.m));
   }

   public L250 w(String var1) {
      return h(this) ? new L250(fmod.Event_getParameter(this.m, var1)) : null;
   }

   public J251 r() {
      return h(this) ? new J251(fmod.Event_getParentGroup(this.m)) : null;
   }

   public static int v(X243 var0) {
      if (var0.m == -1L) {
         return 0;
      } else {
         return h(var0) ? fmod.Event_getState(var0.m) : 0;
      }
   }

   public static boolean y(X243 var0) {
      if (!h(var0)) {
         return false;
      } else {
         int var1 = v(var0);
         if ((var1 & 16) == 16) {
            return true;
         } else {
            return (var1 & 64) == 64 ? false : false;
         }
      }
   }

   public static void af(X243 var0, int var1, float var2) {
      if (h(var0)) {
         fmod.Event_setPropertyByIndex(var0.m, var1, var2);
      }

   }

   public static int u(X243 var0, Q244 var1) {
      var0.ab = var1;
      return h(var0) ? fmod.Event_set3DAttributes(var0.m, var1.g, var1.d, var1.q, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F) : 0;
   }

   public static void m(X243 var0, boolean var1) {
      var0.am = var1;
      if (h(var0)) {
         fmod.Event_setMute(var0.m, var1);
      }

   }

   public static void n(X243 var0, boolean var1) {
      var0.as = var1;
      if (h(var0)) {
         fmod.Event_setPaused(var0.m, var1);
      }

   }

   public static void t(X243 var0, float var1, float var2) {
      if (h(var0)) {
         af(var0, 17, var1);
         af(var0, 18, var2);
      }

   }

   public static void i(X243 var0, float var1) {
      var0.at = var1;
      if (h(var0)) {
         fmod.Event_setVolume(var0.m, var1);
      }

   }

   private static void o(X243 var0) {
      if (h(var0)) {
         i(var0, var0.at);
         k(var0, var0.ac, var0.ax);
         m(var0, var0.am);
         x(var0, var0.ab, var0.aw, var0.ar);
         if (var0.f.size() > 0) {
            Iterator var1 = var0.f.iterator();

            while(var1.hasNext()) {
               G252 var2 = (G252)var1.next();
               var0.ag(var2.g, var2.d);
            }

            var0.f.clear();
         }

         if (var0.az) {
            var0.a();
         }

         n(var0, var0.as);
      }

   }

   public static ArrayList ao() {
      return (ArrayList)a;
   }

   public static void f(X243 var0) {
      if (h(var0)) {
         L250 var1 = var0.w("playback");
         if (L250.g(var1)) {
            L250.d(var1);
            var0.ao = Gz143.g() + 5000L;
         } else {
            fmod.Event_stop(var0.m);
            a.remove(var0);
         }
      }

   }

   public static void c(X243 var0) {
      if (h(var0)) {
         fmod.Event_stopImmediate(var0.m);
         a.remove(var0);
      }

   }

   public void ag(String var1, float var2) {
      if (h(this)) {
         L250 var3 = this.w(var1);
         if (L250.g(var3)) {
            L250.q(var3, var2);
         }
      } else {
         this.f.add(new G252(this, var1, var2));
      }

   }

   public void a() {
      if (h(this)) {
         o.put(this.aq, new P248(this, Gz143.g(), this.m));
         a.add(this);
         fmod.Event_start(this.m);
      }

   }

   public static void av(X243 var0, int var1, int var2) {
      if (h(var0)) {
         fmod.Event_setIntPropertyByIndex(var0.m, var1, var2);
      }

   }

   public static void p(X243 var0, boolean var1, boolean var2) {
      if (h(var0)) {
         fmod.Event_release(var0.m, var1, var2);
      }

   }

   public static void ap(X243 var0, GameEntity var1) {
      var0.au = var1;
   }

   public boolean ai() {
      boolean var1 = false;
      if (h(this)) {
         String[] var2 = this.aq();
         if (var2 != null) {
            String[] var3 = var2;
            int var4 = var2.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               String var6 = var3[var5];
               File var7 = new File(d + var6);
               if (!var7.exists()) {
                  return false;
               }

               var1 |= true;
            }
         }
      }

      return var1;
   }

   public static synchronized void e(X243 var0) {
      String var1 = s(var0);
      Iterator var2 = c.iterator();

      X243 var3;
      do {
         if (!var2.hasNext()) {
            c.add(var0);
            return;
         }

         var3 = (X243)var2.next();
      } while(!s(var3).equals(var1));

   }

   public H238 aa() {
      S237 var1 = new S237(fmod.Event_getChannelGroup(this.m));
      if (S237.g(var1)) {
         int var3 = S237.q(var1);
         if (var3 > 0) {
            H238 var2 = var1.d(var3 - 1);
            return var2;
         }
      }

      return new H238(0L);
   }

   public static long an(X243 var0) {
      H238 var1 = var0.aa();
      return H238.g(var1) ? (long)H238.q(var1, 1) : 0L;
   }

   public static void am(X243 var0, int var1) {
      H238 var2 = var0.aa();
      if (H238.g(var2)) {
         H238.j(var2, var1, 1);
      }

   }

   public static int as(X243 var0) {
      H238 var1 = var0.aa();
      return H238.g(var1) ? V241.g(var1.d(), 1) : 0;
   }

   public X243(long var1) {
      this.m = var1;
      new N247();
      if (this.m > 0L) {
         N247 var3 = g(this.m);
      }

      this.t = x++;
   }

   public String[] aq() {
      if (!h(this)) {
         return null;
      } else {
         String var1 = fmod.Event_getWaveBanksNeeded(this.m);
         String[] var2 = var1.split("\\|");

         for(int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = var2[var3] + ".fsb";
         }

         return var2;
      }
   }

   public static void q(X243 var0) {
      if (h(var0)) {
         J251 var1 = var0.r();
         if (J251.g(var1)) {
            J251.d(var1, var0);
         }
      }

   }

   public static void k(X243 var0, float var1, int var2) {
      var0.ac = var1;
      var0.ax = var2;
      if (h(var0)) {
         fmod.Event_setPitch(var0.m, var1, var2);
      }

   }

   public int z(float var1, float var2, float var3) {
      this.ab = new Q244(var1, var2, var3);
      return h(this) ? fmod.Event_set3DAttributes(this.m, var1, var2, var3, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F) : 0;
   }

   private static N247 g(long var0) {
      N247 var2 = new N247();
      String var3 = fmod.Event_getInfo(var0);
      if (var3 != null && !var3.isEmpty()) {
         int var5;
         for(int var4 = 0; var4 < var3.length(); var4 = var5 + 1) {
            var5 = var3.indexOf(44, var4);
            if (var5 == -1) {
               var5 = var3.length();
            }

            int var6 = var3.indexOf(61, var4);
            if (var6 == -1) {
               var6 = var5;
            }

            int var7 = var6 - var4;
            if (var3.regionMatches(var4, "index", 0, var7)) {
               var2.g = Integer.parseInt(var3.substring(var6 + 1, var5));
            } else if (var3.regionMatches(var4, "name", 0, var7)) {
               var2.d = var3.substring(var6 + 1, var5);
            } else if (var3.regionMatches(var4, "audibility", 0, var7)) {
               var2.q = Float.parseFloat(var3.substring(var6 + 1, var5));
            } else if (var3.regionMatches(var4, "instancesactive", 0, var7)) {
               var2.j = Integer.parseInt(var3.substring(var6 + 1, var5));
            } else if (var3.regionMatches(var4, "maxinstances", 0, var7)) {
               var2.e = Integer.parseInt(var3.substring(var6 + 1, var5));
            }
         }

         return var2;
      } else {
         return var2;
      }
   }

   public static int al(X243 var0, int var1) {
      int var2 = 0;
      if (h(var0)) {
         var2 = fmod.Event_getIntPropertyByIndex(var0.m, var1);
      }

      return var2;
   }
}
