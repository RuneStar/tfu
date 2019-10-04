// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.event.EventHandler;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("GeographicEntityWranglerPRIVATE")
public class GeographicEntityWrangler
{
    private static final Logger logger;
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
    
    static {
        logger = LoggerFactory.getLogger(GeographicEntityWrangler.class);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GeographicEntityWrangler setAutoCreateOnClient(final boolean autoCreateOnClient) {
        this.autoCreateOnClient = autoCreateOnClient;
        return this;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GeographicEntityWrangler setAutoDestroyOnClient(final boolean autoDestroyOnClient) {
        this.autoDestroyOnClient = autoDestroyOnClient;
        return this;
    }
    
    public boolean getAutoCreateOnClient() {
        return this.autoCreateOnClient;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GeographicEntityWrangler setProximityRadius(final float proximityRadius) {
        this.proximityRadius = proximityRadius;
        return this;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setTemplateElement(final String templateElementName) {
        this.templateElementName = templateElementName;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setAuxData(final Object auxData) {
        this.auxData = auxData;
    }
    
    protected GeographicEntityWrangler(final String wranglerID) {
        this.wranglerID = wranglerID;
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
        this.proximityRadius = 0.0f;
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
    
    public static String getGeographicEntityType(final BroadcasterComponent broadcasterComponent) {
        final GameEntity entity = broadcasterComponent.getEntity();
        GeographicEntityWrangler.logger.trace("Finding GE/Wrangler type for object: {}", entity);
        final String s = (String)entity.getProperty("__geWranglerID", null);
        GeographicEntityWrangler.logger.trace("... __geWranglerID prop is {}", s);
        return s;
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
    public GeographicEntityWrangler setCreateScheduledMovementComponent(final boolean createScheduledMovementComponent) {
        this.createScheduledMovementComponent = createScheduledMovementComponent;
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
