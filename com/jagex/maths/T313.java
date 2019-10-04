/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.Vector3;
import java.util.ArrayList;

public final class T313 {
    public final Vector3 d;
    public final Vector3 g;
    ArrayList j;
    public final Vector3 q;

    public int hashCode() {
        return System.identityHashCode(this.g) + System.identityHashCode(this.d) + System.identityHashCode(this.q);
    }

    public boolean equals(Object object) {
        T313 t313 = (T313)object;
        if (this.g == t313.g && this.d == t313.d && this.q == t313.q) {
            return true;
        }
        if (this.g == t313.d && this.d == t313.q && this.q == t313.g) {
            return true;
        }
        if (this.g == t313.q && this.d == t313.g && this.q == t313.d) {
            return true;
        }
        if (this.g == t313.g && this.d == t313.q && this.q == t313.d) {
            return true;
        }
        if (this.g == t313.d && this.d == t313.g && this.q == t313.q) {
            return true;
        }
        return this.g == t313.q && this.d == t313.d && this.q == t313.g;
    }

    T313(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        this.g = vector3;
        this.d = vector32;
        this.q = vector33;
    }
}

