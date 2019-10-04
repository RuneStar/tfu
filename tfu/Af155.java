/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.J173;
import tfu.Al154;
import tfu.Gg3;

public class Af155 {
    static Al154 d;
    private static final boolean g = false;

    public static void g(Al154 al154) {
        d = al154;
    }

    public static String q(Gg3 gg3) {
        return Af155.j(gg3, 32767);
    }

    public static int d(Gg3 gg3, String string) {
        int n = gg3.v;
        byte[] arrby = J173.j(string);
        gg3.at(arrby.length);
        gg3.v += d.d(arrby, 0, arrby.length, gg3.r, gg3.v);
        return gg3.v - n;
    }

    public static String j(Gg3 gg3, int n) {
        try {
            int n2 = Gg3.br(gg3);
            if (n2 > n) {
                n2 = n;
            }
            byte[] arrby = new byte[n2];
            gg3.v += Al154.q(d, gg3.r, gg3.v, arrby, 0, n2);
            String string = J173.s(arrby, 0, n2);
            return string;
        }
        catch (Exception exception) {
            return "Cabbage";
        }
    }
}

