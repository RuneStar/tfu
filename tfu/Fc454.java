/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.constants.E294;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Fq456;
import tfu.Fs455;
import tfu.Fz457;
import tfu.Gg3;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Ig436;

public class Fc454
implements Hp62 {
    public static final int b = 4;
    private static final int d = 9;
    public static final int e = 1;
    public static final int h = 2;
    public static final Ia63 i;
    private static final int j = -87097619;
    public static final int l = 6;
    private static final Logger logger;
    private static final int q = 2;
    public static final int s = 3;
    public static final int w = 0;
    public float k;
    public ArrayList m;
    public float n;
    public int p;
    public String r;
    public Fs455 t = Fs455.PPL;
    public int u;
    public String v;
    public int x;
    public String y;
    public Ig436 z;

    public Fc454(byte[] arrby) {
        this.m = new ArrayList();
        Gg3 gg3 = new Gg3(arrby);
        int n = Gg3.ar(gg3);
        if (n > 9) {
            throw new RuntimeException();
        }
        this.p = Gg3.au(gg3);
        if (this.p == 65535) {
            this.p = -1;
        }
        this.x = Gg3.au(gg3);
        if (this.x == 65535) {
            this.x = -1;
        }
        this.u = Gg3.au(gg3);
        if (this.u == 65535) {
            this.u = -1;
        }
        this.z = n >= 2 ? (Ig436)E294.d(Ig436.values(), Gg3.ax(gg3)) : Ig436.ALPHA_BLENDED;
        if (n >= 3) {
            int n2;
            int n3 = Gg3.ar(gg3);
            int n4 = Gg3.ar(gg3);
            this.t = Fs455.g(n3);
            if (this.t == null) {
                this.t = Fs455.PPL;
            }
            if (n < 8) {
                for (n2 = 0; n2 < n4; ++n2) {
                    Gg3.bl(gg3);
                }
            } else {
                this.t = Fs455.g(n3);
                for (n2 = 0; n2 < n4; ++n2) {
                    String string = gg3.bp();
                    int n5 = Gg3.ar(gg3);
                    float[] arrf = new float[n5];
                    for (int i = 0; i < n5; ++i) {
                        arrf[i] = Gg3.bl(gg3);
                    }
                    Fq456 fq456 = new Fq456(string, arrf);
                    this.m.add(fq456);
                }
            }
            if (n >= 8) {
                this.n = Gg3.bl(gg3);
                this.k = Gg3.bl(gg3);
            } else if (n == 7) {
                this.m.add(new Fq456("UVTransSpeed", new float[]{Gg3.bl(gg3), Gg3.bl(gg3)}));
                this.n = Gg3.bl(gg3);
                this.k = Gg3.bl(gg3);
                this.m.add(new Fq456("UVRotOrigin", new float[]{Gg3.bl(gg3), Gg3.bl(gg3)}));
                this.m.add(new Fq456("UVRotSpeed", new float[]{Gg3.bl(gg3)}));
            } else if (n >= 4) {
                this.m.add(new Fq456("UVTransSpeed", new float[]{Gg3.bl(gg3), Gg3.bl(gg3)}));
                this.n = Gg3.bl(gg3);
                this.k = Gg3.bl(gg3);
            } else {
                float f = Gg3.bl(gg3);
                float f2 = Gg3.bl(gg3);
                this.n = 0.0625f;
                this.k = 0.0625f;
                this.m.add(new Fq456("UVTransSpeed", new float[]{f *= this.n, f2 *= this.k}));
            }
        } else {
            this.t = Fs455.PPL;
        }
    }

    public static void g(Fc454 fc454, String string, float[] arrf) {
        for (int i = 0; i < fc454.m.size(); ++i) {
            float[] arrf2;
            if (!((Fq456)fc454.m.get((int)i)).g.equals(string) || (arrf2 = ((Fq456)fc454.m.get((int)i)).d).length != arrf.length) continue;
            for (int j = 0; j < arrf.length; ++j) {
                arrf[j] = arrf2[j];
            }
        }
    }

    public Fc454() {
        this.m = new ArrayList();
        this.z = Ig436.OPAQUE;
        this.u = -1;
        this.x = -1;
        this.p = -1;
    }

    static {
        logger = LoggerFactory.getLogger(Fc454.class);
        i = new Fz457();
    }

    @Override
    public void onAllRefsReleased() {
    }
}

