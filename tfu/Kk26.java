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

public class Kk26
extends It12 {
    public final String d;
    public final float g;

    public static Kk26 e(Gg3 gg3, Z165 z165, boolean bl, boolean bl2) {
        Gg3.bm(gg3);
        String string = gg3.bp();
        O166.v(z165.g);
        z165.d.j = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        z165.d.e = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        z165.d.h = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        float f = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        return new Kk26(f, string);
    }

    public Kk26(float f, String string) {
        this.g = f;
        this.d = string;
    }

    @Override
    public Ie21 g() {
        return Ie21.SPHERE;
    }
}

