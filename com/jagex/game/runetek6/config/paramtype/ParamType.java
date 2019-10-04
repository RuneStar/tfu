package com.jagex.game.runetek6.config.paramtype;

import com.jagex.core.constants.E294;
import com.jagex.core.stringtools.general.J173;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;

public class ParamType {
   private static final boolean debug = true;
   private static final Logger logger = LoggerFactory.getLogger(ParamType.class);
   public boolean autodisable = true;
   public int defaultint;
   public String defaultstr;
   public ScriptVarType type;

   protected void decode(Gg3 var1, int var2) {
      if (var2 == 1) {
         char var3 = J173.q(Gg3.ax(var1));
         if (var3 == 'i') {
            this.type = ScriptVarType.INT;
         } else if (var3 == '1') {
            this.type = ScriptVarType.BOOLEAN;
         } else if (var3 == 'i') {
            this.type = ScriptVarType.INT;
         } else if (var3 == 'd') {
            this.type = ScriptVarType.GRAPHIC;
         } else if (var3 == 's') {
            this.type = ScriptVarType.STRING;
         } else if (var3 == '@') {
            this.type = ScriptVarType.CURSOR;
         } else if (var3 == 'v') {
            this.type = ScriptVarType.INV;
         } else if (var3 != 'o' && var3 != 'O') {
            this.type = ScriptVarType.LEGACY;
         } else {
            this.type = ScriptVarType.STRING;
         }
      } else if (var2 == 2) {
         this.defaultint = Gg3.bd(var1);
      } else if (var2 == 4) {
         this.autodisable = false;
      } else if (var2 == 5) {
         this.defaultstr = Gg3.bk(var1);
      } else if (var2 == 6) {
         this.type = (ScriptVarType)E294.g(ScriptVarType.class, Gg3.ax(var1));
      } else {
         logger.info("Error unrecognised .param config code: {}", var2);
      }

   }

   protected void decode(Gg3 var1) {
      while(true) {
         int var2 = Gg3.ar(var1);
         if (var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }
}
