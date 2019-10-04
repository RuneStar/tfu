// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.maths.Z165;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;

public class Ka25 extends It12
{
    private static final Logger logger;
    public Vector3[] d;
    public Ie21 e;
    public String h;
    public int[] j;
    public int[] q;
    public int s;
    static final /* synthetic */ boolean b;
    
    public Ka25(final Fk353 fk353) {
        this.d = null;
        this.q = null;
        this.j = null;
        this.e = Ie21.GENERIC_STATIC_MESH;
        this.h = null;
        this.s(fk353);
        this.e = Ie21.GENERIC_STATIC_MESH;
        this.s = -1;
    }
    
    public static Ka25 h(final Gg3 gg3, final Hi86 hi86, final Z165 z165, final boolean b) {
        Z165.q(z165);
        Gg3.bm(gg3);
        final int bm = Gg3.bm(gg3);
        if (bm == -1) {
            return null;
        }
        try {
            final Fk353 fk353 = (Fk353)hi86.j(Fk353.class, bm);
            if (b) {
                Ka25.logger.info("    static mesh fully loaded: js5_index = {} numVertices {} numTriangles {}", new Object[] { bm, fk353.s, fk353.m / 3 });
            }
            return new Ka25(fk353);
        }
        catch (Ik357 ik357) {
            Ka25.logger.error("Error while loading mesh_raw file", ik357);
            return null;
        }
    }
    
    private void s(final Fk353 fk353) {
        final int s = fk353.s;
        this.d = new Vector3[s];
        for (int i = 0; i < s; ++i) {
            this.d[i] = new Vector3(fk353.b[i] * Ai354.q / fk353.n, fk353.l[i] * Ai354.q / fk353.n, fk353.w[i] * Ai354.q / fk353.n);
        }
        int n = 0;
        for (int j = 0; j < fk353.u; ++j) {
            n += fk353.z[j].g;
        }
        this.q = new int[n * 3];
        this.j = new int[n];
        int n2 = 0;
        for (int k = 0; k < fk353.u; ++k) {
            for (int l = 0; l < fk353.z[k].g; ++l) {
                if (!Ka25.b && (0 > fk353.z[k].e[l] || fk353.z[k].e[l] >= this.d.length)) {
                    throw new AssertionError();
                }
                if (!Ka25.b && (0 > fk353.z[k].h[l] || fk353.z[k].h[l] >= this.d.length)) {
                    throw new AssertionError();
                }
                if (!Ka25.b && (0 > fk353.z[k].s[l] || fk353.z[k].s[l] >= this.d.length)) {
                    throw new AssertionError();
                }
                this.q[n2 * 3 + 0] = fk353.z[k].e[l];
                this.q[n2 * 3 + 1] = fk353.z[k].h[l];
                this.q[n2 * 3 + 2] = fk353.z[k].s[l];
                this.j[n2] = fk353.z[k].b;
                ++n2;
            }
        }
    }
    
    @Override
    public Ie21 g() {
        return this.e;
    }
    
    static {
        b = !Ka25.class.desiredAssertionStatus();
        logger = LoggerFactory.getLogger(Ka25.class);
    }
    
    public static Ka25 e(final Gg3 gg3, final Z165 z165, final boolean b) {
        Z165.q(z165);
        Gg3.bm(gg3);
        final String bp = gg3.bp();
        if (b) {
            Ka25.logger.info("    static mesh: meshName = \"{}\"", bp);
        }
        return new Ka25(bp);
    }
    
    public Ka25(final String h) {
        this.d = null;
        this.q = null;
        this.j = null;
        this.e = Ie21.GENERIC_STATIC_MESH;
        this.h = h;
        this.s = -1;
        this.e = Ie21.GENERIC_STATIC_MESH;
    }
}
