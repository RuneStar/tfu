// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.friends;

import rs2.client.client;
import tfu.Le231;
import tfu.Md230;

public final class D236
{
    private final E235[] d;
    public int g;
    
    public static E235 d(final D236 d236, final int n) {
        if (n < 0 || n >= d236.g) {
            return null;
        }
        return d236.d[n];
    }
    
    public static boolean q(final D236 d236) {
        return d236.g >= d236.d.length;
    }
    
    public D236(final int n) {
        this.g = 0;
        this.d = new E235[n];
    }
    
    public void g(final boolean b, final String s, final String s2, final String s3, final String j, final boolean e) {
        if (b) {
            int i = 0;
            while (i < this.g) {
                if (this.d[i].d.equals(j)) {
                    this.d[i].g = s;
                    if (s2 == "") {
                        this.d[i].d = s;
                    }
                    else {
                        this.d[i].d = s2;
                    }
                    this.d[i].q = s3;
                    if (j == "") {
                        this.d[i].j = s3;
                        break;
                    }
                    this.d[i].j = j;
                    break;
                }
                else {
                    ++i;
                }
            }
            return;
        }
        final E235 e2 = new E235();
        e2.g = s;
        if (s2 == "") {
            e2.d = s;
        }
        else {
            e2.d = s2;
        }
        e2.q = s3;
        if (j == "") {
            e2.j = s3;
        }
        else {
            e2.j = j;
        }
        e2.e = e;
        this.d[this.g++] = e2;
    }
    
    public static boolean h(final D236 d236, final String s) {
        if (s == null) {
            return false;
        }
        final String j = Md230.j(s);
        if (j == null) {
            return false;
        }
        for (int i = 0; i < d236.g; ++i) {
            final E235 e235 = d236.d[i];
            if (Le231.g(s, j, e235.g, Md230.j(e235.g))) {
                if (d236.g < d236.d.length) {
                    System.arraycopy(d236.d, i + 1, d236.d, i, d236.g - i);
                }
                --d236.g;
                d236.d[d236.g] = null;
                return true;
            }
        }
        return false;
    }
    
    public static void s(final D236 d236) {
        d236.g = 0;
    }
    
    public static E235 j(final D236 d236, final String s, final boolean b) {
        final String e = Md230.e(s, client.m.l);
        for (int i = 0; i < d236.g; ++i) {
            if (Le231.g(s, e, d236.d[i].d, Md230.e(d236.d[i].d, client.m.l))) {
                return d236.d[i];
            }
            if (b && d236.d[i].j != null && Le231.g(s, e, d236.d[i].j, Md230.e(d236.d[i].j, client.m.l))) {
                return d236.d[i];
            }
        }
        return null;
    }
    
    public static int e(final D236 d236, final String s) {
        if (s != null) {
            for (int i = 0; i < d236.g; ++i) {
                if (s.equalsIgnoreCase(d236.d[i].d)) {
                    return i;
                }
                if (s.equalsIgnoreCase(d236.d[i].j)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
