// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.js5;

import tfu.Lb33;
import tfu.Hl134;
import tfu.Iw364;
import java.math.BigInteger;
import tfu.Gg3;

public class G137
{
    private L145 d;
    private B360 e;
    private W144 g;
    private Gg3 h;
    private BigInteger j;
    private BigInteger q;
    private Q138[] s;
    
    public G137(final W144 g, final L145 d, final BigInteger q, final BigInteger j) {
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
        if (!W144.q(this.g)) {
            this.e = this.g.g(255, 255, (byte)0, true);
        }
    }
    
    public boolean g() {
        if (this.h != null) {
            return true;
        }
        if (this.e == null) {
            if (W144.q(this.g)) {
                return false;
            }
            this.e = this.g.g(255, 255, (byte)0, true);
        }
        if (this.e.l) {
            return false;
        }
        final Gg3 h = new Gg3(this.e.g());
        h.v = 5;
        final int ar = Gg3.ar(h);
        final Gg3 gg3 = h;
        gg3.v += ar * 72;
        final byte[] val = new byte[h.r.length - h.v];
        Gg3.bx(h, val, 0, val.length);
        byte[] byteArray;
        if (this.q == null || this.j == null) {
            byteArray = val;
        }
        else {
            byteArray = new BigInteger(val).modPow(this.q, this.j).toByteArray();
        }
        if (byteArray.length != 65) {
            throw new RuntimeException("Incorrect Whirlpool length - got: " + byteArray.length + " bytes");
        }
        final byte[] e = Iw364.e(h.r, 5, h.v - val.length - 5);
        for (int i = 0; i < 64; ++i) {
            if (e[i] != byteArray[i + 1]) {
                throw new RuntimeException("Masterindex Whirlpool from server does not match my calculation - expected:" + js5.av(byteArray) + " got:" + js5.av(e));
            }
        }
        this.s = new Q138[ar];
        this.h = h;
        return true;
    }
    
    public static Q138 d(final G137 g137, final int n, final Hl134 hl134, final Hl134 hl135) {
        return g137.q(n, hl134, hl135, true);
    }
    
    public Q138 q(final int n, final Hl134 hl134, final Hl134 hl135, final boolean b) {
        if (this.h == null) {
            throw new RuntimeException("Not ready!");
        }
        if (n < 0 || n >= this.s.length) {
            throw new RuntimeException("Invalid archiveid requested - archiveid:" + n);
        }
        if (this.s[n] != null) {
            return this.s[n];
        }
        this.h.v = n * 72 + 6;
        final int bd = Gg3.bd(this.h);
        final int bd2 = Gg3.bd(this.h);
        final byte[] array = new byte[64];
        Gg3.bx(this.h, array, 0, 64);
        if (bd == 0) {
            System.out.println("Warning: indexcrc==0 - likely invalid archiveid requested - archiveid:" + n);
        }
        return this.s[n] = new Q138(n, hl134, hl135, this.g, this.d, bd, array, bd2, b);
    }
    
    public static void j(final G137 g137) {
        if (g137.s == null) {
            return;
        }
        Lb33.g(Lb33.Js5Archive);
        try {
            for (int i = 0; i < g137.s.length; ++i) {
                if (g137.s[i] != null) {
                    Q138.e(g137.s[i]);
                }
            }
            for (int j = 0; j < g137.s.length; ++j) {
                if (g137.s[j] != null) {
                    g137.s[j].h();
                }
            }
        }
        finally {
            Lb33.d(Lb33.Js5Archive);
        }
    }
    
    public G137(final W144 w144, final L145 l145) {
        this(w144, l145, null, null);
    }
}
