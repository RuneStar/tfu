/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.client.sound.SoundManager;
import rs2.shared.sound.SoundAdapter;

final class W599
extends EventHandler {
    public static void g(W599 w599, SoundAdapter soundAdapter, Object object) {
        SoundManager.StopSound(soundAdapter.getHandle());
        SoundManager.ax(soundAdapter);
    }

    W599() {
    }
}

