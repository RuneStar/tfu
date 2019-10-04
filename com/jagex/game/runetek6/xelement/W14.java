// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Gg3;

public class W14
{
    private int d;
    public float e;
    public String g;
    public float h;
    public float j;
    private int q;
    public short[] s;
    
    public static int g(final W14 w14) {
        return w14.d;
    }
    
    public static int d(final W14 w14) {
        return w14.q;
    }
    
    public static void j(final W14 w14, final Gg3 gg3) {
        Gg3.k(gg3, O558.MISC_PROPERTIES.e);
        Gg3.i(gg3, g(w14));
        Gg3.i(gg3, d(w14));
        Gg3.aq(gg3, w14.j);
        Gg3.aq(gg3, w14.e);
        Gg3.aq(gg3, w14.h);
        Gg3.k(gg3, O558.HEIGHT_MAP.e);
        final int v = gg3.v + 4;
        gg3.v = v;
        final int n = v;
        short n2 = 0;
        for (int i = 0; i < w14.s.length; ++i) {
            Gg3.aw(gg3, w14.s[i] - n2);
            n2 = w14.s[i];
        }
        Gg3.am(gg3, gg3.v - n);
        if (w14.g != null) {
            Gg3.k(gg3, O558.XML.e);
            Gg3.a(gg3, Gg3.av(w14.g));
            gg3.ap(w14.g);
        }
        Gg3.k(gg3, 0);
    }
    
    public static W14 q(final Gg3 gg3) throws Au64 {
        final W14 w14 = new W14();
        int ar;
        while ((ar = Gg3.ar(gg3)) != 0) {
            final O558 g = O558.g(ar);
            final int i = (g.h != -1) ? g.h : Gg3.bd(gg3);
            final int n = gg3.v + i;
            switch (U567.g[g.ordinal()]) {
                case 1: {
                    w14.d = Gg3.au(gg3);
                    w14.q = Gg3.au(gg3);
                    w14.j = Gg3.bl(gg3);
                    w14.e = Gg3.bl(gg3);
                    w14.h = Gg3.bl(gg3);
                    break;
                }
                case 2: {
                    final int n2 = w14.d * w14.q;
                    w14.s = new short[n2];
                    int n3 = 0;
                    for (int j = 0; j < n2; ++j) {
                        final short[] s = w14.s;
                        final int n4 = j;
                        final short n5 = (short)(n3 + Gg3.bg(gg3));
                        s[n4] = n5;
                        n3 = n5;
                    }
                    break;
                }
                case 3: {
                    w14.g = gg3.bh();
                    break;
                }
                default: {
                    gg3.v += i;
                    break;
                }
            }
            if (gg3.v != n) {
                throw new Au64("Chunk length mismatch when deserialising " + g + ": expected " + i + " bytes, read " + (gg3.v - (n - i)) + " bytes");
            }
        }
        return w14;
    }
    
    public W14() {
        this.j = 0.0f;
        this.e = 1.0f;
        this.h = 512.0f;
    }
}
