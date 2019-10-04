/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import org.slf4j.Logger;

public class Jy122 {
    public static final int d = 1;
    public static final int g = 0;
    public static final int j = 3;
    public static final int q = 2;
    protected final int b;
    protected String e = "# ";
    protected int h = 0;
    protected final StringBuilder l = new StringBuilder();
    protected final Logger logger;

    public Jy122(Logger logger, int n) {
        this.logger = logger;
        this.b = n;
    }

    public static boolean g(Jy122 jy122) {
        return jy122.logger.isTraceEnabled();
    }

    public static void d(Jy122 jy122, String string) {
        jy122.e = string;
    }

    public static void h(Jy122 jy122, String string) {
        Jy122.q(jy122);
        Jy122.r(jy122);
        jy122.l.append(string);
        Jy122.e(jy122);
    }

    public static void j(Jy122 jy122) {
        if (jy122.h > 0) {
            --jy122.h;
        }
    }

    protected static void e(Jy122 jy122) {
        if (jy122.b == 3) {
            jy122.logger.warn(jy122.l.toString());
        } else if (jy122.b == 2) {
            jy122.logger.info(jy122.l.toString());
        } else if (jy122.b == 1) {
            jy122.logger.debug(jy122.l.toString());
        } else {
            jy122.logger.trace(jy122.l.toString());
        }
        jy122.l.setLength(0);
    }

    public static void b(Jy122 jy122, String string) {
        Jy122.h(jy122, string);
        Jy122.j(jy122);
    }

    public static void l(Jy122 jy122, String string) {
        Jy122.w(jy122);
        jy122.l.append(string);
        Jy122.e(jy122);
        Jy122.j(jy122);
    }

    protected static void r(Jy122 jy122) {
        jy122.l.append(jy122.e);
        for (int i = 1; i < jy122.h - 1; ++i) {
            jy122.l.append(" |   ");
        }
        if (jy122.h > 1) {
            jy122.l.append(" +---");
        }
    }

    protected static void w(Jy122 jy122) {
        jy122.l.append(jy122.e);
        for (int i = 1; i < jy122.h; ++i) {
            jy122.l.append(" |   ");
        }
    }

    public static void q(Jy122 jy122) {
        ++jy122.h;
    }

    public static void s(Jy122 jy122, String string) {
        Jy122.w(jy122);
        jy122.l.append(string);
        Jy122.e(jy122);
    }

    public Jy122(Logger logger) {
        this.logger = logger;
        this.b = 0;
    }
}

