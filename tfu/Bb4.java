/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.StringTools;
import tfu.Ba115;
import tfu.Bc288;
import tfu.Bz650;
import tfu.Gg3;

public final class Bb4 {
    public static final int e = 2;
    public static final int j = 3;
    final int d;
    final Bc288 g;
    private volatile String q;

    public String toString() {
        String string = this.q;
        if (string == null) {
            this.q = string = this.g.name() + ":" + this.d;
        }
        return string;
    }

    public int hashCode() {
        return System.identityHashCode(this.g) + this.d;
    }

    public boolean equals(Object object) {
        Bb4 bb4 = (Bb4)object;
        return this.g == bb4.g && this.d == bb4.d;
    }

    public static Bb4 g(String string) {
        int n = string.indexOf(58);
        if (n < 0) {
            throw new IllegalArgumentException("Cannot decode GameEntityId " + string + " - expected format TYPENAME:12345");
        }
        String string2 = string.substring(0, n).trim();
        if (string2.isEmpty()) {
            throw new IllegalArgumentException("Cannot decode GameEntityId " + string + " - expected format TYPENAME:12345");
        }
        Bc288 bc288 = Bz650.w(string2);
        String string3 = string.substring(n + 1).trim();
        if (!StringTools.d(string3)) {
            throw new IllegalArgumentException("Cannot decode GameEntityId " + string + " - expected format TYPENAME:12345");
        }
        int n2 = StringTools.j(string3);
        if ((n2 & 0xFFFF) != n2) {
            throw new IllegalArgumentException("Cannot decode GameEntityId " + string + " - number is out of range");
        }
        return new Bb4(bc288, n2);
    }

    public static void d(Bb4 bb4) {
        if (Ba115.q(bb4.g)) {
            Ba115 ba115 = Ba115.j(bb4.g);
            ba115.l(bb4);
        }
    }

    public static Bb4 e(Gg3 gg3, Bc288 bc288) {
        if (!Bz650.b(bc288)) {
            throw new IllegalArgumentException("Client-side GameEntityId of type " + bc288.name() + " cannot be sent to server");
        }
        return new Bb4(bc288, Gg3.au(gg3));
    }

    public int h() {
        if (!Bz650.b(this.g)) {
            throw new IllegalArgumentException("Client-side GameEntityId " + this + " cannot be sent to server");
        }
        return (this.g.ordinal() << 16) + this.d;
    }

    public static Bb4 s(int n) {
        if ((n & 0xFFFFFF) != n) {
            throw new IllegalArgumentException("Invalid int24: " + n);
        }
        return new Bb4(Bz650.l(n >> 16), n & 0xFFFF);
    }

    public static Bb4 j(Gg3 gg3) {
        return new Bb4(Bz650.l(Gg3.ar(gg3)), Gg3.au(gg3));
    }

    Bb4(Bc288 bc288, int n) {
        this.g = bc288;
        this.d = n;
        if (this.g == null) {
            throw new IllegalArgumentException();
        }
        if ((this.d & 0xFFFF) != this.d) {
            throw new IllegalArgumentException();
        }
    }

    public void q(Gg3 gg3) {
        if (!Bz650.b(this.g)) {
            throw new IllegalArgumentException("Client-side GameEntityId " + this + " cannot be sent to server");
        }
        Gg3.k(gg3, this.g.ordinal());
        Gg3.i(gg3, this.d);
    }
}

