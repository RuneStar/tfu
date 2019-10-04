// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.lang.reflect.Method;
import com.jagex.jnibindings.runetek6.NativeScriptAPIInfo;
import com.jagex.jnibindings.runetek6.NativeScriptDefaults;
import com.jagex.jnibindings.runetek6.Scripting;
import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.List;
import java.util.Map;

class ScriptManager$NativeMethodInfoBuilder
{
    Map overrideCheckMap;
    List scriptEntryPointMethods;
    Set visitedMethods;
    
    private static void warnIfSubMethodNotExplicitlyExposed(final ScriptManager$MethodSignature scriptManager$MethodSignature, final ScriptManager$MethodSignature scriptManager$MethodSignature2) {
        final Class<?> declaringClass = scriptManager$MethodSignature.method.getDeclaringClass();
        final Class<?> declaringClass2 = scriptManager$MethodSignature2.method.getDeclaringClass();
        if (declaringClass != declaringClass2 && declaringClass.isAssignableFrom(declaringClass2) && scriptManager$MethodSignature.method.isAnnotationPresent(ScriptEntryPoint.class) && !scriptManager$MethodSignature2.method.isAnnotationPresent(ScriptEntryPoint.class)) {
            ScriptManager.logger.error("", new IllegalStateException("Method \"" + scriptManager$MethodSignature2.method + "\" should be explicitly marked @" + ScriptEntryPoint.class.getSimpleName() + " since it overrides method \"@" + ScriptEntryPoint.class.getSimpleName() + " " + scriptManager$MethodSignature.method + "\""));
        }
    }
    
    void scan(final Class clazz) {
        for (final Method obj : clazz.getDeclaredMethods()) {
            Label_0604: {
                if (!this.visitedMethods.contains(obj)) {
                    this.visitedMethods.add(obj);
                    if (!obj.isBridge()) {
                        final ScriptManager$MethodSignature scriptManager$MethodSignature = new ScriptManager$MethodSignature(obj);
                        final ScriptManager$MethodSignature scriptManager$MethodSignature2 = this.overrideCheckMap.get(scriptManager$MethodSignature);
                        if (scriptManager$MethodSignature2 == null) {
                            this.overrideCheckMap.put(scriptManager$MethodSignature, scriptManager$MethodSignature);
                        }
                        else if (obj.isAnnotationPresent(ScriptEntryPoint.class) && scriptManager$MethodSignature2.method.isAnnotationPresent(ScriptEntryPoint.class)) {
                            if (!scriptManager$MethodSignature.isEquivalentForLuaPurposes(scriptManager$MethodSignature2)) {
                                ScriptManager.logger.error("", new IllegalStateException("Overriding methods \"" + obj + "\" and \"" + scriptManager$MethodSignature2.method + "\" have different ScriptDefaults, ScriptID or varargsness!"));
                            }
                            break Label_0604;
                        }
                        else {
                            warnIfSubMethodNotExplicitlyExposed(scriptManager$MethodSignature, scriptManager$MethodSignature2);
                            warnIfSubMethodNotExplicitlyExposed(scriptManager$MethodSignature2, scriptManager$MethodSignature);
                        }
                        if (obj.getAnnotation(ScriptEntryPoint.class) != null) {
                            final String[] array = new String[scriptManager$MethodSignature.nonGenericParameterTypes.length];
                            if (scriptManager$MethodSignature.nonGenericParameterTypes.length > 0) {
                                for (int j = 0; j < scriptManager$MethodSignature.nonGenericParameterTypes.length; ++j) {
                                    final String h = Scripting.h(scriptManager$MethodSignature.nonGenericParameterTypes[j].getName());
                                    if (h == null || h.length() <= 0) {
                                        throw new RuntimeException(String.format("Could not build type signature for parameter '%s'.", scriptManager$MethodSignature.nonGenericParameterTypes[j].toString()));
                                    }
                                    array[j] = h;
                                }
                            }
                            final String h2 = Scripting.h(obj.getReturnType().getName());
                            if (h2 == null || h2.length() <= 0) {
                                throw new RuntimeException(String.format("Could not build type signature for return type '%s'.", obj.getReturnType().toString()));
                            }
                            NativeScriptDefaults[] array2 = null;
                            if (scriptManager$MethodSignature.parameterDefaults != null) {
                                array2 = new NativeScriptDefaults[scriptManager$MethodSignature.parameterDefaults.length];
                                for (int k = 0; k < scriptManager$MethodSignature.parameterDefaults.length; ++k) {
                                    if (scriptManager$MethodSignature.parameterDefaults[k] != null) {
                                        array2[k] = new NativeScriptDefaults(scriptManager$MethodSignature.parameterDefaults[k].defaultInteger(), scriptManager$MethodSignature.parameterDefaults[k].defaultLightUserData(), scriptManager$MethodSignature.parameterDefaults[k].defaultNumber(), scriptManager$MethodSignature.parameterDefaults[k].defaultString(), scriptManager$MethodSignature.parameterDefaults[k].defaultBoolean());
                                    }
                                }
                            }
                            this.scriptEntryPointMethods.add(new NativeScriptAPIInfo(obj.getDeclaringClass().getName().replace('.', '/'), obj.getName(), array, h2, array2, scriptManager$MethodSignature.scriptIDs, (obj.getModifiers() & 0x8) != 0x0, obj.isVarArgs()));
                        }
                    }
                }
            }
        }
        final Class superclass = clazz.getSuperclass();
        if (superclass != null) {
            this.scan(superclass);
        }
        final Class[] interfaces = clazz.getInterfaces();
        for (int length2 = interfaces.length, l = 0; l < length2; ++l) {
            this.scan(interfaces[l]);
        }
    }
    
    ScriptManager$NativeMethodInfoBuilder() {
        this.scriptEntryPointMethods = new ArrayList();
        this.visitedMethods = new HashSet();
        this.overrideCheckMap = new HashMap();
    }
}
