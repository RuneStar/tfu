package tfu;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizerListener;
import com.jagex.game.runetek6.comms.statestream.StateWrapper;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import rs2.client.worldelement.player;
import rs2.shared.movement.E181;
import rs2.shared.movement.PlayerPhysicsAvatar;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.shared.movement.X382;

public class Lz409 implements LossyStateStreamSynchronizerListener {
   static final float a = 0.1F;
   static Map af = new HashMap();
   static int ag = -1;
   static Map ai = new TreeMap(new Lg498());
   static Map al = new HashMap();
   static int aq = -1;
   public static int b = 0;
   static float c = 0.0F;
   public static final Lz409 d = new Lz409();
   public static Q7 e = null;
   static final float f = 0.1F;
   public static final int h = 2;
   static final float i = 0.05F;
   static final float k = 0.2F;
   public static int l = 0;
   private static final Logger logger = LoggerFactory.getLogger(Lz409.class);
   static final float m = 0.2F;
   static final float n = 0.2F;
   static final float o = 0.1F;
   static long p = 0L;
   public static boolean q = true;
   static long[] r = new long[20];
   static int s = 0;
   static final float t = 0.2F;
   static final float u = 0.4F;
   static int v = 0;
   public static long w = System.currentTimeMillis();
   static final Set x = new TreeSet(new Lh494());
   static long y = 0L;
   static final float z = 0.1F;
   private int j = -1;

   public static void b(Lz409 var0) {
      int var1 = -1;
      Iterator var2 = x.iterator();

      while(var2.hasNext()) {
         Integer var3 = (Integer)var2.next();
         if (ai.containsKey(var3)) {
            var1 = var3;
         }
      }

      if (var1 != -1) {
         var0.l(var1);
      }

   }

   void l(int var1) {
      int var2 = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var1, this.j);
      if (var2 != 2) {
         l += var2 / 2 - 1;
      }

      this.j = var1;
      w = System.currentTimeMillis();
      long var3 = System.nanoTime();
      if (p != 0L) {
         long var5 = var3 - p;
         y -= r[v];
         r[v] = var5;
         y += var5;
         v = (v + 1) % r.length;
      }

      p = var3;
      LinkedList var19 = new LinkedList();
      Iterator var6 = x.iterator();

      Integer var7;
      while(var6.hasNext()) {
         var7 = (Integer)var6.next();
         if (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var1, var7) < 0) {
            break;
         }

