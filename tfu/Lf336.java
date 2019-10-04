package tfu;

import com.jagex.core.constants.D123;
import java.net.InetAddress;
import java.net.UnknownHostException;
import rs2.client.Al161;
import rs2.client.client;

public class Lf336 {
   public static String d;
   public static Lx337 e;
   public static final boolean g = true;
   public static boolean h;
   public static Lx337 j;
   public static Lx337 q;

   public static void d(int var0, String var1) {
      q = new Lx337();
      q.g = var0;
      if (d != null) {
         q.d = d;
      } else {
         q.d = var1;
      }

      if (client.t != D123.LIVE) {
         q.q = '鱀' + q.g;
         q.j = '썐' + q.g;
      }

      try {
         Al161.d(InetAddress.getByName(q.d));
      } catch (UnknownHostException var3) {
      }

      System.out.println("Now trying to connect to " + q.d + ":" + q.g);
   }

   public static void g(int var0, String var1) {
      e = q;
      h = true;
      d(var0, var1);
   }
}
