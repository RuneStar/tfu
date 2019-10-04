/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.Q280;
import tfu.Gg3;
import tfu.Gk481;
import tfu.Ha262;
import tfu.Jz233;
import tfu.Kq264;
import tfu.Ld263;
import tfu.Ln265;
import tfu.Lo465;

public class Ef450 {
    public static final byte aa = 3;
    public static final int ab = 100;
    public static final byte ac = -1;
    public static final byte af = 126;
    public static final byte ah = 6;
    public static final byte al = 127;
    public static final byte am = 1;
    public static final byte an = 2;
    public static final byte ao = 4;
    public static final byte ap = 5;
    public static final byte as = 0;
    public static final int at = 500;
    public static final byte av = 125;
    public static final byte az = 100;
    public static final boolean d = false;
    public static boolean g = false;
    static final int q = 6;
    public int a = -1;
    public String[] ag;
    public Ha262 ai;
    public String[] aq;
    public String b = null;
    public long[] c;
    boolean e;
    public int f;
    public long h;
    public boolean[] i;
    boolean j;
    public int[] k;
    public int l = 0;
    private int[] m;
    public int[] n;
    public int o = -1;
    public byte p;
    public boolean r;
    public int s = 0;
    public byte[] t;
    public int u;
    public byte v;
    public int w = 0;
    public byte x;
    public byte y;
    public long[] z;

    public Ef450(String string, long l) {
        this.j = true;
        this.b = string;
        this.q(l, null, Gk481.q());
        this.l = (int)(System.currentTimeMillis() / 60000L);
    }

    private Ef450() {
    }

    private static void g(Ef450 ef450, int n) {
        if (ef450.j) {
            if (ef450.z != null) {
                ef450.z = new long[n];
                System.arraycopy(ef450.z, 0, ef450.z, 0, ef450.u);
            } else {
                ef450.z = new long[n];
            }
        }
        if (ef450.e) {
            if (ef450.ag != null) {
                ef450.ag = new String[n];
                System.arraycopy(ef450.ag, 0, ef450.ag, 0, ef450.u);
            } else {
                ef450.ag = new String[n];
            }
        }
        if (ef450.t != null) {
            ef450.t = new byte[n];
            System.arraycopy(ef450.t, 0, ef450.t, 0, ef450.u);
        } else {
            ef450.t = new byte[n];
        }
        if (ef450.n != null) {
            ef450.n = new int[n];
            System.arraycopy(ef450.n, 0, ef450.n, 0, ef450.u);
        } else {
            ef450.n = new int[n];
        }
        if (ef450.k != null) {
            ef450.k = new int[n];
            System.arraycopy(ef450.k, 0, ef450.k, 0, ef450.u);
        } else {
            ef450.k = new int[n];
        }
        if (ef450.i != null) {
            ef450.i = new boolean[n];
            System.arraycopy(ef450.i, 0, ef450.i, 0, ef450.u);
        } else {
            ef450.i = new boolean[n];
        }
    }

    static int l(Ef450 ef450, int n, boolean bl) {
        if (ef450.i[n] == bl) {
            return -1;
        }
        ef450.i[n] = bl;
        return n;
    }

    public void j(int n) {
        if (n < 0 || n >= this.u) {
            throw new RuntimeException("Invalid pos in doDeleteMember - pos:" + n + " memberCount:" + this.u);
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
        } else {
            System.arraycopy(this.t, n + 1, this.t, n, this.u - n);
            System.arraycopy(this.n, n + 1, this.n, n, this.u - n);
            System.arraycopy(this.k, n + 1, this.k, n, this.u - n);
            System.arraycopy(this.i, n + 1, this.i, n, this.u - n);
            if (this.z != null) {
                System.arraycopy(this.z, n + 1, this.z, n, this.u - n);
            }
            if (this.ag != null) {
                System.arraycopy(this.ag, n + 1, this.ag, n, this.u - n);
            }
            if (n == this.o || n == this.a) {
                Ef450.e(this);
            }
        }
    }

    public boolean r(int n, int n2) {
        if (this.ai != null) {
            Ln265 ln265 = Ha262.d(this.ai, n);
            if (ln265 != null) {
                if (ln265 instanceof Kq264) {
                    Kq264 kq264 = (Kq264)ln265;
                    if (kq264.g == n2) {
                        return false;
                    }
                    kq264.g = n2;
                    return true;
                }
                Ln265.ef(ln265);
            }
        } else {
            this.ai = new Ha262(4);
        }
        Ha262.q(this.ai, new Kq264(n2), n);
        return true;
    }

