package rs2.client.geographicentities;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.CommonStateAndEventTypes;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import rs2.shared.movement.F277;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.shared.movement.T278;
import tfu.Be2;
import tfu.Ll42;

@ScriptEntryClass("GeographicEntityWranglerClientPRIVATE")
@Be2
public class GeographicEntityWranglerClient extends GeographicEntityWrangler {
   private static Map d = new HashMap();
   private static final Logger logger = LoggerFactory.getLogger(GeographicEntityWranglerClient.class);

   public static void g(BroadcastStateAndEventsTypes$AppearedPayload var0) {
      if (!client.bg(var0.areaID)) {
         logger.warn("Ignoring 'appeared' in area instance id #" + var0.areaID + "; this isn't the client's instance id.");
      } else {
         Scene var1 = client.mm;
         String var2 = var0.wranglerID;
         GeographicEntityWranglerClient var3 = h(var2);
         logger.trace("generic 'appeared', wranglerID=" + var0.wranglerID + " found tclient for that wranglerID is " + var3);
         if (var3 != null) {
            GameEntity var4 = null;
            if (var3.getAutoCreateOnClient()) {
               var4 = new GameEntity(var0.broadcasterID, client.cj);
               var4.setObjectTransform(var0.transform);
               var1.add(var4);
               if (var3.getCreateScheduledMovementComponent()) {
                  ScheduledMovementComponent var5 = ScheduledMovementComponent.g(var4.bg, new F277(new T278(var0.transform.trans)));
                  GameEntity.ep(var4, var5);
                  var5.b();
                  ScheduledMovementComponent.u(var5, client.dq);
               }
            }

            EventHandler var6 = var3.appearedEvent;
            if (var6 != null) {
               logger.trace("- found 'appeared' event is {}", var6);
               var6.trigger(var2, var0.broadcasterID);
            }

            client.cj.event.triggerEvent((String)var3.getAppearedEventName(), new Object[]{var1, var0.areaID, var0.broadcasterID.toString(), var4});
         }

      }
   }

   public static void q(String var0, BroadcastStateAndEventsTypes$EventPayload var1) {
   }

   public static void j(BroadcastStateAndEventsTypes$GonePayload var0) {
      if (!client.bg(var0.areaID)) {
         logger.warn("Ignoring 'gone' in area instance id #" + var0.areaID + "; this isn't the client's instance id.");
      } else {
         Scene var1 = client.mm;
         String var2 = var0.wranglerID;
         GeographicEntityWranglerClient var3 = h(var2);
         logger.trace("generic 'gone', wranglerID=" + var0.wranglerID + " found tclient for that wranglerID is " + var3);
         if (var3 != null) {
            GameEntity var4 = Scene.t(var1, var0.broadcasterID);
            EventHandler var5 = var3.goneEvent;
            if (var5 != null) {
               logger.trace("- found 'gone' event is {}", var5);
               var5.trigger(var2, var4);
            }

            client.cj.event.triggerEvent((String)var3.getGoneEventName(), new Object[]{var1, var0.areaID, var0.broadcasterID.toString(), var4});
            if (var3.getAutoDestroyOnClient() && var4 != null) {
               Ll42.q(client.gz, var4);
               var4.removeFromScene();
            }
         }

      }
   }

   public static GeographicEntityWranglerClient e(String var0) {
      if (d.containsKey(var0)) {
         throw new RuntimeException("Wrangler id " + var0 + " already has a wrangler registered.");
      } else {
         GeographicEntityWranglerClient var1 = new GeographicEntityWranglerClient(var0);
         d.put(var0, var1);
         return var1;
      }
   }

   public static GeographicEntityWranglerClient h(String var0) {
      return (GeographicEntityWranglerClient)d.get(var0);
   }

   public static void s(String var0) {
      d.remove(var0);
   }

   public static void d(String var0, BroadcastStateAndEventsTypes$StatePayload var1) {
      if (!client.bg(var1.areaID)) {
         logger.warn("Ignoring 'state' in area instance id #" + var1.areaID + "; this isn't the client's instance id.");
      } else {
         Scene var2 = client.mm;
         String var3 = var1.wranglerID;
         GeographicEntityWranglerClient var4 = h(var3);
         logger.trace("generic 'state', wranglerID=" + var1.wranglerID + " found tclient for that wranglerID is " + var4);
         if (var4 != null && var4.getAutoCreateOnClient() && var0.equals(CommonStateAndEventTypes.entityConfigDef.messageName)) {
            logger.trace("it was a config state, aimed at wranglerID=" + var1.wranglerID + " which auto-creates.  spawning.");
            GameEntity var5 = Scene.t(var2, var1.broadcasterID);
            if (var5 == null) {
               logger.warn("Couldn't find entity for scenery state payload " + var1);
            } else {
               client.bc(var1, var5, new G258(var4, var3, var5, var2, var1));
            }
         }

      }
   }

   // $FF: synthetic method
   static Logger b() {
      return logger;
   }

   public GeographicEntityWranglerClient(String var1) {
      super(var1);
   }
}
