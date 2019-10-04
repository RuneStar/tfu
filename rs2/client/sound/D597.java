/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.maths.Vector3;
import rs2.client.sound.SoundManager;
import rs2.shared.sound.SoundAdapter;

final class D597
extends EventHandler {
    public void g(SoundAdapter soundAdapter, Object object) {
        Vector3 vector3 = soundAdapter.getObservedLinearVelocity();
        String string = "velocity=" + (int)Vector3.f(vector3);
        SoundManager.SetSoundParameter(soundAdapter.getHandle(), string);
    }

    D597() {
    }
}

