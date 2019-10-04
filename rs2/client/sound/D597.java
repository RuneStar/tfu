// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import com.jagex.maths.Vector3;
import rs2.shared.sound.SoundAdapter;
import com.jagex.game.runetek6.event.EventHandler;

final class D597 extends EventHandler
{
    public void g(final SoundAdapter soundAdapter, final Object o) {
        SoundManager.SetSoundParameter(soundAdapter.getHandle(), "velocity=" + (int)Vector3.f(soundAdapter.getObservedLinearVelocity()));
    }
}
