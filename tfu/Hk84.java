// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.HashMap;
import java.util.Map;

public final class Hk84
{
    private Map g;
    
    public static int g(final Hk84 hk84, final Class clazz, final Object o) {
        return hk84.g.get(clazz).d(o);
    }
    
    public static void d(final Hk84 hk84, final Class clazz, final Ip424 ip424) {
        hk84.g.put(clazz, ip424);
    }
    
    public Hk84() {
        this.g = new HashMap();
    }
}
