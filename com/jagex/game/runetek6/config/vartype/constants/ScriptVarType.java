// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.constants;

import tfu.Kg142;
import com.jagex.core.constants.J204;

public enum ScriptVarType implements J204
{
    BOOLEAN("BOOLEAN", 1, 1, BaseVarType.INTEGER, (Object)false), 
    CATEGORY("CATEGORY", 5, 5, BaseVarType.INTEGER, (Object)(-1)), 
    CHAT_CATEGORY("CHAT_CATEGORY", 6, 6, BaseVarType.INTEGER, (Object)(-1)), 
    CHAT_PHRASE("CHAT_PHRASE", 7, 7, BaseVarType.INTEGER, (Object)(-1)), 
    CURSOR("CURSOR", 10, 10, BaseVarType.INTEGER, (Object)(-1)), 
    GRAPHIC("GRAPHIC", 8, 8, BaseVarType.INTEGER, (Object)(-1)), 
    INT("INT", 0, 0, BaseVarType.INTEGER, (Object)0), 
    INV("INV", 11, 11, BaseVarType.INTEGER, (Object)(-1)), 
    LEGACY("LEGACY", 12, 99, BaseVarType.INTEGER, (Object)(-1)), 
    LONG("LONG", 2, 2, BaseVarType.LONG, (Object)0), 
    OBJ("OBJ", 9, 9, BaseVarType.INTEGER, (Object)(-1)), 
    STRING("STRING", 3, 3, BaseVarType.STRING, (Object)""), 
    VECTOR3("VECTOR3", 4, 4, BaseVarType.VECTOR3, (Object)new Kg142());
    
    public static ScriptVarType[] varByLegacyChar;
    public final BaseVarType baseType;
    private Object defaultValue;
    private final int serialID;
    
    @Override
    public int getId() {
        return this.serialID;
    }
    
    private ScriptVarType(final String name, final int ordinal, final int serialID, final BaseVarType baseType, final Object defaultValue) {
        this.serialID = serialID;
        this.baseType = baseType;
        this.defaultValue = defaultValue;
    }
    
    public BaseVarType getVarBaseType() {
        return this.baseType;
    }
    
    public Object getDefaultValue() {
        return this.defaultValue;
    }
}
