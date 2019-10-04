package rs2.client;

import java.util.List;
import rs2.client.inventory.ClientInventory;
import rs2.client.worldelement.player;
import tfu.Gc330;

final class Y388 extends Ag389 {
   // $FF: synthetic field
   final List d;
   // $FF: synthetic field
   final ClientInventory g;

   public String toString() {
      return "INV_TRANSMIT partial " + this.g;
   }

   protected void g() {
   }

   protected void d() {
      player var1 = Gc330.j();
      var1.eh("INV_TRANSMIT", new Object[]{this.g, false, this.d});
   }

   Y388(ClientInventory var1, List var2) {
      this.d = var2;
      this.g = var1;
   }
}
