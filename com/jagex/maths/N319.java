/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.A307;
import com.jagex.maths.Vector3;
import tfu.Gg3;

public final class N319 {
    public static final int d = 1;
    public static final int g = 0;
    private float[] j;
    private A307[] q = new A307[1];

    public void g(Vector3 vector3, Vector3 vector32, float f) {
        A307[] arra307 = new A307[this.q.length + 1];
        System.arraycopy(this.q, 0, arra307, 0, this.q.length);
        A307 a307 = new A307();
        A307 a3072 = this.q[this.q.length - 1];
        A307.d(a307, 0, A307.q(a3072, 3));
        Vector3 vector33 = Vector3.k(A307.q(a3072, 3), A307.q(a3072, 2));
        A307.d(a307, 1, Vector3.z(A307.q(a3072, 3), vector33));
        A307.d(a307, 3, vector3);
        A307.d(a307, 2, vector32);
        arra307[arra307.length - 1] = a307;
        this.q = arra307;
        float[] arrf = new float[this.j.length + 1];
        System.arraycopy(this.j, 0, arrf, 0, this.j.length);
        arrf[arrf.length - 1] = f;
        this.j = arrf;
    }

    public N319(Vector3[] arrvector3, float f, float f2) {
        this.j = new float[2];
        this.q[0] = new A307();
        for (int i = 0; i < 4; ++i) {
            A307.d(this.q[0], i, arrvector3[i]);
        }
        this.j[0] = f;
        this.j[1] = f2;
    }

    public N319(Vector3[] arrvector3) {
        this(arrvector3, 0.0f, 0.0f);
    }

    public N319(Gg3 gg3) {
        this.j = new float[2];
        int n = Gg3.br(gg3);
        this.q[0] = new A307();
        A307.d(this.q[0], 0, new Vector3(gg3));
        A307.d(this.q[0], 1, new Vector3(gg3));
        this.j[0] = Gg3.bl(gg3);
        A307.d(this.q[0], 3, new Vector3(gg3));
        A307.d(this.q[0], 2, new Vector3(gg3));
        this.j[1] = Gg3.bl(gg3);
        for (int i = 2; i < n; ++i) {
            Vector3 vector3 = new Vector3(gg3);
            Vector3 vector32 = new Vector3(gg3);
            this.g(vector3, vector32, Gg3.bl(gg3));
        }
    }
}

