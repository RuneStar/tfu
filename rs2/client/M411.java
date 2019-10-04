/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import rs2.client.V385;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.worldelement.player;
import tfu.Bb4;
import tfu.Gc330;

final class M411
extends V385 {
    final /* synthetic */ BroadcastStateAndEventsTypes$AppearedPayload g;

    @Override
    void g() {
        GeographicEntityWranglerClient.g(this.g);
        player player2 = Gc330.j();
        if (player2 != null) {
            player2.cc(this.g);
        }
    }

    M411(Bb4 bb4, BroadcastStateAndEventsTypes$AppearedPayload broadcastStateAndEventsTypes$AppearedPayload) {
        super(bb4);
        this.g = broadcastStateAndEventsTypes$AppearedPayload;
    }
}

