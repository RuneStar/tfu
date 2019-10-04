package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.xelement.XElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("GeographicEntityWranglerPRIVATE")
public class GeographicEntityWrangler {
   private static final Logger logger = LoggerFactory.getLogger(GeographicEntityWrangler.class);
   public EventHandler appearedEvent;
   protected String appearedScriptEventName;
   protected boolean autoCreateOnClient;
   protected boolean autoDestroyOnClient;
   protected Object auxData;
   public EventHandler configuredEvent;
   protected String configuredScriptEventName;
   protected boolean createScheduledMovementComponent;
   public EventHandler goneEvent;
   protected String goneScriptEventName;
   protected float proximityRadius;
   protected String serverEntityProximityEnterScriptEventName;
   protected String serverEntityProximityLeaveScriptEventName;
   protected String serverNPCProximityEnterScriptEventName;
   protected String serverNPCProximityLeaveScriptEventName;
   protected String serverPlayerBroadcastEnterScriptEventName;
   protected String serverPlayerBroadcastLeaveScriptEventName;
   protected String serverPlayerProximityEnterScriptEventName;
   protected String serverPlayerProximityLeaveScriptEventName;
   protected String teardownScriptEventName;
   protected XElement templateElement;
   private String templateElementName;
   protected String timerScriptEventName;
   protected final String wranglerID;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GeographicEntityWrangler setAutoCreateOnClient(boolean var1) {
      this.autoCreateOnClient = var1;
      return this;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GeographicEntityWrangler setAutoDestroyOnClient(boolean var1) {
      this.autoDestroyOnClient = var1;
      return this;
   }

   public boolean getAutoCreateOnClient() {
      return this.autoCreateOnClient;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GeographicEntityWrangler setProximityRadius(float var1) {
      this.proximityRadius = var1;
      return this;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setTemplateElement(String var1) {
      this.templateElementName = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setAuxData(Object var1) {
      this.auxData = var1;
   }

   protected GeographicEntityWrangler(String var1) {
      this.wranglerID = var1;
      this.appearedScriptEventName = this.wranglerID + "Appeared";
      this.configuredScriptEventName = this.wranglerID + "Configured";
      this.goneScriptEventName = this.wranglerID + "Gone";
      this.timerScriptEventName = this.wranglerID + "Timer";
      this.teardownScriptEventName = this.wranglerID + "Teardown";
      this.serverPlayerBroadcastEnterScriptEventName = this.wranglerID + "PlayerBroadcastEnter";
      this.serverPlayerBroadcastLeaveScriptEventName = this.wranglerID + "PlayerBroadcastLeave";
      this.serverEntityProximityEnterScriptEventName = this.wranglerID + "EntityProximityEnter";
      this.serverEntityProximityLeaveScriptEventName = this.wranglerID + "EntityProximityLeave";
      this.serverPlayerProximityEnterScriptEventName = this.wranglerID + "PlayerProximityEnter";
      this.serverPlayerProximityLeaveScriptEventName = this.wranglerID + "PlayerProximityLeave";
      this.serverNPCProximityEnterScriptEventName = this.wranglerID + "NPCProximityEnter";
      this.serverNPCProximityLeaveScriptEventName = this.wranglerID + "NPCProximityLeave";
      this.autoCreateOnClient = true;
      this.autoDestroyOnClient = true;
      this.createScheduledMovementComponent = false;
      this.templateElement = null;
      this.proximityRadius = 0.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getServerPlayerProximityEnterEventName() {
      return this.serverPlayerProximityEnterScriptEventName;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getTimerEventName() {
      return this.timerScriptEventName;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object getAuxData() {
      return this.auxData;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getAppearedEventName() {
      return this.appearedScriptEventName;
   }

   public boolean getCreateScheduledMovementComponent() {
      return this.createScheduledMovementComponent;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getTeardownEventName() {
      return this.teardownScriptEventName;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getGoneEventName() {
      return this.goneScriptEventName;
   }

   public static String getGeographicEntityType(BroadcasterComponent var0) {
      GameEntity var1 = var0.getEntity();
      logger.trace("Finding GE/Wrangler type for object: {}", var1);
      String var2 = (String)var1.getProperty("__geWranglerID", (Object)null);
      logger.trace("... __geWranglerID prop is {}", var2);
      return var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getServerPlayerBroadcastEnterEventName() {
      return this.serverPlayerBroadcastEnterScriptEventName;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getServerPlayerBroadcastLeaveEventName() {
      return this.serverPlayerBroadcastLeaveScriptEventName;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GeographicEntityWrangler setCreateScheduledMovementComponent(boolean var1) {
      this.createScheduledMovementComponent = var1;
      return this;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getServerEntityProximityLeaveEventName() {
      return this.serverEntityProximityLeaveScriptEventName;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getServerEntityProximityEnterEventName() {
      return this.serverEntityProximityEnterScriptEventName;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getServerPlayerProximityLeaveEventName() {
      return this.serverPlayerProximityLeaveScriptEventName;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getServerNPCProximityEnterEventName() {
      return this.serverNPCProximityEnterScriptEventName;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getServerNPCProximityLeaveEventName() {
      return this.serverNPCProximityLeaveScriptEventName;
   }

   public boolean getAutoDestroyOnClient() {
      return this.autoDestroyOnClient;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getConfiguredEventName() {
      return this.configuredScriptEventName;
   }
}
