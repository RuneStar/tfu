package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.worldelement.player;
import tfu.Bb4;
import tfu.Gc330;

final class Aq668 extends V385 {
   // $FF: synthetic field
   final BroadcastStateAndEventsTypes$GonePayload g;

   void g() {
      GeographicEntityWranglerClient.j(this.g);
      player var1 = Gc330.j();
      if (var1 != null) {
         var1.cx(this.g);
      }

   }

   Aq668(Bb4 var1, BroadcastStateAndEventsTypes$GonePayload var2) {
      super(var1);
      this.g = var2;
   }
}
