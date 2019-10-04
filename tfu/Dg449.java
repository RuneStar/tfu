// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.stringtools.general.Q280;

public class Dg449
{
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
    public int d;
    public long g;
    Gx298 q;
    
    public Dg449(final Gg3 gg3) {
        this.d = -1;
        this.q = new Gx298();
        this.g(gg3);
    }
    
    public void g(final Gg3 gg3) {
        this.g = Gg3.bq(gg3);
        this.d = Gg3.bd(gg3);
        for (int i = Gg3.ar(gg3); i != 0; i = Gg3.ar(gg3)) {
            if (Ef450.g) {
                System.out.println("t:" + i);
            }
            Dm448 dm448;
            if (i == 3) {
                dm448 = new Dk626(this);
            }
            else if (i == 1) {
                dm448 = new Ec614(this);
            }
            else if (i == 13) {
                dm448 = new Ei604(this);
            }
            else if (i == 4) {
                dm448 = new Ep612(this);
            }
            else if (i == 6) {
                dm448 = new Eo611(this);
            }
            else if (i == 5) {
                dm448 = new Db630(this);
            }
            else if (i == 2) {
                dm448 = new Eh618(this);
            }
            else if (i == 7) {
                dm448 = new Dy619(this);
            }
            else if (i == 14) {
                dm448 = new Di627(this);
            }
            else if (i == 8) {
                dm448 = new Em610(this);
            }
            else if (i == 9) {
                dm448 = new Da631(this);
            }
            else if (i == 10) {
                dm448 = new Eb613(this);
            }
            else if (i == 11) {
                dm448 = new Es576(this);
            }
            else {
                if (i != 12) {
                    throw new RuntimeException("Unrecognised ClanSettingsDelta type in decode()");
                }
                dm448 = new Ez447(this);
            }
            dm448.g(gg3);
            Gx298.t(this.q, dm448);
        }
    }
    
    public void d(final Ef450 ef450) {
        if (ef450.h != this.g || ef450.s != this.d) {
            throw new RuntimeException("ClanSettingsDelta.applyToClanSettings(): Credentials do not match! Settings.owner:" + Q280.g(ef450.h) + " updateNum:" + ef450.s + " delta.owner:" + Q280.g(this.g) + " updateNum:" + this.d);
        }
        for (Dm448 dm448 = (Dm448)Gx298.i(this.q); dm448 != null; dm448 = (Dm448)Gx298.c(this.q)) {
            dm448.d(ef450);
        }
        ++ef450.s;
    }
    
    public Dg449(final Ef450 ef450) {
        this.d = -1;
        this.q = new Gx298();
        this.g = ef450.h;
        this.d = ef450.s;
    }
}
