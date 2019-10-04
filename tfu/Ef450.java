// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.stringtools.general.Q280;

public class Ef450
{
    public static final byte aa = 3;
    public static final int ab = 100;
    public static final byte ac = -1;
    public static final byte af = 126;
    public static final byte ah = 6;
    public static final byte al = Byte.MAX_VALUE;
    public static final byte am = 1;
    public static final byte an = 2;
    public static final byte ao = 4;
    public static final byte ap = 5;
    public static final byte as = 0;
    public static final int at = 500;
    public static final byte av = 125;
    public static final byte az = 100;
    public static final boolean d = false;
    public static boolean g;
    static final int q = 6;
    public int a;
    public String[] ag;
    public Ha262 ai;
    public String[] aq;
    public String b;
    public long[] c;
    boolean e;
    public int f;
    public long h;
    public boolean[] i;
    boolean j;
    public int[] k;
    public int l;
    private int[] m;
    public int[] n;
    public int o;
    public byte p;
    public boolean r;
    public int s;
    public byte[] t;
    public int u;
    public byte v;
    public int w;
    public byte x;
    public byte y;
    public long[] z;
    
    public Ef450(final String b, final long n) {
        this.s = 0;
        this.b = null;
        this.l = 0;
        this.w = 0;
        this.o = -1;
        this.a = -1;
        this.j = true;
        this.b = b;
        this.q(n, null, Gk481.q());
        this.l = (int)(System.currentTimeMillis() / 60000L);
    }
    
    private Ef450() {
        this.s = 0;
        this.b = null;
        this.l = 0;
        this.w = 0;
        this.o = -1;
        this.a = -1;
    }
    
    private static void g(final Ef450 ef450, final int n) {
        if (ef450.j) {
            if (ef450.z != null) {
                System.arraycopy(ef450.z, 0, ef450.z = new long[n], 0, ef450.u);
            }
            else {
                ef450.z = new long[n];
            }
        }
        if (ef450.e) {
            if (ef450.ag != null) {
                System.arraycopy(ef450.ag, 0, ef450.ag = new String[n], 0, ef450.u);
            }
            else {
                ef450.ag = new String[n];
            }
        }
        if (ef450.t != null) {
            System.arraycopy(ef450.t, 0, ef450.t = new byte[n], 0, ef450.u);
        }
        else {
            ef450.t = new byte[n];
        }
        if (ef450.n != null) {
            System.arraycopy(ef450.n, 0, ef450.n = new int[n], 0, ef450.u);
        }
        else {
            ef450.n = new int[n];
        }
        if (ef450.k != null) {
            System.arraycopy(ef450.k, 0, ef450.k = new int[n], 0, ef450.u);
        }
        else {
            ef450.k = new int[n];
        }
        if (ef450.i != null) {
            System.arraycopy(ef450.i, 0, ef450.i = new boolean[n], 0, ef450.u);
        }
        else {
            ef450.i = new boolean[n];
        }
    }
    
    static int l(final Ef450 ef450, final int n, final boolean b) {
        if (ef450.i[n] == b) {
            return -1;
        }
        ef450.i[n] = b;
        return n;
    }
    
    public void j(final int i) {
        if (i < 0 || i >= this.u) {
            throw new RuntimeException("Invalid pos in doDeleteMember - pos:" + i + " memberCount:" + this.u);
        }
        --this.u;
        this.m = null;
        if (this.u == 0) {
            this.z = null;
            this.ag = null;
            this.t = null;
            this.n = null;
            this.k = null;
            this.i = null;
            this.o = -1;
            this.a = -1;
        }
        else {
            System.arraycopy(this.t, i + 1, this.t, i, this.u - i);
            System.arraycopy(this.n, i + 1, this.n, i, this.u - i);
            System.arraycopy(this.k, i + 1, this.k, i, this.u - i);
            System.arraycopy(this.i, i + 1, this.i, i, this.u - i);
            if (this.z != null) {
                System.arraycopy(this.z, i + 1, this.z, i, this.u - i);
            }
            if (this.ag != null) {
                System.arraycopy(this.ag, i + 1, this.ag, i, this.u - i);
            }
            if (i == this.o || i == this.a) {
                e(this);
            }
        }
    }
    
