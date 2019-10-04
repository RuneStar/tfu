package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;

class C504 implements Runnable {
   // $FF: synthetic field
   final N220 d;
   // $FF: synthetic field
   final long g;

   public void run() {
      if (this.d.j == 0) {
         boolean var1 = StateManager.callBoolCommand(this.g, this.d.e);
         this.d.s.setText(Boolean.toString(var1));
      } else if (this.d.j == 1) {
         int var2 = StateManager.callIntCommand(this.g, this.d.e);
         this.d.s.setText(Integer.toString(var2));
      } else if (this.d.j == 2) {
         float var3 = StateManager.callFloatCommand(this.g, this.d.e);
         this.d.s.setText(Float.toString(var3));
      } else if (this.d.j == 3) {
         String var4 = StateManager.callStringCommand(this.g, this.d.e);
         this.d.s.setText(var4);
      }

   }

   C504(N220 var1, long var2) {
      this.g = var2;
      this.d = var1;
   }
}
