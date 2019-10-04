/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.J332;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import fmod.E245;
import fmod.Q244;
import fmod.X243;
import java.util.Enumeration;
import java.util.Hashtable;
import rs2.client.ScriptCamera;
import rs2.client.sound.Ag588;
import rs2.client.sound.SoundManager;

final class J590
extends J332 {
    @Override
    public void g(GameEntity gameEntity, String string) {
        Vector3 vector3;
        if (gameEntity == null || string == null) {
            SoundManager.ar().error(gameEntity == null ? "SoundManager Animation: Game Entity is null" : "SoundManager Animation: Sound Trigger is null");
            return;
        }
        Vector3 vector32 = gameEntity.getWorldTransform().trans;
        ScriptCamera scriptCamera = ScriptCamera.getActiveCamera();
        if (scriptCamera != null && Vector3.f(vector3 = Vector3.k(vector32, scriptCamera.getWorldTransform().trans)) < 90.0f && scriptCamera != null) {
            int n;
            String string2;
            if (!string.contains("/") && (n = GameEntity.ev(gameEntity, "BotNumber", -1)) != -1 && (string2 = Ag588.e(n, string)) != null) {
                String string3 = string + Integer.toString(n);
                boolean bl = false;
                if (SoundManager.az.containsKey(string3) && (Integer)SoundManager.az.get(string3) == SoundManager.an) {
                    bl = true;
                }
                if (bl) {
                    return;
                }
                SoundManager.az.put(string3, SoundManager.an);
                string = string2;
                Enumeration enumeration = SoundManager.az.keys();
                while (enumeration.hasMoreElements()) {
                    String string4 = (String)enumeration.nextElement();
                    int n2 = (Integer)SoundManager.az.get(string4);
                    if (n2 >= SoundManager.an) continue;
                    SoundManager.az.remove(string4);
                }
            }
            SoundManager.aw("ANIM", string);
            X243 x243 = SoundManager.c.y(string, new Q244(vector32.x, vector32.y, vector32.z));
            if (X243.h(x243)) {
                X243.ap(x243, gameEntity);
            }
        }
    }

    J590() {
    }
}

