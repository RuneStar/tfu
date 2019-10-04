/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Ag97;
import javax.xml.namespace.QName;
import tfu.Gg3;

public abstract class Bm108 {
    public static final QName b;
    public static final QName d;
    public static final QName e;
    public static final QName g;
    public static final QName h;
    public static final QName j;
    public static final QName l;
    public static final QName q;
    public static final QName s;
    public final Object r;
    public final Ag97 w;

    Bm108(Ag97 ag97, Object object) {
        this.w = ag97;
        this.r = object;
    }

    public abstract void d(Gg3 var1);

    static {
        g = new QName("x");
        d = new QName("y");
        q = new QName("z");
        j = new QName("w");
        e = new QName("r");
        h = new QName("g");
        s = new QName("b");
        b = new QName("a");
        l = new QName("value");
    }
}

