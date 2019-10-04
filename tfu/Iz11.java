// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.maths.Matrix4;
import com.jagex.maths.O166;
import com.jagex.maths.Q10;
import com.jagex.maths.Z165;
import java.util.LinkedList;
import com.jagex.maths.RotTrans;
import org.slf4j.Logger;

public class Iz11 implements Hp62
{
    public static final int d = 4;
    public static final Ia63 e;
    private static final Logger logger;
    public final RotTrans[] j;
    public final It12[] q;
    
    public static Iz11 g(final Gg3 gg3, final Hi86 hi86, final boolean b, final boolean b2, final boolean b3) {
        final int bm = Gg3.bm(gg3);
        if (bm != -87110914) {
            throw new RuntimeException("Invalid header: " + bm);
        }
        final int bm2 = Gg3.bm(gg3);
        if (bm2 > 4) {
            throw new RuntimeException("Invalid version of .geom file: data version = " + bm2 + ", code version = " + 4);
        }
        final LinkedList<Kx22> list = new LinkedList<Kx22>();
        final LinkedList<RotTrans> list2 = new LinkedList<RotTrans>();
        while (true) {
            final int bm3 = Gg3.bm(gg3);
            if (bm3 == 0) {
                Gg3.bm(gg3);
                return new Iz11(list.toArray(new It12[list.size()]), list2.toArray(new RotTrans[list2.size()]));
            }
            final Ie21 g = Ie21.g(bm3);
            if (g == null) {
                if (b) {
                    throw new IllegalArgumentException("Invalid chunk type " + bm3 + " at location " + (gg3.v - 4) + ". Remaining bytes to read: " + (gg3.r.length - gg3.v));
                }
                Iz11.logger.info("Invalid chunk type {}", bm3);
                gg3.v += Gg3.bm(gg3);
            }
            else {
                final Z165 z165 = new Z165();
                if (b2) {
                    Iz11.logger.info("  deserializing collision shape {}", g.name());
                }
                switch (Iv440.g[g.ordinal()]) {
                    case 1: {
                        list.add(Kx22.e(gg3, z165, b2, b3));
                        break;
                    }
                    case 2: {
                        list.add((Kx22)Kw23.e(gg3, z165, b2, b3));
                        break;
                    }
                    case 3: {
                        list.add((Kx22)Kk26.e(gg3, z165, b2, b3));
                        break;
                    }
                    case 4: {
                        list.add((Kx22)Kd441.e(gg3, z165, b2, b3));
                        break;
                    }
                    case 5: {
                        list.add((Kx22)Kb24.e(gg3, z165, b2, b3));
                        break;
                    }
                    case 6: {
                        if (bm2 >= 3) {
                            list.add((Kx22)Ka25.e(gg3, z165, b2));
                            break;
                        }
                        Ka25.e(gg3, z165, b2);
                        Iz11.logger.warn("old version of geometry (.geom) file. Mesh is not loaded");
                        break;
                    }
                    case 7: {
                        final Ka25 h = Ka25.h(gg3, hi86, z165, b2);
                        if (h != null) {
                            list.add((Kx22)h);
                            break;
                        }
                        if (b2) {
                            Iz11.logger.info("A collision mesh is not loaded. See the geom pack log for errors related to exporting collision meshes.");
                            break;
                        }
                        break;
                    }
                }
                list2.add(z165.b());
            }
        }
    }
    
    public static Iz11 d(final Q10 q10) {
        final It12[] array = { null };
        final RotTrans[] array2 = { null };
        final Z165 z165 = new Z165();
        final Matrix4 g = q10.g;
        double sqrt = Math.sqrt(g.f00 * g.f00 + g.f01 * g.f01 + g.f02 * g.f02);
        double sqrt2 = Math.sqrt(g.f10 * g.f10 + g.f11 * g.f11 + g.f12 * g.f12);
        double sqrt3 = Math.sqrt(g.f20 * g.f20 + g.f21 * g.f21 + g.f22 * g.f22);
        if (sqrt < 0.05000000074505806) {
            sqrt = 0.05000000074505806;
        }
        if (sqrt2 < 0.05000000074505806) {
            sqrt2 = 0.05000000074505806;
        }
        if (sqrt3 < 0.05000000074505806) {
            sqrt3 = 0.05000000074505806;
        }
        array[0] = new Kx22((float)sqrt, (float)sqrt2, (float)sqrt3, "");
        z165.d.j = g.f30;
        z165.d.e = g.f31;
        z165.d.h = g.f32;
        final float n = (float)(g.f00 / sqrt);
        final float n2 = (float)(g.f01 / sqrt);
        final float n3 = (float)(g.f02 / sqrt);
        final float n4 = (float)(g.f10 / sqrt2);
        final float n5 = (float)(g.f11 / sqrt2);
        final float n6 = (float)(g.f12 / sqrt2);
        final float n7 = (float)(g.f20 / sqrt3);
        final float n8 = (float)(g.f21 / sqrt3);
        final float n9 = (float)(g.f22 / sqrt3);
        final O166 g2 = z165.g;
        final double a = 1.0f + n + n5 + n9;
        if (a > 1.0E-8) {
            final float n10 = (float)(Math.sqrt(a) * 2.0);
            g2.j = (n8 - n6) / n10;
            g2.e = (n3 - n7) / n10;
            g2.h = (n4 - n2) / n10;
            g2.s = 0.25f * n10;
        }
        else if (n > n5 && n > n9) {
            final float n11 = (float)(Math.sqrt(1.0f + n - n5 - n9) * 2.0);
            g2.j = 0.25f * n11;
            g2.e = (n4 + n2) / n11;
            g2.h = (n3 + n7) / n11;
            g2.s = (n8 - n6) / n11;
        }
        else if (n5 > n9) {
            final float n12 = (float)(Math.sqrt(1.0f + n5 - n - n9) * 2.0);
            g2.j = (n4 + n2) / n12;
            g2.e = 0.25f * n12;
            g2.h = (n8 + n6) / n12;
            g2.s = (n3 - n7) / n12;
        }
        else {
            final float n13 = (float)(Math.sqrt(1.0f + n9 - n - n5) * 2.0);
            g2.j = (n3 + n7) / n13;
            g2.e = (n8 + n6) / n13;
            g2.h = 0.25f * n13;
            g2.s = (n4 - n2) / n13;
        }
        O166.x(g2);
        array2[0] = z165.b();
        return new Iz11(array, array2);
    }
    
    @Override
    public void onAllRefsReleased() {
    }
    
    static {
        logger = LoggerFactory.getLogger(Iz11.class);
        e = new Ih437();
    }
    
    public Iz11(final It12[] q, final RotTrans[] j) {
        this.q = q;
        this.j = j;
    }
}
