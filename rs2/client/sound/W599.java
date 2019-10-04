package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.shared.sound.SoundAdapter;

final class W599 extends EventHandler {
   public static void g(W599 var0, SoundAdapter var1, Object var2) {
      SoundManager.StopSound(var1.getHandle());
      SoundManager.ax(var1);
   }
}
