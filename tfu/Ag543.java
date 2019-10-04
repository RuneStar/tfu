// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Ag543 implements Comparable
{
    public final int d;
    public final int g;
    public final int q;
    
    public Ag543(final Ag543 ag543) {
        this.g = ag543.g;
        this.d = ag543.d;
        this.q = ag543.q;
    }
    
    public Ag543(final int g, final int d, final int q) {
        this.g = g;
        this.d = d;
        this.q = q;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof Ag543 && g(this, (Ag543)o) == 0;
    }
    
    @Override
    public int hashCode() {
        return this.g + this.d + this.q;
    }
    
    public static int g(final Ag543 ag543, final Ag543 ag544) {
        final float n = (float)(ag543.g - ag544.g);
        if (n != 0.0f) {
            return (n > 0.0f) ? 1 : -1;
        }
        final float n2 = (float)(ag543.d - ag544.d);
        if (n2 != 0.0f) {
            return (n2 > 0.0f) ? 1 : -1;
        }
        final float n3 = (float)(ag543.q - ag544.q);
        if (n3 != 0.0f) {
            return (n3 > 0.0f) ? 1 : -1;
        }
        return 0;
    }
}
