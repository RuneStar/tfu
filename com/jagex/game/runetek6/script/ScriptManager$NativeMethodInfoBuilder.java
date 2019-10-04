package com.jagex.game.runetek6.script;

import com.jagex.jnibindings.runetek6.NativeScriptAPIInfo;
import com.jagex.jnibindings.runetek6.NativeScriptDefaults;
import com.jagex.jnibindings.runetek6.Scripting;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ScriptManager$NativeMethodInfoBuilder {
   Map overrideCheckMap = new HashMap();
   List scriptEntryPointMethods = new ArrayList();
   Set visitedMethods = new HashSet();

   private static void warnIfSubMethodNotExplicitlyExposed(ScriptManager$MethodSignature var0, ScriptManager$MethodSignature var1) {
      Class var2 = var0.method.getDeclaringClass();
      Class var3 = var1.method.getDeclaringClass();
      if (var2 != var3 && var2.isAssignableFrom(var3) && var0.method.isAnnotationPresent(ScriptEntryPoint.class) && !var1.method.isAnnotationPresent(ScriptEntryPoint.class)) {
         ScriptManager.logger.error("", new IllegalStateException("Method \"" + var1.method + "\" should be explicitly marked @" + ScriptEntryPoint.class.getSimpleName() + " since it overrides method \"@" + ScriptEntryPoint.class.getSimpleName() + " " + var0.method + "\""));
      }

   }

   void scan(Class var1) {
      Method[] var2 = var1.getDeclaredMethods();
      Method[] var3 = var2;
      int var4 = var2.length;

      int var5;
      for(var5 = 0; var5 < var4; ++var5) {
         Method var6 = var3[var5];
         if (!this.visitedMethods.contains(var6)) {
            this.visitedMethods.add(var6);
            if (!var6.isBridge()) {
               ScriptManager$MethodSignature var7 = new ScriptManager$MethodSignature(var6);
               ScriptManager$MethodSignature var8 = (ScriptManager$MethodSignature)this.overrideCheckMap.get(var7);
               if (var8 == null) {
                  this.overrideCheckMap.put(var7, var7);
               } else {
                  if (var6.isAnnotationPresent(ScriptEntryPoint.class) && var8.method.isAnnotationPresent(ScriptEntryPoint.class)) {
                     if (!var7.isEquivalentForLuaPurposes(var8)) {
                        ScriptManager.logger.error("", new IllegalStateException("Overriding methods \"" + var6 + "\" and \"" + var8.method + "\" have different ScriptDefaults, ScriptID or varargsness!"));
                     }
                     continue;
                  }

                  warnIfSubMethodNotExplicitlyExposed(var7, var8);
                  warnIfSubMethodNotExplicitlyExposed(var8, var7);
               }

               ScriptEntryPoint var9 = (ScriptEntryPoint)var6.getAnnotation(ScriptEntryPoint.class);
               if (var9 != null) {
                  String[] var10 = new String[var7.nonGenericParameterTypes.length];
                  if (var7.nonGenericParameterTypes.length > 0) {
                     for(int var11 = 0; var11 < var7.nonGenericParameterTypes.length; ++var11) {
                        String var12 = Scripting.h(var7.nonGenericParameterTypes[var11].getName());
                        if (var12 == null || var12.length() <= 0) {
                           throw new RuntimeException(String.format("Could not build type signature for parameter '%s'.", var7.nonGenericParameterTypes[var11].toString()));
                        }

                        var10[var11] = var12;
                     }
                  }

                  String var18 = Scripting.h(var6.getReturnType().getName());
                  if (var18 == null || var18.length() <= 0) {
                     throw new RuntimeException(String.format("Could not build type signature for return type '%s'.", var6.getReturnType().toString()));
                  }

                  NativeScriptDefaults[] var19 = null;
                  if (var7.parameterDefaults != null) {
                     var19 = new NativeScriptDefaults[var7.parameterDefaults.length];

                     for(int var13 = 0; var13 < var7.parameterDefaults.length; ++var13) {
                        if (var7.parameterDefaults[var13] != null) {
                           var19[var13] = new NativeScriptDefaults(var7.parameterDefaults[var13].defaultInteger(), var7.parameterDefaults[var13].defaultLightUserData(), var7.parameterDefaults[var13].defaultNumber(), var7.parameterDefaults[var13].defaultString(), var7.parameterDefaults[var13].defaultBoolean());
                        }
                     }
                  }

                  this.scriptEntryPointMethods.add(new NativeScriptAPIInfo(var6.getDeclaringClass().getName().replace('.', '/'), var6.getName(), var10, var18, var19, var7.scriptIDs, (var6.getModifiers() & 8) != 0, var6.isVarArgs()));
               }
            }
         }
      }

      Class var14 = var1.getSuperclass();
      if (var14 != null) {
         this.scan(var14);
      }

      Class[] var15 = var1.getInterfaces();
      var5 = var15.length;

      for(int var16 = 0; var16 < var5; ++var16) {
         Class var17 = var15[var16];
         this.scan(var17);
      }

   }
}
