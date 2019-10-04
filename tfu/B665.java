// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.concurrent.Future;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class B665
{
    private static B665 g;
    final ConcurrentLinkedQueue d;
    
    public Future d(final S671 s671) {
        final E670 e = new E670(s671);
        this.d.add(e);
        return e;
    }
    
    public static B665 g() {
        if (B665.g == null) {
            B665.g = new B665();
        }
        return B665.g;
    }
    
    private B665() {
        this.d = new ConcurrentLinkedQueue();
    }
    
    public static void q(final B665 b665) {
        Lb33.g(Lb33.GraphicsResourceFactory);
        try {
            E670 e670;
            while ((e670 = b665.d.poll()) != null) {
                E670.q(e670);
            }
        }
        finally {
            Lb33.d(Lb33.GraphicsResourceFactory);
        }
    }
}
