/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.js5;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.js5.H362;
import com.jagex.js5.J135;
import com.jagex.js5.S136;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.BitSet;
import java.util.concurrent.ConcurrentHashMap;
import tfu.Ao128;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.Gl480;
import tfu.Gw492;
import tfu.Ls502;
import tfu.Mr366;

public final class js5 {
    public static boolean a;
    static final int af = 2;
    static final int ai = 0;
    static final int al = 1;
    public static int aq;
    public static int[][] c;
    static final boolean d = false;
    private static final boolean e = false;
    public static boolean f;
    static final boolean g = true;
    public static boolean i;
    static final boolean j = false;
    public static boolean k;
    static Ls502 l;
    public static int o;
    public static ConcurrentHashMap p;
    static final boolean q = false;
    public static int r;
    public static final int t = 2;
    public static final int u = 0;
    public static int v;
    public static ConcurrentHashMap y;
    public static final int z = 1;
    public int[][][] ag;
    private Object[][] b;
    private H362 h = null;
    public int m;
    private S136 n;
    private Object[] s;
    public boolean w = false;
    public boolean x;

    public js5(DataInputStream dataInputStream, boolean bl, int n) throws IOException {
        this((S136)new J135(dataInputStream, false), bl, n);
    }

    public js5(byte[] arrby, boolean bl, int n) throws IOException {
        this((S136)new J135(arrby, false), bl, n);
    }

    public js5(S136 s136, boolean bl, boolean bl2) {
        this(s136, bl, bl2 ? 1 : 0);
    }

    private synchronized byte[] s(int n, int n2, int[] arrn, boolean bl) {
        Long l;
        boolean bl2;
        if (!this.j(n, n2)) {
            return null;
        }
        byte[] arrby = null;
        if (!(this.b[n] != null && this.b[n][n2] != null || (bl2 = this.k(n, n2, arrn)))) {
            js5.e(this, n);
            bl2 = this.k(n, n2, arrn);
            if (!bl2) {
                if (!bl && this.fileExists(n, n2)) {
                    new Ao128("File not available yet (or already requested and discarded): " + n + " " + n2).printStackTrace();
                }
                return null;
            }
        }
        if (this.b[n] == null) {
            throw new RuntimeException("");
        }
        if (this.b[n][n2] != null && (arrby = Gl480.d(this.b[n][n2], false)) == null) {
            throw new RuntimeException("");
        }
        if (arrby != null) {
            if (this.m == 1) {
                this.b[n][n2] = null;
                if (this.h.z[n] == 1) {
                    this.b[n] = null;
                }
            } else if (this.m == 2) {
                this.b[n] = null;
            }
        }
        if (arrby != null && !this.w && y.get(l = new Long(this.hashCode() << 0 | n << 16 | n2)) == null) {
            y.put(l, new Boolean(true));
            r += arrby.length;
        }
        return arrby;
    }

    public js5(URL uRL, boolean bl, int n) throws IOException {
        this((S136)new J135(uRL, false), bl, n);
    }

    public js5(byte[] arrby, boolean bl, int n, boolean bl2) throws IOException {
        this((S136)new J135(arrby, bl2), bl, n);
    }

    public js5(DataInputStream dataInputStream, boolean bl, int n, boolean bl2) throws IOException {
        this((S136)new J135(dataInputStream, bl2), bl, n);
    }

    static final byte[] af(byte[] arrby) {
        int n;
        Gg3 gg3 = new Gg3(arrby);
        int n2 = Gg3.ar(gg3);
        if (a || f) {
            aq = n2;
        }
        if ((n = Gg3.bd(gg3)) < 0 || o != 0 && n > o) {
            throw new RuntimeException("ctype=" + n2 + " clen=" + n + " maxsize=" + o);
        }
        if (n2 == 0) {
            byte[] arrby2 = new byte[n];
            Gg3.bx(gg3, arrby2, 0, n);
            return arrby2;
        }
        int n3 = Gg3.bd(gg3);
        if (n3 < 0 || o != 0 && n3 > o) {
            throw new RuntimeException("ctype=" + n2 + " clen=" + n + " ulen=" + n3 + " maxsize=" + o);
        }
        byte[] arrby3 = new byte[n3];
        if (n2 == 1) {
            Gw492.g(arrby3, n3, arrby, n, 9);
        } else {
            Ls502 ls502 = l;
            synchronized (ls502) {
                l.g(gg3, arrby3);
            }
        }
        return arrby3;
    }

