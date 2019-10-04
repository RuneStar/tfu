/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.client.sound.SoundManager;
import rs2.shared.sound.SoundAdapter;

final class Aq602
extends EventHandler {
    public static void g(Aq602 aq602, SoundAdapter soundAdapter, Object object) {
        SoundManager.SetSoundParameter(soundAdapter.getHandle(), soundAdapter.getParams());
    }

    Aq602() {
    }
}

