/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.R257;
import fmod.T239;
import fmod.X243;
import fmod.fmod;

public class J251 {
    private long g;

    public static boolean g(J251 j251) {
        return j251.g != 0L;
    }

    public static void d(J251 j251, X243 x243) {
        fmod.EventGroup_freeEventData(j251.g, x243.m, true);
    }

    public X243 q(int n, int n2) {
        return new X243(fmod.EventGroup_getEventByIndex(this.g, n, n2));
    }

    public T239 s() {
        R257[] arrr257;
        T239 t239 = new T239();
        String string = fmod.EventGroup_getInfo(this.g);
        for (R257 r257 : arrr257 = fmod.j(string)) {
            if (r257.g.equals("index")) {
                t239.g = Integer.parseInt((String)r257.d);
            }
            if (!r257.g.equals("name")) continue;
            t239.d = (String)r257.d;
        }
        return t239;
    }

    public String toString() {
        return this.s().d;
    }

    public J251 h(int n) {
        return new J251(fmod.EventGroup_getGroupByIndex(this.g, n, false));
    }

    public static int b(J251 j251) {
        return fmod.EventGroup_getNumEvents(j251.g);
    }

    public static int l(J251 j251) {
        return fmod.EventGroup_getNumGroups(j251.g);
    }

    public static X243[] e(J251 j251) {
        int n = J251.b(j251);
        X243[] arrx243 = new X243[n];
        for (int i = 0; i < n; ++i) {
            arrx243[i] = j251.q(i, 4);
        }
        return arrx243;
    }

    public J251(long l) {
        this.g = l;
    }

    public static J251[] j(J251 j251) {
        int n = J251.l(j251);
        J251[] arrj251 = new J251[n];
        for (int i = 0; i < n; ++i) {
            arrj251[i] = j251.h(i);
        }
        return arrj251;
    }
}

