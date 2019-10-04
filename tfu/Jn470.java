package tfu;

import com.jagex.core.constants.J204;

public enum Jn470 implements J204 {
   CLIENT_ROUTINE_PARTIAL,
   VARIABLE_FULL,
   CHAT_LINE,
   VARIABLE_PARTIAL,
   HITMARK,
   CLIENT_ROUTINE_FULL;

   public int getId() {
      return this.ordinal();
   }
}
