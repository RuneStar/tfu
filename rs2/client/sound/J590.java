// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import java.util.Enumeration;
import fmod.X243;
import fmod.Q244;
import com.jagex.maths.Vector3;
import rs2.client.ScriptCamera;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.J332;

final class J590 extends J332
{
    @Override
    public void g(final GameEntity gameEntity, String str) {
        if (gameEntity == null || str == null) {
            SoundManager.logger.error((gameEntity == null) ? "SoundManager Animation: Game Entity is null" : "SoundManager Animation: Sound Trigger is null");
            return;
        }
        final Vector3 trans = gameEntity.getWorldTransform().trans;
        final ScriptCamera activeCamera = ScriptCamera.getActiveCamera();
        if (activeCamera != null && Vector3.f(Vector3.k(trans, activeCamera.getWorldTransform().trans)) < 90.0f && activeCamera != null) {
            if (!str.contains("/")) {
                final int ev = GameEntity.ev(gameEntity, "BotNumber", -1);
                if (ev != -1) {
                    final String e = Ag588.e(ev, str);
                    if (e != null) {
                        final String string = str + Integer.toString(ev);
                        boolean b = false;
                        if (SoundManager.az.containsKey(string) && (int)SoundManager.az.get(string) == SoundManager.an) {
                            b = true;
                        }
                        if (b) {
                            return;
                        }
                        SoundManager.az.put(string, SoundManager.an);
                        str = e;
                        final Enumeration<String> keys = SoundManager.az.keys();
                        while (keys.hasMoreElements()) {
                            final String s = keys.nextElement();
                            if ((int)SoundManager.az.get(s) < SoundManager.an) {
                                SoundManager.az.remove(s);
                            }
                        }
                    }
                }
            }
            SoundManager.aw("ANIM", str);
            final X243 y = SoundManager.c.y(str, new Q244(trans.x, trans.y, trans.z));
            if (X243.h(y)) {
                X243.ap(y, gameEntity);
            }
        }
    }
}
