/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import tfu.Fd458;

public final class Fo439 {
    private Fd458[] d;
    private int g;
    private ReferenceQueue q = new ReferenceQueue();

    public void g(Object object, Object object2) {
        if (object == null) {
            throw new NullPointerException();
        }
        Fo439.e(this);
        int n = System.identityHashCode(object);
        int n2 = n & this.d.length - 1;
        Fd458 fd458 = this.d[n2];
        if (fd458 == null) {
            this.d[n2] = new Fd458(object, this.q, n, object2);
            ++this.g;
            if (this.g >= this.d.length) {
                Fo439.j(this);
            }
        } else {
            do {
                if (fd458.get() == object) {
                    fd458.d = object2;
                    break;
                }
                if (fd458.q == null) {
                    fd458.q = new Fd458(object, this.q, n, object2);
                    ++this.g;
                    if (this.g < this.d.length) break;
                    Fo439.j(this);
                    break;
                }
                fd458 = fd458.q;
            } while (true);
        }
    }

    public static Object d(Fo439 fo439, Object object) {
        if (object == null) {
            return null;
        }
        Fo439.e(fo439);
        int n = System.identityHashCode(object);
        int n2 = n & fo439.d.length - 1;
        Fd458 fd458 = fo439.d[n2];
        while (fd458 != null) {
            if (fd458.get() == object) {
                return fd458.d;
            }
            fd458 = fd458.q;
        }
        return null;
    }

    public Fo439() {
        this.d = new Fd458[16];
    }

    private static void j(Fo439 fo439) {
        Fd458[] arrfd458 = fo439.d;
        fo439.d = new Fd458[arrfd458.length * 2];
        for (Fd458 fd458 : arrfd458) {
            while (fd458 != null) {
                Fd458 fd4582 = fd458.q;
                int n = fd458.g & fo439.d.length - 1;
                fd458.q = fo439.d[n];
                fo439.d[n] = fd458;
                fd458 = fd4582;
            }
        }
    }

    private static void e(Fo439 fo439) {
        Fd458 fd458;
        while ((fd458 = (Fd458)fo439.q.poll()) != null) {
            int n = fd458.g & fo439.d.length - 1;
            Fd458 fd4582 = fo439.d[n];
            if (fd4582 == fd458) {
                fo439.d[n] = fd458.q;
                --fo439.g;
                continue;
            }
            while (fd4582 != null && fd4582.q != fd458) {
                fd4582 = fd4582.q;
            }
            if (fd4582 == null) continue;
            fd4582.q = fd458.q;
            --fo439.g;
        }
        return;
    }

    public static void q(Fo439 fo439, Object object) {
        if (object == null) {
            return;
        }
        Fo439.e(fo439);
        int n = System.identityHashCode(object);
        int n2 = n & fo439.d.length - 1;
        Fd458 fd458 = fo439.d[n2];
        if (fd458 == null) {
            return;
        }
        if (fd458.get() == object) {
            fo439.d[n2] = fd458.q;
            --fo439.g;
        } else {
            Fd458 fd4582;
            while ((fd4582 = fd458.q) != null) {
                if (fd4582.get() == object) {
                    fd458.q = fd4582.q;
                    --fo439.g;
                    break;
                }
                fd458 = fd4582;
            }
        }
    }
}

