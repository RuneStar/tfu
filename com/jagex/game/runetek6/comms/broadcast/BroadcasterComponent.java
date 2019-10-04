/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsHub;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessageDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcasterOrReceiverComponent;
import com.jagex.game.runetek6.comms.broadcast.BroadcasterVisibility;
import com.jagex.game.runetek6.comms.broadcast.IGameStateBroadcaster;
import com.jagex.game.runetek6.comms.broadcast.ReceiverComponent;
import com.jagex.game.runetek6.comms.broadcast.ReceiverDetachedException;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.SortedMap;
import java.util.TreeMap;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="BroadcasterComponent")
public class BroadcasterComponent
extends BroadcasterOrReceiverComponent {
    public static final int componentTypeId = StringTools.l(BroadcasterComponent.class.getName());
    private final IGameStateBroadcaster implementation;
    int last_AllowBroadcastsTo_ModCount;
    float last_MinimumBroadcastRadius;
    private float minimumBroadcastRadius;
    final SortedMap persistedState = new TreeMap();

    public void BroadcastableState(BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition, BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload) {
        this.markAsUsed();
        this.persistedState.put(broadcastStateAndEventsTypes$StateDefinition, broadcastStateAndEventsTypes$StatePayload);
        if (this.currentHub != null) {
            this.currentHub.queueMessageForCurrentReceivers(this, broadcastStateAndEventsTypes$StateDefinition, broadcastStateAndEventsTypes$StatePayload);
        }
    }

    public BroadcasterComponent(IGameStateBroadcaster iGameStateBroadcaster) {
        this.implementation = iGameStateBroadcaster;
        if (this.implementation.causesAppearedOrGone()) {
            this.markAsUsed();
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void BroadcastableState(BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition, byte[] arrby) {
        this.BroadcastableState(broadcastStateAndEventsTypes$StateDefinition, new BroadcastStateAndEventsTypes$StatePayload(arrby, this.getEntity().bg));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void BroadcastableEvent(BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition, byte[] arrby) {
        this.BroadcastableEvent(broadcastStateAndEventsTypes$EventDefinition, new BroadcastStateAndEventsTypes$EventPayload(arrby, this.getEntity().bg));
    }

    boolean causesAppearedOrGone() {
        return this.implementation.causesAppearedOrGone();
    }

    BroadcasterVisibility allowBroadcastsTo(GameEntity gameEntity) {
        return this.implementation.allowBroadcastsTo(gameEntity);
    }

    float getMinimumBroadcastRadius() {
        return this.minimumBroadcastRadius;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    void setMinimumBroadcastRadius(float f) {
        this.minimumBroadcastRadius = f;
    }

    @Override
    Class getOppositeComponentClass() {
        return ReceiverComponent.class;
    }

    float getMinDistanceForPair(ReceiverComponent receiverComponent) {
        return receiverComponent.getMinDistanceForPair(this);
    }

    void resetVisibilityNow(ReceiverComponent receiverComponent) throws ReceiverDetachedException {
        this.currentHub.resetVisibilityNow(receiverComponent, this);
    }

    public void BroadcastableEvent(BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition, BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
        this.markAsUsed();
        if (this.currentHub != null) {
            this.currentHub.queueMessageForCurrentReceivers(this, broadcastStateAndEventsTypes$EventDefinition, broadcastStateAndEventsTypes$EventPayload);
        }
    }

    void recalculateVisibilityNextService(ReceiverComponent receiverComponent) {
        this.currentHub.recalculateVisibilityNextService(receiverComponent, this);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return componentTypeId;
    }
}

