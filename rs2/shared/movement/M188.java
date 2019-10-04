/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.client.GameShell3;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.U186;

public class M188 {
    private static int b;
    static float h;
    private static List l;
    private static final Logger logger;
    public static boolean q;
    public static boolean s;
    private final boolean d;
    final List e;
    final List j = new LinkedList();

    public static void e() {
        ++b;
    }

    private static void b(M188 m188) {
        while (m188.j.size() > b && !m188.j.isEmpty()) {
            m188.e.add(m188.j.remove(0));
        }
    }

    public static Object j(M188 m188) {
        int n = m188.j.size();
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return m188.j.get(0);
        }
        int n2 = (int)Math.floor(h) + 1;
        if (n2 < 0) {
            return null;
        }
        if (n2 >= n - 1) {
            return m188.j.get(n - 1);
        }
        return m188.j.get(n2);
    }

    public M188(boolean bl) {
        this.e = new LinkedList();
        this.d = bl;
        l.add(new WeakReference<M188>(this));
    }

    public static void h(float f) {
        float f2 = 1.0f / GameShell3.getPhysicsSpeed();
        float f3 = f / f2;
        int n = (int)(h += f3);
        b -= n;
        h -= (float)n;
        ListIterator listIterator = l.listIterator();
        while (listIterator.hasNext()) {
            WeakReference weakReference = (WeakReference)listIterator.next();
            M188 m188 = (M188)weakReference.get();
            if (m188 == null) {
                listIterator.remove();
                continue;
            }
            M188.b(m188);
        }
    }

    public static void d(M188 m188, Object object) {
        m188.j.add(object);
        if (object instanceof U186) {
            ((U186)object).z = System.nanoTime();
        }
    }

    public static float l(M188 m188) {
        int n = m188.j.size();
        if (h >= (float)(n - 1)) {
            if (m188.d) {
                q = true;
            }
            return h + 2.0f - (float)n;
        }
        if (m188.d) {
            q = false;
        }
        return h;
    }

    private static void r(M188 m188) {
        while (!m188.j.isEmpty()) {
            m188.e.add(m188.j.remove(0));
        }
    }

    static {
        logger = LoggerFactory.getLogger(M188.class);
        q = false;
        h = 0.0f;
        s = false;
        b = 0;
        l = new LinkedList();
    }

    public static float s() {
        return (float)(b - 1) - h;
    }

    public static Object q(M188 m188) {
        int n = m188.j.size();
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return m188.j.get(0);
        }
        int n2 = (int)Math.floor(h);
        if (n2 < 0) {
            return null;
        }
        if (n2 >= n - 1) {
            return m188.j.get(n - 2);
        }
        return m188.j.get(n2);
    }

    public static void w() {
        ListIterator listIterator = l.listIterator();
        while (listIterator.hasNext()) {
            WeakReference weakReference = (WeakReference)listIterator.next();
            M188 m188 = (M188)weakReference.get();
            if (m188 == null) {
                listIterator.remove();
                continue;
            }
            M188.r(m188);
        }
        h = 0.0f;
        b = 0;
    }

    public static Object g(M188 m188) {
        if (m188.e.isEmpty()) {
            return null;
        }
        return m188.e.remove(0);
    }
}

