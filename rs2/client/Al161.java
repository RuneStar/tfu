package rs2.client;

import java.net.InetAddress;

public class Al161 {
   public static int d = -1;
   private static final Runnable e = new Q400();
   public static final int g = 1000;
   private static Thread h = null;
   private static boolean j = true;
   private static InetAddress q = null;

   public static void g() {
      h = new Thread(e);
      h.start();
   }

   public static void d(InetAddress var0) {
      Runnable var1 = e;
      synchronized(var1) {
         q = var0;
         d = -1;
      }
   }

   public static void q() {
      j = false;

      try {
         h.interrupt();
         h.join();
      } catch (InterruptedException var1) {
      }

   }

   // $FF: synthetic method
   static boolean j() {
      return j;
   }

   // $FF: synthetic method
   static InetAddress e() {
      return q;
   }
}
