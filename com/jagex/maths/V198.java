/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.B164;
import tfu.Gg3;
import tfu.Kl267;

public final class V198
implements Kl267,
B164 {
    public static final V198 g = new V198(0.0f, 0.0f, 0.0f, 0.0f);
    public final float d;
    public final float e;
    public final float j;
    public final float q;

    public String toString() {
        return this.d + "," + this.q + "," + this.j + "," + this.e;
    }

    public V198(Gg3 gg3) {
        this.d = Gg3.bl(gg3);
        this.q = Gg3.bl(gg3);
        this.j = Gg3.bl(gg3);
        this.e = Gg3.bl(gg3);
    }

    public static void g(V198 v198, Gg3 gg3) {
        Gg3.aq(gg3, v198.d);
        Gg3.aq(gg3, v198.q);
        Gg3.aq(gg3, v198.j);
        Gg3.aq(gg3, v198.e);
    }

    public static V198 d(V198 v198) {
        return v198;
    }

    public V198(float f, float f2, float f3, float f4) {
        this.d = f;
        this.q = f2;
        this.j = f3;
        this.e = f4;
    }
}

