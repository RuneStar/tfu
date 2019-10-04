/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import fmod.E245;
import fmod.G252;
import fmod.H238;
import fmod.J251;
import fmod.L250;
import fmod.M249;
import fmod.N247;
import fmod.P248;
import fmod.Q244;
import fmod.S237;
import fmod.V241;
import fmod.Y246;
import fmod.fmod;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gz143;

public class X243 {
    private static List a;
    private static long ah;
    public static List aj;
    static int an;
    public static final int b = 5;
    private static List c;
    public static String d;
    public static final int e = 2;
    public static final int h = 3;
    public static final int j = 1;
    public static final int l = 5;
    private static final Logger logger;
    private static Hashtable o;
    public static final int p = 10;
    public static final int q = 0;
    public static final int r = 7;
    public static final int s = 4;
    public static final int v = 8;
    public static final int w = 6;
    private static int x;
    public static final int y = 9;
    String[] aa = null;
    private Q244 ab;
    private float ac = 0.0f;
    public int af;
    private String ag = "";
    public String ai = "";
    public E245 al;
    private boolean am;
    private long ao = 0L;
    private Y246 ap = null;
    public String aq;
    private Q244 ar;
    private boolean as;
    private float at = 1.0f;
    private GameEntity au = null;
    private Object av = null;
    private Q244 aw;
    private int ax;
    public boolean az = false;
    private List f;
    private N247 i = new N247();
    public X243 k = null;
    public long m = 0L;
    public long n = 0L;
    public int t = -1;
    public int u = 0;
    public int z = 0;

    public String toString() {
        return this.i.d;
    }

