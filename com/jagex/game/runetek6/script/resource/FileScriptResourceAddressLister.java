package com.jagex.game.runetek6.script.resource;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ij60;

public class FileScriptResourceAddressLister implements Ij60 {
   protected static final Logger logger = LoggerFactory.getLogger(FileScriptResourceAddressLister.class);
   final File baseDir;
   final String extension;

   public List getAddresses() {
      LinkedList var1 = new LinkedList();
      this.getAddresses(this.baseDir, (List)null, var1);
      logger.debug("Done adding scripts.");
      return var1;
   }

   private void getAddresses(File var1, List var2, List var3) {
      File[] var4 = var1.listFiles();
      File[] var5 = var4;
      int var6 = var4.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         File var8 = var5[var7];
         if (var2 == null || var2.contains(var8)) {
            if (var8.isFile()) {
               if (var8.getName().endsWith(this.extension)) {
                  String var9 = var8.getPath().substring(this.baseDir.getPath().length() + 1);
                  var9 = var9.replace('\\', '/');
                  var9 = var9.substring(0, var9.lastIndexOf(46));
                  logger.debug("Adding Lua chunk \"{}\".", var9);
                  var3.add(var9);
               }
            } else if (var8.isDirectory() && !var8.getName().equals("modules")) {
               this.getAddresses(var8, var2, var3);
            }
         }
      }

   }

   public FileScriptResourceAddressLister(File var1, String var2) {
      this.baseDir = var1;
      this.extension = var2;
   }
}
