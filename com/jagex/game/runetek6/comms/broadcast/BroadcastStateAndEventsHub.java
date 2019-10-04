package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.maths.Vector3;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Fl59;
import tfu.Jo533;
import tfu.Jy122;
import tfu.Lb33;

@ScriptEntryClass("Broadcast")
public class BroadcastStateAndEventsHub {
   public static boolean debug = false;
   static Fl59 hubsByScene;
   private static final Logger logger = LoggerFactory.getLogger(BroadcastStateAndEventsHub.class);
   public static Jy122 tree;
   public static boolean verbose = false;
   private final int areaInstanceID;
   private boolean isDisabled;
   private Map pendingMessages;
   private ArrayDeque recalculateVisibilityRequests = new ArrayDeque();
   private final Scene scene;

   private void TransferMessage(BroadcasterComponent var1, ReceiverComponent var2, BroadcastStateAndEventsTypes$MessageDefinition var3, BroadcastStateAndEventsTypes$MessagePayload var4, boolean var5, boolean var6) throws ReceiverDetachedException {
      Lb33.g(Lb33.TransferMessage);

      try {
         var4.wranglerID = GeographicEntityWrangler.getGeographicEntityType(var1);
         var4.areaID = this.areaInstanceID;
         if (var3 instanceof BroadcastStateAndEventsTypes$StateDefinition) {
            var2.ReceiveState(var3.messageName, (BroadcastStateAndEventsTypes$StatePayload)var4, var5, var6);
         } else if (var3 instanceof BroadcastStateAndEventsTypes$EventDefinition) {
            var2.ReceiveEvent(var3.messageName, (BroadcastStateAndEventsTypes$EventPayload)var4, var5, var6);
         } else if (var3 instanceof BroadcastStateAndEventsTypes$AppearedDefinition) {
            var2.ReceiveAppeared((BroadcastStateAndEventsTypes$AppearedPayload)var4, var5, var6);
         } else {
            if (!(var3 instanceof BroadcastStateAndEventsTypes$GoneDefinition)) {
               throw new RuntimeException("Oo-er, unknown message definition type- " + var3);
            }

            var2.ReceiveGone((BroadcastStateAndEventsTypes$GonePayload)var4, var5, var6);
         }

         Lb33.d(Lb33.TransferMessage);
      } finally {
         Lb33.d(Lb33.TransferMessage);
      }
   }

   void recalculateVisibilityNextService(ReceiverComponent var1, BroadcasterComponent var2) {
      logger.trace("  - Internal recalculateVisibilityNextService between {} and {}", var1, var2);
      this.recalculateVisibilityRequests.add(new BroadcastStateAndEventsHub$RecalculateVisibilityRequest(var1, var2));
   }

   void resetVisibilityNow(ReceiverComponent var1, BroadcasterComponent var2) throws ReceiverDetachedException {
      if (var1.currentHub == this && var2.currentHub == this) {
         logger.trace("  - Internal resetVisibilityNow from {} to {}", var2, var1);
         this.recalculateVisibilityNow(var1, var2, false);
      }

   }

   private void TransferFullState(BroadcasterComponent var1, ReceiverComponent var2, boolean var3, boolean var4) throws ReceiverDetachedException {
      if (debug) {
         Jy122.h(tree, "Transferring full state from broadcaster " + var1 + " to receiver " + var2);
      }

      Lb33.g(Lb33.TransferFullState);
      boolean var11 = false;

      try {
         var11 = true;
         Iterator var5 = var1.persistedState.entrySet().iterator();

         while(true) {
            if (!var5.hasNext()) {
               Lb33.d(Lb33.TransferFullState);
               var11 = false;
               break;
            }

            Entry var6 = (Entry)var5.next();
            BroadcastStateAndEventsTypes$StateDefinition var7 = (BroadcastStateAndEventsTypes$StateDefinition)var6.getKey();
            BroadcastStateAndEventsTypes$StatePayload var8 = (BroadcastStateAndEventsTypes$StatePayload)var6.getValue();
            if (debug) {
               Jy122.s(tree, "type " + var7);
            }

            this.TransferMessage(var1, var2, var7, var8, var3, var4);
         }
      } finally {
         if (var11) {
            Lb33.d(Lb33.TransferFullState);
         }
      }

      if (debug) {
         Jy122.l(tree, "Transferred " + var1.persistedState.size() + " state message(s).");
      }

   }

