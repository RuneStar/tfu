package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.E41;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollisionObject implements G119 {
   private static final Logger logger = LoggerFactory.getLogger(CollisionObject.class);
   private static final boolean u = true;
   public final DiscreteDynamicsWorld b;
   private boolean h = false;
   public final E6 l;
   private final ByteBuffer p = ByteBuffer.allocateDirect(1024);
   private int r;
   public final long s;
   private int v;
   public Object w;
   public int x = -1;
   protected final float[] y = new float[12];

   public void ap() {
      if (this.b.q[(int)this.s] == null) {
         if (nativeIsValid(this.s, this.b.d)) {
            logger.error("Grab Eugene if this fires.");
            throw new RuntimeException("Grab Eugene if this fires.");
         } else {
            String var1 = "!!!Outdated reference to a collision object - on native side the CO does not exist. Probably reset() of physics world has happened but java/lua references to this CO were not invalidated.";
            logger.error("!!!Outdated reference to a collision object - on native side the CO does not exist. Probably reset() of physics world has happened but java/lua references to this CO were not invalidated.");
            throw new RuntimeException("!!!Outdated reference to a collision object - on native side the CO does not exist. Probably reset() of physics world has happened but java/lua references to this CO were not invalidated.");
         }
      } else if (this.b.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      }
   }

   public Vector3 an() {
      if (this.b.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         logger.info("!!!Outdated reference to a collision object. Retruning identity position.");
         return Vector3.g;
      }
   }

   public boolean d() {
      return this.h;
   }

   public Q7 ao() {
      if (this.b.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         logger.info("!!!Outdated reference to a collision object. Returning an identity transform.");
         return Q7.q;
      }
   }

   private static native void nativeGetTransform(long var0, long var2, float[] var4);

   public M47 as() {
      if (this.b.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         logger.info("!!!Outdated reference to a collision object. Retruning identity orientation.");
         return M47.g;
      }
   }

   protected native void nativeSetTransform(long var1, long var3, float[] var5);

   public void aa(Q7 var1) {
      if (this.b.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         logger.info("!!!Outdated reference to a collision object. Doing nothing in setTransform().");
      }
   }

   private static native boolean nativeIsValid(long var0, long var2);

   public void ac(M47 var1) {
      Q7 var2 = new Q7(var1, this.an());
      this.aa(var2);
   }

   public CollisionObject(long var1, DiscreteDynamicsWorld var3, E6 var4, int var5, int var6, Object var7) {
      this.s = var1;
      this.b = var3;
      this.l = var4;
      this.r = var5;
      this.v = var6;
      this.w = var7;
   }

   private static native void nativeGetAabb(long var0, long var2, float[] var4);

   public void g() {
      synchronized(this) {
         this.h = true;
      }
   }

   public void am(Vector3 var1) {
      Q7 var2 = new Q7(this.as(), var1);
      this.aa(var2);
   }

   public E41 at() {
      if (this.b.d == 0L) {
         throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
      } else {
         logger.info("!!!Outdated reference to a collision object. Retruning random aabbox.");
         return null;
      }
   }

   public static int ab(CollisionObject var0) {
      return var0.v;
   }
}
