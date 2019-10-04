package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.I48;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;

public class RigidBody extends CollisionObject {
   private static ByteBuffer g = null;
   public final E6 d;
   private final float[] j = new float[7];
   public final float q;
   private final ByteBuffer z = ByteBuffer.allocateDirect(1024);

   private static native void nativeGetVelocities(long var0, long var2, float[] var4);

   public void r(Vector3 var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public void e(I48 var1, I48 var2) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public void h(Vector3 var1, Vector3 var2) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetVelocities(long var0, long var2, float[] var4);

   public static void s(RigidBody var0, Vector3 var1) {
      var0.h(var1, var0.w());
   }

   public Vector3 l() {
      I48 var1 = new I48();
      this.e(var1, (I48)null);
      return var1.ao();
   }

   public Vector3 w() {
      I48 var1 = new I48();
      this.e((I48)null, var1);
      return var1.ao();
   }

   private static native void nativeApplyCentralForce(long var0, long var2, float var4, float var5, float var6);

   public void v(Vector3 var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeApplyTorque(long var0, long var2, float var4, float var5, float var6);

   protected native void nativeSetTransform(long var1, long var3, float[] var5);

   public static void y(RigidBody var0) {
      var0.b.o(var0);
   }

   public static void p(RigidBody var0) {
      var0.b.a(var0);
   }

   public static boolean x(RigidBody var0) {
      return var0.b.f(var0);
   }

   public static void b(RigidBody var0, Vector3 var1) {
      var0.h(var0.l(), var1);
   }

   RigidBody(long var1, DiscreteDynamicsWorld var3, E6 var4, int var5, int var6, Object var7, float var8) {
      super(var1, var3, var4, var5, var6, var7);
      this.d = var4;
      this.q = var8;
   }
}
