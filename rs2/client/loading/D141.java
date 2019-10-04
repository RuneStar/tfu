package rs2.client.loading;

import com.jagex.game.runetek6.config.vartype.constants.BaseVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;

// $FF: synthetic class
class D141 {
   // $FF: synthetic field
   static final int[] d = new int[BaseVarType.values().length];
   // $FF: synthetic field
   static final int[] g;

   static {
      try {
         d[BaseVarType.INTEGER.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
      }

      try {
         d[BaseVarType.LONG.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
      }

      try {
         d[BaseVarType.STRING.ordinal()] = 3;
      } catch (NoSuchFieldError var4) {
      }

      try {
         d[BaseVarType.VECTOR3.ordinal()] = 4;
      } catch (NoSuchFieldError var3) {
      }

      g = new int[VarDomainType.values().length];

      try {
         g[VarDomainType.CLIENT.ordinal()] = 1;
      } catch (NoSuchFieldError var2) {
      }

      try {
         g[VarDomainType.CLAN.ordinal()] = 2;
      } catch (NoSuchFieldError var1) {
      }

   }
}
