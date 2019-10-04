// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.lang.reflect.Method;

class ScriptManager$MethodSignature
{
    final Method method;
    final Class[] nonGenericParameterTypes;
    final ScriptDefaults[] parameterDefaults;
    final boolean[] scriptIDs;
    
    boolean isOverrideEquivalent(final ScriptManager$MethodSignature scriptManager$MethodSignature) {
        return this.method.getName().equals(scriptManager$MethodSignature.method.getName()) && Arrays.equals(this.nonGenericParameterTypes, scriptManager$MethodSignature.nonGenericParameterTypes);
    }
    
    @Override
    public int hashCode() {
        return this.method.getName().hashCode() * 8191 + Arrays.hashCode(this.nonGenericParameterTypes);
    }
    
    @Override
    public boolean equals(final Object o) {
        return this.isOverrideEquivalent((ScriptManager$MethodSignature)o);
    }
    
    boolean isEquivalentForLuaPurposes(final ScriptManager$MethodSignature scriptManager$MethodSignature) {
        return Arrays.equals(this.parameterDefaults, scriptManager$MethodSignature.parameterDefaults) && Arrays.equals(this.scriptIDs, scriptManager$MethodSignature.scriptIDs) && this.method.isVarArgs() == scriptManager$MethodSignature.method.isVarArgs();
    }
    
    ScriptManager$MethodSignature(final Method method) {
        this.method = method;
        this.nonGenericParameterTypes = this.method.getParameterTypes();
        this.parameterDefaults = new ScriptDefaults[this.nonGenericParameterTypes.length];
        this.scriptIDs = new boolean[this.nonGenericParameterTypes.length];
        final Annotation[][] parameterAnnotations = this.method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; ++i) {
            for (final Annotation annotation : parameterAnnotations[i]) {
                if (annotation.annotationType() == ScriptDefaults.class) {
                    this.parameterDefaults[i] = (ScriptDefaults)annotation;
                }
                if (annotation.annotationType() == ScriptID.class) {
                    this.scriptIDs[i] = true;
                }
            }
        }
    }
}
