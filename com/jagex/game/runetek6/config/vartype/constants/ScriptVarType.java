package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;
import tfu.Kg142;

public enum ScriptVarType implements J204 {
   BOOLEAN(1, BaseVarType.INTEGER, false),
   CATEGORY(5, BaseVarType.INTEGER, -1),
   CHAT_CATEGORY(6, BaseVarType.INTEGER, -1),
   CHAT_PHRASE(7, BaseVarType.INTEGER, -1),
   CURSOR(10, BaseVarType.INTEGER, -1),
   GRAPHIC(8, BaseVarType.INTEGER, -1),
   INT(0, BaseVarType.INTEGER, 0),
   INV(11, BaseVarType.INTEGER, -1),
   LEGACY(99, BaseVarType.INTEGER, -1),
   LONG(2, BaseVarType.LONG, 0),
   OBJ(9, BaseVarType.INTEGER, -1),
   STRING(3, BaseVarType.STRING, ""),
   VECTOR3(4, BaseVarType.VECTOR3, new Kg142());

   public static ScriptVarType[] varByLegacyChar;
   public final BaseVarType baseType;
   private Object defaultValue;
   private final int serialID;

   public int getId() {
      return this.serialID;
   }

   private ScriptVarType(int var3, BaseVarType var4, Object var5) {
      this.serialID = var3;
      this.baseType = var4;
      this.defaultValue = var5;
   }

   public BaseVarType getVarBaseType() {
      return this.baseType;
   }

   public Object getDefaultValue() {
      return this.defaultValue;
   }
}
