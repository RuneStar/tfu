package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;

class R212 {
   public String d;
   public long g;
   // $FF: synthetic field
   final RuntimeTool q;

   public String toString() {
      return StateManager.isActive(this.g) ? this.d : this.d;
   }

   public R212(RuntimeTool var1, long var2) {
      this.q = var1;
      this.g = var2;
      this.d = StateManager.getStateId(this.g);
   }
}
