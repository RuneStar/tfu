/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.geographicentities;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptManager;
import rs2.client.client;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import tfu.Bb4;

final class G258
implements Runnable {
    final /* synthetic */ String d;
    final /* synthetic */ BroadcastStateAndEventsTypes$StatePayload e;
    final /* synthetic */ GeographicEntityWrangler g;
    final /* synthetic */ Scene j;
    final /* synthetic */ GameEntity q;

    @Override
    public void run() {
        EventHandler eventHandler = this.g.configuredEvent;
        if (eventHandler != null) {
            GeographicEntityWranglerClient.b().trace("- found 'configured' event is {}", eventHandler);
            eventHandler.trigger(this.d, this.q);
        }
        client.cj.event.triggerEvent(this.g.getConfiguredEventName(), (Object)new Object[]{this.j, this.e.areaID, this.e.broadcasterID.toString(), this.q});
    }

    G258(GeographicEntityWrangler geographicEntityWrangler, String string, GameEntity gameEntity, Scene scene, BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload) {
        this.d = string;
        this.q = gameEntity;
        this.j = scene;
        this.e = broadcastStateAndEventsTypes$StatePayload;
        this.g = geographicEntityWrangler;
    }
}

