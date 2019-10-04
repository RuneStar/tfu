package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.worldelement.player;
import tfu.Bb4;
import tfu.Gc330;

final class M411 extends V385 {
   // $FF: synthetic field
   final BroadcastStateAndEventsTypes$AppearedPayload g;

   void g() {
      GeographicEntityWranglerClient.g(this.g);
      player var1 = Gc330.j();
      if (var1 != null) {
         var1.cc(this.g);
      }

   }

   M411(Bb4 var1, BroadcastStateAndEventsTypes$AppearedPayload var2) {
      super(var1);
      this.g = var2;
   }
}
