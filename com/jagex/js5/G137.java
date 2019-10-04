/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.js5;

import com.jagex.js5.B360;
import com.jagex.js5.E361;
import com.jagex.js5.L145;
import com.jagex.js5.Q138;
import com.jagex.js5.W144;
import com.jagex.js5.js5;
import java.io.PrintStream;
import java.math.BigInteger;
import tfu.Gg3;
import tfu.Hl134;
import tfu.Iw364;
import tfu.Lb33;

public class G137 {
    private L145 d;
    private B360 e;
    private W144 g;
    private Gg3 h;
    private BigInteger j;
    private BigInteger q;
    private Q138[] s;

    public G137(W144 w144, L145 l145, BigInteger bigInteger, BigInteger bigInteger2) {
        this.g = w144;
        this.d = l145;
        this.q = bigInteger;
        this.j = bigInteger2;
        if (!W144.q(this.g)) {
            this.e = this.g.g(255, 255, (byte)0, true);
        }
    }

    public boolean g() {
        byte[] arrby;
        byte[] arrby2;
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
        Gg3 gg3 = new Gg3(this.e.g());
        gg3.v = 5;
        int n = Gg3.ar(gg3);
        gg3.v += n * 72;
        byte[] arrby3 = new byte[gg3.r.length - gg3.v];
        Gg3.bx(gg3, arrby3, 0, arrby3.length);
        if (this.q == null || this.j == null) {
            arrby2 = arrby3;
        } else {
            arrby = new BigInteger(arrby3);
            BigInteger bigInteger = arrby.modPow(this.q, this.j);
            arrby2 = bigInteger.toByteArray();
        }
        if (arrby2.length != 65) {
            throw new RuntimeException("Incorrect Whirlpool length - got: " + arrby2.length + " bytes");
        }
        arrby = Iw364.e(gg3.r, 5, gg3.v - arrby3.length - 5);
        for (int i = 0; i < 64; ++i) {
            if (arrby[i] == arrby2[i + 1]) continue;
            throw new RuntimeException("Masterindex Whirlpool from server does not match my calculation - expected:" + js5.av(arrby2) + " got:" + js5.av(arrby));
        }
        this.s = new Q138[n];
        this.h = gg3;
        return true;
    }

    public static Q138 d(G137 g137, int n, Hl134 hl134, Hl134 hl1342) {
        return g137.q(n, hl134, hl1342, true);
    }

    public Q138 q(int n, Hl134 hl134, Hl134 hl1342, boolean bl) {
        Q138 q138;
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
        int n2 = Gg3.bd(this.h);
        int n3 = Gg3.bd(this.h);
        byte[] arrby = new byte[64];
        Gg3.bx(this.h, arrby, 0, 64);
        if (n2 == 0) {
            System.out.println("Warning: indexcrc==0 - likely invalid archiveid requested - archiveid:" + n);
        }
        this.s[n] = q138 = new Q138(n, hl134, hl1342, this.g, this.d, n2, arrby, n3, bl);
        return q138;
    }

    public static void j(G137 g137) {
        if (g137.s == null) {
            return;
        }
        Lb33.g(Lb33.Js5Archive);
        try {
            int n;
            for (n = 0; n < g137.s.length; ++n) {
                if (g137.s[n] == null) continue;
                Q138.e(g137.s[n]);
            }
            for (n = 0; n < g137.s.length; ++n) {
                if (g137.s[n] == null) continue;
                g137.s[n].h();
            }
            Lb33.d(Lb33.Js5Archive);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.Js5Archive);
            throw throwable;
        }
    }

    public G137(W144 w144, L145 l145) {
        this(w144, l145, null, null);
    }
}

