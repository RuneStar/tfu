// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import tfu.Gg3;
import java.util.Vector;
import java.util.Map;

public class Q79
{
    private Map d;
    private Vector g;
    
    public static void j(final Q79 q79, final Gg3 gg3) {
        Gg3.i(gg3, q79.g.size());
        final Iterator<String> iterator = q79.g.iterator();
        while (iterator.hasNext()) {
            Gg3.ao(gg3, iterator.next());
        }
    }
    
    public Q79(final int n) {
        this.g = new Vector(n);
        this.d = new HashMap(n);
    }
    
    private Q79(final List list) {
        this(list.size());
        for (int size = list.size(), i = 0; i < size; ++i) {
            final String e = list.get(i);
            this.d.put(e, i);
            this.g.add(e);
        }
    }
    
    public static Q79 e(final Gg3 gg3) {
        final Vector<String> vector = new Vector<String>();
        for (int au = Gg3.au(gg3), i = 0; i < au; ++i) {
            vector.add(gg3.bp());
        }
        return new Q79(vector);
    }
    
    public static int d(final Q79 q79, final String e) {
        Integer value = q79.d.get(e);
        if (value == null) {
            value = q79.g.size();
            q79.d.put(e, value);
            q79.g.add(e);
        }
        return value;
    }
    
    public static String q(final Q79 q79, final int index) {
        return q79.g.get(index);
    }
    
    public Q79() {
        this(4);
    }
    
    public static void g(final Q79 q79, final String e) {
        if (!q79.d.containsKey(e)) {
            q79.d.put(e, q79.g.size());
            q79.g.add(e);
        }
    }
}
