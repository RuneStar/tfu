package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.shared.sound.SoundAdapter;

final class Al600 extends EventHandler {
   public static void g(Al600 var0, SoundAdapter var1, Object var2) {
      SoundManager.StopSound(var1.getHandle());
      SoundManager.ax(var1);
   }
}
