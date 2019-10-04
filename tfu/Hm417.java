/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Hm417 {
    final Class d;
    private final int g;
    private final Set q = new HashSet();

    public int hashCode() {
        return this.g;
    }

    Hm417(Class class_, Object[] arrobject) {
        this.d = class_;
        Collections.addAll(this.q, arrobject);
        int n = this.d.hashCode();
        for (Object object : arrobject) {
            n ^= object.hashCode();
        }
        this.g = n;
    }

    public boolean equals(Object object) {
        Hm417 hm417 = (Hm417)object;
        return this.d.equals(hm417.d) && ((Object)this.q).equals(hm417.q);
    }

    Hm417(Class class_, Object object) {
        this.d = class_;
        this.q.add(object);
        this.g = this.d.hashCode() ^ object.hashCode();
    }
}

