/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.T313;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tfu.Bo314;
import tfu.Me312;

public final class W311 {
    private HashSet d;
    private Me312 g = new Me312();
    private HashSet j;
    private ArrayList q;

    private static T313[] b(HashSet hashSet) {
        Object[] arrobject = hashSet.toArray(new T313[hashSet.size()]);
        Bo314.g(arrobject);
        return arrobject;
    }

    public W311(Vector3[] arrvector3) {
        this.d = new HashSet();
        this.q = new ArrayList();
        this.j = new HashSet();
        W311.g(this, arrvector3);
    }

    private void d(Vector3 vector3) {
        T313[] arrt313;
        if (this.g.contains(vector3)) {
            return;
        }
        this.g.add(vector3);
        if (this.g.size() < 4) {
            return;
        }
        if (this.g.size() == 4) {
            Iterator iterator = this.g.iterator();
            Vector3 vector32 = (Vector3)iterator.next();
            Vector3 vector33 = (Vector3)iterator.next();
            Vector3 vector34 = (Vector3)iterator.next();
            Vector3 vector35 = (Vector3)iterator.next();
            T313 t313 = new T313(vector32, vector33, vector34);
            T313 t3132 = new T313(vector32, vector34, vector33);
            if (W311.q(vector35, t313)) {
                this.d.add(t3132);
                this.j(t313, vector35);
            } else {
                this.d.add(t313);
                this.j(t3132, vector35);
            }
            this.j.clear();
            return;
        }
        for (T313 t313 : arrt313 = this.d.toArray(new T313[this.d.size()])) {
            if (!W311.q(vector3, t313)) continue;
            this.d.remove(t313);
            this.q.add(t313);
            this.j(t313, vector3);
        }
        T313[] arrt3132 = W311.b(this.j);
        for (T313 t313 : this.q) {
            if (t313.j == null) continue;
            for (Vector3 vector36 : t313.j) {
                this.s(arrt3132, vector36);
            }
        }
        this.q.clear();
        this.j.clear();
    }

    private void j(T313 t313, Vector3 vector3) {
        W311.e(this, new T313(t313.g, t313.d, vector3));
        W311.e(this, new T313(t313.d, t313.q, vector3));
        W311.e(this, new T313(t313.q, t313.g, vector3));
    }

    private static void e(W311 w311, T313 t313) {
        boolean bl = w311.d.remove(t313);
        if (bl) {
            w311.j.remove(t313);
        } else {
            w311.d.add(t313);
            w311.j.add(t313);
        }
    }

    private static void h(W311 w311, Vector3[] arrvector3) {
        T313[] arrt313 = W311.b(w311.d);
        for (Vector3 vector3 : arrvector3) {
            if (w311.g.contains(vector3)) continue;
            w311.s(arrt313, vector3);
        }
    }

    private void s(T313[] arrt313, Vector3 vector3) {
        for (T313 t313 : arrt313) {
            if (!W311.q(vector3, t313)) continue;
            if (t313.j == null) {
                t313.j = new ArrayList();
            }
            t313.j.add(vector3);
            return;
        }
        this.g.add(vector3);
    }

    public W311() {
        this.d = new HashSet();
        this.q = new ArrayList();
        this.j = new HashSet();
    }

    private static boolean q(Vector3 vector3, T313 t313) {
        Vector3 vector32;
        Vector3 vector33;
        Vector3 vector34 = Vector3.k(t313.d, t313.g);
        Vector3 vector35 = Vector3.a(vector34, vector33 = Vector3.k(t313.q, t313.g));
        return Vector3.o(vector35, vector32 = Vector3.k(vector3, t313.g)) >= 0.0f;
    }

    public static W311 g(W311 w311, Vector3[] arrvector3) {
        arrvector3 = (Vector3[])arrvector3.clone();
        Bo314.g(arrvector3);
        boolean bl = false;
        for (Vector3 vector3 : arrvector3) {
            if (!bl && w311.d.size() > 0) {
                W311.h(w311, arrvector3);
                bl = true;
            }
            w311.d(vector3);
        }
        return w311;
    }
}

