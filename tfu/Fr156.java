/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Gg3;
import tfu.Ln265;

public class Fr156
extends Ln265 {
    public static final int aa = 0;
    public static final int ag = 3;
    public static final int ap = 0;
    public static final int aq = 4;
    public static final int c = 2;
    private static final boolean d = false;
    public static final int e = 2;
    public static final int f = 1;
    private static final boolean g = true;
    public static final int h = 3;
    public static final int i = 22;
    public static final int j = 1;
    public static final int k = 21;
    public static final int m = 9;
    public static final int n = 20;
    public static final int o = 23;
    public static final int p = 4;
    private static final int q = 6;
    public static final int r = 1;
    public static final int s = 4;
    public static final int t = 8;
    public static final int u = 6;
    public static final int v = 2;
    public static final int w = 0;
    public static final int x = 5;
    public static final int y = 3;
    public static final int z = 7;
    public int a;
    public String ab;
    public String ac;
    public int ad;
    public int af;
    public int ah;
    public int ai;
    public String aj;
    public String ak;
    public int al;
    public int am;
    public int an;
    public int ao;
    public int ar;
    public String as;
    public String at;
    public int au;
    public int av;
    public int aw;
    public int ax;
    public int[] ay;
    public boolean az;
    public int b;
    public boolean l;

    public Fr156() {
        this.ay = new int[3];
    }

    public static void d(Fr156 fr156, Gg3 gg3) {
        Gg3.k(gg3, 6);
        Gg3.k(gg3, fr156.b);
        Gg3.k(gg3, fr156.l ? 1 : 0);
        Gg3.k(gg3, fr156.a);
        Gg3.k(gg3, fr156.ai);
        Gg3.k(gg3, fr156.al);
        Gg3.k(gg3, fr156.af);
        Gg3.k(gg3, fr156.av);
        Gg3.k(gg3, fr156.az ? 1 : 0);
        Gg3.i(gg3, fr156.ah);
        Gg3.k(gg3, fr156.ao);
        Gg3.o(gg3, fr156.an);
        Gg3.i(gg3, fr156.am);
        gg3.ap(fr156.as);
        gg3.ap(fr156.ac);
        gg3.ap(fr156.at);
        gg3.ap(fr156.ab);
        Gg3.k(gg3, fr156.ar);
        Gg3.i(gg3, fr156.aw);
        gg3.ap(fr156.aj);
        gg3.ap(fr156.ak);
        Gg3.k(gg3, fr156.ax);
        Gg3.k(gg3, fr156.au);
        for (int i = 0; i < fr156.ay.length; ++i) {
            Gg3.a(gg3, fr156.ay[i]);
        }
        Gg3.a(gg3, fr156.ad);
    }

    public Fr156(Gg3 gg3) {
        this.ay = new int[3];
        int n = Gg3.ar(gg3);
        if (n > 6) {
            throw new RuntimeException("Invalid userstats version: " + n);
        }
        this.b = Gg3.ar(gg3);
        boolean bl = this.l = Gg3.ar(gg3) == 1;
        if (n > 2) {
            this.a = Gg3.ar(gg3);
        }
        this.ai = Gg3.ar(gg3);
        this.al = Gg3.ar(gg3);
        this.af = Gg3.ar(gg3);
        if (n > 1) {
            this.av = Gg3.ar(gg3);
        }
        this.az = Gg3.ar(gg3) == 1;
        this.ah = Gg3.au(gg3);
        this.ao = Gg3.ar(gg3);
        this.an = Gg3.ay(gg3);
        if (n == 3) {
            Gg3.bd(gg3);
        }
        if (n > 3) {
            this.am = Gg3.au(gg3);
            if (n <= 5) {
                Gg3.ar(gg3);
                Gg3.ar(gg3);
                Gg3.ar(gg3);
            }
            this.as = gg3.bh();
            this.ac = gg3.bh();
            this.at = gg3.bh();
            this.ab = gg3.bh();
            this.ar = Gg3.ar(gg3);
            this.aw = Gg3.au(gg3);
        } else {
            this.ab = "";
            this.at = "";
            this.ac = "";
            this.as = "";
        }
        if (n > 5) {
            this.aj = gg3.bh();
            this.ak = gg3.bh();
            this.ax = Gg3.ar(gg3);
            this.au = Gg3.ar(gg3);
            for (int i = 0; i < this.ay.length; ++i) {
                this.ay[i] = Gg3.bd(gg3);
            }
            this.ad = Gg3.bd(gg3);
        } else {
            this.ak = "";
            this.aj = "";
        }
        Fr156.g(this);
    }

    private static void g(Fr156 fr156) {
        if (fr156.as.length() > 40) {
            fr156.as = fr156.as.substring(0, 40);
        }
        if (fr156.ac.length() > 40) {
            fr156.ac = fr156.ac.substring(0, 40);
        }
        if (fr156.at.length() > 10) {
            fr156.at = fr156.at.substring(0, 10);
        }
        if (fr156.ab.length() > 10) {
            fr156.ab = fr156.ab.substring(0, 10);
        }
    }

    /*
     * Exception decompiling
     */
    public Fr156(boolean var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl639 : IINC : trying to set 0 previously set to 2
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:314)
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

    public static int q(Fr156 fr156) {
        int n = 38;
        n += Gg3.av(fr156.as);
        n += Gg3.av(fr156.ac);
        n += Gg3.av(fr156.at);
        n += Gg3.av(fr156.ab);
        n += Gg3.av(fr156.aj);
        return n += Gg3.av(fr156.ak);
    }
}

