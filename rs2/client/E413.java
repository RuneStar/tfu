// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import tfu.Bb4;
import tfu.Gc330;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;

final class E413 extends V385
{
    final /* synthetic */ BroadcastStateAndEventsTypes$EventPayload d;
    final /* synthetic */ BroadcastStateAndEventsTypes$EventDefinition g;
    
    @Override
    void g() {
        GeographicEntityWranglerClient.q(this.g.messageName, this.d);
        Gc330.j().cm(this.g.messageName, this.d);
    }
    
    E413(final Bb4 bb4, final BroadcastStateAndEventsTypes$EventDefinition g, final BroadcastStateAndEventsTypes$EventPayload d) {
        this.d = d;
        super(bb4);
        this.g = g;
    }
}
