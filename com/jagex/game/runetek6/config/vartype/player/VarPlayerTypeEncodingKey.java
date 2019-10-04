package com.jagex.game.runetek6.config.vartype.player;

import com.jagex.core.constants.J204;

@Deprecated
@Deprecated
@Deprecated
@Deprecated
public enum VarPlayerTypeEncodingKey implements J204 {
   CLANDATA(107),
   /** @deprecated */
   CLIENTCODE(110),
   /** @deprecated */
   GENERALPURPOSE(109),
   HISCOREDATA(105),
   LEGACYID(113),
   /** @deprecated */
   MASTERQUEST(111),
   PLOGDATA(106),
   PROTECTEDACCESSREQUIRED(100),
   /** @deprecated */
   QUESTPOINTS(112),
   SENDTOGAMELOGWORLD(103),
   SETVARALLOWED(101),
   TRANSMITLEVELOTHER(108),
   WARNONDECREASE(104),
   WEALTHEQUIVALENT(102);

   private final int serialID;

   private VarPlayerTypeEncodingKey(int var3) {
      this.serialID = var3;
   }

   public int getId() {
      return this.serialID;
   }
}