         var19.add(var7);
      }

      var6 = var19.iterator();

      while(var6.hasNext()) {
         var7 = (Integer)var6.next();
         x.remove(var7);
      }

      if (ag != -1) {
         for(int var20 = ag; LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var20, var1) < 0; var20 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(var20, 1)) {
            ai.remove(var20);
         }

         ag = var1;
         if (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(aq, ag) <= 0) {
            aq = -1;
            ag = -1;
         }
      }

      Lj497 var21 = (Lj497)ai.get(var1);
      if (var21 != null) {
         c = 0.0F;
         al.clear();
         af.clear();
         Iterator var22 = var21.g.entrySet().iterator();

         Q7 var12;
         Vector3 var14;
         while(var22.hasNext()) {
            Entry var8 = (Entry)var22.next();
            player var9 = Gc330.e((Integer)var8.getKey());
            if (var9 != null && var9.c.hasExplicitState(var1)) {
               E181 var10 = (E181)var9.c.getState(var1);
               Q7 var11 = var10.g;
               if (var9 == Gc330.j()) {
                  e = var11;
               }

               var12 = (Q7)var8.getValue();
               Vector3 var13 = var10.d;
               var14 = (Vector3)var21.d.get(var8.getKey());
               Vector3 var15 = var10.q;
               Vector3 var16 = (Vector3)var21.q.get(var8.getKey());
               Lw500 var17 = new Lw500(Vector3.k(var11.g, var12.g), var12.d.q().b().s().r(var11.d.q().b()), Vector3.k(var13, var14), Vector3.k(var15, var16));
               if (Vector3.f(var17.g) > 10.0F) {
                  logger.warn("Snapping player {}", var9.aq);
                  PlayerPhysicsComponent var18 = (PlayerPhysicsComponent)player.eb(var9, PlayerPhysicsComponent.class);
                  if (var18 != null) {
                     PlayerPhysicsAvatar.e(var18.getAvatar(false), var11);
                  }
               } else {
                  al.put(var8.getKey(), var17);
               }
            }
         }

         Object var23 = Collections.emptySet();
         if (client.mm != null) {
            var23 = client.mm.x(ScheduledMovementComponent.class);
         }

         Iterator var24 = ((Collection)var23).iterator();

         while(var24.hasNext()) {
            ScheduledMovementComponent var26 = (ScheduledMovementComponent)var24.next();
            int var28 = var26.getEntity().bg.h();
            if (var21.j.containsKey(var28)) {
               E181 var30 = ScheduledMovementComponent.r(var26, var1);
               if (var30 != null) {
                  var12 = var30.g;
                  Q7 var33 = (Q7)var21.j.get(var28);
                  Lw500 var35 = new Lw500(Vector3.k(var12.g, var33.g), var33.d.q().b().s().r(var12.d.q().b()), (Vector3)null, (Vector3)null);
                  if (Vector3.f(var35.g) > 10.0F) {
                     logger.warn("Snapping npc {}", var26.getEntity().bg.toString());
                     ScheduledMovementComponent.v(var26, var12);
                  } else {
                     af.put(var28, var35);
                  }
               }
            }
         }

         int var25 = var1;

         for(int var27 = 0; LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var25, aq) <= 0; ++var27) {
            Lj497 var29 = (Lj497)ai.get(var25);
            if (var29 == null) {
               break;
            }

            Iterator var31 = var29.g.entrySet().iterator();

            Entry var32;
            Lw500 var34;
            Q7 var36;
            while(var31.hasNext()) {
               var32 = (Entry)var31.next();
               var34 = (Lw500)al.get(var32.getKey());
               if (var34 != null) {
                  var36 = (Q7)var32.getValue();
                  var32.setValue(w(var36, var34.g, var34.d, 0.1F, 0.4F, 0.2F));
               }
            }

            var31 = var29.d.entrySet().iterator();

            while(var31.hasNext()) {
               var32 = (Entry)var31.next();
               var34 = (Lw500)al.get(var32.getKey());
               if (var34 != null) {
                  var14 = (Vector3)var32.getValue();
                  var32.setValue(Vector3.n(var14, var34.q, 0.2F));
               }
            }

            var31 = var29.q.entrySet().iterator();

            while(var31.hasNext()) {
               var32 = (Entry)var31.next();
               var34 = (Lw500)al.get(var32.getKey());
               if (var34 != null) {
                  var14 = (Vector3)var32.getValue();
                  var32.setValue(Vector3.n(var14, var34.j, 0.2F));
               }
            }

            var31 = var29.j.entrySet().iterator();

            while(var31.hasNext()) {
               var32 = (Entry)var31.next();
               var34 = (Lw500)af.get(var32.getKey());
               if (var34 != null) {
                  var36 = (Q7)var32.getValue();
                  var32.setValue(w(var36, var34.g, var34.d, 0.1F, 0.4F, 0.2F));
               }
            }

            var25 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(var25, 1);
         }

      }
   }

   static Q7 w(Q7 var0, Vector3 var1, Quaternion var2, float var3, float var4, float var5) {
      Quaternion var6 = var0.d.q().p(var0.d.q().r(var2).b(), var5);
      Vector3 var7 = Vector3.al(new Vector3(0.0F, 1.0F, 0.0F), var6);
      Vector3 var8 = Vector3.ai(var7, Vector3.o(var1, var7));
      Vector3 var9 = Vector3.k(var1, var8);
      Vector3 var10 = Vector3.n(Vector3.n(var0.g, var8, var3), var9, var4);
      return new Q7(var6.m(), var10);
   }

   public void newStateReceived(LossyStateStreamSynchronizer var1, LossyStateStream var2, StateWrapper var3, long var4) {
      int var6 = var2.id & -16777216;
      int var7;
      if (var6 == 33554432 && var4 >= 0L) {
         var7 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(client.df, Lq191.j() - client.dz);
         int var8 = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var3.timestamp, var7);
         if (var8 < 0) {
            ++b;
         }
      }

      if (var6 == 67108864 || var6 == 83886080 || var6 == 100663296) {
         if (this.j != -1 && LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var3.timestamp, this.j) <= 0) {
            logger.info("Not processing old dynamic state packet {} {}", this.j, var3.timestamp);
         } else if (!client.y(client.ac)) {
            if (q) {
               var7 = var3.timestamp;
               player var13 = Gc330.j();
               if (var13 != null) {
                  if (var13.ag.hasExplicitState(var7)) {
                     X382 var9 = (X382)var13.ag.getState(var7);
                     Iterator var10 = var9.g.iterator();

                     LossyStateStream var12;
                     do {
                        if (!var10.hasNext()) {
                           if (ai.containsKey(var7)) {
                              this.l(var7);
                           } else {
                              x.add(var7);
                           }

                           return;
                        }

                        Integer var11 = (Integer)var10.next();
                        var12 = client.dq.getStream(var11);
                     } while(var12 == null || var12.hasExplicitState(var7));

                  }
               }
            }
         }
      }
   }

   public static void v(int var0) {
      Lj497 var1 = new Lj497();
      Iterator var2 = Gc330.h().iterator();

      while(var2.hasNext()) {
         player var3 = (player)var2.next();
         PlayerPhysicsComponent var4 = (PlayerPhysicsComponent)player.eb(var3, PlayerPhysicsComponent.class);
         if (var4 != null) {
            E181 var5 = var4.e((E181)null, false);
            if (var5 != null) {
               Q7 var6 = var5.g;
               var1.g.put(var3.m, var6);
               var1.d.put(var3.m, var5.d);
               var1.q.put(var3.m, var5.q);
            }
         }
      }

      Object var8 = Collections.emptySet();
      if (client.mm != null) {
         var8 = client.mm.x(ScheduledMovementComponent.class);
      }

      Iterator var9 = ((Collection)var8).iterator();

      while(var9.hasNext()) {
         ScheduledMovementComponent var10 = (ScheduledMovementComponent)var9.next();
         int var11 = var10.getEntity().bg.h();
         E181 var12 = ScheduledMovementComponent.y(var10);
         if (var12 != null) {
            Q7 var7 = var12.g;
            var1.j.put(var11, var7);
         }
      }

      ai.put(var0, var1);
      if (ag == -1) {
         ag = var0;
      }

      aq = var0;
   }

   public void streamAdded(LossyStateStreamSynchronizer var1, LossyStateStream var2, boolean var3) {
   }

   public void streamRemoved(LossyStateStreamSynchronizer var1, LossyStateStream var2) {
   }

   public void newStateAddedToMaster(LossyStateStreamSynchronizer var1, LossyStateStream var2, StateWrapper var3) {
   }

   public static int p(Lz409 var0) {
      return var0.j;
   }

   private Lz409() {
   }

   public static void r() {
      ai.clear();
      ag = -1;
      aq = -1;
   }

   public static void x(Lz409 var0) {
      var0.j = -1;
   }

   public static void y() {
      if (c < 2.0F) {
         ++c;
         Iterator var0 = al.entrySet().iterator();

         Q7 var6;
         while(var0.hasNext()) {
            Entry var1 = (Entry)var0.next();
            player var2 = Gc330.e((Integer)var1.getKey());
            if (var2 != null) {
               PlayerPhysicsComponent var3 = (PlayerPhysicsComponent)player.eb(var2, PlayerPhysicsComponent.class);
               if (var3 != null) {
                  PlayerPhysicsAvatar var4 = var3.getAvatar(false);
                  Lw500 var5 = (Lw500)var1.getValue();
                  var6 = var4.getCurrentTransform();
                  if (var6 != null) {
                     Q7 var7 = w(var6, var5.g, var5.d, 0.05F, 0.2F, 0.1F);
                     PlayerPhysicsAvatar.e(var4, var7);
                     Vector3 var8 = var3.getLinearVelocity(false);
                     Vector3 var9 = Vector3.z(var8, var5.q);
                     PlayerPhysicsComponent.h(var3, Vector3.av(var8, var9, 0.1F), true, false);
                     Vector3 var10 = var3.getAngularVelocity(false);
                     Vector3 var11 = Vector3.z(var10, var5.j);
                     PlayerPhysicsComponent.s(var3, Vector3.av(var10, var11, 0.1F), true, false);
                  }
               }
            }
         }

         Object var12 = Collections.emptySet();
         if (client.mm != null) {
            var12 = client.mm.x(ScheduledMovementComponent.class);
         }

         Iterator var13 = ((Collection)var12).iterator();

         while(var13.hasNext()) {
            ScheduledMovementComponent var14 = (ScheduledMovementComponent)var13.next();
            int var15 = var14.getEntity().bg.h();
            Lw500 var16 = (Lw500)af.get(var15);
            if (var16 != null) {
               Q7 var17 = ScheduledMovementComponent.y(var14).g;
               if (var17 != null) {
                  var6 = w(var17, var16.g, var16.d, 0.05F, 0.2F, 0.1F);
                  ScheduledMovementComponent.v(var14, var6);
               }
            }
         }

      }
   }
}
