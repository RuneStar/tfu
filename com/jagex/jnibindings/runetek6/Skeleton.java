package com.jagex.jnibindings.runetek6;

import tfu.Hi86;
import tfu.Ia63;

public class Skeleton implements D91 {
   public static final Ia63 d = new J372();
   public Hi86 g;
   private long q;

   private static final native int LoadFromIntermediate(long var0, byte[] var2, float var3);

   private static final native int GetBoneIndex(long var0, String var2);

   public int g() {
      assert this.q != 0L;

      return GetBoneCount(this.q);
   }

   public Skeleton(Hi86 var1) {
      this(Create());
      this.g = var1;
   }

   public static int q(Skeleton var0, byte[] var1, float var2) {
      return LoadFromIntermediate(var0.q, var1, var2);
   }

   public static void j(Skeleton var0) {
      Destroy(var0.q);
      var0.q = 0L;
   }

   public void onAllRefsReleased() {
      j(this);
   }

   Skeleton(long var1) {
      this.q = var1;
   }

   static long e(Skeleton var0) {
      return var0.q;
   }

   private static final native void Destroy(long var0);

   private static final native int GetBoneCount(long var0);

   private static final native long Create();

   public Skeleton() {
      this((Hi86)null);
   }

   public int d(String var1) {
      assert this.q != 0L;

      return GetBoneIndex(this.q, var1);
   }
}
