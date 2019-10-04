package com.jagex.jnibindings.runetek6;

public class Animation {
   private long g;

   public Animation() {
      this(Create());
   }

   Animation(long var1) {
      this.g = var1;
   }

   private static final native long Create();
}
