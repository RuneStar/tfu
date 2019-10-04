// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import java.util.Collection;
import com.jagex.maths.Quaternion;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.util.LinkedList;
import tfu.Gg3;
import java.util.Date;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import java.util.Iterator;
import java.util.HashMap;
import java.io.PrintStream;
import java.util.Map;
import java.util.List;

public class Y192
{
    private static final List d;
    public static boolean e;
    public static final Map g;
    static PrintStream h;
    private static boolean j;
    private static final List q;
    
    public static void q() {
        if (!Y192.e) {
            return;
        }
        for (final C184 c184 : Y192.d) {
            final Q7 currentTransform = c184.v.getCurrentTransform();
            if (currentTransform == null) {
                continue;
            }
            c184.h = currentTransform.g;
            c184.b = currentTransform.d;
            if (!Y192.j) {
                Map<?, ?> map = Y192.g.get(c184.q);
                if (map == null) {
                    map = new HashMap<Object, Object>();
                    Y192.g.put(c184.q, map);
                }
                Map<?, ?> map2 = map.get(c184.j);
                if (map2 == null) {
                    map2 = new HashMap<Object, Object>();
                    map.put(c184.j, map2);
                }
                map2.put(c184.d, c184);
            }
            if (!Y192.j) {
                continue;
            }
            Y192.q.add(c184);
        }
        Y192.d.clear();
    }
    
    public static void g(final boolean j) {
        Y192.j = j;
    }
    
    public static boolean j() {
        return !Y192.q.isEmpty();
    }
    
    public static C184 d(final String s, final int n, final String s2, final PlayerPhysicsAvatar v, final Map map, final Map map2) {
        if (!Y192.e) {
            return null;
        }
        final Q7 currentTransform = v.getCurrentTransform();
        if (currentTransform != null) {
            final C184 c184 = new C184(new Date(), s, n, s2, currentTransform.g, currentTransform.d, map, map2);
            c184.v = v;
            Y192.d.add(c184);
            return c184;
        }
        return null;
    }
    
    public static boolean e(final Gg3 gg3) {
        final int v = gg3.v;
        Gg3.i(gg3, Y192.q.size());
        final LinkedList<C184> list = new LinkedList<C184>();
        for (final C184 c184 : Y192.q) {
            if (gg3.v > 512) {
                break;
            }
            Gg3.ag(gg3, c184.g.getTime());
            gg3.af(c184.d);
            gg3.af(c184.j);
            Gg3.a(gg3, c184.q);
            Vector3.w(c184.e, gg3);
            Vector3.w(c184.h, gg3);
            M47.b(c184.s, gg3);
            M47.b(c184.b, gg3);
            Gg3.i(gg3, c184.l.size());
            for (final Map.Entry<String, V> entry : c184.l.entrySet()) {
                gg3.af(entry.getKey());
                final V value = entry.getValue();
                if (value instanceof Boolean) {
                    if (value) {
                        Gg3.k(gg3, 1);
                    }
                    else {
                        Gg3.k(gg3, 0);
                    }
                }
                else {
                    if (!(value instanceof Double)) {
                        throw new IllegalStateException("Only boolean and number controls are currently supported");
                    }
                    Gg3.k(gg3, 2);
                    Gg3.ai(gg3, (double)value);
                }
            }
            Gg3.i(gg3, c184.r.size());
            for (final O376 o376 : c184.r) {
                gg3.ap(o376.g);
                Gg3.k(gg3, o376.d.length);
                for (final Object o377 : o376.d) {
                    if (o377 instanceof Integer) {
                        Gg3.k(gg3, 0);
                        Gg3.a(gg3, (int)o377);
                    }
                    else if (o377 instanceof Boolean) {
                        Gg3.k(gg3, ((boolean)o377) ? 2 : 1);
                    }
                    else if (o377 instanceof Float) {
                        Gg3.k(gg3, 3);
                        Gg3.aq(gg3, (float)o377);
                    }
                    else if (o377 instanceof Quaternion) {
                        Gg3.k(gg3, 4);
                        Quaternion.q((Quaternion)o377, gg3);
                    }
                    else if (o377 instanceof Vector3) {
                        Gg3.k(gg3, 5);
                        Vector3.w((Vector3)o377, gg3);
                    }
                }
            }
            list.add(c184);
        }
        final int size = list.size();
        if (size == 0) {
            return false;
        }
        if (size != Y192.q.size()) {
            final int v2 = gg3.v;
            gg3.v = v;
            Gg3.i(gg3, size);
            gg3.v = v2;
        }
        Y192.q.removeAll(list);
        return true;
    }
    
    static {
        g = new HashMap();
        d = new LinkedList();
        q = new LinkedList();
        Y192.e = false;
        Y192.h = null;
    }
}
