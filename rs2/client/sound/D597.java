package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.maths.Vector3;
import rs2.shared.sound.SoundAdapter;

final class D597 extends EventHandler {
   public void g(SoundAdapter var1, Object var2) {
      Vector3 var3 = var1.getObservedLinearVelocity();
      String var4 = "velocity=" + (int)Vector3.f(var3);
      SoundManager.SetSoundParameter(var1.getHandle(), var4);
   }
}
