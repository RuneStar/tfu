// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import org.slf4j.LoggerFactory;
import java.util.ListIterator;
import com.jagex.game.runetek6.client.GameShell3;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import org.slf4j.Logger;
import java.util.List;

public class M188
{
    private static int b;
    static float h;
    private static List l;
    private static final Logger logger;
    public static boolean q;
    public static boolean s;
    private final boolean d;
    final List e;
    final List j;
    
    public static void e() {
        ++M188.b;
    }
    
    private static void b(final M188 m188) {
        while (m188.j.size() > M188.b && !m188.j.isEmpty()) {
            m188.e.add(m188.j.remove(0));
        }
    }
    
    public static Object j(final M188 m188) {
        final int size = m188.j.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return m188.j.get(0);
        }
        final int n = (int)Math.floor(M188.h) + 1;
        if (n < 0) {
            return null;
        }
        if (n >= size - 1) {
            return m188.j.get(size - 1);
        }
        return m188.j.get(n);
    }
    
    public M188(final boolean d) {
        this.j = new LinkedList();
        this.e = new LinkedList();
        this.d = d;
        M188.l.add(new WeakReference<M188>(this));
    }
    
    public static void h(final float n) {
        M188.h += n / (1.0f / GameShell3.getPhysicsSpeed());
        final int n2 = (int)M188.h;
        M188.b -= n2;
        M188.h -= n2;
        final ListIterator<WeakReference<M188>> listIterator = (ListIterator<WeakReference<M188>>)M188.l.listIterator();
        while (listIterator.hasNext()) {
            final M188 m188 = listIterator.next().get();
            if (m188 == null) {
                listIterator.remove();
            }
            else {
                b(m188);
            }
        }
    }
    
    public static void d(final M188 m188, final Object o) {
        m188.j.add(o);
        if (o instanceof U186) {
            ((U186)o).z = System.nanoTime();
        }
    }
    
    public static float l(final M188 m188) {
        final int size = m188.j.size();
        if (M188.h >= size - 1) {
            if (m188.d) {
                M188.q = true;
            }
            return M188.h + 2.0f - size;
        }
        if (m188.d) {
            M188.q = false;
        }
        return M188.h;
    }
    
    private static void r(final M188 m188) {
        while (!m188.j.isEmpty()) {
            m188.e.add(m188.j.remove(0));
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(M188.class);
        M188.q = false;
        M188.h = 0.0f;
        M188.s = false;
        M188.b = 0;
        M188.l = new LinkedList();
    }
    
    public static float s() {
        return M188.b - 1 - M188.h;
    }
    
    public static Object q(final M188 m188) {
        final int size = m188.j.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return m188.j.get(0);
        }
        final int n = (int)Math.floor(M188.h);
        if (n < 0) {
            return null;
        }
        if (n >= size - 1) {
            return m188.j.get(size - 2);
        }
        return m188.j.get(n);
    }
    
    public static void w() {
        final ListIterator<WeakReference<M188>> listIterator = (ListIterator<WeakReference<M188>>)M188.l.listIterator();
        while (listIterator.hasNext()) {
            final M188 m188 = listIterator.next().get();
            if (m188 == null) {
                listIterator.remove();
            }
            else {
                r(m188);
            }
        }
        M188.h = 0.0f;
        M188.b = 0;
    }
    
    public static Object g(final M188 m188) {
        if (m188.e.isEmpty()) {
            return null;
        }
        return m188.e.remove(0);
    }
}
