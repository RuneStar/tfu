/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.HashSet;
import tfu.Kl267;

public final class Ki358 {
    private static HashSet g = new HashSet();

    public static Object g(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Kl267) {
            Kl267 kl267 = (Kl267)object;
            return kl267.q();
        }
        if (g.contains(object.getClass())) {
            return object;
        }
        throw new IllegalArgumentException("Unsupported type: " + object.getClass());
    }

    static {
        g.add(Byte.class);
        g.add(Short.class);
        g.add(Character.class);
        g.add(Integer.class);
        g.add(Long.class);
        g.add(Float.class);
        g.add(Double.class);
        g.add(Boolean.class);
        g.add(String.class);
    }
}

