/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Gg3;

public class Mh508 {
    public static byte[] g(int n, int[] arrn) {
        Gg3 gg3 = new Gg3(8);
        for (int i = 0; i < 4; ++i) {
            Gg3.i(gg3, n);
        }
        Gg3.bu(gg3, arrn);
        return gg3.r;
    }
}

