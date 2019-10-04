/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.Vector3;
import tfu.Lp301;

public final class E41
implements Lp301 {
    public final float d;
    public final float e;
    public final float g;
    public final float h;
    public final float j;
    public final float q;

    @Override
    public Vector3 j() {
        return Vector3.g(this.g, this.d, this.q);
    }

    @Override
    public Vector3 e() {
        return Vector3.g(this.j, this.e, this.h);
    }

    public E41(float f, float f2, float f3, float f4, float f5, float f6) {
        this.g = f;
        this.d = f2;
        this.q = f3;
        this.j = f4;
        this.e = f5;
        this.h = f6;
    }

    public String toString() {
        return "[Aabb: (" + this.g + "," + this.d + "," + this.q + ")->(" + this.j + "," + this.e + "," + this.h + ")]";
    }
}

