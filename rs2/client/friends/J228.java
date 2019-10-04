/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.friends;

import com.jagex.core.constants.Language;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import rs2.client.chat.G232;
import rs2.client.client;
import rs2.client.friends.G229;
import rs2.client.friends.Q210;
import tfu.Gd27;
import tfu.Gz143;
import tfu.Jz233;
import tfu.Le231;
import tfu.Ly234;
import tfu.Md230;
import tfu.Mk163;

public final class J228 {
    private final Q210[] d;
    public int g = 0;
    private final List j;
    private final Map q;

    public static Q210 q(J228 j228, int n) {
        if (n < 0 || n >= j228.g) {
            return null;
        }
        return j228.d[n];
    }

    public void j(boolean bl, String string, String string2, int n, String string3, boolean bl2, boolean bl3) {
        if (bl) {
            Q210 q210 = (Q210)this.q.get(string2);
            if (q210 != null) {
                q210.g = string;
                q210.d = string2;
                this.q.put(string, q210);
            }
            return;
        }
        Q210 q210 = (Q210)this.q.get(string);
        if (q210 != null) {
            if (q210.q != n) {
                boolean bl4 = true;
                Iterator iterator = this.j.iterator();
                while (iterator.hasNext()) {
                    G229 g229 = (G229)iterator.next();
                    if (!g229.d.equals(string)) continue;
                    if (n != 0 && g229.q == 0) {
                        iterator.remove();
                        bl4 = false;
                        continue;
                    }
                    if (n != 0 || g229.q == 0) continue;
                    iterator.remove();
                    bl4 = false;
                }
                if (bl4) {
                    this.j.add(new G229(string, n));
                }
                q210.q = n;
            }
            q210.d = string2;
            q210.j = string3;
            q210.e = bl2;
            q210.h = bl3;
            return;
        }
        if (this.g < this.d.length) {
            Q210 q2102 = new Q210();
            q2102.g = string;
            q2102.q = n;
            q2102.j = string3;
            q2102.e = bl2;
            q2102.h = bl3;
            this.d[this.g++] = q2102;
            this.q.put(q2102.g, q2102);
        }
    }

    public static boolean e(J228 j228) {
        return j228.g >= j228.d.length;
    }

    public static boolean h(J228 j228, String string) {
        if (string == null) {
            return false;
        }
        String string2 = Md230.j(string);
        if (string2 == null) {
            return false;
        }
        for (int i = 0; i < j228.g; ++i) {
            Q210 q210 = j228.d[i];
            if (!Le231.g(string, string2, q210.g, Md230.j(q210.g))) continue;
            j228.q.remove(q210.g);
            if (j228.g < j228.d.length) {
                System.arraycopy(j228.d, i + 1, j228.d, i, j228.g - i);
            }
            --j228.g;
            j228.d[j228.g] = null;
            return true;
        }
        return false;
    }

    public static void s(J228 j228) {
        j228.g = 0;
        j228.q.clear();
    }

    public void b() {
        Iterator iterator = this.j.iterator();
        while (iterator.hasNext()) {
            G229 g229 = (G229)iterator.next();
            if ((long)g229.g >= Gz143.g() / 1000L - 5L) continue;
            if (g229.q > 0) {
                G232.q(5, 0, "", "", "", g229.d + Mk163.g(Mk163.FRIENDLOGIN, client.n));
            }
            if (g229.q == 0) {
                G232.q(5, 0, "", "", "", g229.d + Mk163.g(Mk163.FRIENDLOGOUT, client.n));
            }
            iterator.remove();
        }
    }

    public J228(int n) {
        this.d = new Q210[n];
        this.q = new HashMap(Jz233.j(n));
        this.j = new LinkedList();
    }

    public static int g(J228 j228, String string) {
        if (string != null) {
            for (int i = 0; i < j228.g; ++i) {
                if (!j228.d[i].g.equalsIgnoreCase(string)) continue;
                return i;
            }
        }
        return -1;
    }

    public static Q210 d(J228 j228, String string, boolean bl) {
        String string2 = Md230.e(string, client.m.l);
        for (int i = 0; i < j228.g; ++i) {
            if (Le231.g(string, string2, j228.d[i].g, Md230.e(j228.d[i].g, client.m.l))) {
                return j228.d[i];
            }
            if (!bl || j228.d[i].d == null || !Le231.g(string, string2, j228.d[i].d, Md230.e(j228.d[i].d, client.m.l))) continue;
            return j228.d[i];
        }
        return null;
    }
}

