package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;

class A213 {
   public String d;
   public long g;
   // $FF: synthetic field
   final RuntimeTool q;

   public A213(RuntimeTool var1, long var2) {
      this.q = var1;
      this.g = var2;
      this.d = StateManager.getZoneId(this.g);
      RuntimeTool.o().debug("constructed new zone object - " + this.d);
   }

   public String toString() {
      return this.d;
   }
}
