/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.Graphics;
import com.jagex.jnibindings.runetek6.GroundCover;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.maths.H303;
import com.jagex.maths.Matrix4;
import com.jagex.maths.Quaternion;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.awt.Canvas;
import java.io.File;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ai354;
import tfu.C340;
import tfu.Gy491;
import tfu.Kc180;
import tfu.L253;
import tfu.Lb33;

public final class H149 {
    private static int b;
    public static int d;
    public static int e;
    public static long h;
    public static long j;
    private static float[] l;
    private static final Logger logger;
    public static int p;
    private static int q;
    private static int[] r;
    private static int s;
    public static long u;
    public static final Object v;
    private static long[] w;
    public static int x;
    public static boolean y;
    public static String z;

    public static void g(String string, Canvas canvas) {
        Lb33.g(Lb33.InitGraphicsJava);
        try {
            try {
                Gy491.g(false, true);
                d = Kc180.e();
                j = Kc180.g(q);
                Lb33.g(Lb33.GetDefaultCamera);
                h = Graphics.getDefaultCamera();
                Lb33.d(Lb33.GetDefaultCamera);
                z = string + File.separatorChar;
                Lb33.g(Lb33.AddBaseMediaPath);
                Graphics.addBaseMediaPath(string + File.separatorChar);
                Lb33.d(Lb33.AddBaseMediaPath);
                Lb33.g(Lb33.AddBaseShaderPath);
                Graphics.addBaseShaderPath(new File(string, "HLSL").getPath() + File.separatorChar);
                Lb33.d(Lb33.AddBaseShaderPath);
                Lb33.g(Lb33.InitFromCanvas);
                Graphics.initFromCanvas(canvas, 0, 0, 2, 0, 0, 0);
                Lb33.d(Lb33.InitFromCanvas);
                p = canvas.getWidth();
                x = canvas.getHeight();
                Lb33.g(Lb33.InitDrawHelper);
                C340.g();
                Lb33.d(Lb33.InitDrawHelper);
                Lb33.g(Lb33.CreateGroundCover);
                u = GroundCover.createEngine();
                Lb33.d(Lb33.CreateGroundCover);
                y = true;
            }
            catch (Exception exception) {
                logger.error("", exception);
                Lb33.d(Lb33.InitGraphicsJava);
            }
            Lb33.d(Lb33.InitGraphicsJava);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.InitGraphicsJava);
            throw throwable;
        }
    }

    public static void e(H303 h303, Matrix4 matrix4, Collection collection, float f, float f2, float f3, float f4, float f5, float f6, float f7, Collection collection2, Collection collection3) {
        Object object = v;
        synchronized (object) {
            Lb33.g(Lb33.zGraphicsSync);
            try {
                long l;
                int n = collection != null ? collection.size() : 0;
                int n2 = collection2 != null ? collection2.size() : 0;
                int n3 = collection3 != null ? collection3.size() : 0;
                int n4 = d + 88 + 4 + n * (d + 32) + 4 + n2 * d + 4 + n3 * d + 4 + b * (64 + d + 4);
                if (q < n4) {
                    int n5 = n4 * 3 / 2;
                    Kc180.d(j);
                    j = Kc180.g(n5);
                    q = n5;
                }
                long l2 = j;
                Kc180.s(l2, h);
                Kc180.v(l2 += (long)d, matrix4.f00);
                Kc180.v(l2 += 4L, matrix4.f01);
                Kc180.v(l2 += 4L, matrix4.f02);
                Kc180.v(l2 += 4L, matrix4.f03);
                Kc180.v(l2 += 4L, matrix4.f10);
                Kc180.v(l2 += 4L, matrix4.f11);
                Kc180.v(l2 += 4L, matrix4.f12);
                Kc180.v(l2 += 4L, matrix4.f13);
                Kc180.v(l2 += 4L, matrix4.f20);
                Kc180.v(l2 += 4L, matrix4.f21);
                Kc180.v(l2 += 4L, matrix4.f22);
                Kc180.v(l2 += 4L, matrix4.f23);
                Kc180.v(l2 += 4L, matrix4.f30);
                Kc180.v(l2 += 4L, matrix4.f31);
                Kc180.v(l2 += 4L, matrix4.f32);
                Kc180.v(l2 += 4L, matrix4.f33);
                Kc180.v(l2 += 4L, f2);
                Kc180.v(l2 += 4L, f3);
                Kc180.v(l2 += 4L, f4);
                Kc180.v(l2 += 4L, f5);
                Kc180.v(l2 += 4L, f6);
                Kc180.v(l2 += 4L, f7);
                int n6 = 0;
                long l3 = l2 += 4L;
                l2 += 4L;
                if (collection != null) {
                    for (L253 l253 : collection) {
                        long l4 = l253.g();
                        if (l4 == 0L) continue;
                        Object object2 = l253.getObjectTransform();
                        Kc180.s(l2, l4);
                        Kc180.v(l2 += (long)d, ((ScaleRotTrans)object2).scale);
                        Kc180.v(l2 += 4L, object2.rot.x);
                        Kc180.v(l2 += 4L, object2.rot.y);
                        Kc180.v(l2 += 4L, object2.rot.z);
                        Kc180.v(l2 += 4L, object2.rot.w);
                        Kc180.v(l2 += 4L, object2.trans.x);
                        Kc180.v(l2 += 4L, object2.trans.y);
                        Kc180.v(l2 += 4L, object2.trans.z);
                        l2 += 4L;
                        ++n6;
                    }
                }
                Kc180.r(l3, n6);
                int n7 = 0;
                long l5 = l2;
                l2 += 4L;
                if (collection2 != null) {
                    for (Object object2 : collection2) {
                        l = object2.g();
                        if (l == 0L) continue;
                        Kc180.s(l2, l);
                        l2 += (long)d;
                        ++n7;
                    }
                }
                Kc180.r(l5, n7);
                n7 = 0;
                l5 = l2;
                l2 += 4L;
                if (collection3 != null) {
                    for (Object object2 : collection3) {
                        l = object2.g();
                        if (l == 0L) continue;
                        Kc180.s(l2, l);
                        l2 += (long)d;
                        ++n7;
                    }
                }
                Kc180.r(l5, n7);
                Kc180.r(l2, b);
                l2 += 4L;
                for (n7 = 0; n7 < b; ++n7) {
                    for (int i = 0; i < 16; ++i) {
                        Kc180.v(l2, H149.l[n7 * 16 + i]);
                        l2 += 4L;
                    }
                    Kc180.s(l2, w[n7]);
                    Kc180.r(l2 += (long)d, r[n7]);
                    l2 += 4L;
                }
                if (l2 > j + (long)n4) {
                    logger.error("Buffer size was estimated as " + n4 + ", but we used " + (l2 - j));
                    if (l2 > j + (long)q) {
                        throw new Error("The above wrong estimate has caused a buffer overrun - bailing out!");
                    }
                }
                Graphics.processFrame(j, (int)(l2 - j), f, e);
                b = 0;
                Lb33.d(Lb33.zGraphicsSync);
            }
            catch (Throwable throwable) {
                Lb33.d(Lb33.zGraphicsSync);
                throw throwable;
            }
        }
    }

    public static void h() {
        b = 0;
    }

    public static void d() {
        if (Scripting.g()) {
            Kc180.d(j);
            GroundCover.destroyEngine(u);
            Graphics.purge();
        }
    }

    public static void j(long l, float f) {
        Lb33.g(Lb33.ProcessScript);
        try {
            Graphics.runPreRenderScripts(l, f);
            Lb33.d(Lb33.ProcessScript);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.ProcessScript);
            throw throwable;
        }
    }

    public static void s(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, long l, int n) {
        if ((n & 0xFF000000) == 0) {
            return;
        }
        float f9 = -0.5f;
        f += f9;
        f2 += f9;
        f3 += f9;
        f4 += f9;
        if (f > (float)C340.r) {
            return;
        }
        if (f2 > (float)C340.l) {
            return;
        }
        if (f3 < (float)C340.w) {
            return;
        }
        if (f4 < (float)C340.b) {
            return;
        }
        float f10 = f3 - f;
        float f11 = f4 - f2;
        float f12 = f7 - f5;
        float f13 = f8 - f6;
        if (f < (float)C340.w) {
            f5 += ((float)C340.w - f) / f10 * f12;
            f = C340.w;
        }
        if (f2 < (float)C340.b) {
            f6 += ((float)C340.b - f2) / f11 * f13;
            f2 = C340.b;
        }
        if (f3 > (float)C340.r) {
            f7 -= (f3 - (float)C340.r) / f10 * f12;
            f3 = C340.r;
        }
        if (f4 > (float)C340.l) {
            f8 -= (f4 - (float)C340.l) / f11 * f13;
            f4 = C340.l;
        }
        if (b == s) {
            float[] arrf = new float[(s *= 2) * 16];
            System.arraycopy(H149.l, 0, arrf, 0, b * 16);
            H149.l = arrf;
            long[] arrl = new long[s];
            System.arraycopy(w, 0, arrl, 0, b);
            w = arrl;
            int[] arrn = new int[s];
            System.arraycopy(r, 0, arrn, 0, b);
            r = arrn;
        }
        H149.l[H149.b * 16 + 0] = Ai354.j(f);
        H149.l[H149.b * 16 + 1] = Ai354.e(f2);
        H149.l[H149.b * 16 + 2] = f5;
        H149.l[H149.b * 16 + 3] = f6;
        H149.l[H149.b * 16 + 4] = Ai354.j(f3);
        H149.l[H149.b * 16 + 5] = Ai354.e(f2);
        H149.l[H149.b * 16 + 6] = f7;
        H149.l[H149.b * 16 + 7] = f6;
        H149.l[H149.b * 16 + 8] = Ai354.j(f);
        H149.l[H149.b * 16 + 9] = Ai354.e(f4);
        H149.l[H149.b * 16 + 10] = f5;
        H149.l[H149.b * 16 + 11] = f8;
        H149.l[H149.b * 16 + 12] = Ai354.j(f3);
        H149.l[H149.b * 16 + 13] = Ai354.e(f4);
        H149.l[H149.b * 16 + 14] = f7;
        H149.l[H149.b * 16 + 15] = f8;
        H149.w[H149.b] = l;
        H149.r[H149.b] = n & 0xFF00FF00 | (n & 0xFF0000) >> 16 | (n & 0xFF) << 16;
        ++b;
    }

    public static void b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long l, int n) {
        if ((n & 0xFF000000) == 0) {
            return;
        }
        float f17 = -0.5f;
        f += f17;
        f2 += f17;
        f3 += f17;
        f4 += f17;
        f5 += f17;
        f6 += f17;
        f7 += f17;
        f8 += f17;
        if (b == s) {
            float[] arrf = new float[(s *= 2) * 16];
            System.arraycopy(H149.l, 0, arrf, 0, b * 16);
            H149.l = arrf;
            long[] arrl = new long[s];
            System.arraycopy(w, 0, arrl, 0, b);
            w = arrl;
            int[] arrn = new int[s];
            System.arraycopy(r, 0, arrn, 0, b);
            r = arrn;
        }
        H149.l[H149.b * 16 + 0] = Ai354.j(f);
        H149.l[H149.b * 16 + 1] = Ai354.e(f2);
        H149.l[H149.b * 16 + 2] = f9;
        H149.l[H149.b * 16 + 3] = f10;
        H149.l[H149.b * 16 + 4] = Ai354.j(f3);
        H149.l[H149.b * 16 + 5] = Ai354.e(f4);
        H149.l[H149.b * 16 + 6] = f11;
        H149.l[H149.b * 16 + 7] = f12;
        H149.l[H149.b * 16 + 8] = Ai354.j(f5);
        H149.l[H149.b * 16 + 9] = Ai354.e(f6);
        H149.l[H149.b * 16 + 10] = f13;
        H149.l[H149.b * 16 + 11] = f14;
        H149.l[H149.b * 16 + 12] = Ai354.j(f7);
        H149.l[H149.b * 16 + 13] = Ai354.e(f8);
        H149.l[H149.b * 16 + 14] = f15;
        H149.l[H149.b * 16 + 15] = f16;
        H149.w[H149.b] = l;
        H149.r[H149.b] = n & 0xFF00FF00 | (n & 0xFF0000) >> 16 | (n & 0xFF) << 16;
        ++b;
    }

    static {
        logger = LoggerFactory.getLogger(H149.class);
        d = 4;
        q = 4194304;
        j = 0L;
        e = 0;
        h = 0L;
        s = 128;
        b = 0;
        l = new float[s * 16];
        w = new long[s];
        r = new int[s];
        v = new Object();
        y = false;
    }

    public static void q(long l, float f) {
        Lb33.g(Lb33.ProcessScript);
        try {
            Graphics.runPreGameplayScripts(l, f);
            Lb33.d(Lb33.ProcessScript);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.ProcessScript);
            throw throwable;
        }
    }
}

