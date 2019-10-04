/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.I48;
import com.jagex.maths.O166;
import com.jagex.maths.Z165;
import tfu.Ai354;
import tfu.Gg3;
import tfu.Ie21;
import tfu.It12;

public class Kw23
extends It12 {
    public final float d;
    public final float g;
    public final String q;

    public static Kw23 e(Gg3 gg3, Z165 z165, boolean bl, boolean bl2) {
        Gg3.bm(gg3);
        String string = gg3.bp();
        z165.g.j = Gg3.bw(gg3);
        z165.g.e = Gg3.bw(gg3);
        z165.g.h = Gg3.bw(gg3);
        z165.g.s = Gg3.bw(gg3);
        z165.d.j = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        z165.d.e = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        z165.d.h = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        float f = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        float f2 = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        return new Kw23(f, f2, string);
    }

    @Override
    public Ie21 g() {
        return Ie21.CAPSULE;
    }

    public Kw23(float f, float f2, String string) {
        this.g = f;
        this.d = f2;
        this.q = string;
    }
}

