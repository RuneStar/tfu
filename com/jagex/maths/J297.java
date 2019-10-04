/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import tfu.Ln265;

public class J297
extends Ln265
implements Comparable {
    public float d;
    public float g;
    public double q;

    public J297(J297 j297) {
        this.g = j297.g;
        this.d = j297.d;
        this.q = j297.q;
    }

    public String toString() {
        return this.g + "," + this.d;
    }

    public static int g(J297 j297, J297 j2972) {
        return j297.q < j2972.q ? -1 : 1;
    }

    public J297(float f, float f2) {
        this.g = f;
        this.d = f2;
    }
}

