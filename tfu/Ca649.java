/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Cg550;
import tfu.Ci646;
import tfu.Cj551;
import tfu.Co638;
import tfu.Ha262;

public class Ca649 {
    private static final boolean g = true;
    private js5 d;
    private Ha262 e;
    private Ha262 h;
    private Ha262 j = new Ha262(256);
    private js5 q;

    public static Cj551 g(Ca649 ca649, int n, int n2, int[] arrn) {
        int n3 = n2 ^ (n << 4 & 0xFFFF | n >>> 12);
        long l = n3 |= n << 16;
        Cj551 cj551 = (Cj551)Ha262.d(ca649.h, l);
        if (cj551 != null) {
            return cj551;
        }
        if (arrn != null && arrn[0] <= 0) {
            return null;
        }
        Co638 co638 = Co638.g(ca649.d, n, n2);
        if (co638 == null) {
            return null;
        }
        cj551 = co638.d();
        Ha262.q(ca649.h, cj551, l);
        if (arrn != null) {
            int[] arrn2 = arrn;
            arrn2[0] = arrn2[0] - cj551.e.length;
        }
        return cj551;
    }

    public Ca649(js5 js52, js5 js53) {
        this.e = new Ha262(256);
        this.h = new Ha262(256);
        this.d = js52;
        this.q = js53;
    }

    public Cj551 q(int n, int[] arrn) {
        if (js5.t(this.d) == 1) {
            return Ca649.g(this, 0, n, arrn);
        }
        if (js5.z(this.d, n) == 1) {
            return Ca649.g(this, n, 0, arrn);
        }
        throw new RuntimeException("Unable to determine if id is groupid or fileid");
    }

    public Ci646 j(int n, int[] arrn) {
        if (js5.t(this.q) == 1) {
            return Ca649.d(this, 0, n, arrn);
        }
        if (js5.z(this.q, n) == 1) {
            return Ca649.d(this, n, 0, arrn);
        }
        throw new RuntimeException("Unable to determine if id is groupid or fileid");
    }

    public static Ci646 d(Ca649 ca649, int n, int n2, int[] arrn) {
        int n3 = n2 ^ (n << 4 & 0xFFFF | n >>> 12);
        long l = (long)(n3 |= n << 16) ^ 0x100000000L;
        Ci646 ci646 = (Ci646)Ha262.d(ca649.e, l);
        if (ci646 != null) {
            return ci646;
        }
        if (arrn != null && arrn[0] <= 0) {
            return null;
        }
        Cg550 cg550 = (Cg550)Ha262.d(ca649.j, l);
        if (cg550 == null) {
            cg550 = Cg550.b(ca649.q, n, n2);
            if (cg550 == null) {
                return null;
            }
            Ha262.q(ca649.j, cg550, l);
        }
        if ((ci646 = cg550.l()) == null) {
            return null;
        }
        Cg550.ef(cg550);
        Ha262.q(ca649.e, ci646, l);
        return ci646;
    }
}

