// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Lb33;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass
public class ReceiverComponent extends BroadcasterOrReceiverComponent
{
    public static final int componentTypeId;
    private static final ReceiverDetachedException receiverDetachedException;
    private final IGameStateReceiver implementation;
    int last_AllowBroadcastsFrom_ModCount;
    float last_MinimumInterestRadius;
    boolean last_UseBroadcasterMinimumBroadcastRadius;
    
    void ReceiveState(final String s, final BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload, final boolean b, final boolean b2) throws ReceiverDetachedException {
        Lb33.g(Lb33.ReceiveState);
        try {
            final BroadcastStateAndEventsHub currentHub = super.currentHub;
            this.implementation.ReceiveState(s, broadcastStateAndEventsTypes$StatePayload, b, b2);
            if (super.currentHub != currentHub) {
                throw ReceiverComponent.receiverDetachedException;
            }
        }
        finally {
            Lb33.d(Lb33.ReceiveState);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return ReceiverComponent.componentTypeId;
    }
    
    void ReceiveEvent(final String s, final BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload, final boolean b, final boolean b2) throws ReceiverDetachedException {
        Lb33.g(Lb33.ReceiveEvent);
        try {
            final BroadcastStateAndEventsHub currentHub = super.currentHub;
            this.implementation.ReceiveEvent(s, broadcastStateAndEventsTypes$EventPayload, b, b2);
            if (super.currentHub != currentHub) {
                throw ReceiverComponent.receiverDetachedException;
            }
        }
        finally {
            Lb33.d(Lb33.ReceiveEvent);
        }
    }
    
    public ReceiverComponent(final IGameStateReceiver implementation) {
        this.implementation = implementation;
        this.markAsUsed();
    }
    
    float getMinimumInterestRadius() {
        return this.implementation.getMinimumInterestRadius();
    }
    
    boolean useBroadcasterMinimumBroadcastRadius() {
        return this.implementation.useBroadcasterMinimumBroadcastRadius();
    }
    
    BroadcasterVisibility allowBroadcastsFrom(final GameEntity gameEntity) {
        return this.implementation.allowBroadcastsFrom(gameEntity);
    }
    
    float getMinDistanceForPair(final BroadcasterComponent broadcasterComponent) {
        float minimumInterestRadius = this.implementation.getMinimumInterestRadius();
        if (this.implementation.useBroadcasterMinimumBroadcastRadius()) {
            final float minimumBroadcastRadius = broadcasterComponent.getMinimumBroadcastRadius();
            if (minimumBroadcastRadius > minimumInterestRadius) {
                minimumInterestRadius = minimumBroadcastRadius;
            }
        }
        return minimumInterestRadius;
    }
    
    @Override
    Class getOppositeComponentClass() {
        return BroadcasterComponent.class;
    }
    
    void resetVisibilityNow(final BroadcasterComponent broadcasterComponent) throws ReceiverDetachedException {
        super.currentHub.resetVisibilityNow(this, broadcasterComponent);
    }
    
    void recalculateVisibilityNextService(final BroadcasterComponent broadcasterComponent) {
        super.currentHub.recalculateVisibilityNextService(this, broadcasterComponent);
    }
    
    void ReceiveAppeared(final BroadcastStateAndEventsTypes$AppearedPayload broadcastStateAndEventsTypes$AppearedPayload, final boolean b, final boolean b2) throws ReceiverDetachedException {
        Lb33.g(Lb33.ReceiveAppeared);
        try {
            final BroadcastStateAndEventsHub currentHub = super.currentHub;
            this.implementation.ReceiveAppeared(broadcastStateAndEventsTypes$AppearedPayload, b, b2);
            if (super.currentHub != currentHub) {
                throw ReceiverComponent.receiverDetachedException;
            }
        }
        finally {
            Lb33.d(Lb33.ReceiveAppeared);
        }
    }
    
    void ReceiveGone(final BroadcastStateAndEventsTypes$GonePayload broadcastStateAndEventsTypes$GonePayload, final boolean b, final boolean b2) throws ReceiverDetachedException {
        Lb33.g(Lb33.ReceiveGone);
        try {
            final BroadcastStateAndEventsHub currentHub = super.currentHub;
            this.implementation.ReceiveGone(broadcastStateAndEventsTypes$GonePayload, b, b2);
            if (super.currentHub != currentHub) {
                throw ReceiverComponent.receiverDetachedException;
            }
        }
        finally {
            Lb33.d(Lb33.ReceiveGone);
        }
    }
    
    static {
        receiverDetachedException = new ReceiverDetachedException();
        componentTypeId = StringTools.l(ReceiverComponent.class.getName());
    }
}
