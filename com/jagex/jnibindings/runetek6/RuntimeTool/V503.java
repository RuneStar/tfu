package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;

class V503 implements Runnable {
   // $FF: synthetic field
   final long d;
   // $FF: synthetic field
   final String g;
   // $FF: synthetic field
   final N220 q;

   public void run() {
      if (this.q.j == 0) {
         if (this.g.equals("true") || this.g.equals("false")) {
            StateManager.callStateCommand(this.d, this.q.h.replace("%value%", this.g));
         }
      } else if (this.q.j == 3) {
         StateManager.callStateCommand(this.d, this.q.h.replace("%value%", "'" + this.g + "'"));
      } else if (this.q.j == 2) {
         Float var1 = new Float(this.g);
         this.q.s.setText(Float.toString(var1));
         StateManager.callStateCommand(this.d, this.q.h.replace("%value%", var1.toString()));
      } else {
         StateManager.callStateCommand(this.d, this.q.h.replace("%value%", this.g));
      }

   }

   V503(N220 var1, String var2, long var3) {
      this.g = var2;
      this.d = var3;
      this.q = var1;
   }
}
