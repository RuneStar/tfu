// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import fmod.Z256;

public class K589
{
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
        K589.d = false;
        K589.q = new LinkedList();
        K589.j = new ArrayList();
        K589.e = null;
        K589.h = null;
        K589.s = null;
        K589.b = null;
        K589.l = 0L;
        K589.w = 0L;
    }
    
    public static void j() {
        final Iterator iterator = K589.q.iterator();
        while (iterator.hasNext()) {
            X675.r(iterator.next());
        }
    }
    
    protected static X675 e(final String anObject) {
        for (final X675 x675 : K589.q) {
            if (x675.d.equals(anObject)) {
                return x675;
            }
        }
        return null;
    }
    
    public static void s(final String s) {
        if (s != null && !s.equals("")) {
            final Iterator iterator = K589.q.iterator();
            while (iterator.hasNext()) {
                X675.l(iterator.next(), s);
            }
        }
    }
    
    public static void b() {
        if (K589.s != null) {
            X675.q(K589.s);
        }
        if (K589.b != null) {
            X675.h(K589.b);
        }
        K589.s = (K589.b = null);
    }
    
    static long g() {
        return System.currentTimeMillis();
    }
    
    public static void q() {
        if (K589.d) {
            if (System.currentTimeMillis() - K589.w > 1000L) {
                K589.w = System.currentTimeMillis() - 1L;
            }
            while (K589.w < System.currentTimeMillis()) {
                K589.w += 33L;
                j();
            }
        }
    }
    
    public static void d(final String str) {
        final E673 e673 = new E673();
        K589.d = false;
        G593.g(str + ".dat", 100000L, false, e673, null);
    }
    
    public static void h(final String e, final String h) {
        if (!K589.d) {
            K589.e = e;
            K589.h = h;
            return;
        }
        final X675 e2 = e(e);
        if (e2 != null) {
            X675.y(e2);
            if (h != null && !h.equals("")) {
                X675.l(e2, h);
            }
            else {
                X675.l(e2, "GARBAGEMOOD");
            }
        }
    }
}
