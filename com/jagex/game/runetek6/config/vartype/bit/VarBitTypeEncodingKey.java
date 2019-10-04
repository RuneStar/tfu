package com.jagex.game.runetek6.config.vartype.bit;

import com.jagex.core.constants.J204;

@Deprecated
@Deprecated
public enum VarBitTypeEncodingKey implements J204 {
   BASEVAR(1),
   BITS(2),
   DEBUGNAME(11),
   IGNOREOVERLAP(12),
   /** @deprecated */
   MASTERQUEST(4),
   /** @deprecated */
   QUESTPOINTS(5),
   SENDTOGAMELOGWORLD(8),
   SETVARALLOWED(7),
   TRANSMITLEVEL(9),
   TRANSMITLEVELOTHER(10),
   VARBITNAME_HASH32(13),
   WARNONDECREASE(3),
   WEALTHEQUIVALENT(6);

   private final int serialID;

   public int getId() {
      return this.serialID;
   }

   private VarBitTypeEncodingKey(int var3) {
      this.serialID = var3;
   }
}
