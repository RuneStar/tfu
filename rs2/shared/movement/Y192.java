/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rs2.shared.movement.C184;
import rs2.shared.movement.O376;
import rs2.shared.movement.PlayerPhysicsAvatar;
import tfu.Gg3;

public class Y192 {
    private static final List d;
    public static boolean e;
    public static final Map g;
    static PrintStream h;
    private static boolean j;
    private static final List q;

    public static void q() {
        if (!e) {
            return;
        }
        for (C184 c184 : d) {
            Q7 q7 = c184.v.getCurrentTransform();
            if (q7 == null) continue;
            c184.h = q7.g;
            c184.b = q7.d;
            if (!j) {
                HashMap<String, C184> hashMap;
                HashMap<String, HashMap<String, C184>> hashMap2 = (HashMap<String, HashMap<String, C184>>)g.get(c184.q);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<String, HashMap<String, C184>>();
                    g.put(c184.q, hashMap2);
                }
                if ((hashMap = (HashMap<String, C184>)hashMap2.get(c184.j)) == null) {
                    hashMap = new HashMap<String, C184>();
                    hashMap2.put(c184.j, hashMap);
                }
                hashMap.put(c184.d, c184);
            }
            if (!j) continue;
            q.add(c184);
        }
        d.clear();
    }

    public static void g(boolean bl) {
        j = bl;
    }

    public static boolean j() {
        return !q.isEmpty();
    }

    public static C184 d(String string, int n, String string2, PlayerPhysicsAvatar playerPhysicsAvatar, Map map, Map map2) {
        if (!e) {
            return null;
        }
        Q7 q7 = playerPhysicsAvatar.getCurrentTransform();
        if (q7 != null) {
            C184 c184 = new C184(new Date(), string, n, string2, q7.g, q7.d, map, map2);
            c184.v = playerPhysicsAvatar;
            d.add(c184);
            return c184;
        }
        return null;
    }

    public static boolean e(Gg3 gg3) {
        int n;
        int n2 = gg3.v;
        Gg3.i(gg3, q.size());
        LinkedList<C184> linkedList = new LinkedList<C184>();
        for (C184 c184 : q) {
            if (gg3.v > 512) break;
            Gg3.ag(gg3, c184.g.getTime());
            gg3.af(c184.d);
            gg3.af(c184.j);
            Gg3.a(gg3, c184.q);
            Vector3.w(c184.e, gg3);
            Vector3.w(c184.h, gg3);
            M47.b(c184.s, gg3);
            M47.b(c184.b, gg3);
            Gg3.i(gg3, c184.l.size());
            for (Map.Entry entry : c184.l.entrySet()) {
                gg3.af((String)entry.getKey());
                Object v = entry.getValue();
                if (v instanceof Boolean) {
                    if (((Boolean)v).booleanValue()) {
                        Gg3.k(gg3, 1);
                        continue;
                    }
                    Gg3.k(gg3, 0);
                    continue;
                }
                if (v instanceof Double) {
                    Gg3.k(gg3, 2);
                    Gg3.ai(gg3, (Double)v);
                    continue;
                }
                throw new IllegalStateException("Only boolean and number controls are currently supported");
            }
            Gg3.i(gg3, c184.r.size());
            for (O376 o376 : c184.r) {
                gg3.ap(o376.g);
                Gg3.k(gg3, o376.d.length);
                for (Object object : o376.d) {
                    if (object instanceof Integer) {
                        Gg3.k(gg3, 0);
                        Gg3.a(gg3, (Integer)object);
                        continue;
                    }
                    if (object instanceof Boolean) {
                        Gg3.k(gg3, (Boolean)object != false ? 2 : 1);
                        continue;
                    }
                    if (object instanceof Float) {
                        Gg3.k(gg3, 3);
                        Gg3.aq(gg3, ((Float)object).floatValue());
                        continue;
                    }
                    if (object instanceof Quaternion) {
                        Gg3.k(gg3, 4);
                        Quaternion.q((Quaternion)object, gg3);
                        continue;
                    }
                    if (!(object instanceof Vector3)) continue;
                    Gg3.k(gg3, 5);
                    Vector3.w((Vector3)object, gg3);
                }
            }
            linkedList.add(c184);
        }
        if ((n = linkedList.size()) == 0) {
            return false;
        }
        if (n != q.size()) {
            int n3 = gg3.v;
            gg3.v = n2;
            Gg3.i(gg3, n);
            gg3.v = n3;
        }
        q.removeAll(linkedList);
        return true;
    }

    static {
        g = new HashMap();
        d = new LinkedList();
        q = new LinkedList();
        e = false;
        h = null;
    }
}

