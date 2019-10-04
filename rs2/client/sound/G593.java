package rs2.client.sound;

import com.jagex.js5.G137;
import com.jagex.js5.js5;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import tfu.Gz143;

public class G593 {
   public static final int d = 0;
   public static int j = 1;
   private static final Logger logger = LoggerFactory.getLogger(G593.class);
   public static final int q = 1;
   private static String r = "\\";
   private static ArrayList w = new ArrayList();
   private ArrayList b = new ArrayList();
   private String e;
   private long h;
   private Object l;
   private boolean s = false;

   public static byte[] s(int var0, int var1, boolean var2) {
      long var4 = Gz143.g();
      long var6 = var4 + 100000L;
      byte[] var3;
      if (!var2) {
         var3 = js5.h(client.ez, var0, var1);
         return var3;
      } else {
         do {
            var3 = js5.h(client.ez, var0, var1);
            if (!client.dm.s()) {
               float var8 = (float)(Gz143.g() - var4) * 0.001F;
               client.bu.m(var8);
            }

            G137.j(client.dt);
            logger.trace("Loading file {} from group {}", var1, var0);
         } while(var3 == null && Gz143.g() < var6);

         return var3;
      }
   }

   public static void g(String var0, long var1, boolean var3, Z674 var4, Object var5) {
      if (j == 1) {
         if (client.ez.getgroupid(var0) == -1) {
            if (var4 != null) {
               var4.q();
            }

            return;
         }
      } else {
         File var6 = new File(SoundManager.aq + var0);
         if (!var6.exists()) {
            return;
         }
      }

      Iterator var8 = w.iterator();

      G593 var7;
      do {
         if (!var8.hasNext()) {
            w.add(new G593(var0, Gz143.g() + var1, var3, var4, var5));
            return;
         }

         var7 = (G593)var8.next();
      } while(!var7.e.equalsIgnoreCase(var0));

      var7.b.add(var4);
   }

   public static void d(String var0, long var1) {
      g(var0, var1, true, (Z674)null, (Object)null);
   }

   public static void q() {
      long var0 = Gz143.g();
      Iterator var2 = w.iterator();

      while(var2.hasNext()) {
         G593 var3 = (G593)var2.next();
         byte[] var4 = e(var3.e, false);
         Iterator var5;
         Z674 var6;
         if (var4 != null) {
            if (var3.s) {
               b(var3.e, var4);
               var5 = var3.b.iterator();

               while(var5.hasNext()) {
                  var6 = (Z674)var5.next();
                  if (var6 != null) {
                     var6.g(var3.e, var3.l);
                  }
               }

               var3.b.clear();
            } else {
               var5 = var3.b.iterator();

               while(var5.hasNext()) {
                  var6 = (Z674)var5.next();
                  if (var6 != null) {
                     var6.d(var4, var3.l);
                  }
               }

               var3.b.clear();
            }

            w.remove(var3);
            break;
         }

         if (var0 > var3.h) {
            var5 = var3.b.iterator();

            while(var5.hasNext()) {
               var6 = (Z674)var5.next();
               if (var6 != null) {
                  var6.q();
               }
            }

            var3.b.clear();
            w.remove(var3);
            break;
         }
      }

   }

   public G593(String var1, long var2, boolean var4, Z674 var5, Object var6) {
      this.e = var1;
      this.h = var2;
      this.b.add(var5);
      this.s = var4;
      this.l = var6;
   }

   public static byte[] e(String var0, boolean var1) {
      if (j == 0) {
         logger.trace("Reading file {}", var0);
         byte[] var2 = j(SoundManager.aq + var0);
         return var2;
      } else {
         return s(client.ez.getgroupid(var0), 0, var1);
      }
   }

   public static char[] h(String var0, boolean var1) {
      byte[] var2 = s(client.ez.getgroupid(var0), 0, var1);
      char[] var3 = null;
      if (var2 != null) {
         var3 = new char[var2.length];

         for(int var4 = 0; var4 < var2.length; ++var4) {
            var3[var4] = (char)var2[var4];
         }
      }

      return var3;
   }

   static boolean b(String var0, byte[] var1) {
      boolean var2 = false;

      try {
         FileOutputStream var3 = new FileOutputStream(new File(SoundManager.ag + var0));
         var3.write(var1);
         var3.close();
         var2 = true;
      } catch (FileNotFoundException var4) {
      } catch (IOException var5) {
      }

      return var2;
   }

   public static byte[] j(String var0) {
      File var1 = new File(var0);
      if (!var1.exists()) {
         return null;
      } else {
         byte[] var2 = new byte[(int)var1.length()];

         try {
            FileInputStream var3 = new FileInputStream(var1);
            var3.read(var2);
            var3.close();
            return var2;
         } catch (FileNotFoundException var4) {
            return null;
         } catch (IOException var5) {
            return null;
         }
      }
   }
}
