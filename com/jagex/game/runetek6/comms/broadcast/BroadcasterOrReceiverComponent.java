package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.maths.Vector3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Fl59;

abstract class BroadcasterOrReceiverComponent extends Component {
   static final int ALL = 3;
   static final int SMALLEST = 0;
   private static final int WITHIN_100 = 1;
   private static final int WITHIN_20 = 0;
   private static final int WITHIN_500 = 2;
   private static final Logger logger = LoggerFactory.getLogger(BroadcasterOrReceiverComponent.class);
   BroadcastStateAndEventsHub currentHub;
   boolean isUsed;
   private final Vector3[] lastUpdatePositions;
   final Set[] oppositesByProximityToVisibilityBorder = new Set[]{new HashSet(), new HashSet(), new HashSet(), new HashSet()};
   final Map oppositesInBroadcastRange;
   int requiredRecalculateLevel;

   private void tryDetachFromScene() {
      if (this.currentHub != null) {
         logger.trace("{} detached from hub {}", this, this.currentHub);
         this.removeAllOppositeComponents();
         this.currentHub = null;

         for(int var1 = 0; var1 < this.lastUpdatePositions.length; ++var1) {
            this.lastUpdatePositions[var1] = Vector3.e;
         }
      }

   }

   public void tryToRepair(BroadcastStateAndEventsHub var1, int var2) {
      GameEntity var3 = this.getEntity();
      if (var3 == null && var2 == 0) {
         logger.error("- {} is not attached to an entity! This is strange, because Scene.getComponents() should have skipped us.", this);
      }

      if (!this.isUsed && this.currentHub != null) {
         if (var2 == 0) {
            logger.error("- ({}).currentHub was {} (the one I'm repairing is {}), but the component is unused, so the hub should have been null! I'll try to remove this component from the hub I'm repairing.", new Object[]{this, this.currentHub, var1});
         } else {
            this.currentHub = null;
         }
      }

      if (this.isUsed && this.currentHub != var1 && var2 == 0) {
         logger.error("- ({}).currentHub is {} instead of the one I'm repairing, {}. I'll try to remove this component from the hub I'm repairing.", new Object[]{this, this.currentHub, var1});
      }

      this.tryToRepairOpposites(var1, var2, 0);
      this.tryToRepairOpposites(var1, var2, 1);
      this.tryToRepairOpposites(var1, var2, 2);
      this.tryToRepairOpposites(var1, var2, 3);
      this.tryToRepairSubsets(var2, 3, 2);
      this.tryToRepairSubsets(var2, 2, 1);
      this.tryToRepairSubsets(var2, 1, 0);
      this.tryToRepairBroadcastRangeSet(var2);
   }

   abstract void resetVisibilityNow(BroadcasterOrReceiverComponent var1) throws ReceiverDetachedException;

