/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsHub;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcasterComponent;
import com.jagex.game.runetek6.comms.broadcast.BroadcasterOrReceiverComponent;
import com.jagex.game.runetek6.comms.broadcast.BroadcasterVisibility;
import com.jagex.game.runetek6.comms.broadcast.IGameStateReceiver;
import com.jagex.game.runetek6.comms.broadcast.ReceiverDetachedException;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;
import tfu.Lb33;

@ScriptEntryClass
public class ReceiverComponent
extends BroadcasterOrReceiverComponent {
    public static final int componentTypeId;
    private static final ReceiverDetachedException receiverDetachedException;
    private final IGameStateReceiver implementation;
    int last_AllowBroadcastsFrom_ModCount;
    float last_MinimumInterestRadius;
    boolean last_UseBroadcasterMinimumBroadcastRadius;

    void ReceiveState(String string, BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload, boolean bl, boolean bl2) throws ReceiverDetachedException {
        Lb33.g(Lb33.ReceiveState);
        try {
            BroadcastStateAndEventsHub broadcastStateAndEventsHub = this.currentHub;
            this.implementation.ReceiveState(string, broadcastStateAndEventsTypes$StatePayload, bl, bl2);
            if (this.currentHub != broadcastStateAndEventsHub) {
                throw receiverDetachedException;
            }
            Lb33.d(Lb33.ReceiveState);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.ReceiveState);
            throw throwable;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return componentTypeId;
    }

    void ReceiveEvent(String string, BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload, boolean bl, boolean bl2) throws ReceiverDetachedException {
        Lb33.g(Lb33.ReceiveEvent);
        try {
            BroadcastStateAndEventsHub broadcastStateAndEventsHub = this.currentHub;
            this.implementation.ReceiveEvent(string, broadcastStateAndEventsTypes$EventPayload, bl, bl2);
            if (this.currentHub != broadcastStateAndEventsHub) {
                throw receiverDetachedException;
            }
            Lb33.d(Lb33.ReceiveEvent);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.ReceiveEvent);
            throw throwable;
        }
    }

    public ReceiverComponent(IGameStateReceiver iGameStateReceiver) {
        this.implementation = iGameStateReceiver;
        this.markAsUsed();
    }

    float getMinimumInterestRadius() {
        return this.implementation.getMinimumInterestRadius();
    }

    boolean useBroadcasterMinimumBroadcastRadius() {
        return this.implementation.useBroadcasterMinimumBroadcastRadius();
    }

    BroadcasterVisibility allowBroadcastsFrom(GameEntity gameEntity) {
        return this.implementation.allowBroadcastsFrom(gameEntity);
    }

    float getMinDistanceForPair(BroadcasterComponent broadcasterComponent) {
        float f;
        float f2 = this.implementation.getMinimumInterestRadius();
        if (this.implementation.useBroadcasterMinimumBroadcastRadius() && (f = broadcasterComponent.getMinimumBroadcastRadius()) > f2) {
            f2 = f;
        }
        return f2;
    }

    @Override
    Class getOppositeComponentClass() {
        return BroadcasterComponent.class;
    }

    void resetVisibilityNow(BroadcasterComponent broadcasterComponent) throws ReceiverDetachedException {
        this.currentHub.resetVisibilityNow(this, broadcasterComponent);
    }

    void recalculateVisibilityNextService(BroadcasterComponent broadcasterComponent) {
        this.currentHub.recalculateVisibilityNextService(this, broadcasterComponent);
    }

    void ReceiveAppeared(BroadcastStateAndEventsTypes$AppearedPayload broadcastStateAndEventsTypes$AppearedPayload, boolean bl, boolean bl2) throws ReceiverDetachedException {
        Lb33.g(Lb33.ReceiveAppeared);
        try {
            BroadcastStateAndEventsHub broadcastStateAndEventsHub = this.currentHub;
            this.implementation.ReceiveAppeared(broadcastStateAndEventsTypes$AppearedPayload, bl, bl2);
            if (this.currentHub != broadcastStateAndEventsHub) {
                throw receiverDetachedException;
            }
            Lb33.d(Lb33.ReceiveAppeared);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.ReceiveAppeared);
            throw throwable;
        }
    }

    void ReceiveGone(BroadcastStateAndEventsTypes$GonePayload broadcastStateAndEventsTypes$GonePayload, boolean bl, boolean bl2) throws ReceiverDetachedException {
        Lb33.g(Lb33.ReceiveGone);
        try {
            BroadcastStateAndEventsHub broadcastStateAndEventsHub = this.currentHub;
            this.implementation.ReceiveGone(broadcastStateAndEventsTypes$GonePayload, bl, bl2);
            if (this.currentHub != broadcastStateAndEventsHub) {
                throw receiverDetachedException;
            }
            Lb33.d(Lb33.ReceiveGone);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.ReceiveGone);
            throw throwable;
        }
    }

    static {
        receiverDetachedException = new ReceiverDetachedException();
        componentTypeId = StringTools.l(ReceiverComponent.class.getName());
    }
}

