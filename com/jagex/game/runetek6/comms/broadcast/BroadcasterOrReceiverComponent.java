/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsHub;
import com.jagex.game.runetek6.comms.broadcast.ReceiverDetachedException;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Fl59;

abstract class BroadcasterOrReceiverComponent
extends Component {
    static final int ALL = 3;
    static final int SMALLEST = 0;
    private static final int WITHIN_100 = 1;
    private static final int WITHIN_20 = 0;
    private static final int WITHIN_500 = 2;
    private static final Logger logger = LoggerFactory.getLogger(BroadcasterOrReceiverComponent.class);
    BroadcastStateAndEventsHub currentHub;
    boolean isUsed;
    private final Vector3[] lastUpdatePositions;
    final Set[] oppositesByProximityToVisibilityBorder = new Set[]{new HashSet<E>(), new HashSet<E>(), new HashSet<E>(), new HashSet<E>()};
    final Map oppositesInBroadcastRange;
    int requiredRecalculateLevel;

    private void tryDetachFromScene() {
        if (this.currentHub != null) {
            logger.trace("{} detached from hub {}", this, (Object)this.currentHub);
            this.removeAllOppositeComponents();
            this.currentHub = null;
            for (int i = 0; i < this.lastUpdatePositions.length; ++i) {
                this.lastUpdatePositions[i] = Vector3.e;
            }
        }
    }

    public void tryToRepair(BroadcastStateAndEventsHub broadcastStateAndEventsHub, int n) {
        GameEntity gameEntity = this.getEntity();
        if (gameEntity == null && n == 0) {
            logger.error("- {} is not attached to an entity! This is strange, because Scene.getComponents() should have skipped us.", this);
        }
        if (!this.isUsed && this.currentHub != null) {
            if (n == 0) {
                logger.error("- ({}).currentHub was {} (the one I'm repairing is {}), but the component is unused, so the hub should have been null! I'll try to remove this component from the hub I'm repairing.", new Object[]{this, this.currentHub, broadcastStateAndEventsHub});
            } else {
                this.currentHub = null;
            }
        }
        if (this.isUsed && this.currentHub != broadcastStateAndEventsHub && n == 0) {
            logger.error("- ({}).currentHub is {} instead of the one I'm repairing, {}. I'll try to remove this component from the hub I'm repairing.", new Object[]{this, this.currentHub, broadcastStateAndEventsHub});
        }
        this.tryToRepairOpposites(broadcastStateAndEventsHub, n, 0);
        this.tryToRepairOpposites(broadcastStateAndEventsHub, n, 1);
        this.tryToRepairOpposites(broadcastStateAndEventsHub, n, 2);
        this.tryToRepairOpposites(broadcastStateAndEventsHub, n, 3);
        this.tryToRepairSubsets(n, 3, 2);
        this.tryToRepairSubsets(n, 2, 1);
        this.tryToRepairSubsets(n, 1, 0);
        this.tryToRepairBroadcastRangeSet(n);
    }

    abstract void resetVisibilityNow(BroadcasterOrReceiverComponent var1) throws ReceiverDetachedException;

    private void tryToRepairSubsets(int n, int n2, int n3) {
        Set set = this.oppositesByProximityToVisibilityBorder[n2];
        Set set2 = this.oppositesByProximityToVisibilityBorder[n3];
        Iterator<E> iterator = set2.iterator();
        while (iterator.hasNext()) {
            BroadcasterOrReceiverComponent broadcasterOrReceiverComponent = (BroadcasterOrReceiverComponent)iterator.next();
            if (set.contains(broadcasterOrReceiverComponent)) continue;
            if (n == 0) {
                logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was not in the next bigger set [{}].", new Object[]{this, n3, broadcasterOrReceiverComponent, n2});
                continue;
            }
            iterator.remove();
        }
    }

    private void tryToRepairOpposites(BroadcastStateAndEventsHub broadcastStateAndEventsHub, int n, int n2) {
        Set set = this.oppositesByProximityToVisibilityBorder[n2];
        Iterator<E> iterator = set.iterator();
        while (iterator.hasNext()) {
            BroadcasterOrReceiverComponent broadcasterOrReceiverComponent = (BroadcasterOrReceiverComponent)iterator.next();
            if (broadcasterOrReceiverComponent == null) {
                if (n == 0) {
                    logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained a null.", this, (Object)n2);
                    continue;
                }
                iterator.remove();
                continue;
            }
            boolean bl = false;
            if (broadcasterOrReceiverComponent.getEntity() == null) {
                if (n == 0) {
                    logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was not attached to an entity.", new Object[]{this, n2, broadcasterOrReceiverComponent});
                } else {
                    bl = true;
                }
            }
            if (!broadcasterOrReceiverComponent.isUsed) {
                if (n == 0) {
                    logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was unused and shouldn't have been involved in a mapping.", new Object[]{this, n2, broadcasterOrReceiverComponent});
                } else {
                    bl = true;
                }
            }
            if (broadcasterOrReceiverComponent.currentHub != broadcastStateAndEventsHub) {
                if (n == 0) {
                    logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was in hub {} instead of {}.", new Object[]{this, n2, broadcasterOrReceiverComponent, broadcasterOrReceiverComponent.currentHub, this.currentHub});
                } else {
                    bl = true;
                }
            }
            if (!broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[n2].contains(this)) {
                if (n == 0) {
                    logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} but the reverse mapping doesn't exist.", new Object[]{this, n2, broadcasterOrReceiverComponent});
                } else {
                    bl = true;
                }
            }
            if (this.currentHub != broadcastStateAndEventsHub) {
                bl = true;
            }
            if (n != 1 || !bl) continue;
            iterator.remove();
            broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[n2].remove(this);
        }
    }

    @Override
    protected final void attachToEntity() {
        this.tryAttachToScene();
    }

    @Override
    protected final void detachFromEntity() {
        this.tryDetachFromScene();
    }

    @Override
    public final void addedToScene() {
        this.tryAttachToScene();
    }

    @Override
    public final void removingFromScene() {
        this.tryDetachFromScene();
    }

    abstract void recalculateVisibilityNextService(BroadcasterOrReceiverComponent var1);

    abstract Class getOppositeComponentClass();

    private void addOppositeComponent(BroadcasterOrReceiverComponent broadcasterOrReceiverComponent) {
        logger.trace("- Adding opposite {} to {}", broadcasterOrReceiverComponent, (Object)this);
        this.oppositesByProximityToVisibilityBorder[3].add(broadcasterOrReceiverComponent);
        broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[3].add(this);
        float f = Vector3.ag(this.getEntity().getWorldTransform().trans, broadcasterOrReceiverComponent.getEntity().getWorldTransform().trans);
        float f2 = this.getMinDistanceForPair(broadcasterOrReceiverComponent);
        float f3 = Math.abs(f - f2);
        if (f3 <= 500.0f) {
            logger.trace("  - within 500");
            this.oppositesByProximityToVisibilityBorder[2].add(broadcasterOrReceiverComponent);
            broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[2].add(this);
            if (f3 <= 100.0f) {
                logger.trace("  - within 100");
                this.oppositesByProximityToVisibilityBorder[1].add(broadcasterOrReceiverComponent);
                broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[1].add(this);
                if (f3 <= 20.0f) {
                    logger.trace("  - within 20");
                    this.oppositesByProximityToVisibilityBorder[0].add(broadcasterOrReceiverComponent);
                    broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[0].add(this);
                }
            }
        }
        this.recalculateVisibilityNextService(broadcasterOrReceiverComponent);
    }

    private void removeAllOppositeComponents() {
        Object[] arrobject;
        for (Object object : arrobject = this.oppositesByProximityToVisibilityBorder[3].toArray()) {
            BroadcasterOrReceiverComponent broadcasterOrReceiverComponent = (BroadcasterOrReceiverComponent)object;
            logger.trace("- Removing opposite {} from {}", broadcasterOrReceiverComponent, (Object)this);
            try {
                this.resetVisibilityNow(broadcasterOrReceiverComponent);
            }
            catch (ReceiverDetachedException receiverDetachedException) {
                // empty catch block
            }
            this.oppositesByProximityToVisibilityBorder[3].remove(broadcasterOrReceiverComponent);
            this.oppositesByProximityToVisibilityBorder[2].remove(broadcasterOrReceiverComponent);
            this.oppositesByProximityToVisibilityBorder[1].remove(broadcasterOrReceiverComponent);
            this.oppositesByProximityToVisibilityBorder[0].remove(broadcasterOrReceiverComponent);
            broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[3].remove(this);
            broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[2].remove(this);
            broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[1].remove(this);
            broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[0].remove(this);
        }
    }

    abstract float getMinDistanceForPair(BroadcasterOrReceiverComponent var1);

    private void tryAttachToScene() {
        GameEntity gameEntity;
        if (this.isUsed && (gameEntity = this.getEntity()) != null) {
            Scene scene = gameEntity.getScene();
            this.currentHub = (BroadcastStateAndEventsHub)Fl59.d(BroadcastStateAndEventsHub.hubsByScene, scene);
            if (this.currentHub != null) {
                logger.trace("{} attached to hub {}", this, (Object)this.currentHub);
                for (BroadcasterOrReceiverComponent broadcasterOrReceiverComponent : scene.x(this.getOppositeComponentClass())) {
                    if (!broadcasterOrReceiverComponent.isUsed) continue;
                    this.addOppositeComponent(broadcasterOrReceiverComponent);
                }
                this.requiredRecalculateLevel = 3;
            }
        }
    }

    BroadcasterOrReceiverComponent() {
        this.lastUpdatePositions = new Vector3[]{Vector3.e, Vector3.e, Vector3.e, Vector3.e};
        this.oppositesInBroadcastRange = new HashMap<K, V>();
    }

    final void markAsUsed() {
        if (!this.isUsed) {
            this.isUsed = true;
            this.tryAttachToScene();
        }
    }

    private void tryToRepairBroadcastRangeSet(int n) {
        Set set = this.oppositesByProximityToVisibilityBorder[3];
        Set<K> set2 = this.oppositesInBroadcastRange.keySet();
        Iterator<K> iterator = set2.iterator();
        while (iterator.hasNext()) {
            BroadcasterOrReceiverComponent broadcasterOrReceiverComponent = (BroadcasterOrReceiverComponent)iterator.next();
            if (set.contains(broadcasterOrReceiverComponent)) continue;
            if (n == 0) {
                logger.error("- ({}).oppositesInBroadcastRange contained {} which was not in the ALL set.", new Object[]{this, broadcasterOrReceiverComponent});
                continue;
            }
            iterator.remove();
        }
    }
}

