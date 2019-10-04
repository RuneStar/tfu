// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import org.slf4j.LoggerFactory;
import tfu.Jo533;
import java.util.WeakHashMap;
import java.util.LinkedList;
import java.util.List;
import com.jagex.maths.Vector3;
import java.util.Iterator;
import tfu.Lb33;
import com.jagex.game.runetek6.scenegraph.Scene;
import java.util.ArrayDeque;
import java.util.Map;
import tfu.Jy122;
import org.slf4j.Logger;
import tfu.Fl59;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("Broadcast")
public class BroadcastStateAndEventsHub
{
    public static boolean debug;
    static Fl59 hubsByScene;
    private static final Logger logger;
    public static Jy122 tree;
    public static boolean verbose;
    private final int areaInstanceID;
    private boolean isDisabled;
    private Map pendingMessages;
    private ArrayDeque recalculateVisibilityRequests;
    private final Scene scene;
    
    private void TransferMessage(final BroadcasterComponent broadcasterComponent, final ReceiverComponent receiverComponent, final BroadcastStateAndEventsTypes$MessageDefinition obj, final BroadcastStateAndEventsTypes$MessagePayload broadcastStateAndEventsTypes$MessagePayload, final boolean b, final boolean b2) throws ReceiverDetachedException {
        Lb33.g(Lb33.TransferMessage);
        try {
            broadcastStateAndEventsTypes$MessagePayload.wranglerID = GeographicEntityWrangler.getGeographicEntityType(broadcasterComponent);
            broadcastStateAndEventsTypes$MessagePayload.areaID = this.areaInstanceID;
            if (obj instanceof BroadcastStateAndEventsTypes$StateDefinition) {
                receiverComponent.ReceiveState(obj.messageName, (BroadcastStateAndEventsTypes$StatePayload)broadcastStateAndEventsTypes$MessagePayload, b, b2);
            }
            else if (obj instanceof BroadcastStateAndEventsTypes$EventDefinition) {
                receiverComponent.ReceiveEvent(obj.messageName, (BroadcastStateAndEventsTypes$EventPayload)broadcastStateAndEventsTypes$MessagePayload, b, b2);
            }
            else if (obj instanceof BroadcastStateAndEventsTypes$AppearedDefinition) {
                receiverComponent.ReceiveAppeared((BroadcastStateAndEventsTypes$AppearedPayload)broadcastStateAndEventsTypes$MessagePayload, b, b2);
            }
            else {
                if (!(obj instanceof BroadcastStateAndEventsTypes$GoneDefinition)) {
                    throw new RuntimeException("Oo-er, unknown message definition type- " + obj);
                }
                receiverComponent.ReceiveGone((BroadcastStateAndEventsTypes$GonePayload)broadcastStateAndEventsTypes$MessagePayload, b, b2);
            }
        }
        finally {
            Lb33.d(Lb33.TransferMessage);
        }
    }
    
    void recalculateVisibilityNextService(final ReceiverComponent receiverComponent, final BroadcasterComponent broadcasterComponent) {
        BroadcastStateAndEventsHub.logger.trace("  - Internal recalculateVisibilityNextService between {} and {}", receiverComponent, broadcasterComponent);
        this.recalculateVisibilityRequests.add(new BroadcastStateAndEventsHub$RecalculateVisibilityRequest(receiverComponent, broadcasterComponent));
    }
    
    void resetVisibilityNow(final ReceiverComponent receiverComponent, final BroadcasterComponent broadcasterComponent) throws ReceiverDetachedException {
        if (receiverComponent.currentHub == this && broadcasterComponent.currentHub == this) {
            BroadcastStateAndEventsHub.logger.trace("  - Internal resetVisibilityNow from {} to {}", broadcasterComponent, receiverComponent);
            this.recalculateVisibilityNow(receiverComponent, broadcasterComponent, false);
        }
    }
    
