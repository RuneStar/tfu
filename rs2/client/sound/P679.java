/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import fmod.E245;
import fmod.Q244;
import fmod.X243;
import java.util.ArrayList;
import rs2.client.sound.H591;
import rs2.client.sound.R676;
import rs2.client.sound.SoundManager;

class P679 {
    private int b;
    private ArrayList d = new ArrayList();
    private float e;
    private String g;
    private float h = 1.0f;
    private X243 j;
    private int l;
    H591 p;
    private float q;
    private int r = 0;
    private int s;
    public int u;
    private String v;
    private int w;
    private String x = "";
    private int y;
    public float z = 0.0f;
    final /* synthetic */ H591 t;

    public static void g(P679 p679) {
        if (p679.j != null && X243.h(p679.j)) {
            X243.f(p679.j);
        }
    }

    public P679(H591 h591, int n, String string, H591 h5912, int n2, int n3, int n4, int n5) {
        this.t = h591;
        this.y = n;
        this.s = n2;
        this.b = n3;
        this.l = n4;
        this.w = n5;
        this.p = h5912;
        this.e = (float)Math.pow(2.0, 8.333333535119891E-4);
        this.g = string;
    }

    public static void q(P679 p679, float f, float f2, float f3) {
        f = Math.max(f, (float)p679.s);
        f = Math.min(f, (float)p679.b);
        float f4 = (f - (float)p679.s) / (float)(p679.b - p679.s);
        float f5 = (float)p679.l + (float)(p679.w - p679.l) * f4;
        f5 *= p679.h;
        if (p679.j != null && X243.h(p679.j)) {
            X243.k(p679.j, (f5 + p679.q) / 100.0f, 2);
        }
        float f6 = f4;
        float f7 = 0.0f;
        int n = p679.d.size();
        if (f6 > ((R676)p679.d.get((int)(n - 1))).g) {
            f6 = ((R676)p679.d.get((int)(n - 1))).g;
        }
        if (f6 < ((R676)p679.d.get((int)0)).g) {
            f6 = ((R676)p679.d.get((int)0)).g;
        }
        for (int i = 0; i < n - 1; ++i) {
            R676 r676 = (R676)p679.d.get(i);
            R676 r6762 = (R676)p679.d.get(i + 1);
            if (!(f6 >= r676.g) || !(f6 <= r6762.g)) continue;
            f4 = (f6 - r676.g) / (r6762.g - r676.g);
            f7 = r676.d + (r6762.d - r676.d) * f4;
            break;
        }
        float f8 = p679.r == 0 ? f2 : f3;
        float f9 = f8 * f7;
        f9 *= p679.p.ai;
        if (p679.j == null && f9 > 0.01f) {
            p679.j = E245.v(SoundManager.c, p679.x);
            if (X243.h(p679.j)) {
                X243.u(p679.j, p679.t.av);
                p679.j.a();
            } else {
                p679.j = null;
            }
        }
        if (p679.j != null && f9 == 0.0f) {
            X243.c(p679.j);
            p679.j = null;
        }
        if (p679.j != null) {
            X243.i(p679.j, Math.min(1.0f, Math.abs(f9)));
        }
        p679.z = 0.0f;
        if (p679.j != null && X243.y(p679.j)) {
            ++p679.t.d;
            p679.z = f9;
        }
    }

    public int j(String[] arrstring, int n) {
        int n2 = ++n;
        this.q = Float.parseFloat(arrstring[n2]);
        this.r = 0;
        int n3 = ++n;
        ++n;
        String string = arrstring[n3];
        if (string.equals("L")) {
            this.r = 0;
        } else if (string.equals("U")) {
            this.r = 1;
        }
        this.v = arrstring[n++];
        this.h = Float.parseFloat(arrstring[n++]);
        int n4 = Integer.parseInt(arrstring[n++]);
        float f = -12345.0f;
        for (int i = 0; i < n4; ++i) {
            float f2;
            String[] arrstring2;
            if ((f2 = Math.min(Float.parseFloat((arrstring2 = arrstring[n++].split("\\|"))[0]), 1.0f)) == f) continue;
            f = f2;
            this.d.add(new R676(this.t, f2, Float.parseFloat(arrstring2[1])));
        }
        this.x = "VEHICLES/A" + this.y + "/" + this.g;
        this.j = null;
        return n;
    }

    public static void d(P679 p679, Q244 q244) {
        if (p679.j != null && X243.h(p679.j)) {
            X243.u(p679.j, q244);
        }
    }
}

