/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import rs2.client.V385;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.worldelement.player;
import tfu.Bb4;
import tfu.Gc330;

final class Aq668
extends V385 {
    final /* synthetic */ BroadcastStateAndEventsTypes$GonePayload g;

    @Override
    void g() {
        GeographicEntityWranglerClient.j(this.g);
        player player2 = Gc330.j();
        if (player2 != null) {
            player2.cx(this.g);
        }
    }

    Aq668(Bb4 bb4, BroadcastStateAndEventsTypes$GonePayload broadcastStateAndEventsTypes$GonePayload) {
        super(bb4);
        this.g = broadcastStateAndEventsTypes$GonePayload;
    }
}

