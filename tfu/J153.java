/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.StateEventManager;
import tfu.Bb4;
import tfu.Gg3;
import tfu.Kc180;
import tfu.Q475;

public class J153 {
    protected static final int d = 4;
    protected static long e;
    protected static final int g = 2;
    protected static boolean h;
    protected static long j;
    protected static int q;

    protected static void j(Gg3 gg3) {
        if (h) {
            int n = Gg3.aj(gg3);
            gg3.v -= 2;
            short s = Kc180.p(j);
            s = (short)(s + 2);
            byte[] arrby = new byte[n];
            Gg3.bx(gg3, arrby, 0, n);
            int n2 = 0;
            while (n2 < n) {
                Kc180.b(j + (long)s, arrby[n2]);
                ++n2;
                s = (short)(s + 1);
            }
            Kc180.w(j, (short)(s - 2));
        }
    }

    public static void g() {
        if (h) {
            j = Kc180.g(q);
            e = Kc180.g(q);
            StateEventManager.initEventsBuffers(j, e, q);
        }
    }

    protected static boolean d() {
        return Kc180.p(e) > 0;
    }

    static {
        q = 4096;
        j = 0L;
        e = 0L;
        h = true;
    }

    protected static int q(int n, Q475 q475) {
        if (!h) {
            return 0;
        }
        short s = Kc180.p(e);
        if (s > n) {
            int n2 = Kc180.p(e + (long)n);
            int n3 = Kc180.x(e + (long)n + 2L);
            q475.g = n3 != 0 ? Bb4.s(n3) : null;
            int n4 = n2 + 2;
            q475.d = new Gg3(n4);
            Gg3.i(q475.d, n2);
            byte[] arrby = new byte[n2];
            for (int i = 0; i < n2; ++i) {
                arrby[i] = Kc180.y(e + (long)n + (long)i);
            }
            Gg3.aa(q475.d, arrby, 0, n2);
            return n + n2;
        }
        return 0;
    }
}

