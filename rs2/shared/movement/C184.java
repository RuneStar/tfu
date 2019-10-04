// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import java.util.Iterator;
import com.jagex.core.stringtools.general.StringTools;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import com.jagex.maths.Vector3;
import com.jagex.maths.M47;

public class C184
{
    public M47 b;
    public final String d;
    public final Vector3 e;
    public final Date g;
    public Vector3 h;
    public final String j;
    public final Map l;
    public final int q;
    public final List r;
    public final M47 s;
    public PlayerPhysicsAvatar v;
    public final Map w;
    
    C184(final Date g, final String d, final int q, final String j, final Vector3 e, final M47 s, final Vector3 h, final M47 b) {
        this.l = new HashMap();
        this.w = new HashMap();
        this.r = new LinkedList();
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.s = s;
        this.h = h;
        this.b = b;
    }
    
    public static void g(final C184 c184, final String s, final Object o) {
        int i;
        try {
            i = Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            i = StringTools.l(s);
        }
        c184.l.put(s, o);
        c184.w.put(i, o);
    }
    
    public void d(final String s, final Object... array) {
        this.r.add(new O376(s, array));
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof C184)) {
            return false;
        }
        final C184 c184 = (C184)o;
        if (this.w.size() != c184.w.size()) {
            return false;
        }
        for (final Map.Entry<Integer, V> entry : this.w.entrySet()) {
            final Integer n = entry.getKey();
            if (!c184.w.containsKey(n)) {
                return false;
            }
            final V value = entry.getValue();
            final Object value2 = c184.w.get(n);
            if (value == null) {
                if (value2 != null) {
                    return false;
                }
                continue;
            }
            else {
                if (!value.equals(value2)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.g.getHours() + ":" + this.g.getMinutes() + ":" + this.g.getSeconds() + "." + this.g.getTime() % 1000L + " " + this.d + ": " + this.e.x + "," + this.e.y + "," + this.e.z + " [" + this.s.f00 + "," + this.s.f01 + "," + this.s.f02 + "," + this.s.f10 + "," + this.s.f11 + "," + this.s.f12 + "," + this.s.f20 + "," + this.s.f21 + "," + this.s.f22 + "] -> " + this.h.x + "," + this.h.y + "," + this.h.z + " [" + this.b.f00 + "," + this.b.f01 + "," + this.b.f02 + "," + this.b.f10 + "," + this.b.f11 + "," + this.b.f12 + "," + this.b.f20 + "," + this.b.f21 + "," + this.b.f22 + "]\n");
        for (final Map.Entry<String, V> entry : this.l.entrySet()) {
            sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
        }
        final Iterator<O376> iterator2 = this.r.iterator();
        while (iterator2.hasNext()) {
            sb.append(iterator2.next().toString() + "\n");
        }
        return sb.toString();
    }
    
    C184(final Date g, final String d, final int q, final String j, final Vector3 e, final M47 s) {
        this.l = new HashMap();
        this.w = new HashMap();
        this.r = new LinkedList();
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.s = s;
    }
    
    C184(final Date date, final String s, final int n, final String s2, final Vector3 vector3, final M47 m47, final Map map, final Map map2) {
        this(date, s, n, s2, vector3, m47);
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            String string = null;
            if (map2 != null) {
                string = map2.get(entry.getKey());
            }
            if (string == null) {
                string = Integer.toString(entry.getKey());
            }
            g(this, string, entry.getValue());
        }
    }
}
