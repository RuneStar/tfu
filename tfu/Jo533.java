// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.HashMap;

public class Jo533
{
    private static final HashMap g;
    
    private static Jl526 g(final String s) {
        Jl526 value = Jo533.g.get(s);
        if (value == null) {
            value = new Jl526();
            Jo533.g.put(s, value);
        }
        return value;
    }
    
    public static void d(final Jy122 jy122, final String s, final String s2) {
        if (Jl526.g(g(s), s2)) {
            Jy122.s(jy122, s2);
        }
    }
    
    static {
        g = new HashMap();
    }
}
