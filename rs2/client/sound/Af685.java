/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.maths.Vector3;
import fmod.D564;
import fmod.E245;
import fmod.Q244;
import rs2.client.sound.F594;
import rs2.client.sound.SoundManager;
import rs2.client.sound.Z674;
import tfu.Gg3;

final class Af685
implements Z674 {
    Af685() {
    }

    @Override
    public void g(String string, Object object) {
    }

    @Override
    public void q() {
        F594.q();
    }

    @Override
    public void d(byte[] arrby, Object object) {
        float f;
        int n;
        float f2;
        Object object2;
        int n2;
        String[] arrstring;
        float f3;
        Gg3 gg3 = new Gg3(arrby);
        int n3 = Gg3.au(gg3);
        F594.q();
        F594.s(F594.b(0.0f));
        for (n2 = 0; n2 < n3; ++n2) {
            n = Gg3.ar(gg3);
            int n4 = Gg3.ar(gg3);
            object2 = new char[n4];
            for (int i = 0; i < n4; ++i) {
                object2[i] = (char)Gg3.ar(gg3);
            }
            arrstring = String.valueOf(object2);
            n4 = (byte)Gg3.ar(gg3);
            object2 = new char[n4];
            for (int i = 0; i < n4; ++i) {
                object2[i] = (char)Gg3.ar(gg3);
            }
            String string = String.valueOf(object2);
            f2 = (float)Gg3.bd(gg3) / 100.0f;
            f = (float)Gg3.bd(gg3) / 100.0f;
            f3 = (float)Gg3.bd(gg3) / 100.0f;
            F594 f594 = new F594(new Vector3(f2, f, f3), (String)arrstring);
            f594.h = string;
            f594.r = Gg3.bd(gg3);
            f594.v = Gg3.bd(gg3);
            f594.w = n;
            f594.p = true;
            f594.l = Gg3.ar(gg3);
            f594.l /= 100.0f;
            F594.d(f594);
        }
        if (gg3.v < gg3.r.length) {
            n2 = Gg3.au(gg3);
            for (n = 0; n < n2; ++n) {
                String string = Gg3.bk(gg3);
                object2 = Gg3.bk(gg3);
                arrstring = string.split(",");
                float f4 = Float.parseFloat(arrstring[1]);
                f2 = Float.parseFloat(arrstring[2]);
                f = Float.parseFloat(arrstring[3]);
                f3 = Float.parseFloat(arrstring[4]);
                float f5 = Float.parseFloat(arrstring[5]);
                D564 d564 = SoundManager.c.z((String)object2);
                if (!D564.g(d564)) continue;
                D564.j(d564, new Q244(f4, f2, f), f3, f5);
                D564.q(d564, true);
                F594.l().add(d564);
            }
        }
        F594.b(1.0f);
    }
}

