/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import tfu.Fa452;
import tfu.Fh453;

public final class Fl59 {
    private Fh453[] d;
    private int g;
    private ReferenceQueue j;
    private ReferenceQueue q = new ReferenceQueue();

    public static Object d(Fl59 fl59, Object object) {
        if (object == null) {
            return null;
        }
        Fl59.j(fl59);
        int n = System.identityHashCode(object);
        int n2 = n & fl59.d.length - 1;
        Fh453 fh453 = fl59.d[n2];
        while (fh453 != null) {
            if (fh453.get() == object) {
                return fh453.d.get();
            }
            fh453 = fh453.q;
        }
        return null;
    }

    private static void q(Fl59 fl59) {
        Fh453[] arrfh453 = fl59.d;
        fl59.d = new Fh453[arrfh453.length * 2];
        for (Fh453 fh453 : arrfh453) {
            while (fh453 != null) {
                Fh453 fh4532 = fh453.q;
                int n = fh453.g & fl59.d.length - 1;
                fh453.q = fl59.d[n];
                fl59.d[n] = fh453;
                fh453 = fh4532;
            }
        }
    }

    private static void j(Fl59 fl59) {
        Object object;
        WeakReference weakReference;
        while ((weakReference = (Fh453)fl59.q.poll()) != null) {
            object = weakReference.g & fl59.d.length - 1;
            Fh453 fh453 = fl59.d[object];
            if (fh453 == weakReference) {
                fl59.d[object] = weakReference.q;
                --fl59.g;
                continue;
            }
            while (fh453 != null && fh453.q != weakReference) {
                fh453 = fh453.q;
            }
            if (fh453 == null) continue;
            fh453.q = weakReference.q;
            --fl59.g;
        }
        while ((weakReference = (Fa452)fl59.j.poll()) != null) {
            object = ((Fa452)weakReference).g;
            if (object.d != weakReference) continue;
            int n = object.g & fl59.d.length - 1;
            Fh453 fh453 = fl59.d[n];
            if (fh453 == object) {
                fl59.d[n] = object.q;
                --fl59.g;
                continue;
            }
            while (fh453 != null && fh453.q != object) {
                fh453 = fh453.q;
            }
            if (fh453 == null) continue;
            fh453.q = object.q;
            --fl59.g;
        }
    }

    public Fl59() {
        this.j = new ReferenceQueue();
        this.d = new Fh453[16];
    }

    public void g(Object object, Object object2) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (object2 == null) {
            throw new NullPointerException();
        }
        Fl59.j(this);
        int n = System.identityHashCode(object);
        int n2 = n & this.d.length - 1;
        Fh453 fh453 = this.d[n2];
        if (fh453 == null) {
            this.d[n2] = new Fh453(object, this.q, n, object2, this.j);
            ++this.g;
            if (this.g >= this.d.length) {
                Fl59.q(this);
            }
        } else {
            do {
                if (fh453.get() == object) {
                    fh453.g(object2, this.j);
                    break;
                }
                if (fh453.q == null) {
                    fh453.q = new Fh453(object, this.q, n, object2, this.j);
                    ++this.g;
                    if (this.g < this.d.length) break;
                    Fl59.q(this);
                    break;
                }
                fh453 = fh453.q;
            } while (true);
        }
    }
}

