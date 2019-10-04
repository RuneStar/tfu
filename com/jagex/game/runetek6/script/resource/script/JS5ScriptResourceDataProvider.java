package com.jagex.game.runetek6.script.resource.script;

import com.jagex.js5.js5;
import tfu.Gg3;
import tfu.Hs30;
import tfu.Ib29;

public class JS5ScriptResourceDataProvider implements Ib29 {
   final String extension;
   final js5 scriptJS5;

   public JS5ScriptResourceDataProvider(js5 var1, String var2) {
      this.scriptJS5 = var1;
      this.extension = var2;
   }

   public byte[] getData(String var1) throws Hs30 {
      byte[] var2 = js5.a(this.scriptJS5, this.extension, var1 + this.extension);
      if (var2 == null) {
         throw new Hs30(String.format("File \"%s\" not found", var1));
      } else {
         Gg3 var3 = new Gg3(var2);
         var3.bh();
         byte[] var4 = new byte[var2.length - var3.v];
         System.arraycopy(var2, var3.v, var4, 0, var4.length);
         return var4;
      }
   }

   public String getResourceAddress(String var1) {
      return null;
   }

   public String getIdentifier() {
      return null;
   }
}
