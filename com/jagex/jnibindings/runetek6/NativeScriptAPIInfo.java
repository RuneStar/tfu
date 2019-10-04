/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.NativeScriptDefaults;
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
        StringBuilder stringBuilder = new StringBuilder();
        if (this.isStatic) {
            stringBuilder.append("static ");
        }
        if (this.isVarArgs) {
            stringBuilder.append("varargs ");
        }
        stringBuilder.append(this.methodName + "(");
        boolean bl = true;
        for (String string : this.parameterTypeSigs) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string);
        }
        stringBuilder.append(") " + this.returnTypeSig);
        return stringBuilder.toString();
    }

    @Bs1
    @Be2
    public String methodNameFirstCharTitleCase() {
        return Character.toTitleCase(this.methodName.charAt(0)) + this.methodName.substring(1);
    }

    @Bs1
    @Be2
    public NativeScriptAPIInfo(String string, String string2, String[] arrstring, String string3, NativeScriptDefaults[] arrnativeScriptDefaults, boolean[] arrbl, boolean bl, boolean bl2) {
        this.className = string;
        this.methodName = string2;
        this.parameterTypeSigs = arrstring;
        this.returnTypeSig = string3;
        this.scriptDefaults = arrnativeScriptDefaults;
        this.scriptIDs = arrbl;
        this.isStatic = bl;
        this.isVarArgs = bl2;
    }
}

