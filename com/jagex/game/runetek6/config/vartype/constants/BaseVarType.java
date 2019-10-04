// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.constants;

import tfu.Kg142;
import com.jagex.core.constants.J204;

public enum BaseVarType implements J204
{
    INTEGER("INTEGER", 0, 0, (Class)Integer.class), 
    LONG("LONG", 1, 1, (Class)Long.class), 
    STRING("STRING", 2, 2, (Class)String.class), 
    VECTOR3("VECTOR3", 3, 3, (Class)Kg142.class);
    
    public final int id;
    public final Class javaClass;
    
    private BaseVarType(final String name, final int ordinal, final int id, final Class javaClass) {
        this.id = id;
        this.javaClass = javaClass;
    }
    
    @Override
    public int getId() {
        return this.id;
    }
}
