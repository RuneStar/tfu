package com.jagex.game.runetek6.script.resource.proto;

import java.util.ArrayList;
import java.util.List;
import tfu.Hp62;
import tfu.Ia63;

public class ProtocolBufferDefinition implements Hp62 {
   public static final Ia63 PROTO_CONSTRUCTOR = new ProtocolBufferDefinition$1();
   public final String definition;
   public final List messageProtocolIds;
   public final String name;

   ProtocolBufferDefinition(String var1, List var2, String var3) {
      this.name = var1;
      this.definition = var3;
      this.messageProtocolIds = new ArrayList(var2);
   }

   public void onAllRefsReleased() {
   }
}