    public js5(byte[] arrby, boolean bl, boolean bl2, boolean bl3) throws IOException {
        this((S136)new J135(arrby, bl3), bl, bl2);
    }

    public static void n(js5 js52, boolean bl, boolean bl2) {
        if (!js5.g(js52)) {
            return;
        }
        if (bl) {
            js52.h.s = null;
            js52.h.b = null;
        }
        if (bl2) {
            js52.h.x = null;
            js52.h.u = null;
        }
    }

    public js5(byte[] arrby, boolean bl, boolean bl2) throws IOException {
        this((S136)new J135(arrby, false), bl, bl2);
    }

    public js5(DataInputStream dataInputStream, boolean bl, boolean bl2) throws IOException {
        this((S136)new J135(dataInputStream, false), bl, bl2);
    }

    public js5(File file, boolean bl, boolean bl2) throws IOException {
        this((S136)new J135(file, false), bl, bl2);
    }

    public js5(File file, boolean bl, int n) throws IOException {
        this((S136)new J135(file, false), bl, n);
    }

    public js5(File file, boolean bl, boolean bl2, boolean bl3) throws IOException {
        this((S136)new J135(file, bl3), bl, bl2);
    }

    public js5(URL uRL, boolean bl, boolean bl2, boolean bl3) throws IOException {
        this((S136)new J135(uRL, bl3), bl, bl2);
    }

    public synchronized boolean q(int n) {
        if (!js5.g(this)) {
            return false;
        }
        if (n < 0 || n >= this.h.z.length || this.h.z[n] == 0) {
            if (k) {
                throw new IllegalArgumentException(Integer.toString(n));
            }
            return false;
        }
        return true;
    }

    public int d() {
        if (!js5.g(this)) {
            throw new IllegalStateException("Index not ready");
        }
        return this.h.d;
    }

    public js5(URL uRL, boolean bl, boolean bl2) throws IOException {
        this((S136)new J135(uRL, false), bl, bl2);
    }

    private synchronized byte[] x(int n, boolean bl) {
        if (!js5.g(this)) {
            return null;
        }
        if (this.h.z.length == 1) {
            return this.s(0, n, null, bl);
        }
        if (!this.q(n)) {
            return null;
        }
        if (this.h.z[n] == 1) {
            return this.s(n, 0, null, bl);
        }
        throw new RuntimeException("Unable to determine if id is groupid or fileid");
    }

    private static synchronized void e(js5 js52, int n) {
        js52.s[n] = js52.x ? js52.n.q(n) : Gl480.g(js52.n.q(n), false);
    }

    @Be2
    @Bs1
    public boolean fileExists(int n, int n2) {
        if (!js5.g(this)) {
            throw new IllegalStateException("Not ready");
        }
        if (n < 0 || n2 < 0 || n >= this.h.z.length || n2 >= this.h.z[n]) {
            return false;
        }
        if (this.h.h != null) {
            if (this.h.t == null) {
                this.h.t = new BitSet(this.h.z.length);
                for (int n3 : this.h.h) {
                    this.h.t.set(n3);
                }
            }
            if (!this.h.t.get(n)) {
                return false;
            }
        }
        if (this.h.p[n] != null) {
            if (this.h.m == null) {
                this.h.m = new BitSet[this.h.z.length];
            }
            if (this.h.m[n] == null) {
                this.h.m[n] = new BitSet(this.h.z[n]);
                for (int n3 : this.h.p[n]) {
                    this.h.m[n].set(n3);
                }
            }
            if (!this.h.m[n].get(n2)) {
                return false;
            }
        }
        return true;
    }

    public static synchronized boolean g(js5 js52) {
        if (js52.h == null) {
            js52.h = js52.n.d();
            if (js52.h == null) {
                return false;
            }
            js52.s = new Object[js52.h.l];
            js52.b = new Object[js52.h.l][];
        }
        return true;
    }

    @Deprecated
    @Be2
    @Bs1
    public byte[] getfile(int n, int n2) {
        return this.s(n, n2, null, i);
    }

    public static byte[] h(js5 js52, int n, int n2) {
        return js52.s(n, n2, null, true);
    }

    @Be2
    @Bs1
    public boolean fileIsReady(int n, int n2) {
        boolean bl;
        if (!this.j(n, n2)) {
            return false;
        }
        if (!(this.b[n] != null && this.b[n][n2] != null || (bl = this.k(n, n2, null)))) {
            js5.e(this, n);
            bl = this.k(n, n2, null);
            if (!bl) {
                return false;
            }
        }
        if (this.b[n] == null) {
            throw new RuntimeException("");
        }
        return this.b[n][n2] != null;
    }

