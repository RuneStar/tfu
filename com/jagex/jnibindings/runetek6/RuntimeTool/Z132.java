/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.D222;
import com.jagex.jnibindings.runetek6.RuntimeTool.Q506;
import com.jagex.jnibindings.runetek6.RuntimeTool.X513;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Z132 {
    public static final String d = "PACKAGE_";
    public static final String g = "LOAD_";
    private static ConcurrentHashMap j;
    private static final Logger logger;

    public static synchronized void g(String string) {
        Z132.d(string, "");
    }

    public static synchronized void q(String string) {
        if (!j.containsKey(string)) {
            logger.error("Event " + string + " cannot be found!");
            return;
        }
        X513.q((X513)j.get(string));
    }

    public static synchronized String[][] j() {
        int n = j.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n);
        for (Map.Entry entry : j.entrySet()) {
            D222 d222 = new D222((String)entry.getKey(), X513.b((X513)entry.getValue()), X513.s((X513)entry.getValue()), ((X513)entry.getValue()).h());
            arrayList.add(d222);
        }
        Collections.sort(arrayList, D222.q);
        String[][] arrstring = new String[n][4];
        int n2 = n;
        for (D222 d222 : arrayList) {
            arrstring[--n2][0] = d222.j;
            arrstring[n2][1] = String.format("%1.3f", Float.valueOf((float)d222.h * 0.001f));
            arrstring[n2][2] = String.format("%1.3f", Float.valueOf((float)d222.s * 0.001f));
            arrstring[n2][3] = d222.e;
        }
        return arrstring;
    }

    public static synchronized void d(String string, String string2) {
        if (j.containsKey(string)) {
            logger.error("Event " + string + " is started already!");
        }
        X513 x513 = new X513();
        X513.d(x513);
        X513.e(x513, string2);
        j.put(string, x513);
    }

    static {
        logger = LoggerFactory.getLogger(Z132.class);
        j = new ConcurrentHashMap();
    }
}

