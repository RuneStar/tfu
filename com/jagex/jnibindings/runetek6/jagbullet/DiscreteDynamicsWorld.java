package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscreteDynamicsWorld {
   private static final Logger logger = LoggerFactory.getLogger(DiscreteDynamicsWorld.class);
   float[] a;
   public final int b;
   long d;
   public final int e;
   float[] f;
   public final int h;
   long[] i = new long[128];
   BulletVehicle[] j;
   boolean[][] k = (boolean[][])null;
   public final int l;
   final float m;
   public float n = 0.0F;
   float[] o;
   int p = 0;
   CollisionObject[] q;
   int r = 0;
   public final int s;
   Vector3 t;
   private final ByteBuffer u;
   int v = 0;
   int w = 0;
   private final ByteBuffer x;
   int y = 0;
   private final ByteBuffer z;

   public static long g(DiscreteDynamicsWorld var0) {
      return var0.d;
   }

   private static native long nativeInit(int var0, ByteBuffer var1, ByteBuffer var2, int var3, int var4, int var5, int var6, int var7, int var8);

   public static Vector3 af(DiscreteDynamicsWorld var0) {
      return var0.t;
   }

   public void d(Vector3 var1) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetGravity(long var0, float var2, float var3, float var4);

   private static native boolean getHeightfieldNormalAt(long var0, float var2, float var3, float[] var4);

   public E6 j(int var1, float var2, float var3) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native long nativeCreateSphereShape(long var0, float var2);

   public E6 e(float var1, float var2, float var3, float var4) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native long nativeCreateBoxShape(long var0, float var2, float var3, float var4, float var5);

   public static E6 h(DiscreteDynamicsWorld var0, float var1, float var2, float var3) {
      return var0.e(var1, var2, var3, 0.0F);
   }

   public void at(boolean[][] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         for(int var3 = var2; var3 < var1[0].length; ++var3) {
            this.am(var2, var3, var1[var2][var3], true);
            if (var1[var2][var3] != var1[var3][var2]) {
               throw new IllegalArgumentException("Collision table must be symmetric!");
            }
         }
      }

      this.ac();
      this.k = var1;
   }

   public boolean an(int var1, int var2) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public E6 b(Vector3[] var1) {
      if (this.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         return null;
      }
   }

   private static native long nativeCreateConvexHullShape(long var0, float[] var2, float[] var3, float[] var4);

   private static native void nativeReset(long var0);

   private static native long nativeCreateGenericMeshShape(long var0, float[] var2, float[] var3, float[] var4, int[] var5);

   public HeightfieldTerrainCollisionShape w(float[][] var1, float var2, float var3, float var4) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native long nativeCreateHeightfieldTerrainShape(long var0, float[][] var2, float var3, float var4, float var5);

   public E6 r(E6[] var1, Q7[] var2) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native long nativeCreateCompoundShape(long var0, long[] var2, float[] var3, float[] var4, float[] var5, float[] var6, float[] var7, float[] var8, float[] var9, float[] var10, float[] var11, float[] var12, float[] var13, float[] var14);

   public RigidBody v(E6 var1, Q7 var2, float var3, float var4, int var5, int var6, boolean var7, boolean var8, Object var9) {
      if (this.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else if (var1 == null) {
         return null;
      } else {
         H46.q();
         if (!Float.isNaN(var2.g.x) && !Float.isInfinite(var2.g.x) && !Float.isNaN(var2.g.y) && !Float.isInfinite(var2.g.y) && !Float.isNaN(var2.g.z) && !Float.isInfinite(var2.g.z) && !Float.isNaN(var2.d.f00) && !Float.isInfinite(var2.d.f00) && !Float.isNaN(var2.d.f01) && !Float.isInfinite(var2.d.f01) && !Float.isNaN(var2.d.f02) && !Float.isInfinite(var2.d.f02) && !Float.isNaN(var2.d.f10) && !Float.isInfinite(var2.d.f10) && !Float.isNaN(var2.d.f11) && !Float.isInfinite(var2.d.f11) && !Float.isNaN(var2.d.f12) && !Float.isInfinite(var2.d.f12) && !Float.isNaN(var2.d.f20) && !Float.isInfinite(var2.d.f20) && !Float.isNaN(var2.d.f21) && !Float.isInfinite(var2.d.f21) && !Float.isNaN(var2.d.f22) && !Float.isInfinite(var2.d.f22)) {
            assert this.r < this.h;

            RigidBody var10;
            if (this.r < this.h) {
               long var11 = nativeCreateStaticRigidBody(this.d, var1.g, var2.g.x, var2.g.y, var2.g.z, var2.d.f00, var2.d.f10, var2.d.f20, var2.d.f01, var2.d.f11, var2.d.f21, var2.d.f02, var2.d.f12, var2.d.f22, var3, var4, var5, var6, var7, var8);
               var10 = new RigidBody(var11, this, var1, var5, var6, var9, 0.0F);

               assert var11 < (long)(this.s + this.b + this.h);

               assert this.q[(int)var11] == null;

               this.q[(int)var11] = var10;
               ++this.r;
            } else {
               var10 = null;
            }

            H46.j();
            return var10;
         } else {
            throw new IllegalArgumentException("Bad numbers fed to createStaticRigidBody()");
         }
      }
   }

   private static native long nativeCreateCapsuleShape(long var0, int var2, float var3, float var4);

   public RigidBody y(float var1, E6 var2, Q7 var3, float var4, float var5, int var6, int var7, boolean var8, boolean var9, Object var10) {
      Vector3 var11 = new Vector3(1.0F, 1.0F, 1.0F);
      Vector3 var12 = new Vector3(0.0F, 0.0F, 0.0F);
      float var13 = 1.0F;
      float var14 = 1.0F;
      float var15 = 1.0F;
      float var16 = 1.0F;
      return this.p(var1, var2, var3, var11, var4, var5, var6, var7, var8, var9, var10, var12, var13, var14, var15, var16);
   }

   public RigidBody p(float var1, E6 var2, Q7 var3, Vector3 var4, float var5, float var6, int var7, int var8, boolean var9, boolean var10, Object var11, Vector3 var12, float var13, float var14, float var15, float var16) {
      if (this.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else if (var2 == null) {
         return null;
      } else {
         H46.q();

         assert this.r < this.h;

         RigidBody var17 = null;
         if (this.r < this.h) {
            long var18 = nativeCreateDynamicRigidBody(this.d, var1, var2.g, var3.g.x, var3.g.y, var3.g.z, var3.d.f00, var3.d.f10, var3.d.f20, var3.d.f01, var3.d.f11, var3.d.f21, var3.d.f02, var3.d.f12, var3.d.f22, var4.x, var4.y, var4.z, var5, var6, var7, var8, var9, var10, var12.x, var12.y, var12.z, var13, var14, var15, var16);
            var17 = new RigidBody(var18, this, var2, var7, var8, var11, var1);

            assert var18 < (long)(this.s + this.b + this.h);

            assert this.q[(int)var18] == null;

            this.q[(int)var18] = var17;
            ++this.r;
         }

         H46.j();
         return var17;
      }
   }

   public List al(E6 var1, Q7 var2, int var3, int var4, List var5, int var6) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public CameraController x(E6 var1, Q7 var2, boolean var3, int var4, int var5, Object var6) {
      if (this.d != 0L) {
         long var10000 = var1.g;
         long var10001 = 0L;
      }

      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native long nativeCreateCameraController(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, int var16, int var17, boolean var18);

   public CharacterController u(E6 var1, Q7 var2, float var3, boolean var4, int var5, int var6, Object var7) {
      if (this.d != 0L) {
         long var10000 = var1.g;
         long var10001 = 0L;
      }

      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native long nativeCreateCharacterController(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, int var17, int var18, boolean var19);

   public BulletVehicle z(RigidBody var1, B45 var2, int var3, int var4) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public DiscreteDynamicsWorld(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      this.o = new float[this.i.length * 3];
      this.a = new float[this.i.length * 3];
      this.f = new float[this.i.length];
      H46.q();
      this.x = ByteBuffer.allocateDirect(var6 * 4 * 96);
      this.x.order(ByteOrder.LITTLE_ENDIAN);
      this.u = ByteBuffer.allocateDirect(4 + 8 * var7);
      this.u.order(ByteOrder.LITTLE_ENDIAN);
      this.z = ByteBuffer.allocateDirect(24576);
      this.z.order(ByteOrder.LITTLE_ENDIAN);
      this.e = var2;
      this.h = var3;
      this.s = var4;
      this.b = var5;
      this.l = var6;
      this.m = var8;
      this.q = new CollisionObject[var3 + var5 + var4];
      this.j = new BulletVehicle[var6];
      this.d = nativeInit(var1, this.x, this.u, var2, var3, var4, var5, var6, var7);
      logger.debug("DiscreteDynamicsWorld created. TimeStep {} s.", var8);
      H46.j();
   }

   public E6 s(float var1, float var2, float var3, float var4) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeDestroyCollisionShape(long var0, long var2);

   public void m(RigidBody var1) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeDestroyBody(long var0, long var2);

   public void n(CharacterController var1) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeDestroyCharacterController(long var0, long var2);

   public void k(BulletVehicle var1) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeDestroyVehicle(long var0, long var2);

   public static int aj(DiscreteDynamicsWorld var0) {
      return var0.r + var0.y + var0.v;
   }

   private static native long nativeCreateCylinderSectorShape(long var0, float var2, float var3, float var4, float var5);

   public void o(RigidBody var1) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public void a(RigidBody var1) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeDisableBody(long var0, long var2);

   public boolean f(RigidBody var1) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native boolean nativeIsBodyEnabled(long var0, long var2);

   public E6 l(Vector3[] var1, int[] var2) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native boolean nativeRayIntersectsAny(long var0, float var2, float var3, float var4, float var5, float var6, float var7, int var8, int var9);

   public boolean ag(E6 var1, Q7 var2, int var3, int var4) {
      if (this.d != 0L) {
         long var10000 = var1.g;
         long var10001 = 0L;
      }

      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native boolean nativeShapeIntersectsAny(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, int var16, int var17);

   private static void aq(DiscreteDynamicsWorld var0, int var1) {
      if (var0.i.length < var1) {
         var0.i = new long[var1];
         var0.o = new float[var1 * 3];
         var0.a = new float[var1 * 3];
         var0.f = new float[var1];
      }

   }

   public ArrayList ai(Vector3 var1, Vector3 var2, int var3, int var4, boolean var5, boolean var6, ArrayList var7, int var8) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native int nativeGetRayIntersections(long var0, float var2, float var3, float var4, float var5, float var6, float var7, long[] var8, float[] var9, float[] var10, float[] var11, boolean var12, boolean var13, int var14, int var15);

   private static native int nativeGetShapeIntersections(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, long[] var16, float[] var17, float[] var18, int var19, int var20);

   public void au() {
      if (this.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         this.ar();
         logger.debug("Optimizing broadphase... ");
         H46.q();
         nativeOptimizeBroadphase(this.d, 64);
         logger.debug("                          succeded.");
         H46.j();
      }
   }

   public static float av(DiscreteDynamicsWorld var0) {
      return var0.m;
   }

   public float ao(float var1, float var2) {
      if (this.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         return getHeightfieldHeightAt(this.d, var1, var2, Float.NaN);
      }
   }

   private static native float getHeightfieldHeightAt(long var0, float var2, float var3, float var4);

   public void ar() {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native long nativeCreateDynamicRigidBody(long var0, float var2, long var3, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18, float var19, float var20, float var21, int var22, int var23, boolean var24, boolean var25, float var26, float var27, float var28, float var29, float var30, float var31, float var32);

   public void am(int var1, int var2, boolean var3, boolean var4) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public static void as(DiscreteDynamicsWorld var0, int var1, int var2, boolean var3) {
      var0.am(var1, var2, var3, false);
   }

   public void ac() {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public static native void nativeUpdateBroadphaseCache(long var0);

   protected void finalize() {
      if (this.d != 0L) {
         logger.error("DiscreteDynamicsWorld GC'd without being destroyed properly!");
         this.ab();
      }

   }

   public void ab() {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeQuit(long var0);

   private static native int nativeDumpProfile(long var0, ByteBuffer var2, int var3);

   private static native int nativeDumpStatus(long var0, ByteBuffer var2, int var3);

   public static void ax(DiscreteDynamicsWorld var0, float var1) {
      int var2;
      for(var2 = 0; var2 < var0.j.length; ++var2) {
         BulletVehicle var3 = var0.j[var2];
         if (var3 != null) {
            var3.p(var1);
         }
      }

      for(var2 = 0; var2 < aj(var0); ++var2) {
         CollisionObject var4 = var0.q[var2];
         if (var4 instanceof CharacterController) {
            ((CharacterController)var4).z(var1);
         }
      }

   }

   private static native void nativeOptimizeBroadphase(long var0, int var2);

   private static native long nativeCreateVehicle(long var0, long var2, int var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18, float var19, float var20, float var21, float var22, float var23, float var24, boolean var25, boolean var26, boolean var27, boolean var28, boolean var29, boolean var30, float var31, float var32, float var33, float var34, int var35, int var36);

   public static native boolean nativeGroupsCollide(long var0, int var2, int var3);

   private static native void nativeStepSimulation(long var0, float var2);

   private static native long nativeCreateStaticRigidBody(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, int var18, int var19, boolean var20, boolean var21);

   public boolean c(Vector3 var1, Vector3 var2, int var3, int var4) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public E6 q(float var1) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeEnableBody(long var0, long var2);

   public void i() {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public Object ap(long var1) {
      assert var1 < (long)(this.s + this.b + this.h);

      return this.q[(int)var1] != null ? this.q[(int)var1].w : null;
   }

   public void aw() {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public static native void nativeSetGroupsCollide(long var0, int var2, int var3, boolean var4, boolean var5);

   public void ak(ArrayList var1) {
      long var10000 = this.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public void t(E6 var1) {
      if (this.d != 0L) {
         long var10000 = var1.g;
         long var10001 = 0L;
      }

      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public Vector3 aa(float var1, float var2) {
      if (this.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         float[] var3 = new float[3];
         return getHeightfieldNormalAt(this.d, var1, var2, var3) ? new Vector3(var3[0], var3[1], var3[2]) : null;
      }
   }
}
