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
public class NativeScriptDefaults
{
    protected final boolean defaultBoolean;
    protected final int defaultInteger;
    protected final int defaultLightUserData;
    protected final double defaultNumber;
    protected final String defaultString;
    
    @Bs1
    @Be2
    public NativeScriptDefaults(final int defaultInteger, final int defaultLightUserData, final double defaultNumber, final String defaultString, final boolean defaultBoolean) {
        this.defaultInteger = defaultInteger;
        this.defaultLightUserData = defaultLightUserData;
        this.defaultNumber = defaultNumber;
        this.defaultString = defaultString;
        this.defaultBoolean = defaultBoolean;
    }
}
