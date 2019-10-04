/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.List;
import rs2.client.client;
import tfu.Gs329;
import tfu.Lu496;

public class Lk495 {
    private static Lk495 j;
    private List d;
    private boolean e;
    private List g = new ArrayList();
    private List q;

    public static void q(Lk495 lk495) {
        if (Lk495.h(lk495)) {
            for (Lu496 lu496 : lk495.g) {
                Lu496.d(lu496);
            }
            for (Lu496 lu496 : lk495.q) {
                Lu496.d(lu496);
            }
        }
    }

    public static Lk495 g() {
        if (j == null) {
            j = new Lk495();
        }
        return j;
    }

    private Lk495() {
        this.d = new ArrayList();
        this.q = new ArrayList();
    }

    public void e(Gs329 gs329) {
        this.g.clear();
        int n = Gs329.au(gs329);
        for (int i = 0; i < n; ++i) {
            int n2 = Gs329.au(gs329);
            Lu496 lu496 = new Lu496();
            this.g.add(lu496);
            for (int j = 0; j < n2; ++j) {
                int n3 = Gs329.bd(gs329) - client.gn;
                int n4 = Gs329.bd(gs329) - client.gj;
                float f = Gs329.bl(gs329);
                Vector3 vector3 = new Vector3(n3, f, n4);
                Lu496.g(lu496).add(vector3);
            }
        }
    }

    public static void d(int n, int n2) {
        Lu496.b(n, n2);
    }

    public void j(Gs329 gs329) {
        this.q.clear();
        Lu496 lu496 = new Lu496();
        Lu496.s(lu496, false);
        Lu496.e(lu496, -16776961);
        this.q.add(lu496);
        int n = Gs329.au(gs329);
        for (int i = 0; i < n; ++i) {
            int n2 = Gs329.bd(gs329) - client.gn;
            int n3 = Gs329.bd(gs329) - client.gj;
            float f = Gs329.bl(gs329);
            Vector3 vector3 = new Vector3(n2, f, n3);
            Lu496.g(lu496).add(vector3);
        }
    }

    public static boolean h(Lk495 lk495) {
        return lk495.e;
    }
}

