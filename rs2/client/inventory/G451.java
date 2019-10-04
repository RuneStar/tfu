package rs2.client.inventory;

import tfu.Ha262;

public final class G451 {
   private static final Ha262 g = new Ha262(32);

   public static ClientInventory g(int var0, boolean var1) {
      long var2 = (long)(var0 | (var1 ? Integer.MIN_VALUE : 0));
      return (ClientInventory)Ha262.d(g, var2);
   }

   public static ClientInventory d(int var0, boolean var1) {
      long var2 = (long)(var0 | (var1 ? Integer.MIN_VALUE : 0));
      ClientInventory var4 = (ClientInventory)Ha262.d(g, var2);
      if (var4 == null) {
         var4 = new ClientInventory(var0);
         Ha262.q(g, var4, var2);
      }

      return var4;
   }

   public static void q(int var0, boolean var1) {
      ClientInventory var2 = g(var0, var1);
      if (var2 != null) {
         ClientInventory.d(var2);
         var2.d = true;
         ClientInventory.ef(var2);
      }
   }

   public static void j() {
      for(ClientInventory var0 = (ClientInventory)Ha262.e(g); var0 != null; var0 = (ClientInventory)Ha262.h(g)) {
         ClientInventory.d(var0);
         var0.d = true;
      }

      Ha262.j(g);
   }
}
