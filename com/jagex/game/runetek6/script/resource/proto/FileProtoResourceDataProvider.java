package com.jagex.game.runetek6.script.resource.proto;

import java.io.File;
import tfu.Gg3;
import tfu.Hs30;
import tfu.Ib29;
import tfu.If31;

public class FileProtoResourceDataProvider implements Ib29 {
   final File baseDir;

   public byte[] getData(String var1) throws Hs30 {
      byte[] var2 = If31.q(new File(this.baseDir, var1 + ".proto"));
      if (var2 == null) {
         throw new Hs30(String.format("File \"%s\" not found", var1));
      } else {
         Gg3 var3 = new Gg3(Gg3.av(var1) + 2 + var2.length);
         var3.ap(var1);
         Gg3.i(var3, 0);
         Gg3.aa(var3, var2, 0, var2.length);
         return var3.r;
      }
   }

   public FileProtoResourceDataProvider(File var1) {
      this.baseDir = var1;
   }

   public String getIdentifier() {
      return null;
   }

   public String getResourceAddress(String var1) {
      return null;
   }
}
