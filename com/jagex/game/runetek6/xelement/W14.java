/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.O558;
import tfu.Gg3;

public class W14 {
    private int d;
    public float e = 1.0f;
    public String g;
    public float h = 512.0f;
    public float j = 0.0f;
    private int q;
    public short[] s;

    public static int g(W14 w14) {
        return w14.d;
    }

    public static int d(W14 w14) {
        return w14.q;
    }

    public static void j(W14 w14, Gg3 gg3) {
        Gg3.k(gg3, O558.MISC_PROPERTIES.e);
        Gg3.i(gg3, W14.g(w14));
        Gg3.i(gg3, W14.d(w14));
        Gg3.aq(gg3, w14.j);
        Gg3.aq(gg3, w14.e);
        Gg3.aq(gg3, w14.h);
        Gg3.k(gg3, O558.HEIGHT_MAP.e);
        int n = gg3.v += 4;
        short s = 0;
        for (int i = 0; i < w14.s.length; ++i) {
            Gg3.aw(gg3, w14.s[i] - s);
            s = w14.s[i];
        }
        Gg3.am(gg3, gg3.v - n);
        if (w14.g != null) {
            Gg3.k(gg3, O558.XML.e);
            Gg3.a(gg3, Gg3.av(w14.g));
            gg3.ap(w14.g);
        }
        Gg3.k(gg3, 0);
    }

    public static W14 q(Gg3 gg3) throws Au64 {
        int n;
        W14 w14 = new W14();
        while ((n = Gg3.ar(gg3)) != 0) {
            O558 o558 = O558.g(n);
            int n2 = o558.h != -1 ? o558.h : Gg3.bd(gg3);
            int n3 = gg3.v + n2;
            switch (o558) {
                case MISC_PROPERTIES: {
                    w14.d = Gg3.au(gg3);
                    w14.q = Gg3.au(gg3);
                    w14.j = Gg3.bl(gg3);
                    w14.e = Gg3.bl(gg3);
                    w14.h = Gg3.bl(gg3);
                    break;
                }
                case HEIGHT_MAP: {
                    int n4 = w14.d * w14.q;
                    w14.s = new short[n4];
                    int n5 = 0;
                    for (int i = 0; i < n4; ++i) {
                        w14.s[i] = (short)(n5 + Gg3.bg(gg3));
                        n5 = w14.s[i];
                    }
                    break;
                }
                case XML: {
                    w14.g = gg3.bh();
                    break;
                }
                default: {
                    gg3.v += n2;
                }
            }
            if (gg3.v == n3) continue;
            throw new Au64("Chunk length mismatch when deserialising " + (Object)((Object)o558) + ": expected " + n2 + " bytes, read " + (gg3.v - (n3 - n2)) + " bytes");
        }
        return w14;
    }
}

