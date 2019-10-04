/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import tfu.Jm443;

public class Lx337 {
    public String d;
    private boolean e = true;
    public int g;
    private boolean h = false;
    public int j = 443;
    public int q = 43594;

    public Socket g() throws IOException {
        if (!this.h) {
            return new Socket(InetAddress.getByName(this.d), this.e ? this.j : this.q);
        }
        return Jm443.s(this.d, this.e ? this.j : this.q).g();
    }

    public static int d(Lx337 lx337) {
        if (lx337.e) {
            return lx337.j;
        }
        return lx337.q;
    }

    public static void q(Lx337 lx337) {
        if (!lx337.e) {
            lx337.e = true;
            lx337.h = true;
        } else if (lx337.h) {
            lx337.h = false;
        } else {
            lx337.e = false;
        }
    }
}

