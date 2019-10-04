/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import tfu.E670;
import tfu.Lb33;
import tfu.S671;

public final class B665 {
    private static B665 g;
    final ConcurrentLinkedQueue d = new ConcurrentLinkedQueue();

    public Future d(S671 s671) {
        E670 e670 = new E670(s671);
        this.d.add(e670);
        return e670;
    }

    public static B665 g() {
        if (g == null) {
            g = new B665();
        }
        return g;
    }

    private B665() {
    }

    public static void q(B665 b665) {
        Lb33.g(Lb33.GraphicsResourceFactory);
        try {
            E670 e670;
            while ((e670 = (E670)b665.d.poll()) != null) {
                E670.q(e670);
            }
            Lb33.d(Lb33.GraphicsResourceFactory);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.GraphicsResourceFactory);
            throw throwable;
        }
    }
}