    private void TransferFullState(final BroadcasterComponent obj, final ReceiverComponent obj2, final boolean b, final boolean b2) throws ReceiverDetachedException {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.h(BroadcastStateAndEventsHub.tree, "Transferring full state from broadcaster " + obj + " to receiver " + obj2);
        }
        Lb33.g(Lb33.TransferFullState);
        try {
            for (final Map.Entry<BroadcastStateAndEventsTypes$StateDefinition, V> entry : obj.persistedState.entrySet()) {
                final BroadcastStateAndEventsTypes$StateDefinition obj3 = entry.getKey();
                final BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload = (BroadcastStateAndEventsTypes$StatePayload)entry.getValue();
                if (BroadcastStateAndEventsHub.debug) {
                    Jy122.s(BroadcastStateAndEventsHub.tree, "type " + obj3);
                }
                this.TransferMessage(obj, obj2, obj3, broadcastStateAndEventsTypes$StatePayload, b, b2);
            }
        }
        finally {
            Lb33.d(Lb33.TransferFullState);
        }
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.l(BroadcastStateAndEventsHub.tree, "Transferred " + obj.persistedState.size() + " state message(s).");
        }
    }
    
    private void recalculateVisibilityNow(final ReceiverComponent receiverComponent, final BroadcasterComponent broadcasterComponent, final boolean b) throws ReceiverDetachedException {
        final Vector3 trans = receiverComponent.getEntity().getWorldTransform().trans;
        final float minimumInterestRadius = receiverComponent.getMinimumInterestRadius();
        this.recalculateVisibilityNow(receiverComponent, trans, minimumInterestRadius * minimumInterestRadius, receiverComponent.useBroadcasterMinimumBroadcastRadius(), broadcasterComponent, b);
    }
    
    void queueMessageForCurrentReceivers(final BroadcasterComponent obj, final BroadcastStateAndEventsTypes$MessageDefinition obj2, final BroadcastStateAndEventsTypes$MessagePayload obj3) {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.s(BroadcastStateAndEventsHub.tree, "Queuing message on " + obj + ", type=" + obj2 + ", payload=" + obj3);
        }
        synchronized (this.pendingMessages) {
            Object o = this.pendingMessages.get(obj);
            if (o == null) {
                o = new LinkedList<BroadcastStateAndEventsHub$PendingMessage>();
                this.pendingMessages.put(obj, o);
            }
            ((List<BroadcastStateAndEventsHub$PendingMessage>)o).add(new BroadcastStateAndEventsHub$PendingMessage(obj2, obj3));
        }
    }
    
    public BroadcastStateAndEventsHub(final Scene scene, final int areaInstanceID, final boolean isDisabled) {
        this.recalculateVisibilityRequests = new ArrayDeque();
        Jy122.d(BroadcastStateAndEventsHub.tree, "==== ");
        this.scene = scene;
        this.areaInstanceID = areaInstanceID;
        this.isDisabled = isDisabled;
        BroadcastStateAndEventsHub.hubsByScene.g(this.scene, this);
        this.pendingMessages = new WeakHashMap();
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.s(BroadcastStateAndEventsHub.tree, "Created new BroadcastStateAndEventsHub.");
        }
    }
    
    private void recalculateVisibilityNow(final ReceiverComponent receiverComponent, final Vector3 vector3, final float n, final boolean b, final BroadcasterComponent broadcasterComponent, final boolean b2) throws ReceiverDetachedException {
        Lb33.g(Lb33.RecalculateVisibilityNow);
        try {
            BroadcastStateAndEventsHub.logger.trace("    - Recalculating visibility between {} and {}", receiverComponent, broadcasterComponent);
            BroadcasterVisibility obj = BroadcasterVisibility.UNKNOWN;
            Lb33.g(Lb33.GetVisibility);
            try {
                if (b2 && broadcasterComponent.getEntity() != receiverComponent.getEntity()) {
                    final float aq = Vector3.aq(broadcasterComponent.getEntity().getWorldTransform().trans, vector3);
                    float n2 = n;
                    if (b) {
                        final float minimumBroadcastRadius = broadcasterComponent.getMinimumBroadcastRadius();
                        final float n3 = minimumBroadcastRadius * minimumBroadcastRadius;
                        if (n3 > n2) {
                            n2 = n3;
                        }
                    }
                    if (aq <= n2) {
                        obj = broadcasterComponent.allowBroadcastsTo(receiverComponent.getEntity());
                        obj = obj.and(receiverComponent.allowBroadcastsFrom(broadcasterComponent.getEntity()));
                        if (BroadcastStateAndEventsHub.debug && BroadcastStateAndEventsHub.verbose) {
                            Jo533.d(BroadcastStateAndEventsHub.tree, broadcasterComponent.toString(), "Broadcast " + obj + " from " + broadcasterComponent + " to " + receiverComponent);
                        }
                    }
                }
            }
            finally {
                Lb33.d(Lb33.GetVisibility);
            }
            Lb33.g(Lb33.CompareVisibility);
            BroadcasterVisibility unknown;
            try {
                if (obj != BroadcasterVisibility.UNKNOWN) {
                    unknown = receiverComponent.oppositesInBroadcastRange.put(broadcasterComponent, obj);
                    broadcasterComponent.oppositesInBroadcastRange.put(receiverComponent, obj);
                }
                else {
                    unknown = receiverComponent.oppositesInBroadcastRange.remove(broadcasterComponent);
                    broadcasterComponent.oppositesInBroadcastRange.remove(receiverComponent);
                }
                if (unknown == null) {
                    unknown = BroadcasterVisibility.UNKNOWN;
                }
            }
            finally {
                Lb33.d(Lb33.CompareVisibility);
            }
            final boolean b3 = unknown == BroadcasterVisibility.UNKNOWN && obj != BroadcasterVisibility.UNKNOWN;
            boolean b4 = unknown != BroadcasterVisibility.SERVER_AND_CLIENT && obj == BroadcasterVisibility.SERVER_AND_CLIENT;
            final boolean b5 = unknown != BroadcasterVisibility.UNKNOWN && obj == BroadcasterVisibility.UNKNOWN;
            final boolean b6 = unknown == BroadcasterVisibility.SERVER_AND_CLIENT && obj != BroadcasterVisibility.SERVER_AND_CLIENT;
            if (b3 || b4) {
                if (b3) {
                    BroadcastStateAndEventsHub.logger.trace("      - Newly known to server");
                }
                if (b4) {
                    BroadcastStateAndEventsHub.logger.trace("      - Newly known to client");
                }
                if (BroadcastStateAndEventsHub.debug) {
                    Jy122.h(BroadcastStateAndEventsHub.tree, "Broadcaster " + broadcasterComponent + " is freshly in view for receiver " + receiverComponent + ", sending full state.");
                }
                Lb33.g(Lb33.CheckReceiveAppeared);
                try {
                    if (broadcasterComponent.causesAppearedOrGone()) {
                        if (BroadcastStateAndEventsHub.debug) {
                            Jy122.l(BroadcastStateAndEventsHub.tree, "Broadcaster " + broadcasterComponent + " is sending an 'Appeared' message to " + receiverComponent);
                        }
                        receiverComponent.ReceiveAppeared(new BroadcastStateAndEventsTypes$AppearedPayload(broadcasterComponent.getEntity().bg, GeographicEntityWrangler.getGeographicEntityType(broadcasterComponent), this.areaInstanceID, broadcasterComponent.getEntity().getObjectTransform()), b3, b4);
                        if (obj == BroadcasterVisibility.SERVER_ONLY) {
                            final BroadcasterVisibility and = broadcasterComponent.allowBroadcastsTo(receiverComponent.getEntity()).and(receiverComponent.allowBroadcastsFrom(broadcasterComponent.getEntity()));
                            if (and == BroadcasterVisibility.SERVER_AND_CLIENT) {
                                receiverComponent.oppositesInBroadcastRange.put(broadcasterComponent, and);
                                broadcasterComponent.oppositesInBroadcastRange.put(receiverComponent, and);
                                receiverComponent.ReceiveAppeared(new BroadcastStateAndEventsTypes$AppearedPayload(broadcasterComponent.getEntity().bg, GeographicEntityWrangler.getGeographicEntityType(broadcasterComponent), this.areaInstanceID, broadcasterComponent.getEntity().getObjectTransform()), false, true);
                                b4 = true;
                            }
                        }
                    }
                }
                finally {
                    Lb33.d(Lb33.CheckReceiveAppeared);
                }
                this.TransferFullState(broadcasterComponent, receiverComponent, b3, b4);
                if (BroadcastStateAndEventsHub.debug) {
                    Jy122.j(BroadcastStateAndEventsHub.tree);
                }
            }
            if (b5 || b6) {
                Lb33.g(Lb33.CheckReceiveGone);
                try {
                    if (b5) {
                        BroadcastStateAndEventsHub.logger.trace("      - Gone from server");
                    }
                    if (b6) {
                        BroadcastStateAndEventsHub.logger.trace("      - Gone from client");
                    }
                    if (broadcasterComponent.causesAppearedOrGone()) {
                        if (BroadcastStateAndEventsHub.debug) {
                            Jy122.l(BroadcastStateAndEventsHub.tree, "Broadcaster " + broadcasterComponent + " has dropped out of interest for receiver " + receiverComponent);
                        }
                        receiverComponent.ReceiveGone(new BroadcastStateAndEventsTypes$GonePayload(broadcasterComponent.getEntity().bg, GeographicEntityWrangler.getGeographicEntityType(broadcasterComponent), this.areaInstanceID), b5, b6);
                    }
                }
                finally {
                    Lb33.d(Lb33.CheckReceiveGone);
                }
            }
        }
        finally {
            Lb33.d(Lb33.RecalculateVisibilityNow);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(BroadcastStateAndEventsHub.class);
        BroadcastStateAndEventsHub.debug = false;
        BroadcastStateAndEventsHub.verbose = false;
        BroadcastStateAndEventsHub.tree = new Jy122(BroadcastStateAndEventsHub.logger, 2);
        BroadcastStateAndEventsHub.hubsByScene = new Fl59();
    }
}
