/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.Q244;
import fmod.fmod;

public class D564 {
    public String d = "";
    public long g = 0L;

    public static void d(D564 d564) {
        if (D564.g(d564)) {
            fmod.EventReverb_release(d564.g);
        }
    }

    public String toString() {
        return this.d;
    }

    public static void q(D564 d564, boolean bl) {
        if (D564.g(d564)) {
            fmod.EventReverb_setActive(d564.g, bl);
        }
    }

    public static void j(D564 d564, Q244 q244, float f, float f2) {
        if (D564.g(d564)) {
            fmod.EventReverb_set3DAttributes(d564.g, q244.g, q244.d, q244.q, f, f2);
        }
    }

    public D564(long l) {
        this.g = l;
    }

    public static boolean g(D564 d564) {
        return d564.g != 0L;
    }
}

