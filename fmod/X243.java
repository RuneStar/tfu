// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

import org.slf4j.LoggerFactory;
import java.io.File;
import java.util.ArrayList;
import com.jagex.maths.Vector3;
import java.util.Enumeration;
import java.util.Iterator;
import tfu.Gz143;
import java.util.ConcurrentModificationException;
import com.jagex.game.runetek6.gameentity.GameEntity;
import java.util.Hashtable;
import org.slf4j.Logger;
import java.util.List;

public class X243
{
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
    String[] aa;
    private Q244 ab;
    private float ac;
    public int af;
    private String ag;
    public String ai;
    public E245 al;
    private boolean am;
    private long ao;
    private Y246 ap;
    public String aq;
    private Q244 ar;
    private boolean as;
    private float at;
    private GameEntity au;
    private Object av;
    private Q244 aw;
    private int ax;
    public boolean az;
    private List f;
    private N247 i;
    public X243 k;
    public long m;
    public long n;
    public int t;
    public int u;
    public int z;
    
    @Override
    public String toString() {
        return this.i.d;
    }
    
    public static void d() {
        try {
            for (final X243 x243 : X243.c) {
                final X243 r = x243.al.r(x243.aq, x243.af);
                if (h(r)) {
                    x243.m = r.m;
                    o(x243);
                    X243.c.remove(x243);
                    break;
                }
            }
        }
        catch (ConcurrentModificationException ex) {
            X243.logger.info("Two things trying to play with event list");
        }
        final Enumeration<String> keys = X243.o.keys();
        final N247 n247 = new N247();
        final long g = Gz143.g();
        while (keys.hasMoreElements()) {
            final String s = keys.nextElement();
            final P248 p248 = X243.o.get(s);
            if (p248 != null && p248.d != 0L && g(p248.d).j == 0 && p248.g + X243.ah < g) {
                X243.logger.trace("Flushed {} from events. {} used", s, fmod.getMemoryUsed());
                X243.o.remove(s);
                final X243 x244 = new X243(p248.d);
                f(x244);
                p(x244, true, true);
                q(x244);
                break;
            }
        }
        final int n248 = X243.a.size() - 1;
        if (n248 >= 0) {
            for (int i = n248; i >= 0; --i) {
                final X243 x245 = X243.a.get(i);
                if (x245.ao > 0L && Gz143.g() > x245.ao) {
                    c(x245);
                }
                else if ((v(x245) & 0x40) != 0x0) {
                    c(x245);
                }
                else if (!y(x245)) {
                    c(x245);
                }
                else if (x245.au != null) {
                    final Vector3 trans = x245.au.getWorldTransform().trans;
                    x245.z(trans.x, trans.y, trans.z);
                }
            }
        }
    }
    
    public static int x(final X243 x243, final Q244 ab, final Q244 aw, final Q244 ar) {
        x243.ab = ab;
        x243.aw = aw;
        x243.ar = ar;
        return h(x243) ? fmod.Event_set3DAttributes(x243.m, ab.g, ab.d, ab.q, aw.g, aw.d, aw.q, ar.g, ar.d, ar.q) : 0;
    }
    
    public static void j(final long ah) {
        X243.ah = ah;
    }
    
    public static boolean h(final X243 x243) {
        return x243.m > 0L;
    }
    
    public static String s(final X243 x243) {
        return x243.ai;
    }
    
    public static N247 b(final X243 x243) {
        return g(x243.m);
    }
    
    public M249 l() {
        if (this.m == -1L) {
            return null;
        }
        return new M249(fmod.Event_getCategory(this.m));
    }
    
    public L250 w(final String s) {
        return h(this) ? new L250(fmod.Event_getParameter(this.m, s)) : null;
    }
    
    public J251 r() {
        return h(this) ? new J251(fmod.Event_getParentGroup(this.m)) : null;
    }
    
    public static int v(final X243 x243) {
        if (x243.m == -1L) {
            return 0;
        }
        return h(x243) ? fmod.Event_getState(x243.m) : 0;
    }
    
    public static boolean y(final X243 x243) {
        if (!h(x243)) {
            return false;
        }
        final int v = v(x243);
        return (v & 0x10) == 0x10 || ((v & 0x40) == 0x40 && false);
    }
    
