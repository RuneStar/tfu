/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;

class A207
implements State {
    final float b;
    final float d;
    final float e;
    final float g;
    final boolean h;
    final float j;
    final float l;
    final float q;
    final float s;

    public int hashCode() {
        return (int)(this.g * 65536.0f + this.d * 31.0f + this.q + this.j * 257.0f + this.e * 8191.0f);
    }

    public String toString() {
        String string = "dpos=(" + this.g + "," + this.d + "," + this.q + ") maxAccelPerTick=" + this.j + " faceAngle=" + this.e;
        if (this.h) {
            string = string + " isUnpushable=true";
        }
        if (this.s != 0.0f || this.b != 0.0f || this.l != 0.0f) {
            string = string + " impulse=(" + this.s + "," + this.b + "," + this.l + ")";
        }
        return string;
    }

    A207(float f, float f2, float f3, float f4, float f5, boolean bl, float f6, float f7, float f8) {
        if (bl) {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f6 = 0.0f;
            f7 = 0.0f;
            f8 = 0.0f;
        }
        this.g = f;
        this.d = f2;
        this.q = f3;
        this.j = f4;
        this.e = f5;
        this.h = bl;
        this.s = f6;
        this.b = f7;
        this.l = f8;
    }

    public boolean equals(Object object) {
        A207 a207 = (A207)object;
        return this.g == a207.g && this.d == a207.d && this.q == a207.q && this.j == a207.j && this.e == a207.e && this.h == a207.h && this.s == a207.s && this.b == a207.b && this.l == a207.l;
    }
}