   private void recalculateVisibilityNow(ReceiverComponent var1, BroadcasterComponent var2, boolean var3) throws ReceiverDetachedException {
      Vector3 var4 = var1.getEntity().getWorldTransform().trans;
      float var5 = var1.getMinimumInterestRadius();
      float var6 = var5 * var5;
      boolean var7 = var1.useBroadcasterMinimumBroadcastRadius();
      this.recalculateVisibilityNow(var1, var4, var6, var7, var2, var3);
   }

   void queueMessageForCurrentReceivers(BroadcasterComponent var1, BroadcastStateAndEventsTypes$MessageDefinition var2, BroadcastStateAndEventsTypes$MessagePayload var3) {
      if (debug) {
         Jy122.s(tree, "Queuing message on " + var1 + ", type=" + var2 + ", payload=" + var3);
      }

      Map var4 = this.pendingMessages;
      synchronized(var4) {
         Object var5 = (List)this.pendingMessages.get(var1);
         if (var5 == null) {
            var5 = new LinkedList();
            this.pendingMessages.put(var1, var5);
         }

         ((List)var5).add(new BroadcastStateAndEventsHub$PendingMessage(var2, var3));
      }
   }

   public BroadcastStateAndEventsHub(Scene var1, int var2, boolean var3) {
      Jy122.d(tree, "==== ");
      this.scene = var1;
      this.areaInstanceID = var2;
      this.isDisabled = var3;
      hubsByScene.g(this.scene, this);
      this.pendingMessages = new WeakHashMap();
      if (debug) {
         Jy122.s(tree, "Created new BroadcastStateAndEventsHub.");
      }

   }

