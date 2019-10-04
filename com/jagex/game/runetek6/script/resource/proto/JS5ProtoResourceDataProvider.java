package com.jagex.game.runetek6.script.resource.proto;

import com.jagex.js5.js5;
import tfu.Hs30;
import tfu.Ib29;

public class JS5ProtoResourceDataProvider implements Ib29 {
   public static final boolean keepLuaAround = true;
   final js5 protoJS5;

   public JS5ProtoResourceDataProvider(js5 var1) {
      this.protoJS5 = var1;
   }

   public String getIdentifier() {
      return null;
   }

   public byte[] getData(String var1) throws Hs30 {
      byte[] var2 = js5.a(this.protoJS5, ".proto", var1 + ".proto");
      if (var2 == null) {
         throw new Hs30(String.format("File \"%s\" not found", var1));
      } else {
         return var2;
      }
   }

   public String getResourceAddress(String var1) {
      return null;
   }
}
