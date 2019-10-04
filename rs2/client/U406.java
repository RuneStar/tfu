package rs2.client;

import rs2.client.inventory.ClientInventory;
import rs2.client.worldelement.player;
import tfu.Gc330;

final class U406 extends Ag389 {
   // $FF: synthetic field
   final ClientInventory g;

   public String toString() {
      return "INV_TRANSMIT full " + this.g;
   }

   U406(ClientInventory var1) {
      this.g = var1;
   }

   protected void d() {
      player var1 = Gc330.j();
      var1.eh("INV_TRANSMIT", new Object[]{this.g, true});
   }

   protected void g() {
   }
}
