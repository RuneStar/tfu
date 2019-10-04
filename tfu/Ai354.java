/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ag543;
import tfu.Aq544;
import tfu.Bn279;
import tfu.Fc454;
import tfu.Fk353;
import tfu.Fp460;
import tfu.Fs455;
import tfu.Gy491;
import tfu.H149;
import tfu.Ha262;
import tfu.Hi86;
import tfu.Hp62;
import tfu.I545;
import tfu.Ig436;
import tfu.Ik357;
import tfu.Ir421;
import tfu.Iu445;
import tfu.Jz233;
import tfu.K547;
import tfu.Kc180;
import tfu.Kq264;
import tfu.N105;
import tfu.O546;

public class Ai354 {
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

    public static int g(char c, char c2, char c3, char c4) {
        return (c & 0xFF) << 0 | (c2 & 0xFF) << 8 | (c3 & 0xFF) << 16 | (c4 & 0xFF) << 24;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static Aq544 q(long var0, Fk353 var2_1, Fp460 var3_2, Hi86 var4_3, Map var5_4, Map var6_5) {
        block78 : {
            var7_6 = new Aq544();
            var8_7 = var2_1.y != null;
            var9_8 = Kc180.e();
            var10_9 = var0;
            Kc180.r(var10_9, Ai354.j);
            Kc180.r(var10_9 += 4L, 65536);
            var10_9 += 4L;
            if (var4_3 != null) {
                try {
                    if (var3_2.b != -1) {
                        var12_10 = (Fc454)var4_3.j(Fc454.class, var3_2.b);
                        break block78;
                    }
                    var12_10 = null;
                }
                catch (Ik357 var13_11) {
                    var12_10 = null;
                }
            } else {
                v0 = var12_10 = var3_2.b != -1 ? (Fc454)var5_4.get(var3_2.b) : null;
            }
        }
        if (var12_10 == null) ** GOTO lbl-1000
        if (var12_10.t == Fs455.TWO_TONE_PPL) {
            Kc180.r(var10_9, var8_7 != false ? 114688 : 81920);
            Kc180.r(var10_9 += 4L, 104);
            var10_9 += 4L;
        } else lbl-1000: // 2 sources:
        {
            Kc180.r(var10_9, var8_7 != false ? 98304 : 65536);
            Kc180.r(var10_9 += 4L, 80);
            var10_9 += 4L;
        }
        var13_12 = new float[]{0.4f, 0.3f, 0.27f};
        var14_13 = new float[]{2.0f};
        var15_14 = new float[]{0.0f};
        var16_15 = new float[]{1.0f, 1.0f, 1.0f};
        var17_16 = new float[]{1.0f};
        if (var12_10 != null && Fs455.d(var12_10.t)) {
            Fc454.g(var12_10, "SpecularColour", var13_12);
            Fc454.g(var12_10, "SpecularExponent", var14_13);
            Fc454.g(var12_10, "EnvMappingWeight", var15_14);
            Fc454.g(var12_10, "EmissiveColour", var16_15);
            Fc454.g(var12_10, "EmissiveBoost", var17_16);
        }
        if (var16_15[0] == 0.0f && var16_15[1] == 0.0f && var16_15[2] == 0.0f) {
            var16_15[0] = 1.0f;
            var16_15[1] = 1.0f;
            var16_15[2] = 1.0f;
        }
        Kc180.v(var10_9, var13_12[0]);
        Kc180.v(var10_9 += 4L, var13_12[1]);
        Kc180.v(var10_9 += 4L, var13_12[2]);
        Kc180.v(var10_9 += 4L, var14_13[0]);
        Kc180.v(var10_9 += 4L, var15_14[0]);
        Kc180.v(var10_9 += 4L, var16_15[0]);
        Kc180.v(var10_9 += 4L, var16_15[1]);
        Kc180.v(var10_9 += 4L, var16_15[2]);
        Kc180.v(var10_9 += 4L, var17_16[0]);
        var10_9 += 4L;
        var18_17 = new float[]{0.0f, 0.0f};
        var19_18 = new float[]{0.0f, 0.0f};
        var20_19 = new float[]{0.0f, 0.0f};
        if (var12_10 != null) {
            Fc454.g(var12_10, "UVTransSpeed", var18_17);
            Fc454.g(var12_10, "UVRotOrigin", var19_18);
            Fc454.g(var12_10, "UVRotSpeed", var20_19);
        }
        Kc180.v(var10_9, var18_17[0]);
        Kc180.v(var10_9 += 4L, var18_17[1]);
        Kc180.v(var10_9 += 4L, var19_18[0]);
        Kc180.v(var10_9 += 4L, var19_18[1]);
        Kc180.v(var10_9 += 4L, var20_19[0]);
        Kc180.v(var10_9 += 4L, 1.0f);
        Kc180.v(var10_9 += 4L, 1.0f);
        Kc180.v(var10_9 += 4L, 1.0f);
        Kc180.v(var10_9 += 4L, 0.0f);
        Kc180.v(var10_9 += 4L, 0.0f);
        Kc180.v(var10_9 += 4L, 0.0f);
        var10_9 += 4L;
        if (var12_10 != null) {
            if (var12_10.t == Fs455.TWO_TONE_PPL) {
                Kc180.v(var10_9, 1.0f);
                Kc180.v(var10_9 += 4L, 1.0f);
                Kc180.v(var10_9 += 4L, 1.0f);
                Kc180.v(var10_9 += 4L, 1.0f);
                Kc180.v(var10_9 += 4L, 1.0f);
                Kc180.v(var10_9 += 4L, 1.0f);
                var10_9 += 4L;
            }
        }
        Kc180.r(var10_9, 2);
        var10_9 += 4L;
        if (var4_3 != null) {
            var22_20 = -1;
            var23_22 = -1;
            if (var12_10 != null) {
                var22_20 = var12_10.p;
                var23_22 = var12_10.x;
                var21_24 = var12_10.z;
            } else {
                var21_24 = Ig436.OPAQUE;
            }
            Kc180.r(var10_9, var22_20);
            Kc180.r(var10_9 += 4L, var23_22);
            var10_9 += 4L;
        } else {
            var22_21 = "default_diff";
            var23_23 = "default_mat2";
            if (var12_10 == null) {
                Ai354.logger.info("Glue failed to load material with id {}", var3_2.b);
                var21_24 = Ig436.OPAQUE;
            } else {
                Ai354.logger.info("Glue succeeded in loading material with id {}", var3_2.b);
                var24_25 = null;
                var25_27 = new String("");
                if (var12_10.p != -1) {
                    var24_25 = (I545)var6_5.get(var12_10.p);
                } else {
                    var22_21 = var12_10.r;
                    var24_25 = (I545)var6_5.get(var12_10.r.hashCode());
                }
                if (var24_25 != null) {
                    var22_21 = var24_25.d.getAbsolutePath();
                    var25_27 = "." + Iu445.g(var24_25.d);
                }
                if (var12_10.x != -1) {
                    var26_29 = (I545)var6_5.get(var12_10.x);
                    if (var26_29 != null) {
                        var23_23 = var26_29.d.getAbsolutePath();
                    }
                } else {
                    var23_23 = var22_21.toLowerCase();
                    var26_30 = var23_23.lastIndexOf(46);
                    if (var26_30 > 0) {
                        var23_23 = var23_23.substring(0, var26_30);
                    }
                    if (var12_10.v != null) {
                        var23_23 = var12_10.v;
                    } else {
                        var27_32 = "_diff";
                        var28_34 = "_diffa";
                        var29_35 = "_diffm";
                        if (var23_23.endsWith(var28_34)) {
                            var23_23 = var23_23.substring(0, var23_23.length() - var28_34.length()) + "_mat2" + var25_27;
                        } else if (var23_23.endsWith(var29_35)) {
                            var23_23 = var23_23.substring(0, var23_23.length() - var29_35.length()) + "_mat2" + var25_27;
                        } else if (var23_23.endsWith(var27_32)) {
                            var23_23 = var23_23.substring(0, var23_23.length() - var27_32.length()) + "_mat2" + var25_27;
                        }
                    }
                }
                var21_24 = var12_10.z;
            }
            Kc180.r(var10_9, var22_21.length());
            var10_9 += 4L;
            for (var24_26 = 0; var24_26 < var22_21.length(); ++var10_9, ++var24_26) {
                Kc180.l(var10_9, var22_21.charAt(var24_26));
            }
            Kc180.r(var10_9, var23_23.length());
            var10_9 += 4L;
            for (var24_26 = 0; var24_26 < var23_23.length(); ++var10_9, ++var24_26) {
                Kc180.l(var10_9, var23_23.charAt(var24_26));
            }
        }
        var22_20 = 20;
        var23_22 = 3;
        if (var8_7) {
            var22_20 += 8;
            var23_22 += 2;
        }
        if (Ai354.w) {
            var22_20 += 4;
            ++var23_22;
        }
        Kc180.r(var10_9, var23_22);
        Kc180.r(var10_9 += 4L, 0);
        Kc180.r(var10_9 += 4L, 2);
        Kc180.r(var10_9 += 4L, 0);
        Kc180.r(var10_9 += 4L, 0);
        Kc180.r(var10_9 += 4L, 0);
        Kc180.r(var10_9 += 4L, 6);
        Kc180.r(var10_9 += 4L, 5);
        Kc180.r(var10_9 += 4L, 0);
        Kc180.r(var10_9 += 4L, 0);
        Kc180.r(var10_9 += 4L, 8);
        Kc180.r(var10_9 += 4L, 3);
        Kc180.r(var10_9 += 4L, 0);
        var10_9 += 4L;
        if (var8_7) {
            Kc180.r(var10_9, 0);
            Kc180.r(var10_9 += 4L, 5);
            Kc180.r(var10_9 += 4L, 2);
            Kc180.r(var10_9 += 4L, 0);
            Kc180.r(var10_9 += 4L, 0);
            Kc180.r(var10_9 += 4L, 8);
            Kc180.r(var10_9 += 4L, 1);
            Kc180.r(var10_9 += 4L, 0);
            var10_9 += 4L;
        }
        if (Ai354.w) {
            Kc180.r(var10_9, 0);
            Kc180.r(var10_9 += 4L, 8);
            Kc180.r(var10_9 += 4L, 10);
            Kc180.r(var10_9 += 4L, 0);
            var10_9 += 4L;
        }
        Kc180.r(var10_9, var22_20);
        var24_26 = 0;
        var25_28 = 0;
        var26_31 = 0;
        var24_26 = var3_2.g * 3;
        var26_31 = var2_1.t;
        var25_28 = var2_1.s;
        var27_33 = var10_9 += 4L;
        Kc180.r(var10_9 += 4L, var24_26);
        var29_36 = var10_9 += 4L;
        var31_37 = var10_9 + (long)(var22_20 * var26_31);
        var33_38 = var29_36;
        var35_39 = var31_37;
        var37_40 = null;
        if (var8_7) {
            var37_40 = new O546[var25_28];
            if (var2_1.y != null) {
                var38_41 = 0;
                for (var39_42 = 0; var39_42 < var2_1.s; ++var39_42) {
                    var37_40[var39_42] = new O546(var2_1.y[var39_42]);
                    var40_44 = var37_40[var39_42];
                    for (var41_45 = 0; var41_45 < var2_1.y[var39_42]; ++var38_41, ++var41_45) {
                        var40_44.d[var41_45] = var2_1.p[var38_41];
                        var40_44.q[var41_45] = (float)(var2_1.x[var38_41] & 255) / 255.0f;
                    }
                }
            }
        }
        var38_41 = 0;
        var39_43 = new int[var25_28];
        var40_44 = new HashMap<K, V>(var25_28);
        for (var41_45 = 0; var41_45 < var25_28; ++var41_45) {
            var42_46 = new Ag543(var2_1.b[var41_45], var2_1.l[var41_45], var2_1.w[var41_45]);
            var43_48 = (Integer)var40_44.get(var42_46);
            if (var43_48 == null) {
                var40_44.put(var42_46, var38_41);
                var39_43[var41_45] = var38_41++;
                continue;
            }
            var39_43[var41_45] = var43_48.intValue();
        }
        var41_45 = 0;
        var42_47 = new int[var26_31];
        var43_48 = new float[var26_31];
        var44_49 = new float[var26_31];
        var45_50 = new float[var26_31];
        var46_51 = new Ha262(Jz233.e(var26_31));
        var47_52 = 0;
        do {
            if (var47_52 < var3_2.g) {
                var48_54 = var3_2.e[var47_52] & 65535;
                var49_56 = var3_2.h[var47_52] & 65535;
                var50_57 = var3_2.s[var47_52] & 65535;
                var51_58 = var2_1.b[var50_57] - var2_1.b[var49_56];
                var52_60 = var2_1.b[var48_54] - var2_1.b[var49_56];
                var53_62 = var2_1.l[var50_57] - var2_1.l[var49_56];
                var54_64 = var2_1.l[var48_54] - var2_1.l[var49_56];
                var55_66 = var2_1.w[var50_57] - var2_1.w[var49_56];
                var56_67 = var2_1.w[var48_54] - var2_1.w[var49_56];
                var57_69 = var53_62 * var56_67 - var55_66 * var54_64;
                var58_72 = var55_66 * var52_60 - var51_58 * var56_67;
                var59_75 = var51_58 * var54_64 - var53_62 * var52_60;
                var60_78 = (float)(1.0 / Math.sqrt(var57_69 * var57_69 + var58_72 * var58_72 + var59_75 * var59_75));
                var57_69 *= var60_78;
                var58_72 *= var60_78;
                var59_75 *= var60_78;
                var61_79 = var3_2.j[var47_52] & 255;
            } else {
                for (var47_52 = 0; var47_52 < var41_45; ++var47_52) {
                    if (var42_47[var47_52] <= 1) continue;
                    var48_55 = (float)(1.0 / Math.sqrt((double)(var43_48[var47_52] * var43_48[var47_52] + var44_49[var47_52] * var44_49[var47_52] + var45_50[var47_52] * var45_50[var47_52])));
                    v1 = var43_48;
                    v2 = var47_52;
                    v1[v2] = v1[v2] * var48_55;
                    v3 = var44_49;
                    v4 = var47_52;
                    v3[v4] = v3[v4] * var48_55;
                    v5 = var45_50;
                    v6 = var47_52;
                    v5[v6] = v5[v6] * var48_55;
                }
                break;
            }
            for (var63_81 = 0; var63_81 < 3; ++var63_81) {
                var65_84 = 0;
                switch (var63_81) {
                    case 0: {
                        var65_84 = var48_54;
                        break;
                    }
                    case 1: {
                        var65_84 = var49_56;
                        break;
                    }
                    case 2: {
                        var65_84 = var50_57;
                        break;
                    }
                }
                var66_86 = var61_79 << 48 | (long)var39_43[var65_84];
                var68_87 /* !! */  = (Kq264)Ha262.d(var46_51, (long)var66_86);
                if (var68_87 /* !! */  == null) {
                    var64_83 = var41_45++;
                    Ha262.q(var46_51, new Kq264(var64_83), (long)var66_86);
                } else {
                    var64_83 = var68_87 /* !! */ .g;
                }
                v7 = var43_48;
                v8 = var64_83;
                v7[v8] = v7[v8] + var57_69;
                v9 = var44_49;
                v10 = var64_83;
                v9[v10] = v9[v10] + var58_72;
                v11 = var45_50;
                v12 = var64_83;
                v11[v12] = v11[v12] + var59_75;
                v13 = var42_47;
                v14 = var64_83;
                v13[v14] = v13[v14] + 1;
            }
            ++var47_52;
        } while (true);
        var47_53 = new Ha262(Jz233.e(var26_31));
        var48_54 = 0;
        var49_56 = 0;
        var50_57 = 0;
        do {
            if (var50_57 < var3_2.g) {
                var51_59 = 0;
                var52_61 = 0;
                var53_63 = var3_2.d[var50_57] & 65535;
                var54_65 = var3_2.j[var50_57] & 255;
            } else {
                Kc180.r(var27_33, var49_56);
                if (var49_56 != var26_31) {
                    Kc180.j(var35_39, var33_38 + (long)(var22_20 * var49_56), var48_54 * 2);
                }
                var7_6.g = var0;
                var7_6.d = (int)(var29_36 + (long)(var48_54 * 2) - var0);
                var7_6.j = var21_24;
                var7_6.q = var8_7;
                return var7_6;
            }
            for (var56_68 = 0; var56_68 < 3; ++var56_68) {
                var58_74 = 0;
                switch (var56_68) {
                    case 0: {
                        var58_74 = var3_2.e[var50_57] & 65535;
                        break;
                    }
                    case 1: {
                        var58_74 = var3_2.h[var50_57] & 65535;
                        break;
                    }
                    case 2: {
                        var58_74 = var3_2.s[var50_57] & 65535;
                        break;
                    }
                }
                var59_77 = var54_65 << 48 | (long)var39_43[var58_74];
                var61_80 = (Kq264)Ha262.d(var46_51, var59_77);
                var62_88 = var61_80.g;
                var63_82 = (long)var53_63 << 32 | (long)(var62_88 << 16) | (long)var58_74;
                var65_85 = (Kq264)Ha262.d(var47_53, var63_82);
                if (var65_85 == null) {
                    var57_71 = var49_56++;
                    var65_85 = new Kq264(var57_71);
                    Kc180.v(var29_36, (float)var2_1.b[var58_74] * Ai354.q / var2_1.n);
                    Kc180.v(var29_36 += 4L, (float)var2_1.l[var58_74] * Ai354.q / var2_1.n);
                    Kc180.v(var29_36 += 4L, (float)var2_1.w[var58_74] * Ai354.q / var2_1.n);
                    var29_36 += 4L;
                    var66_86 = (float)var2_1.r[var58_74] / 2048.0f;
                    var67_89 = 1.0f - (float)var2_1.v[var58_74] / 2048.0f;
                    if (var66_86 <= -16.0f || var67_89 <= -16.0f || var66_86 >= 16.0f || var67_89 >= 16.0f) {
                        Ai354.logger.info("Texcoords exceed compressable range! {},{}", Float.valueOf(var66_86), (Object)Float.valueOf(var67_89));
                    }
                    Kc180.w(var29_36, Ai354.h(var66_86));
                    Kc180.w(var29_36 += 2L, Ai354.h(var67_89));
                    var68_87 /* !! */  = (Kq264)false;
                    var68_87 /* !! */  = (Kq264)(var68_87 /* !! */  | ((int)((var43_48[var62_88] * 0.5f + 0.5f) * 255.0f) & 255) << 0);
                    var68_87 /* !! */  = (Kq264)(var68_87 /* !! */  | ((int)((var44_49[var62_88] * 0.5f + 0.5f) * 255.0f) & 255) << 8);
                    var68_87 /* !! */  = (Kq264)(var68_87 /* !! */  | ((int)((var45_50[var62_88] * 0.5f + 0.5f) * 255.0f) & 255) << 16);
                    Kc180.r(var29_36 += 2L, (int)var68_87 /* !! */ );
                    var29_36 += 4L;
                    if (var8_7) {
                        var69_90 = var37_40[var58_74];
                        for (var70_92 = 0; var70_92 < var69_90.g; ++var29_36, ++var70_92) {
                            Kc180.b(var29_36, var69_90.d[var70_92]);
                        }
                        while (var70_92 < 4) {
                            Kc180.b(var29_36, (byte)0);
                            ++var29_36;
                            ++var70_92;
                        }
                        for (var71_93 = 0; var71_93 < var69_90.g; ++var29_36, ++var71_93) {
                            Kc180.b(var29_36, (byte)(var69_90.q[var71_93] * 255.0f));
                        }
                        while (var71_93 < 4) {
                            Kc180.b(var29_36, (byte)0);
                            ++var29_36;
                            ++var71_93;
                        }
                    }
                    if (Ai354.w) {
                        var69_91 = Gy491.j[var53_63] >> 16 & 255;
                        var70_92 = Gy491.j[var53_63] >> 8 & 255;
                        var71_93 = Gy491.j[var53_63] >> 0 & 255;
                        Kc180.r(var29_36, -16777216 | var69_91 << 0 | var70_92 << 8 | var71_93 << 16);
                        var29_36 += 4L;
                    }
                    Ha262.q(var47_53, var65_85, var63_82);
                } else {
                    var57_71 = var65_85.g;
                }
                if (var56_68 >= 2) {
                    Kc180.w(var31_37, (short)(var51_59 ? 1 : 0));
                    Kc180.w(var31_37 += 2L, (short)var52_61);
                    Kc180.w(var31_37 += 2L, (short)var57_71);
                    var31_37 += 2L;
                    var48_54 += 3;
                } else if (var56_68 == 0) {
                    var51_59 = var57_71;
                }
                var52_61 = var57_71;
            }
            ++var50_57;
        } while (true);
    }

    public static float j(float f) {
        float f2 = f / (float)H149.p * 2.0f - 1.0f;
        return f2;
    }

    public static short h(float f) {
        return (short)(f * 2048.0f);
    }

    public static Bn279 s(Set set, Hi86 hi86, int n) {
        return !set.isEmpty() ? Hi86.s(hi86, N105.class, Fk353.class, set, r, n, null, null) : null;
    }

    static {
        logger = LoggerFactory.getLogger(Ai354.class);
        q = 0.015625f;
        j = Ai354.g('M', 'E', 'S', 'H');
        w = true;
        r = new K547();
    }

    public static float e(float f) {
        float f2 = (1.0f - f / (float)H149.x) * 2.0f - 1.0f;
        return f2;
    }

    public static N105 d(Fk353[] arrfk353, Hi86 hi86) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        boolean bl = false;
        for (Fk353 n4 : arrfk353) {
            bl |= n4.y != null;
            n3 += n4.t;
            n2 += n4.m;
            n += n4.u;
        }
        N105 n105 = new N105(hi86, n, bl, 1048576 + n3 * 32 + n2 * 2);
        long l = N105.j(n105);
        int n4 = 0;
        for (int i = 0; i < arrfk353.length; ++i) {
            Fk353 fk353 = arrfk353[i];
            for (int j = 0; j < fk353.u; ++j) {
                Aq544 aq544 = Ai354.q(l, fk353, fk353.z[j], hi86, null, null);
                l += (long)aq544.d;
                N105.h(n105, n4++, aq544);
            }
        }
        return n105;
    }
}

