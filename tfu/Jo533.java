/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.HashMap;
import tfu.Jl526;
import tfu.Jy122;

public class Jo533 {
    private static final HashMap g = new HashMap();

    private static Jl526 g(String string) {
        Jl526 jl526 = (Jl526)g.get(string);
        if (jl526 == null) {
            jl526 = new Jl526();
            g.put(string, jl526);
        }
        return jl526;
    }

    public static void d(Jy122 jy122, String string, String string2) {
        Jl526 jl526 = Jo533.g(string);
        if (Jl526.g(jl526, string2)) {
            Jy122.s(jy122, string2);
        }
    }
}

