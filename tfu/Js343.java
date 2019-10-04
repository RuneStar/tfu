/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Js343 {
    public final Object d;
    public final Object q;

    public boolean equals(Object object) {
        if (object == null || !(object instanceof Js343)) {
            return false;
        }
        Js343 js343 = (Js343)object;
        if (this.d == null ? js343.d != null : !this.d.equals(js343.d)) {
            return false;
        }
        return !(this.q == null ? js343.q != null : !this.q.equals(js343.q));
    }

    public String toString() {
        return this.d + ", " + this.q;
    }

    public Js343(Object object, Object object2) {
        this.d = object;
        this.q = object2;
    }

    public int hashCode() {
        int n = 0;
        if (this.d != null) {
            n += this.d.hashCode();
        }
        if (this.q != null) {
            n += 31 * this.q.hashCode();
        }
        return n;
    }
}

