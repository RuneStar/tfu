/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script;

import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.script.ScriptManager$MethodSignature;
import com.jagex.jnibindings.runetek6.NativeScriptAPIInfo;
import com.jagex.jnibindings.runetek6.NativeScriptDefaults;
import com.jagex.jnibindings.runetek6.Scripting;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;

class ScriptManager$NativeMethodInfoBuilder {
    Map overrideCheckMap;
    List scriptEntryPointMethods = new ArrayList();
    Set visitedMethods = new HashSet();

    private static void warnIfSubMethodNotExplicitlyExposed(ScriptManager$MethodSignature scriptManager$MethodSignature, ScriptManager$MethodSignature scriptManager$MethodSignature2) {
        Class<?> class_;
        Class<?> class_2 = scriptManager$MethodSignature.method.getDeclaringClass();
        if (class_2 != (class_ = scriptManager$MethodSignature2.method.getDeclaringClass()) && class_2.isAssignableFrom(class_) && scriptManager$MethodSignature.method.isAnnotationPresent(ScriptEntryPoint.class) && !scriptManager$MethodSignature2.method.isAnnotationPresent(ScriptEntryPoint.class)) {
            ScriptManager.logger.error("", new IllegalStateException("Method \"" + scriptManager$MethodSignature2.method + "\" should be explicitly marked @" + ScriptEntryPoint.class.getSimpleName() + " since it overrides method \"@" + ScriptEntryPoint.class.getSimpleName() + " " + scriptManager$MethodSignature.method + "\""));
        }
    }

    void scan(Class class_) {
        Method[] arrmethod;
        for (Method method : arrmethod = class_.getDeclaredMethods()) {
            NativeScriptDefaults[] arrnativeScriptDefaults;
            String string;
            if (this.visitedMethods.contains(method)) continue;
            this.visitedMethods.add(method);
            if (method.isBridge()) continue;
            ScriptManager$MethodSignature scriptManager$MethodSignature = new ScriptManager$MethodSignature(method);
            ScriptManager$MethodSignature scriptManager$MethodSignature2 = (ScriptManager$MethodSignature)this.overrideCheckMap.get(scriptManager$MethodSignature);
            if (scriptManager$MethodSignature2 == null) {
                this.overrideCheckMap.put(scriptManager$MethodSignature, scriptManager$MethodSignature);
            } else {
                if (method.isAnnotationPresent(ScriptEntryPoint.class) && scriptManager$MethodSignature2.method.isAnnotationPresent(ScriptEntryPoint.class)) {
                    if (scriptManager$MethodSignature.isEquivalentForLuaPurposes(scriptManager$MethodSignature2)) continue;
                    ScriptManager.logger.error("", new IllegalStateException("Overriding methods \"" + method + "\" and \"" + scriptManager$MethodSignature2.method + "\" have different ScriptDefaults, ScriptID or varargsness!"));
                    continue;
                }
                ScriptManager$NativeMethodInfoBuilder.warnIfSubMethodNotExplicitlyExposed(scriptManager$MethodSignature, scriptManager$MethodSignature2);
                ScriptManager$NativeMethodInfoBuilder.warnIfSubMethodNotExplicitlyExposed(scriptManager$MethodSignature2, scriptManager$MethodSignature);
            }
            ScriptEntryPoint scriptEntryPoint = method.getAnnotation(ScriptEntryPoint.class);
            if (scriptEntryPoint == null) continue;
            String[] arrstring = new String[scriptManager$MethodSignature.nonGenericParameterTypes.length];
            if (scriptManager$MethodSignature.nonGenericParameterTypes.length > 0) {
                for (int i = 0; i < scriptManager$MethodSignature.nonGenericParameterTypes.length; ++i) {
                    arrnativeScriptDefaults = Scripting.h(scriptManager$MethodSignature.nonGenericParameterTypes[i].getName());
                    if (arrnativeScriptDefaults == null || arrnativeScriptDefaults.length() <= 0) {
                        throw new RuntimeException(String.format("Could not build type signature for parameter '%s'.", scriptManager$MethodSignature.nonGenericParameterTypes[i].toString()));
                    }
                    arrstring[i] = arrnativeScriptDefaults;
                }
            }
            if ((string = Scripting.h(method.getReturnType().getName())) == null || string.length() <= 0) {
                throw new RuntimeException(String.format("Could not build type signature for return type '%s'.", method.getReturnType().toString()));
            }
            arrnativeScriptDefaults = null;
            if (scriptManager$MethodSignature.parameterDefaults != null) {
                arrnativeScriptDefaults = new NativeScriptDefaults[scriptManager$MethodSignature.parameterDefaults.length];
                for (int i = 0; i < scriptManager$MethodSignature.parameterDefaults.length; ++i) {
                    if (scriptManager$MethodSignature.parameterDefaults[i] == null) continue;
                    arrnativeScriptDefaults[i] = new NativeScriptDefaults(scriptManager$MethodSignature.parameterDefaults[i].defaultInteger(), scriptManager$MethodSignature.parameterDefaults[i].defaultLightUserData(), scriptManager$MethodSignature.parameterDefaults[i].defaultNumber(), scriptManager$MethodSignature.parameterDefaults[i].defaultString(), scriptManager$MethodSignature.parameterDefaults[i].defaultBoolean());
                }
            }
            this.scriptEntryPointMethods.add(new NativeScriptAPIInfo(method.getDeclaringClass().getName().replace('.', '/'), method.getName(), arrstring, string, arrnativeScriptDefaults, scriptManager$MethodSignature.scriptIDs, (method.getModifiers() & 8) != 0, method.isVarArgs()));
        }
        Class class_2 = class_.getSuperclass();
        if (class_2 != null) {
            this.scan(class_2);
        }
        for (Class<?> class_3 : class_.getInterfaces()) {
            this.scan(class_3);
        }
    }

    ScriptManager$NativeMethodInfoBuilder() {
        this.overrideCheckMap = new HashMap();
    }
}

