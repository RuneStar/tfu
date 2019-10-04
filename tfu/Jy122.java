// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.Logger;

public class Jy122
{
    public static final int d = 1;
    public static final int g = 0;
    public static final int j = 3;
    public static final int q = 2;
    protected final int b;
    protected String e;
    protected int h;
    protected final StringBuilder l;
    protected final Logger logger;
    
    public Jy122(final Logger logger, final int b) {
        this.e = "# ";
        this.h = 0;
        this.l = new StringBuilder();
        this.logger = logger;
        this.b = b;
    }
    
    public static boolean g(final Jy122 jy122) {
        return jy122.logger.isTraceEnabled();
    }
    
    public static void d(final Jy122 jy122, final String e) {
        jy122.e = e;
    }
    
    public static void h(final Jy122 jy122, final String str) {
        q(jy122);
        r(jy122);
        jy122.l.append(str);
        e(jy122);
    }
    
    public static void j(final Jy122 jy122) {
        if (jy122.h > 0) {
            --jy122.h;
        }
    }
    
    protected static void e(final Jy122 jy122) {
        if (jy122.b == 3) {
            jy122.logger.warn(jy122.l.toString());
        }
        else if (jy122.b == 2) {
            jy122.logger.info(jy122.l.toString());
        }
        else if (jy122.b == 1) {
            jy122.logger.debug(jy122.l.toString());
        }
        else {
            jy122.logger.trace(jy122.l.toString());
        }
        jy122.l.setLength(0);
    }
    
    public static void b(final Jy122 jy122, final String s) {
        h(jy122, s);
        j(jy122);
    }
    
    public static void l(final Jy122 jy122, final String str) {
        w(jy122);
        jy122.l.append(str);
        e(jy122);
        j(jy122);
    }
    
    protected static void r(final Jy122 jy122) {
        jy122.l.append(jy122.e);
        for (int i = 1; i < jy122.h - 1; ++i) {
            jy122.l.append(" |   ");
        }
        if (jy122.h > 1) {
            jy122.l.append(" +---");
        }
    }
    
    protected static void w(final Jy122 jy122) {
        jy122.l.append(jy122.e);
        for (int i = 1; i < jy122.h; ++i) {
            jy122.l.append(" |   ");
        }
    }
    
    public static void q(final Jy122 jy122) {
        ++jy122.h;
    }
    
    public static void s(final Jy122 jy122, final String str) {
        w(jy122);
        jy122.l.append(str);
        e(jy122);
    }
    
    public Jy122(final Logger logger) {
        this.e = "# ";
        this.h = 0;
        this.l = new StringBuilder();
        this.logger = logger;
        this.b = 0;
    }
}