    public js5(File file, boolean bl, int n, boolean bl2) throws IOException {
        this((S136)new J135(file, bl2), bl, n);
    }

    @Be2
    public synchronized boolean requestgroupdownload(int n) {
        if (!this.q(n)) {
            return false;
        }
        if (this.s[n] != null) {
            return true;
        }
        js5.e(this, n);
        return this.s[n] != null;
    }

    public static synchronized boolean l(js5 js52) {
        if (!js5.g(js52)) {
            return false;
        }
        boolean bl = true;
        for (int i = 0; i < js52.h.h.length; ++i) {
            int n = js52.h.h[i];
            if (js52.s[n] != null) continue;
            js5.e(js52, n);
            if (js52.s[n] != null) continue;
            bl = false;
        }
        return bl;
    }

    public synchronized boolean j(int n, int n2) {
        if (!js5.g(this)) {
            return false;
        }
        if (n < 0 || n2 < 0 || n >= this.h.z.length || n2 >= this.h.z[n]) {
            if (k) {
                throw new IllegalArgumentException(n + " " + n2);
            }
            return false;
        }
        return true;
    }

    public static synchronized int r(js5 js52) {
        int n;
        if (!js5.g(js52)) {
            return 0;
        }
        int n2 = 0;
        int n3 = 0;
        for (n = 0; n < js52.s.length; ++n) {
            if (js52.h.y[n] <= 0) continue;
            n2 += 100;
            n3 += js5.w(js52, n);
        }
        if (n2 == 0) {
            return 100;
        }
        n = n3 * 100 / n2;
        return n;
    }

    @Deprecated
    public static synchronized byte[] v(js5 js52, int n) {
        return js52.x(n, i);
    }

    public static synchronized byte[] y(js5 js52, int n) {
        return js52.x(n, false);
    }

    public static synchronized byte[] p(js5 js52, int n) {
        return js52.x(n, true);
    }

    public static boolean i(js5 js52) {
        if (!js5.g(js52)) {
            return false;
        }
        return js52.h.s != null;
    }

    public static synchronized int[] u(js5 js52, int n) {
        if (!js52.q(n)) {
            return null;
        }
        int[] arrn = js52.h.p[n];
        if (arrn == null) {
            arrn = new int[js52.h.y[n]];
            for (int i = 0; i < arrn.length; ++i) {
                arrn[i] = i;
            }
        }
        return arrn;
    }

    public static int z(js5 js52, int n) {
        if (!js52.q(n)) {
            return 0;
        }
        return js52.h.z[n];
    }

    public static boolean aq(js5 js52, String string) {
        int n = js52.getgroupid("");
        if (n != -1) {
            return js5.ag(js52, "", string);
        }
        return js5.ag(js52, string, "");
    }

    public static synchronized void m(js5 js52) {
        if (js52.b != null) {
            for (int i = 0; i < js52.b.length; ++i) {
                js52.b[i] = null;
            }
        }
    }

    @Be2
    @Bs1
    public synchronized boolean requestdownload(int n, int n2) {
        if (!this.j(n, n2)) {
            return false;
        }
        if (this.b[n] != null && this.b[n][n2] != null) {
            return true;
        }
        if (this.s[n] != null) {
            return true;
        }
        js5.e(this, n);
        return this.s[n] != null;
    }

