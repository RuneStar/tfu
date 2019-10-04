/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Jk523 {
    public Object d;
    public Object g;

    public String toString() {
        return this.g + ", " + this.d;
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof Jk523)) {
            return false;
        }
        Jk523 jk523 = (Jk523)object;
        if (this.g == null ? jk523.g != null : !this.g.equals(jk523.g)) {
            return false;
        }
        return !(this.d == null ? jk523.d != null : !this.d.equals(jk523.d));
    }

    public int hashCode() {
        int n = 0;
        if (this.g != null) {
            n += this.g.hashCode();
        }
        if (this.d != null) {
            n += 31 * this.d.hashCode();
        }
        return n;
    }

    public Jk523(Object object, Object object2) {
        this.g = object;
        this.d = object2;
    }
}