    void h(long l, String string) {
        if (string != null && string.length() == 0) {
            string = null;
        }
        if (l > 0L != this.j) {
            throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.j + " but userhash:" + l);
        }
        if (string != null != this.e) {
            throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.e + " but displayname:" + string);
        }
        if (l > 0L && (this.c == null || this.f >= this.c.length) || string != null && (this.aq == null || this.f >= this.aq.length)) {
            Ef450.d(this, this.f + 5);
        }
        if (this.c != null) {
            this.c[this.f] = l;
        }
        if (this.aq != null) {
            this.aq[this.f] = string;
        }
        ++this.f;
    }

    public static void s(Ef450 ef450, int n) {
        --ef450.f;
        if (ef450.f == 0) {
            ef450.c = null;
            ef450.aq = null;
        } else {
            if (ef450.c != null) {
                System.arraycopy(ef450.c, n + 1, ef450.c, n, ef450.f - n);
            }
            if (ef450.aq != null) {
                System.arraycopy(ef450.aq, n + 1, ef450.aq, n, ef450.f - n);
            }
        }
    }

    static int b(Ef450 ef450, int n, byte by) {
        if (by == 126 || by == 127) {
            return -1;
        }
        if (n == ef450.o && (ef450.a == -1 || ef450.t[ef450.a] < 125)) {
            return -1;
        }
        if (ef450.t[n] == by) {
            return -1;
        }
        ef450.t[n] = by;
        Ef450.e(ef450);
        return n;
    }

    static int w(Ef450 ef450, int n, int n2, int n3, int n4) {
        int n5 = (1 << n3) - 1;
        int n6 = n4 == 31 ? -1 : (1 << n4 + 1) - 1;
        int n7 = n6 ^ n5;
        n2 <<= n3;
        int n8 = ef450.n[n];
        if ((n8 & n7) == (n2 &= n7)) {
            return -1;
        }
        ef450.n[n] = (n8 &= ~n7) | n2;
        return n;
    }

    private static void e(Ef450 ef450) {
        if (ef450.u == 0) {
            ef450.o = -1;
            ef450.a = -1;
            return;
        }
        ef450.o = -1;
        ef450.a = -1;
        int n = 0;
        byte by = ef450.t[0];
        for (int i = 1; i < ef450.u; ++i) {
            if (ef450.t[i] > by) {
                if (by == 125) {
                    ef450.a = n;
                }
                n = i;
                by = ef450.t[i];
                continue;
            }
            if (ef450.a != -1 || ef450.t[i] != 125) continue;
            ef450.a = i;
        }
        ef450.o = n;
        if (ef450.o != -1) {
            ef450.t[ef450.o] = 126;
        }
    }

    boolean v(int n, int n2, int n3, int n4) {
        int n5 = (1 << n3) - 1;
        int n6 = n4 == 31 ? -1 : (1 << n4 + 1) - 1;
        int n7 = n6 ^ n5;
        n2 <<= n3;
        n2 &= n7;
        if (this.ai != null) {
            Ln265 ln265 = Ha262.d(this.ai, n);
            if (ln265 != null) {
                if (ln265 instanceof Kq264) {
                    Kq264 kq264 = (Kq264)ln265;
                    if ((kq264.g & n7) == n2) {
                        return false;
                    }
                    kq264.g &= ~n7;
                    kq264.g |= n2;
                    return true;
                }
                Ln265.ef(ln265);
            }
        } else {
            this.ai = new Ha262(4);
        }
        Ha262.q(this.ai, new Kq264(n2), n);
        return true;
    }

    private static void d(Ef450 ef450, int n) {
        if (ef450.j) {
            if (ef450.c != null) {
                ef450.c = new long[n];
                System.arraycopy(ef450.c, 0, ef450.c, 0, ef450.f);
            } else {
                ef450.c = new long[n];
            }
        }
        if (ef450.e) {
            if (ef450.aq != null) {
                ef450.aq = new String[n];
                System.arraycopy(ef450.aq, 0, ef450.aq, 0, ef450.f);
            } else {
                ef450.aq = new String[n];
            }
        }
    }

    boolean p(int n, String string) {
        if (string == null) {
            string = "";
        } else if (string.length() > 80) {
            string = string.substring(0, 80);
        }
        if (this.ai != null) {
            Ln265 ln265 = Ha262.d(this.ai, n);
            if (ln265 != null) {
                if (ln265 instanceof Ld263) {
                    Ld263 ld263 = (Ld263)ln265;
                    if (ld263.g instanceof String) {
                        if (string.equals(ld263.g)) {
                            return false;
                        }
                        Ld263.ef(ld263);
                        Ha262.q(this.ai, new Ld263(string), ld263.bq);
                        return true;
                    }
                }
                Ln265.ef(ln265);
            }
        } else {
            this.ai = new Ha262(4);
        }
        Ha262.q(this.ai, new Ld263(string), n);
        return true;
    }

    public void x(Gg3 gg3) {
        int n;
        int n2 = Gg3.ar(gg3);
        if (n2 < 1 || n2 > 6) {
            throw new RuntimeException("Unsupported ClanSettings version: " + n2);
        }
        int n3 = Gg3.ar(gg3);
        if ((n3 & 1) != 0) {
            this.j = true;
        }
        if ((n3 & 2) != 0) {
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
        if (n2 <= 3 && this.l != 0) {
            this.l += 16912800;
        }
        this.u = Gg3.au(gg3);
        this.f = Gg3.ar(gg3);
        this.b = Gg3.bk(gg3);
        if (n2 >= 4) {
            this.w = Gg3.bd(gg3);
        }
        this.r = Gg3.ar(gg3) == 1;
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
            for (n = 0; n < this.u; ++n) {
                if (this.j) {
                    this.z[n] = Gg3.bq(gg3);
                }
                if (this.e) {
                    this.ag[n] = Gg3.bj(gg3);
                }
                this.t[n] = Gg3.ax(gg3);
                if (n2 >= 2) {
                    this.n[n] = Gg3.bd(gg3);
                }
                this.k[n] = n2 >= 5 ? Gg3.au(gg3) : 0;
                this.i[n] = n2 >= 6 ? Gg3.ar(gg3) == 1 : false;
            }
            Ef450.e(this);
        }
        if (this.f > 0) {
            if (this.j && (this.c == null || this.c.length < this.f)) {
                this.c = new long[this.f];
            }
            if (this.e && (this.aq == null || this.aq.length < this.f)) {
                this.aq = new String[this.f];
            }
            for (n = 0; n < this.f; ++n) {
                if (this.j) {
                    this.c[n] = Gg3.bq(gg3);
                }
                if (!this.e) continue;
                this.aq[n] = Gg3.bj(gg3);
            }
        }
        if (n2 >= 3 && (n = Gg3.au(gg3)) > 0) {
            this.ai = new Ha262(n < 16 ? Jz233.j(n) : 16);
            while (n-- > 0) {
                int n4 = Gg3.bd(gg3);
                int n5 = n4 & 0x3FFFFFFF;
                int n6 = n4 >>> 30;
                if (n6 == 0) {
                    int n7 = Gg3.bd(gg3);
                    Ha262.q(this.ai, new Kq264(n7), n5);
                    continue;
                }
                if (n6 == 1) {
                    long l = Gg3.bq(gg3);
                    Ha262.q(this.ai, new Lo465(l), n5);
                    continue;
                }
                if (n6 != 2) continue;
                String string = Gg3.bk(gg3);
                Ha262.q(this.ai, new Ld263(string), n5);
            }
        }
    }

    public String u() {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Clan Name: ").append(this.b).append("\ncurrentOwnerSlot: ").append(this.o).append(", replacementOwnerSlot: ").append(this.a).append("\nallowNonMembers: ").append(this.r).append(", rankTalk: ").append(this.v).append(", rankKick: ").append(this.y).append(",  rankLootShare: ").append(this.p);
        stringBuilder.append("\nMembers:");
        for (n = 0; n < this.u; ++n) {
            stringBuilder.append("\n").append(this.z != null ? Q280.g(this.z[n]) : "null").append(" - ").append(this.ag[n]).append(" - rank:").append(this.t[n]);
        }
        stringBuilder.append("\nBanned:");
        for (n = 0; n < this.u; ++n) {
            stringBuilder.append("\n").append(this.z != null ? Q280.g(this.z[n]) : "null").append(" - ").append(this.ag[n]).append(" - rank:").append(this.t[n]);
        }
        return stringBuilder.toString();
    }

    public Ef450(long l, Gg3 gg3) {
        this.h = l;
        this.x(gg3);
    }

    boolean y(int n, long l) {
        if (this.ai != null) {
            Ln265 ln265 = Ha262.d(this.ai, n);
            if (ln265 != null) {
                if (ln265 instanceof Lo465) {
                    Lo465 lo465 = (Lo465)ln265;
                    if (lo465.g == l) {
                        return false;
                    }
                    lo465.g = l;
                    return true;
                }
                Ln265.ef(ln265);
            }
        } else {
            this.ai = new Ha262(4);
        }
        Ha262.q(this.ai, new Lo465(l), n);
        return true;
    }

    void q(long l, String string, int n) {
        if (string != null && string.length() == 0) {
            string = null;
        }
        if (l > 0L != this.j) {
            throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.j + " but userhash:" + l);
        }
        if (string != null != this.e) {
            throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.e + " but displayname:" + string);
        }
        if (l > 0L && (this.z == null || this.u >= this.z.length) || string != null && (this.ag == null || this.u >= this.ag.length)) {
            Ef450.g(this, this.u + 5);
        }
        if (this.z != null) {
            this.z[this.u] = l;
        }
        if (this.ag != null) {
            this.ag[this.u] = string;
        }
        if (this.o == -1) {
            this.o = this.u;
            this.t[this.u] = 126;
        } else {
            this.t[this.u] = 0;
        }
        this.n[this.u] = 0;
        this.k[this.u] = n;
        this.i[this.u] = false;
        ++this.u;
        this.m = null;
    }

    public Ef450(Gg3 gg3) {
        this.x(gg3);
    }
}

