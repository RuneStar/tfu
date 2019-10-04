package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.shared.sound.SoundAdapter;

final class Aq602 extends EventHandler {
   public static void g(Aq602 var0, SoundAdapter var1, Object var2) {
      SoundManager.SetSoundParameter(var1.getHandle(), var1.getParams());
   }
}
