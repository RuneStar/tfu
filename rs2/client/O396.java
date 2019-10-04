package rs2.client;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import rs2.client.worldelement.Npc;

final class O396 extends EventHandler {
   // $FF: synthetic field
   final Vector3 d;
   // $FF: synthetic field
   final Npc g;
   // $FF: synthetic field
   final Quaternion q;

   public static void g(O396 var0, XElement var1, Object var2) {
      var0.g.bi(var1, var0.d, var0.q);
   }

   O396(Npc var1, Vector3 var2, Quaternion var3) {
      this.d = var2;
      this.q = var3;
      this.g = var1;
   }
}
