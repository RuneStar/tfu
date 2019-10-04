// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import tfu.Bb4;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.worldelement.player;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;

final class F407 extends V385
{
    final /* synthetic */ BroadcastStateAndEventsTypes$StatePayload d;
    final /* synthetic */ BroadcastStateAndEventsTypes$StateDefinition g;
    final /* synthetic */ player j;
    
    @Override
    void g() {
        GeographicEntityWranglerClient.d(this.g.messageName, this.d);
        if (this.j != null) {
            this.j.cb(this.g.messageName, this.d);
        }
    }
    
    F407(final Bb4 bb4, final BroadcastStateAndEventsTypes$StateDefinition g, final BroadcastStateAndEventsTypes$StatePayload d, final player j) {
        this.d = d;
        this.j = j;
        super(bb4);
        this.g = g;
    }
}