    public static void af(final X243 x243, final int n, final float n2) {
        if (h(x243)) {
            fmod.Event_setPropertyByIndex(x243.m, n, n2);
        }
    }
    
    public static int u(final X243 x243, final Q244 ab) {
        x243.ab = ab;
        return h(x243) ? fmod.Event_set3DAttributes(x243.m, ab.g, ab.d, ab.q, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f) : 0;
    }
    
    public static void m(final X243 x243, final boolean am) {
        x243.am = am;
        if (h(x243)) {
            fmod.Event_setMute(x243.m, am);
        }
    }
    
    public static void n(final X243 x243, final boolean as) {
        x243.as = as;
        if (h(x243)) {
            fmod.Event_setPaused(x243.m, as);
        }
    }
    
    public static void t(final X243 x243, final float n, final float n2) {
        if (h(x243)) {
            af(x243, 17, n);
            af(x243, 18, n2);
        }
    }
    
    public static void i(final X243 x243, final float at) {
        x243.at = at;
        if (h(x243)) {
            fmod.Event_setVolume(x243.m, at);
        }
    }
    
    private static void o(final X243 x243) {
        if (h(x243)) {
            i(x243, x243.at);
            k(x243, x243.ac, x243.ax);
            m(x243, x243.am);
            x(x243, x243.ab, x243.aw, x243.ar);
            if (x243.f.size() > 0) {
                for (final G252 g252 : x243.f) {
                    x243.ag(g252.g, g252.d);
                }
                x243.f.clear();
            }
            if (x243.az) {
                x243.a();
            }
            n(x243, x243.as);
        }
    }
    
    public static ArrayList ao() {
        return (ArrayList)X243.a;
    }
    
    public static void f(final X243 x243) {
        if (h(x243)) {
            final L250 w = x243.w("playback");
            if (L250.g(w)) {
                L250.d(w);
                x243.ao = Gz143.g() + 5000L;
            }
            else {
                fmod.Event_stop(x243.m);
                X243.a.remove(x243);
            }
        }
    }
    
    public static void c(final X243 x243) {
        if (h(x243)) {
            fmod.Event_stopImmediate(x243.m);
            X243.a.remove(x243);
        }
    }
    
    public void ag(final String s, final float n) {
        if (h(this)) {
            final L250 w = this.w(s);
            if (L250.g(w)) {
                L250.q(w, n);
            }
        }
        else {
            this.f.add(new G252(this, s, n));
        }
    }
    
    public void a() {
        if (h(this)) {
            X243.o.put(this.aq, new P248(this, Gz143.g(), this.m));
            X243.a.add(this);
            fmod.Event_start(this.m);
        }
    }
    
    public static void av(final X243 x243, final int n, final int n2) {
        if (h(x243)) {
            fmod.Event_setIntPropertyByIndex(x243.m, n, n2);
        }
    }
    
    public static void p(final X243 x243, final boolean b, final boolean b2) {
        if (h(x243)) {
            fmod.Event_release(x243.m, b, b2);
        }
    }
    
    public static void ap(final X243 x243, final GameEntity au) {
        x243.au = au;
    }
    
    public boolean ai() {
        boolean b = false;
        if (h(this)) {
            final String[] aq = this.aq();
            if (aq != null) {
                final String[] array = aq;
                for (int length = array.length, i = 0; i < length; ++i) {
                    if (!new File(X243.d + array[i]).exists()) {
                        return false;
                    }
                    b |= true;
                }
            }
        }
        return b;
    }
    
    public static synchronized void e(final X243 x243) {
        final String s = s(x243);
        final Iterator<X243> iterator = (Iterator<X243>)X243.c.iterator();
        while (iterator.hasNext()) {
            if (s(iterator.next()).equals(s)) {
                return;
            }
        }
        X243.c.add(x243);
    }
    
    public H238 aa() {
        final S237 s237 = new S237(fmod.Event_getChannelGroup(this.m));
        if (S237.g(s237)) {
            final int q = S237.q(s237);
            if (q > 0) {
                return s237.d(q - 1);
            }
        }
        return new H238(0L);
    }
    
    public static long an(final X243 x243) {
        final H238 aa = x243.aa();
        if (H238.g(aa)) {
            return H238.q(aa, 1);
        }
        return 0L;
    }
    
