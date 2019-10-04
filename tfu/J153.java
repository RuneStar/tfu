// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.jnibindings.runetek6.StateEventManager;

public class J153
{
    protected static final int d = 4;
    protected static long e;
    protected static final int g = 2;
    protected static boolean h;
    protected static long j;
    protected static int q;
    
    protected static void j(final Gg3 gg3) {
        if (J153.h) {
            final int aj = Gg3.aj(gg3);
            gg3.v -= 2;
            short n = (short)(Kc180.p(J153.j) + 2);
            final byte[] array = new byte[aj];
            Gg3.bx(gg3, array, 0, aj);
            for (int i = 0; i < aj; ++i, ++n) {
                Kc180.b(J153.j + n, array[i]);
            }
            Kc180.w(J153.j, (short)(n - 2));
        }
    }
    
    public static void g() {
        if (J153.h) {
            J153.j = Kc180.g(J153.q);
            J153.e = Kc180.g(J153.q);
            StateEventManager.initEventsBuffers(J153.j, J153.e, J153.q);
        }
    }
    
    protected static boolean d() {
        return Kc180.p(J153.e) > 0;
    }
    
    static {
        J153.q = 4096;
        J153.j = 0L;
        J153.e = 0L;
        J153.h = true;
    }
    
    protected static int q(final int n, final Q475 q475) {
        if (!J153.h) {
            return 0;
        }
        if (Kc180.p(J153.e) > n) {
            final short p2 = Kc180.p(J153.e + n);
            final int x = Kc180.x(J153.e + n + 2L);
            if (x != 0) {
                q475.g = Bb4.s(x);
            }
            else {
                q475.g = null;
            }
            Gg3.i(q475.d = new Gg3(p2 + 2), p2);
            final byte[] array = new byte[p2];
            for (short n2 = 0; n2 < p2; ++n2) {
                array[n2] = Kc180.y(J153.e + n + n2);
            }
            Gg3.aa(q475.d, array, 0, p2);
            return n + p2;
        }
        return 0;
    }
}
