// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.stringtools.general.J173;

public class Af155
{
    static Al154 d;
    private static final boolean g = false;
    
    public static void g(final Al154 d) {
        Af155.d = d;
    }
    
    public static String q(final Gg3 gg3) {
        return j(gg3, 32767);
    }
    
    public static int d(final Gg3 gg3, final String s) {
        final int v = gg3.v;
        final byte[] j = J173.j(s);
        gg3.at(j.length);
        gg3.v += Af155.d.d(j, 0, j.length, gg3.r, gg3.v);
        return gg3.v - v;
    }
    
    public static String j(final Gg3 gg3, final int n) {
        try {
            int br = Gg3.br(gg3);
            if (br > n) {
                br = n;
            }
            final byte[] array = new byte[br];
            gg3.v += Al154.q(Af155.d, gg3.r, gg3.v, array, 0, br);
            return J173.s(array, 0, br);
        }
        catch (Exception ex) {
            return "Cabbage";
        }
    }
}
