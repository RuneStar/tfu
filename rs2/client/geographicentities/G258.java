// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.geographicentities;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.client.client;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;

final class G258 implements Runnable
{
    final /* synthetic */ String d;
    final /* synthetic */ BroadcastStateAndEventsTypes$StatePayload e;
    final /* synthetic */ GeographicEntityWrangler g;
    final /* synthetic */ Scene j;
    final /* synthetic */ GameEntity q;
    
    @Override
    public void run() {
        final EventHandler configuredEvent = this.g.configuredEvent;
        if (configuredEvent != null) {
            GeographicEntityWranglerClient.logger.trace("- found 'configured' event is {}", configuredEvent);
            configuredEvent.trigger(this.d, this.q);
        }
        client.cj.event.triggerEvent(this.g.getConfiguredEventName(), new Object[] { this.j, this.e.areaID, this.e.broadcasterID.toString(), this.q });
    }
    
    G258(final GeographicEntityWrangler g, final String d, final GameEntity q, final Scene j, final BroadcastStateAndEventsTypes$StatePayload e) {
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.g = g;
    }
}
