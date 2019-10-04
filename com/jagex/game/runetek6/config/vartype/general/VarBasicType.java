package com.jagex.game.runetek6.config.vartype.general;

import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;

public class VarBasicType extends VarType {
   private static final Logger logger = LoggerFactory.getLogger(VarBasicType.class);

   public void decode(Gg3 var1, int var2) {
      logger.info("{} not supported for {}!", var2, super.domain);
   }

   public VarBasicType(VarDomainType var1, int var2) {
      super(var1, var2);
   }
}
