package com.jagex.game.runetek6.config.vartype.player;

import com.jagex.core.constants.E294;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;

public class VarPlayerType extends VarType {
   private static final Logger logger = LoggerFactory.getLogger(VarPlayerType.class);
   public int clientCode;

   public void decode(Gg3 var1, int var2) {
      VarPlayerTypeEncodingKey var3 = (VarPlayerTypeEncodingKey)E294.d(VarPlayerTypeEncodingKey.values(), var2);
      if (var3 == VarPlayerTypeEncodingKey.CLIENTCODE) {
         this.clientCode = Gg3.au(var1);
      } else {
         logger.info("Error: Unrecognised config code: {} for domain {}", var2, super.domain);
      }

   }

   public VarPlayerType(VarDomainType var1, int var2) {
      super(var1, var2);
   }
}
