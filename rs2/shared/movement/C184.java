/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rs2.shared.movement.O376;
import rs2.shared.movement.PlayerPhysicsAvatar;

public class C184 {
    public M47 b;
    public final String d;
    public final Vector3 e;
    public final Date g;
    public Vector3 h;
    public final String j;
    public final Map l = new HashMap();
    public final int q;
    public final List r;
    public final M47 s;
    public PlayerPhysicsAvatar v;
    public final Map w = new HashMap();

    C184(Date date, String string, int n, String string2, Vector3 vector3, M47 m47, Vector3 vector32, M47 m472) {
        this.r = new LinkedList();
        this.g = date;
        this.d = string;
        this.q = n;
        this.j = string2;
        this.e = vector3;
        this.s = m47;
        this.h = vector32;
        this.b = m472;
    }

    public static void g(C184 c184, String string, Object object) {
        int n;
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            n = StringTools.l(string);
        }
        c184.l.put(string, object);
        c184.w.put(n, object);
    }

    public void d(String string, Object ... arrobject) {
        this.r.add(new O376(string, arrobject));
    }

    public boolean equals(Object object) {
        if (!(object instanceof C184)) {
            return false;
        }
        C184 c184 = (C184)object;
        if (this.w.size() != c184.w.size()) {
            return false;
        }
        for (Map.Entry entry : this.w.entrySet()) {
            Integer n = (Integer)entry.getKey();
            if (!c184.w.containsKey(n)) {
                return false;
            }
            Object v = entry.getValue();
            Object v2 = c184.w.get(n);
            if (!(v == null ? v2 != null : !v.equals(v2))) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.g.getHours() + ":" + this.g.getMinutes() + ":" + this.g.getSeconds() + "." + this.g.getTime() % 1000L + " " + this.d + ": " + this.e.x + "," + this.e.y + "," + this.e.z + " [" + this.s.f00 + "," + this.s.f01 + "," + this.s.f02 + "," + this.s.f10 + "," + this.s.f11 + "," + this.s.f12 + "," + this.s.f20 + "," + this.s.f21 + "," + this.s.f22 + "] -> " + this.h.x + "," + this.h.y + "," + this.h.z + " [" + this.b.f00 + "," + this.b.f01 + "," + this.b.f02 + "," + this.b.f10 + "," + this.b.f11 + "," + this.b.f12 + "," + this.b.f20 + "," + this.b.f21 + "," + this.b.f22 + "]\n");
        for (Map.Entry object : this.l.entrySet()) {
            stringBuilder.append((String)object.getKey() + " : " + object.getValue() + "\n");
        }
        for (O376 o376 : this.r) {
            stringBuilder.append(o376.toString() + "\n");
        }
        return stringBuilder.toString();
    }

    C184(Date date, String string, int n, String string2, Vector3 vector3, M47 m47) {
        this.r = new LinkedList();
        this.g = date;
        this.d = string;
        this.q = n;
        this.j = string2;
        this.e = vector3;
        this.s = m47;
    }

    C184(Date date, String string, int n, String string2, Vector3 vector3, M47 m47, Map map, Map map2) {
        this(date, string, n, string2, vector3, m47);
        for (Map.Entry entry : map.entrySet()) {
            String string3 = null;
            if (map2 != null) {
                string3 = (String)map2.get(entry.getKey());
            }
            if (string3 == null) {
                string3 = Integer.toString((Integer)entry.getKey());
            }
            C184.g(this, string3, entry.getValue());
        }
    }
}

