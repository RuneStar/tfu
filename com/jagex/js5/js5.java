// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.js5;

import tfu.Mr366;
import com.jagex.core.stringtools.general.StringTools;
import tfu.Bs1;
import tfu.Be2;
import java.util.BitSet;
import java.io.File;
import tfu.Gw492;
import tfu.Gg3;
import java.net.URL;
import tfu.Gl480;
import tfu.Ao128;
import java.io.IOException;
import java.io.DataInputStream;
import java.util.concurrent.ConcurrentHashMap;
import tfu.Ls502;

public final class js5
{
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
    private H362 h;
    public int m;
    private S136 n;
    private Object[] s;
    public boolean w;
    public boolean x;
    
    public js5(final DataInputStream dataInputStream, final boolean b, final int n) throws IOException {
        this(new J135(dataInputStream, false), b, n);
    }
    
    public js5(final byte[] array, final boolean b, final int n) throws IOException {
        this(new J135(array, false), b, n);
    }
    
    @Deprecated
    public js5(final S136 s136, final boolean b, final boolean b2) {
        this(s136, b, b2 ? 1 : 0);
    }
    
    private synchronized byte[] s(final int i, final int j, final int[] array, final boolean b) {
        if (!this.j(i, j)) {
            return null;
        }
        byte[] d = null;
        if ((this.b[i] == null || this.b[i][j] == null) && !this.k(i, j, array)) {
            e(this, i);
            if (!this.k(i, j, array)) {
                if (!b && this.fileExists(i, j)) {
                    new Ao128("File not available yet (or already requested and discarded): " + i + " " + j).printStackTrace();
                }
                return null;
            }
        }
        if (this.b[i] == null) {
            throw new RuntimeException("");
        }
        if (this.b[i][j] != null) {
            d = Gl480.d(this.b[i][j], false);
            if (d == null) {
                throw new RuntimeException("");
            }
        }
        if (d != null) {
            if (this.m == 1) {
                this.b[i][j] = null;
                if (this.h.z[i] == 1) {
                    this.b[i] = null;
                }
            }
            else if (this.m == 2) {
                this.b[i] = null;
            }
        }
        if (d != null && !this.w) {
            final Long n = new Long(this.hashCode() << 0 | i << 16 | j);
            if (js5.y.get(n) == null) {
                js5.y.put(n, new Boolean(true));
                js5.r += d.length;
            }
        }
        return d;
    }
    
    public js5(final URL url, final boolean b, final int n) throws IOException {
        this(new J135(url, false), b, n);
    }
    
    public js5(final byte[] array, final boolean b, final int n, final boolean b2) throws IOException {
        this(new J135(array, b2), b, n);
    }
    
    public js5(final DataInputStream dataInputStream, final boolean b, final int n, final boolean b2) throws IOException {
        this(new J135(dataInputStream, b2), b, n);
    }
    
    static final byte[] af(final byte[] array) {
        final Gg3 gg3 = new Gg3(array);
        final int ar = Gg3.ar(gg3);
        if (js5.a || js5.f) {
            js5.aq = ar;
        }
        final int bd = Gg3.bd(gg3);
        if (bd < 0 || (js5.o != 0 && bd > js5.o)) {
            throw new RuntimeException("ctype=" + ar + " clen=" + bd + " maxsize=" + js5.o);
        }
        if (ar == 0) {
            final byte[] array2 = new byte[bd];
            Gg3.bx(gg3, array2, 0, bd);
            return array2;
        }
        final int bd2 = Gg3.bd(gg3);
        if (bd2 < 0 || (js5.o != 0 && bd2 > js5.o)) {
            throw new RuntimeException("ctype=" + ar + " clen=" + bd + " ulen=" + bd2 + " maxsize=" + js5.o);
        }
        final byte[] array3 = new byte[bd2];
        if (ar == 1) {
            Gw492.g(array3, bd2, array, bd, 9);
        }
        else {
            synchronized (js5.l) {
                js5.l.g(gg3, array3);
            }
        }
        return array3;
    }
    
    @Deprecated
    public js5(final byte[] array, final boolean b, final boolean b2, final boolean b3) throws IOException {
        this(new J135(array, b3), b, b2);
    }
    
    public static void n(final js5 js5, final boolean b, final boolean b2) {
        if (!g(js5)) {
            return;
        }
        if (b) {
            js5.h.s = null;
            js5.h.b = null;
        }
        if (b2) {
            js5.h.x = null;
            js5.h.u = null;
        }
    }
    
    @Deprecated
    public js5(final byte[] array, final boolean b, final boolean b2) throws IOException {
        this(new J135(array, false), b, b2);
    }
    
