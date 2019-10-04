// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.HashMap;

public final class Bz650
{
    static boolean d;
    private static HashMap j;
    private static final Logger logger;
    private static Bc288[] q;
    
    public static void j(final Bc288 bc288) {
        if (Bz650.q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        if (Bz650.q[bc288.ordinal()] != bc288) {
            if (Bz650.q[bc288.ordinal()] != null) {
                throw new IllegalArgumentException(bc288.ordinal() + " used for both " + Bz650.q[bc288.ordinal()].name() + " and " + bc288.name());
            }
            Bz650.q[bc288.ordinal()] = bc288;
        }
        h(bc288);
    }
    
    public static void g(final boolean d) {
        if (Bz650.q != null) {
            throw new IllegalStateException("GameEntityIdTypes.init() called twice!");
        }
        Bz650.q = new Bc288[256];
        Bz650.j = new HashMap();
        Bz650.d = d;
        Bz650.logger.info(Bz650.d ? "Simulating worst-case bandwidth" : "Optimising for bandwidth (worst-case simulation is off)");
    }
    
    public static void d(final Bc288... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            j(array[i]);
        }
    }
    
    private static String s(final Bc288 bc288) {
        return bc288.toString() + "(" + bc288.getClass().getSimpleName() + "@" + System.identityHashCode(bc288) + ")";
    }
    
    public static void e(final Bc288 bc288) {
        if (Bz650.q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        h(bc288);
    }
    
    static boolean b(final Bc288 bc288) {
        if (Bz650.q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        return (bc288.ordinal() & 0xFF) == bc288.ordinal() && Bz650.q[bc288.ordinal()] == bc288;
    }
    
    public static void q(final Bc288... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            e(array[i]);
        }
    }
    
    static Bc288 w(final String str) {
        if (Bz650.q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        final Bc288 bc288 = Bz650.j.get(str.toLowerCase());
        if (bc288 != null) {
            return bc288;
        }
        throw new IllegalArgumentException("GameEntityIdType " + str + " is not a valid type.");
    }
    
    static {
        logger = LoggerFactory.getLogger(Bz650.class);
    }
    
    static Bc288 l(final int i) {
        if (Bz650.q == null) {
            throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
        }
        if ((i & 0xFF) == i) {
            final Bc288 bc288 = Bz650.q[i];
            if (bc288 != null) {
                return bc288;
            }
        }
        throw new IllegalArgumentException("GameEntityIdType " + i + " is not a valid server-generated type.");
    }
    
    private static void h(final Bc288 value) {
        final String lowerCase = value.name().toLowerCase();
        if (Bz650.j.get(lowerCase) != value) {
            if (Bz650.j.get(lowerCase) != null) {
                throw new IllegalArgumentException(value.name() + " used for both " + s((Bc288)Bz650.j.get(lowerCase)) + " and " + s(value));
            }
            Bz650.j.put(lowerCase, value);
        }
    }
}
