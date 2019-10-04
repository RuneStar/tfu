package rs2.client.lua;

import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Q344;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.F304;
import com.jagex.maths.H303;
import com.jagex.maths.Matrix4;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import rs2.client.ScriptCamera;
import rs2.client.client;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.PhysicsWorldWrapper;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gc330;
import tfu.Gn5;

@ScriptEntryClass("Client")
public class ClientScriptAPI {
   private static Q344 d = new G347();
   public static List g = new Vector();

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean addCamera(ScriptCamera var0) {
      var0.et(d);
      if (client.mm != null) {
         client.mm.add(var0);
      }

      return g.add(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GameEntity GetSelfGameEntity() {
      return Gc330.j();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GameEntity[] getEntitiesInCameraFrustum(@ScriptDefaults(defaultNumber = 0.0D) float var0, @ScriptDefaults(defaultInteger = 0) int var1, @ScriptDefaults(defaultInteger = 0) int var2, @ScriptDefaults(defaultBoolean = false) boolean var3, @ScriptDefaults(defaultInteger = 1000) int var4) {
      if (var1 == 0) {
         var1 = Gn5.PLAYER_VOLUME_QUERY.ordinal();
      }

      if (client.gz != null && client.gz.d != null) {
         Vector3[] var5 = g((Vector3[])null, var0);
         if (var5 == null) {
            return new GameEntity[0];
         } else {
            PhysicsWorldWrapper var6 = client.dc.g(var5[0]);
            Vector3 var7 = null;
            if (var3) {
               var7 = Vector3.g(0.5F * (var5[0].x + var5[3].x), 0.5F * (var5[0].y + var5[3].y), 0.5F * (var5[0].z + var5[3].z));
            }

            if (var6 == null) {
               return new GameEntity[0];
            } else {
               Vector3 var8 = Vector3.g(0.25F * (var5[0].x + var5[3].x + var5[4].x + var5[7].x), 0.25F * (var5[0].y + var5[3].y + var5[4].y + var5[7].y), 0.25F * (var5[0].z + var5[3].z + var5[4].z + var5[7].z));

               for(int var9 = 0; var9 < var5.length; ++var9) {
                  var5[var9] = Vector3.k(var5[var9], var8);
               }

               E6 var17 = var6.d.b(var5);
               ArrayList var10 = new ArrayList();
               RotTrans var11 = new RotTrans(Quaternion.g, var8);
               var6.d.al(var17, Q7.g(var11), var1, var2, var10, var4);
               var6.d.t(var17);
               int var12 = 0;
               Iterator var13 = var10.iterator();

               while(var13.hasNext()) {
                  L8 var14 = (L8)var13.next();
                  CollisionObjectData var15 = (CollisionObjectData)var6.d.ap(var14.g);
                  if (var15.d != null) {
                     ++var12;
                  }
               }

               GameEntity[] var18 = new GameEntity[0];
               if (var12 > 0) {
                  var18 = new GameEntity[var12];
                  var12 = 0;
                  Iterator var19 = var10.iterator();

                  while(var19.hasNext()) {
                     L8 var21 = (L8)var19.next();
                     CollisionObjectData var16 = (CollisionObjectData)var6.d.ap(var21.g);
                     if (var16.d != null) {
                        var18[var12++] = var16.d;
                     }
                  }

                  if (var3) {
                     D346 var20 = new D346(var7);
                     Arrays.sort(var18, var20);
                  }
               }

               return var18;
            }
         }
      } else {
         return new GameEntity[0];
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static RotTrans clientToServerTransform(RotTrans var0) {
      return var0.w((float)client.gn, 0.0F, (float)client.gj);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static RotTrans serverToClientTransform(RotTrans var0) {
      return var0.v((float)client.gn, 0.0F, (float)client.gj);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 clientToServerPos(Vector3 var0) {
      return Vector3.m(var0, (float)client.gn, 0.0F, (float)client.gj);
   }

   public static Vector3[] g(Vector3[] var0, float var1) {
      if (var0 == null) {
         var0 = new Vector3[8];
      }

      Matrix4 var2 = client.bl;
      Matrix4 var3 = var2.j();
      Vector3 var4 = Vector3.g(-1.0F, -1.0F, 0.0F);
      Vector3 var5 = Vector3.g(1.0F, 1.0F, 1.0F);
      F304 var6 = new F304();

      for(int var7 = 0; var7 < 8; ++var7) {
         var6.g = var7 / 1 % 2 == 0 ? var4.x : var5.x;
         var6.d = var7 / 2 % 2 == 0 ? var4.y : var5.y;
         var6.q = var7 / 4 % 2 == 0 ? var4.z : var5.z;
         var6.j = 1.0F;
         F304.h(var6, var3);
         var0[var7] = new Vector3(var6.g / var6.j, var6.d / var6.j, var6.q / var6.j);
      }

      if (var1 != 0.0F) {
         Vector3 var12 = Vector3.g(0.5F * (var0[0].x + var0[3].x), 0.5F * (var0[0].y + var0[3].y), 0.5F * (var0[0].z + var0[3].z));
         Vector3 var8 = Vector3.g(0.5F * (var0[4].x + var0[7].x), 0.5F * (var0[4].y + var0[7].y), 0.5F * (var0[4].z + var0[7].z));
         float var9 = Vector3.f(Vector3.k(var8, var12));
         float var10 = var1 / var9;

         for(int var11 = 0; var11 < 4; ++var11) {
            var0[4 + var11] = Vector3.av(var0[var11], var0[4 + var11], var10);
         }
      }

      return var0;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int GetBotCount() {
      return Gc330.j.size();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GameEntity GetBotEntity(int var0) {
      return (GameEntity)Gc330.j.get(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getCameraHeading() {
      ScriptCamera var1 = ScriptCamera.getActiveCamera();
      if (var1 != null) {
         Quaternion var0 = var1.getWorldTransform().rot;
         Vector3 var2 = Vector3.g(0.0F, 0.0F, 1.0F);
         var2 = Vector3.al(var2, var0);
         float var3 = (float)Math.atan2((double)var2.x, (double)var2.z);
         return var3;
      } else {
         return 0.0F;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getavh(float var0, float var1) {
      return client.bh(var0, var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3[] getPhysicsRayFromPixelSpace(float var0, float var1) {
      float var2 = var0 / (float)GameShell3.canvasWid * 2.0F - 1.0F;
      float var3 = -(var1 / (float)GameShell3.canvasHei * 2.0F - 1.0F);
      float[] var4 = new float[]{var2, var3, 0.0F};
      float[] var5 = new float[]{var2, var3, 1.0F};
      Matrix4 var6 = client.ar.j();
      float var7 = Matrix4.s(var6, var4[0], var4[1], var4[2]);
      float var8 = Matrix4.s(var6, var5[0], var5[1], var5[2]);
      Matrix4.h(var6, var4);
      Matrix4.h(var6, var5);
      var4[0] /= var7;
      var4[1] /= var7;
      var4[2] /= var7;
      var5[0] /= var8;
      var5[1] /= var8;
      var5[2] /= var8;
      H303.w(client.ax, var4);
      H303.w(client.ax, var5);
      Vector3 var9 = new Vector3(var4[0] + (float)client.gn, var4[1], var4[2] + (float)client.gj);
      Vector3 var10 = new Vector3(var5[0] + (float)client.gn, var5[1], var5[2] + (float)client.gj);
      return new Vector3[]{var9, var10};
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 serverToClientPos(Vector3 var0) {
      return Vector3.i(var0, (float)client.gn, 0.0F, (float)client.gj);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Scene getScene() {
      return client.mm;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getCameraNearPlaneCentre() {
      Vector3[] var0 = g((Vector3[])null, 0.0F);
      if (var0 != null) {
         PhysicsWorldWrapper var1 = client.dc.g(var0[0]);
         if (var1 != null) {
            Vector3 var2 = var0[0];
            Vector3 var3 = var0[3];
            Vector3 var4 = new Vector3(0.5F * (var2.x + var3.x), 0.5F * (var2.y + var3.y), 0.5F * (var2.z + var3.z));
            return var4;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean removeCamera(ScriptCamera var0, @ScriptDefaults(defaultBoolean = true) boolean var1) {
      ScriptCamera.eu(var0, d);
      if (client.mm != null) {
         client.mm.remove(var0, true, var1);
      }

      return g.remove(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void GameConNoTimout() {
      client.au();
   }

   public static final native void setNativeSelfGameEntity(long var0, long var2, GameEntity var4);
}
