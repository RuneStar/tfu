/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.Vector3;
import tfu.Gg3;

public final class Ag566 {
    private static int d;
    private static Ag566[] g;
    private static int q;
    public float[] j = new float[9];

    public Ag566(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        this.j[0] = vector3.x;
        this.j[1] = vector32.x;
        this.j[2] = vector33.x;
        this.j[3] = vector3.y;
        this.j[4] = vector32.y;
        this.j[5] = vector33.y;
        this.j[6] = vector3.z;
        this.j[7] = vector32.z;
        this.j[8] = vector33.z;
    }

    public Ag566() {
        Ag566.d(this);
    }

    public Ag566(Ag566 ag566) {
        System.arraycopy(ag566.j, 0, this.j, 0, 9);
    }

    public Ag566(Gg3 gg3) {
        this.j[0] = Gg3.bl(gg3);
        this.j[1] = Gg3.bl(gg3);
        this.j[2] = Gg3.bl(gg3);
        this.j[3] = Gg3.bl(gg3);
        this.j[4] = Gg3.bl(gg3);
        this.j[5] = Gg3.bl(gg3);
        this.j[6] = Gg3.bl(gg3);
        this.j[7] = Gg3.bl(gg3);
        this.j[8] = Gg3.bl(gg3);
    }

    public static Ag566 d(Ag566 ag566) {
        ag566.j[0] = 1.0f;
        ag566.j[1] = 0.0f;
        ag566.j[2] = 0.0f;
        ag566.j[3] = 0.0f;
        ag566.j[4] = 1.0f;
        ag566.j[5] = 0.0f;
        ag566.j[6] = 0.0f;
        ag566.j[7] = 0.0f;
        ag566.j[8] = 1.0f;
        return ag566;
    }

    public String toString() {
        return this.j[0] + "," + this.j[1] + "," + this.j[2] + "\n" + this.j[3] + "," + this.j[4] + "," + this.j[5] + "\n" + this.j[6] + "," + this.j[7] + "," + this.j[8];
    }

    static {
        g = new Ag566[0];
    }

    public static void g(int n) {
        d = n;
        g = new Ag566[n];
        q = 0;
    }
}