    @Deprecated
    public js5(final DataInputStream dataInputStream, final boolean b, final boolean b2) throws IOException {
        this(new J135(dataInputStream, false), b, b2);
    }
    
    @Deprecated
    public js5(final File file, final boolean b, final boolean b2) throws IOException {
        this(new J135(file, false), b, b2);
    }
    
    public js5(final File file, final boolean b, final int n) throws IOException {
        this(new J135(file, false), b, n);
    }
    
    @Deprecated
    public js5(final File file, final boolean b, final boolean b2, final boolean b3) throws IOException {
        this(new J135(file, b3), b, b2);
    }
    
    @Deprecated
    public js5(final URL url, final boolean b, final boolean b2, final boolean b3) throws IOException {
        this(new J135(url, b3), b, b2);
    }
    
    public synchronized boolean q(final int i) {
        if (!g(this)) {
            return false;
        }
        if (i >= 0 && i < this.h.z.length && this.h.z[i] != 0) {
            return true;
        }
        if (js5.k) {
            throw new IllegalArgumentException(Integer.toString(i));
        }
        return false;
    }
    
    public int d() {
        if (!g(this)) {
            throw new IllegalStateException("Index not ready");
        }
        return this.h.d;
    }
    
    @Deprecated
    public js5(final URL url, final boolean b, final boolean b2) throws IOException {
        this(new J135(url, false), b, b2);
    }
    
    private synchronized byte[] x(final int n, final boolean b) {
        if (!g(this)) {
            return null;
        }
        if (this.h.z.length == 1) {
            return this.s(0, n, null, b);
        }
        if (!this.q(n)) {
            return null;
        }
        if (this.h.z[n] == 1) {
            return this.s(n, 0, null, b);
        }
        throw new RuntimeException("Unable to determine if id is groupid or fileid");
    }
    
    private static synchronized void e(final js5 js5, final int n) {
        if (js5.x) {
            js5.s[n] = js5.n.q(n);
        }
        else {
            js5.s[n] = Gl480.g(js5.n.q(n), false);
        }
    }
    
    @Be2
    @Bs1
    public boolean fileExists(final int bitIndex, final int bitIndex2) {
        if (!g(this)) {
            throw new IllegalStateException("Not ready");
        }
        if (bitIndex < 0 || bitIndex2 < 0 || bitIndex >= this.h.z.length || bitIndex2 >= this.h.z[bitIndex]) {
            return false;
        }
        if (this.h.h != null) {
            if (this.h.t == null) {
                this.h.t = new BitSet(this.h.z.length);
                final int[] h = this.h.h;
                for (int length = h.length, i = 0; i < length; ++i) {
                    this.h.t.set(h[i]);
                }
            }
            if (!this.h.t.get(bitIndex)) {
                return false;
            }
        }
        if (this.h.p[bitIndex] != null) {
            if (this.h.m == null) {
                this.h.m = new BitSet[this.h.z.length];
            }
            if (this.h.m[bitIndex] == null) {
                this.h.m[bitIndex] = new BitSet(this.h.z[bitIndex]);
                final int[] array = this.h.p[bitIndex];
                for (int length2 = array.length, j = 0; j < length2; ++j) {
                    this.h.m[bitIndex].set(array[j]);
                }
            }
            if (!this.h.m[bitIndex].get(bitIndex2)) {
                return false;
            }
        }
        return true;
    }
    
    public static synchronized boolean g(final js5 js5) {
        if (js5.h == null) {
            js5.h = js5.n.d();
            if (js5.h == null) {
                return false;
            }
            js5.s = new Object[js5.h.l];
            js5.b = new Object[js5.h.l][];
        }
        return true;
    }
    
    @Deprecated
    @Be2
    @Bs1
    public byte[] getfile(final int n, final int n2) {
        return this.s(n, n2, null, js5.i);
    }
    
    public static byte[] h(final js5 js5, final int n, final int n2) {
        return js5.s(n, n2, null, true);
    }
    
    @Be2
    @Bs1
    public boolean fileIsReady(final int n, final int n2) {
        if (!this.j(n, n2)) {
            return false;
        }
        if ((this.b[n] == null || this.b[n][n2] == null) && !this.k(n, n2, null)) {
            e(this, n);
            if (!this.k(n, n2, null)) {
                return false;
            }
        }
        if (this.b[n] == null) {
            throw new RuntimeException("");
        }
        return this.b[n][n2] != null;
    }
    
    public js5(final File file, final boolean b, final int n, final boolean b2) throws IOException {
        this(new J135(file, b2), b, n);
    }
    
