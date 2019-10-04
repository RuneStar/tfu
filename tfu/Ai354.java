// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;

public class Ai354
{
    static final int b = 81920;
    public static final float d = 4.0f;
    static final int e = 65536;
    static final int h = 65536;
    static final int j;
    static final int l = 114688;
    private static final Logger logger;
    public static float q;
    private static final Ir421 r;
    static final int s = 98304;
    static boolean w;
    
    public static int g(final char c, final char c2, final char c3, final char c4) {
        return (c & '\u00ff') << 0 | (c2 & '\u00ff') << 8 | (c3 & '\u00ff') << 16 | (c4 & '\u00ff') << 24;
    }
    
    private static Aq544 q(final long g, final Fk353 fk353, final Fp460 fp460, final Hi86 hi86, final Map map, final Map map2) {
        final Aq544 aq544 = new Aq544();
        final boolean q = fk353.y != null;
        Kc180.e();
        Kc180.r(g, Ai354.j);
        final long n = g + 4L;
        Kc180.r(n, 65536);
        final long n2 = n + 4L;
        Fc454 fc454;
        if (hi86 != null) {
            try {
                if (fp460.b != -1) {
                    fc454 = (Fc454)hi86.j(Fc454.class, fp460.b);
                }
                else {
                    fc454 = null;
                }
            }
            catch (Ik357 ik357) {
                fc454 = null;
            }
        }
        else {
            fc454 = ((fp460.b != -1) ? map.get(fp460.b) : null);
        }
        long n4 = 0L;
        Label_0247: {
            if (fc454 != null) {
                final Fs455 t = fc454.t;
                final Fs455 t2 = fc454.t;
                if (t == Fs455.TWO_TONE_PPL) {
                    Kc180.r(n2, q ? 114688 : 81920);
                    final long n3 = n2 + 4L;
                    Kc180.r(n3, 104);
                    n4 = n3 + 4L;
                    break Label_0247;
                }
            }
            Kc180.r(n2, q ? 98304 : 65536);
            final long n5 = n2 + 4L;
            Kc180.r(n5, 80);
            n4 = n5 + 4L;
        }
        final float[] array = { 0.4f, 0.3f, 0.27f };
        final float[] array2 = { 2.0f };
        final float[] array3 = { 0.0f };
        final float[] array4 = { 1.0f, 1.0f, 1.0f };
        final float[] array5 = { 1.0f };
        if (fc454 != null && Fs455.d(fc454.t)) {
            Fc454.g(fc454, "SpecularColour", array);
            Fc454.g(fc454, "SpecularExponent", array2);
            Fc454.g(fc454, "EnvMappingWeight", array3);
            Fc454.g(fc454, "EmissiveColour", array4);
            Fc454.g(fc454, "EmissiveBoost", array5);
        }
        if (array4[0] == 0.0f && array4[1] == 0.0f && array4[2] == 0.0f) {
            array4[0] = 1.0f;
            array4[2] = (array4[1] = 1.0f);
        }
        Kc180.v(n4, array[0]);
        final long n6 = n4 + 4L;
        Kc180.v(n6, array[1]);
        final long n7 = n6 + 4L;
        Kc180.v(n7, array[2]);
        final long n8 = n7 + 4L;
        Kc180.v(n8, array2[0]);
        final long n9 = n8 + 4L;
        Kc180.v(n9, array3[0]);
        final long n10 = n9 + 4L;
        Kc180.v(n10, array4[0]);
        final long n11 = n10 + 4L;
        Kc180.v(n11, array4[1]);
        final long n12 = n11 + 4L;
        Kc180.v(n12, array4[2]);
        final long n13 = n12 + 4L;
        Kc180.v(n13, array5[0]);
        final long n14 = n13 + 4L;
        final float[] array6 = { 0.0f, 0.0f };
        final float[] array7 = { 0.0f, 0.0f };
        final float[] array8 = { 0.0f, 0.0f };
        if (fc454 != null) {
            Fc454.g(fc454, "UVTransSpeed", array6);
            Fc454.g(fc454, "UVRotOrigin", array7);
            Fc454.g(fc454, "UVRotSpeed", array8);
        }
        Kc180.v(n14, array6[0]);
        final long n15 = n14 + 4L;
        Kc180.v(n15, array6[1]);
        final long n16 = n15 + 4L;
        Kc180.v(n16, array7[0]);
        final long n17 = n16 + 4L;
        Kc180.v(n17, array7[1]);
        final long n18 = n17 + 4L;
        Kc180.v(n18, array8[0]);
        final long n19 = n18 + 4L;
        Kc180.v(n19, 1.0f);
        final long n20 = n19 + 4L;
        Kc180.v(n20, 1.0f);
        final long n21 = n20 + 4L;
        Kc180.v(n21, 1.0f);
        final long n22 = n21 + 4L;
        Kc180.v(n22, 0.0f);
        final long n23 = n22 + 4L;
        Kc180.v(n23, 0.0f);
        final long n24 = n23 + 4L;
        Kc180.v(n24, 0.0f);
        long n25 = n24 + 4L;
        if (fc454 != null) {
            final Fs455 t3 = fc454.t;
            final Fs455 t4 = fc454.t;
            if (t3 == Fs455.TWO_TONE_PPL) {
                Kc180.v(n25, 1.0f);
                final long n26 = n25 + 4L;
                Kc180.v(n26, 1.0f);
                final long n27 = n26 + 4L;
                Kc180.v(n27, 1.0f);
                final long n28 = n27 + 4L;
                Kc180.v(n28, 1.0f);
                final long n29 = n28 + 4L;
                Kc180.v(n29, 1.0f);
                final long n30 = n29 + 4L;
                Kc180.v(n30, 1.0f);
                n25 = n30 + 4L;
            }
        }
        Kc180.r(n25, 2);
        final long n31 = n25 + 4L;
        Ig436 j;
        long n33;
        if (hi86 != null) {
            int p6 = -1;
            int x = -1;
            if (fc454 != null) {
                p6 = fc454.p;
                x = fc454.x;
                j = fc454.z;
            }
            else {
                j = Ig436.OPAQUE;
            }
            Kc180.r(n31, p6);
            final long n32 = n31 + 4L;
            Kc180.r(n32, x);
            n33 = n32 + 4L;
        }
        else {
            String s = "default_diff";
            String s2 = "default_mat2";
            if (fc454 == null) {
                Ai354.logger.info("Glue failed to load material with id {}", fp460.b);
                j = Ig436.OPAQUE;
            }
            else {
                Ai354.logger.info("Glue succeeded in loading material with id {}", fp460.b);
                String string = new String("");
                I545 i545;
                if (fc454.p != -1) {
                    i545 = map2.get(fc454.p);
                }
                else {
                    s = fc454.r;
                    i545 = map2.get(fc454.r.hashCode());
                }
                if (i545 != null) {
                    s = i545.d.getAbsolutePath();
                    string = "." + Iu445.g(i545.d);
                }
                if (fc454.x != -1) {
                    final I545 i546 = map2.get(fc454.x);
                    if (i546 != null) {
                        s2 = i546.d.getAbsolutePath();
                    }
                }
                else {
                    s2 = s.toLowerCase();
                    final int lastIndex = s2.lastIndexOf(46);
                    if (lastIndex > 0) {
                        s2 = s2.substring(0, lastIndex);
                    }
                    if (fc454.v != null) {
                        s2 = fc454.v;
                    }
                    else {
                        final String suffix = "_diff";
                        final String suffix2 = "_diffa";
                        final String suffix3 = "_diffm";
                        if (s2.endsWith(suffix2)) {
                            s2 = s2.substring(0, s2.length() - suffix2.length()) + "_mat2" + string;
                        }
                        else if (s2.endsWith(suffix3)) {
                            s2 = s2.substring(0, s2.length() - suffix3.length()) + "_mat2" + string;
                        }
                        else if (s2.endsWith(suffix)) {
                            s2 = s2.substring(0, s2.length() - suffix.length()) + "_mat2" + string;
                        }
                    }
                }
                j = fc454.z;
            }
            Kc180.r(n31, s.length());
            long n34 = n31 + 4L;
            for (int k = 0; k < s.length(); ++k) {
                Kc180.l(n34, s.charAt(k));
                ++n34;
            }
            Kc180.r(n34, s2.length());
            n33 = n34 + 4L;
            for (int l = 0; l < s2.length(); ++l) {
                Kc180.l(n33, s2.charAt(l));
                ++n33;
            }
        }
        int n35 = 20;
        int n36 = 3;
        if (q) {
            n35 += 8;
            n36 += 2;
        }
        if (Ai354.w) {
            n35 += 4;
            ++n36;
        }
        Kc180.r(n33, n36);
        final long n37 = n33 + 4L;
        Kc180.r(n37, 0);
        final long n38 = n37 + 4L;
        Kc180.r(n38, 2);
        final long n39 = n38 + 4L;
        Kc180.r(n39, 0);
        final long n40 = n39 + 4L;
        Kc180.r(n40, 0);
        final long n41 = n40 + 4L;
        Kc180.r(n41, 0);
        final long n42 = n41 + 4L;
        Kc180.r(n42, 6);
        final long n43 = n42 + 4L;
        Kc180.r(n43, 5);
        final long n44 = n43 + 4L;
        Kc180.r(n44, 0);
        final long n45 = n44 + 4L;
        Kc180.r(n45, 0);
        final long n46 = n45 + 4L;
        Kc180.r(n46, 8);
        final long n47 = n46 + 4L;
        Kc180.r(n47, 3);
        final long n48 = n47 + 4L;
        Kc180.r(n48, 0);
        long n49 = n48 + 4L;
        if (q) {
            Kc180.r(n49, 0);
            final long n50 = n49 + 4L;
            Kc180.r(n50, 5);
            final long n51 = n50 + 4L;
            Kc180.r(n51, 2);
            final long n52 = n51 + 4L;
            Kc180.r(n52, 0);
            final long n53 = n52 + 4L;
            Kc180.r(n53, 0);
            final long n54 = n53 + 4L;
            Kc180.r(n54, 8);
            final long n55 = n54 + 4L;
            Kc180.r(n55, 1);
            final long n56 = n55 + 4L;
            Kc180.r(n56, 0);
            n49 = n56 + 4L;
        }
        if (Ai354.w) {
            Kc180.r(n49, 0);
            final long n57 = n49 + 4L;
            Kc180.r(n57, 8);
            final long n58 = n57 + 4L;
            Kc180.r(n58, 10);
            final long n59 = n58 + 4L;
            Kc180.r(n59, 0);
            n49 = n59 + 4L;
        }
        Kc180.r(n49, n35);
        final long n60 = n49 + 4L;
        final int n61 = fp460.g * 3;
        final int t5 = fk353.t;
        final int s3 = fk353.s;
        final long n62 = n60;
        final long n63 = n60 + 4L;
        Kc180.r(n63, n61);
        long n65;
        long n64 = (n65 = n63 + 4L) + n35 * t5;
        final long n66 = n65;
        final long n67 = n64;
        O546[] array9 = null;
        if (q) {
            array9 = new O546[s3];
            if (fk353.y != null) {
                int n68 = 0;
                for (int n69 = 0; n69 < fk353.s; ++n69) {
                    final O546[] array10 = array9;
                    final int n70 = n69;
                    final O546 o546 = new O546(fk353.y[n69]);
                    array10[n70] = o546;
                    final O546 o547 = o546;
                    for (byte b = 0; b < fk353.y[n69]; ++b) {
                        o547.d[b] = fk353.p[n68];
                        o547.q[b] = (fk353.x[n68] & 0xFF) / 255.0f;
                        ++n68;
                    }
                }
            }
        }
        int m = 0;
        final int[] array11 = new int[s3];
        final HashMap hashMap = new HashMap<Ag543, Integer>(s3);
        for (int n71 = 0; n71 < s3; ++n71) {
            final Ag543 ag543 = new Ag543(fk353.b[n71], fk353.l[n71], fk353.w[n71]);
            final Integer n72 = hashMap.get(ag543);
            if (n72 == null) {
                hashMap.put(ag543, m);
                array11[n71] = m++;
            }
            else {
                array11[n71] = n72;
            }
        }
        int n73 = 0;
        final int[] array12 = new int[t5];
        final float[] array13 = new float[t5];
        final float[] array14 = new float[t5];
        final float[] array15 = new float[t5];
        final Ha262 ha262 = new Ha262(Jz233.e(t5));
        for (int n74 = 0; n74 < fp460.g; ++n74) {
            final int n75 = fp460.e[n74] & 0xFFFF;
            final int n76 = fp460.h[n74] & 0xFFFF;
            final int n77 = fp460.s[n74] & 0xFFFF;
            final float n78 = (float)(fk353.b[n77] - fk353.b[n76]);
            final float n79 = (float)(fk353.b[n75] - fk353.b[n76]);
            final float n80 = (float)(fk353.l[n77] - fk353.l[n76]);
            final float n81 = (float)(fk353.l[n75] - fk353.l[n76]);
            final float n82 = (float)(fk353.w[n77] - fk353.w[n76]);
            final float n83 = (float)(fk353.w[n75] - fk353.w[n76]);
            final float n84 = n80 * n83 - n82 * n81;
            final float n85 = n82 * n79 - n78 * n83;
            final float n86 = n78 * n81 - n80 * n79;
            final float n87 = (float)(1.0 / Math.sqrt(n84 * n84 + n85 * n85 + n86 * n86));
            final float n88 = n84 * n87;
            final float n89 = n85 * n87;
            final float n90 = n86 * n87;
            final long n91 = fp460.j[n74] & 0xFF;
            for (int n92 = 0; n92 < 3; ++n92) {
                int n93 = 0;
                switch (n92) {
                    case 0: {
                        n93 = n75;
                        break;
                    }
                    case 1: {
                        n93 = n76;
                        break;
                    }
                    case 2: {
                        n93 = n77;
                        break;
                    }
                }
                final long n94 = n91 << 48 | (long)array11[n93];
                final Kq264 kq264 = (Kq264)Ha262.d(ha262, n94);
                int g2;
                if (kq264 == null) {
                    Ha262.q(ha262, new Kq264(g2 = n73++), n94);
                }
                else {
                    g2 = kq264.g;
                }
                final float[] array16 = array13;
                final int n95 = g2;
                array16[n95] += n88;
                final float[] array17 = array14;
                final int n96 = g2;
                array17[n96] += n89;
                final float[] array18 = array15;
                final int n97 = g2;
                array18[n97] += n90;
                final int[] array19 = array12;
                final int n98 = g2;
                ++array19[n98];
            }
        }
        for (int n99 = 0; n99 < n73; ++n99) {
            if (array12[n99] > 1) {
                final float n100 = (float)(1.0 / Math.sqrt(array13[n99] * array13[n99] + array14[n99] * array14[n99] + array15[n99] * array15[n99]));
                final float[] array20 = array13;
                final int n101 = n99;
                array20[n101] *= n100;
                final float[] array21 = array14;
                final int n102 = n99;
                array21[n102] *= n100;
                final float[] array22 = array15;
                final int n103 = n99;
                array22[n103] *= n100;
            }
        }
        final Ha262 ha263 = new Ha262(Jz233.e(t5));
        int n104 = 0;
        int n105 = 0;
        for (int n106 = 0; n106 < fp460.g; ++n106) {
            int n107 = 0;
            int n108 = 0;
            final int n109 = fp460.d[n106] & 0xFFFF;
            final long n110 = fp460.j[n106] & 0xFF;
            for (int n111 = 0; n111 < 3; ++n111) {
                int n112 = 0;
                switch (n111) {
                    case 0: {
                        n112 = (fp460.e[n106] & 0xFFFF);
                        break;
                    }
                    case 1: {
                        n112 = (fp460.h[n106] & 0xFFFF);
                        break;
                    }
                    case 2: {
                        n112 = (fp460.s[n106] & 0xFFFF);
                        break;
                    }
                }
                final int g3 = ((Kq264)Ha262.d(ha262, n110 << 48 | (long)array11[n112])).g;
                final long n113 = (long)n109 << 32 | (long)(g3 << 16) | (long)n112;
                final Kq264 kq265 = (Kq264)Ha262.d(ha263, n113);
                int g4;
                if (kq265 == null) {
                    final Kq264 kq266 = new Kq264(g4 = n105++);
                    Kc180.v(n65, fk353.b[n112] * Ai354.q / fk353.n);
                    final long n114 = n65 + 4L;
                    Kc180.v(n114, fk353.l[n112] * Ai354.q / fk353.n);
                    final long n115 = n114 + 4L;
                    Kc180.v(n115, fk353.w[n112] * Ai354.q / fk353.n);
                    final long n116 = n115 + 4L;
                    final float f = fk353.r[n112] / 2048.0f;
                    final float f2 = 1.0f - fk353.v[n112] / 2048.0f;
                    if (f <= -16.0f || f2 <= -16.0f || f >= 16.0f || f2 >= 16.0f) {
                        Ai354.logger.info("Texcoords exceed compressable range! {},{}", f, f2);
                    }
                    Kc180.w(n116, h(f));
                    final long n117 = n116 + 2L;
                    Kc180.w(n117, h(f2));
                    final long n118 = n117 + 2L;
                    Kc180.r(n118, 0x0 | ((int)((array13[g3] * 0.5f + 0.5f) * 255.0f) & 0xFF) << 0 | ((int)((array14[g3] * 0.5f + 0.5f) * 255.0f) & 0xFF) << 8 | ((int)((array15[g3] * 0.5f + 0.5f) * 255.0f) & 0xFF) << 16);
                    n65 = n118 + 4L;
                    if (q) {
                        O546 o548;
                        int n119;
                        for (o548 = array9[n112], n119 = 0; n119 < o548.g; ++n119) {
                            Kc180.b(n65, o548.d[n119]);
                            ++n65;
                        }
                        while (n119 < 4) {
                            Kc180.b(n65, (byte)0);
                            ++n65;
                            ++n119;
                        }
                        int n120;
                        for (n120 = 0; n120 < o548.g; ++n120) {
                            Kc180.b(n65, (byte)(o548.q[n120] * 255.0f));
                            ++n65;
                        }
                        while (n120 < 4) {
                            Kc180.b(n65, (byte)0);
                            ++n65;
                            ++n120;
                        }
                    }
                    if (Ai354.w) {
                        Kc180.r(n65, 0xFF000000 | (Gy491.j[n109] >> 16 & 0xFF) << 0 | (Gy491.j[n109] >> 8 & 0xFF) << 8 | (Gy491.j[n109] >> 0 & 0xFF) << 16);
                        n65 += 4L;
                    }
                    Ha262.q(ha263, kq266, n113);
                }
                else {
                    g4 = kq265.g;
                }
                if (n111 >= 2) {
                    Kc180.w(n64, (short)n107);
                    final long n121 = n64 + 2L;
                    Kc180.w(n121, (short)n108);
                    final long n122 = n121 + 2L;
                    Kc180.w(n122, (short)g4);
                    n64 = n122 + 2L;
                    n104 += 3;
                }
                else if (n111 == 0) {
                    n107 = g4;
                }
                n108 = g4;
            }
        }
        Kc180.r(n62, n105);
        if (n105 != t5) {
            Kc180.j(n67, n66 + n35 * n105, n104 * 2);
        }
        aq544.g = g;
        aq544.d = (int)(n65 + n104 * 2 - g);
        aq544.j = j;
        aq544.q = q;
        return aq544;
    }
    
