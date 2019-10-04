/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.HashMap;
import java.util.Map;
import tfu.Ip424;

public final class Hk84 {
    private Map g = new HashMap();

    public static int g(Hk84 hk84, Class class_, Object object) {
        Ip424 ip424 = (Ip424)hk84.g.get(class_);
        return ip424.d(object);
    }

    public static void d(Hk84 hk84, Class class_, Ip424 ip424) {
        hk84.g.put(class_, ip424);
    }
}

