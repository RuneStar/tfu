// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Js343
{
    public final Object d;
    public final Object q;
    
    @Override
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof Js343)) {
            return false;
        }
        final Js343 js343 = (Js343)o;
        if (this.d == null) {
            if (js343.d != null) {
                return false;
            }
        }
        else if (!this.d.equals(js343.d)) {
            return false;
        }
        if (this.q == null) {
            if (js343.q != null) {
                return false;
            }
        }
        else if (!this.q.equals(js343.q)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.d + ", " + this.q;
    }
    
    public Js343(final Object d, final Object q) {
        this.d = d;
        this.q = q;
    }
    
    @Override
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
