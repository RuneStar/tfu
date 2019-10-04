/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.maths.Vector3;

public class Av190 {
    public final float d;
    public final Vector3 g;
    public final int j;
    public final float q;

    public static boolean g(Av190 av190, Av190 av1902) {
        return av1902 != null && Vector3.v(av190.g, av1902.g) && av190.d == av1902.d && av190.j == av1902.j && av190.q == av1902.q;
    }

    public Av190(Vector3 vector3, float f, int n, float f2) {
        this.g = vector3;
        this.d = f;
        this.j = n;
        this.q = f2;
    }
}

