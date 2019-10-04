package com.jagex.game.runetek6.script.resource.script;

import tfu.Ia63;

public class StringScriptChunk extends ScriptChunk {
   public static final Ia63 CHUNK_CONSTRUCTOR = new StringScriptChunk$1();
   public final String chunk;

   public StringScriptChunk(String var1, String var2) {
      super(var1);
      this.chunk = var2;
   }

   public void onAllRefsReleased() {
   }
}
