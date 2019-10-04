package rs2.client.worldelement;

import com.jagex.game.runetek6.event.EventHandler;
import java.io.IOException;
import rs2.client.client;

class S34 extends EventHandler {
   // $FF: synthetic field
   final player g;

   public void trigger(Object var1, Object var2) {
      try {
         client.dq.sendOutgoingPackets();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   S34(player var1) {
      this.g = var1;
   }
}
