package com.jagex.game.runetek6.client;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemRequirementsCheck {
   private static boolean loadedDirectX = false;
   private static boolean loadedVSRuntime = false;
   private static final Logger logger = LoggerFactory.getLogger(SystemRequirementsCheck.class);

   public static boolean getLoadedDirectX() {
      return loadedDirectX;
   }

   public static boolean performCheckForDll(String var0) {
      boolean var1 = false;
      String var2 = File.separator;
      String var3 = System.getenv("windir");
      if (var3.isEmpty()) {
         logger.warn("windir environment variable is empty, using default one");
         var3 = "C:" + var2 + "Windows";
      }

      if (!var3.endsWith(var2)) {
         var3 = var3 + var2;
      }

      String[] var4 = new String[]{var3 + "System32" + var2, var3 + "SysWOW64" + var2};
      String[] var5 = var4;
      int var6 = var4.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String var8 = var5[var7];

         try {
            System.load(var8 + var0);
            var1 = true;
            break;
         } catch (UnsatisfiedLinkError var10) {
            logger.error("linkage error failed to load " + var8 + var0);
            var10.printStackTrace();
         } catch (Exception var11) {
            logger.error("exception failed to load " + var8 + var0);
            var11.printStackTrace();
         }
      }

      return var1;
   }

   public static boolean performAllChecks() {
      boolean var0 = false;
      loadedDirectX = performCheckForDll("D3DX9_43.dll");
      loadedVSRuntime = performCheckForDll("MSVCR100.dll");
      var0 = loadedDirectX && loadedVSRuntime;
      if (!var0) {
         logger.error("Depedencies are not satisfied! DirectX :" + loadedDirectX + "  VSRuntime:" + loadedVSRuntime);
         System.out.println("Depedencies are not found! DirectX :" + loadedDirectX + "  VSRuntime:" + loadedVSRuntime);
      }

      return var0;
   }
}