   private void recalculateVisibilityNow(ReceiverComponent var1, Vector3 var2, float var3, boolean var4, BroadcasterComponent var5, boolean var6) throws ReceiverDetachedException {
      Lb33.g(Lb33.RecalculateVisibilityNow);

      try {
         logger.trace("    - Recalculating visibility between {} and {}", var1, var5);
         BroadcasterVisibility var7 = BroadcasterVisibility.UNKNOWN;
         Lb33.g(Lb33.GetVisibility);
         boolean var45 = false;

         try {
            var45 = true;
            if (var6 && var5.getEntity() != var1.getEntity()) {
               float var8 = Vector3.aq(var5.getEntity().getWorldTransform().trans, var2);
               float var9 = var3;
               if (var4) {
                  float var10 = var5.getMinimumBroadcastRadius();
                  float var11 = var10 * var10;
                  if (var11 > var3) {
                     var9 = var11;
                  }
               }

               if (var8 <= var9) {
                  var7 = var5.allowBroadcastsTo(var1.getEntity());
                  var7 = var7.and(var1.allowBroadcastsFrom(var5.getEntity()));
                  if (debug && verbose) {
                     Jo533.d(tree, var5.toString(), "Broadcast " + var7 + " from " + var5 + " to " + var1);
                  }
               }
            }

            Lb33.d(Lb33.GetVisibility);
            var45 = false;
         } finally {
            if (var45) {
               Lb33.d(Lb33.GetVisibility);
            }
         }

         Lb33.g(Lb33.CompareVisibility);
         boolean var39 = false;

         BroadcasterVisibility var51;
         try {
            var39 = true;
            if (var7 != BroadcasterVisibility.UNKNOWN) {
               var51 = (BroadcasterVisibility)var1.oppositesInBroadcastRange.put(var5, var7);
               var5.oppositesInBroadcastRange.put(var1, var7);
            } else {
               var51 = (BroadcasterVisibility)var1.oppositesInBroadcastRange.remove(var5);
               var5.oppositesInBroadcastRange.remove(var1);
            }

            if (var51 == null) {
               var51 = BroadcasterVisibility.UNKNOWN;
            }

            Lb33.d(Lb33.CompareVisibility);
            var39 = false;
         } finally {
            if (var39) {
               Lb33.d(Lb33.CompareVisibility);
            }
         }

         boolean var52 = var51 == BroadcasterVisibility.UNKNOWN && var7 != BroadcasterVisibility.UNKNOWN;
         boolean var53 = var51 != BroadcasterVisibility.SERVER_AND_CLIENT && var7 == BroadcasterVisibility.SERVER_AND_CLIENT;
         boolean var54 = var51 != BroadcasterVisibility.UNKNOWN && var7 == BroadcasterVisibility.UNKNOWN;
         boolean var12 = var51 == BroadcasterVisibility.SERVER_AND_CLIENT && var7 != BroadcasterVisibility.SERVER_AND_CLIENT;
         if (var52 || var53) {
            if (var52) {
               logger.trace("      - Newly known to server");
            }

            if (var53) {
               logger.trace("      - Newly known to client");
            }

            if (debug) {
               Jy122.h(tree, "Broadcaster " + var5 + " is freshly in view for receiver " + var1 + ", sending full state.");
            }

            Lb33.g(Lb33.CheckReceiveAppeared);
            boolean var33 = false;

            try {
               var33 = true;
               if (var5.causesAppearedOrGone()) {
                  if (debug) {
                     Jy122.l(tree, "Broadcaster " + var5 + " is sending an 'Appeared' message to " + var1);
                  }

                  var1.ReceiveAppeared(new BroadcastStateAndEventsTypes$AppearedPayload(var5.getEntity().bg, GeographicEntityWrangler.getGeographicEntityType(var5), this.areaInstanceID, var5.getEntity().getObjectTransform()), var52, var53);
                  if (var7 == BroadcasterVisibility.SERVER_ONLY) {
                     var7 = var5.allowBroadcastsTo(var1.getEntity());
                     var7 = var7.and(var1.allowBroadcastsFrom(var5.getEntity()));
                     if (var7 == BroadcasterVisibility.SERVER_AND_CLIENT) {
                        var1.oppositesInBroadcastRange.put(var5, var7);
                        var5.oppositesInBroadcastRange.put(var1, var7);
                        var1.ReceiveAppeared(new BroadcastStateAndEventsTypes$AppearedPayload(var5.getEntity().bg, GeographicEntityWrangler.getGeographicEntityType(var5), this.areaInstanceID, var5.getEntity().getObjectTransform()), false, true);
                        var53 = true;
                     }
                  }
               }

               Lb33.d(Lb33.CheckReceiveAppeared);
               var33 = false;
            } finally {
               if (var33) {
                  Lb33.d(Lb33.CheckReceiveAppeared);
               }
            }

            this.TransferFullState(var5, var1, var52, var53);
            if (debug) {
               Jy122.j(tree);
            }
         }

         if (var54 || var12) {
            Lb33.g(Lb33.CheckReceiveGone);
            boolean var27 = false;

            try {
               var27 = true;
               if (var54) {
                  logger.trace("      - Gone from server");
               }

               if (var12) {
                  logger.trace("      - Gone from client");
               }

               if (var5.causesAppearedOrGone()) {
                  if (debug) {
                     Jy122.l(tree, "Broadcaster " + var5 + " has dropped out of interest for receiver " + var1);
                  }

                  var1.ReceiveGone(new BroadcastStateAndEventsTypes$GonePayload(var5.getEntity().bg, GeographicEntityWrangler.getGeographicEntityType(var5), this.areaInstanceID), var54, var12);
               }

               Lb33.d(Lb33.CheckReceiveGone);
               var27 = false;
            } finally {
               if (var27) {
                  Lb33.d(Lb33.CheckReceiveGone);
               }
            }
         }

         Lb33.d(Lb33.RecalculateVisibilityNow);
      } finally {
         Lb33.d(Lb33.RecalculateVisibilityNow);
      }
   }

   static {
      tree = new Jy122(logger, 2);
      hubsByScene = new Fl59();
   }
}
