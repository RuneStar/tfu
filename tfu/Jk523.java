// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Jk523
{
    public Object d;
    public Object g;
    
    @Override
    public String toString() {
        return this.g + ", " + this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof Jk523)) {
            return false;
        }
        final Jk523 jk523 = (Jk523)o;
        if (this.g == null) {
            if (jk523.g != null) {
                return false;
            }
        }
        else if (!this.g.equals(jk523.g)) {
            return false;
        }
        if (this.d == null) {
            if (jk523.d != null) {
                return false;
            }
        }
        else if (!this.d.equals(jk523.d)) {
            return false;
        }
        return true;
    }
    
    @Override
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
    
    public Jk523(final Object g, final Object d) {
        this.g = g;
        this.d = d;
    }
}
