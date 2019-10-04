/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.J251;
import fmod.R257;
import fmod.W242;
import fmod.fmod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Z256 {
    private static final Logger logger = LoggerFactory.getLogger(Z256.class);
    long d;

    public J251 d(int n, boolean bl) {
        return new J251(fmod.EventProject_getGroupByIndex(this.d, n, bl));
    }

    public W242 j() {
        R257[] arrr257;
        W242 w242 = new W242();
        if (this.d == 0L) {
            return null;
        }
        String string = fmod.EventProject_getInfo(this.d);
        for (R257 r257 : arrr257 = fmod.j(string)) {
            if (r257.g.equals("index")) {
                w242.g = Integer.parseInt((String)r257.d);
            }
            if (r257.g.equals("name")) {
                w242.d = (String)r257.d;
            }
            if (r257.g.equals("numevents")) {
                w242.q = Integer.parseInt((String)r257.d);
            }
            if (r257.g.equals("maxwavebanks")) {
                w242.e = Integer.parseInt((String)r257.d);
            }
            if (r257.g.equals("numinstances")) {
                w242.j = Integer.parseInt((String)r257.d);
            }
            if (!r257.g.equals("numplayingevents")) continue;
            w242.h = Integer.parseInt((String)r257.d);
        }
        return w242;
    }

    public String[] e() {
        if (Z256.g(this)) {
            String string = fmod.EventProject_getWaveBanksNeeded(this.d);
            String[] arrstring = string.split("\\|");
            int n = 0;
            while (n < arrstring.length) {
                String[] arrstring2 = arrstring;
                int n2 = n++;
                arrstring2[n2] = arrstring2[n2] + ".fsb";
            }
            return arrstring;
        }
        return null;
    }

    public static int h(Z256 z256) {
        return fmod.EventProject_getNumGroups(z256.d);
    }

    public static void s(Z256 z256, boolean bl) {
        fmod.EventProject_stopAllEvents(z256.d, bl);
    }

    public Z256(long l) {
        this.d = l;
    }

    public static boolean g(Z256 z256) {
        return z256.d != 0L;
    }

    public static J251[] q(Z256 z256) {
        int n = Z256.h(z256);
        J251[] arrj251 = new J251[n];
        for (int i = 0; i < n; ++i) {
            arrj251[i] = z256.d(i, false);
        }
        return arrj251;
    }
}

