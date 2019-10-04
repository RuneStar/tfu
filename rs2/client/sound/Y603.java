/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import fmod.E245;
import fmod.X243;
import java.util.Hashtable;
import rs2.client.sound.G593;
import rs2.client.sound.I684;
import rs2.client.sound.SoundManager;

public class Y603 {
    static String d;
    static float e;
    static String g;
    static int h;
    static String j;
    static X243 q;

    public static X243 g() {
        return q;
    }

    public static void q() {
        if (q != null) {
            X243.f(q);
            q = null;
        }
        d = null;
        g = null;
    }

    public static void d(String string, String string2) {
        if (string.equalsIgnoreCase(g) || string.equalsIgnoreCase(d)) {
            return;
        }
        if (string.equals("")) {
            g = null;
            d = null;
            Y603.q();
            return;
        }
        d = string;
        j = string2;
        if (SoundManager.al.containsValue(string)) {
            d = string;
            I684 i684 = new I684();
            String[] arrstring = SoundManager.c.r(d, 4).aq();
            if (arrstring != null) {
                h = arrstring.length;
                for (String string3 : arrstring) {
                    G593.g(string3, 100000L, true, i684, null);
                }
            } else {
                d = null;
            }
        } else if (q != null) {
            X243.f(q);
        }
    }

    static {
        g = null;
        d = null;
        q = null;
        j = null;
        e = 1.0f;
        h = 0;
    }
}