    public synchronized boolean k(int n, int n2, int[] arrn) {
        byte[] arrby;
        Object object;
        if (!this.q(n)) {
            return false;
        }
        if (this.s[n] == null) {
            return false;
        }
        int n3 = this.h.y[n];
        int[] arrn2 = this.h.p[n];
        if (this.b[n] == null) {
            this.b[n] = new Object[this.h.z[n]];
        }
        Object[] arrobject = this.b[n];
        boolean bl = true;
        for (int i = 0; i < n3; ++i) {
            int n4 = arrn2 == null ? i : arrn2[i];
            if (arrobject[n4] != null) continue;
            bl = false;
            break;
        }
        if (bl) {
            return true;
        }
        if (arrn != null && (arrn[0] != 0 || arrn[1] != 0 || arrn[2] != 0 || arrn[3] != 0)) {
            arrby = Gl480.d(this.s[n], true);
            Gg3 gg3 = new Gg3(arrby);
            Gg3.bi(gg3, arrn, 5, gg3.r.length);
        } else {
            arrby = Gl480.d(this.s[n], false);
        }
        if (arrby != null && !this.w && p.get(object = new Long(this.hashCode() << 0 | n)) == null) {
            p.put(object, new Boolean(true));
            v += arrby.length;
        }
        object = js5.af(arrby);
        if (this.x) {
            this.s[n] = null;
        }
        if (f && this.ag == null) {
            this.ag = new int[this.h.l][][];
        }
        if (n3 > 1) {
            if (this.m != 2) {
                int n5;
                int n6;
                int n7;
                int n8 = ((byte[])object).length;
                int n9 = object[--n8] & 0xFF;
                Gg3 gg3 = new Gg3((byte[])object);
                int[] arrn3 = new int[n3];
                gg3.v = n8 -= n3 * n9 * 4;
                if (a || f) {
                    c = new int[arrobject.length][n9];
                    if (f) {
                        this.ag[n] = c;
                    }
                }
                for (int i = 0; i < n9; ++i) {
                    n6 = 0;
                    for (n7 = 0; n7 < n3; ++n7) {
                        int[] arrn4 = arrn3;
                        int n10 = n7;
                        arrn4[n10] = arrn4[n10] + (n6 += Gg3.bd(gg3));
                        if (!a && !f) continue;
                        n5 = arrn2 == null ? n7 : arrn2[n7];
                        js5.c[n5][i] = n6;
                    }
                }
                byte[][] arrarrby = new byte[n3][];
                for (n6 = 0; n6 < n3; ++n6) {
                    arrarrby[n6] = new byte[arrn3[n6]];
                    arrn3[n6] = 0;
                }
                gg3.v = n8;
                n6 = 0;
                for (n7 = 0; n7 < n9; ++n7) {
                    n5 = 0;
                    int n11 = 0;
                    while (n11 < n3) {
                        System.arraycopy(object, n6, arrarrby[n11], arrn3[n11], n5 += Gg3.bd(gg3));
                        int[] arrn5 = arrn3;
                        int n12 = n11++;
                        arrn5[n12] = arrn5[n12] + n5;
                        n6 += n5;
                    }
                }
                for (n7 = 0; n7 < n3; ++n7) {
                    n5 = arrn2 == null ? n7 : arrn2[n7];
                    arrobject[n5] = this.m == 0 ? Gl480.g(arrarrby[n7], false) : arrarrby[n7];
                }
            } else {
                int n13;
                int n14;
                int n15;
                int n16 = ((byte[])object).length;
                int n17 = object[--n16] & 0xFF;
                Gg3 gg3 = new Gg3((byte[])object);
                int n18 = 0;
                int n19 = 0;
                gg3.v = n16 -= n3 * n17 * 4;
                if (a || f) {
                    c = new int[arrobject.length][n17];
                    if (f) {
                        this.ag[n] = c;
                    }
                }
                for (int i = 0; i < n17; ++i) {
                    n15 = 0;
                    for (n13 = 0; n13 < n3; ++n13) {
                        n15 += Gg3.bd(gg3);
                        n14 = arrn2 == null ? n13 : arrn2[n13];
                        if (n14 != n2) continue;
                        n18 += n15;
                        n19 = n14;
                        if (!a && !f) continue;
                        js5.c[n19][i] = n15;
                    }
                }
                if (n18 == 0) {
                    return true;
                }
                byte[] arrby2 = new byte[n18];
                n18 = 0;
                gg3.v = n16;
                n15 = 0;
                for (n13 = 0; n13 < n17; ++n13) {
                    n14 = 0;
                    for (int i = 0; i < n3; ++i) {
                        n14 += Gg3.bd(gg3);
                        int n20 = arrn2 == null ? i : arrn2[i];
                        if (n20 == n2) {
                            System.arraycopy(object, n15, arrby2, n18, n14);
                            n18 += n14;
                        }
                        n15 += n14;
                    }
                }
                arrobject[n19] = arrby2;
            }
        } else {
            int n21 = arrn2 == null ? 0 : arrn2[0];
            arrobject[n21] = this.m == 0 ? Gl480.g(object, false) : object;
            if (a || f) {
                if (f) {
                    this.ag[n] = null;
                }
                c = null;
            }
        }
        return true;
    }

    public static boolean ag(js5 js52, String string, String string2) {
        if (!js5.g(js52)) {
            return false;
        }
        string = string.toLowerCase();
        string2 = string2.toLowerCase();
        int n = Mr366.g(js52.h.b, StringTools.b(string));
        if (!js52.q(n)) {
            return false;
        }
        int n2 = Mr366.g(js52.h.u[n], StringTools.b(string2));
        return js52.requestdownload(n, n2);
    }

