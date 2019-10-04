package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.worldelement.player;
import tfu.Bb4;

final class F407 extends V385 {
   // $FF: synthetic field
   final BroadcastStateAndEventsTypes$StatePayload d;
   // $FF: synthetic field
   final BroadcastStateAndEventsTypes$StateDefinition g;
   // $FF: synthetic field
   final player j;

   void g() {
      GeographicEntityWranglerClient.d(this.g.messageName, this.d);
      if (this.j != null) {
         this.j.cb(this.g.messageName, this.d);
      }

   }

   F407(Bb4 var1, BroadcastStateAndEventsTypes$StateDefinition var2, BroadcastStateAndEventsTypes$StatePayload var3, player var4) {
      super(var1);
      this.d = var3;
      this.j = var4;
      this.g = var2;
   }
}
