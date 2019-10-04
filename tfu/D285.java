// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.game.runetek6.xelement.Av106;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import com.jagex.game.runetek6.xelement.Bh77;
import java.util.LinkedList;
import com.jagex.game.runetek6.xelement.As109;
import java.util.HashSet;
import rs2.client.client;
import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.xelement.T101;
import java.util.List;
import org.slf4j.Logger;

public class D285
{
    private static final Logger logger;
    public final Bt286 b;
    private final int d;
    final int e;
    final float h;
    final int j;
    private final List l;
    private final int q;
    private List r;
    private T101 s;
    private Bn279 w;
    
    static {
        logger = LoggerFactory.getLogger(D285.class);
    }
    
    public boolean g() {
        try {
            if (this.s == null) {
                if (this.w == null) {
                    this.w = client.lh.e(T101.class, this.q, 0, null, null);
                }
                if (!Bn279.g(this.w)) {
                    return false;
                }
                this.s = (T101)this.w.d();
            }
            if (this.r == null) {
                final float n = this.j + this.h;
                final float n2 = this.e + this.h;
                final HashSet<Integer> set = new HashSet<Integer>();
                for (final As109 as109 : this.s.z) {
                    this.l.add(new G289((int)as109.e, as109.g * this.s.e - this.j, as109.d * this.s.e - this.e));
                    if (!set.contains(as109.e)) {
                        set.add((Integer)as109.e);
                    }
                }
                this.r = new LinkedList();
                for (final int intValue : set) {
                    this.r.add(client.lh.e(Bh77.class, intValue, 0, null, intValue));
                }
            }
            if (!this.r.isEmpty()) {
                final Iterator iterator3 = this.r.iterator();
                while (iterator3.hasNext()) {
                    final Bn279 bn279 = iterator3.next();
                    if (Bn279.g(bn279)) {
                        final int intValue2 = (int)bn279.j;
                        final Bh77 j = (Bh77)bn279.d();
                        for (final G289 g289 : this.l) {
                            if (g289.g == intValue2) {
                                g289.j = j;
                            }
                        }
                        iterator3.remove();
                    }
                }
                if (!this.r.isEmpty()) {
                    return false;
                }
            }
        }
        catch (ExecutionException ex) {
            D285.logger.error("", ex);
        }
        return true;
    }
    
    public static List q(final D285 d285) {
        return d285.l;
    }
    
    public D285(final int d, final int q, final Bt286 b, final int j, final int e, final float h) {
        this.l = new LinkedList();
        this.d = d;
        this.q = q;
        this.b = b;
        this.j = j;
        this.e = e;
        this.h = h;
    }
    
    public static int d(final D285 d285) {
        return d285.d;
    }
    
    public static boolean j(final D285 d285) {
        return d285.s == null || d285.s.j == Av106.FULL;
    }
}
