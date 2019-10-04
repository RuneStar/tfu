/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.core.constants;

import com.jagex.core.constants.J204;
import java.util.HashMap;
import java.util.Map;

public class E294 {
    private static Map g = new HashMap();

    public static J204 d(J204[] arrj204, int n) {
        for (J204 j204 : arrj204) {
            if (n != j204.getId()) continue;
            return j204;
        }
        return null;
    }

    public static J204 g(Class class_, int n) {
        Map map = g;
        synchronized (map) {
            HashMap<Integer, J204> hashMap = (HashMap<Integer, J204>)g.get(class_);
            if (hashMap == null) {
                hashMap = new HashMap<Integer, J204>();
                for (J204 j204 : (J204[])class_.getEnumConstants()) {
                    hashMap.put(j204.getId(), j204);
                }
                g.put(class_, hashMap);
            }
            return (J204)hashMap.get(n);
        }
    }
}

