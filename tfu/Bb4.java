// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.stringtools.general.StringTools;

public final class Bb4
{
    public static final int e = 2;
    public static final int j = 3;
    final int d;
    final Bc288 g;
    private volatile String q;
    
    @Override
    public String toString() {
        String q = this.q;
        if (q == null) {
            q = (this.q = this.g.name() + ":" + this.d);
        }
        return q;
    }
    
    @Override
    public int hashCode() {
        return System.identityHashCode(this.g) + this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        final Bb4 bb4 = (Bb4)o;
        return this.g == bb4.g && this.d == bb4.d;
    }
    
    public static Bb4 g(final String s) {
        final int index = s.indexOf(58);
        if (index < 0) {
            throw new IllegalArgumentException("Cannot decode GameEntityId " + s + " - expected format TYPENAME:12345");
        }
        final String trim = s.substring(0, index).trim();
        if (trim.isEmpty()) {
            throw new IllegalArgumentException("Cannot decode GameEntityId " + s + " - expected format TYPENAME:12345");
        }
        final Bc288 w = Bz650.w(trim);
        final String trim2 = s.substring(index + 1).trim();
        if (!StringTools.d(trim2)) {
            throw new IllegalArgumentException("Cannot decode GameEntityId " + s + " - expected format TYPENAME:12345");
        }
        final int j = StringTools.j(trim2);
        if ((j & 0xFFFF) != j) {
            throw new IllegalArgumentException("Cannot decode GameEntityId " + s + " - number is out of range");
        }
        return new Bb4(w, j);
    }
    
    public static void d(final Bb4 bb4) {
        if (Ba115.q(bb4.g)) {
            Ba115.j(bb4.g).l(bb4);
        }
    }
    
    public static Bb4 e(final Gg3 gg3, final Bc288 bc288) {
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
    
    public static Bb4 s(final int i) {
        if ((i & 0xFFFFFF) != i) {
            throw new IllegalArgumentException("Invalid int24: " + i);
        }
        return new Bb4(Bz650.l(i >> 16), i & 0xFFFF);
    }
    
    public static Bb4 j(final Gg3 gg3) {
        return new Bb4(Bz650.l(Gg3.ar(gg3)), Gg3.au(gg3));
    }
    
    Bb4(final Bc288 g, final int d) {
        this.g = g;
        this.d = d;
        if (this.g == null) {
            throw new IllegalArgumentException();
        }
        if ((this.d & 0xFFFF) != this.d) {
            throw new IllegalArgumentException();
        }
    }
    
    public void q(final Gg3 gg3) {
        if (!Bz650.b(this.g)) {
            throw new IllegalArgumentException("Client-side GameEntityId " + this + " cannot be sent to server");
        }
        Gg3.k(gg3, this.g.ordinal());
        Gg3.i(gg3, this.d);
    }
}
