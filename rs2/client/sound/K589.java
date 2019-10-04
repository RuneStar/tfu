/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import fmod.Z256;
import java.util.ArrayList;
import java.util.LinkedList;
import rs2.client.sound.E673;
import rs2.client.sound.G593;
import rs2.client.sound.X675;

public class K589 {
    protected static X675 b;
    protected static boolean d;
    static String e;
    static Z256 g;
    static String h;
    protected static ArrayList j;
    static long l;
    protected static LinkedList q;
    protected static X675 s;
    static long w;

    static {
        d = false;
        q = new LinkedList();
        j = new ArrayList();
        e = null;
        h = null;
        s = null;
        b = null;
        l = 0L;
        w = 0L;
    }

    public static void j() {
        for (X675 x675 : q) {
            X675.r(x675);
        }
    }

    protected static X675 e(String string) {
        for (X675 x675 : q) {
            if (!x675.d.equals(string)) continue;
            return x675;
        }
        return null;
    }

    public static void s(String string) {
        if (string != null && !string.equals("")) {
            for (X675 x675 : q) {
                X675.l(x675, string);
            }
        }
    }

    public static void b() {
        if (s != null) {
            X675.q(s);
        }
        if (b != null) {
            X675.h(b);
        }
        b = null;
        s = null;
    }

    static long g() {
        return System.currentTimeMillis();
    }

    public static void q() {
        if (d) {
            if (System.currentTimeMillis() - w > 1000L) {
                w = System.currentTimeMillis() - 1L;
            }
            while (w < System.currentTimeMillis()) {
                w += 33L;
                K589.j();
            }
        }
    }

    public static void d(String string) {
        E673 e673 = new E673();
        d = false;
        G593.g(string + ".dat", 100000L, false, e673, null);
    }

    public static void h(String string, String string2) {
        if (!d) {
            e = string;
            h = string2;
            return;
        }
        X675 x675 = K589.e(string);
        if (x675 != null) {
            X675.y(x675);
            if (string2 != null && !string2.equals("")) {
                X675.l(x675, string2);
            } else {
                X675.l(x675, "GARBAGEMOOD");
            }
        }
    }
}

