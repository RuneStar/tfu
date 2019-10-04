package com.jagex.game.runetek6.script.resource.script;

import java.io.File;
import tfu.Hs30;
import tfu.Ib29;
import tfu.If31;

public class FileScriptResourceDataProvider implements Ib29 {
   final File baseDir;
   final String extension;

   public byte[] getData(String var1) throws Hs30 {
      byte[] var2 = If31.q(new File(this.baseDir, var1 + this.extension));
      if (var2 == null) {
         throw new Hs30(String.format("File \"%s\" not found", var1));
      } else {
         return var2;
      }
   }

   public String getResourceAddress(String var1) {
      return null;
   }

   public FileScriptResourceDataProvider(File var1, String var2) {
      this.baseDir = var1;
      this.extension = var2;
   }

   public String getIdentifier() {
      return null;
   }
}
