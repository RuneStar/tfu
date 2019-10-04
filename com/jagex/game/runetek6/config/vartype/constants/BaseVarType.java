/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;
import tfu.Kg142;

public enum BaseVarType implements J204
{
    INTEGER(0, Integer.class),
    LONG(1, Long.class),
    STRING(2, String.class),
    VECTOR3(3, Kg142.class);
    
    public final int id;
    public final Class javaClass;

    private BaseVarType(int n2, Class class_) {
        this.id = n2;
        this.javaClass = class_;
    }

    @Override
    public int getId() {
        return this.id;
    }
}

