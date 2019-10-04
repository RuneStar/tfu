// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.reflect.Array;
import java.util.Collection;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Logger;

public class Hi86
{
    private static final Logger logger;
    private static final boolean q = false;
    private final Bu350 b;
    final In418 e;
    private Map g;
    final Bu350 h;
    private final Class j;
    private final Bu350 l;
    private final Map r;
    final Bu350 s;
    private final Map v;
    private final Map w;
    private final Map y;
    
    public Bn279 e(final Class clazz, final Object o, final int n, final Bv351 bv351, final Object o2) {
        return this.b.g(new Hc416(this, clazz, o, n, null), bv351, o2);
    }
    
    public static void d(final Hi86 hi86, final Gg3 gg3) {
        for (int ar = Gg3.ar(gg3), i = 0; i < ar; ++i) {
            final String bh = gg3.bh();
            final String bh2 = gg3.bh();
            final String lowerCase = bh.toLowerCase();
            final String lowerCase2 = bh2.toLowerCase();
            for (final Class clazz : hi86.v.keySet()) {
                final Ib29 ib29 = hi86.v.get(clazz);
                final String identifier = ib29.getIdentifier();
                if (identifier != null && identifier.toLowerCase().equals(lowerCase)) {
                    g(hi86, clazz, ib29.getResourceAddress(lowerCase2));
                }
            }
        }
    }
    
    public Hi86(final Class j) {
        this.g = new HashMap();
        this.e = new In418();
        this.h = new Bu350("Resource Manager Provider Thread");
        this.s = new Bu350("Resource Manager Constructor Thread");
        this.b = new Bu350("Resource Manager Loader Thread");
        this.l = new Bu350("Resource Manager Loader and Combiner Thread");
        this.w = new HashMap();
        this.r = new HashMap();
        this.v = new HashMap();
        this.y = new HashMap();
        this.j = j;
    }
    
    public static void q(final Hi86 hi86) {
        hi86.e.g();
    }
    
    public Hp62 j(final Class clazz, final Object obj) throws Ik357 {
        final Hm417 hm417 = new Hm417(clazz, obj);
        try {
            final Hp62 j = this.e.j(hm417, null);
            if (j != null) {
                return j;
            }
            final Ib29 y = y(this, clazz);
            final Ia63 x = x(this, clazz);
            final Hp62 constructResource = x.constructResource(y.getData(obj), obj, this);
            this.e.e(hm417, constructResource, x);
            return constructResource;
        }
        catch (Throwable cause) {
            this.e.h(hm417, cause);
            final Object value = this.g.get(clazz);
            if (value != null && !value.equals(obj)) {
                return this.j(clazz, value);
            }
            if (cause instanceof Ik357) {
                throw (Ik357)cause;
            }
            if (cause instanceof RuntimeException) {
                throw (RuntimeException)cause;
            }
            if (cause instanceof Error) {
                throw (Error)cause;
            }
            throw new RuntimeException(cause);
        }
    }
    
    public Bn279 b(final Class clazz, final Class clazz2, final Object[] array, final Ir421 ir421, final int n, final Bv351 bv351, final Object o) {
        return this.l.g(new Iq422(this, clazz, clazz2, array, ir421, n, null), bv351, o);
    }
    
    public static void g(final Hi86 hi86, final Class clazz, final Object o) {
        hi86.g.put(clazz, o);
    }
    
    public static void w(final Hi86 hi86) {
        hi86.b.d();
    }
    
    public static void r(final Hi86 hi86, final Class clazz, final Ij60 ij60) {
        hi86.r.put(clazz, ij60);
    }
    
    public static List v(final Hi86 hi86, final Class clazz) {
        final Ij60 ij60 = hi86.r.get(clazz);
        if (ij60 == null) {
            return Collections.emptyList();
        }
        return ij60.getAddresses();
    }
    
    public static void p(final Hi86 hi86, final Class clazz, final Ib29 ib29) {
        hi86.v.put(clazz, ib29);
    }
    
    public static Ia63 x(final Hi86 hi86, final Class clazz) {
        return hi86.y.get(clazz);
    }
    
    public static void u(final Hi86 hi86, final Class clazz, final Ia63 ia63) {
        hi86.y.put(clazz, ia63);
    }
    
    public static Ib29 y(final Hi86 hi86, final Class clazz) {
        return hi86.v.get(clazz);
    }
    
    static {
        logger = LoggerFactory.getLogger(Hi86.class);
    }
    
    public static void l(final Hi86 hi86, final Hp62 hp62) {
        hi86.e.s(hp62);
    }
    
    public static Bn279 s(final Hi86 hi86, final Class clazz, final Class clazz2, final Collection collection, final Ir421 ir421, final int n, final Bv351 bv351, final Object o) {
        return hi86.b(clazz, clazz2, collection.toArray((Object[])Array.newInstance(hi86.j, collection.size())), ir421, n, bv351, o);
    }
    
    public Bn279 h(final Class clazz, final Object o, final Mz200 mz200, final Bv351 bv351, final Object o2) {
        return this.b.g(new Hc416(this, clazz, o, 0, mz200), bv351, o2);
    }
}
