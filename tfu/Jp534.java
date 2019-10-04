/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Gg3;
import tfu.Jh522;

public class Jp534 {
    private byte[] d;
    public Jh522 g;

    public void g(Gg3 gg3, int n) {
        int n2 = gg3.v + n;
        int n3 = Gg3.ar(gg3);
        int n4 = Gg3.ar(gg3);
        int n5 = Gg3.bd(gg3);
        int n6 = Gg3.bd(gg3);
        int n7 = n2 - gg3.v;
        if (n5 == 0) {
            this.d = new byte[n6];
        }
        Gg3.bx(gg3, this.d, n5, n7);
        if ((n5 += n7) == n6) {
            if (this.g == null) {
                this.g = new Jh522(n3);
            }
            Jh522.d(this.g, n4, this.d);
            this.d = null;
        }
    }
}

