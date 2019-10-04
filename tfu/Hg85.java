// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.HashMap;
import java.util.Map;

public class Hg85
{
    private Map d;
    private Map g;
    
    public Object[] g(final Class clazz, final Class clazz2, final Object o) {
        final Iy427 iy427 = this.d.get(clazz);
        if (iy427 == null) {
            throw new RuntimeException("");
        }
        final He426 he426 = this.g.get(clazz2);
        if (he426 == null) {
            throw new RuntimeException("");
        }
        return he426.g(o, iy427);
    }
    
    public Hg85() {
        this.g = new HashMap();
        this.d = new HashMap();
    }
}
