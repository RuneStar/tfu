package com.jagex.game.runetek6.script;

class ScriptManager$NativeRef {
   private final long ref;
   // $FF: synthetic field
   final ScriptManager this$0;

   public long getRef() {
      if (this.ref == 0L) {
         throw new IllegalStateException("Native reference was invalid.");
      } else {
         return this.ref;
      }
   }

   ScriptManager$NativeRef(ScriptManager var1, long var2) {
      this.this$0 = var1;
      this.ref = var2;
   }
}
