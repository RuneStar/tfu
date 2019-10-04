// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import org.slf4j.Logger;
import java.util.concurrent.ConcurrentHashMap;

public class Z132
{
    public static final String d = "PACKAGE_";
    public static final String g = "LOAD_";
    private static ConcurrentHashMap j;
    private static final Logger logger;
    
    public static synchronized void g(final String s) {
        d(s, "");
    }
    
    public static synchronized void q(final String key) {
        if (!Z132.j.containsKey(key)) {
            Z132.logger.error("Event " + key + " cannot be found!");
            return;
        }
        X513.q(Z132.j.get(key));
    }
    
    public static synchronized String[][] j() {
        final int size = Z132.j.size();
        final ArrayList list = new ArrayList<D222>(size);
        for (final Map.Entry<K, X513> entry : Z132.j.entrySet()) {
            list.add((T)new D222((String)entry.getKey(), X513.b(entry.getValue()), X513.s(entry.getValue()), entry.getValue().h()));
        }
        Collections.sort((List<Object>)list, D222.q);
        final String[][] array = new String[size][4];
        int n = size;
        for (final D222 d222 : list) {
            array[--n][0] = d222.j;
            array[n][1] = String.format("%1.3f", d222.h * 0.001f);
            array[n][2] = String.format("%1.3f", d222.s * 0.001f);
            array[n][3] = d222.e;
        }
        return array;
    }
    
    public static synchronized void d(final String key, final String s) {
        if (Z132.j.containsKey(key)) {
            Z132.logger.error("Event " + key + " is started already!");
        }
        final X513 value = new X513();
        X513.d(value);
        X513.e(value, s);
        Z132.j.put(key, value);
    }
    
    static {
        logger = LoggerFactory.getLogger(Z132.class);
        Z132.j = new ConcurrentHashMap();
    }
}
