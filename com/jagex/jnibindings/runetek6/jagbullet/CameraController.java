package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.Vector3;

public class CameraController extends CollisionObject {
   private final E6 g;

   CameraController(long var1, E6 var3, DiscreteDynamicsWorld var4, int var5, int var6, Object var7) {
      super(var1, var4, var3, var5, var6, var7);
      this.g = var3;
   }

   private static native boolean nativeSetDesiredLocation(long var0, long var2, float var4, float var5, float var6);

   public void h(float var1) {
      long var10000 = super.b.d;
      long var10001 = 0L;
      throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
   }

   private static native boolean nativeSetCameraRadius(long var0, long var2, float var4);

   public boolean e(Vector3 var1) {
      if (super.b.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         boolean var2 = false;
         H46.q();
         this.ap();
         var2 = nativeSetDesiredLocation(super.s, super.b.d, var1.x, var1.y, var1.z);
         H46.j();
         return var2;
      }
   }
}
