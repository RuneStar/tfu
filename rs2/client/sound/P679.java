// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import fmod.Q244;
import fmod.E245;
import fmod.X243;
import java.util.ArrayList;

class P679
{
    private int b;
    private ArrayList d;
    private float e;
    private String g;
    private float h;
    private X243 j;
    private int l;
    H591 p;
    private float q;
    private int r;
    private int s;
    public int u;
    private String v;
    private int w;
    private String x;
    private int y;
    public float z;
    final /* synthetic */ H591 t;
    
    public static void g(final P679 p) {
        if (p.j != null && X243.h(p.j)) {
            X243.f(p.j);
        }
    }
    
    public P679(final H591 t, final int y, final String g, final H591 p8, final int s, final int b, final int l, final int w) {
        this.t = t;
        this.d = new ArrayList();
        this.h = 1.0f;
        this.r = 0;
        this.x = "";
        this.z = 0.0f;
        this.y = y;
        this.s = s;
        this.b = b;
        this.l = l;
        this.w = w;
        this.p = p8;
        this.e = (float)Math.pow(2.0, 8.333333535119891E-4);
        this.g = g;
    }
    
    public static void q(final P679 p4, float n, final float n2, final float n3) {
        n = Math.max(n, (float)p4.s);
        n = Math.min(n, (float)p4.b);
        final float n4 = (n - p4.s) / (p4.b - p4.s);
        final float n5 = (p4.l + (p4.w - p4.l) * n4) * p4.h;
        if (p4.j != null && X243.h(p4.j)) {
            X243.k(p4.j, (n5 + p4.q) / 100.0f, 2);
        }
        float n6 = n4;
        float n7 = 0.0f;
        final int size = p4.d.size();
        if (n6 > ((R676)p4.d.get(size - 1)).g) {
            n6 = ((R676)p4.d.get(size - 1)).g;
        }
        if (n6 < p4.d.get(0).g) {
            n6 = p4.d.get(0).g;
        }
        for (int i = 0; i < size - 1; ++i) {
            final R676 r676 = p4.d.get(i);
            final R676 r677 = p4.d.get(i + 1);
            if (n6 >= r676.g && n6 <= r677.g) {
                n7 = r676.d + (r677.d - r676.d) * ((n6 - r676.g) / (r677.g - r676.g));
                break;
            }
        }
        float n8;
        if (p4.r == 0) {
            n8 = n2;
        }
        else {
            n8 = n3;
        }
        final float n9 = n8 * n7 * p4.p.ai;
        if (p4.j == null && n9 > 0.01f) {
            p4.j = E245.v(SoundManager.c, p4.x);
            if (X243.h(p4.j)) {
                X243.u(p4.j, p4.t.av);
                p4.j.a();
            }
            else {
                p4.j = null;
            }
        }
        if (p4.j != null && n9 == 0.0f) {
            X243.c(p4.j);
            p4.j = null;
        }
        if (p4.j != null) {
            X243.i(p4.j, Math.min(1.0f, Math.abs(n9)));
        }
        p4.z = 0.0f;
        if (p4.j != null && X243.y(p4.j)) {
            final H591 t = p4.t;
            ++t.d;
            p4.z = n9;
        }
    }
    
    public int j(final String[] array, int n) {
        ++n;
        this.q = Float.parseFloat(array[n++]);
        this.r = 0;
        final String s = array[n++];
        if (s.equals("L")) {
            this.r = 0;
        }
        else if (s.equals("U")) {
            this.r = 1;
        }
        this.v = array[n++];
        this.h = Float.parseFloat(array[n++]);
        final int int1 = Integer.parseInt(array[n++]);
        float n2 = -12345.0f;
        for (int i = 0; i < int1; ++i) {
            final String[] split = array[n++].split("\\|");
            final float min = Math.min(Float.parseFloat(split[0]), 1.0f);
            if (min != n2) {
                n2 = min;
                this.d.add(new R676(this.t, min, Float.parseFloat(split[1])));
            }
        }
        this.x = "VEHICLES/A" + this.y + "/" + this.g;
        this.j = null;
        return n;
    }
    
    public static void d(final P679 p2, final Q244 q244) {
        if (p2.j != null && X243.h(p2.j)) {
            X243.u(p2.j, q244);
        }
    }
}