    public static void am(final X243 x243, final int n) {
        final H238 aa = x243.aa();
        if (H238.g(aa)) {
            H238.j(aa, n, 1);
        }
    }
    
    public static int as(final X243 x243) {
        final H238 aa = x243.aa();
        return H238.g(aa) ? V241.g(aa.d(), 1) : 0;
    }
    
    static {
        logger = LoggerFactory.getLogger(X243.class);
        X243.d = "";
        X243.x = 0;
        X243.o = new Hashtable();
        X243.a = new ArrayList();
        X243.c = new ArrayList();
        X243.ah = 10000L;
        X243.an = 0;
        X243.aj = new ArrayList();
    }
    
    public X243(final long m) {
        this.u = 0;
        this.z = 0;
        this.t = -1;
        this.m = 0L;
        this.n = 0L;
        this.k = null;
        this.i = new N247();
        this.f = new ArrayList();
        this.ag = "";
        this.ai = "";
        this.av = null;
        this.az = false;
        this.ap = null;
        this.ao = 0L;
        this.aa = null;
        this.ac = 0.0f;
        this.at = 1.0f;
        this.ab = new Q244();
        this.aw = new Q244();
        this.ar = new Q244();
        this.au = null;
        this.m = m;
        final N247 n247 = new N247();
        if (this.m > 0L) {
            g(this.m);
        }
        this.t = X243.x++;
    }
    
    public String[] aq() {
        if (h(this)) {
            final String[] split = fmod.Event_getWaveBanksNeeded(this.m).split("\\|");
            for (int i = 0; i < split.length; ++i) {
                final StringBuilder sb = new StringBuilder();
                final String[] array = split;
                final int n = i;
                array[n] = sb.append(array[n]).append(".fsb").toString();
            }
            return split;
        }
        return null;
    }
    
    public static void q(final X243 x243) {
        if (h(x243)) {
            final J251 r = x243.r();
            if (J251.g(r)) {
                J251.d(r, x243);
            }
        }
    }
    
    public static void k(final X243 x243, final float ac, final int ax) {
        x243.ac = ac;
        x243.ax = ax;
        if (h(x243)) {
            fmod.Event_setPitch(x243.m, ac, ax);
        }
    }
    
    public int z(final float n, final float n2, final float n3) {
        this.ab = new Q244(n, n2, n3);
        return h(this) ? fmod.Event_set3DAttributes(this.m, n, n2, n3, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f) : 0;
    }
    
    private static N247 g(final long n) {
        final N247 n2 = new N247();
        final String event_getInfo = fmod.Event_getInfo(n);
        if (event_getInfo == null || event_getInfo.isEmpty()) {
            return n2;
        }
        int endIndex;
        for (int i = 0; i < event_getInfo.length(); i = endIndex + 1) {
            endIndex = event_getInfo.indexOf(44, i);
            if (endIndex == -1) {
                endIndex = event_getInfo.length();
            }
            int index = event_getInfo.indexOf(61, i);
            if (index == -1) {
                index = endIndex;
            }
            final int len = index - i;
            if (event_getInfo.regionMatches(i, "index", 0, len)) {
                n2.g = Integer.parseInt(event_getInfo.substring(index + 1, endIndex));
            }
            else if (event_getInfo.regionMatches(i, "name", 0, len)) {
                n2.d = event_getInfo.substring(index + 1, endIndex);
            }
            else if (event_getInfo.regionMatches(i, "audibility", 0, len)) {
                n2.q = Float.parseFloat(event_getInfo.substring(index + 1, endIndex));
            }
            else if (event_getInfo.regionMatches(i, "instancesactive", 0, len)) {
                n2.j = Integer.parseInt(event_getInfo.substring(index + 1, endIndex));
            }
            else if (event_getInfo.regionMatches(i, "maxinstances", 0, len)) {
                n2.e = Integer.parseInt(event_getInfo.substring(index + 1, endIndex));
            }
        }
        return n2;
    }
    
    public static int al(final X243 x243, final int n) {
        int event_getIntPropertyByIndex = 0;
        if (h(x243)) {
            event_getIntPropertyByIndex = fmod.Event_getIntPropertyByIndex(x243.m, n);
        }
        return event_getIntPropertyByIndex;
    }
}
