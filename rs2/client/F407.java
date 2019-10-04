/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessageDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import rs2.client.V385;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.worldelement.player;
import tfu.Bb4;

final class F407
extends V385 {
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

    F407(Bb4 bb4, BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition, BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload, player player2) {
        this.d = broadcastStateAndEventsTypes$StatePayload;
        this.j = player2;
        super(bb4);
        this.g = broadcastStateAndEventsTypes$StateDefinition;
    }
}

