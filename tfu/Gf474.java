package tfu;

import com.jagex.jnibindings.runetek6.StateEventManager;
import rs2.client.N272;
import rs2.client.client;

public class Gf474 extends J153 {
   public static void w() {
      if (d()) {
         r();
      }

   }

   private static void r() {
      int var0 = 2;
      Q475 var1 = new Q475();

      while((var0 = q(var0, var1)) != 0) {
         El328 var2 = El328.d(Eu326.STATEEVENT_EVENTSBUFFER, client.fx.s);
         Gs329.an(var2.q, var1.d);
         N272.e(client.fx, var2);
      }

      StateEventManager.resetOutEventsBuffer();
   }

   public static void v(Gs329 var0) {
      j(var0);
   }
}
