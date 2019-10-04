// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.HashSet;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Fl59;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import com.jagex.game.runetek6.gameentity.Component;

abstract class BroadcasterOrReceiverComponent extends Component
{
    static final int ALL = 3;
    static final int SMALLEST = 0;
    private static final int WITHIN_100 = 1;
    private static final int WITHIN_20 = 0;
    private static final int WITHIN_500 = 2;
    private static final Logger logger;
    BroadcastStateAndEventsHub currentHub;
    boolean isUsed;
    private final Vector3[] lastUpdatePositions;
    final Set[] oppositesByProximityToVisibilityBorder;
    final Map oppositesInBroadcastRange;
    int requiredRecalculateLevel;
    
    private void tryDetachFromScene() {
        if (this.currentHub != null) {
            BroadcasterOrReceiverComponent.logger.trace("{} detached from hub {}", this, this.currentHub);
            this.removeAllOppositeComponents();
            this.currentHub = null;
            for (int i = 0; i < this.lastUpdatePositions.length; ++i) {
                this.lastUpdatePositions[i] = Vector3.e;
            }
        }
    }
    
    public void tryToRepair(final BroadcastStateAndEventsHub broadcastStateAndEventsHub, final int n) {
        if (this.getEntity() == null && n == 0) {
            BroadcasterOrReceiverComponent.logger.error("- {} is not attached to an entity! This is strange, because Scene.getComponents() should have skipped us.", this);
        }
        if (!this.isUsed && this.currentHub != null) {
            if (n == 0) {
                BroadcasterOrReceiverComponent.logger.error("- ({}).currentHub was {} (the one I'm repairing is {}), but the component is unused, so the hub should have been null! I'll try to remove this component from the hub I'm repairing.", new Object[] { this, this.currentHub, broadcastStateAndEventsHub });
            }
            else {
                this.currentHub = null;
            }
        }
        if (this.isUsed && this.currentHub != broadcastStateAndEventsHub && n == 0) {
            BroadcasterOrReceiverComponent.logger.error("- ({}).currentHub is {} instead of the one I'm repairing, {}. I'll try to remove this component from the hub I'm repairing.", new Object[] { this, this.currentHub, broadcastStateAndEventsHub });
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
    
    abstract void resetVisibilityNow(final BroadcasterOrReceiverComponent p0) throws ReceiverDetachedException;
    
    private void tryToRepairSubsets(final int n, final int i, final int j) {
        final Set set = this.oppositesByProximityToVisibilityBorder[i];
        final Iterator<BroadcasterOrReceiverComponent> iterator = (Iterator<BroadcasterOrReceiverComponent>)this.oppositesByProximityToVisibilityBorder[j].iterator();
        while (iterator.hasNext()) {
            final BroadcasterOrReceiverComponent broadcasterOrReceiverComponent = iterator.next();
            if (!set.contains(broadcasterOrReceiverComponent)) {
                if (n == 0) {
                    BroadcasterOrReceiverComponent.logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was not in the next bigger set [{}].", new Object[] { this, j, broadcasterOrReceiverComponent, i });
                }
                else {
                    iterator.remove();
                }
            }
        }
    }
    
    private void tryToRepairOpposites(final BroadcastStateAndEventsHub broadcastStateAndEventsHub, final int n, final int i) {
        final Iterator<BroadcasterOrReceiverComponent> iterator = (Iterator<BroadcasterOrReceiverComponent>)this.oppositesByProximityToVisibilityBorder[i].iterator();
        while (iterator.hasNext()) {
            final BroadcasterOrReceiverComponent broadcasterOrReceiverComponent = iterator.next();
            if (broadcasterOrReceiverComponent == null) {
                if (n == 0) {
                    BroadcasterOrReceiverComponent.logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained a null.", this, i);
                }
                else {
                    iterator.remove();
                }
            }
            else {
                boolean b = false;
                if (broadcasterOrReceiverComponent.getEntity() == null) {
                    if (n == 0) {
                        BroadcasterOrReceiverComponent.logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was not attached to an entity.", new Object[] { this, i, broadcasterOrReceiverComponent });
                    }
                    else {
                        b = true;
                    }
                }
                if (!broadcasterOrReceiverComponent.isUsed) {
                    if (n == 0) {
                        BroadcasterOrReceiverComponent.logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was unused and shouldn't have been involved in a mapping.", new Object[] { this, i, broadcasterOrReceiverComponent });
                    }
                    else {
                        b = true;
                    }
                }
                if (broadcasterOrReceiverComponent.currentHub != broadcastStateAndEventsHub) {
                    if (n == 0) {
                        BroadcasterOrReceiverComponent.logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was in hub {} instead of {}.", new Object[] { this, i, broadcasterOrReceiverComponent, broadcasterOrReceiverComponent.currentHub, this.currentHub });
                    }
                    else {
                        b = true;
                    }
                }
                if (!broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[i].contains(this)) {
                    if (n == 0) {
                        BroadcasterOrReceiverComponent.logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} but the reverse mapping doesn't exist.", new Object[] { this, i, broadcasterOrReceiverComponent });
                    }
                    else {
                        b = true;
                    }
                }
                if (this.currentHub != broadcastStateAndEventsHub) {
                    b = true;
                }
                if (n != 1 || !b) {
                    continue;
                }
                iterator.remove();
                broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[i].remove(this);
            }
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
    
    abstract void recalculateVisibilityNextService(final BroadcasterOrReceiverComponent p0);
    
    abstract Class getOppositeComponentClass();
    
    private void addOppositeComponent(final BroadcasterOrReceiverComponent broadcasterOrReceiverComponent) {
        BroadcasterOrReceiverComponent.logger.trace("- Adding opposite {} to {}", broadcasterOrReceiverComponent, this);
        this.oppositesByProximityToVisibilityBorder[3].add(broadcasterOrReceiverComponent);
        broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[3].add(this);
        final float abs = Math.abs(Vector3.ag(this.getEntity().getWorldTransform().trans, broadcasterOrReceiverComponent.getEntity().getWorldTransform().trans) - this.getMinDistanceForPair(broadcasterOrReceiverComponent));
        if (abs <= 500.0f) {
            BroadcasterOrReceiverComponent.logger.trace("  - within 500");
            this.oppositesByProximityToVisibilityBorder[2].add(broadcasterOrReceiverComponent);
            broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[2].add(this);
            if (abs <= 100.0f) {
                BroadcasterOrReceiverComponent.logger.trace("  - within 100");
                this.oppositesByProximityToVisibilityBorder[1].add(broadcasterOrReceiverComponent);
                broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[1].add(this);
                if (abs <= 20.0f) {
                    BroadcasterOrReceiverComponent.logger.trace("  - within 20");
                    this.oppositesByProximityToVisibilityBorder[0].add(broadcasterOrReceiverComponent);
                    broadcasterOrReceiverComponent.oppositesByProximityToVisibilityBorder[0].add(this);
                }
            }
        }
        this.recalculateVisibilityNextService(broadcasterOrReceiverComponent);
    }
    
    private void removeAllOppositeComponents() {
        final Object[] array = this.oppositesByProximityToVisibilityBorder[3].toArray();
        for (int length = array.length, i = 0; i < length; ++i) {
            final BroadcasterOrReceiverComponent broadcasterOrReceiverComponent = (BroadcasterOrReceiverComponent)array[i];
            BroadcasterOrReceiverComponent.logger.trace("- Removing opposite {} from {}", broadcasterOrReceiverComponent, this);
            try {
                this.resetVisibilityNow(broadcasterOrReceiverComponent);
            }
            catch (ReceiverDetachedException ex) {}
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
    
    abstract float getMinDistanceForPair(final BroadcasterOrReceiverComponent p0);
    
    private void tryAttachToScene() {
        if (this.isUsed) {
            final GameEntity entity = this.getEntity();
            if (entity != null) {
                final Scene scene = entity.getScene();
                this.currentHub = (BroadcastStateAndEventsHub)Fl59.d(BroadcastStateAndEventsHub.hubsByScene, scene);
                if (this.currentHub != null) {
                    BroadcasterOrReceiverComponent.logger.trace("{} attached to hub {}", this, this.currentHub);
                    for (final BroadcasterOrReceiverComponent broadcasterOrReceiverComponent : scene.x(this.getOppositeComponentClass())) {
                        if (broadcasterOrReceiverComponent.isUsed) {
                            this.addOppositeComponent(broadcasterOrReceiverComponent);
                        }
                    }
                    this.requiredRecalculateLevel = 3;
                }
            }
        }
    }
    
    BroadcasterOrReceiverComponent() {
        this.oppositesByProximityToVisibilityBorder = new Set[] { new HashSet(), new HashSet(), new HashSet(), new HashSet() };
        this.lastUpdatePositions = new Vector3[] { Vector3.e, Vector3.e, Vector3.e, Vector3.e };
        this.oppositesInBroadcastRange = new HashMap();
    }
    
    final void markAsUsed() {
        if (!this.isUsed) {
            this.isUsed = true;
            this.tryAttachToScene();
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(BroadcasterOrReceiverComponent.class);
    }
    
    private void tryToRepairBroadcastRangeSet(final int n) {
        final Set set = this.oppositesByProximityToVisibilityBorder[3];
        final Iterator<BroadcasterOrReceiverComponent> iterator = this.oppositesInBroadcastRange.keySet().iterator();
        while (iterator.hasNext()) {
            final BroadcasterOrReceiverComponent broadcasterOrReceiverComponent = iterator.next();
            if (!set.contains(broadcasterOrReceiverComponent)) {
                if (n == 0) {
                    BroadcasterOrReceiverComponent.logger.error("- ({}).oppositesInBroadcastRange contained {} which was not in the ALL set.", new Object[] { this, broadcasterOrReceiverComponent });
                }
                else {
                    iterator.remove();
                }
            }
        }
    }
}