    public static void d() {
        X243 x243;
        Object object2;
        int n;
        try {
            for (Object object2 : c) {
                X243 x2432 = ((X243)object2).al.r(((X243)object2).aq, ((X243)object2).af);
                if (!X243.h(x2432)) continue;
                ((X243)object2).m = x2432.m;
                X243.o((X243)object2);
                c.remove(object2);
                break;
            }
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            logger.info("Two things trying to play with event list");
        }
        Enumeration enumeration = o.keys();
        object2 = new N247();
        long l = Gz143.g();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            P248 p248 = (P248)o.get(string);
            if (p248 == null || p248.d == 0L) continue;
            object2 = X243.g(p248.d);
            if (((N247)object2).j != 0 || p248.g + ah >= l) continue;
            logger.trace("Flushed {} from events. {} used", (Object)string, (Object)fmod.getMemoryUsed());
            o.remove(string);
            x243 = new X243(p248.d);
            X243.f(x243);
            X243.p(x243, true, true);
            X243.q(x243);
            break;
        }
        if ((n = a.size() - 1) >= 0) {
            for (int i = n; i >= 0; --i) {
                x243 = (X243)a.get(i);
                if (x243.ao > 0L && Gz143.g() > x243.ao) {
                    X243.c(x243);
                    continue;
                }
                if ((X243.v(x243) & 0x40) != 0) {
                    X243.c(x243);
                    continue;
                }
                if (!X243.y(x243)) {
                    X243.c(x243);
                    continue;
                }
                if (x243.au == null) continue;
                Vector3 vector3 = x243.au.getWorldTransform().trans;
                x243.z(vector3.x, vector3.y, vector3.z);
            }
        }
    }

    public static int x(X243 x243, Q244 q244, Q244 q2442, Q244 q2443) {
        x243.ab = q244;
        x243.aw = q2442;
        x243.ar = q2443;
        return X243.h(x243) ? fmod.Event_set3DAttributes(x243.m, q244.g, q244.d, q244.q, q2442.g, q2442.d, q2442.q, q2443.g, q2443.d, q2443.q) : 0;
    }

    public static void j(long l) {
        ah = l;
    }

    public static boolean h(X243 x243) {
        return x243.m > 0L;
    }

    public static String s(X243 x243) {
        return x243.ai;
    }

    public static N247 b(X243 x243) {
        return X243.g(x243.m);
    }

    public M249 l() {
        if (this.m == -1L) {
            return null;
        }
        return new M249(fmod.Event_getCategory(this.m));
    }

    public L250 w(String string) {
        return X243.h(this) ? new L250(fmod.Event_getParameter(this.m, string)) : null;
    }

    public J251 r() {
        return X243.h(this) ? new J251(fmod.Event_getParentGroup(this.m)) : null;
    }

    public static int v(X243 x243) {
        if (x243.m == -1L) {
            return 0;
        }
        return X243.h(x243) ? fmod.Event_getState(x243.m) : 0;
    }

    public static boolean y(X243 x243) {
        if (!X243.h(x243)) {
            return false;
        }
        int n = X243.v(x243);
        if ((n & 0x10) == 16) {
            return true;
        }
        if ((n & 0x40) == 64) {
            return false;
        }
        return false;
    }

    public static void af(X243 x243, int n, float f) {
        if (X243.h(x243)) {
            fmod.Event_setPropertyByIndex(x243.m, n, f);
        }
    }

    public static int u(X243 x243, Q244 q244) {
        x243.ab = q244;
        return X243.h(x243) ? fmod.Event_set3DAttributes(x243.m, q244.g, q244.d, q244.q, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f) : 0;
    }

    public static void m(X243 x243, boolean bl) {
        x243.am = bl;
        if (X243.h(x243)) {
            fmod.Event_setMute(x243.m, bl);
        }
    }

    public static void n(X243 x243, boolean bl) {
        x243.as = bl;
        if (X243.h(x243)) {
            fmod.Event_setPaused(x243.m, bl);
        }
    }

    public static void t(X243 x243, float f, float f2) {
        if (X243.h(x243)) {
            X243.af(x243, 17, f);
            X243.af(x243, 18, f2);
        }
    }

    public static void i(X243 x243, float f) {
        x243.at = f;
        if (X243.h(x243)) {
            fmod.Event_setVolume(x243.m, f);
        }
    }

    private static void o(X243 x243) {
        if (X243.h(x243)) {
            X243.i(x243, x243.at);
            X243.k(x243, x243.ac, x243.ax);
            X243.m(x243, x243.am);
            X243.x(x243, x243.ab, x243.aw, x243.ar);
            if (x243.f.size() > 0) {
                for (G252 g252 : x243.f) {
                    x243.ag(g252.g, g252.d);
                }
                x243.f.clear();
            }
            if (x243.az) {
                x243.a();
            }
            X243.n(x243, x243.as);
        }
    }

    public static ArrayList ao() {
        return (ArrayList)a;
    }

    public static void f(X243 x243) {
        if (X243.h(x243)) {
            L250 l250 = x243.w("playback");
            if (L250.g(l250)) {
                L250.d(l250);
                x243.ao = Gz143.g() + 5000L;
            } else {
                fmod.Event_stop(x243.m);
                a.remove(x243);
            }
        }
    }

    public static void c(X243 x243) {
        if (X243.h(x243)) {
            fmod.Event_stopImmediate(x243.m);
            a.remove(x243);
        }
    }

    public void ag(String string, float f) {
        if (X243.h(this)) {
            L250 l250 = this.w(string);
            if (L250.g(l250)) {
                L250.q(l250, f);
            }
        } else {
            this.f.add(new G252(this, string, f));
        }
    }

    public void a() {
        if (X243.h(this)) {
            o.put(this.aq, new P248(this, Gz143.g(), this.m));
            a.add(this);
            fmod.Event_start(this.m);
        }
    }

    public static void av(X243 x243, int n, int n2) {
        if (X243.h(x243)) {
            fmod.Event_setIntPropertyByIndex(x243.m, n, n2);
        }
    }

    public static void p(X243 x243, boolean bl, boolean bl2) {
        if (X243.h(x243)) {
            fmod.Event_release(x243.m, bl, bl2);
        }
    }

    public static void ap(X243 x243, GameEntity gameEntity) {
        x243.au = gameEntity;
    }

    public boolean ai() {
        String[] arrstring;
        boolean bl = false;
        if (X243.h(this) && (arrstring = this.aq()) != null) {
            for (String string : arrstring) {
                File file = new File(d + string);
                if (!file.exists()) {
                    return false;
                }
                bl |= true;
            }
        }
        return bl;
    }

    public static synchronized void e(X243 x243) {
        String string = X243.s(x243);
        for (X243 x2432 : c) {
            if (!X243.s(x2432).equals(string)) continue;
            return;
        }
        c.add(x243);
    }

    public H238 aa() {
        int n;
        S237 s237 = new S237(fmod.Event_getChannelGroup(this.m));
        if (S237.g(s237) && (n = S237.q(s237)) > 0) {
            H238 h238 = s237.d(n - 1);
            return h238;
        }
        return new H238(0L);
    }

    public static long an(X243 x243) {
        H238 h238 = x243.aa();
        if (H238.g(h238)) {
            return H238.q(h238, 1);
        }
        return 0L;
    }

    public static void am(X243 x243, int n) {
        H238 h238 = x243.aa();
        if (H238.g(h238)) {
            H238.j(h238, n, 1);
        }
    }

    public static int as(X243 x243) {
        H238 h238 = x243.aa();
        return H238.g(h238) ? V241.g(h238.d(), 1) : 0;
    }

    static {
        logger = LoggerFactory.getLogger(X243.class);
        d = "";
        x = 0;
        o = new Hashtable();
        a = new ArrayList();
        c = new ArrayList();
        ah = 10000L;
        an = 0;
        aj = new ArrayList();
    }

    public X243(long l) {
        this.f = new ArrayList();
        this.ab = new Q244();
        this.aw = new Q244();
        this.ar = new Q244();
        this.m = l;
        N247 n247 = new N247();
        if (this.m > 0L) {
            n247 = X243.g(this.m);
        }
        this.t = x++;
    }

    public String[] aq() {
        if (X243.h(this)) {
            String string = fmod.Event_getWaveBanksNeeded(this.m);
            String[] arrstring = string.split("\\|");
            int n = 0;
            while (n < arrstring.length) {
                String[] arrstring2 = arrstring;
                int n2 = n++;
                arrstring2[n2] = arrstring2[n2] + ".fsb";
            }
            return arrstring;
        }
        return null;
    }

    public static void q(X243 x243) {
        J251 j251;
        if (X243.h(x243) && J251.g(j251 = x243.r())) {
            J251.d(j251, x243);
        }
    }

    public static void k(X243 x243, float f, int n) {
        x243.ac = f;
        x243.ax = n;
        if (X243.h(x243)) {
            fmod.Event_setPitch(x243.m, f, n);
        }
    }

    public int z(float f, float f2, float f3) {
        this.ab = new Q244(f, f2, f3);
        return X243.h(this) ? fmod.Event_set3DAttributes(this.m, f, f2, f3, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f) : 0;
    }

    private static N247 g(long l) {
        N247 n247 = new N247();
        String string = fmod.Event_getInfo(l);
        if (string == null || string.isEmpty()) {
            return n247;
        }
        int n = 0;
        while (n < string.length()) {
            int n2;
            int n3;
            int n4 = string.indexOf(44, n);
            if (n4 == -1) {
                n4 = string.length();
            }
            if ((n3 = string.indexOf(61, n)) == -1) {
                n3 = n4;
            }
            if (string.regionMatches(n, "index", 0, n2 = n3 - n)) {
                n247.g = Integer.parseInt(string.substring(n3 + 1, n4));
            } else if (string.regionMatches(n, "name", 0, n2)) {
                n247.d = string.substring(n3 + 1, n4);
            } else if (string.regionMatches(n, "audibility", 0, n2)) {
                n247.q = Float.parseFloat(string.substring(n3 + 1, n4));
            } else if (string.regionMatches(n, "instancesactive", 0, n2)) {
                n247.j = Integer.parseInt(string.substring(n3 + 1, n4));
            } else if (string.regionMatches(n, "maxinstances", 0, n2)) {
                n247.e = Integer.parseInt(string.substring(n3 + 1, n4));
            }
            n = n4 + 1;
        }
        return n247;
    }

    public static int al(X243 x243, int n) {
        int n2 = 0;
        if (X243.h(x243)) {
            n2 = fmod.Event_getIntPropertyByIndex(x243.m, n);
        }
        return n2;
    }
}

