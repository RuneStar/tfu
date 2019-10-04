package rs2.client.chat;

import com.jagex.game.runetek6.gameentity.GameEntity;
import rs2.client.client;
import rs2.client.worldelement.player;
import tfu.Bb4;

public class G232 {
   private static int d;
   public static final int g = 100;
   private static int j = 0;
   public static final ChatLine[] q = new ChatLine[100];

   public static int e() {
      return d;
   }

   public static void d(int var0, String var1) {
      q(var0, 0, "", "", "", var1);
   }

   public static void j(int var0, int var1, String var2, String var3, String var4, String var5, String var6, int var7) {
      ChatLine var8 = q[99];

      for(int var9 = 99; var9 > 0; --var9) {
         q[var9] = q[var9 - 1];
      }

      if (var8 == null) {
         var8 = new ChatLine(var0, var1, var2, var3, var4, var6, var7, var5);
      } else {
         ChatLine.g(var8, var0, var1, var2, var3, var4, var6, var7, var5);
      }

      q[0] = var8;
      ++d;
      player var12 = null;
      if (var2.startsWith("PLAYER:")) {
         Bb4 var10 = Bb4.g(var3);
         GameEntity var11 = GameEntity.es(var10);
         if (var11 == null) {
            var2 = "Unknown";
         } else if (var11 instanceof player) {
            var12 = (player)var11;
            var2 = var12.aq;
         }
      }

      Object[] var13 = new Object[]{var5, var2 != null && !var2.equals("") ? var2 : null, var6 != null && !var6.equals("") ? var6 : null, var0, var1, var12};
      client.cj.event.triggerEvent((String)"CHAT", var13);
   }

   public static void q(int var0, int var1, String var2, String var3, String var4, String var5) {
      j(var0, var1, var2, var3, var4, var5, (String)null, -1);
   }

   public static void h() {
      for(int var0 = 0; var0 < 100; ++var0) {
         q[var0] = null;
      }

      d = 0;
   }

   static int g() {
      return j++;
   }
}
