package com.jagex.jnibindings.runetek6;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public class NativeScriptAPIInfo {
   protected final String className;
   protected final boolean isStatic;
   protected final boolean isVarArgs;
   protected final String methodName;
   protected final String[] parameterTypeSigs;
   protected final String returnTypeSig;
   protected final NativeScriptDefaults[] scriptDefaults;
   protected final boolean[] scriptIDs;

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      if (this.isStatic) {
         var1.append("static ");
      }

      if (this.isVarArgs) {
         var1.append("varargs ");
      }

      var1.append(this.methodName + "(");
      boolean var2 = true;
      String[] var3 = this.parameterTypeSigs;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var3[var5];
         if (var2) {
            var2 = false;
         } else {
            var1.append(", ");
         }

         var1.append(var6);
      }

      var1.append(") " + this.returnTypeSig);
      return var1.toString();
   }

   @Bs1
   @Be2
   public String methodNameFirstCharTitleCase() {
      return Character.toTitleCase(this.methodName.charAt(0)) + this.methodName.substring(1);
   }

   @Bs1
   @Be2
   public NativeScriptAPIInfo(String var1, String var2, String[] var3, String var4, NativeScriptDefaults[] var5, boolean[] var6, boolean var7, boolean var8) {
      this.className = var1;
      this.methodName = var2;
      this.parameterTypeSigs = var3;
      this.returnTypeSig = var4;
      this.scriptDefaults = var5;
      this.scriptIDs = var6;
      this.isStatic = var7;
      this.isVarArgs = var8;
   }
}