    public static int t(js5 js52) {
        if (!js5.g(js52)) {
            return -1;
        }
        return js52.h.z.length;
    }

    @Be2
    @Bs1
    public int getfileid(int n, String string) {
        if (!this.q(n)) {
            return -1;
        }
        int n2 = Mr366.g(this.h.u[n], StringTools.b(string = string.toLowerCase()));
        if (!this.j(n, n2)) {
            return -1;
        }
        return n2;
    }

    public static boolean o(js5 js52, String string, String string2) {
        if (!js5.g(js52)) {
            return false;
        }
        string = string.toLowerCase();
        string2 = string2.toLowerCase();
        int n = Mr366.g(js52.h.b, StringTools.b(string));
        if (n < 0) {
            return false;
        }
        int n2 = Mr366.g(js52.h.u[n], StringTools.b(string2));
        return n2 >= 0;
    }

    @Deprecated
    public static synchronized byte[] a(js5 js52, String string, String string2) {
        return js5.c(js52, string, string2, null, i);
    }

    public static synchronized byte[] f(js5 js52, String string, String string2) {
        return js5.c(js52, string, string2, null, false);
    }

    private static synchronized byte[] c(js5 js52, String string, String string2, int[] arrn, boolean bl) {
        if (!js5.g(js52)) {
            return null;
        }
        string = string.toLowerCase();
        string2 = string2.toLowerCase();
        int n = Mr366.g(js52.h.b, StringTools.b(string));
        if (!js52.q(n)) {
            return null;
        }
        int n2 = Mr366.g(js52.h.u[n], StringTools.b(string2));
        return js52.s(n, n2, arrn, bl);
    }

    public js5(URL uRL, boolean bl, int n, boolean bl2) throws IOException {
        this((S136)new J135(uRL, bl2), bl, n);
    }

    public static boolean ai(js5 js52, String string) {
        if (!js5.g(js52)) {
            return false;
        }
        string = string.toLowerCase();
        int n = Mr366.g(js52.h.b, StringTools.b(string));
        return js52.requestgroupdownload(n);
    }

    @Be2
    @Bs1
    public boolean grouphasdata(int n) {
        return js5.g(this) && this.q(n);
    }

    public static int al(js5 js52, String string) {
        if (!js5.g(js52)) {
            return 0;
        }
        string = string.toLowerCase();
        int n = Mr366.g(js52.h.b, StringTools.b(string));
        return js5.w(js52, n);
    }

    static String av(byte[] arrby) {
        StringBuffer stringBuffer = new StringBuffer(arrby.length * 2 + 2);
        stringBuffer.append("0x");
        for (byte by : arrby) {
            if (by >= 0 && by < 16) {
                stringBuffer.append("0" + StringTools.s(by, 16, false));
                continue;
            }
            stringBuffer.append(StringTools.s(by & 0xFF, 16, false));
        }
        return stringBuffer.toString();
    }

    static {
        l = new Ls502();
        r = 0;
        v = 0;
        y = new ConcurrentHashMap();
        p = new ConcurrentHashMap();
        k = false;
        i = true;
        o = 0;
        a = false;
        f = false;
    }

    public static synchronized int w(js5 js52, int n) {
        if (!js52.q(n)) {
            return 0;
        }
        if (js52.s[n] != null) {
            return 100;
        }
        return js52.n.w(n);
    }

    public js5(DataInputStream dataInputStream, boolean bl, boolean bl2, boolean bl3) throws IOException {
        this((S136)new J135(dataInputStream, bl3), bl, bl2);
    }

    public js5(S136 s136, boolean bl, int n) {
        if (n < 0 || n > 2) {
            throw new IllegalArgumentException("");
        }
        this.n = s136;
        this.x = bl;
        this.m = n;
    }

    @Be2
    @Bs1
    public int getgroupid(String string) {
        if (!js5.g(this)) {
            return -1;
        }
        int n = Mr366.g(this.h.b, StringTools.b(string = string.toLowerCase()));
        if (!this.q(n)) {
            return -1;
        }
        return n;
    }

    public synchronized boolean b(int n) {
        if (!js5.g(this)) {
            return false;
        }
        if (this.h.z.length == 1) {
            return this.requestdownload(0, n);
        }
        if (!this.q(n)) {
            return false;
        }
        if (this.h.z[n] == 1) {
            return this.requestdownload(n, 0);
        }
        throw new RuntimeException("Unable to determine if id is groupid or fileid");
    }
}

