/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Bc288;

public final class Bz650 {
    static boolean d;
    private static HashMap j;
    private static final Logger logger;
    private static Bc288[] q;

    public static void j(Bc288 bc288) {
        if (q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        if (q[bc288.ordinal()] != bc288) {
            if (q[bc288.ordinal()] != null) {
                throw new IllegalArgumentException(bc288.ordinal() + " used for both " + q[bc288.ordinal()].name() + " and " + bc288.name());
            }
            Bz650.q[bc288.ordinal()] = bc288;
        }
        Bz650.h(bc288);
    }

    public static void g(boolean bl) {
        if (q != null) {
            throw new IllegalStateException("GameEntityIdTypes.init() called twice!");
        }
        q = new Bc288[256];
        j = new HashMap();
        d = bl;
        logger.info(d ? "Simulating worst-case bandwidth" : "Optimising for bandwidth (worst-case simulation is off)");
    }

    public static void d(Bc288 ... arrbc288) {
        for (Bc288 bc288 : arrbc288) {
            Bz650.j(bc288);
        }
    }

    private static String s(Bc288 bc288) {
        return bc288.toString() + "(" + bc288.getClass().getSimpleName() + "@" + System.identityHashCode(bc288) + ")";
    }

    public static void e(Bc288 bc288) {
        if (q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        Bz650.h(bc288);
    }

    static boolean b(Bc288 bc288) {
        if (q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        return (bc288.ordinal() & 0xFF) == bc288.ordinal() && q[bc288.ordinal()] == bc288;
    }

    public static void q(Bc288 ... arrbc288) {
        for (Bc288 bc288 : arrbc288) {
            Bz650.e(bc288);
        }
    }

    static Bc288 w(String string) {
        if (q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        String string2 = string.toLowerCase();
        Bc288 bc288 = (Bc288)j.get(string2);
        if (bc288 != null) {
            return bc288;
        }
        throw new IllegalArgumentException("GameEntityIdType " + string + " is not a valid type.");
    }

    static {
        logger = LoggerFactory.getLogger(Bz650.class);
    }

    static Bc288 l(int n) {
        Bc288 bc288;
        if (q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        if ((n & 0xFF) == n && (bc288 = q[n]) != null) {
            return bc288;
        }
        throw new IllegalArgumentException("GameEntityIdType " + n + " is not a valid server-generated type.");
    }

    private static void h(Bc288 bc288) {
        String string = bc288.name().toLowerCase();
        if (j.get(string) != bc288) {
            if (j.get(string) != null) {
                throw new IllegalArgumentException(bc288.name() + " used for both " + Bz650.s((Bc288)j.get(string)) + " and " + Bz650.s(bc288));
            }
            j.put(string, bc288);
        }
    }
}

