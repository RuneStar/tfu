/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.sound.SoundManager;
import rs2.shared.sound.SoundAdapter;

final class T596
extends EventHandler {
    T596() {
    }

    public static void g(T596 t596, SoundAdapter soundAdapter, Object object) {
        Vector3 vector3 = ClientScriptAPI.clientToServerPos(soundAdapter.getWorldTransform().trans);
        SoundManager.SetSoundPosition(soundAdapter.getHandle(), vector3.x, vector3.y, vector3.z);
    }
}

