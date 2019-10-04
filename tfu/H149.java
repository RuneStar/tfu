// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.maths.ScaleRotTrans;
import java.util.Iterator;
import java.util.Collection;
import com.jagex.maths.Matrix4;
import com.jagex.maths.H303;
import com.jagex.jnibindings.runetek6.GroundCover;
import java.io.File;
import com.jagex.jnibindings.runetek6.Graphics;
import java.awt.Canvas;
import org.slf4j.Logger;

public final class H149
{
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
    
    public static void g(final String parent, final Canvas canvas) {
        Lb33.g(Lb33.InitGraphicsJava);
        try {
            Gy491.g(false, true);
            H149.d = Kc180.e();
            H149.j = Kc180.g(H149.q);
            Lb33.g(Lb33.GetDefaultCamera);
            try {
                H149.h = Graphics.getDefaultCamera();
            }
            finally {
                Lb33.d(Lb33.GetDefaultCamera);
            }
            H149.z = parent + File.separatorChar;
            Lb33.g(Lb33.AddBaseMediaPath);
            try {
                Graphics.addBaseMediaPath(parent + File.separatorChar);
            }
            finally {
                Lb33.d(Lb33.AddBaseMediaPath);
            }
            Lb33.g(Lb33.AddBaseShaderPath);
            try {
                Graphics.addBaseShaderPath(new File(parent, "HLSL").getPath() + File.separatorChar);
            }
            finally {
                Lb33.d(Lb33.AddBaseShaderPath);
            }
            Lb33.g(Lb33.InitFromCanvas);
            try {
                Graphics.initFromCanvas(canvas, 0, 0, 2, 0, 0, 0);
            }
            finally {
                Lb33.d(Lb33.InitFromCanvas);
            }
            H149.p = canvas.getWidth();
            H149.x = canvas.getHeight();
            Lb33.g(Lb33.InitDrawHelper);
            try {
                C340.g();
            }
            finally {
                Lb33.d(Lb33.InitDrawHelper);
            }
            Lb33.g(Lb33.CreateGroundCover);
            try {
                H149.u = GroundCover.createEngine();
            }
            finally {
                Lb33.d(Lb33.CreateGroundCover);
            }
            H149.y = true;
        }
        catch (Exception ex) {
            H149.logger.error("", ex);
        }
        finally {
            Lb33.d(Lb33.InitGraphicsJava);
        }
    }
    
