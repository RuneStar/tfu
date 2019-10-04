/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
public class LuaUserData {
    private final String metatable;
    private final long userdata;

    @Bs1
    @Be2
    public LuaUserData(long l, String string) {
        this.userdata = l;
        this.metatable = string;
    }
}