    @Be2
    public synchronized boolean requestgroupdownload(final int n) {
        if (!this.q(n)) {
            return false;
        }
        if (this.s[n] != null) {
            return true;
        }
        e(this, n);
        return this.s[n] != null;
    }
    
    public static synchronized boolean l(final js5 js5) {
        if (!g(js5)) {
            return false;
        }
        boolean b = true;
        for (int i = 0; i < js5.h.h.length; ++i) {
            final int n = js5.h.h[i];
            if (js5.s[n] == null) {
                e(js5, n);
                if (js5.s[n] == null) {
                    b = false;
                }
            }
        }
        return b;
    }
    
    public synchronized boolean j(final int i, final int j) {
        if (!g(this)) {
            return false;
        }
        if (i >= 0 && j >= 0 && i < this.h.z.length && j < this.h.z[i]) {
            return true;
        }
        if (js5.k) {
            throw new IllegalArgumentException(i + " " + j);
        }
        return false;
    }
    
    public static synchronized int r(final js5 js5) {
        if (!g(js5)) {
            return 0;
        }
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < js5.s.length; ++i) {
            if (js5.h.y[i] > 0) {
                n += 100;
                n2 += w(js5, i);
            }
        }
        if (n == 0) {
            return 100;
        }
        return n2 * 100 / n;
    }
    
    @Deprecated
    public static synchronized byte[] v(final js5 js5, final int n) {
        return js5.x(n, js5.i);
    }
    
    public static synchronized byte[] y(final js5 js5, final int n) {
        return js5.x(n, false);
    }
    
    public static synchronized byte[] p(final js5 js5, final int n) {
        return js5.x(n, true);
    }
    
    public static boolean i(final js5 js5) {
        return g(js5) && js5.h.s != null;
    }
    
    public static synchronized int[] u(final js5 js5, final int n) {
        if (!js5.q(n)) {
            return null;
        }
        int[] array = js5.h.p[n];
        if (array == null) {
            array = new int[js5.h.y[n]];
            for (int i = 0; i < array.length; ++i) {
                array[i] = i;
            }
        }
        return array;
    }
    
    public static int z(final js5 js5, final int n) {
        if (!js5.q(n)) {
            return 0;
        }
        return js5.h.z[n];
    }
    
    public static boolean aq(final js5 js5, final String s) {
        if (js5.getgroupid("") != -1) {
            return ag(js5, "", s);
        }
        return ag(js5, s, "");
    }
    
    public static synchronized void m(final js5 js5) {
        if (js5.b != null) {
            for (int i = 0; i < js5.b.length; ++i) {
                js5.b[i] = null;
            }
        }
    }
    
    @Be2
    @Bs1
    public synchronized boolean requestdownload(final int n, final int n2) {
        if (!this.j(n, n2)) {
            return false;
        }
        if (this.b[n] != null && this.b[n][n2] != null) {
            return true;
        }
        if (this.s[n] != null) {
            return true;
        }
        e(this, n);
        return this.s[n] != null;
    }
    
    public synchronized boolean k(final int n, final int n2, final int[] array) {
        if (!this.q(n)) {
            return false;
        }
        if (this.s[n] == null) {
            return false;
        }
        final int n3 = this.h.y[n];
        final int[] array2 = this.h.p[n];
        if (this.b[n] == null) {
            this.b[n] = new Object[this.h.z[n]];
        }
        final Object[] array3 = this.b[n];
        boolean b = true;
        for (int i = 0; i < n3; ++i) {
            int n4;
            if (array2 == null) {
                n4 = i;
            }
            else {
                n4 = array2[i];
            }
            if (array3[n4] == null) {
                b = false;
                break;
            }
        }
        if (b) {
            return true;
        }
        byte[] array4;
        if (array != null && (array[0] != 0 || array[1] != 0 || array[2] != 0 || array[3] != 0)) {
            array4 = Gl480.d(this.s[n], true);
            final Gg3 gg3 = new Gg3(array4);
            Gg3.bi(gg3, array, 5, gg3.r.length);
        }
        else {
            array4 = Gl480.d(this.s[n], false);
        }
        if (array4 != null && !this.w) {
            final Long n5 = new Long(this.hashCode() << 0 | n);
            if (js5.p.get(n5) == null) {
                js5.p.put(n5, new Boolean(true));
                js5.v += array4.length;
            }
        }
        final byte[] af = af(array4);
        if (this.x) {
            this.s[n] = null;
        }
        if (js5.f && this.ag == null) {
            this.ag = new int[this.h.l][][];
        }
        if (n3 > 1) {
            if (this.m != 2) {
                int length = af.length;
                final int n6 = af[--length] & 0xFF;
                final int n7 = length - n3 * n6 * 4;
                final Gg3 gg4 = new Gg3(af);
                final int[] array5 = new int[n3];
                gg4.v = n7;
                if (js5.a || js5.f) {
                    js5.c = new int[array3.length][n6];
                    if (js5.f) {
                        this.ag[n] = js5.c;
                    }
                }
                for (int j = 0; j < n6; ++j) {
                    int n8 = 0;
                    for (int k = 0; k < n3; ++k) {
                        n8 += Gg3.bd(gg4);
                        final int[] array6 = array5;
                        final int n9 = k;
                        array6[n9] += n8;
                        if (js5.a || js5.f) {
                            int n10;
                            if (array2 == null) {
                                n10 = k;
                            }
                            else {
                                n10 = array2[k];
                            }
                            js5.c[n10][j] = n8;
                        }
                    }
                }
                final byte[][] array7 = new byte[n3][];
                for (int l = 0; l < n3; ++l) {
                    array7[l] = new byte[array5[l]];
                    array5[l] = 0;
                }
                gg4.v = n7;
                int n11 = 0;
                for (int n12 = 0; n12 < n6; ++n12) {
                    int n13 = 0;
                    for (int n14 = 0; n14 < n3; ++n14) {
                        n13 += Gg3.bd(gg4);
                        System.arraycopy(af, n11, array7[n14], array5[n14], n13);
                        final int[] array8 = array5;
                        final int n15 = n14;
                        array8[n15] += n13;
                        n11 += n13;
                    }
                }
                for (int n16 = 0; n16 < n3; ++n16) {
                    int n17;
                    if (array2 == null) {
                        n17 = n16;
                    }
                    else {
                        n17 = array2[n16];
                    }
                    if (this.m == 0) {
                        array3[n17] = Gl480.g(array7[n16], false);
                    }
                    else {
                        array3[n17] = array7[n16];
                    }
                }
            }
            else {
                int length2 = af.length;
                final int n18 = af[--length2] & 0xFF;
                final int n19 = length2 - n3 * n18 * 4;
                final Gg3 gg5 = new Gg3(af);
                int n20 = 0;
                int n21 = 0;
                gg5.v = n19;
                if (js5.a || js5.f) {
                    js5.c = new int[array3.length][n18];
                    if (js5.f) {
                        this.ag[n] = js5.c;
                    }
                }
                for (int n22 = 0; n22 < n18; ++n22) {
                    int n23 = 0;
                    for (int n24 = 0; n24 < n3; ++n24) {
                        n23 += Gg3.bd(gg5);
                        int n25;
                        if (array2 == null) {
                            n25 = n24;
                        }
                        else {
                            n25 = array2[n24];
                        }
                        if (n25 == n2) {
                            n20 += n23;
                            n21 = n25;
                            if (js5.a || js5.f) {
                                js5.c[n21][n22] = n23;
                            }
                        }
                    }
                }
                if (n20 == 0) {
                    return true;
                }
                final byte[] array9 = new byte[n20];
                int n26 = 0;
                gg5.v = n19;
                int n27 = 0;
                for (int n28 = 0; n28 < n18; ++n28) {
                    int n29 = 0;
                    for (int n30 = 0; n30 < n3; ++n30) {
                        n29 += Gg3.bd(gg5);
                        int n31;
                        if (array2 == null) {
                            n31 = n30;
                        }
                        else {
                            n31 = array2[n30];
                        }
                        if (n31 == n2) {
                            System.arraycopy(af, n27, array9, n26, n29);
                            n26 += n29;
                        }
                        n27 += n29;
                    }
                }
                array3[n21] = array9;
            }
        }
        else {
            int n32;
            if (array2 == null) {
                n32 = 0;
            }
            else {
                n32 = array2[0];
            }
            if (this.m == 0) {
                array3[n32] = Gl480.g(af, false);
            }
            else {
                array3[n32] = af;
            }
            if (js5.a || js5.f) {
                if (js5.f) {
                    this.ag[n] = null;
                }
                js5.c = null;
            }
        }
        return true;
    }
    
    public static boolean ag(final js5 js5, String lowerCase, String lowerCase2) {
        if (!g(js5)) {
            return false;
        }
        lowerCase = lowerCase.toLowerCase();
        lowerCase2 = lowerCase2.toLowerCase();
        final int g = Mr366.g(js5.h.b, StringTools.b(lowerCase));
        return js5.q(g) && js5.requestdownload(g, Mr366.g(js5.h.u[g], StringTools.b(lowerCase2)));
    }
    
    public static int t(final js5 js5) {
        if (!g(js5)) {
            return -1;
        }
        return js5.h.z.length;
    }
    
    @Be2
    @Bs1
    public int getfileid(final int n, String lowerCase) {
        if (!this.q(n)) {
            return -1;
        }
        lowerCase = lowerCase.toLowerCase();
        final int g = Mr366.g(this.h.u[n], StringTools.b(lowerCase));
        if (!this.j(n, g)) {
            return -1;
        }
        return g;
    }
    
    public static boolean o(final js5 js5, String lowerCase, String lowerCase2) {
        if (!g(js5)) {
            return false;
        }
        lowerCase = lowerCase.toLowerCase();
        lowerCase2 = lowerCase2.toLowerCase();
        final int g = Mr366.g(js5.h.b, StringTools.b(lowerCase));
        return g >= 0 && Mr366.g(js5.h.u[g], StringTools.b(lowerCase2)) >= 0;
    }
    
    @Deprecated
    public static synchronized byte[] a(final js5 js5, final String s, final String s2) {
        return c(js5, s, s2, null, js5.i);
    }
    
    public static synchronized byte[] f(final js5 js5, final String s, final String s2) {
        return c(js5, s, s2, null, false);
    }
    
    private static synchronized byte[] c(final js5 js5, String lowerCase, String lowerCase2, final int[] array, final boolean b) {
        if (!g(js5)) {
            return null;
        }
        lowerCase = lowerCase.toLowerCase();
        lowerCase2 = lowerCase2.toLowerCase();
        final int g = Mr366.g(js5.h.b, StringTools.b(lowerCase));
        if (!js5.q(g)) {
            return null;
        }
        return js5.s(g, Mr366.g(js5.h.u[g], StringTools.b(lowerCase2)), array, b);
    }
    
    public js5(final URL url, final boolean b, final int n, final boolean b2) throws IOException {
        this(new J135(url, b2), b, n);
    }
    
    public static boolean ai(final js5 js5, String lowerCase) {
        if (!g(js5)) {
            return false;
        }
        lowerCase = lowerCase.toLowerCase();
        return js5.requestgroupdownload(Mr366.g(js5.h.b, StringTools.b(lowerCase)));
    }
    
    @Be2
    @Bs1
    public boolean grouphasdata(final int n) {
        return g(this) && this.q(n);
    }
    
    public static int al(final js5 js5, String lowerCase) {
        if (!g(js5)) {
            return 0;
        }
        lowerCase = lowerCase.toLowerCase();
        return w(js5, Mr366.g(js5.h.b, StringTools.b(lowerCase)));
    }
    
    static String av(final byte[] array) {
        final StringBuffer sb = new StringBuffer(array.length * 2 + 2);
        sb.append("0x");
        for (final byte b : array) {
            if (b >= 0 && b < 16) {
                sb.append("0" + StringTools.s(b, 16, false));
            }
            else {
                sb.append(StringTools.s(b & 0xFF, 16, false));
            }
        }
        return sb.toString();
    }
    
    static {
        js5.l = new Ls502();
        js5.r = 0;
        js5.v = 0;
        js5.y = new ConcurrentHashMap();
        js5.p = new ConcurrentHashMap();
        js5.k = false;
        js5.i = true;
        js5.o = 0;
        js5.a = false;
        js5.f = false;
    }
    
    public static synchronized int w(final js5 js5, final int n) {
        if (!js5.q(n)) {
            return 0;
        }
        if (js5.s[n] != null) {
            return 100;
        }
        return js5.n.w(n);
    }
    
    @Deprecated
    public js5(final DataInputStream dataInputStream, final boolean b, final boolean b2, final boolean b3) throws IOException {
        this(new J135(dataInputStream, b3), b, b2);
    }
    
    public js5(final S136 n, final boolean x, final int m) {
        this.h = null;
        this.w = false;
        if (m < 0 || m > 2) {
            throw new IllegalArgumentException("");
        }
        this.n = n;
        this.x = x;
        this.m = m;
    }
    
    @Be2
    @Bs1
    public int getgroupid(String lowerCase) {
        if (!g(this)) {
            return -1;
        }
        lowerCase = lowerCase.toLowerCase();
        final int g = Mr366.g(this.h.b, StringTools.b(lowerCase));
        if (!this.q(g)) {
            return -1;
        }
        return g;
    }
    
    public synchronized boolean b(final int n) {
        if (!g(this)) {
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
