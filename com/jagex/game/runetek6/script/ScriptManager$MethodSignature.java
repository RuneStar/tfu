package com.jagex.game.runetek6.script;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

class ScriptManager$MethodSignature {
   final Method method;
   final Class[] nonGenericParameterTypes;
   final ScriptDefaults[] parameterDefaults;
   final boolean[] scriptIDs;

   boolean isOverrideEquivalent(ScriptManager$MethodSignature var1) {
      if (!this.method.getName().equals(var1.method.getName())) {
         return false;
      } else {
         return Arrays.equals(this.nonGenericParameterTypes, var1.nonGenericParameterTypes);
      }
   }

   public int hashCode() {
      return this.method.getName().hashCode() * 8191 + Arrays.hashCode(this.nonGenericParameterTypes);
   }

   public boolean equals(Object var1) {
      return this.isOverrideEquivalent((ScriptManager$MethodSignature)var1);
   }

   boolean isEquivalentForLuaPurposes(ScriptManager$MethodSignature var1) {
      if (!Arrays.equals(this.parameterDefaults, var1.parameterDefaults)) {
         return false;
      } else if (!Arrays.equals(this.scriptIDs, var1.scriptIDs)) {
         return false;
      } else {
         return this.method.isVarArgs() == var1.method.isVarArgs();
      }
   }

   ScriptManager$MethodSignature(Method var1) {
      this.method = var1;
      this.nonGenericParameterTypes = this.method.getParameterTypes();
      this.parameterDefaults = new ScriptDefaults[this.nonGenericParameterTypes.length];
      this.scriptIDs = new boolean[this.nonGenericParameterTypes.length];
      Annotation[][] var2 = this.method.getParameterAnnotations();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Annotation[] var4 = var2[var3];
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Annotation var7 = var4[var6];
            if (var7.annotationType() == ScriptDefaults.class) {
               this.parameterDefaults[var3] = (ScriptDefaults)var7;
            }

            if (var7.annotationType() == ScriptID.class) {
               this.scriptIDs[var3] = true;
            }
         }
      }

   }
}
