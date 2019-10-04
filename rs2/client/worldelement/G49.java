package rs2.client.worldelement;

import com.jagex.game.runetek6.config.vartype.constants.BaseVarType;

// $FF: synthetic class
class G49 {
   // $FF: synthetic field
   static final int[] g = new int[BaseVarType.values().length];

   static {
      try {
         g[BaseVarType.INTEGER.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         g[BaseVarType.LONG.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         g[BaseVarType.STRING.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         g[BaseVarType.VECTOR3.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
