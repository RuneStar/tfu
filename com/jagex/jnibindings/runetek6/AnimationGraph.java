package com.jagex.jnibindings.runetek6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;

public class AnimationGraph {
   private static final Logger logger = LoggerFactory.getLogger(AnimationGraph.class);
   private final Ao128 d = new Ao128("Instantiated here");
   private long q = Create();

   public static void d(AnimationGraph var0, long var1) {
      ConfigureSkinnedModel(var0.q, var1);
   }

   public static boolean g(AnimationGraph var0, String var1, Skeleton var2, long var3, int var5) {
      return ConfigureAndPopulate(var0.q, Skeleton.e(var2), var1, var3, var5);
   }

   private static final native int GetMoreEvents(long var0, int var2, long var3, int var5);

   public static int q(AnimationGraph var0, float var1, long var2, int var4) {
      return Update(var0.q, var1, var2, var4);
   }

   protected void finalize() {
      try {
         if (this.q != 0L) {
            logger.error("Native memory leak - " + this.getClass().getSimpleName() + " garbage-collected without destroy()!", this.d);
         }
      } catch (Throwable var2) {
         logger.error("", var2);
      }

   }

   public static int j(AnimationGraph var0, int var1, long var2, int var4) {
      return GetMoreEvents(var0.q, var1, var2, var4);
   }

   public static long h(AnimationGraph var0) {
      return var0.q;
   }

   private static final native long Create();

   public static void e(AnimationGraph var0) {
      if (var0.q != 0L) {
         Destroy(var0.q);
         var0.q = 0L;
      }

   }

   private static final native void Destroy(long var0);

   private static final native void ConfigureSkinnedModel(long var0, long var2);

   private static final native int Update(long var0, float var2, long var3, int var5);

   private static final native boolean ConfigureAndPopulate(long var0, long var2, String var4, long var5, int var7);
}
