package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.maths.Vector3;
import rs2.client.lua.ClientScriptAPI;
import rs2.shared.sound.SoundAdapter;

final class T596 extends EventHandler {
   public static void g(T596 var0, SoundAdapter var1, Object var2) {
      Vector3 var3 = ClientScriptAPI.clientToServerPos(var1.getWorldTransform().trans);
      SoundManager.SetSoundPosition(var1.getHandle(), var3.x, var3.y, var3.z);
   }
}
