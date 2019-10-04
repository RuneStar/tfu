package rs2.client.geographicentities;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import rs2.client.client;

final class G258 implements Runnable {
   // $FF: synthetic field
   final String d;
   // $FF: synthetic field
   final BroadcastStateAndEventsTypes$StatePayload e;
   // $FF: synthetic field
   final GeographicEntityWrangler g;
   // $FF: synthetic field
   final Scene j;
   // $FF: synthetic field
   final GameEntity q;

   public void run() {
      EventHandler var1 = this.g.configuredEvent;
      if (var1 != null) {
         GeographicEntityWranglerClient.b().trace("- found 'configured' event is {}", var1);
         var1.trigger(this.d, this.q);
      }

      client.cj.event.triggerEvent((String)this.g.getConfiguredEventName(), new Object[]{this.j, this.e.areaID, this.e.broadcasterID.toString(), this.q});
   }

   G258(GeographicEntityWrangler var1, String var2, GameEntity var3, Scene var4, BroadcastStateAndEventsTypes$StatePayload var5) {
      this.d = var2;
      this.q = var3;
      this.j = var4;
      this.e = var5;
      this.g = var1;
   }
}
