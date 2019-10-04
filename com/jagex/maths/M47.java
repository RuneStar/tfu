/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.I48;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public class M47 {
    static ThreadLocal d;
    public static final M47 g;
    public final float f00;
    public final float f01;
    public final float f02;
    public final float f10;
    public final float f11;
    public final float f12;
    public final float f20;
    public final float f21;
    public final float f22;

    public M47 e(M47 m47) {
        float f = m47.f00 * this.f00 + m47.f10 * this.f01 + m47.f20 * this.f02;
        float f2 = m47.f01 * this.f00 + m47.f11 * this.f01 + m47.f21 * this.f02;
        float f3 = m47.f02 * this.f00 + m47.f12 * this.f01 + m47.f22 * this.f02;
        float f4 = m47.f00 * this.f10 + m47.f10 * this.f11 + m47.f20 * this.f12;
        float f5 = m47.f01 * this.f10 + m47.f11 * this.f11 + m47.f21 * this.f12;
        float f6 = m47.f02 * this.f10 + m47.f12 * this.f11 + m47.f22 * this.f12;
        float f7 = m47.f00 * this.f20 + m47.f10 * this.f21 + m47.f20 * this.f22;
        float f8 = m47.f01 * this.f20 + m47.f11 * this.f21 + m47.f21 * this.f22;
        float f9 = m47.f02 * this.f20 + m47.f12 * this.f21 + m47.f22 * this.f22;
        M47 m472 = new M47(f, f2, f3, f4, f5, f6, f7, f8, f9);
        return m472;
    }

    public M47(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f00 = f;
        this.f01 = f2;
        this.f02 = f3;
        this.f10 = f4;
        this.f11 = f5;
        this.f12 = f6;
        this.f20 = f7;
        this.f21 = f8;
        this.f22 = f9;
    }

    public static M47 g(Vector3 vector3, float f) {
        return Quaternion.j(vector3, f).m();
    }

    public static M47 d(float f, float f2, float f3, float f4) {
        return Quaternion.e(f, f2, f3, f4).m();
    }

    public Quaternion q() {
        float f = this.f00 + this.f11 + this.f22;
        float[] arrf = (float[])d.get();
        if (arrf == null) {
            arrf = new float[4];
            d.set(arrf);
        }
        if (f > 0.0f) {
            float f2 = (float)Math.sqrt(f + 1.0f);
            arrf[3] = f2 * 0.5f;
            f2 = 0.5f / f2;
            arrf[0] = (this.f12 - this.f21) * f2;
            arrf[1] = (this.f20 - this.f02) * f2;
            arrf[2] = (this.f01 - this.f10) * f2;
        } else {
            int n = this.f00 < this.f11 ? (this.f11 < this.f22 ? 2 : 1) : (this.f00 < this.f22 ? 2 : 0);
            int n2 = (n + 1) % 3;
            int n3 = (n + 2) % 3;
            float f3 = (float)Math.sqrt(this.j(n, n) - this.j(n2, n2) - this.j(n3, n3) + 1.0f);
            arrf[n] = f3 * 0.5f;
            f3 = 0.5f / f3;
            arrf[3] = (this.j(n2, n3) - this.j(n3, n2)) * f3;
            arrf[n2] = (this.j(n, n2) + this.j(n2, n)) * f3;
            arrf[n3] = (this.j(n, n3) + this.j(n3, n)) * f3;
        }
        return new Quaternion(arrf[0], arrf[1], arrf[2], arrf[3]);
    }

    private float j(int n, int n2) {
        switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        return this.f00;
                    }
                    case 1: {
                        return this.f01;
                    }
                    case 2: {
                        return this.f02;
                    }
                }
                break;
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        return this.f10;
                    }
                    case 1: {
                        return this.f11;
                    }
                    case 2: {
                        return this.f12;
                    }
                }
                break;
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        return this.f20;
                    }
                    case 1: {
                        return this.f21;
                    }
                    case 2: {
                        return this.f22;
                    }
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public M47(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        this.f00 = vector3.x;
        this.f01 = vector32.x;
        this.f02 = vector33.x;
        this.f10 = vector3.y;
        this.f11 = vector32.y;
        this.f12 = vector33.y;
        this.f20 = vector3.z;
        this.f21 = vector32.z;
        this.f22 = vector33.z;
    }

    public String toString() {
        return this.f00 + "," + this.f01 + "," + this.f02 + "\n" + this.f10 + "," + this.f11 + "," + this.f12 + "\n" + this.f20 + "," + this.f21 + "," + this.f22;
    }

    public boolean equals(Object object) {
        if (!(object instanceof M47)) {
            return false;
        }
        M47 m47 = (M47)object;
        return this.f00 == m47.f00 && this.f01 == m47.f01 && this.f02 == m47.f02 && this.f10 == m47.f10 && this.f11 == m47.f11 && this.f12 == m47.f12 && this.f20 == m47.f20 && this.f21 == m47.f21 && this.f22 == m47.f22;
    }

    static {
        g = new M47(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
        d = new ThreadLocal();
    }

    public M47 h(M47 m47) {
        float f = this.f00 * m47.f00 + this.f10 * m47.f01 + this.f20 * m47.f02;
        float f2 = this.f01 * m47.f00 + this.f11 * m47.f01 + this.f21 * m47.f02;
        float f3 = this.f02 * m47.f00 + this.f12 * m47.f01 + this.f22 * m47.f02;
        float f4 = this.f00 * m47.f10 + this.f10 * m47.f11 + this.f20 * m47.f12;
        float f5 = this.f01 * m47.f10 + this.f11 * m47.f11 + this.f21 * m47.f12;
        float f6 = this.f02 * m47.f10 + this.f12 * m47.f11 + this.f22 * m47.f12;
        float f7 = this.f00 * m47.f20 + this.f10 * m47.f21 + this.f20 * m47.f22;
        float f8 = this.f01 * m47.f20 + this.f11 * m47.f21 + this.f21 * m47.f22;
        float f9 = this.f02 * m47.f20 + this.f12 * m47.f21 + this.f22 * m47.f22;
        M47 m472 = new M47(f, f2, f3, f4, f5, f6, f7, f8, f9);
        return m472;
    }

    public static M47 s(M47 m47, I48 i48) {
        float f = i48.j;
        float f2 = i48.e;
        float f3 = i48.h;
        i48.j = m47.f00 * f + m47.f10 * f2 + m47.f20 * f3;
        i48.e = m47.f01 * f + m47.f11 * f2 + m47.f21 * f3;
        i48.h = m47.f02 * f + m47.f12 * f2 + m47.f22 * f3;
        return m47;
    }

    public static M47 b(M47 m47, Gg3 gg3) {
        Gg3.aq(gg3, m47.f00);
        Gg3.aq(gg3, m47.f01);
        Gg3.aq(gg3, m47.f02);
        Gg3.aq(gg3, m47.f10);
        Gg3.aq(gg3, m47.f11);
        Gg3.aq(gg3, m47.f12);
        Gg3.aq(gg3, m47.f20);
        Gg3.aq(gg3, m47.f21);
        Gg3.aq(gg3, m47.f22);
        return m47;
    }
}

