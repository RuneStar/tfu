/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.friends;

import rs2.client.client;
import rs2.client.friends.E235;
import tfu.Gd27;
import tfu.Le231;
import tfu.Ly234;
import tfu.Md230;

public final class D236 {
    private final E235[] d;
    public int g = 0;

    public static E235 d(D236 d236, int n) {
        if (n < 0 || n >= d236.g) {
            return null;
        }
        return d236.d[n];
    }

    public static boolean q(D236 d236) {
        return d236.g >= d236.d.length;
    }

    public D236(int n) {
        this.d = new E235[n];
    }

    public void g(boolean bl, String string, String string2, String string3, String string4, boolean bl2) {
        if (bl) {
            for (int i = 0; i < this.g; ++i) {
                if (!this.d[i].d.equals(string4)) continue;
                this.d[i].g = string;
                this.d[i].d = string2 == "" ? string : string2;
                this.d[i].q = string3;
                if (string4 == "") {
                    this.d[i].j = string3;
                    break;
                }
                this.d[i].j = string4;
                break;
            }
            return;
        }
        E235 e235 = new E235();
        e235.g = string;
        e235.d = string2 == "" ? string : string2;
        e235.q = string3;
        e235.j = string4 == "" ? string3 : string4;
        e235.e = bl2;
        this.d[this.g++] = e235;
    }

    public static boolean h(D236 d236, String string) {
        if (string == null) {
            return false;
        }
        String string2 = Md230.j(string);
        if (string2 == null) {
            return false;
        }
        for (int i = 0; i < d236.g; ++i) {
            E235 e235 = d236.d[i];
            if (!Le231.g(string, string2, e235.g, Md230.j(e235.g))) continue;
            if (d236.g < d236.d.length) {
                System.arraycopy(d236.d, i + 1, d236.d, i, d236.g - i);
            }
            --d236.g;
            d236.d[d236.g] = null;
            return true;
        }
        return false;
    }

    public static void s(D236 d236) {
        d236.g = 0;
    }

    public static E235 j(D236 d236, String string, boolean bl) {
        String string2 = Md230.e(string, client.m.l);
        for (int i = 0; i < d236.g; ++i) {
            if (Le231.g(string, string2, d236.d[i].d, Md230.e(d236.d[i].d, client.m.l))) {
                return d236.d[i];
            }
            if (!bl || d236.d[i].j == null || !Le231.g(string, string2, d236.d[i].j, Md230.e(d236.d[i].j, client.m.l))) continue;
            return d236.d[i];
        }
        return null;
    }

    public static int e(D236 d236, String string) {
        if (string != null) {
            for (int i = 0; i < d236.g; ++i) {
                if (string.equalsIgnoreCase(d236.d[i].d)) {
                    return i;
                }
                if (!string.equalsIgnoreCase(d236.d[i].j)) continue;
                return i;
            }
        }
        return -1;
    }
}

