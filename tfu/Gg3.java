/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.J173;
import java.math.BigInteger;
import java.util.UUID;
import tfu.Ln265;
import tfu.Mj383;
import tfu.Mv477;

public class Gg3
extends Ln265 {
    public static final int b = 100;
    protected static final boolean e = true;
    private static final char[] h;
    public static final int l = 5000;
    private static final int p = -306674912;
    public static final int s = 50;
    private static final long u = -3932672073523589310L;
    public static final int w = 30000;
    public static long[] x;
    private static int[] y;
    public byte[] r;
    public int v;

    public static String bk(Gg3 gg3) {
        int n = gg3.v;
        while (gg3.r[gg3.v++] != 0) {
        }
        int n2 = gg3.v - n - 1;
        if (n2 == 0) {
            return "";
        }
        return J173.s(gg3.r, n, n2);
    }

    public static int m(byte[] arrby, int n) {
        return Gg3.t(arrby, 0, n);
    }

    public Gg3(int n) {
        this.r = Mv477.d(n);
        this.v = 0;
    }

    public Gg3(byte[] arrby) {
        this.r = arrby;
        this.v = 0;
    }

    public Gg3(byte[] arrby, int n) {
        this.r = arrby;
        this.v = n;
    }

    public static void n(Gg3 gg3) {
        if (gg3.r != null) {
            Mv477.q(gg3.r);
        }
        gg3.r = null;
    }

    public static void k(Gg3 gg3, int n) {
        gg3.r[gg3.v++] = (byte)n;
    }

    public static void i(Gg3 gg3, int n) {
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)n;
    }

    public static void f(Gg3 gg3, int n) {
        gg3.r[gg3.v++] = (byte)n;
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)(n >> 16);
        gg3.r[gg3.v++] = (byte)(n >> 24);
    }

    public static void ag(Gg3 gg3, long l) {
        gg3.r[gg3.v++] = (byte)(l >> 56);
        gg3.r[gg3.v++] = (byte)(l >> 48);
        gg3.r[gg3.v++] = (byte)(l >> 40);
        gg3.r[gg3.v++] = (byte)(l >> 32);
        gg3.r[gg3.v++] = (byte)(l >> 24);
        gg3.r[gg3.v++] = (byte)(l >> 16);
        gg3.r[gg3.v++] = (byte)(l >> 8);
        gg3.r[gg3.v++] = (byte)l;
    }

    public static int al(String string) {
        return string.length() + 1;
    }

    public static void ai(Gg3 gg3, double d) {
        Gg3.ag(gg3, Double.doubleToRawLongBits(d));
    }

    public void af(String string) {
        int n = string.indexOf(0);
        if (n >= 0) {
            throw new IllegalArgumentException("NUL character at " + n + " - cannot pjstr");
        }
        this.v += J173.e(string, 0, string.length(), this.r, this.v);
        this.r[this.v++] = 0;
    }

    public static int av(String string) {
        return string.length() + 2;
    }

    public static void aq(Gg3 gg3, float f) {
        int n = Float.floatToIntBits(f);
        Gg3.a(gg3, n);
    }

    public static void ao(Gg3 gg3, CharSequence charSequence) {
        int n = Mj383.g(charSequence);
        gg3.r[gg3.v++] = 0;
        Gg3.ab(gg3, n);
        gg3.v += Mj383.d(gg3.r, gg3.v, charSequence);
    }

    public static void aa(Gg3 gg3, byte[] arrby, int n, int n2) {
        for (int i = n; i < n + n2; ++i) {
            gg3.r[gg3.v++] = arrby[i];
        }
    }

    public static void an(Gg3 gg3, Gg3 gg32) {
        Gg3.aa(gg3, gg32.r, 0, gg32.v);
    }

    public static void am(Gg3 gg3, int n) {
        gg3.r[gg3.v - n - 4] = (byte)(n >> 24);
        gg3.r[gg3.v - n - 3] = (byte)(n >> 16);
        gg3.r[gg3.v - n - 2] = (byte)(n >> 8);
        gg3.r[gg3.v - n - 1] = (byte)n;
    }

    public static void a(Gg3 gg3, int n) {
        gg3.r[gg3.v++] = (byte)(n >> 24);
        gg3.r[gg3.v++] = (byte)(n >> 16);
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)n;
    }

    public static void ac(Gg3 gg3, int n) {
        gg3.r[gg3.v - n - 1] = (byte)n;
    }

    public void at(int n) {
        if (n >= 0 && n < 128) {
            Gg3.k(this, n);
            return;
        }
        if (n >= 0 && n < 32768) {
            Gg3.i(this, 32768 + n);
            return;
        }
        throw new IllegalArgumentException("psmarts out of range - val:" + n);
    }

    public static void ab(Gg3 gg3, int n) {
        if ((n & 0xFFFFFF80) != 0) {
            if ((n & 0xFFFFC000) != 0) {
                if ((n & 0xFFE00000) != 0) {
                    if ((n & 0xF0000000) != 0) {
                        Gg3.k(gg3, n >>> 28 | 0x80);
                    }
                    Gg3.k(gg3, n >>> 21 | 0x80);
                }
                Gg3.k(gg3, n >>> 14 | 0x80);
            }
            Gg3.k(gg3, n >>> 7 | 0x80);
        }
        Gg3.k(gg3, n & 0x7F);
    }

    public static void aw(Gg3 gg3, int n) {
        int n2;
        int n3 = 6;
        if (n < 0) {
            n = -n;
            n2 = 64;
        } else {
            n2 = 0;
        }
        do {
            int n4;
            int n5 = n > (n4 = (1 << n3) - 1) ? 128 : 0;
            Gg3.k(gg3, n5 | n & n4 | n2);
            if ((n >>= n3) <= 0) {
                return;
            }
            n3 = 7;
            n2 = 0;
        } while (true);
    }

    public static int ar(Gg3 gg3) {
        return gg3.r[gg3.v++] & 0xFF;
    }

    public static int aj(Gg3 gg3) {
        gg3.v += 2;
        return ((gg3.r[gg3.v - 1] & 0xFF) << 8) + (gg3.r[gg3.v - 2] & 0xFF);
    }

    public static int ak(Gg3 gg3) {
        gg3.v += 2;
        int n = ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
        if (n > 32767) {
            n -= 65536;
        }
        return n;
    }

    public String bp() {
        byte by;
        if ((by = this.r[this.v++]) != 0) {
            throw new IllegalStateException("Bad version number in gUTF8");
        }
        int n = Gg3.bn(this);
        if (n + this.v > this.r.length) {
            throw new IllegalStateException("Length of string is longer than available data");
        }
        String string = Mj383.j(this.r, this.v, n);
        this.v += n;
        return string;
    }

    public static int bd(Gg3 gg3) {
        gg3.v += 4;
        return ((gg3.r[gg3.v - 4] & 0xFF) << 24) + ((gg3.r[gg3.v - 3] & 0xFF) << 16) + ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
    }

    public static int bm(Gg3 gg3) {
        gg3.v += 4;
        return ((gg3.r[gg3.v - 1] & 0xFF) << 24) + ((gg3.r[gg3.v - 2] & 0xFF) << 16) + ((gg3.r[gg3.v - 3] & 0xFF) << 8) + (gg3.r[gg3.v - 4] & 0xFF);
    }

    public static long bq(Gg3 gg3) {
        long l = (long)Gg3.bd(gg3) & 0xFFFFFFFFL;
        long l2 = (long)Gg3.bd(gg3) & 0xFFFFFFFFL;
        return (l << 32) + l2;
    }

    public UUID bo() {
        long l = Gg3.bq(this);
        long l2 = Gg3.bq(this);
        return new UUID(l, l2);
    }

    public static float bl(Gg3 gg3) {
        return Float.intBitsToFloat(Gg3.bd(gg3));
    }

    public static float bw(Gg3 gg3) {
        return Float.intBitsToFloat(Gg3.bm(gg3));
    }

    public void ap(String string) {
        int n = string.indexOf(0);
        if (n >= 0) {
            throw new IllegalArgumentException("NUL character at " + n + " - cannot pjstr2");
        }
        this.r[this.v++] = 0;
        this.v += J173.e(string, 0, string.length(), this.r, this.v);
        this.r[this.v++] = 0;
    }

    public String bh() {
        byte by;
        if ((by = this.r[this.v++]) != 0) {
            throw new IllegalStateException("Bad version number in gjstr2");
        }
        int n = this.v;
        while (this.r[this.v++] != 0) {
        }
        int n2 = this.v - n - 1;
        if (n2 == 0) {
            return "";
        }
        return J173.s(this.r, n, n2);
    }

    public static void bx(Gg3 gg3, byte[] arrby, int n, int n2) {
        for (int i = n; i < n + n2; ++i) {
            arrby[i] = gg3.r[gg3.v++];
        }
    }

    public static int br(Gg3 gg3) {
        int n = gg3.r[gg3.v] & 0xFF;
        if (n < 128) {
            return Gg3.ar(gg3);
        }
        return Gg3.au(gg3) - 32768;
    }

    public static int bv(Gg3 gg3) {
        if (gg3.r[gg3.v] < 0) {
            return Gg3.bd(gg3) & Integer.MAX_VALUE;
        }
        return Gg3.au(gg3);
    }

    public static int bf(Gg3 gg3) {
        if (gg3.r[gg3.v] < 0) {
            return Gg3.bd(gg3) & Integer.MAX_VALUE;
        }
        int n = Gg3.au(gg3);
        if (n == 32767) {
            return -1;
        }
        return n;
    }

    public static byte ax(Gg3 gg3) {
        return gg3.r[gg3.v++];
    }

    public static int bg(Gg3 gg3) {
        int n = Gg3.ar(gg3);
        int n2 = n & 0x3F;
        int n3 = n & 0x40;
        int n4 = 6;
        while (n > 127) {
            n = Gg3.ar(gg3);
            n2 |= (n & 0x7F) << n4;
            n4 += 7;
        }
        return n3 == 0 ? n2 : -n2;
    }

    public static void bu(Gg3 gg3, int[] arrn) {
        int n = gg3.v / 8;
        gg3.v = 0;
        for (int i = 0; i < n; ++i) {
            int n2 = Gg3.bd(gg3);
            int n3 = Gg3.bd(gg3);
            int n4 = 0;
            int n5 = -1640531527;
            int n6 = 32;
            while (n6-- > 0) {
                n3 += ((n2 += (n3 << 4 ^ n3 >>> 5) + n3 ^ n4 + arrn[n4 & 3]) << 4 ^ n2 >>> 5) + n2 ^ (n4 += n5) + arrn[n4 >>> 11 & 3];
            }
            gg3.v -= 8;
            Gg3.a(gg3, n2);
            Gg3.a(gg3, n3);
        }
    }

    public static void bb(Gg3 gg3, int[] arrn) {
        int n = gg3.v / 8;
        gg3.v = 0;
        for (int i = 0; i < n; ++i) {
            int n2 = Gg3.bd(gg3);
            int n3 = Gg3.bd(gg3);
            int n4 = -957401312;
            int n5 = -1640531527;
            int n6 = 32;
            while (n6-- > 0) {
                n2 -= ((n3 -= (n2 << 4 ^ n2 >>> 5) + n2 ^ n4 + arrn[n4 >>> 11 & 3]) << 4 ^ n3 >>> 5) + n3 ^ (n4 -= n5) + arrn[n4 & 3];
            }
            gg3.v -= 8;
            Gg3.a(gg3, n2);
            Gg3.a(gg3, n3);
        }
    }

    public static void ba(Gg3 gg3, int[] arrn, int n, int n2) {
        int n3 = gg3.v;
        gg3.v = n;
        int n4 = (n2 - n) / 8;
        for (int i = 0; i < n4; ++i) {
            int n5 = Gg3.bd(gg3);
            int n6 = Gg3.bd(gg3);
            int n7 = 0;
            int n8 = -1640531527;
            int n9 = 32;
            while (n9-- > 0) {
                n6 += ((n5 += (n6 << 4 ^ n6 >>> 5) + n6 ^ n7 + arrn[n7 & 3]) << 4 ^ n5 >>> 5) + n5 ^ (n7 += n8) + arrn[n7 >>> 11 & 3];
            }
            gg3.v -= 8;
            Gg3.a(gg3, n5);
            Gg3.a(gg3, n6);
        }
        gg3.v = n3;
    }

    public static void bi(Gg3 gg3, int[] arrn, int n, int n2) {
        int n3 = gg3.v;
        gg3.v = n;
        int n4 = (n2 - n) / 8;
        for (int i = 0; i < n4; ++i) {
            int n5 = Gg3.bd(gg3);
            int n6 = Gg3.bd(gg3);
            int n7 = -957401312;
            int n8 = -1640531527;
            int n9 = 32;
            while (n9-- > 0) {
                n5 -= ((n6 -= (n5 << 4 ^ n5 >>> 5) + n5 ^ n7 + arrn[n7 >>> 11 & 3]) << 4 ^ n6 >>> 5) + n6 ^ (n7 -= n8) + arrn[n7 & 3];
            }
            gg3.v -= 8;
            Gg3.a(gg3, n5);
            Gg3.a(gg3, n6);
        }
        gg3.v = n3;
    }

    public void bt(BigInteger bigInteger, BigInteger bigInteger2) {
        int n = this.v;
        this.v = 0;
        byte[] arrby = new byte[n];
        Gg3.bx(this, arrby, 0, n);
        BigInteger bigInteger3 = new BigInteger(arrby);
        BigInteger bigInteger4 = bigInteger3.modPow(bigInteger, bigInteger2);
        byte[] arrby2 = bigInteger4.toByteArray();
        this.v = 0;
        Gg3.i(this, arrby2.length);
        Gg3.aa(this, arrby2, 0, arrby2.length);
    }

    static {
        int n;
        h = new char[]{'\u0000', '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        y = new int[256];
        for (int i = 0; i < 256; ++i) {
            int n2 = i;
            for (n = 0; n < 8; ++n) {
                if ((n2 & 1) == 1) {
                    n2 = n2 >>> 1 ^ 0xEDB88320;
                    continue;
                }
                n2 >>>= 1;
            }
            Gg3.y[i] = n2;
        }
        x = new long[256];
        for (n = 0; n < 256; ++n) {
            long l = n;
            for (int i = 0; i < 8; ++i) {
                if ((l & 1L) == 1L) {
                    l = l >>> 1 ^ 0xC96C5795D7870F42L;
                    continue;
                }
                l >>>= 1;
            }
            Gg3.x[n] = l;
        }
    }

    public static void c(Gg3 gg3, long l) {
        gg3.r[gg3.v++] = (byte)(l >> 32);
        gg3.r[gg3.v++] = (byte)(l >> 24);
        gg3.r[gg3.v++] = (byte)(l >> 16);
        gg3.r[gg3.v++] = (byte)(l >> 8);
        gg3.r[gg3.v++] = (byte)l;
    }

    public static int bn(Gg3 gg3) {
        byte by = gg3.r[gg3.v++];
        int n = 0;
        while (by < 0) {
            n = (n | by & 0x7F) << 7;
            by = gg3.r[gg3.v++];
        }
        return n | by;
    }

    public static String bj(Gg3 gg3) {
        if (gg3.r[gg3.v] == 0) {
            ++gg3.v;
            return null;
        }
        return Gg3.bk(gg3);
    }

    public static int au(Gg3 gg3) {
        gg3.v += 2;
        return ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
    }

    public static int by(Gg3 gg3) {
        int n = gg3.r[gg3.v] & 0xFF;
        if (n < 128) {
            return Gg3.ar(gg3) - 64;
        }
        return Gg3.au(gg3) - 49152;
    }

    public static int bz(Gg3 gg3, int n) {
        int n2 = Gg3.t(gg3.r, n, gg3.v);
        Gg3.a(gg3, n2);
        return n2;
    }

    public static int ay(Gg3 gg3) {
        gg3.v += 3;
        return ((gg3.r[gg3.v - 3] & 0xFF) << 16) + ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
    }

    public static void as(Gg3 gg3, int n) {
        gg3.r[gg3.v - n - 2] = (byte)(n >> 8);
        gg3.r[gg3.v - n - 1] = (byte)n;
    }

    public static void o(Gg3 gg3, int n) {
        gg3.r[gg3.v++] = (byte)(n >> 16);
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)n;
    }

    public static int t(byte[] arrby, int n, int n2) {
        int n3 = -1;
        for (int i = n; i < n2; ++i) {
            n3 = n3 >>> 8 ^ y[(n3 ^ arrby[i]) & 0xFF];
        }
        return n3 ^= 0xFFFFFFFF;
    }

    public static int ad(Gg3 gg3) {
        gg3.v += 3;
        int n = ((gg3.r[gg3.v - 3] & 0xFF) << 16) + ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
        if (n > 8388607) {
            n -= 16777216;
        }
        return n;
    }

    public static boolean bc(Gg3 gg3) {
        int n;
        gg3.v -= 4;
        int n2 = Gg3.t(gg3.r, 0, gg3.v);
        return n2 == (n = Gg3.bd(gg3));
    }
}

