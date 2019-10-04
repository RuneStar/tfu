/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tfu.Kf58;
import tfu.Kr260;
import tfu.Mn54;

public class Ma57
implements Mn54 {
    protected final Kf58 d;
    protected Map g;

    @Override
    public int d(int n) {
        Kr260 kr260;
        if (this.g != null && (kr260 = (Kr260)this.g.get(n)) != null) {
            return (Integer)kr260.d;
        }
        return (Integer)this.d.getDefaultValue(n);
    }

    @Override
    public void q(int n, int n2) {
        if (this.g == null) {
            this.g = new HashMap();
            this.g.put(n, new Kr260(n, n2));
        } else {
            Kr260 kr260 = (Kr260)this.g.get(n);
            if (kr260 == null) {
                this.g.put(n, new Kr260(n, n2));
            } else {
                kr260.d = n2;
            }
        }
    }

    @Override
    public long j(int n) {
        Kr260 kr260;
        if (this.g != null && (kr260 = (Kr260)this.g.get(n)) != null) {
            return (Long)kr260.d;
        }
        return (Long)this.d.getDefaultValue(n);
    }

    @Override
    public void b() {
        if (this.g != null) {
            this.g.clear();
        }
    }

    @Override
    public Object h(int n) {
        Kr260 kr260;
        if (this.g != null && (kr260 = (Kr260)this.g.get(n)) != null) {
            return kr260.d;
        }
        return this.d.getDefaultValue(n);
    }

    @Override
    public void s(int n, Object object) {
        if (this.g == null) {
            this.g = new HashMap();
            this.g.put(n, new Kr260(n, object));
        } else {
            Kr260 kr260 = (Kr260)this.g.get(n);
            if (kr260 == null) {
                this.g.put(n, new Kr260(n, object));
            } else {
                kr260.d = object;
            }
        }
    }

    public Ma57(Kf58 kf58) {
        this.d = kf58;
    }

    @Override
    public void l(int n) {
        if (this.g != null) {
            this.g.remove(n);
        }
    }

    public Iterator iterator() {
        if (this.g == null) {
            return Collections.emptyList().iterator();
        }
        return this.g.values().iterator();
    }

    @Override
    public void e(int n, long l) {
        if (this.g == null) {
            this.g = new HashMap();
            this.g.put(n, new Kr260(n, l));
        } else {
            Kr260 kr260 = (Kr260)this.g.get(n);
            if (kr260 == null) {
                this.g.put(n, new Kr260(n, l));
            } else {
                kr260.d = l;
            }
        }
    }
}

