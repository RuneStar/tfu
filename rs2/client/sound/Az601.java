/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.client.sound.SoundManager;
import rs2.shared.sound.SoundAdapter;

final class Az601
extends EventHandler {
    public static void g(Az601 az601, SoundAdapter soundAdapter, Object object) {
        SoundManager.SetSoundVolume(soundAdapter.getHandle(), soundAdapter.getVolume());
    }

    Az601() {
    }
}

