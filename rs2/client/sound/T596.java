// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import com.jagex.maths.Vector3;
import rs2.client.lua.ClientScriptAPI;
import rs2.shared.sound.SoundAdapter;
import com.jagex.game.runetek6.event.EventHandler;

final class T596 extends EventHandler
{
    public static void g(final T596 t596, final SoundAdapter soundAdapter, final Object o) {
        final Vector3 clientToServerPos = ClientScriptAPI.clientToServerPos(soundAdapter.getWorldTransform().trans);
        SoundManager.SetSoundPosition(soundAdapter.getHandle(), clientToServerPos.x, clientToServerPos.y, clientToServerPos.z);
    }
}
