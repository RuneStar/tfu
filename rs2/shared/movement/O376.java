// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import java.util.Arrays;

public class O376
{
    public final Object[] d;
    public final String g;
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof O376)) {
            return false;
        }
        final O376 o2 = (O376)o;
        return this.g.equals(o2.g) && Arrays.equals(this.d, o2.d);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.g + "(");
        int n = 1;
        for (final Object obj : this.d) {
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append(",");
            }
            sb.append(obj);
        }
        sb.append(")");
        return sb.toString();
    }
    
    public O376(final String g, final Object[] d) {
        this.g = g;
        this.d = d;
    }
}
