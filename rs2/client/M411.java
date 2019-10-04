// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import tfu.Bb4;
import rs2.client.worldelement.player;
import tfu.Gc330;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;

final class M411 extends V385
{
    final /* synthetic */ BroadcastStateAndEventsTypes$AppearedPayload g;
    
    @Override
    void g() {
        GeographicEntityWranglerClient.g(this.g);
        final player j = Gc330.j();
        if (j != null) {
            j.cc(this.g);
        }
    }
    
    M411(final Bb4 bb4, final BroadcastStateAndEventsTypes$AppearedPayload g) {
        super(bb4);
        this.g = g;
    }
}