    public static float j(final float n) {
        return n / H149.p * 2.0f - 1.0f;
    }
    
    public static short h(final float n) {
        return (short)(n * 2048.0f);
    }
    
    public static Bn279 s(final Set set, final Hi86 hi86, final int n) {
        return set.isEmpty() ? null : Hi86.s(hi86, N105.class, Fk353.class, set, Ai354.r, n, null, null);
    }
    
    static {
        logger = LoggerFactory.getLogger(Ai354.class);
        Ai354.q = 0.015625f;
        j = g('M', 'E', 'S', 'H');
        Ai354.w = true;
        r = new K547();
    }
    
    public static float e(final float n) {
        return (1.0f - n / H149.x) * 2.0f - 1.0f;
    }
    
    public static N105 d(final Fk353[] array, final Hi86 hi86) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        boolean b = false;
        for (final Fk353 fk353 : array) {
            b |= (fk353.y != null);
            n3 += fk353.t;
            n2 += fk353.m;
            n += fk353.u;
        }
        final N105 n4 = new N105(hi86, n, b, 1048576 + n3 * 32 + n2 * 2);
        long j = N105.j(n4);
        int n5 = 0;
        for (int k = 0; k < array.length; ++k) {
            final Fk353 fk354 = array[k];
            for (int l = 0; l < fk354.u; ++l) {
                final Aq544 q = q(j, fk354, fk354.z[l], hi86, null, null);
                j += q.d;
                N105.h(n4, n5++, q);
            }
        }
        return n4;
    }
}
