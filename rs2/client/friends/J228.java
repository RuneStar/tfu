// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.friends;

import java.util.LinkedList;
import java.util.HashMap;
import tfu.Jz233;
import rs2.client.chat.G232;
import rs2.client.client;
import tfu.Mk163;
import tfu.Gz143;
import tfu.Le231;
import tfu.Md230;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public final class J228
{
    private final Q210[] d;
    public int g;
    private final List j;
    private final Map q;
    
    public static Q210 q(final J228 j228, final int n) {
        if (n < 0 || n >= j228.g) {
            return null;
        }
        return j228.d[n];
    }
    
    public void j(final boolean b, final String g, final String s, final int n, final String s2, final boolean b2, final boolean b3) {
        if (b) {
            final Q210 q210 = this.q.get(s);
            if (q210 != null) {
                q210.g = g;
                q210.d = s;
                this.q.put(g, q210);
            }
            return;
        }
        final Q210 q211 = this.q.get(g);
        if (q211 != null) {
            if (q211.q != n) {
                boolean b4 = true;
                final Iterator<G229> iterator = (Iterator<G229>)this.j.iterator();
                while (iterator.hasNext()) {
                    final G229 g2 = iterator.next();
                    if (g2.d.equals(g)) {
                        if (n != 0 && g2.q == 0) {
                            iterator.remove();
                            b4 = false;
                        }
                        else {
                            if (n != 0 || g2.q == 0) {
                                continue;
                            }
                            iterator.remove();
                            b4 = false;
                        }
                    }
                }
                if (b4) {
                    this.j.add(new G229(g, n));
                }
                q211.q = n;
            }
            q211.d = s;
            q211.j = s2;
            q211.e = b2;
            q211.h = b3;
            return;
        }
        if (this.g < this.d.length) {
            final Q210 q212 = new Q210();
            q212.g = g;
            q212.q = n;
            q212.j = s2;
            q212.e = b2;
            q212.h = b3;
            this.d[this.g++] = q212;
            this.q.put(q212.g, q212);
        }
    }
    
    public static boolean e(final J228 j228) {
        return j228.g >= j228.d.length;
    }
    
    public static boolean h(final J228 j228, final String s) {
        if (s == null) {
            return false;
        }
        final String i = Md230.j(s);
        if (i == null) {
            return false;
        }
        for (int k = 0; k < j228.g; ++k) {
            final Q210 q210 = j228.d[k];
            if (Le231.g(s, i, q210.g, Md230.j(q210.g))) {
                j228.q.remove(q210.g);
                if (j228.g < j228.d.length) {
                    System.arraycopy(j228.d, k + 1, j228.d, k, j228.g - k);
                }
                --j228.g;
                j228.d[j228.g] = null;
                return true;
            }
        }
        return false;
    }
    
    public static void s(final J228 j228) {
        j228.g = 0;
        j228.q.clear();
    }
    
    public void b() {
        final Iterator<G229> iterator = (Iterator<G229>)this.j.iterator();
        while (iterator.hasNext()) {
            final G229 g229 = iterator.next();
            if (g229.g < Gz143.g() / 1000L - 5L) {
                if (g229.q > 0) {
                    G232.q(5, 0, "", "", "", g229.d + Mk163.g(Mk163.FRIENDLOGIN, client.n));
                }
                if (g229.q == 0) {
                    G232.q(5, 0, "", "", "", g229.d + Mk163.g(Mk163.FRIENDLOGOUT, client.n));
                }
                iterator.remove();
            }
        }
    }
    
    public J228(final int n) {
        this.g = 0;
        this.d = new Q210[n];
        this.q = new HashMap(Jz233.j(n));
        this.j = new LinkedList();
    }
    
    public static int g(final J228 j228, final String anotherString) {
        if (anotherString != null) {
            for (int i = 0; i < j228.g; ++i) {
                if (j228.d[i].g.equalsIgnoreCase(anotherString)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static Q210 d(final J228 j228, final String s, final boolean b) {
        final String e = Md230.e(s, client.m.l);
        for (int i = 0; i < j228.g; ++i) {
            if (Le231.g(s, e, j228.d[i].g, Md230.e(j228.d[i].g, client.m.l))) {
                return j228.d[i];
            }
            if (b && j228.d[i].d != null && Le231.g(s, e, j228.d[i].d, Md230.e(j228.d[i].d, client.m.l))) {
                return j228.d[i];
            }
        }
        return null;
    }
}
