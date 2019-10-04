// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import rs2.shared.sound.SoundAdapter;
import com.jagex.game.runetek6.event.EventHandler;

final class Az601 extends EventHandler
{
    public static void g(final Az601 az601, final SoundAdapter soundAdapter, final Object o) {
        SoundManager.SetSoundVolume(soundAdapter.getHandle(), soundAdapter.getVolume());
    }
}
