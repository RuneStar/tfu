/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Ag97;
import com.jagex.game.runetek6.xelement.Bm108;
import com.jagex.maths.Vector3;
import tfu.Gg3;

public class S356
extends Bm108 {
    public static S356 g(Gg3 gg3, int n) {
        Vector3 vector3 = new Vector3(gg3);
        return new S356(vector3);
    }

    @Override
    public void d(Gg3 gg3) {
        Vector3.w((Vector3)this.r, gg3);
    }

    S356(Vector3 vector3) {
        super(Ag97.j, vector3);
    }
}

