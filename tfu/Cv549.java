/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Cb633;
import tfu.Cd585;
import tfu.Cj551;
import tfu.Cs635;
import tfu.Cw634;
import tfu.Cx556;

public class Cv549
extends Cs635 {
    protected Cv549(Cj551 cj551, int n, int n2, int n3) {
        this.bm = cj551;
        this.u = cj551.d;
        this.z = cj551.q;
        this.t = cj551.j;
        this.e = n;
        this.h = n2;
        this.s = n3;
        this.j = 0;
        Cv549.bd(this);
    }

    private static int h(Cv549 cv549, int[] arrn, int n, int n2, int n3, int n4) {
        while (cv549.m > 0) {
            int n5 = n + cv549.m;
            if (n5 > n3) {
                n5 = n3;
            }
            cv549.m += n;
            n = cv549.e == 256 && (cv549.j & 0xFF) == 0 ? (Cd585.s ? Cv549.o(0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.l, cv549.r, cv549.y, cv549.p, 0, n5, n2, cv549) : Cv549.i(((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.b, cv549.v, 0, n5, n2, cv549)) : (Cd585.s ? Cv549.ag(0, 0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.l, cv549.r, cv549.y, cv549.p, 0, n5, n2, cv549, cv549.e, n4) : Cv549.c(0, 0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.b, cv549.v, 0, n5, n2, cv549, cv549.e, n4));
            cv549.m -= n;
            if (cv549.m != 0) {
                return n;
            }
            if (!Cv549.bg(cv549)) continue;
            return n3;
        }
        if (cv549.e == 256 && (cv549.j & 0xFF) == 0) {
            if (Cd585.s) {
                return Cv549.v(0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.l, cv549.r, 0, n3, n2, cv549);
            }
            return Cv549.r(((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.b, 0, n3, n2, cv549);
        }
        if (Cd585.s) {
            return Cv549.m(0, 0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.l, cv549.r, 0, n3, n2, cv549, cv549.e, n4);
        }
        return Cv549.t(0, 0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.b, 0, n3, n2, cv549, cv549.e, n4);
    }

    private static int s(Cv549 cv549, int[] arrn, int n, int n2, int n3, int n4) {
        while (cv549.m > 0) {
            int n5 = n + cv549.m;
            if (n5 > n3) {
                n5 = n3;
            }
            cv549.m += n;
            n = cv549.e == -256 && (cv549.j & 0xFF) == 0 ? (Cd585.s ? Cv549.f(0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.l, cv549.r, cv549.y, cv549.p, 0, n5, n2, cv549) : Cv549.a(((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.b, cv549.v, 0, n5, n2, cv549)) : (Cd585.s ? Cv549.ai(0, 0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.l, cv549.r, cv549.y, cv549.p, 0, n5, n2, cv549, cv549.e, n4) : Cv549.aq(0, 0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.b, cv549.v, 0, n5, n2, cv549, cv549.e, n4));
            cv549.m -= n;
            if (cv549.m != 0) {
                return n;
            }
            if (!Cv549.bg(cv549)) continue;
            return n3;
        }
        if (cv549.e == -256 && (cv549.j & 0xFF) == 0) {
            if (Cd585.s) {
                return Cv549.z(0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.l, cv549.r, 0, n3, n2, cv549);
            }
            return Cv549.u(((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.b, 0, n3, n2, cv549);
        }
        if (Cd585.s) {
            return Cv549.k(0, 0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.l, cv549.r, 0, n3, n2, cv549, cv549.e, n4);
        }
        return Cv549.n(0, 0, ((Cj551)cv549.bm).e, arrn, cv549.j, n, cv549.b, 0, n3, n2, cv549, cv549.e, n4);
    }

    protected Cv549(Cj551 cj551, int n, int n2) {
        this.bm = cj551;
        this.u = cj551.d;
        this.z = cj551.q;
        this.t = cj551.j;
        this.e = n;
        this.h = n2;
        this.s = 8192;
        this.j = 0;
        Cv549.bd(this);
    }

    private static int k(int n, int n2, byte[] arrby, int[] arrn, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Cv549 cv549, int n10, int n11) {
        if (n10 == 0 || (n7 = n4 + (n9 + 256 - n3 + n10) / n10) > n8) {
            n7 = n8;
        }
        n4 <<= 1;
        while (n4 < (n7 <<= 1)) {
            n2 = n3 >> 8;
            n = arrby[n2 - 1];
            n = (n << 8) + (arrby[n2] - n) * (n3 & 0xFF);
            int[] arrn2 = arrn;
            int n12 = n4++;
            arrn2[n12] = arrn2[n12] + (n * n5 >> 6);
            int[] arrn3 = arrn;
            int n13 = n4++;
            arrn3[n13] = arrn3[n13] + (n * n6 >> 6);
            n3 += n10;
        }
        if (n10 == 0 || (n7 = (n4 >> 1) + (n9 - n3 + n10) / n10) > n8) {
            n7 = n8;
        }
        n2 = n11;
        while (n4 < (n7 <<= 1)) {
            n = (n2 << 8) + (arrby[n3 >> 8] - n2) * (n3 & 0xFF);
            int[] arrn4 = arrn;
            int n14 = n4++;
            arrn4[n14] = arrn4[n14] + (n * n5 >> 6);
            int[] arrn5 = arrn;
            int n15 = n4++;
            arrn5[n15] = arrn5[n15] + (n * n6 >> 6);
            n3 += n10;
        }
        cv549.j = n3;
        return n4 >> 1;
    }

    private static int u(byte[] arrby, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, Cv549 cv549) {
        n3 <<= 2;
        n4 = n2 + (n >>= 8) - ((n6 >>= 8) - 1);
        if (n4 > n5) {
            n4 = n5;
        }
        while (n2 < (n4 -= 3)) {
            int[] arrn2 = arrn;
            int n7 = n2++;
            arrn2[n7] = arrn2[n7] + arrby[n--] * n3;
            int[] arrn3 = arrn;
            int n8 = n2++;
            arrn3[n8] = arrn3[n8] + arrby[n--] * n3;
            int[] arrn4 = arrn;
            int n9 = n2++;
            arrn4[n9] = arrn4[n9] + arrby[n--] * n3;
            int[] arrn5 = arrn;
            int n10 = n2++;
            arrn5[n10] = arrn5[n10] + arrby[n--] * n3;
        }
        while (n2 < (n4 += 3)) {
            int[] arrn6 = arrn;
            int n11 = n2++;
            arrn6[n11] = arrn6[n11] + arrby[n--] * n3;
        }
        cv549.j = n << 8;
        return n2;
    }

    private static int z(int n, byte[] arrby, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Cv549 cv549) {
        n4 <<= 2;
        n5 <<= 2;
        n6 = n3 + (n2 >>= 8) - ((n8 >>= 8) - 1);
        if (n6 > n7) {
            n6 = n7;
        }
        n3 <<= 1;
        n6 <<= 1;
        while (n3 < (n6 -= 6)) {
            n = arrby[n2--];
            int[] arrn2 = arrn;
            int n9 = n3++;
            arrn2[n9] = arrn2[n9] + n * n4;
            int[] arrn3 = arrn;
            int n10 = n3++;
            arrn3[n10] = arrn3[n10] + n * n5;
            n = arrby[n2--];
            int[] arrn4 = arrn;
            int n11 = n3++;
            arrn4[n11] = arrn4[n11] + n * n4;
            int[] arrn5 = arrn;
            int n12 = n3++;
            arrn5[n12] = arrn5[n12] + n * n5;
            n = arrby[n2--];
            int[] arrn6 = arrn;
            int n13 = n3++;
            arrn6[n13] = arrn6[n13] + n * n4;
            int[] arrn7 = arrn;
            int n14 = n3++;
            arrn7[n14] = arrn7[n14] + n * n5;
            n = arrby[n2--];
            int[] arrn8 = arrn;
            int n15 = n3++;
            arrn8[n15] = arrn8[n15] + n * n4;
            int[] arrn9 = arrn;
            int n16 = n3++;
            arrn9[n16] = arrn9[n16] + n * n5;
        }
        while (n3 < (n6 += 6)) {
            n = arrby[n2--];
            int[] arrn10 = arrn;
            int n17 = n3++;
            arrn10[n17] = arrn10[n17] + n * n4;
            int[] arrn11 = arrn;
            int n18 = n3++;
            arrn11[n18] = arrn11[n18] + n * n5;
        }
        cv549.j = n2 << 8;
        return n3 >> 1;
    }

    private static int a(byte[] arrby, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, int n7, Cv549 cv549) {
        n3 <<= 2;
        n4 <<= 2;
        n5 = n2 + (n >>= 8) - ((n7 >>= 8) - 1);
        if (n5 > n6) {
            n5 = n6;
        }
        cv549.l += cv549.y * (n5 - n2);
        cv549.r += cv549.p * (n5 - n2);
        while (n2 < (n5 -= 3)) {
            int[] arrn2 = arrn;
            int n8 = n2++;
            arrn2[n8] = arrn2[n8] + arrby[n--] * n3;
            int[] arrn3 = arrn;
            int n9 = n2++;
            arrn3[n9] = arrn3[n9] + arrby[n--] * (n3 += n4);
            int[] arrn4 = arrn;
            int n10 = n2++;
            arrn4[n10] = arrn4[n10] + arrby[n--] * (n3 += n4);
            int[] arrn5 = arrn;
            int n11 = n2++;
            arrn5[n11] = arrn5[n11] + arrby[n--] * (n3 += n4);
            n3 += n4;
        }
        while (n2 < (n5 += 3)) {
            int[] arrn6 = arrn;
            int n12 = n2++;
            arrn6[n12] = arrn6[n12] + arrby[n--] * n3;
            n3 += n4;
        }
        cv549.b = n3 >> 2;
        cv549.j = n << 8;
        return n2;
    }

    private static int m(int n, int n2, byte[] arrby, int[] arrn, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Cv549 cv549, int n10, int n11) {
        if (n10 == 0 || (n7 = n4 + (n9 - n3 + n10 - 257) / n10) > n8) {
            n7 = n8;
        }
        n4 <<= 1;
        while (n4 < (n7 <<= 1)) {
            n2 = n3 >> 8;
            n = arrby[n2];
            n = (n << 8) + (arrby[n2 + 1] - n) * (n3 & 0xFF);
            int[] arrn2 = arrn;
            int n12 = n4++;
            arrn2[n12] = arrn2[n12] + (n * n5 >> 6);
            int[] arrn3 = arrn;
            int n13 = n4++;
            arrn3[n13] = arrn3[n13] + (n * n6 >> 6);
            n3 += n10;
        }
        if (n10 == 0 || (n7 = (n4 >> 1) + (n9 - n3 + n10 - 1) / n10) > n8) {
            n7 = n8;
        }
        n2 = n11;
        while (n4 < (n7 <<= 1)) {
            n = arrby[n3 >> 8];
            n = (n << 8) + (n2 - n) * (n3 & 0xFF);
            int[] arrn4 = arrn;
            int n14 = n4++;
            arrn4[n14] = arrn4[n14] + (n * n5 >> 6);
            int[] arrn5 = arrn;
            int n15 = n4++;
            arrn5[n15] = arrn5[n15] + (n * n6 >> 6);
            n3 += n10;
        }
        cv549.j = n3;
        return n4 >> 1;
    }

    /*
     * Exception decompiling
     */
    @Override
    public synchronized void j(int[] var1_1, int var2_2, int var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[DOLOOP]], but top level block is 24[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:619)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:699)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:188)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:133)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:225)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:109)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        // org.runestar.tfudeob.MainKt.decompileCfr(Main.kt:49)
        // org.runestar.tfudeob.MainKt.deob(Main.kt:37)
        // org.runestar.tfudeob.MainKt.main(Main.kt:11)
        // org.runestar.tfudeob.MainKt.main(Main.kt)
        throw new IllegalStateException("Decompilation failed");
    }

    private static int v(int n, byte[] arrby, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Cv549 cv549) {
        n4 <<= 2;
        n5 <<= 2;
        n6 = n3 + (n8 >>= 8) - (n2 >>= 8);
        if (n6 > n7) {
            n6 = n7;
        }
        n3 <<= 1;
        n6 <<= 1;
        while (n3 < (n6 -= 6)) {
            n = arrby[n2++];
            int[] arrn2 = arrn;
            int n9 = n3++;
            arrn2[n9] = arrn2[n9] + n * n4;
            int[] arrn3 = arrn;
            int n10 = n3++;
            arrn3[n10] = arrn3[n10] + n * n5;
            n = arrby[n2++];
            int[] arrn4 = arrn;
            int n11 = n3++;
            arrn4[n11] = arrn4[n11] + n * n4;
            int[] arrn5 = arrn;
            int n12 = n3++;
            arrn5[n12] = arrn5[n12] + n * n5;
            n = arrby[n2++];
            int[] arrn6 = arrn;
            int n13 = n3++;
            arrn6[n13] = arrn6[n13] + n * n4;
            int[] arrn7 = arrn;
            int n14 = n3++;
            arrn7[n14] = arrn7[n14] + n * n5;
            n = arrby[n2++];
            int[] arrn8 = arrn;
            int n15 = n3++;
            arrn8[n15] = arrn8[n15] + n * n4;
            int[] arrn9 = arrn;
            int n16 = n3++;
            arrn9[n16] = arrn9[n16] + n * n5;
        }
        while (n3 < (n6 += 6)) {
            n = arrby[n2++];
            int[] arrn10 = arrn;
            int n17 = n3++;
            arrn10[n17] = arrn10[n17] + n * n4;
            int[] arrn11 = arrn;
            int n18 = n3++;
            arrn11[n18] = arrn11[n18] + n * n5;
        }
        cv549.j = n2 << 8;
        return n3 >> 1;
    }

    private static int i(byte[] arrby, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, int n7, Cv549 cv549) {
        n3 <<= 2;
        n4 <<= 2;
        n5 = n2 + (n7 >>= 8) - (n >>= 8);
        if (n5 > n6) {
            n5 = n6;
        }
        cv549.l += cv549.y * (n5 - n2);
        cv549.r += cv549.p * (n5 - n2);
        while (n2 < (n5 -= 3)) {
            int[] arrn2 = arrn;
            int n8 = n2++;
            arrn2[n8] = arrn2[n8] + arrby[n++] * n3;
            int[] arrn3 = arrn;
            int n9 = n2++;
            arrn3[n9] = arrn3[n9] + arrby[n++] * (n3 += n4);
            int[] arrn4 = arrn;
            int n10 = n2++;
            arrn4[n10] = arrn4[n10] + arrby[n++] * (n3 += n4);
            int[] arrn5 = arrn;
            int n11 = n2++;
            arrn5[n11] = arrn5[n11] + arrby[n++] * (n3 += n4);
            n3 += n4;
        }
        while (n2 < (n5 += 3)) {
            int[] arrn6 = arrn;
            int n12 = n2++;
            arrn6[n12] = arrn6[n12] + arrby[n++] * n3;
            n3 += n4;
        }
        cv549.b = n3 >> 2;
        cv549.j = n << 8;
        return n2;
    }

    private static int o(int n, byte[] arrby, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, Cv549 cv549) {
        n4 <<= 2;
        n5 <<= 2;
        n6 <<= 2;
        n7 <<= 2;
        n8 = n3 + (n10 >>= 8) - (n2 >>= 8);
        if (n8 > n9) {
            n8 = n9;
        }
        cv549.b += cv549.v * (n8 - n3);
        n3 <<= 1;
        n8 <<= 1;
        while (n3 < (n8 -= 6)) {
            n = arrby[n2++];
            int[] arrn2 = arrn;
            int n11 = n3++;
            arrn2[n11] = arrn2[n11] + n * n4;
            int[] arrn3 = arrn;
            int n12 = n3++;
            arrn3[n12] = arrn3[n12] + n * n5;
            n = arrby[n2++];
            int[] arrn4 = arrn;
            int n13 = n3++;
            arrn4[n13] = arrn4[n13] + n * (n4 += n6);
            int[] arrn5 = arrn;
            int n14 = n3++;
            arrn5[n14] = arrn5[n14] + n * (n5 += n7);
            n = arrby[n2++];
            int[] arrn6 = arrn;
            int n15 = n3++;
            arrn6[n15] = arrn6[n15] + n * (n4 += n6);
            int[] arrn7 = arrn;
            int n16 = n3++;
            arrn7[n16] = arrn7[n16] + n * (n5 += n7);
            n = arrby[n2++];
            int[] arrn8 = arrn;
            int n17 = n3++;
            arrn8[n17] = arrn8[n17] + n * (n4 += n6);
            n4 += n6;
            int[] arrn9 = arrn;
            int n18 = n3++;
            arrn9[n18] = arrn9[n18] + n * (n5 += n7);
            n5 += n7;
        }
        while (n3 < (n8 += 6)) {
            n = arrby[n2++];
            int[] arrn10 = arrn;
            int n19 = n3++;
            arrn10[n19] = arrn10[n19] + n * n4;
            n4 += n6;
            int[] arrn11 = arrn;
            int n20 = n3++;
            arrn11[n20] = arrn11[n20] + n * n5;
            n5 += n7;
        }
        cv549.l = n4 >> 2;
        cv549.r = n5 >> 2;
        cv549.j = n2 << 8;
        return n3 >> 1;
    }

    private static int f(int n, byte[] arrby, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, Cv549 cv549) {
        n4 <<= 2;
        n5 <<= 2;
        n6 <<= 2;
        n7 <<= 2;
        n8 = n3 + (n2 >>= 8) - ((n10 >>= 8) - 1);
        if (n8 > n9) {
            n8 = n9;
        }
        cv549.b += cv549.v * (n8 - n3);
        n3 <<= 1;
        n8 <<= 1;
        while (n3 < (n8 -= 6)) {
            n = arrby[n2--];
            int[] arrn2 = arrn;
            int n11 = n3++;
            arrn2[n11] = arrn2[n11] + n * n4;
            int[] arrn3 = arrn;
            int n12 = n3++;
            arrn3[n12] = arrn3[n12] + n * n5;
            n = arrby[n2--];
            int[] arrn4 = arrn;
            int n13 = n3++;
            arrn4[n13] = arrn4[n13] + n * (n4 += n6);
            int[] arrn5 = arrn;
            int n14 = n3++;
            arrn5[n14] = arrn5[n14] + n * (n5 += n7);
            n = arrby[n2--];
            int[] arrn6 = arrn;
            int n15 = n3++;
            arrn6[n15] = arrn6[n15] + n * (n4 += n6);
            int[] arrn7 = arrn;
            int n16 = n3++;
            arrn7[n16] = arrn7[n16] + n * (n5 += n7);
            n = arrby[n2--];
            int[] arrn8 = arrn;
            int n17 = n3++;
            arrn8[n17] = arrn8[n17] + n * (n4 += n6);
            n4 += n6;
            int[] arrn9 = arrn;
            int n18 = n3++;
            arrn9[n18] = arrn9[n18] + n * (n5 += n7);
            n5 += n7;
        }
        while (n3 < (n8 += 6)) {
            n = arrby[n2--];
            int[] arrn10 = arrn;
            int n19 = n3++;
            arrn10[n19] = arrn10[n19] + n * n4;
            n4 += n6;
            int[] arrn11 = arrn;
            int n20 = n3++;
            arrn11[n20] = arrn11[n20] + n * n5;
            n5 += n7;
        }
        cv549.l = n4 >> 2;
        cv549.r = n5 >> 2;
        cv549.j = n2 << 8;
        return n3 >> 1;
    }

    private static int c(int n, int n2, byte[] arrby, int[] arrn, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Cv549 cv549, int n10, int n11) {
        cv549.l -= cv549.y * n4;
        cv549.r -= cv549.p * n4;
        if (n10 == 0 || (n7 = n4 + (n9 - n3 + n10 - 257) / n10) > n8) {
            n7 = n8;
        }
        while (n4 < n7) {
            n2 = n3 >> 8;
            n = arrby[n2];
            int[] arrn2 = arrn;
            int n12 = n4++;
            arrn2[n12] = arrn2[n12] + (((n << 8) + (arrby[n2 + 1] - n) * (n3 & 0xFF)) * n5 >> 6);
            n5 += n6;
            n3 += n10;
        }
        if (n10 == 0 || (n7 = n4 + (n9 - n3 + n10 - 1) / n10) > n8) {
            n7 = n8;
        }
        n2 = n11;
        while (n4 < n7) {
            n = arrby[n3 >> 8];
            int[] arrn3 = arrn;
            int n13 = n4++;
            arrn3[n13] = arrn3[n13] + (((n << 8) + (n2 - n) * (n3 & 0xFF)) * n5 >> 6);
            n5 += n6;
            n3 += n10;
        }
        cv549.l += cv549.y * n4;
        cv549.r += cv549.p * n4;
        cv549.b = n5;
        cv549.j = n3;
        return n4;
    }

    private static int ag(int n, int n2, byte[] arrby, int[] arrn, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, Cv549 cv549, int n12, int n13) {
        cv549.b -= cv549.v * n4;
        if (n12 == 0 || (n9 = n4 + (n11 - n3 + n12 - 257) / n12) > n10) {
            n9 = n10;
        }
        n4 <<= 1;
        while (n4 < (n9 <<= 1)) {
            n2 = n3 >> 8;
            n = arrby[n2];
            n = (n << 8) + (arrby[n2 + 1] - n) * (n3 & 0xFF);
            int[] arrn2 = arrn;
            int n14 = n4++;
            arrn2[n14] = arrn2[n14] + (n * n5 >> 6);
            n5 += n7;
            int[] arrn3 = arrn;
            int n15 = n4++;
            arrn3[n15] = arrn3[n15] + (n * n6 >> 6);
            n6 += n8;
            n3 += n12;
        }
        if (n12 == 0 || (n9 = (n4 >> 1) + (n11 - n3 + n12 - 1) / n12) > n10) {
            n9 = n10;
        }
        n2 = n13;
        while (n4 < (n9 <<= 1)) {
            n = arrby[n3 >> 8];
            n = (n << 8) + (n2 - n) * (n3 & 0xFF);
            int[] arrn4 = arrn;
            int n16 = n4++;
            arrn4[n16] = arrn4[n16] + (n * n5 >> 6);
            n5 += n7;
            int[] arrn5 = arrn;
            int n17 = n4++;
            arrn5[n17] = arrn5[n17] + (n * n6 >> 6);
            n6 += n8;
            n3 += n12;
        }
        cv549.b += cv549.v * (n4 >>= 1);
        cv549.l = n5;
        cv549.r = n6;
        cv549.j = n3;
        return n4;
    }

    private static int aq(int n, int n2, byte[] arrby, int[] arrn, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Cv549 cv549, int n10, int n11) {
        cv549.l -= cv549.y * n4;
        cv549.r -= cv549.p * n4;
        if (n10 == 0 || (n7 = n4 + (n9 + 256 - n3 + n10) / n10) > n8) {
            n7 = n8;
        }
        while (n4 < n7) {
            n2 = n3 >> 8;
            n = arrby[n2 - 1];
            int[] arrn2 = arrn;
            int n12 = n4++;
            arrn2[n12] = arrn2[n12] + (((n << 8) + (arrby[n2] - n) * (n3 & 0xFF)) * n5 >> 6);
            n5 += n6;
            n3 += n10;
        }
        if (n10 == 0 || (n7 = n4 + (n9 - n3 + n10) / n10) > n8) {
            n7 = n8;
        }
        n = n11;
        n2 = n10;
        while (n4 < n7) {
            int[] arrn3 = arrn;
            int n13 = n4++;
            arrn3[n13] = arrn3[n13] + (((n << 8) + (arrby[n3 >> 8] - n) * (n3 & 0xFF)) * n5 >> 6);
            n5 += n6;
            n3 += n2;
        }
        cv549.l += cv549.y * n4;
        cv549.r += cv549.p * n4;
        cv549.b = n5;
        cv549.j = n3;
        return n4;
    }

    private static int ai(int n, int n2, byte[] arrby, int[] arrn, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, Cv549 cv549, int n12, int n13) {
        cv549.b -= cv549.v * n4;
        if (n12 == 0 || (n9 = n4 + (n11 + 256 - n3 + n12) / n12) > n10) {
            n9 = n10;
        }
        n4 <<= 1;
        while (n4 < (n9 <<= 1)) {
            n2 = n3 >> 8;
            n = arrby[n2 - 1];
            n = (n << 8) + (arrby[n2] - n) * (n3 & 0xFF);
            int[] arrn2 = arrn;
            int n14 = n4++;
            arrn2[n14] = arrn2[n14] + (n * n5 >> 6);
            n5 += n7;
            int[] arrn3 = arrn;
            int n15 = n4++;
            arrn3[n15] = arrn3[n15] + (n * n6 >> 6);
            n6 += n8;
            n3 += n12;
        }
        if (n12 == 0 || (n9 = (n4 >> 1) + (n11 - n3 + n12) / n12) > n10) {
            n9 = n10;
        }
        n2 = n13;
        while (n4 < (n9 <<= 1)) {
            n = (n2 << 8) + (arrby[n3 >> 8] - n2) * (n3 & 0xFF);
            int[] arrn4 = arrn;
            int n16 = n4++;
            arrn4[n16] = arrn4[n16] + (n * n5 >> 6);
            n5 += n7;
            int[] arrn5 = arrn;
            int n17 = n4++;
            arrn5[n17] = arrn5[n17] + (n * n6 >> 6);
            n6 += n8;
            n3 += n12;
        }
        cv549.b += cv549.v * (n4 >>= 1);
        cv549.l = n5;
        cv549.r = n6;
        cv549.j = n3;
        return n4;
    }

    private static int t(int n, int n2, byte[] arrby, int[] arrn, int n3, int n4, int n5, int n6, int n7, int n8, Cv549 cv549, int n9, int n10) {
        if (n9 == 0 || (n6 = n4 + (n8 - n3 + n9 - 257) / n9) > n7) {
            n6 = n7;
        }
        while (n4 < n6) {
            n2 = n3 >> 8;
            n = arrby[n2];
            int[] arrn2 = arrn;
            int n11 = n4++;
            arrn2[n11] = arrn2[n11] + (((n << 8) + (arrby[n2 + 1] - n) * (n3 & 0xFF)) * n5 >> 6);
            n3 += n9;
        }
        if (n9 == 0 || (n6 = n4 + (n8 - n3 + n9 - 1) / n9) > n7) {
            n6 = n7;
        }
        n2 = n10;
        while (n4 < n6) {
            n = arrby[n3 >> 8];
            int[] arrn3 = arrn;
            int n12 = n4++;
            arrn3[n12] = arrn3[n12] + (((n << 8) + (n2 - n) * (n3 & 0xFF)) * n5 >> 6);
            n3 += n9;
        }
        cv549.j = n3;
        return n4;
    }

    private static int r(byte[] arrby, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, Cv549 cv549) {
        n3 <<= 2;
        n4 = n2 + (n6 >>= 8) - (n >>= 8);
        if (n4 > n5) {
            n4 = n5;
        }
        while (n2 < (n4 -= 3)) {
            int[] arrn2 = arrn;
            int n7 = n2++;
            arrn2[n7] = arrn2[n7] + arrby[n++] * n3;
            int[] arrn3 = arrn;
            int n8 = n2++;
            arrn3[n8] = arrn3[n8] + arrby[n++] * n3;
            int[] arrn4 = arrn;
            int n9 = n2++;
            arrn4[n9] = arrn4[n9] + arrby[n++] * n3;
            int[] arrn5 = arrn;
            int n10 = n2++;
            arrn5[n10] = arrn5[n10] + arrby[n++] * n3;
        }
        while (n2 < (n4 += 3)) {
            int[] arrn6 = arrn;
            int n11 = n2++;
            arrn6[n11] = arrn6[n11] + arrby[n++] * n3;
        }
        cv549.j = n << 8;
        return n2;
    }

    private static int n(int n, int n2, byte[] arrby, int[] arrn, int n3, int n4, int n5, int n6, int n7, int n8, Cv549 cv549, int n9, int n10) {
        if (n9 == 0 || (n6 = n4 + (n8 + 256 - n3 + n9) / n9) > n7) {
            n6 = n7;
        }
        while (n4 < n6) {
            n2 = n3 >> 8;
            n = arrby[n2 - 1];
            int[] arrn2 = arrn;
            int n11 = n4++;
            arrn2[n11] = arrn2[n11] + (((n << 8) + (arrby[n2] - n) * (n3 & 0xFF)) * n5 >> 6);
            n3 += n9;
        }
        if (n9 == 0 || (n6 = n4 + (n8 - n3 + n9) / n9) > n7) {
            n6 = n7;
        }
        n = n10;
        n2 = n9;
        while (n4 < n6) {
            int[] arrn3 = arrn;
            int n12 = n4++;
            arrn3[n12] = arrn3[n12] + (((n << 8) + (arrby[n3 >> 8] - n) * (n3 & 0xFF)) * n5 >> 6);
            n3 += n2;
        }
        cv549.j = n3;
        return n4;
    }
}

