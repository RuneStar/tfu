/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.Vector3;
import com.jagex.maths.Z165;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ai354;
import tfu.Fk353;
import tfu.Fp460;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ie21;
import tfu.Ik357;
import tfu.It12;

public class Ka25
extends It12 {
    private static final Logger logger = LoggerFactory.getLogger(Ka25.class);
    public Vector3[] d = null;
    public Ie21 e = Ie21.GENERIC_STATIC_MESH;
    public String h;
    public int[] j = null;
    public int[] q = null;
    public int s;

    public Ka25(Fk353 fk353) {
        this.h = null;
        this.s(fk353);
        this.e = Ie21.GENERIC_STATIC_MESH;
        this.s = -1;
    }

    public static Ka25 h(Gg3 gg3, Hi86 hi86, Z165 z165, boolean bl) {
        Z165.q(z165);
        Gg3.bm(gg3);
        int n = Gg3.bm(gg3);
        if (n == -1) {
            return null;
        }
        try {
            Fk353 fk353 = (Fk353)hi86.j(Fk353.class, n);
            if (bl) {
                Object[] arrobject = new Object[]{n, fk353.s, fk353.m / 3};
                logger.info("    static mesh fully loaded: js5_index = {} numVertices {} numTriangles {}", arrobject);
            }
            return new Ka25(fk353);
        }
        catch (Ik357 ik357) {
            logger.error("Error while loading mesh_raw file", ik357);
            return null;
        }
    }

    private void s(Fk353 fk353) {
        int n;
        int n2;
        int n3 = fk353.s;
        this.d = new Vector3[n3];
        for (n = 0; n < n3; ++n) {
            float f = (float)fk353.b[n] * Ai354.q / fk353.n;
            float f2 = (float)fk353.l[n] * Ai354.q / fk353.n;
            float f3 = (float)fk353.w[n] * Ai354.q / fk353.n;
            this.d[n] = new Vector3(f, f2, f3);
        }
        n = 0;
        for (n2 = 0; n2 < fk353.u; ++n2) {
            n += fk353.z[n2].g;
        }
        this.q = new int[n * 3];
        this.j = new int[n];
        n = 0;
        for (n2 = 0; n2 < fk353.u; ++n2) {
            for (int i = 0; i < fk353.z[n2].g; ++i) {
                assert (0 <= fk353.z[n2].e[i] && fk353.z[n2].e[i] < this.d.length);
                assert (0 <= fk353.z[n2].h[i] && fk353.z[n2].h[i] < this.d.length);
                assert (0 <= fk353.z[n2].s[i] && fk353.z[n2].s[i] < this.d.length);
                this.q[n * 3 + 0] = fk353.z[n2].e[i];
                this.q[n * 3 + 1] = fk353.z[n2].h[i];
                this.q[n * 3 + 2] = fk353.z[n2].s[i];
                this.j[n] = fk353.z[n2].b;
                ++n;
            }
        }
    }

    @Override
    public Ie21 g() {
        return this.e;
    }

    public static Ka25 e(Gg3 gg3, Z165 z165, boolean bl) {
        Z165.q(z165);
        Gg3.bm(gg3);
        String string = gg3.bp();
        if (bl) {
            logger.info("    static mesh: meshName = \"{}\"", (Object)string);
        }
        return new Ka25(string);
    }

    public Ka25(String string) {
        this.h = string;
        this.s = -1;
        this.e = Ie21.GENERIC_STATIC_MESH;
    }
}

