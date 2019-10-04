// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.core.constants.J204;
import com.jagex.core.constants.E294;
import java.util.ArrayList;
import org.slf4j.Logger;

public class Fc454 implements Hp62
{
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
    public Fs455 t;
    public int u;
    public String v;
    public int x;
    public String y;
    public Ig436 z;
    
    public Fc454(final byte[] array) {
        this.t = Fs455.PPL;
        this.m = new ArrayList();
        final Gg3 gg3 = new Gg3(array);
        final int ar = Gg3.ar(gg3);
        if (ar > 9) {
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
        if (ar >= 2) {
            this.z = (Ig436)E294.d(Ig436.values(), Gg3.ax(gg3));
        }
        else {
            this.z = Ig436.ALPHA_BLENDED;
        }
        if (ar >= 3) {
            final int ar2 = Gg3.ar(gg3);
            final int ar3 = Gg3.ar(gg3);
            this.t = Fs455.g(ar2);
            if (this.t == null) {
                this.t = Fs455.PPL;
            }
            if (ar < 8) {
                for (int i = 0; i < ar3; ++i) {
                    Gg3.bl(gg3);
                }
            }
            else {
                this.t = Fs455.g(ar2);
                for (int j = 0; j < ar3; ++j) {
                    final String bp = gg3.bp();
                    final int ar4 = Gg3.ar(gg3);
                    final float[] array2 = new float[ar4];
                    for (int k = 0; k < ar4; ++k) {
                        array2[k] = Gg3.bl(gg3);
                    }
                    this.m.add(new Fq456(bp, array2));
                }
            }
            if (ar >= 8) {
                this.n = Gg3.bl(gg3);
                this.k = Gg3.bl(gg3);
            }
            else if (ar == 7) {
                this.m.add(new Fq456("UVTransSpeed", new float[] { Gg3.bl(gg3), Gg3.bl(gg3) }));
                this.n = Gg3.bl(gg3);
                this.k = Gg3.bl(gg3);
                this.m.add(new Fq456("UVRotOrigin", new float[] { Gg3.bl(gg3), Gg3.bl(gg3) }));
                this.m.add(new Fq456("UVRotSpeed", new float[] { Gg3.bl(gg3) }));
            }
            else if (ar >= 4) {
                this.m.add(new Fq456("UVTransSpeed", new float[] { Gg3.bl(gg3), Gg3.bl(gg3) }));
                this.n = Gg3.bl(gg3);
                this.k = Gg3.bl(gg3);
            }
            else {
                final float bl = Gg3.bl(gg3);
                final float bl2 = Gg3.bl(gg3);
                this.n = 0.0625f;
                this.k = 0.0625f;
                this.m.add(new Fq456("UVTransSpeed", new float[] { bl * this.n, bl2 * this.k }));
            }
        }
        else {
            this.t = Fs455.PPL;
        }
    }
    
    public static void g(final Fc454 fc454, final String anObject, final float[] array) {
        for (int i = 0; i < fc454.m.size(); ++i) {
            if (((Fq456)fc454.m.get(i)).g.equals(anObject)) {
                final float[] d = fc454.m.get(i).d;
                if (d.length == array.length) {
                    for (int j = 0; j < array.length; ++j) {
                        array[j] = d[j];
                    }
                }
            }
        }
    }
    
    public Fc454() {
        this.t = Fs455.PPL;
        this.m = new ArrayList();
        this.z = Ig436.OPAQUE;
        final int p = -1;
        this.u = p;
        this.x = p;
        this.p = p;
    }
    
    static {
        logger = LoggerFactory.getLogger(Fc454.class);
        i = new Fz457();
    }
    
    @Override
    public void onAllRefsReleased() {
    }
}
