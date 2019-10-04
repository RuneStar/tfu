/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jl526 {
    private String d;
    private final Logger logger = LoggerFactory.getLogger(Jl526.class);

    public static boolean g(Jl526 jl526, String string) {
        if (!string.equals(jl526.d)) {
            jl526.d = string;
            return true;
        }
        return false;
    }

    public Jl526() {
        this.d = new String();
    }
}

