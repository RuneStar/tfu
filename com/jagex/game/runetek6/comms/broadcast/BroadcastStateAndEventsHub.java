/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsHub$PendingMessage;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsHub$RecalculateVisibilityRequest;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GoneDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessageDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcasterComponent;
import com.jagex.game.runetek6.comms.broadcast.BroadcasterOrReceiverComponent;
import com.jagex.game.runetek6.comms.broadcast.BroadcasterVisibility;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;
import com.jagex.game.runetek6.comms.broadcast.ReceiverComponent;
import com.jagex.game.runetek6.comms.broadcast.ReceiverDetachedException;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.WeakHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Bb4;
import tfu.Fl59;
import tfu.Jo533;
import tfu.Jy122;
import tfu.Lb33;

@ScriptEntryClass(value="Broadcast")
public class BroadcastStateAndEventsHub {
    public static boolean debug;
    static Fl59 hubsByScene;
    private static final Logger logger;
    public static Jy122 tree;
    public static boolean verbose;
    private final int areaInstanceID;
    private boolean isDisabled;
    private Map pendingMessages;
    private ArrayDeque recalculateVisibilityRequests = new ArrayDeque();
    private final Scene scene;

    private void TransferMessage(BroadcasterComponent broadcasterComponent, ReceiverComponent receiverComponent, BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition, BroadcastStateAndEventsTypes$MessagePayload broadcastStateAndEventsTypes$MessagePayload, boolean bl, boolean bl2) throws ReceiverDetachedException {
        Lb33.g(Lb33.TransferMessage);
        try {
            broadcastStateAndEventsTypes$MessagePayload.wranglerID = GeographicEntityWrangler.getGeographicEntityType(broadcasterComponent);
            broadcastStateAndEventsTypes$MessagePayload.areaID = this.areaInstanceID;
            if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$StateDefinition) {
                receiverComponent.ReceiveState(broadcastStateAndEventsTypes$MessageDefinition.messageName, (BroadcastStateAndEventsTypes$StatePayload)broadcastStateAndEventsTypes$MessagePayload, bl, bl2);
            } else if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$EventDefinition) {
                receiverComponent.ReceiveEvent(broadcastStateAndEventsTypes$MessageDefinition.messageName, (BroadcastStateAndEventsTypes$EventPayload)broadcastStateAndEventsTypes$MessagePayload, bl, bl2);
            } else if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$AppearedDefinition) {
                receiverComponent.ReceiveAppeared((BroadcastStateAndEventsTypes$AppearedPayload)broadcastStateAndEventsTypes$MessagePayload, bl, bl2);
            } else if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$GoneDefinition) {
                receiverComponent.ReceiveGone((BroadcastStateAndEventsTypes$GonePayload)broadcastStateAndEventsTypes$MessagePayload, bl, bl2);
            } else {
                throw new RuntimeException("Oo-er, unknown message definition type- " + broadcastStateAndEventsTypes$MessageDefinition);
            }
            Lb33.d(Lb33.TransferMessage);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.TransferMessage);
            throw throwable;
        }
    }

    void recalculateVisibilityNextService(ReceiverComponent receiverComponent, BroadcasterComponent broadcasterComponent) {
        logger.trace("  - Internal recalculateVisibilityNextService between {} and {}", receiverComponent, (Object)broadcasterComponent);
        this.recalculateVisibilityRequests.add(new BroadcastStateAndEventsHub$RecalculateVisibilityRequest(receiverComponent, broadcasterComponent));
    }

    void resetVisibilityNow(ReceiverComponent receiverComponent, BroadcasterComponent broadcasterComponent) throws ReceiverDetachedException {
        if (receiverComponent.currentHub == this && broadcasterComponent.currentHub == this) {
            logger.trace("  - Internal resetVisibilityNow from {} to {}", broadcasterComponent, (Object)receiverComponent);
            this.recalculateVisibilityNow(receiverComponent, broadcasterComponent, false);
        }
    }

    private void TransferFullState(BroadcasterComponent broadcasterComponent, ReceiverComponent receiverComponent, boolean bl, boolean bl2) throws ReceiverDetachedException {
        if (debug) {
            Jy122.h(tree, "Transferring full state from broadcaster " + broadcasterComponent + " to receiver " + receiverComponent);
        }
        Lb33.g(Lb33.TransferFullState);
        try {
            for (Map.Entry entry : broadcasterComponent.persistedState.entrySet()) {
                BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition = (BroadcastStateAndEventsTypes$StateDefinition)entry.getKey();
                BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload = (BroadcastStateAndEventsTypes$StatePayload)entry.getValue();
                if (debug) {
                    Jy122.s(tree, "type " + broadcastStateAndEventsTypes$StateDefinition);
                }
                this.TransferMessage(broadcasterComponent, receiverComponent, broadcastStateAndEventsTypes$StateDefinition, broadcastStateAndEventsTypes$StatePayload, bl, bl2);
            }
            Lb33.d(Lb33.TransferFullState);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.TransferFullState);
            throw throwable;
        }
        if (debug) {
            Jy122.l(tree, "Transferred " + broadcasterComponent.persistedState.size() + " state message(s).");
        }
    }

    private void recalculateVisibilityNow(ReceiverComponent receiverComponent, BroadcasterComponent broadcasterComponent, boolean bl) throws ReceiverDetachedException {
        Vector3 vector3 = receiverComponent.getEntity().getWorldTransform().trans;
        float f = receiverComponent.getMinimumInterestRadius();
        float f2 = f * f;
        boolean bl2 = receiverComponent.useBroadcasterMinimumBroadcastRadius();
        this.recalculateVisibilityNow(receiverComponent, vector3, f2, bl2, broadcasterComponent, bl);
    }

    void queueMessageForCurrentReceivers(BroadcasterComponent broadcasterComponent, BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition, BroadcastStateAndEventsTypes$MessagePayload broadcastStateAndEventsTypes$MessagePayload) {
        if (debug) {
            Jy122.s(tree, "Queuing message on " + broadcasterComponent + ", type=" + broadcastStateAndEventsTypes$MessageDefinition + ", payload=" + broadcastStateAndEventsTypes$MessagePayload);
        }
        Map map = this.pendingMessages;
        synchronized (map) {
            LinkedList<BroadcastStateAndEventsHub$PendingMessage> linkedList = (LinkedList<BroadcastStateAndEventsHub$PendingMessage>)this.pendingMessages.get(broadcasterComponent);
            if (linkedList == null) {
                linkedList = new LinkedList<BroadcastStateAndEventsHub$PendingMessage>();
                this.pendingMessages.put(broadcasterComponent, linkedList);
            }
            linkedList.add(new BroadcastStateAndEventsHub$PendingMessage(broadcastStateAndEventsTypes$MessageDefinition, broadcastStateAndEventsTypes$MessagePayload));
        }
    }

    public BroadcastStateAndEventsHub(Scene scene, int n, boolean bl) {
        Jy122.d(tree, "==== ");
        this.scene = scene;
        this.areaInstanceID = n;
        this.isDisabled = bl;
        hubsByScene.g(this.scene, this);
        this.pendingMessages = new WeakHashMap();
        if (debug) {
            Jy122.s(tree, "Created new BroadcastStateAndEventsHub.");
        }
    }

    private void recalculateVisibilityNow(ReceiverComponent receiverComponent, Vector3 vector3, float f, boolean bl, BroadcasterComponent broadcasterComponent, boolean bl2) throws ReceiverDetachedException {
        Lb33.g(Lb33.RecalculateVisibilityNow);
        try {
            BroadcasterVisibility broadcasterVisibility;
            boolean bl3;
            logger.trace("    - Recalculating visibility between {} and {}", receiverComponent, (Object)broadcasterComponent);
            BroadcasterVisibility broadcasterVisibility2 = BroadcasterVisibility.UNKNOWN;
            Lb33.g(Lb33.GetVisibility);
            if (bl2 && broadcasterComponent.getEntity() != receiverComponent.getEntity()) {
                float f2;
                float f3;
                float f4 = Vector3.aq(broadcasterComponent.getEntity().getWorldTransform().trans, vector3);
                float f5 = f;
                if (bl && (f2 = (f3 = broadcasterComponent.getMinimumBroadcastRadius()) * f3) > f5) {
                    f5 = f2;
                }
                if (f4 <= f5) {
                    broadcasterVisibility2 = broadcasterComponent.allowBroadcastsTo(receiverComponent.getEntity());
                    broadcasterVisibility2 = broadcasterVisibility2.and(receiverComponent.allowBroadcastsFrom(broadcasterComponent.getEntity()));
                    if (debug && verbose) {
                        Jo533.d(tree, broadcasterComponent.toString(), "Broadcast " + (Object)((Object)broadcasterVisibility2) + " from " + broadcasterComponent + " to " + receiverComponent);
                    }
                }
            }
            Lb33.d(Lb33.GetVisibility);
            Lb33.g(Lb33.CompareVisibility);
            try {
                if (broadcasterVisibility2 != BroadcasterVisibility.UNKNOWN) {
                    broadcasterVisibility = receiverComponent.oppositesInBroadcastRange.put(broadcasterComponent, broadcasterVisibility2);
                    broadcasterComponent.oppositesInBroadcastRange.put(receiverComponent, broadcasterVisibility2);
                } else {
                    broadcasterVisibility = (BroadcasterVisibility)((Object)receiverComponent.oppositesInBroadcastRange.remove(broadcasterComponent));
                    broadcasterComponent.oppositesInBroadcastRange.remove(receiverComponent);
                }
                if (broadcasterVisibility == null) {
                    broadcasterVisibility = BroadcasterVisibility.UNKNOWN;
                }
                Lb33.d(Lb33.CompareVisibility);
            }
            catch (Throwable throwable) {
                Lb33.d(Lb33.CompareVisibility);
                throw throwable;
            }
            boolean bl4 = broadcasterVisibility == BroadcasterVisibility.UNKNOWN && broadcasterVisibility2 != BroadcasterVisibility.UNKNOWN;
            boolean bl5 = broadcasterVisibility != BroadcasterVisibility.SERVER_AND_CLIENT && broadcasterVisibility2 == BroadcasterVisibility.SERVER_AND_CLIENT;
            boolean bl6 = broadcasterVisibility != BroadcasterVisibility.UNKNOWN && broadcasterVisibility2 == BroadcasterVisibility.UNKNOWN;
            boolean bl7 = bl3 = broadcasterVisibility == BroadcasterVisibility.SERVER_AND_CLIENT && broadcasterVisibility2 != BroadcasterVisibility.SERVER_AND_CLIENT;
            if (bl4 || bl5) {
                if (bl4) {
                    logger.trace("      - Newly known to server");
                }
                if (bl5) {
                    logger.trace("      - Newly known to client");
                }
                if (debug) {
                    Jy122.h(tree, "Broadcaster " + broadcasterComponent + " is freshly in view for receiver " + receiverComponent + ", sending full state.");
                }
                Lb33.g(Lb33.CheckReceiveAppeared);
                try {
                    if (broadcasterComponent.causesAppearedOrGone()) {
                        if (debug) {
                            Jy122.l(tree, "Broadcaster " + broadcasterComponent + " is sending an 'Appeared' message to " + receiverComponent);
                        }
                        receiverComponent.ReceiveAppeared(new BroadcastStateAndEventsTypes$AppearedPayload(broadcasterComponent.getEntity().bg, GeographicEntityWrangler.getGeographicEntityType(broadcasterComponent), this.areaInstanceID, broadcasterComponent.getEntity().getObjectTransform()), bl4, bl5);
                        if (broadcasterVisibility2 == BroadcasterVisibility.SERVER_ONLY) {
                            broadcasterVisibility2 = broadcasterComponent.allowBroadcastsTo(receiverComponent.getEntity());
                            if ((broadcasterVisibility2 = broadcasterVisibility2.and(receiverComponent.allowBroadcastsFrom(broadcasterComponent.getEntity()))) == BroadcasterVisibility.SERVER_AND_CLIENT) {
                                receiverComponent.oppositesInBroadcastRange.put(broadcasterComponent, broadcasterVisibility2);
                                broadcasterComponent.oppositesInBroadcastRange.put(receiverComponent, broadcasterVisibility2);
                                receiverComponent.ReceiveAppeared(new BroadcastStateAndEventsTypes$AppearedPayload(broadcasterComponent.getEntity().bg, GeographicEntityWrangler.getGeographicEntityType(broadcasterComponent), this.areaInstanceID, broadcasterComponent.getEntity().getObjectTransform()), false, true);
                                bl5 = true;
                            }
                        }
                    }
                    Lb33.d(Lb33.CheckReceiveAppeared);
                }
                catch (Throwable throwable) {
                    Lb33.d(Lb33.CheckReceiveAppeared);
                    throw throwable;
                }
                this.TransferFullState(broadcasterComponent, receiverComponent, bl4, bl5);
                if (debug) {
                    Jy122.j(tree);
                }
            }
            if (bl6 || bl3) {
                Lb33.g(Lb33.CheckReceiveGone);
                if (bl6) {
                    logger.trace("      - Gone from server");
                }
                if (bl3) {
                    logger.trace("      - Gone from client");
                }
                if (broadcasterComponent.causesAppearedOrGone()) {
                    if (debug) {
                        Jy122.l(tree, "Broadcaster " + broadcasterComponent + " has dropped out of interest for receiver " + receiverComponent);
                    }
                    receiverComponent.ReceiveGone(new BroadcastStateAndEventsTypes$GonePayload(broadcasterComponent.getEntity().bg, GeographicEntityWrangler.getGeographicEntityType(broadcasterComponent), this.areaInstanceID), bl6, bl3);
                }
                Lb33.d(Lb33.CheckReceiveGone);
            }
            Lb33.d(Lb33.RecalculateVisibilityNow);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.RecalculateVisibilityNow);
            throw throwable;
        }
    }

    static {
        logger = LoggerFactory.getLogger(BroadcastStateAndEventsHub.class);
        debug = false;
        verbose = false;
        tree = new Jy122(logger, 2);
        hubsByScene = new Fl59();
    }
}

