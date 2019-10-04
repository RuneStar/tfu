package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.worldelement.player;
import tfu.Bb4;
import tfu.Gc330;

final class E413 extends V385 {
   // $FF: synthetic field
   final BroadcastStateAndEventsTypes$EventPayload d;
   // $FF: synthetic field
   final BroadcastStateAndEventsTypes$EventDefinition g;

   void g() {
      GeographicEntityWranglerClient.q(this.g.messageName, this.d);
      player var1 = Gc330.j();
      var1.cm(this.g.messageName, this.d);
   }

   E413(Bb4 var1, BroadcastStateAndEventsTypes$EventDefinition var2, BroadcastStateAndEventsTypes$EventPayload var3) {
      super(var1);
      this.d = var3;
      this.g = var2;
   }
}
