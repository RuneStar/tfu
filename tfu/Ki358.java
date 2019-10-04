// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.HashSet;

public final class Ki358
{
    private static HashSet g;
    
    public static Object g(final Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Kl267) {
            return ((Kl267)o).q();
        }
        if (Ki358.g.contains(o.getClass())) {
            return o;
        }
        throw new IllegalArgumentException("Unsupported type: " + o.getClass());
    }
    
    static {
        (Ki358.g = new HashSet()).add(Byte.class);
        Ki358.g.add(Short.class);
        Ki358.g.add(Character.class);
        Ki358.g.add(Integer.class);
        Ki358.g.add(Long.class);
        Ki358.g.add(Float.class);
        Ki358.g.add(Double.class);
        Ki358.g.add(Boolean.class);
        Ki358.g.add(String.class);
    }
}