    public static void e(final H303 h303, final Matrix4 matrix4, final Collection collection, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final Collection collection2, final Collection collection3) {
        synchronized (H149.v) {
            Lb33.g(Lb33.zGraphicsSync);
            try {
                final int i = H149.d + 88 + 4 + ((collection != null) ? collection.size() : 0) * (H149.d + 32) + 4 + ((collection2 != null) ? collection2.size() : 0) * H149.d + 4 + ((collection3 != null) ? collection3.size() : 0) * H149.d + 4 + H149.b * (64 + H149.d + 4);
                if (H149.q < i) {
                    final int q = i * 3 / 2;
                    Kc180.d(H149.j);
                    H149.j = Kc180.g(q);
                    H149.q = q;
                }
                final long j = H149.j;
                Kc180.s(j, H149.h);
                final long n8 = j + H149.d;
                Kc180.v(n8, matrix4.f00);
                final long n9 = n8 + 4L;
                Kc180.v(n9, matrix4.f01);
                final long n10 = n9 + 4L;
                Kc180.v(n10, matrix4.f02);
                final long n11 = n10 + 4L;
                Kc180.v(n11, matrix4.f03);
                final long n12 = n11 + 4L;
                Kc180.v(n12, matrix4.f10);
                final long n13 = n12 + 4L;
                Kc180.v(n13, matrix4.f11);
                final long n14 = n13 + 4L;
                Kc180.v(n14, matrix4.f12);
                final long n15 = n14 + 4L;
                Kc180.v(n15, matrix4.f13);
                final long n16 = n15 + 4L;
                Kc180.v(n16, matrix4.f20);
                final long n17 = n16 + 4L;
                Kc180.v(n17, matrix4.f21);
                final long n18 = n17 + 4L;
                Kc180.v(n18, matrix4.f22);
                final long n19 = n18 + 4L;
                Kc180.v(n19, matrix4.f23);
                final long n20 = n19 + 4L;
                Kc180.v(n20, matrix4.f30);
                final long n21 = n20 + 4L;
                Kc180.v(n21, matrix4.f31);
                final long n22 = n21 + 4L;
                Kc180.v(n22, matrix4.f32);
                final long n23 = n22 + 4L;
                Kc180.v(n23, matrix4.f33);
                final long n24 = n23 + 4L;
                Kc180.v(n24, n2);
                final long n25 = n24 + 4L;
                Kc180.v(n25, n3);
                final long n26 = n25 + 4L;
                Kc180.v(n26, n4);
                final long n27 = n26 + 4L;
                Kc180.v(n27, n5);
                final long n28 = n27 + 4L;
                Kc180.v(n28, n6);
                final long n29 = n28 + 4L;
                Kc180.v(n29, n7);
                final long n30 = n29 + 4L;
                int n31 = 0;
                final long n32 = n30;
                long n33 = n30 + 4L;
                if (collection != null) {
                    for (final L253 l253 : collection) {
                        final long g = l253.g();
                        if (g == 0L) {
                            continue;
                        }
                        final ScaleRotTrans objectTransform = l253.getObjectTransform();
                        Kc180.s(n33, g);
                        final long n34 = n33 + H149.d;
                        Kc180.v(n34, objectTransform.scale);
                        final long n35 = n34 + 4L;
                        Kc180.v(n35, objectTransform.rot.x);
                        final long n36 = n35 + 4L;
                        Kc180.v(n36, objectTransform.rot.y);
                        final long n37 = n36 + 4L;
                        Kc180.v(n37, objectTransform.rot.z);
                        final long n38 = n37 + 4L;
                        Kc180.v(n38, objectTransform.rot.w);
                        final long n39 = n38 + 4L;
                        Kc180.v(n39, objectTransform.trans.x);
                        final long n40 = n39 + 4L;
                        Kc180.v(n40, objectTransform.trans.y);
                        final long n41 = n40 + 4L;
                        Kc180.v(n41, objectTransform.trans.z);
                        n33 = n41 + 4L;
                        ++n31;
                    }
                }
                Kc180.r(n32, n31);
                int n42 = 0;
                final long n43 = n33;
                long n44 = n33 + 4L;
                if (collection2 != null) {
                    final Iterator<L253> iterator2 = collection2.iterator();
                    while (iterator2.hasNext()) {
                        final long g2 = iterator2.next().g();
                        if (g2 == 0L) {
                            continue;
                        }
                        Kc180.s(n44, g2);
                        n44 += H149.d;
                        ++n42;
                    }
                }
                Kc180.r(n43, n42);
                int n45 = 0;
                final long n46 = n44;
                long n47 = n44 + 4L;
                if (collection3 != null) {
                    final Iterator<L253> iterator3 = collection3.iterator();
                    while (iterator3.hasNext()) {
                        final long g3 = iterator3.next().g();
                        if (g3 == 0L) {
                            continue;
                        }
                        Kc180.s(n47, g3);
                        n47 += H149.d;
                        ++n45;
                    }
                }
                Kc180.r(n46, n45);
                Kc180.r(n47, H149.b);
                long n48 = n47 + 4L;
                for (int k = 0; k < H149.b; ++k) {
                    for (int n49 = 0; n49 < 16; ++n49) {
                        Kc180.v(n48, H149.l[k * 16 + n49]);
                        n48 += 4L;
                    }
                    Kc180.s(n48, H149.w[k]);
                    final long n50 = n48 + H149.d;
                    Kc180.r(n50, H149.r[k]);
                    n48 = n50 + 4L;
                }
                if (n48 > H149.j + i) {
                    H149.logger.error("Buffer size was estimated as " + i + ", but we used " + (n48 - H149.j));
                    if (n48 > H149.j + H149.q) {
                        throw new Error("The above wrong estimate has caused a buffer overrun - bailing out!");
                    }
                }
                Graphics.processFrame(H149.j, (int)(n48 - H149.j), n, H149.e);
                H149.b = 0;
            }
            finally {
                Lb33.d(Lb33.zGraphicsSync);
            }
        }
    }
    
    public static void h() {
        H149.b = 0;
    }
    
    public static void d() {
        if (Scripting.g()) {
            Kc180.d(H149.j);
            GroundCover.destroyEngine(H149.u);
            Graphics.purge();
        }
    }
    
    public static void j(final long n, final float n2) {
        Lb33.g(Lb33.ProcessScript);
        try {
            Graphics.runPreRenderScripts(n, n2);
        }
        finally {
            Lb33.d(Lb33.ProcessScript);
        }
    }
    
