// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.TreeMap;
import com.jagex.core.stringtools.general.StringTools;
import java.util.SortedMap;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("BroadcasterComponent")
public class BroadcasterComponent extends BroadcasterOrReceiverComponent
{
    public static final int componentTypeId;
    private final IGameStateBroadcaster implementation;
    int last_AllowBroadcastsTo_ModCount;
    float last_MinimumBroadcastRadius;
    private float minimumBroadcastRadius;
    final SortedMap persistedState;
    
    static {
        componentTypeId = StringTools.l(BroadcasterComponent.class.getName());
    }
    
    public void BroadcastableState(final BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition, final BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload) {
        this.markAsUsed();
        this.persistedState.put(broadcastStateAndEventsTypes$StateDefinition, broadcastStateAndEventsTypes$StatePayload);
        if (super.currentHub != null) {
            super.currentHub.queueMessageForCurrentReceivers(this, broadcastStateAndEventsTypes$StateDefinition, broadcastStateAndEventsTypes$StatePayload);
        }
    }
    
    public BroadcasterComponent(final IGameStateBroadcaster implementation) {
        this.persistedState = new TreeMap();
        this.implementation = implementation;
        if (this.implementation.causesAppearedOrGone()) {
            this.markAsUsed();
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void BroadcastableState(final BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition, final byte[] array) {
        this.BroadcastableState(broadcastStateAndEventsTypes$StateDefinition, new BroadcastStateAndEventsTypes$StatePayload(array, this.getEntity().bg));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void BroadcastableEvent(final BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition, final byte[] array) {
        this.BroadcastableEvent(broadcastStateAndEventsTypes$EventDefinition, new BroadcastStateAndEventsTypes$EventPayload(array, this.getEntity().bg));
    }
    
    boolean causesAppearedOrGone() {
        return this.implementation.causesAppearedOrGone();
    }
    
    BroadcasterVisibility allowBroadcastsTo(final GameEntity gameEntity) {
        return this.implementation.allowBroadcastsTo(gameEntity);
    }
    
    float getMinimumBroadcastRadius() {
        return this.minimumBroadcastRadius;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    void setMinimumBroadcastRadius(final float minimumBroadcastRadius) {
        this.minimumBroadcastRadius = minimumBroadcastRadius;
    }
    
    @Override
    Class getOppositeComponentClass() {
        return ReceiverComponent.class;
    }
    
    float getMinDistanceForPair(final ReceiverComponent receiverComponent) {
        return receiverComponent.getMinDistanceForPair(this);
    }
    
    void resetVisibilityNow(final ReceiverComponent receiverComponent) throws ReceiverDetachedException {
        super.currentHub.resetVisibilityNow(receiverComponent, this);
    }
    
    public void BroadcastableEvent(final BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition, final BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
        this.markAsUsed();
        if (super.currentHub != null) {
            super.currentHub.queueMessageForCurrentReceivers(this, broadcastStateAndEventsTypes$EventDefinition, broadcastStateAndEventsTypes$EventPayload);
        }
    }
    
    void recalculateVisibilityNextService(final ReceiverComponent receiverComponent) {
        super.currentHub.recalculateVisibilityNextService(receiverComponent, this);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return BroadcasterComponent.componentTypeId;
    }
}
