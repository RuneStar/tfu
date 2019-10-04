// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.geographicentities;

import com.jagex.game.runetek6.comms.broadcast.CommonStateAndEventTypes;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import tfu.Ll42;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.gameentity.Component;
import rs2.shared.movement.Z36;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.shared.movement.Ai37;
import rs2.shared.movement.F277;
import rs2.shared.movement.T278;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.gameentity.GameEntity;
import rs2.client.client;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import org.slf4j.Logger;
import java.util.Map;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;

@ScriptEntryClass("GeographicEntityWranglerClientPRIVATE")
@Be2
public class GeographicEntityWranglerClient extends GeographicEntityWrangler
{
    private static Map d;
    private static final Logger logger;
    
    public static void g(final BroadcastStateAndEventsTypes$AppearedPayload broadcastStateAndEventsTypes$AppearedPayload) {
        if (!client.bg(broadcastStateAndEventsTypes$AppearedPayload.areaID)) {
            GeographicEntityWranglerClient.logger.warn("Ignoring 'appeared' in area instance id #" + broadcastStateAndEventsTypes$AppearedPayload.areaID + "; this isn't the client's instance id.");
            return;
        }
        final Scene mm = client.mm;
        final String wranglerID = broadcastStateAndEventsTypes$AppearedPayload.wranglerID;
        final GeographicEntityWranglerClient h = h(wranglerID);
        GeographicEntityWranglerClient.logger.trace("generic 'appeared', wranglerID=" + broadcastStateAndEventsTypes$AppearedPayload.wranglerID + " found tclient for that wranglerID is " + h);
        if (h != null) {
            GameEntity gameEntity = null;
            if (h.getAutoCreateOnClient()) {
                gameEntity = new GameEntity(broadcastStateAndEventsTypes$AppearedPayload.broadcasterID, client.cj);
                gameEntity.setObjectTransform(broadcastStateAndEventsTypes$AppearedPayload.transform);
                mm.add(gameEntity);
                if (h.getCreateScheduledMovementComponent()) {
                    final ScheduledMovementComponent g = ScheduledMovementComponent.g(gameEntity.bg, new F277(new T278(broadcastStateAndEventsTypes$AppearedPayload.transform.trans)));
                    GameEntity.ep(gameEntity, g);
                    g.b();
                    ScheduledMovementComponent.u(g, client.dq);
                }
            }
            final EventHandler appearedEvent = h.appearedEvent;
            if (appearedEvent != null) {
                GeographicEntityWranglerClient.logger.trace("- found 'appeared' event is {}", appearedEvent);
                appearedEvent.trigger(wranglerID, broadcastStateAndEventsTypes$AppearedPayload.broadcasterID);
            }
            client.cj.event.triggerEvent(h.getAppearedEventName(), new Object[] { mm, broadcastStateAndEventsTypes$AppearedPayload.areaID, broadcastStateAndEventsTypes$AppearedPayload.broadcasterID.toString(), gameEntity });
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(GeographicEntityWranglerClient.class);
        GeographicEntityWranglerClient.d = new HashMap();
    }
    
    public static void q(final String s, final BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
    }
    
    public static void j(final BroadcastStateAndEventsTypes$GonePayload broadcastStateAndEventsTypes$GonePayload) {
        if (!client.bg(broadcastStateAndEventsTypes$GonePayload.areaID)) {
            GeographicEntityWranglerClient.logger.warn("Ignoring 'gone' in area instance id #" + broadcastStateAndEventsTypes$GonePayload.areaID + "; this isn't the client's instance id.");
            return;
        }
        final Scene mm = client.mm;
        final String wranglerID = broadcastStateAndEventsTypes$GonePayload.wranglerID;
        final GeographicEntityWranglerClient h = h(wranglerID);
        GeographicEntityWranglerClient.logger.trace("generic 'gone', wranglerID=" + broadcastStateAndEventsTypes$GonePayload.wranglerID + " found tclient for that wranglerID is " + h);
        if (h != null) {
            final GameEntity t = Scene.t(mm, broadcastStateAndEventsTypes$GonePayload.broadcasterID);
            final EventHandler goneEvent = h.goneEvent;
            if (goneEvent != null) {
                GeographicEntityWranglerClient.logger.trace("- found 'gone' event is {}", goneEvent);
                goneEvent.trigger(wranglerID, t);
            }
            client.cj.event.triggerEvent(h.getGoneEventName(), new Object[] { mm, broadcastStateAndEventsTypes$GonePayload.areaID, broadcastStateAndEventsTypes$GonePayload.broadcasterID.toString(), t });
            if (h.getAutoDestroyOnClient() && t != null) {
                Ll42.q(client.gz, t);
                t.removeFromScene();
            }
        }
    }
    
    public static GeographicEntityWranglerClient e(final String str) {
        if (GeographicEntityWranglerClient.d.containsKey(str)) {
            throw new RuntimeException("Wrangler id " + str + " already has a wrangler registered.");
        }
        final GeographicEntityWranglerClient geographicEntityWranglerClient = new GeographicEntityWranglerClient(str);
        GeographicEntityWranglerClient.d.put(str, geographicEntityWranglerClient);
        return geographicEntityWranglerClient;
    }
    
    public static GeographicEntityWranglerClient h(final String s) {
        return GeographicEntityWranglerClient.d.get(s);
    }
    
    public static void s(final String s) {
        GeographicEntityWranglerClient.d.remove(s);
    }
    
    public static void d(final String s, final BroadcastStateAndEventsTypes$StatePayload obj) {
        if (!client.bg(obj.areaID)) {
            GeographicEntityWranglerClient.logger.warn("Ignoring 'state' in area instance id #" + obj.areaID + "; this isn't the client's instance id.");
            return;
        }
        final Scene mm = client.mm;
        final String wranglerID = obj.wranglerID;
        final GeographicEntityWranglerClient h = h(wranglerID);
        GeographicEntityWranglerClient.logger.trace("generic 'state', wranglerID=" + obj.wranglerID + " found tclient for that wranglerID is " + h);
        if (h != null && h.getAutoCreateOnClient() && s.equals(CommonStateAndEventTypes.entityConfigDef.messageName)) {
            GeographicEntityWranglerClient.logger.trace("it was a config state, aimed at wranglerID=" + obj.wranglerID + " which auto-creates.  spawning.");
            final GameEntity t = Scene.t(mm, obj.broadcasterID);
            if (t == null) {
                GeographicEntityWranglerClient.logger.warn("Couldn't find entity for scenery state payload " + obj);
            }
            else {
                client.bc(obj, t, new G258(h, wranglerID, t, mm, obj));
            }
        }
    }
    
    public GeographicEntityWranglerClient(final String s) {
        super(s);
    }
}
