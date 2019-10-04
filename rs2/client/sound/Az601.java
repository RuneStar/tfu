package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.shared.sound.SoundAdapter;

final class Az601 extends EventHandler {
   public static void g(Az601 var0, SoundAdapter var1, Object var2) {
      SoundManager.SetSoundVolume(var1.getHandle(), var1.getVolume());
   }
}
