/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.I48;
import com.jagex.maths.Matrix4;
import com.jagex.maths.O166;
import com.jagex.maths.Q10;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Z165;
import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Ie21;
import tfu.Ih437;
import tfu.It12;
import tfu.Ka25;
import tfu.Kb24;
import tfu.Kd441;
import tfu.Kk26;
import tfu.Kw23;
import tfu.Kx22;

public class Iz11
implements Hp62 {
    public static final int d = 4;
    public static final Ia63 e;
    private static final Logger logger;
    public final RotTrans[] j;
    public final It12[] q;

    public static Iz11 g(Gg3 gg3, Hi86 hi86, boolean bl, boolean bl2, boolean bl3) {
        int n = Gg3.bm(gg3);
        if (n != -87110914) {
            throw new RuntimeException("Invalid header: " + n);
        }
        int n2 = Gg3.bm(gg3);
        if (n2 > 4) {
            throw new RuntimeException("Invalid version of .geom file: data version = " + n2 + ", code version = " + 4);
        }
        LinkedList<It12> linkedList = new LinkedList<It12>();
        LinkedList<RotTrans> linkedList2 = new LinkedList<RotTrans>();
        do {
            int n3;
            if ((n3 = Gg3.bm(gg3)) == 0) break;
            Ie21 ie21 = Ie21.g(n3);
            if (ie21 == null) {
                if (bl) {
                    throw new IllegalArgumentException("Invalid chunk type " + n3 + " at location " + (gg3.v - 4) + ". Remaining bytes to read: " + (gg3.r.length - gg3.v));
                }
                logger.info("Invalid chunk type {}", n3);
                gg3.v += Gg3.bm(gg3);
                continue;
            }
            Z165 z165 = new Z165();
            if (bl2) {
                logger.info("  deserializing collision shape {}", (Object)ie21.name());
            }
            switch (ie21) {
                case BOX: {
                    linkedList.add(Kx22.e(gg3, z165, bl2, bl3));
                    break;
                }
                case CAPSULE: {
                    linkedList.add(Kw23.e(gg3, z165, bl2, bl3));
                    break;
                }
                case SPHERE: {
                    linkedList.add(Kk26.e(gg3, z165, bl2, bl3));
                    break;
                }
                case CONVEX_2D_POLYGON: {
                    linkedList.add(Kd441.e(gg3, z165, bl2, bl3));
                    break;
                }
                case CONVEX_HULL: {
                    linkedList.add(Kb24.e(gg3, z165, bl2, bl3));
                    break;
                }
                case GENERIC_STATIC_MESH: {
                    if (n2 >= 3) {
                        linkedList.add(Ka25.e(gg3, z165, bl2));
                        break;
                    }
                    Ka25.e(gg3, z165, bl2);
                    logger.warn("old version of geometry (.geom) file. Mesh is not loaded");
                    break;
                }
                case GENERIC_STATIC_MESH_INTERNAL: {
                    Ka25 ka25 = Ka25.h(gg3, hi86, z165, bl2);
                    if (ka25 != null) {
                        linkedList.add(ka25);
                        break;
                    }
                    if (!bl2) break;
                    logger.info("A collision mesh is not loaded. See the geom pack log for errors related to exporting collision meshes.");
                }
            }
            linkedList2.add(z165.b());
        } while (true);
        Gg3.bm(gg3);
        return new Iz11(linkedList.toArray(new It12[linkedList.size()]), linkedList2.toArray(new RotTrans[linkedList2.size()]));
    }

    public static Iz11 d(Q10 q10) {
        It12[] arrit12 = new It12[1];
        RotTrans[] arrrotTrans = new RotTrans[1];
        Z165 z165 = new Z165();
        Matrix4 matrix4 = q10.g;
        double d = Math.sqrt(matrix4.f00 * matrix4.f00 + matrix4.f01 * matrix4.f01 + matrix4.f02 * matrix4.f02);
        double d2 = Math.sqrt(matrix4.f10 * matrix4.f10 + matrix4.f11 * matrix4.f11 + matrix4.f12 * matrix4.f12);
        double d3 = Math.sqrt(matrix4.f20 * matrix4.f20 + matrix4.f21 * matrix4.f21 + matrix4.f22 * matrix4.f22);
        float f = 0.05f;
        if (d < 0.05000000074505806) {
            d = 0.05000000074505806;
        }
        if (d2 < 0.05000000074505806) {
            d2 = 0.05000000074505806;
        }
        if (d3 < 0.05000000074505806) {
            d3 = 0.05000000074505806;
        }
        arrit12[0] = new Kx22((float)d, (float)d2, (float)d3, "");
        z165.d.j = matrix4.f30;
        z165.d.e = matrix4.f31;
        z165.d.h = matrix4.f32;
        float f2 = (float)((double)matrix4.f00 / d);
        float f3 = (float)((double)matrix4.f01 / d);
        float f4 = (float)((double)matrix4.f02 / d);
        float f5 = (float)((double)matrix4.f10 / d2);
        float f6 = (float)((double)matrix4.f11 / d2);
        float f7 = (float)((double)matrix4.f12 / d2);
        float f8 = (float)((double)matrix4.f20 / d3);
        float f9 = (float)((double)matrix4.f21 / d3);
        float f10 = (float)((double)matrix4.f22 / d3);
        O166 o166 = z165.g;
        double d4 = 1.0f + f2 + f6 + f10;
        if (d4 > 1.0E-8) {
            float f11 = (float)(Math.sqrt(d4) * 2.0);
            o166.j = (f9 - f7) / f11;
            o166.e = (f4 - f8) / f11;
            o166.h = (f5 - f3) / f11;
            o166.s = 0.25f * f11;
        } else if (f2 > f6 && f2 > f10) {
            float f12 = (float)(Math.sqrt(1.0f + f2 - f6 - f10) * 2.0);
            o166.j = 0.25f * f12;
            o166.e = (f5 + f3) / f12;
            o166.h = (f4 + f8) / f12;
            o166.s = (f9 - f7) / f12;
        } else if (f6 > f10) {
            float f13 = (float)(Math.sqrt(1.0f + f6 - f2 - f10) * 2.0);
            o166.j = (f5 + f3) / f13;
            o166.e = 0.25f * f13;
            o166.h = (f9 + f7) / f13;
            o166.s = (f4 - f8) / f13;
        } else {
            float f14 = (float)(Math.sqrt(1.0f + f10 - f2 - f6) * 2.0);
            o166.j = (f4 + f8) / f14;
            o166.e = (f9 + f7) / f14;
            o166.h = 0.25f * f14;
            o166.s = (f5 - f3) / f14;
        }
        O166.x(o166);
        arrrotTrans[0] = z165.b();
        return new Iz11(arrit12, arrrotTrans);
    }

    @Override
    public void onAllRefsReleased() {
    }

    static {
        logger = LoggerFactory.getLogger(Iz11.class);
        e = new Ih437();
    }

    public Iz11(It12[] arrit12, RotTrans[] arrrotTrans) {
        this.q = arrit12;
        this.j = arrrotTrans;
    }
}

