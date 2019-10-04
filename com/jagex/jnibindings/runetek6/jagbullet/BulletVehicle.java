package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BulletVehicle {
   private static ByteBuffer h = null;
   private static final Logger logger = LoggerFactory.getLogger(BulletVehicle.class);
   public float b = 0.0F;
   public final long d;
   public final RigidBody e;
   public final B45 j;
   public float l = 0.0F;
   public float p = 0.0F;
   public final DiscreteDynamicsWorld q;
   public float r = 0.1F;
   public Vector3 s = new Vector3(0.0F, 0.0F, 0.0F);
   public float[] u = null;
   public float v = 1.0F;
   public float w = 1.0F;
   public float x = 0.0F;
   public float y = 0.1F;

   public void x(float var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public static int g(BulletVehicle var0) {
      return var0.j.g;
   }

   public void d(float var1, float var2, boolean var3, float var4) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetOnWallGravityMultiplier(long var0, long var2, float var4);

   private static native void nativeControl(long var0, long var2, float var4, float var5, boolean var6, float var7);

   public Q7 j(int var1) {
      M47 var2 = new M47(this.u[12 + var1 * 21 + 12], this.u[12 + var1 * 21 + 15], this.u[12 + var1 * 21 + 18], this.u[12 + var1 * 21 + 13], this.u[12 + var1 * 21 + 16], this.u[12 + var1 * 21 + 19], this.u[12 + var1 * 21 + 14], this.u[12 + var1 * 21 + 17], this.u[12 + var1 * 21 + 20]);
      Vector3 var3 = new Vector3(this.u[12 + var1 * 21 + 0], this.u[12 + var1 * 21 + 1], this.u[12 + var1 * 21 + 2]);
      return new Q7(var2, var3);
   }

   public boolean e(int var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native boolean nativeGetWheelIsTouchingGround(long var0, long var2, int var4);

   public float h(int var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public static Vector3 l(BulletVehicle var0, int var1) {
      Q7 var2 = var0.q(var1);
      return Vector3.i(var2.g, 0.0F, var0.j.x, 0.0F);
   }

   public float s(int var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetInducedDriftEffect(long var0, long var2, float var4);

   public float b(int var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native float nativeGetWheelSlipSpeed(long var0, long var2, int var4);

   private static native float nativeGetWheelSuspensionCompression(long var0, long var2, int var4);

   public void r(Vector3 var1, Vector3 var2, Vector3 var3, Vector3 var4) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native boolean nativeGetWheelContactNormal(long var0, long var2, long var4, float[] var6);

   private static native void nativeSetOrientationCorrectionLimits(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15);

   public void v(I48 var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetOrientationCorrectionReferenceVector(long var0, long var2, float var4, float var5, float var6);

   public void y(float var1, float var2, float var3) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetCarDesiredOrientations(long var0, long var2, float var4, float var5, float var6);

   public void p(float var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetOrientationCorrectionStrengths(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12);

   public void n(float var1, float var2) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public void w(Vector3 var1, Vector3 var2, Vector3 var3) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public void u(float var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetLateralFrictionMultiplier(long var0, long var2, float var4);

   public void z(float var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public void t(float var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetFrictionDissipationReduction(long var0, long var2, float var4);

   public Vector3 m(int var1) {
      long var10000 = this.q.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native float nativeGetWheelSlipStatus(long var0, long var2, int var4);

   public Q7 q(int var1) {
      M47 var2 = new M47(this.u[12 + var1 * 21 + 3], this.u[12 + var1 * 21 + 6], this.u[12 + var1 * 21 + 9], this.u[12 + var1 * 21 + 4], this.u[12 + var1 * 21 + 7], this.u[12 + var1 * 21 + 10], this.u[12 + var1 * 21 + 5], this.u[12 + var1 * 21 + 8], this.u[12 + var1 * 21 + 11]);
      Vector3 var3 = new Vector3(this.u[12 + var1 * 21 + 0], this.u[12 + var1 * 21 + 1], this.u[12 + var1 * 21 + 2]);
      return new Q7(var2, var3);
   }

   private static native void nativeSetWheelTransformVisualModifiers(long var0, long var2, float var4, float var5);

   private static native void nativeSetInAirGravityY(long var0, long var2, float var4);

   public BulletVehicle(long var1, DiscreteDynamicsWorld var3, B45 var4, RigidBody var5) {
      this.d = var1;
      this.q = var3;
      this.j = var4;
      this.e = var5;
      this.u = new float[12 + 21 * g(this)];
   }
}
