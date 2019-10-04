/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Bn279;
import tfu.Br121;
import tfu.Bu350;
import tfu.Bv351;
import tfu.Gg3;
import tfu.Hc416;
import tfu.Hm417;
import tfu.Hp62;
import tfu.Hz419;
import tfu.Ia63;
import tfu.Ib29;
import tfu.Ij60;
import tfu.Ik357;
import tfu.In418;
import tfu.Iq422;
import tfu.Ir421;
import tfu.Mz200;

public class Hi86 {
    private static final Logger logger = LoggerFactory.getLogger(Hi86.class);
    private static final boolean q = false;
    private final Bu350 b;
    final In418 e;
    private Map g = new HashMap();
    final Bu350 h;
    private final Class j;
    private final Bu350 l;
    private final Map r;
    final Bu350 s;
    private final Map v;
    private final Map w;
    private final Map y;

    public Bn279 e(Class class_, Object object, int n, Bv351 bv351, Object object2) {
        Hc416 hc416 = new Hc416(this, class_, object, n, null);
        return this.b.g(hc416, bv351, object2);
    }

    public static void d(Hi86 hi86, Gg3 gg3) {
        int n = Gg3.ar(gg3);
        for (int i = 0; i < n; ++i) {
            String string = gg3.bh();
            String string2 = gg3.bh();
            string = string.toLowerCase();
            string2 = string2.toLowerCase();
            for (Class class_ : hi86.v.keySet()) {
                Ib29 ib29 = (Ib29)hi86.v.get(class_);
                String string3 = ib29.getIdentifier();
                if (string3 == null || !(string3 = string3.toLowerCase()).equals(string)) continue;
                Object object = ib29.getResourceAddress(string2);
                Hi86.g(hi86, class_, object);
            }
        }
    }

    public Hi86(Class class_) {
        this.e = new In418();
        this.h = new Bu350("Resource Manager Provider Thread");
        this.s = new Bu350("Resource Manager Constructor Thread");
        this.b = new Bu350("Resource Manager Loader Thread");
        this.l = new Bu350("Resource Manager Loader and Combiner Thread");
        this.w = new HashMap();
        this.r = new HashMap();
        this.v = new HashMap();
        this.y = new HashMap();
        this.j = class_;
    }

    public static void q(Hi86 hi86) {
        hi86.e.g();
    }

    public Hp62 j(Class class_, Object object) throws Ik357 {
        Hm417 hm417 = new Hm417(class_, object);
        try {
            Hp62 hp62 = this.e.j(hm417, null);
            if (hp62 != null) {
                return hp62;
            }
            Ib29 ib29 = Hi86.y(this, class_);
            Ia63 ia63 = Hi86.x(this, class_);
            byte[] arrby = ib29.getData(object);
            hp62 = ia63.constructResource(arrby, object, this);
            this.e.e(hm417, hp62, ia63);
            return hp62;
        }
        catch (Throwable throwable) {
            this.e.h(hm417, throwable);
            Object v = this.g.get(class_);
            if (v == null || v.equals(object)) {
                if (throwable instanceof Ik357) {
                    throw (Ik357)throwable;
                }
                if (throwable instanceof RuntimeException) {
                    throw (RuntimeException)throwable;
                }
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                throw new RuntimeException(throwable);
            }
            return this.j(class_, v);
        }
    }

    public Bn279 b(Class class_, Class class_2, Object[] arrobject, Ir421 ir421, int n, Bv351 bv351, Object object) {
        Iq422 iq422 = new Iq422(this, class_, class_2, arrobject, ir421, n, null);
        return this.l.g(iq422, bv351, object);
    }

    public static void g(Hi86 hi86, Class class_, Object object) {
        hi86.g.put(class_, object);
    }

    public static void w(Hi86 hi86) {
        hi86.b.d();
    }

    public static void r(Hi86 hi86, Class class_, Ij60 ij60) {
        hi86.r.put(class_, ij60);
    }

    static /* synthetic */ Map t(Hi86 hi86) {
        return hi86.g;
    }

    public static List v(Hi86 hi86, Class class_) {
        Ij60 ij60 = (Ij60)hi86.r.get(class_);
        if (ij60 == null) {
            return Collections.emptyList();
        }
        return ij60.getAddresses();
    }

    public static void p(Hi86 hi86, Class class_, Ib29 ib29) {
        hi86.v.put(class_, ib29);
    }

    public static Ia63 x(Hi86 hi86, Class class_) {
        return (Ia63)hi86.y.get(class_);
    }

    public static void u(Hi86 hi86, Class class_, Ia63 ia63) {
        hi86.y.put(class_, ia63);
    }

    public static Ib29 y(Hi86 hi86, Class class_) {
        return (Ib29)hi86.v.get(class_);
    }

    static /* synthetic */ Logger z() {
        return logger;
    }

    public static void l(Hi86 hi86, Hp62 hp62) {
        hi86.e.s(hp62);
    }

    public static Bn279 s(Hi86 hi86, Class class_, Class class_2, Collection collection, Ir421 ir421, int n, Bv351 bv351, Object object) {
        Object[] arrobject = collection.toArray((Object[])Array.newInstance(hi86.j, collection.size()));
        return hi86.b(class_, class_2, arrobject, ir421, n, bv351, object);
    }

    public Bn279 h(Class class_, Object object, Mz200 mz200, Bv351 bv351, Object object2) {
        Hc416 hc416 = new Hc416(this, class_, object, 0, mz200);
        return this.b.g(hc416, bv351, object2);
    }
}

