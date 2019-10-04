// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import java.util.Iterator;
import tfu.Bo314;
import java.util.ArrayList;
import tfu.Me312;
import java.util.HashSet;

public final class W311
{
    private HashSet d;
    private Me312 g;
    private HashSet j;
    private ArrayList q;
    
    private static T313[] b(final HashSet set) {
        final T313[] array = (T313[])set.toArray(new T313[set.size()]);
        Bo314.g(array);
        return array;
    }
    
    public W311(final Vector3[] array) {
        this.g = new Me312();
        this.d = new HashSet();
        this.q = new ArrayList();
        this.j = new HashSet();
        g(this, array);
    }
    
    private void d(final Vector3 vector3) {
        if (this.g.contains(vector3)) {
            return;
        }
        this.g.add(vector3);
        if (this.g.size() < 4) {
            return;
        }
        if (this.g.size() == 4) {
            final Iterator iterator = this.g.iterator();
            final Vector3 vector4 = iterator.next();
            final Vector3 vector5 = iterator.next();
            final Vector3 vector6 = iterator.next();
            final Vector3 vector7 = iterator.next();
            final T313 e = new T313(vector4, vector5, vector6);
            final T313 e2 = new T313(vector4, vector6, vector5);
            if (q(vector7, e)) {
                this.d.add(e2);
                this.j(e, vector7);
            }
            else {
                this.d.add(e);
                this.j(e2, vector7);
            }
            this.j.clear();
            return;
        }
        for (final T313 t313 : (T313[])this.d.toArray(new T313[this.d.size()])) {
            if (q(vector3, t313)) {
                this.d.remove(t313);
                this.q.add(t313);
                this.j(t313, vector3);
            }
        }
        final T313[] b = b(this.j);
        for (final T313 t314 : this.q) {
            if (t314.j != null) {
                final Iterator iterator3 = t314.j.iterator();
                while (iterator3.hasNext()) {
                    this.s(b, iterator3.next());
                }
            }
        }
        this.q.clear();
        this.j.clear();
    }
    
    private void j(final T313 t313, final Vector3 vector3) {
        e(this, new T313(t313.g, t313.d, vector3));
        e(this, new T313(t313.d, t313.q, vector3));
        e(this, new T313(t313.q, t313.g, vector3));
    }
    
    private static void e(final W311 w311, final T313 t313) {
        if (w311.d.remove(t313)) {
            w311.j.remove(t313);
        }
        else {
            w311.d.add(t313);
            w311.j.add(t313);
        }
    }
    
    private static void h(final W311 w311, final Vector3[] array) {
        final T313[] b = b(w311.d);
        for (final Vector3 vector3 : array) {
            if (!w311.g.contains(vector3)) {
                w311.s(b, vector3);
            }
        }
    }
    
    private void s(final T313[] array, final Vector3 e) {
        for (final T313 t313 : array) {
            if (q(e, t313)) {
                if (t313.j == null) {
                    t313.j = new ArrayList();
                }
                t313.j.add(e);
                return;
            }
        }
        this.g.add(e);
    }
    
    public W311() {
        this.g = new Me312();
        this.d = new HashSet();
        this.q = new ArrayList();
        this.j = new HashSet();
    }
    
    private static boolean q(final Vector3 vector3, final T313 t313) {
        return Vector3.o(Vector3.a(Vector3.k(t313.d, t313.g), Vector3.k(t313.q, t313.g)), Vector3.k(vector3, t313.g)) >= 0.0f;
    }
    
    public static W311 g(final W311 w311, Vector3[] array) {
        array = array.clone();
        Bo314.g(array);
        int n = 0;
        for (final Vector3 vector3 : array) {
            if (n == 0 && w311.d.size() > 0) {
                h(w311, array);
                n = 1;
            }
            w311.d(vector3);
        }
        return w311;
    }
}
