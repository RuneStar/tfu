/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;
import com.jagex.game.runetek6.config.vartype.constants.BaseVarType;
import tfu.Kg142;

public enum ScriptVarType implements J204
{
    INT(0, BaseVarType.INTEGER, 0),
    BOOLEAN(1, BaseVarType.INTEGER, false),
    LONG(2, BaseVarType.LONG, 0),
    STRING(3, BaseVarType.STRING, ""),
    VECTOR3(4, BaseVarType.VECTOR3, new Kg142()),
    CATEGORY(5, BaseVarType.INTEGER, -1),
    CHAT_CATEGORY(6, BaseVarType.INTEGER, -1),
    CHAT_PHRASE(7, BaseVarType.INTEGER, -1),
    GRAPHIC(8, BaseVarType.INTEGER, -1),
    OBJ(9, BaseVarType.INTEGER, -1),
    CURSOR(10, BaseVarType.INTEGER, -1),
    INV(11, BaseVarType.INTEGER, -1),
    LEGACY(99, BaseVarType.INTEGER, -1);
    
    public static ScriptVarType[] varByLegacyChar;
    public final BaseVarType baseType;
    private Object defaultValue;
    private final int serialID;

    @Override
    public int getId() {
        return this.serialID;
    }

    private ScriptVarType(int n2, BaseVarType baseVarType, Object object) {
        this.serialID = n2;
        this.baseType = baseVarType;
        this.defaultValue = object;
    }

    public BaseVarType getVarBaseType() {
        return this.baseType;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }
}

