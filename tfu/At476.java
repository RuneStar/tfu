package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.sound.SoundManager;
import rs2.client.worldelement.Npc;
import rs2.client.worldelement.player;

public class At476 {
   private static final int d = 75;
   private static Ha262 e = new Ha262(16);
   private static Gx298 h = new Gx298();
   private static Gx298 j = new Gx298();
   private static final Logger logger = LoggerFactory.getLogger(At476.class);
   private static Gx298 q = new Gx298();
   private static Ha262 s = new Ha262(16);

   public static void e(player var0) {
      logger.trace("Attempting player sound update");
      As554 var1 = (As554)Ha262.d(e, (long)var0.m);
      if (var1 == null) {
         q(var0);
      } else {
         j(var0);
         q(var0);
      }

   }

   public static void g(boolean var0) {
      Am548 var1;
      for(var1 = (Am548)Gx298.i(q); var1 != null; var1 = (Am548)Gx298.c(q)) {
         if (var1.a != null) {
            Dn555.s(SoundManager.t, var1.a);
            var1.a = null;
         }

         Am548.ef(var1);
         Gx298.t(h, var1);
      }

      if (var0) {
         for(var1 = (Am548)Gx298.i(j); var1 != null; var1 = (Am548)Gx298.c(j)) {
            if (var1.a != null) {
               Dn555.s(SoundManager.t, var1.a);
               var1.a = null;
            }

            Am548.ef(var1);
         }

         for(As554 var2 = (As554)Ha262.e(e); var2 != null; var2 = (As554)Ha262.h(e)) {
            if (var2.d != null && var2.d.a != null) {
               Dn555.s(SoundManager.t, var2.d.a);
               var2.d.a = null;
            }

            if (var2.q != null && var2.q.a != null) {
               Dn555.s(SoundManager.t, var2.q.a);
               var2.q.a = null;
            }

            As554.ef(var2);
         }
      }

   }

   public static void d() {
      Am548 var0;
      for(var0 = (Am548)Gx298.i(q); var0 != null; var0 = (Am548)Gx298.c(q)) {
         if (var0.e) {
            var0.g();
         }
      }

      for(var0 = (Am548)Gx298.i(j); var0 != null; var0 = (Am548)Gx298.c(j)) {
         if (var0.e) {
            var0.g();
         }
      }

   }

   public static void q(player var0) {
      Ac557 var1 = null;
      if (var0.ac != -1) {
         var1 = new Ac557(var0);
         var1.c = var0.ac;
         var1.k = var0.ab;
         var1.d = var0.aw << 2;
         var1.q = var0.ax;
         var1.n = 256;
         var1.m = 256;
         var1.g = var0.ar << 2;
      }

      Ac557 var2 = null;
      if (var0.at != -1) {
         var2 = new Ac557(var0);
         var2.c = var0.at;
         var2.k = var0.ab;
         var2.d = var0.aw << 2;
         var2.q = var0.ax;
         var2.n = 256;
         var2.m = 256;
         var2.g = var0.ar << 2;
      }

      Ha262.q(e, new As554(var0, var1, var2), (long)var0.m);
   }

   static int h(Npc var0) {
      byte var1 = -1;
      return var1;
   }

   public static void j(player var0) {
      logger.trace("Attempting player sound removal");
      As554 var1 = (As554)Ha262.d(e, (long)var0.m);
      if (var1 != null) {
         if (var1.d != null && var1.d.a != null) {
            Dn555.s(SoundManager.t, var1.d.a);
            var1.d.a = null;
         }

         if (var1.q != null && var1.q.a != null) {
            Dn555.s(SoundManager.t, var1.q.a);
            var1.q.a = null;
         }

         As554.ef(var1);
      }

   }
}
