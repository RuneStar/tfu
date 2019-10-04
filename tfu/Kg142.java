/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.Vector3;
import tfu.Gg3;
import tfu.Kz261;

public class Kg142
implements Kz261 {
    public Vector3 g;

    public Kg142(Vector3 vector3) {
        this.g = vector3;
    }

    public Kg142() {
        this.g = Vector3.g;
    }

    @Override
    public void d(Gg3 gg3) {
        Vector3.w(this.g, gg3);
    }

    @Override
    public int g() {
        return Vector3.r(this.g);
    }

    @Override
    public void q(Gg3 gg3) {
        this.g = Vector3.d(gg3);
    }
}

