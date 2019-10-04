/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.xelement.As109;
import com.jagex.game.runetek6.xelement.Av106;
import com.jagex.game.runetek6.xelement.Bh77;
import com.jagex.game.runetek6.xelement.T101;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import tfu.Bn279;
import tfu.Bt286;
import tfu.Bv351;
import tfu.G289;
import tfu.Hi86;

public class D285 {
    private static final Logger logger = LoggerFactory.getLogger(D285.class);
    public final Bt286 b;
    private final int d;
    final int e;
    final float h;
    final int j;
    private final List l = new LinkedList();
    private final int q;
    private List r;
    private T101 s;
    private Bn279 w;

    public boolean g() {
        try {
            Iterator iterator;
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
                float f = (float)this.j + this.h;
                float f2 = (float)this.e + this.h;
                HashSet<Object> hashSet = new HashSet<Object>();
                for (Object object : this.s.z) {
                    float f3 = (float)((As109)object).g * this.s.e - (float)this.j;
                    float f4 = (float)((As109)object).d * this.s.e - (float)this.e;
                    this.l.add(new G289((Integer)((As109)object).e, f3, f4));
                    if (hashSet.contains(((As109)object).e)) continue;
                    hashSet.add(((As109)object).e);
                }
                this.r = new LinkedList();
                iterator = hashSet.iterator();
                while (iterator.hasNext()) {
                    int n = (Integer)iterator.next();
                    Bn279 bn279 = client.lh.e(Bh77.class, n, 0, null, n);
                    this.r.add(bn279);
                }
            }
            if (!this.r.isEmpty()) {
                Iterator iterator2 = this.r.iterator();
                while (iterator2.hasNext()) {
                    Bn279 bn279 = (Bn279)iterator2.next();
                    if (!Bn279.g(bn279)) continue;
                    int n = (Integer)bn279.j;
                    iterator = (Bh77)bn279.d();
                    for (G289 g289 : this.l) {
                        if (g289.g != n) continue;
                        g289.j = iterator;
                    }
                    iterator2.remove();
                }
                if (!this.r.isEmpty()) {
                    return false;
                }
            }
        }
        catch (ExecutionException executionException) {
            logger.error("", executionException);
        }
        return true;
    }

    public static List q(D285 d285) {
        return d285.l;
    }

    public D285(int n, int n2, Bt286 bt286, int n3, int n4, float f) {
        this.d = n;
        this.q = n2;
        this.b = bt286;
        this.j = n3;
        this.e = n4;
        this.h = f;
    }

    public static int d(D285 d285) {
        return d285.d;
    }

    public static boolean j(D285 d285) {
        if (d285.s == null) {
            return true;
        }
        return d285.s.j == Av106.FULL;
    }
}

