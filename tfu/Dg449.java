/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.Q280;
import java.io.PrintStream;
import tfu.Da631;
import tfu.Db630;
import tfu.Di627;
import tfu.Dk626;
import tfu.Dm448;
import tfu.Dy619;
import tfu.Eb613;
import tfu.Ec614;
import tfu.Ef450;
import tfu.Eh618;
import tfu.Ei604;
import tfu.Em610;
import tfu.Eo611;
import tfu.Ep612;
import tfu.Es576;
import tfu.Ez447;
import tfu.Gg3;
import tfu.Gx298;

public class Dg449 {
    private static final int b = 5;
    private static final int e = 2;
    private static final int h = 3;
    private static final int j = 1;
    private static final int l = 6;
    private static final int p = 11;
    private static final int r = 8;
    private static final int s = 4;
    private static final int u = 13;
    private static final int v = 9;
    private static final int w = 7;
    private static final int x = 12;
    private static final int y = 10;
    private static final int z = 14;
    public int d = -1;
    public long g;
    Gx298 q = new Gx298();

    public Dg449(Gg3 gg3) {
        this.g(gg3);
    }

    public void g(Gg3 gg3) {
        this.g = Gg3.bq(gg3);
        this.d = Gg3.bd(gg3);
        int n = Gg3.ar(gg3);
        while (n != 0) {
            Dm448 dm448;
            if (Ef450.g) {
                System.out.println("t:" + n);
            }
            if (n == 3) {
                dm448 = new Dk626(this);
            } else if (n == 1) {
                dm448 = new Ec614(this);
            } else if (n == 13) {
                dm448 = new Ei604(this);
            } else if (n == 4) {
                dm448 = new Ep612(this);
            } else if (n == 6) {
                dm448 = new Eo611(this);
            } else if (n == 5) {
                dm448 = new Db630(this);
            } else if (n == 2) {
                dm448 = new Eh618(this);
            } else if (n == 7) {
                dm448 = new Dy619(this);
            } else if (n == 14) {
                dm448 = new Di627(this);
            } else if (n == 8) {
                dm448 = new Em610(this);
            } else if (n == 9) {
                dm448 = new Da631(this);
            } else if (n == 10) {
                dm448 = new Eb613(this);
            } else if (n == 11) {
                dm448 = new Es576(this);
            } else if (n == 12) {
                dm448 = new Ez447(this);
            } else {
                throw new RuntimeException("Unrecognised ClanSettingsDelta type in decode()");
            }
            ((Dm448)dm448).g(gg3);
            Gx298.t(this.q, dm448);
            n = Gg3.ar(gg3);
        }
    }

    public void d(Ef450 ef450) {
        if (ef450.h != this.g || ef450.s != this.d) {
            throw new RuntimeException("ClanSettingsDelta.applyToClanSettings(): Credentials do not match! Settings.owner:" + Q280.g(ef450.h) + " updateNum:" + ef450.s + " delta.owner:" + Q280.g(this.g) + " updateNum:" + this.d);
        }
        Dm448 dm448 = (Dm448)Gx298.i(this.q);
        while (dm448 != null) {
            dm448.d(ef450);
            dm448 = (Dm448)Gx298.c(this.q);
        }
        ++ef450.s;
    }

    public Dg449(Ef450 ef450) {
        this.g = ef450.h;
        this.d = ef450.s;
    }
}

