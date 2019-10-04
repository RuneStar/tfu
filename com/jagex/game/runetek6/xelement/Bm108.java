// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Gg3;
import javax.xml.namespace.QName;

public abstract class Bm108
{
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
    
    Bm108(final Ag97 w, final Object r) {
        this.w = w;
        this.r = r;
    }
    
    public abstract void d(final Gg3 p0);
    
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