    public boolean r(final int n, final int g) {
        if (this.ai != null) {
            final Ln265 d = Ha262.d(this.ai, n);
            if (d != null) {
                if (d instanceof Kq264) {
                    final Kq264 kq264 = (Kq264)d;
                    if (kq264.g == g) {
                        return false;
                    }
                    kq264.g = g;
                    return true;
                }
                else {
                    Ln265.ef(d);
                }
            }
        }
        else {
            this.ai = new Ha262(4);
        }
        Ha262.q(this.ai, new Kq264(g), n);
        return true;
    }
    
    void h(final long lng, String str) {
        if (str != null && str.length() == 0) {
            str = null;
        }
        if (lng > 0L != this.j) {
            throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.j + " but userhash:" + lng);
        }
        if (str != null != this.e) {
            throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.e + " but displayname:" + str);
        }
        if ((lng > 0L && (this.c == null || this.f >= this.c.length)) || (str != null && (this.aq == null || this.f >= this.aq.length))) {
            d(this, this.f + 5);
        }
        if (this.c != null) {
            this.c[this.f] = lng;
        }
        if (this.aq != null) {
            this.aq[this.f] = str;
        }
        ++this.f;
    }
    
    public static void s(final Ef450 ef450, final int n) {
        --ef450.f;
        if (ef450.f == 0) {
            ef450.c = null;
            ef450.aq = null;
        }
        else {
            if (ef450.c != null) {
                System.arraycopy(ef450.c, n + 1, ef450.c, n, ef450.f - n);
            }
            if (ef450.aq != null) {
                System.arraycopy(ef450.aq, n + 1, ef450.aq, n, ef450.f - n);
            }
        }
    }
    
    static int b(final Ef450 ef450, final int n, final byte b) {
        if (b == 126 || b == 127) {
            return -1;
        }
        if (n == ef450.o && (ef450.a == -1 || ef450.t[ef450.a] < 125)) {
            return -1;
        }
        if (ef450.t[n] == b) {
            return -1;
        }
        ef450.t[n] = b;
        e(ef450);
        return n;
    }
    
    static int w(final Ef450 ef450, final int n, int n2, final int n3, final int n4) {
        final int n5 = ((n4 == 31) ? -1 : ((1 << n4 + 1) - 1)) ^ (1 << n3) - 1;
        n2 <<= n3;
        n2 &= n5;
        final int n6 = ef450.n[n];
        if ((n6 & n5) == n2) {
            return -1;
        }
        ef450.n[n] = ((n6 & ~n5) | n2);
        return n;
    }
    
    private static void e(final Ef450 ef450) {
        if (ef450.u == 0) {
            ef450.o = -1;
            ef450.a = -1;
            return;
        }
        ef450.o = -1;
        ef450.a = -1;
        int n = 0;
        byte b = ef450.t[0];
        for (int i = 1; i < ef450.u; ++i) {
            if (ef450.t[i] > b) {
                if (b == 125) {
                    ef450.a = n;
                }
                n = i;
                b = ef450.t[i];
            }
            else if (ef450.a == -1 && ef450.t[i] == 125) {
                ef450.a = i;
            }
        }
        ef450.o = n;
        if (ef450.o != -1) {
            ef450.t[ef450.o] = 126;
        }
    }
    
    boolean v(final int n, int n2, final int n3, final int n4) {
        final int n5 = ((n4 == 31) ? -1 : ((1 << n4 + 1) - 1)) ^ (1 << n3) - 1;
        n2 <<= n3;
        n2 &= n5;
        if (this.ai != null) {
            final Ln265 d = Ha262.d(this.ai, n);
            if (d != null) {
                if (d instanceof Kq264) {
                    final Kq264 kq264 = (Kq264)d;
                    if ((kq264.g & n5) == n2) {
                        return false;
                    }
                    final Kq264 kq265 = kq264;
                    kq265.g &= ~n5;
                    final Kq264 kq266 = kq264;
                    kq266.g |= n2;
                    return true;
                }
                else {
                    Ln265.ef(d);
                }
            }
        }
        else {
            this.ai = new Ha262(4);
        }
        Ha262.q(this.ai, new Kq264(n2), n);
        return true;
    }
    
    private static void d(final Ef450 ef450, final int n) {
        if (ef450.j) {
            if (ef450.c != null) {
                System.arraycopy(ef450.c, 0, ef450.c = new long[n], 0, ef450.f);
            }
            else {
                ef450.c = new long[n];
            }
        }
        if (ef450.e) {
            if (ef450.aq != null) {
                System.arraycopy(ef450.aq, 0, ef450.aq = new String[n], 0, ef450.f);
            }
            else {
                ef450.aq = new String[n];
            }
        }
    }
    
    boolean p(final int n, String substring) {
        if (substring == null) {
            substring = "";
        }
        else if (substring.length() > 80) {
            substring = substring.substring(0, 80);
        }
        if (this.ai != null) {
            final Ln265 d = Ha262.d(this.ai, n);
            if (d != null) {
                if (d instanceof Ld263) {
                    final Ld263 ld263 = (Ld263)d;
                    if (ld263.g instanceof String) {
                        if (substring.equals(ld263.g)) {
                            return false;
                        }
                        Ln265.ef(ld263);
                        Ha262.q(this.ai, new Ld263(substring), ld263.bq);
                        return true;
                    }
                }
                Ln265.ef(d);
            }
        }
        else {
            this.ai = new Ha262(4);
        }
        Ha262.q(this.ai, new Ld263(substring), n);
        return true;
    }
    
    public void x(final Gg3 gg3) {
        final int ar = Gg3.ar(gg3);
        if (ar < 1 || ar > 6) {
            throw new RuntimeException("Unsupported ClanSettings version: " + ar);
        }
        final int ar2 = Gg3.ar(gg3);
        if ((ar2 & 0x1) != 0x0) {
            this.j = true;
        }
        if ((ar2 & 0x2) != 0x0) {
            this.e = true;
        }
        if (!this.j) {
            this.z = null;
            this.c = null;
        }
        if (!this.e) {
            this.ag = null;
            this.aq = null;
        }
        this.s = Gg3.bd(gg3);
        this.l = Gg3.bd(gg3);
        if (ar <= 3 && this.l != 0) {
            this.l += 16912800;
        }
        this.u = Gg3.au(gg3);
        this.f = Gg3.ar(gg3);
        this.b = Gg3.bk(gg3);
        if (ar >= 4) {
            this.w = Gg3.bd(gg3);
        }
        this.r = (Gg3.ar(gg3) == 1);
        this.v = Gg3.ax(gg3);
        this.y = Gg3.ax(gg3);
        this.p = Gg3.ax(gg3);
        this.x = Gg3.ax(gg3);
        if (this.u > 0) {
            if (this.j && (this.z == null || this.z.length < this.u)) {
                this.z = new long[this.u];
            }
            if (this.e && (this.ag == null || this.ag.length < this.u)) {
                this.ag = new String[this.u];
            }
            if (this.t == null || this.t.length < this.u) {
                this.t = new byte[this.u];
            }
            if (this.n == null || this.n.length < this.u) {
                this.n = new int[this.u];
            }
            if (this.k == null || this.k.length < this.u) {
                this.k = new int[this.u];
            }
            if (this.i == null || this.i.length < this.u) {
                this.i = new boolean[this.u];
            }
            for (int i = 0; i < this.u; ++i) {
                if (this.j) {
                    this.z[i] = Gg3.bq(gg3);
                }
                if (this.e) {
                    this.ag[i] = Gg3.bj(gg3);
                }
                this.t[i] = Gg3.ax(gg3);
                if (ar >= 2) {
                    this.n[i] = Gg3.bd(gg3);
                }
                if (ar >= 5) {
                    this.k[i] = Gg3.au(gg3);
                }
                else {
                    this.k[i] = 0;
                }
                if (ar >= 6) {
                    this.i[i] = (Gg3.ar(gg3) == 1);
                }
                else {
                    this.i[i] = false;
                }
            }
            e(this);
        }
        if (this.f > 0) {
            if (this.j && (this.c == null || this.c.length < this.f)) {
                this.c = new long[this.f];
            }
            if (this.e && (this.aq == null || this.aq.length < this.f)) {
                this.aq = new String[this.f];
            }
            for (int j = 0; j < this.f; ++j) {
                if (this.j) {
                    this.c[j] = Gg3.bq(gg3);
                }
                if (this.e) {
                    this.aq[j] = Gg3.bj(gg3);
                }
            }
        }
        if (ar >= 3) {
            int au = Gg3.au(gg3);
            if (au > 0) {
                this.ai = new Ha262((au < 16) ? Jz233.j(au) : 16);
                while (au-- > 0) {
                    final int bd = Gg3.bd(gg3);
                    final int n = bd & 0x3FFFFFFF;
                    final int n2 = bd >>> 30;
                    if (n2 == 0) {
                        Ha262.q(this.ai, new Kq264(Gg3.bd(gg3)), n);
                    }
                    else if (n2 == 1) {
                        Ha262.q(this.ai, new Lo465(Gg3.bq(gg3)), n);
                    }
                    else {
                        if (n2 != 2) {
                            continue;
                        }
                        Ha262.q(this.ai, new Ld263(Gg3.bk(gg3)), n);
                    }
                }
            }
        }
    }
    
    public String u() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Clan Name: ").append(this.b).append("\ncurrentOwnerSlot: ").append(this.o).append(", replacementOwnerSlot: ").append(this.a).append("\nallowNonMembers: ").append(this.r).append(", rankTalk: ").append(this.v).append(", rankKick: ").append(this.y).append(",  rankLootShare: ").append(this.p);
        sb.append("\nMembers:");
        for (int i = 0; i < this.u; ++i) {
            sb.append("\n").append((this.z != null) ? Q280.g(this.z[i]) : "null").append(" - ").append(this.ag[i]).append(" - rank:").append(this.t[i]);
        }
        sb.append("\nBanned:");
        for (int j = 0; j < this.u; ++j) {
            sb.append("\n").append((this.z != null) ? Q280.g(this.z[j]) : "null").append(" - ").append(this.ag[j]).append(" - rank:").append(this.t[j]);
        }
        return sb.toString();
    }
    
    static {
        Ef450.g = false;
    }
    
    public Ef450(final long h, final Gg3 gg3) {
        this.s = 0;
        this.b = null;
        this.l = 0;
        this.w = 0;
        this.o = -1;
        this.a = -1;
        this.h = h;
        this.x(gg3);
    }
    
    boolean y(final int n, final long g) {
        if (this.ai != null) {
            final Ln265 d = Ha262.d(this.ai, n);
            if (d != null) {
                if (d instanceof Lo465) {
                    final Lo465 lo465 = (Lo465)d;
                    if (lo465.g == g) {
                        return false;
                    }
                    lo465.g = g;
                    return true;
                }
                else {
                    Ln265.ef(d);
                }
            }
        }
        else {
            this.ai = new Ha262(4);
        }
        Ha262.q(this.ai, new Lo465(g), n);
        return true;
    }
    
    void q(final long lng, String str, final int n) {
        if (str != null && str.length() == 0) {
            str = null;
        }
        if (lng > 0L != this.j) {
            throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.j + " but userhash:" + lng);
        }
        if (str != null != this.e) {
            throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.e + " but displayname:" + str);
        }
        if ((lng > 0L && (this.z == null || this.u >= this.z.length)) || (str != null && (this.ag == null || this.u >= this.ag.length))) {
            g(this, this.u + 5);
        }
        if (this.z != null) {
            this.z[this.u] = lng;
        }
        if (this.ag != null) {
            this.ag[this.u] = str;
        }
        if (this.o == -1) {
            this.o = this.u;
            this.t[this.u] = 126;
        }
        else {
            this.t[this.u] = 0;
        }
        this.n[this.u] = 0;
        this.k[this.u] = n;
        this.i[this.u] = false;
        ++this.u;
        this.m = null;
    }
    
    public Ef450(final Gg3 gg3) {
        this.s = 0;
        this.b = null;
        this.l = 0;
        this.w = 0;
        this.o = -1;
        this.a = -1;
        this.x(gg3);
    }
}
