package tfu;

import com.jagex.game.runetek6.config.vartype.player.VarPlayerType;
import com.jagex.game.runetek6.event.PhysicsEventMode;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.maths.Quaternion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.N272;
import rs2.client.client;
import rs2.client.chat.G232;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.worldelement.player;

public class Gc330 {
   public static Quaternion b;
   private static final boolean d = true;
   public static int e;
   public static int h;
   public static ArrayList j = new ArrayList();
   private static int l;
   private static final Logger logger = LoggerFactory.getLogger(Gc330.class);
   private static int q = -1;
   private static final player[] r;
   public static int s;
   private static final Gg3[] v;
   private static final List w;

   public static void s(Gg3 var0, int var1) {
      boolean var2 = j() == null;
      logger.trace("Received player info 2 packet! Size: {}", var1);
      int var3 = Gg3.br(var0);
      int var4;
      int var5;
      int var6;
      if (var3 > 0) {
         logger.trace("Getting data about {} rule B infringers...", var3);

         for(var4 = 0; var4 < var3; ++var4) {
            var5 = Gg3.au(var0);
            var6 = var5 & 2047;
            boolean var7 = (var5 & '耀') != 0;
            Bb4 var8 = Bb4.e(var0, Ed472.PLAYER);
            player var9 = r[var6];
            if (var9 == null) {
               logger.debug("Received new player: {} {}", var6, var6 == q ? " [self]" : "");
               var9 = new player(var8);
               r[var6] = var9;
               w.add(var9);
               client.mm.add(var9);
               ++l;
               player.ep(var9, new MappedEventComponent((Map)null, PhysicsEventMode.COLLISION));
               var9.be(var6, var6 == q || var7);
               if (var6 == q) {
                  ClientScriptAPI.setNativeSelfGameEntity(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), var9);
                  player.ep(var9, client.ku);
               }
            }

            var9.m = var6;
            if (var7) {
               j.add(var9);
            }

            if ((var5 & 16384) != 0) {
               var9.cq(var0);
            }
         }

         var4 = 0;

         for(var5 = Gg3.by(var0); var5 >= 0; var5 = Gg3.by(var0)) {
            var4 += var5;
            Gg3.ar(var0);
            Gg3.ar(var0);
            Gg3.ar(var0);
         }

         var4 += -var5;
         logger.trace("Received 'no change' update for {} players!", var4);
      }

