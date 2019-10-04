package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharacterController extends CollisionObject {
   private static final ByteBuffer j;
   private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);
   public static final int q = nativeGetRequiredDynamicStatePacketSize();
   private final E6 d;

   public void b(float var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   CharacterController(long var1, E6 var3, DiscreteDynamicsWorld var4, int var5, int var6, Object var7) {
      super(var1, var4, var3, var5, var6, var7);
      this.d = var3;
   }

   public Vector3 h() {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public void l(float var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetMaxWalkSlope(long var0, long var2, float var4);

   private static native void nativeSetMaxJumpSlope(long var0, long var2, float var4);

   public void r(float var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetMinSlideSlope(long var0, long var2, float var4);

   public void w(boolean var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetCanBePushedByCc(long var0, long var2, boolean var4);

   public void s(float var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeJump(long var0, long var2, float var4, float var5);

   private static native void nativeGetWalkPerFrame(long var0, long var2, float[] var4);

   private static native void nativeSetVerticalVelocity(long var0, long var2, float var4);

   public float y() {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native float nativeGetVerticalVelocity(long var0, long var2);

   private static native int nativeGetRequiredDynamicStatePacketSize();

   public boolean p() {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native boolean nativeIsTouchingGround(long var0, long var2);

   public boolean x() {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public boolean u(D194 var1, float var2) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native boolean nativeGetLandingPredicition(long var0, long var2, float[] var4, float var5, float var6, int var7);

   public void z(float var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetYGravity(long var0, long var2, float var4);

   static {
      j = ByteBuffer.allocateDirect(q);
   }

   public void e(Vector3 var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   public void v(float var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native void nativeSetWalkPerFrame(long var0, long var2, float var4, float var5, float var6);
}
