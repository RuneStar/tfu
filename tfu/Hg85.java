/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.HashMap;
import java.util.Map;
import tfu.He426;
import tfu.Iy427;

public class Hg85 {
    private Map d;
    private Map g = new HashMap();

    public Object[] g(Class class_, Class class_2, Object object) {
        Iy427 iy427 = (Iy427)this.d.get(class_);
        if (iy427 == null) {
            throw new RuntimeException("");
        }
        He426 he426 = (He426)this.g.get(class_2);
        if (he426 == null) {
            throw new RuntimeException("");
        }
        return he426.g(object, iy427);
    }

    public Hg85() {
        this.d = new HashMap();
    }
}

