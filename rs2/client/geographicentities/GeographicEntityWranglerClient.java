/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.geographicentities;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessageDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.CommonStateAndEventTypes;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import rs2.client.geographicentities.G258;
import rs2.shared.movement.Ai37;
import rs2.shared.movement.F277;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.shared.movement.T278;
import tfu.Bb4;
import tfu.Be2;
import tfu.Ll42;

@ScriptEntryClass(value="GeographicEntityWranglerClientPRIVATE")
@Be2
public class GeographicEntityWranglerClient
extends GeographicEntityWrangler {
    private static Map d;
    private static final Logger logger;

    public static void g(BroadcastStateAndEventsTypes$AppearedPayload broadcastStateAndEventsTypes$AppearedPayload) {
        if (!client.bg(broadcastStateAndEventsTypes$AppearedPayload.areaID)) {
            logger.warn("Ignoring 'appeared' in area instance id #" + broadcastStateAndEventsTypes$AppearedPayload.areaID + "; this isn't the client's instance id.");
            return;
        }
        Scene scene = client.mm;
        String string = broadcastStateAndEventsTypes$AppearedPayload.wranglerID;
        GeographicEntityWranglerClient geographicEntityWranglerClient = GeographicEntityWranglerClient.h(string);
        logger.trace("generic 'appeared', wranglerID=" + broadcastStateAndEventsTypes$AppearedPayload.wranglerID + " found tclient for that wranglerID is " + geographicEntityWranglerClient);
        if (geographicEntityWranglerClient != null) {
            Object object;
            GameEntity gameEntity = null;
            if (geographicEntityWranglerClient.getAutoCreateOnClient()) {
                gameEntity = new GameEntity(broadcastStateAndEventsTypes$AppearedPayload.broadcasterID, client.cj);
                gameEntity.setObjectTransform(broadcastStateAndEventsTypes$AppearedPayload.transform);
                scene.add(gameEntity);
                if (geographicEntityWranglerClient.getCreateScheduledMovementComponent()) {
                    object = ScheduledMovementComponent.g(gameEntity.bg, new F277(new T278(broadcastStateAndEventsTypes$AppearedPayload.transform.trans)));
                    GameEntity.ep(gameEntity, (Component)object);
                    ((ScheduledMovementComponent)object).b();
                    ScheduledMovementComponent.u((ScheduledMovementComponent)object, client.dq);
                }
            }
            if ((object = geographicEntityWranglerClient.appearedEvent) != null) {
                logger.trace("- found 'appeared' event is {}", object);
                ((EventHandler)object).trigger(string, broadcastStateAndEventsTypes$AppearedPayload.broadcasterID);
            }
            client.cj.event.triggerEvent(geographicEntityWranglerClient.getAppearedEventName(), (Object)new Object[]{scene, broadcastStateAndEventsTypes$AppearedPayload.areaID, broadcastStateAndEventsTypes$AppearedPayload.broadcasterID.toString(), gameEntity});
        }
    }

    static {
        logger = LoggerFactory.getLogger(GeographicEntityWranglerClient.class);
        d = new HashMap();
    }

    public static void q(String string, BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
    }

    public static void j(BroadcastStateAndEventsTypes$GonePayload broadcastStateAndEventsTypes$GonePayload) {
        if (!client.bg(broadcastStateAndEventsTypes$GonePayload.areaID)) {
            logger.warn("Ignoring 'gone' in area instance id #" + broadcastStateAndEventsTypes$GonePayload.areaID + "; this isn't the client's instance id.");
            return;
        }
        Scene scene = client.mm;
        String string = broadcastStateAndEventsTypes$GonePayload.wranglerID;
        GeographicEntityWranglerClient geographicEntityWranglerClient = GeographicEntityWranglerClient.h(string);
        logger.trace("generic 'gone', wranglerID=" + broadcastStateAndEventsTypes$GonePayload.wranglerID + " found tclient for that wranglerID is " + geographicEntityWranglerClient);
        if (geographicEntityWranglerClient != null) {
            GameEntity gameEntity = Scene.t(scene, broadcastStateAndEventsTypes$GonePayload.broadcasterID);
            EventHandler eventHandler = geographicEntityWranglerClient.goneEvent;
            if (eventHandler != null) {
                logger.trace("- found 'gone' event is {}", eventHandler);
                eventHandler.trigger(string, gameEntity);
            }
            client.cj.event.triggerEvent(geographicEntityWranglerClient.getGoneEventName(), (Object)new Object[]{scene, broadcastStateAndEventsTypes$GonePayload.areaID, broadcastStateAndEventsTypes$GonePayload.broadcasterID.toString(), gameEntity});
            if (geographicEntityWranglerClient.getAutoDestroyOnClient() && gameEntity != null) {
                Ll42.q(client.gz, gameEntity);
                gameEntity.removeFromScene();
            }
        }
    }

    public static GeographicEntityWranglerClient e(String string) {
        if (d.containsKey(string)) {
            throw new RuntimeException("Wrangler id " + string + " already has a wrangler registered.");
        }
        GeographicEntityWranglerClient geographicEntityWranglerClient = new GeographicEntityWranglerClient(string);
        d.put(string, geographicEntityWranglerClient);
        return geographicEntityWranglerClient;
    }

    public static GeographicEntityWranglerClient h(String string) {
        return (GeographicEntityWranglerClient)d.get(string);
    }

    public static void s(String string) {
        d.remove(string);
    }

    public static void d(String string, BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload) {
        if (!client.bg(broadcastStateAndEventsTypes$StatePayload.areaID)) {
            logger.warn("Ignoring 'state' in area instance id #" + broadcastStateAndEventsTypes$StatePayload.areaID + "; this isn't the client's instance id.");
            return;
        }
        Scene scene = client.mm;
        String string2 = broadcastStateAndEventsTypes$StatePayload.wranglerID;
        GeographicEntityWranglerClient geographicEntityWranglerClient = GeographicEntityWranglerClient.h(string2);
        logger.trace("generic 'state', wranglerID=" + broadcastStateAndEventsTypes$StatePayload.wranglerID + " found tclient for that wranglerID is " + geographicEntityWranglerClient);
        if (geographicEntityWranglerClient != null && geographicEntityWranglerClient.getAutoCreateOnClient() && string.equals(CommonStateAndEventTypes.entityConfigDef.messageName)) {
            logger.trace("it was a config state, aimed at wranglerID=" + broadcastStateAndEventsTypes$StatePayload.wranglerID + " which auto-creates.  spawning.");
            GameEntity gameEntity = Scene.t(scene, broadcastStateAndEventsTypes$StatePayload.broadcasterID);
            if (gameEntity == null) {
                logger.warn("Couldn't find entity for scenery state payload " + broadcastStateAndEventsTypes$StatePayload);
            } else {
                client.bc(broadcastStateAndEventsTypes$StatePayload, gameEntity, new G258(geographicEntityWranglerClient, string2, gameEntity, scene, broadcastStateAndEventsTypes$StatePayload));
            }
        }
    }

    static /* synthetic */ Logger b() {
        return logger;
    }

    public GeographicEntityWranglerClient(String string) {
        super(string);
    }
}

