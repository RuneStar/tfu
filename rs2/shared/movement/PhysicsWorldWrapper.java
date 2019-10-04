package rs2.shared.movement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.J13;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.Q10;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gh19;
import tfu.Gj16;
import tfu.Gn5;
import tfu.It12;
import tfu.Iz11;

@ScriptEntryClass("PhysicsWorld")
public class PhysicsWorldWrapper {
   private static final Logger logger = LoggerFactory.getLogger(PhysicsWorldWrapper.class);
   public final DiscreteDynamicsWorld d;
   public Vector3 e = null;
   private Set h = Collections.emptySet();
   public Vector3 j = null;
   public final Stack q = new Stack();

   @ScriptEntryPoint
   @Be2
   @Bs1
   public PhysicsQueryResultList cylinderSectorVolumeListQuery(float var1, float var2, float var3, float var4, RotTrans var5, @ScriptDefaults(defaultInteger = 0) int var6, @ScriptDefaults(defaultInteger = 0) int var7, @ScriptDefaults(defaultInteger = 50) int var8) {
      if (var6 == 0) {
         var6 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      E6 var9 = this.d.s(var1, var2, var3, var4);
      ArrayList var10 = new ArrayList();
      this.d.al(var9, Q7.g(var5), var6, var7, var10, var8);
      this.d.t(var9);
      return new PhysicsQueryResultList(this.d, var10);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean rayIntersectsAny(Vector3 var1, Vector3 var2, @ScriptDefaults(defaultInteger = 0) int var3, @ScriptDefaults(defaultInteger = 0) int var4) {
      if (var3 == 0) {
         var3 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      return this.d.c(var1, var2, var3, var4);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean sphereVolumeQuery(Vector3 var1, float var2, @ScriptDefaults(defaultInteger = 0) int var3, @ScriptDefaults(defaultInteger = 0) int var4) {
      if (var3 == 0) {
         var3 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      E6 var5 = this.d.q(var2);
      RotTrans var6 = new RotTrans(Quaternion.g, var1);
      boolean var7 = this.d.ag(var5, Q7.g(var6), var3, var4);
      this.d.t(var5);
      return var7;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public PhysicsQueryResultList sphereVolumeListQuery(Vector3 var1, float var2, @ScriptDefaults(defaultInteger = 0) int var3, @ScriptDefaults(defaultInteger = 0) int var4, @ScriptDefaults(defaultInteger = 50) int var5) {
      if (var3 == 0) {
         var3 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      E6 var6 = this.d.q(var2);
      RotTrans var7 = new RotTrans(Quaternion.g, var1);
      ArrayList var8 = new ArrayList();
      this.d.al(var6, Q7.g(var7), var3, var4, var8, var5);
      this.d.t(var6);
      return new PhysicsQueryResultList(this.d, var8);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean boxVolumeQuery(float var1, float var2, float var3, RotTrans var4, @ScriptDefaults(defaultInteger = 0) int var5, @ScriptDefaults(defaultInteger = 0) int var6) {
      if (var5 == 0) {
         var5 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      E6 var7 = DiscreteDynamicsWorld.h(this.d, var1, var2, var3);
      boolean var8 = this.d.ag(var7, Q7.g(var4), var5, var6);
      this.d.t(var7);
      return var8;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getHeightfieldNormalAt(Vector3 var1) {
      Vector3 var2 = this.d.aa(var1.x, var1.z);
      return var2;
   }

   public static void b(PhysicsWorldWrapper var0) {
      Iterator var1 = var0.h.iterator();

      while(var1.hasNext()) {
         MappedEventComponent var2 = (MappedEventComponent)var1.next();
         MappedEventComponent.l(var2);
      }

      var0.h.clear();
      var0.d.i();
      var0.q.clear();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public PhysicsQueryResultList capsuleVolumeListQuery(float var1, float var2, RotTrans var3, @ScriptDefaults(defaultInteger = 0) int var4, @ScriptDefaults(defaultInteger = 0) int var5, @ScriptDefaults(defaultInteger = 50) int var6) {
      if (var4 == 0) {
         var4 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      E6 var7 = this.d.j(1, var1, var2);
      ArrayList var8 = new ArrayList();
      this.d.al(var7, Q7.g(var3), var4, var5, var8, var6);
      this.d.t(var7);
      return new PhysicsQueryResultList(this.d, var8);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean cylinderSectorVolumeQuery(float var1, float var2, float var3, float var4, RotTrans var5, @ScriptDefaults(defaultInteger = 0) int var6, @ScriptDefaults(defaultInteger = 0) int var7) {
      if (var6 == 0) {
         var6 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      E6 var8 = this.d.s(var1, var2, var3, var4);
      boolean var9 = this.d.ag(var8, Q7.g(var5), var6, var7);
      this.d.t(var8);
      return var9;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean capsuleVolumeQuery(float var1, float var2, RotTrans var3, @ScriptDefaults(defaultInteger = 0) int var4, @ScriptDefaults(defaultInteger = 0) int var5) {
      if (var4 == 0) {
         var4 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      E6 var6 = this.d.j(1, var1, var2);
      boolean var7 = this.d.ag(var6, Q7.g(var3), var4, var5);
      this.d.t(var6);
      return var7;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public PhysicsQueryResultList raycast(Vector3 var1, Vector3 var2, @ScriptDefaults(defaultInteger = 0) int var3, @ScriptDefaults(defaultInteger = 0) int var4, @ScriptDefaults(defaultBoolean = false) boolean var5, @ScriptDefaults(defaultBoolean = true) boolean var6) {
      if (var3 == 0) {
         var3 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      this.j = var1;
      this.e = var2;
      ArrayList var7 = new ArrayList();
      this.d.ai(var1, var2, var3, var4, var5, var6, var7, 1000);
      return new PhysicsQueryResultList(this.d, var7);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GameEntity[] getEntitiesInCuboid(Vector3 var1, Vector3 var2, @ScriptDefaults(defaultInteger = 0) int var3, @ScriptDefaults(defaultInteger = 0) int var4, @ScriptDefaults(defaultInteger = 1000) int var5) {
      if (var3 == 0) {
         var3 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      GameEntity[] var6 = null;
      E6 var7 = DiscreteDynamicsWorld.h(this.d, var2.x, var2.y, var2.z);
      ArrayList var8 = new ArrayList();
      RotTrans var9 = new RotTrans(Quaternion.g, var1);
      this.d.al(var7, Q7.g(var9), var3, var4, var8, var5);
      this.d.t(var7);
      int var10 = 0;
      Iterator var11 = var8.iterator();

      L8 var12;
      CollisionObjectData var13;
      while(var11.hasNext()) {
         var12 = (L8)var11.next();
         var13 = (CollisionObjectData)this.d.ap(var12.g);
         if (var13.d != null) {
            ++var10;
         }
      }

      if (var10 > 0) {
         var6 = new GameEntity[var10];
         var10 = 0;
         var11 = var8.iterator();

         while(var11.hasNext()) {
            var12 = (L8)var11.next();
            var13 = (CollisionObjectData)this.d.ap(var12.g);
            if (var13.d != null) {
               var6[var10++] = var13.d;
            }
         }

         L9 var14 = new L9(this, var1);
         Arrays.sort(var6, var14);
      } else {
         var6 = new GameEntity[0];
      }

      return var6;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GameEntity[] getEntitiesInSphere(Vector3 var1, float var2, @ScriptDefaults(defaultInteger = 0) int var3, @ScriptDefaults(defaultInteger = 0) int var4, @ScriptDefaults(defaultInteger = 1000) int var5) {
      if (var3 == 0) {
         var3 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      GameEntity[] var6 = null;
      E6 var7 = this.d.q(var2);
      ArrayList var8 = new ArrayList();
      RotTrans var9 = new RotTrans(Quaternion.g, var1);
      this.d.al(var7, Q7.g(var9), var3, var4, var8, var5);
      this.d.t(var7);
      int var10 = 0;
      Iterator var11 = var8.iterator();

      L8 var12;
      CollisionObjectData var13;
      while(var11.hasNext()) {
         var12 = (L8)var11.next();
         var13 = (CollisionObjectData)this.d.ap(var12.g);
         if (var13.d != null) {
            ++var10;
         }
      }

      if (var10 > 0) {
         var6 = new GameEntity[var10];
         var10 = 0;
         var11 = var8.iterator();

         while(var11.hasNext()) {
            var12 = (L8)var11.next();
            var13 = (CollisionObjectData)this.d.ap(var12.g);
            if (var13.d != null) {
               var6[var10++] = var13.d;
            }
         }

         L9 var14 = new L9(this, var1);
         Arrays.sort(var6, var14);
      } else {
         var6 = new GameEntity[0];
      }

      return var6;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getHeightfieldHeightAt(Vector3 var1) {
      float var2 = this.d.ao(var1.x, var1.z);
      if (var2 == Float.NaN) {
         return null;
      } else {
         Vector3 var3 = new Vector3(var1.x, var2, var1.z);
         return var3;
      }
   }

   public static E6 s(PhysicsWorldWrapper var0, Q10 var1, float var2, float var3) {
      float var4 = 2.0F;
      float var5 = var4 * 2.0F;
      if (var1 != null) {
         float var6 = var1.g.f00;
         float var7 = var1.g.f10;
         float var8 = var1.g.f20;
         float var9 = var1.g.f01;
         float var10 = var1.g.f11;
         float var11 = var1.g.f21;
         float var12 = var1.g.f02;
         float var13 = var1.g.f12;
         float var14 = var1.g.f22;
         float var15 = var6 * var6 + var12 * var12;
         float var16 = var7 * var7 + var13 * var13;
         float var17 = var8 * var8 + var14 * var14;
         var4 = (float)Math.sqrt((double)(var15 + var16 + var17));
         var5 = (float)Math.sqrt((double)(var9 * var9 + var10 * var10 + var11 * var11)) * 2.0F;
      }

      if (var2 > 0.0F) {
         var4 = var2;
      }

      if (var3 > 0.0F) {
         var5 = var3;
      }

      if (var5 < var4 * 2.0F) {
         var4 = var5 / 2.0F;
      }

      return var0.d.j(1, var4, var5 - var4 * 2.0F);
   }

   public RigidBody g(Iz11 var1, RotTrans var2, float var3, int var4, int var5, float var6, float var7, boolean var8, boolean var9, CollisionObjectData var10) {
      if (var1.q.length < 1) {
         return null;
      } else if (var1.q.length == 1) {
         RotTrans var14 = new RotTrans(var1.j[0].rot, Vector3.ai(var1.j[0].trans, var3));
         RotTrans var12 = var14.e(var2);
         E6 var13 = q(this, var1.q[0], var3);
         return this.d.v(var13, Q7.g(var12), var6, var7, var4, var5, var8, var9, var10);
      } else {
         E6 var11 = d(this, var1, var3);
         return this.d.v(var11, Q7.g(var2), var6, var7, var4, var5, var8, var9, var10);
      }
   }

   public static E6 d(PhysicsWorldWrapper var0, Iz11 var1, float var2) {
      E6[] var3 = new E6[var1.q.length];
      Q7[] var4 = new Q7[var1.q.length];

      for(int var5 = 0; var5 < var1.q.length; ++var5) {
         var3[var5] = q(var0, var1.q[var5], var2);
         var4[var5] = Q7.g(var1.j[var5].y(var2));
      }

      return var0.d.r(var3, var4);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean getGroupsCollide(int var1, int var2) {
      return this.d.an(var1, var2);
   }

   public void j(ArrayList var1) {
      HashSet var2 = new HashSet();
      Iterator var3 = var1.iterator();

      while(true) {
         GameEntity var6;
         MappedEventComponent var7;
         MappedEventComponent var8;
         do {
            while(true) {
               GameEntity var5;
               do {
                  do {
                     if (!var3.hasNext()) {
                        var3 = this.h.iterator();

                        while(var3.hasNext()) {
                           MappedEventComponent var9 = (MappedEventComponent)var3.next();
                           MappedEventComponent.l(var9);
                        }

                        this.h = var2;
                        return;
                     }

                     J13 var4 = (J13)var3.next();
                     var5 = ((CollisionObjectData)var4.g.w).d;
                     var6 = ((CollisionObjectData)var4.d.w).d;
                  } while(var5 == null);
               } while(var6 == null);

               var7 = (MappedEventComponent)GameEntity.eb(var5, MappedEventComponent.class);
               var8 = (MappedEventComponent)GameEntity.eb(var6, MappedEventComponent.class);
               if (var7 != null && MappedEventComponent.e(var7)) {
                  break;
               }

               if (var8 != null && MappedEventComponent.e(var8)) {
                  var8.b(var5);
                  var2.add(var8);
               } else {
                  if (var7 != null) {
                     MappedEventComponent.g(var7, var6);
                  }

                  if (var8 != null) {
                     MappedEventComponent.g(var8, var5);
                  }
               }
            }
         } while(var8 != null && MappedEventComponent.e(var8));

         var7.b(var6);
         var2.add(var7);
      }
   }

   public void e(W14 var1, float var2, float var3) {
      if (var1 != null) {
         CollisionObjectData var4 = new CollisionObjectData(S15.GROUND);
         D18 var5 = V17.g(this.d, var1, var2, var3, 0.2F, 0.0F, Gn5.HEIGHTFIELD.ordinal(), Gj16.NONE.az, var4);
         this.q.add(var5);
      }

   }

   public RigidBody h(GameEntity var1, float var2, float var3, Integer var4) {
      Iz11 var5 = var1.cj;
      if (var5 == null) {
         Q10 var6 = GameEntity.k(var1);
         if (var6 != null) {
            var5 = Iz11.d(var6);
            var1.z = false;
         } else {
            var1.z = true;
         }
      }

      if (var5 != null) {
         ScaleRotTrans var16 = var1.getWorldTransform();
         RotTrans var7 = var16.q();
         var7 = var7.w(var2, 0.0F, var3);
         CollisionObjectData var8 = new CollisionObjectData(S15.SCENERY);
         var8.d = var1;
         boolean var9 = false;
         boolean var10 = true;
         MappedEventComponent var11 = (MappedEventComponent)GameEntity.eb(var1, MappedEventComponent.class);
         if (var11 != null) {
            var9 = MappedEventComponent.q(var11);
            var10 = MappedEventComponent.j(var11);
         }

         int var12;
         if (var9 && !var10) {
            var12 = Gn5.TRIGGER_VOLUME.ordinal();
         } else {
            var12 = Gn5.SCENERY.ordinal();
         }

         int var13 = Gj16.NONE.az;
         if (var4 == null) {
            var13 = GameEntity.ev(var1, "CollisionMask", Gj16.NONE.az);
            if (var13 != Gj16.NONE.az) {
               var13 <<= 2;

               try {
                  Gj16.g(var13);
               } catch (IllegalArgumentException var15) {
                  logger.warn("A CollisionMask was specified as an entity propery but was invalid - set to CollisionMask.NONE.mask (0).\n{}\n(Specified mask was: '{}'.)", var15.getMessage(), var13);
                  var13 = Gj16.NONE.az;
               }
            }
         } else {
            var13 = var4;
         }

         var1.u = var10;
         RigidBody var14 = this.g(var5, var7, var16.scale, var12, var13, Gh19.y, Gh19.x, var9, var10, var8);
         return var14;
      } else {
         return null;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setGroupsCollide(int var1, int var2, boolean var3) {
      DiscreteDynamicsWorld.as(this.d, var1, var2, var3);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GameEntity[] getEntitiesInSwingArea(Vector3 var1, float var2, float var3, float var4, float var5, @ScriptDefaults(defaultNumber = 0.0D) float var6, @ScriptDefaults(defaultInteger = 0) int var7, @ScriptDefaults(defaultInteger = 0) int var8, @ScriptDefaults(defaultInteger = 1000) int var9) {
      if (var1 == null) {
         return null;
      } else {
         if (var7 == 0) {
            var7 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
         }

         GameEntity[] var10 = null;

         float var11;
         for(var11 = 1.5707964F - var4; var11 >= 6.2831855F; var11 -= 6.2831855F) {
         }

         while(var11 <= 0.0F) {
            var11 += 6.2831855F;
         }

         if (var5 < 0.0F) {
            var5 = 1.0E-4F;
         }

         if (var5 >= 6.2831855F) {
            var5 = 6.2830853F;
         }

         float var12 = var11 - var5 / 2.0F;
         float var13 = var11 + var5 / 2.0F;
         if (var12 < 0.0F) {
            var12 = (float)((double)var12 + 6.283185307179586D);
            var13 = (float)((double)var13 + 6.283185307179586D);
         }

         E6 var14 = this.d.s(var2, var3, var12, var13);
         ArrayList var15 = new ArrayList();
         Vector3 var16 = Vector3.g((float)Math.cos((double)var4), 0.0F, -((float)Math.sin((double)var4)));
         RotTrans var17 = new RotTrans(Quaternion.j(var16, var6), var1);
         this.d.al(var14, Q7.g(var17), var7, var8, var15, var9);
         this.d.t(var14);
         int var18 = 0;
         Iterator var19 = var15.iterator();

         while(var19.hasNext()) {
            L8 var20 = (L8)var19.next();
            CollisionObjectData var21 = (CollisionObjectData)this.d.ap(var20.g);
            if (var21.d != null) {
               ++var18;
            }
         }

         if (var18 > 0) {
            var10 = new GameEntity[var18];
            var18 = 0;
            int var24 = 0;
            Iterator var25 = var15.iterator();

            while(var25.hasNext()) {
               L8 var23 = (L8)var25.next();
               CollisionObjectData var22 = (CollisionObjectData)this.d.ap(var23.g);
               if (var22.d != null) {
                  ++var24;
                  var10[var18++] = var22.d;
               }
            }

            if (var24 == 0) {
               var10 = null;
            }

            L9 var26 = new L9(this, var1);
            Arrays.sort(var10, var26);
         } else {
            var10 = null;
         }

         return var10;
      }
   }

   public static void l(PhysicsWorldWrapper var0) {
      var0.d.i();
      var0.d.ab();
   }

   public PhysicsWorldWrapper(DiscreteDynamicsWorld var1) {
      this.d = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public PhysicsQueryResultList boxVolumeListQuery(float var1, float var2, float var3, RotTrans var4, @ScriptDefaults(defaultInteger = 0) int var5, @ScriptDefaults(defaultInteger = 0) int var6, @ScriptDefaults(defaultInteger = 50) int var7) {
      if (var5 == 0) {
         var5 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      E6 var8 = DiscreteDynamicsWorld.h(this.d, var1, var2, var3);
      ArrayList var9 = new ArrayList();
      this.d.al(var8, Q7.g(var4), var5, var6, var9, var7);
      this.d.t(var8);
      return new PhysicsQueryResultList(this.d, var9);
   }

   public static E6 q(PhysicsWorldWrapper var0, It12 var1, float var2) {
      // $FF: Couldn't be decompiled
   }
}
