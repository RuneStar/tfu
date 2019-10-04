/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script;

import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptID;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

class ScriptManager$MethodSignature {
    final Method method;
    final Class[] nonGenericParameterTypes;
    final ScriptDefaults[] parameterDefaults;
    final boolean[] scriptIDs;

    boolean isOverrideEquivalent(ScriptManager$MethodSignature scriptManager$MethodSignature) {
        if (!this.method.getName().equals(scriptManager$MethodSignature.method.getName())) {
            return false;
        }
        return Arrays.equals(this.nonGenericParameterTypes, scriptManager$MethodSignature.nonGenericParameterTypes);
    }

    public int hashCode() {
        return this.method.getName().hashCode() * 8191 + Arrays.hashCode(this.nonGenericParameterTypes);
    }

    public boolean equals(Object object) {
        return this.isOverrideEquivalent((ScriptManager$MethodSignature)object);
    }

    boolean isEquivalentForLuaPurposes(ScriptManager$MethodSignature scriptManager$MethodSignature) {
        if (!Arrays.equals(this.parameterDefaults, scriptManager$MethodSignature.parameterDefaults)) {
            return false;
        }
        if (!Arrays.equals(this.scriptIDs, scriptManager$MethodSignature.scriptIDs)) {
            return false;
        }
        return this.method.isVarArgs() == scriptManager$MethodSignature.method.isVarArgs();
    }

    ScriptManager$MethodSignature(Method method) {
        this.method = method;
        this.nonGenericParameterTypes = this.method.getParameterTypes();
        this.parameterDefaults = new ScriptDefaults[this.nonGenericParameterTypes.length];
        this.scriptIDs = new boolean[this.nonGenericParameterTypes.length];
        Annotation[][] arrannotation = this.method.getParameterAnnotations();
        for (int i = 0; i < arrannotation.length; ++i) {
            for (Annotation annotation : arrannotation[i]) {
                if (annotation.annotationType() == ScriptDefaults.class) {
                    this.parameterDefaults[i] = (ScriptDefaults)annotation;
                }
                if (annotation.annotationType() != ScriptID.class) continue;
                this.scriptIDs[i] = true;
            }
        }
    }
}

