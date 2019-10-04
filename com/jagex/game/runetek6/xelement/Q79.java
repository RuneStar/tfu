/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import tfu.Gg3;

public class Q79 {
    private Map d;
    private Vector g;

    public static void j(Q79 q79, Gg3 gg3) {
        Gg3.i(gg3, q79.g.size());
        for (String string : q79.g) {
            Gg3.ao(gg3, string);
        }
    }

    public Q79(int n) {
        this.g = new Vector(n);
        this.d = new HashMap(n);
    }

    private Q79(List list) {
        this(list.size());
        int n = list.size();
        for (int i = 0; i < n; ++i) {
            String string = (String)list.get(i);
            this.d.put(string, i);
            this.g.add(string);
        }
    }

    public static Q79 e(Gg3 gg3) {
        Vector<String> vector = new Vector<String>();
        int n = Gg3.au(gg3);
        for (int i = 0; i < n; ++i) {
            String string = gg3.bp();
            vector.add(string);
        }
        return new Q79(vector);
    }

    public static int d(Q79 q79, String string) {
        Integer n = (Integer)q79.d.get(string);
        if (n == null) {
            n = q79.g.size();
            q79.d.put(string, n);
            q79.g.add(string);
        }
        return n;
    }

    public static String q(Q79 q79, int n) {
        return (String)q79.g.get(n);
    }

    public Q79() {
        this(4);
    }

    public static void g(Q79 q79, String string) {
        if (!q79.d.containsKey(string)) {
            q79.d.put(string, q79.g.size());
            q79.g.add(string);
        }
    }
}

