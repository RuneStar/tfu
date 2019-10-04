package rs2.client.login;

import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.N272;
import rs2.client.client;
import tfu.Lf336;
import tfu.Lx337;
import tfu.Mf509;

public class B271 extends Y276 {
   private static final Logger logger = LoggerFactory.getLogger(B271.class);
   final boolean b;
   S605 d;
   final long e;
   final String h;
   final String j;
   int l;
   L606 q;
   final long s;
   int w;

   public B271(N272 var1, long var2, long var4, boolean var6, EventHandler var7) {
      super(var1, 5.0F, var7);
      this.j = null;
      this.e = var2;
      this.h = null;
      this.s = var4;
      this.b = var6;
      if (this.e != 0L && this.s != 0L) {
         this.q = L606.CONNECT_UDP;
      } else {
         l(this, E275.LOGIN_FAIL, Mf509.INVALID_USERNAME_OR_PASSWORD);
      }
   }

   public void g() {
      n(this);
      this.q = L606.CONNECT_UDP;
   }

   public void j() {
      N272.s(super.v);
      client.de.close();
      client.de = null;
      LuaNativeEvents.detachAllEventHandlers(client.cj.getLuaStateNativeRef());
      client.dq.setChannel((PacketChannel)null);
      client.dq.removeAllStreams();
      n(this);
      this.d = new S605(System.currentTimeMillis() + 1000L, L606.CONNECT_UDP);
      this.q = L606.DELAY;
      logger.error("Switching world");
   }

   private static void l(B271 var0, E275 var1, Mf509 var2) {
      logger.info("Login failed: result={} serverResponse={}", var1, var2);
      var0.q = null;
      N272.s(var0.v);
      var0.i(var1, var2);
   }

   private static void e(B271 var0, E275 var1) {
      N272.s(var0.v);
      J570.q();
      if (var0.z < 4) {
         Lx337.q(Lf336.q);
         var0.x = 0.0F;
         var0.p = 40.0F;
         ++var0.z;
         var0.q = L606.CONNECT_UDP;
      } else {
         w(var0, var1);
      }

   }

   public void q() {
      N272.s(super.v);
      client.de.close();
      client.de = null;
      client.dq.setChannel((PacketChannel)null);
      client.dq.removeAllStreams();
      n(this);
      this.d = new S605(System.currentTimeMillis() + 1000L, L606.CONNECT_UDP);
      this.q = L606.DELAY;
   }

   public B271(N272 var1, String var2, String var3, EventHandler var4) {
      super(var1, 5.0F, var4);
      this.j = var2;
      this.e = 0L;
      this.h = var3;
      this.s = 0L;
      this.b = false;
      if (!this.j.equals("") && !this.h.equals("")) {
         this.q = L606.CONNECT_UDP;
      } else {
         l(this, E275.LOGIN_FAIL, Mf509.INVALID_USERNAME_OR_PASSWORD);
      }
   }

   public void d(float var1) {
      // $FF: Couldn't be decompiled
   }

   private static void w(B271 var0, E275 var1) {
      logger.info("Login failed: result={}", var1);
      l(var0, var1, (Mf509)null);
   }
}
