/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessageDefinition;
import rs2.client.V385;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.worldelement.player;
import tfu.Bb4;
import tfu.Gc330;

final class E413
extends V385 {
    final /* synthetic */ BroadcastStateAndEventsTypes$EventPayload d;
    final /* synthetic */ BroadcastStateAndEventsTypes$EventDefinition g;

    @Override
    void g() {
        GeographicEntityWranglerClient.q(this.g.messageName, this.d);
        player player2 = Gc330.j();
        player2.cm(this.g.messageName, this.d);
    }

    E413(Bb4 bb4, BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition, BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
        this.d = broadcastStateAndEventsTypes$EventPayload;
        super(bb4);
        this.g = broadcastStateAndEventsTypes$EventDefinition;
    }
}

