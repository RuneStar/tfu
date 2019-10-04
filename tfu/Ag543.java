/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Ag543
implements Comparable {
    public final int d;
    public final int g;
    public final int q;

    public Ag543(Ag543 ag543) {
        this.g = ag543.g;
        this.d = ag543.d;
        this.q = ag543.q;
    }

    public Ag543(int n, int n2, int n3) {
        this.g = n;
        this.d = n2;
        this.q = n3;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Ag543)) {
            return false;
        }
        return Ag543.g(this, (Ag543)object) == 0;
    }

    public int hashCode() {
        return this.g + this.d + this.q;
    }

    public static int g(Ag543 ag543, Ag543 ag5432) {
        float f = ag543.g - ag5432.g;
        if (f != 0.0f) {
            return f > 0.0f ? 1 : -1;
        }
        f = ag543.d - ag5432.d;
        if (f != 0.0f) {
            return f > 0.0f ? 1 : -1;
        }
        f = ag543.q - ag5432.q;
        if (f != 0.0f) {
            return f > 0.0f ? 1 : -1;
        }
        return 0;
    }
}

