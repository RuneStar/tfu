// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import rs2.shared.sound.SoundAdapter;
import com.jagex.game.runetek6.event.EventHandler;

final class W599 extends EventHandler
{
    public static void g(final W599 w599, final SoundAdapter soundAdapter, final Object o) {
        SoundManager.StopSound(soundAdapter.getHandle());
        af(soundAdapter);
    }
}