   private void tryToRepairSubsets(int var1, int var2, int var3) {
      Set var4 = this.oppositesByProximityToVisibilityBorder[var2];
      Set var5 = this.oppositesByProximityToVisibilityBorder[var3];
      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         BroadcasterOrReceiverComponent var7 = (BroadcasterOrReceiverComponent)var6.next();
         if (!var4.contains(var7)) {
            if (var1 == 0) {
               logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was not in the next bigger set [{}].", new Object[]{this, var3, var7, var2});
            } else {
               var6.remove();
            }
         }
      }

   }

   private void tryToRepairOpposites(BroadcastStateAndEventsHub var1, int var2, int var3) {
      Set var4 = this.oppositesByProximityToVisibilityBorder[var3];
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         BroadcasterOrReceiverComponent var6 = (BroadcasterOrReceiverComponent)var5.next();
         if (var6 == null) {
            if (var2 == 0) {
               logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained a null.", this, var3);
            } else {
               var5.remove();
            }
         } else {
            boolean var7 = false;
            if (var6.getEntity() == null) {
               if (var2 == 0) {
                  logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was not attached to an entity.", new Object[]{this, var3, var6});
               } else {
                  var7 = true;
               }
            }

            if (!var6.isUsed) {
               if (var2 == 0) {
                  logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was unused and shouldn't have been involved in a mapping.", new Object[]{this, var3, var6});
               } else {
                  var7 = true;
               }
            }

            if (var6.currentHub != var1) {
               if (var2 == 0) {
                  logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} which was in hub {} instead of {}.", new Object[]{this, var3, var6, var6.currentHub, this.currentHub});
               } else {
                  var7 = true;
               }
            }

            if (!var6.oppositesByProximityToVisibilityBorder[var3].contains(this)) {
               if (var2 == 0) {
                  logger.error("- ({}).oppositesByProximityToVisibilityBorder[{}] contained {} but the reverse mapping doesn't exist.", new Object[]{this, var3, var6});
               } else {
                  var7 = true;
               }
            }

            if (this.currentHub != var1) {
               var7 = true;
            }

            if (var2 == 1 && var7) {
               var5.remove();
               var6.oppositesByProximityToVisibilityBorder[var3].remove(this);
            }
         }
      }

   }

   protected final void attachToEntity() {
      this.tryAttachToScene();
   }

   protected final void detachFromEntity() {
      this.tryDetachFromScene();
   }

   public final void addedToScene() {
      this.tryAttachToScene();
   }

   public final void removingFromScene() {
      this.tryDetachFromScene();
   }

   abstract void recalculateVisibilityNextService(BroadcasterOrReceiverComponent var1);

   abstract Class getOppositeComponentClass();

   private void addOppositeComponent(BroadcasterOrReceiverComponent var1) {
      logger.trace("- Adding opposite {} to {}", var1, this);
      this.oppositesByProximityToVisibilityBorder[3].add(var1);
      var1.oppositesByProximityToVisibilityBorder[3].add(this);
      float var2 = Vector3.ag(this.getEntity().getWorldTransform().trans, var1.getEntity().getWorldTransform().trans);
      float var3 = this.getMinDistanceForPair(var1);
      float var4 = Math.abs(var2 - var3);
      if (var4 <= 500.0F) {
         logger.trace("  - within 500");
         this.oppositesByProximityToVisibilityBorder[2].add(var1);
         var1.oppositesByProximityToVisibilityBorder[2].add(this);
         if (var4 <= 100.0F) {
            logger.trace("  - within 100");
            this.oppositesByProximityToVisibilityBorder[1].add(var1);
            var1.oppositesByProximityToVisibilityBorder[1].add(this);
            if (var4 <= 20.0F) {
               logger.trace("  - within 20");
               this.oppositesByProximityToVisibilityBorder[0].add(var1);
               var1.oppositesByProximityToVisibilityBorder[0].add(this);
            }
         }
      }

      this.recalculateVisibilityNextService(var1);
   }

   private void removeAllOppositeComponents() {
      Object[] var1 = this.oppositesByProximityToVisibilityBorder[3].toArray();
      Object[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Object var5 = var2[var4];
         BroadcasterOrReceiverComponent var6 = (BroadcasterOrReceiverComponent)var5;
         logger.trace("- Removing opposite {} from {}", var6, this);

         try {
            this.resetVisibilityNow(var6);
         } catch (ReceiverDetachedException var8) {
         }

         this.oppositesByProximityToVisibilityBorder[3].remove(var6);
         this.oppositesByProximityToVisibilityBorder[2].remove(var6);
         this.oppositesByProximityToVisibilityBorder[1].remove(var6);
         this.oppositesByProximityToVisibilityBorder[0].remove(var6);
         var6.oppositesByProximityToVisibilityBorder[3].remove(this);
         var6.oppositesByProximityToVisibilityBorder[2].remove(this);
         var6.oppositesByProximityToVisibilityBorder[1].remove(this);
         var6.oppositesByProximityToVisibilityBorder[0].remove(this);
      }

   }

   abstract float getMinDistanceForPair(BroadcasterOrReceiverComponent var1);

   private void tryAttachToScene() {
      if (this.isUsed) {
         GameEntity var1 = this.getEntity();
         if (var1 != null) {
            Scene var2 = var1.getScene();
            this.currentHub = (BroadcastStateAndEventsHub)Fl59.d(BroadcastStateAndEventsHub.hubsByScene, var2);
            if (this.currentHub != null) {
               logger.trace("{} attached to hub {}", this, this.currentHub);
               Iterator var3 = var2.x(this.getOppositeComponentClass()).iterator();

               while(var3.hasNext()) {
                  BroadcasterOrReceiverComponent var4 = (BroadcasterOrReceiverComponent)var3.next();
                  if (var4.isUsed) {
                     this.addOppositeComponent(var4);
                  }
               }

               this.requiredRecalculateLevel = 3;
            }
         }
      }

   }

   BroadcasterOrReceiverComponent() {
      this.lastUpdatePositions = new Vector3[]{Vector3.e, Vector3.e, Vector3.e, Vector3.e};
      this.oppositesInBroadcastRange = new HashMap();
   }

   final void markAsUsed() {
      if (!this.isUsed) {
         this.isUsed = true;
         this.tryAttachToScene();
      }

   }

   private void tryToRepairBroadcastRangeSet(int var1) {
      Set var2 = this.oppositesByProximityToVisibilityBorder[3];
      Set var3 = this.oppositesInBroadcastRange.keySet();
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         BroadcasterOrReceiverComponent var5 = (BroadcasterOrReceiverComponent)var4.next();
         if (!var2.contains(var5)) {
            if (var1 == 0) {
               logger.error("- ({}).oppositesInBroadcastRange contained {} which was not in the ALL set.", new Object[]{this, var5});
            } else {
               var4.remove();
            }
         }
      }

   }
}
