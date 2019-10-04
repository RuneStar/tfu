package rs2.client.login;

import com.jagex.game.runetek6.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.N272;
import tfu.Lf336;
import tfu.Lx337;
import tfu.Mf509;

public class G270 extends Y276 {
   private static final Logger logger = LoggerFactory.getLogger(G270.class);
   Q580 d;
   public long e;
   public long h;
   int j;
   int q;

   public void d(float var1) {
      // $FF: Couldn't be decompiled
   }

   public G270(N272 var1, int var2, EventHandler var3) {
      super(var1, 5.0F, var3);
      this.q = var2;
      this.d = Q580.CONNECT;
   }

   private static void e(G270 var0, E275 var1) {
      j(var0, var1, (Mf509)null);
   }

   private static void q(G270 var0, E275 var1) {
      N272.s(var0.v);
      if (var0.z < 4) {
         Lx337.q(Lf336.q);
         var0.x = 0.0F;
         if (var0.d != Q580.CONNECT && var0.d != Q580.WAIT_FOR_CONNECTION_ACK && var0.d != Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN_LENGTH && var0.d != Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN) {
            var0.p = 120.0F;
         } else {
            var0.p = 40.0F;
         }

         ++var0.z;
         var0.d = Q580.CONNECT;
      } else {
         e(var0, var1);
      }

   }

   private static void j(G270 var0, E275 var1, Mf509 var2) {
      var0.d = null;
      N272.s(var0.v);
      var0.i(var1, var2);
   }
}
