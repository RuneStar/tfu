// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.core.constants;

import java.util.HashMap;
import java.util.Map;

public class E294
{
    private static Map g;
    
    public static J204 d(final J204[] array, final int n) {
        for (final J204 j204 : array) {
            if (n == j204.getId()) {
                return j204;
            }
        }
        return null;
    }
    
    public static J204 g(final Class clazz, final int i) {
        synchronized (E294.g) {
            Map<Integer, J204> map = E294.g.get(clazz);
            if (map == null) {
                map = new HashMap<Integer, J204>();
                for (final J204 j2 : clazz.getEnumConstants()) {
                    map.put(j2.getId(), j2);
                }
                E294.g.put(clazz, map);
            }
            return map.get(i);
        }
    }
    
    static {
        E294.g = new HashMap();
    }
}
