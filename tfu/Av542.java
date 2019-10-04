// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

final class Av542 extends Js343
{
    final /* synthetic */ Ah536 g;
    
    @Override
    public int hashCode() {
        int n = 0;
        if (super.d != null) {
            n += ((String)super.d).toLowerCase().hashCode();
        }
        if (super.q != null) {
            n += 31 * ((String)super.q).toLowerCase().hashCode();
        }
        return n;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof Js343)) {
            return false;
        }
        final Av542 av542 = (Av542)o;
        if (super.d == null) {
            if (av542.d != null) {
                return false;
            }
        }
        else if (!((String)super.d).equalsIgnoreCase((String)av542.d)) {
            return false;
        }
        if (super.q == null) {
            if (av542.q != null) {
                return false;
            }
        }
        else if (!((String)super.q).equalsIgnoreCase((String)av542.q)) {
            return false;
        }
        return true;
    }
    
    public Av542(final Ah536 g, final String s, final String s2) {
        super(s, s2);
        this.g = g;
    }
}
