/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.worldelement;

import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.event.EventHandler;
import java.io.IOException;
import rs2.client.client;
import rs2.client.worldelement.player;

class S34
extends EventHandler {
    final /* synthetic */ player g;

    @Override
    public void trigger(Object object, Object object2) {
        try {
            client.dq.sendOutgoingPackets();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    S34(player player2) {
        this.g = player2;
    }
}