      var4 = Gg3.ar(var0);
      logger.trace("Received {} dropped players!", var4);

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = Gg3.br(var0);
         At476.j(r[var6]);
         j.remove(r[var6]);
         player.cw(r[var6]);
         player.co(r[var6]);
         Scene.w(client.mm, r[var6]);
         w.remove(r[var6]);
         logger.info("Dropping player {}", var6);
         if (var6 == q) {
            ClientScriptAPI.setNativeSelfGameEntity(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), (GameEntity)null);
         }

         r[var6] = null;
         --l;
      }

      var5 = Gg3.ar(var0);
      logger.trace("Receiving physics/extend updates for " + var5 + " players!");

      for(var6 = 0; var6 < var5; ++var6) {
         int var11 = Gg3.au(var0);
         int var13 = var11 & 3;
         int var14 = var11 >> 2 & 2047;
         if (var13 == 0) {
            player var10 = r[var14];
            if (var10 == null) {
               logger.warn("Eeek! Player was null for extend data: {}", var14);
               client.ap();
               return;
            }

            logger.trace("Receiving extend data only for slot: {}", var14);
            b(var0, var14, var10);
         } else {
            logger.debug("Inv t: {}", var13);
         }
      }

      if (var0.v != var1) {
         logger.warn("RPD: {} - {}", var0.v, var1);
         client.ap();
      } else {
         if (var2 && j() != null) {
            El328 var12 = El328.d(Eu326.PLAYER_LOGIN, client.fx.s);
            N272.e(client.fx, var12);
            client.cj.event.triggerEvent((String)"__onLoggedIn", j());
            client.ba();
         }

      }
   }

   public static void g() {
      l = 0;
      w.clear();
      j.clear();

      for(int var0 = 0; var0 < 2048; ++var0) {
         if (r[var0] != null) {
            if (client.mm != null) {
               Scene.w(client.mm, r[var0]);
            }

            player.cw(r[var0]);
            r[var0].ba = null;
            r[var0] = null;
         }

         v[var0] = null;
      }

   }

   public static int d() {
      return q;
   }

   public static player j() {
      return q != -1 ? r[q] : null;
   }

   public static void q(int var0) {
      q = var0;
   }

   public static Iterable h() {
      return w;
   }

   private static void b(Gg3 var0, int var1, player var2) {
      int var3 = Gg3.ar(var0);
      if (var3 != 0) {
         if ((var3 & 128) != 0) {
            var3 += Gg3.ar(var0) << 8;
         }

         if ((var3 & '耀') != 0) {
            var3 += Gg3.ar(var0) << 16;
         }

         int var4;
         if ((var3 & 1) != 0) {
            var4 = Gg3.ar(var0);
            logger.trace("Got information for player: {}, len: {}", var1, var4);
            byte[] var5 = new byte[var4];
            Gg3 var6 = new Gg3(var5);
            Gg3.bx(var0, var5, 0, var4);
            v[var1] = var6;
            var2.bn(var6);
         }

         int var13;
         String var14;
         if ((var3 & 16) != 0) {
            var4 = Gg3.ar(var0);

            for(var13 = 0; var13 < var4; ++var13) {
               var14 = var0.bh();

               try {
                  client.cj.runScriptEvent(var14, var2, (Object)null);
               } catch (Exception var11) {
                  logger.error("Script execution failed: " + var14, var11);
               }
            }
         }

         if ((var3 & 32) != 0) {
            var4 = Gg3.ar(var0);

            for(var13 = 0; var13 < var4; ++var13) {
               var14 = var0.bh();

               try {
                  logger.debug("Running client routine: {}", var14);
                  client.cj.runScriptEvent(var14, var2, (Object)null);
               } catch (Exception var10) {
                  logger.error("Script execution failed: " + var14, var10);
               }
            }
         }

         if ((var3 & 8192) != 0) {
            String var12 = Gg3.bk(var0);
            if (var12.charAt(0) == '~') {
               var12 = var12.substring(1);
               G232.q(2, 0, var2.bi(true), player.bt(var2, false), var2.aq, var12);
            } else if (var2 == j()) {
               G232.q(2, 0, var2.bi(true), player.bt(var2, false), var2.aq, var12);
            }
         }

         if ((var3 & 4096) != 0) {
            var4 = Gg3.au(var0);
            var2.bk = Gg3.ar(var0);
            var2.bh = Gg3.ar(var0);
            var2.bp = (var4 & '耀') != 0;
            var2.bj = var4 & 32767;
            var2.bw = client.bj + var2.bj + var2.bk;
         }

         if ((var3 & 2048) != 0) {
            var2.ay = Gg3.ar(var0) == 1;
         }

         Object var7;
         VarPlayerType var8;
         Integer var9;
         Kr260 var15;
         if ((var3 & 4194304) != 0) {
            var2.by.b();
            var4 = var0.r[var0.v++] & 255;

            for(var13 = 0; var13 < var4; ++var13) {
               var15 = client.fd.decodeVarValue(var0);
               var7 = var2.by.h(var15.g);
               var2.by.s(var15.g, var15.d);
               if (var2 != j()) {
                  player.cv(var2, var15.g, var15.d);
               }

               if (!Kh56.g(var15.d, var7)) {
                  var8 = client.fd.list(var15.g);
                  var9 = player.ex(var2, var8.debugNameHash32);
                  if (var9 != null) {
                     var2.triggerEvent(var9, var15.d);
                  }
               }
            }
         }

         if ((var3 & 2097152) != 0) {
            var4 = var0.r[var0.v++] & 255;

            for(var13 = 0; var13 < var4; ++var13) {
               var15 = client.fd.decodeVarValue(var0);
               var7 = var2.by.h(var15.g);
               var2.by.s(var15.g, var15.d);
               if (var2 != j()) {
                  player.cv(var2, var15.g, var15.d);
               }

               if (!Kh56.g(var15.d, var7)) {
                  var8 = client.fd.list(var15.g);
                  var9 = player.ex(var2, var8.debugNameHash32);
                  if (var9 != null) {
                     var2.triggerEvent(var9, var15.d);
                  }
               }
            }
         }

      }
   }

   static {
      b = Quaternion.g;
      l = 0;
      w = new LinkedList();
      r = new player[2048];
      v = new Gg3[2048];
   }

   public static player e(int var0) {
      return r[var0];
   }
}