    public static void s(float n, float n2, float n3, float n4, float n5, float n6, float n7, float n8, final long n9, final int n10) {
        if ((n10 & 0xFF000000) == 0x0) {
            return;
        }
        final float n11 = -0.5f;
        n += n11;
        n2 += n11;
        n3 += n11;
        n4 += n11;
        if (n > C340.r) {
            return;
        }
        if (n2 > C340.l) {
            return;
        }
        if (n3 < C340.w) {
            return;
        }
        if (n4 < C340.b) {
            return;
        }
        final float n12 = n3 - n;
        final float n13 = n4 - n2;
        final float n14 = n7 - n5;
        final float n15 = n8 - n6;
        if (n < C340.w) {
            n5 += (C340.w - n) / n12 * n14;
            n = (float)C340.w;
        }
        if (n2 < C340.b) {
            n6 += (C340.b - n2) / n13 * n15;
            n2 = (float)C340.b;
        }
        if (n3 > C340.r) {
            n7 -= (n3 - C340.r) / n12 * n14;
            n3 = (float)C340.r;
        }
        if (n4 > C340.l) {
            n8 -= (n4 - C340.l) / n13 * n15;
            n4 = (float)C340.l;
        }
        if (H149.b == H149.s) {
            H149.s *= 2;
            final float[] l = new float[H149.s * 16];
            System.arraycopy(H149.l, 0, l, 0, H149.b * 16);
            H149.l = l;
            final long[] w = new long[H149.s];
            System.arraycopy(H149.w, 0, w, 0, H149.b);
            H149.w = w;
            final int[] r = new int[H149.s];
            System.arraycopy(H149.r, 0, r, 0, H149.b);
            H149.r = r;
        }
        H149.l[H149.b * 16 + 0] = Ai354.j(n);
        H149.l[H149.b * 16 + 1] = Ai354.e(n2);
        H149.l[H149.b * 16 + 2] = n5;
        H149.l[H149.b * 16 + 3] = n6;
        H149.l[H149.b * 16 + 4] = Ai354.j(n3);
        H149.l[H149.b * 16 + 5] = Ai354.e(n2);
        H149.l[H149.b * 16 + 6] = n7;
        H149.l[H149.b * 16 + 7] = n6;
        H149.l[H149.b * 16 + 8] = Ai354.j(n);
        H149.l[H149.b * 16 + 9] = Ai354.e(n4);
        H149.l[H149.b * 16 + 10] = n5;
        H149.l[H149.b * 16 + 11] = n8;
        H149.l[H149.b * 16 + 12] = Ai354.j(n3);
        H149.l[H149.b * 16 + 13] = Ai354.e(n4);
        H149.l[H149.b * 16 + 14] = n7;
        H149.l[H149.b * 16 + 15] = n8;
        H149.w[H149.b] = n9;
        H149.r[H149.b] = ((n10 & 0xFF00FF00) | (n10 & 0xFF0000) >> 16 | (n10 & 0xFF) << 16);
        ++H149.b;
    }
    
    public static void b(float n, float n2, float n3, float n4, float n5, float n6, float n7, float n8, final float n9, final float n10, final float n11, final float n12, final float n13, final float n14, final float n15, final float n16, final long n17, final int n18) {
        if ((n18 & 0xFF000000) == 0x0) {
            return;
        }
        final float n19 = -0.5f;
        n += n19;
        n2 += n19;
        n3 += n19;
        n4 += n19;
        n5 += n19;
        n6 += n19;
        n7 += n19;
        n8 += n19;
        if (H149.b == H149.s) {
            H149.s *= 2;
            final float[] l = new float[H149.s * 16];
            System.arraycopy(H149.l, 0, l, 0, H149.b * 16);
            H149.l = l;
            final long[] w = new long[H149.s];
            System.arraycopy(H149.w, 0, w, 0, H149.b);
            H149.w = w;
            final int[] r = new int[H149.s];
            System.arraycopy(H149.r, 0, r, 0, H149.b);
            H149.r = r;
        }
        H149.l[H149.b * 16 + 0] = Ai354.j(n);
        H149.l[H149.b * 16 + 1] = Ai354.e(n2);
        H149.l[H149.b * 16 + 2] = n9;
        H149.l[H149.b * 16 + 3] = n10;
        H149.l[H149.b * 16 + 4] = Ai354.j(n3);
        H149.l[H149.b * 16 + 5] = Ai354.e(n4);
        H149.l[H149.b * 16 + 6] = n11;
        H149.l[H149.b * 16 + 7] = n12;
        H149.l[H149.b * 16 + 8] = Ai354.j(n5);
        H149.l[H149.b * 16 + 9] = Ai354.e(n6);
        H149.l[H149.b * 16 + 10] = n13;
        H149.l[H149.b * 16 + 11] = n14;
        H149.l[H149.b * 16 + 12] = Ai354.j(n7);
        H149.l[H149.b * 16 + 13] = Ai354.e(n8);
        H149.l[H149.b * 16 + 14] = n15;
        H149.l[H149.b * 16 + 15] = n16;
        H149.w[H149.b] = n17;
        H149.r[H149.b] = ((n18 & 0xFF00FF00) | (n18 & 0xFF0000) >> 16 | (n18 & 0xFF) << 16);
        ++H149.b;
    }
    
    static {
        logger = LoggerFactory.getLogger(H149.class);
        H149.d = 4;
        H149.q = 4194304;
        H149.j = 0L;
        H149.e = 0;
        H149.h = 0L;
        H149.s = 128;
        H149.b = 0;
        H149.l = new float[H149.s * 16];
        H149.w = new long[H149.s];
        H149.r = new int[H149.s];
        v = new Object();
        H149.y = false;
    }
    
    public static void q(final long n, final float n2) {
        Lb33.g(Lb33.ProcessScript);
        try {
            Graphics.runPreGameplayScripts(n, n2);
        }
        finally {
            Lb33.d(Lb33.ProcessScript);
        }
    }
}
