/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Cj551;
import tfu.Cl639;
import tfu.Gg3;

public class Co638 {
    static final int g = 22050;
    private Cl639[] d = new Cl639[10];
    private int j;
    private int q;

    public static Co638 g(js5 js52, int n, int n2) {
        byte[] arrby = js52.getfile(n, n2);
        if (arrby == null) {
            return null;
        }
        return new Co638(new Gg3(arrby));
    }

    private static final byte[] q(Co638 co638) {
        int n;
        int n2 = 0;
        for (n = 0; n < 10; ++n) {
            if (co638.d[n] == null || !co638.d[n].g || co638.d[n].z + co638.d[n].t <= n2) continue;
            n2 = co638.d[n].z + co638.d[n].t;
        }
        if (n2 == 0) {
            return new byte[0];
        }
        n = 22050 * n2 / 1000;
        byte[] arrby = new byte[n];
        for (int i = 0; i < 10; ++i) {
            if (co638.d[i] == null || !co638.d[i].g) continue;
            int n3 = co638.d[i].z * 22050 / 1000;
            int n4 = co638.d[i].t * 22050 / 1000;
            int[] arrn = Cl639.g(co638.d[i], n3, co638.d[i].z);
            for (int j = 0; j < n3; ++j) {
                int n5 = arrby[j + n4] + (arrn[j] >> 8);
                if ((n5 + 128 & 0xFFFFFF00) != 0) {
                    n5 = n5 >> 31 ^ 0x7F;
                }
                arrby[j + n4] = (byte)n5;
            }
        }
        return arrby;
    }

    private Co638() {
    }

    public Cj551 d() {
        byte[] arrby = Co638.q(this);
        return new Cj551(22050, arrby, 22050 * this.q / 1000, 22050 * this.j / 1000);
    }

    public Co638(Gg3 gg3) {
        for (int i = 0; i < 10; ++i) {
            int n = Gg3.ar(gg3);
            if (n == 0) continue;
            --gg3.v;
            this.d[i] = new Cl639();
            this.d[i].q(gg3);
        }
        this.q = Gg3.au(gg3);
        this.j = Gg3.au(gg3);
    }
}

