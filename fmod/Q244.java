/*
 * Decompiled with CFR 0.146.
 */
package fmod;

public class Q244 {
    public float d;
    public float g;
    public float q;

    public Q244(float f, float f2, float f3) {
        this.g = f;
        this.d = f2;
        this.q = f3;
    }

    public Q244() {
        this.q = 0.0f;
        this.d = 0.0f;
        this.g = 0.0f;
    }

    public Q244(Q244 q244) {
        this.g = q244.g;
        this.d = q244.d;
        this.q = q244.q;
    }

    public String toString() {
        return "X = " + this.g + ", Y = " + this.d + ", Z = " + this.q;
    }
}

