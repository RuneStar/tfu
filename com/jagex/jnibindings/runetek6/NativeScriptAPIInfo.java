// 
// Decompiled by Procyon v0.5.36
// 

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
public class NativeScriptAPIInfo
{
    protected final String className;
    protected final boolean isStatic;
    protected final boolean isVarArgs;
    protected final String methodName;
    protected final String[] parameterTypeSigs;
    protected final String returnTypeSig;
    protected final NativeScriptDefaults[] scriptDefaults;
    protected final boolean[] scriptIDs;
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (this.isStatic) {
            sb.append("static ");
        }
        if (this.isVarArgs) {
            sb.append("varargs ");
        }
        sb.append(this.methodName + "(");
        int n = 1;
        for (final String str : this.parameterTypeSigs) {
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(") " + this.returnTypeSig);
        return sb.toString();
    }
    
    @Bs1
    @Be2
    public String methodNameFirstCharTitleCase() {
        return Character.toTitleCase(this.methodName.charAt(0)) + this.methodName.substring(1);
    }
    
    @Bs1
    @Be2
    public NativeScriptAPIInfo(final String className, final String methodName, final String[] parameterTypeSigs, final String returnTypeSig, final NativeScriptDefaults[] scriptDefaults, final boolean[] scriptIDs, final boolean isStatic, final boolean isVarArgs) {
        this.className = className;
        this.methodName = methodName;
        this.parameterTypeSigs = parameterTypeSigs;
        this.returnTypeSig = returnTypeSig;
        this.scriptDefaults = scriptDefaults;
        this.scriptIDs = scriptIDs;
        this.isStatic = isStatic;
        this.isVarArgs = isVarArgs;
    }
}
