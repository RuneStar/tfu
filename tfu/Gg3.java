// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.math.BigInteger;
import java.util.UUID;
import com.jagex.core.stringtools.general.J173;

public class Gg3 extends Ln265
{
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
    
    public static String bk(final Gg3 gg3) {
        final int v = gg3.v;
        while (gg3.r[gg3.v++] != 0) {}
        final int n = gg3.v - v - 1;
        if (n == 0) {
            return "";
        }
        return J173.s(gg3.r, v, n);
    }
    
    public static int m(final byte[] array, final int n) {
        return t(array, 0, n);
    }
    
    public Gg3(final int n) {
        this.r = Mv477.d(n);
        this.v = 0;
    }
    
    public Gg3(final byte[] r) {
        this.r = r;
        this.v = 0;
    }
    
    public Gg3(final byte[] r, final int v) {
        this.r = r;
        this.v = v;
    }
    
    public static void n(final Gg3 gg3) {
        if (gg3.r != null) {
            Mv477.q(gg3.r);
        }
        gg3.r = null;
    }
    
    public static void k(final Gg3 gg3, final int n) {
        gg3.r[gg3.v++] = (byte)n;
    }
    
    public static void i(final Gg3 gg3, final int n) {
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)n;
    }
    
    public static void f(final Gg3 gg3, final int n) {
        gg3.r[gg3.v++] = (byte)n;
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)(n >> 16);
        gg3.r[gg3.v++] = (byte)(n >> 24);
    }
    
    public static void ag(final Gg3 gg3, final long n) {
        gg3.r[gg3.v++] = (byte)(n >> 56);
        gg3.r[gg3.v++] = (byte)(n >> 48);
        gg3.r[gg3.v++] = (byte)(n >> 40);
        gg3.r[gg3.v++] = (byte)(n >> 32);
        gg3.r[gg3.v++] = (byte)(n >> 24);
        gg3.r[gg3.v++] = (byte)(n >> 16);
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)n;
    }
    
    public static int al(final String s) {
        return s.length() + 1;
    }
    
    public static void ai(final Gg3 gg3, final double n) {
        ag(gg3, Double.doubleToRawLongBits(n));
    }
    
    public void af(final String s) {
        final int index = s.indexOf(0);
        if (index >= 0) {
            throw new IllegalArgumentException("NUL character at " + index + " - cannot pjstr");
        }
        this.v += J173.e(s, 0, s.length(), this.r, this.v);
        this.r[this.v++] = 0;
    }
    
    public static int av(final String s) {
        return s.length() + 2;
    }
    
    public static void aq(final Gg3 gg3, final float value) {
        a(gg3, Float.floatToIntBits(value));
    }
    
    public static void ao(final Gg3 gg3, final CharSequence charSequence) {
        final int g = Mj383.g(charSequence);
        gg3.r[gg3.v++] = 0;
        ab(gg3, g);
        gg3.v += Mj383.d(gg3.r, gg3.v, charSequence);
    }
    
    public static void aa(final Gg3 gg3, final byte[] array, final int n, final int n2) {
        for (int i = n; i < n + n2; ++i) {
            gg3.r[gg3.v++] = array[i];
        }
    }
    
    public static void an(final Gg3 gg3, final Gg3 gg4) {
        aa(gg3, gg4.r, 0, gg4.v);
    }
    
    public static void am(final Gg3 gg3, final int n) {
        gg3.r[gg3.v - n - 4] = (byte)(n >> 24);
        gg3.r[gg3.v - n - 3] = (byte)(n >> 16);
        gg3.r[gg3.v - n - 2] = (byte)(n >> 8);
        gg3.r[gg3.v - n - 1] = (byte)n;
    }
    
    public static void a(final Gg3 gg3, final int n) {
        gg3.r[gg3.v++] = (byte)(n >> 24);
        gg3.r[gg3.v++] = (byte)(n >> 16);
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)n;
    }
    
    public static void ac(final Gg3 gg3, final int n) {
        gg3.r[gg3.v - n - 1] = (byte)n;
    }
    
    public void at(final int i) {
        if (i >= 0 && i < 128) {
            k(this, i);
            return;
        }
        if (i >= 0 && i < 32768) {
            i(this, 32768 + i);
            return;
        }
        throw new IllegalArgumentException("psmarts out of range - val:" + i);
    }
    
    public static void ab(final Gg3 gg3, final int n) {
        if ((n & 0xFFFFFF80) != 0x0) {
            if ((n & 0xFFFFC000) != 0x0) {
                if ((n & 0xFFE00000) != 0x0) {
                    if ((n & 0xF0000000) != 0x0) {
                        k(gg3, n >>> 28 | 0x80);
                    }
                    k(gg3, n >>> 21 | 0x80);
                }
                k(gg3, n >>> 14 | 0x80);
            }
            k(gg3, n >>> 7 | 0x80);
        }
        k(gg3, n & 0x7F);
    }
    
    public static void aw(final Gg3 gg3, int n) {
        int n2 = 6;
        int n3;
        if (n < 0) {
            n = -n;
            n3 = 64;
        }
        else {
            n3 = 0;
        }
        while (true) {
            final int n4 = (1 << n2) - 1;
            k(gg3, ((n > n4) ? 128 : 0) | (n & n4) | n3);
            n >>= n2;
            if (n <= 0) {
                break;
            }
            n2 = 7;
            n3 = 0;
        }
    }
    
    public static int ar(final Gg3 gg3) {
        return gg3.r[gg3.v++] & 0xFF;
    }
    
    public static int aj(final Gg3 gg3) {
        gg3.v += 2;
        return ((gg3.r[gg3.v - 1] & 0xFF) << 8) + (gg3.r[gg3.v - 2] & 0xFF);
    }
    
    public static int ak(final Gg3 gg3) {
        gg3.v += 2;
        int n = ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
        if (n > 32767) {
            n -= 65536;
        }
        return n;
    }
    
    public String bp() {
        if (this.r[this.v++] != 0) {
            throw new IllegalStateException("Bad version number in gUTF8");
        }
        final int bn = bn(this);
        if (bn + this.v > this.r.length) {
            throw new IllegalStateException("Length of string is longer than available data");
        }
        final String j = Mj383.j(this.r, this.v, bn);
        this.v += bn;
        return j;
    }
    
    public static int bd(final Gg3 gg3) {
        gg3.v += 4;
        return ((gg3.r[gg3.v - 4] & 0xFF) << 24) + ((gg3.r[gg3.v - 3] & 0xFF) << 16) + ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
    }
    
    public static int bm(final Gg3 gg3) {
        gg3.v += 4;
        return ((gg3.r[gg3.v - 1] & 0xFF) << 24) + ((gg3.r[gg3.v - 2] & 0xFF) << 16) + ((gg3.r[gg3.v - 3] & 0xFF) << 8) + (gg3.r[gg3.v - 4] & 0xFF);
    }
    
    public static long bq(final Gg3 gg3) {
        return (((long)bd(gg3) & 0xFFFFFFFFL) << 32) + ((long)bd(gg3) & 0xFFFFFFFFL);
    }
    
    public UUID bo() {
        return new UUID(bq(this), bq(this));
    }
    
    public static float bl(final Gg3 gg3) {
        return Float.intBitsToFloat(bd(gg3));
    }
    
    public static float bw(final Gg3 gg3) {
        return Float.intBitsToFloat(bm(gg3));
    }
    
    public void ap(final String s) {
        final int index = s.indexOf(0);
        if (index >= 0) {
            throw new IllegalArgumentException("NUL character at " + index + " - cannot pjstr2");
        }
        this.r[this.v++] = 0;
        this.v += J173.e(s, 0, s.length(), this.r, this.v);
        this.r[this.v++] = 0;
    }
    
    public String bh() {
        if (this.r[this.v++] != 0) {
            throw new IllegalStateException("Bad version number in gjstr2");
        }
        final int v = this.v;
        while (this.r[this.v++] != 0) {}
        final int n = this.v - v - 1;
        if (n == 0) {
            return "";
        }
        return J173.s(this.r, v, n);
    }
    
    public static void bx(final Gg3 gg3, final byte[] array, final int n, final int n2) {
        for (int i = n; i < n + n2; ++i) {
            array[i] = gg3.r[gg3.v++];
        }
    }
    
    public static int br(final Gg3 gg3) {
        if ((gg3.r[gg3.v] & 0xFF) < 128) {
            return ar(gg3);
        }
        return au(gg3) - 32768;
    }
    
    public static int bv(final Gg3 gg3) {
        if (gg3.r[gg3.v] < 0) {
            return bd(gg3) & Integer.MAX_VALUE;
        }
        return au(gg3);
    }
    
    public static int bf(final Gg3 gg3) {
        if (gg3.r[gg3.v] < 0) {
            return bd(gg3) & Integer.MAX_VALUE;
        }
        final int au = au(gg3);
        if (au == 32767) {
            return -1;
        }
        return au;
    }
    
    public static byte ax(final Gg3 gg3) {
        return gg3.r[gg3.v++];
    }
    
    public static int bg(final Gg3 gg3) {
        int i = ar(gg3);
        int n = i & 0x3F;
        final int n2 = i & 0x40;
        for (int n3 = 6; i > 127; i = ar(gg3), n |= (i & 0x7F) << n3, n3 += 7) {}
        return (n2 == 0) ? n : (-n);
    }
    
    public static void bu(final Gg3 gg3, final int[] array) {
        final int n = gg3.v / 8;
        gg3.v = 0;
        for (int i = 0; i < n; ++i) {
            int bd = bd(gg3);
            int bd2 = bd(gg3);
            int n2 = 0;
            final int n3 = -1640531527;
            int n4 = 32;
            while (n4-- > 0) {
                bd += ((bd2 << 4 ^ bd2 >>> 5) + bd2 ^ n2 + array[n2 & 0x3]);
                n2 += n3;
                bd2 += ((bd << 4 ^ bd >>> 5) + bd ^ n2 + array[n2 >>> 11 & 0x3]);
            }
            gg3.v -= 8;
            a(gg3, bd);
            a(gg3, bd2);
        }
    }
    
    public static void bb(final Gg3 gg3, final int[] array) {
        final int n = gg3.v / 8;
        gg3.v = 0;
        for (int i = 0; i < n; ++i) {
            int bd = bd(gg3);
            int bd2 = bd(gg3);
            int n2 = -957401312;
            final int n3 = -1640531527;
            int n4 = 32;
            while (n4-- > 0) {
                bd2 -= ((bd << 4 ^ bd >>> 5) + bd ^ n2 + array[n2 >>> 11 & 0x3]);
                n2 -= n3;
                bd -= ((bd2 << 4 ^ bd2 >>> 5) + bd2 ^ n2 + array[n2 & 0x3]);
            }
            gg3.v -= 8;
            a(gg3, bd);
            a(gg3, bd2);
        }
    }
    
    public static void ba(final Gg3 gg3, final int[] array, final int v, final int n) {
        final int v2 = gg3.v;
        gg3.v = v;
        for (int n2 = (n - v) / 8, i = 0; i < n2; ++i) {
            int bd = bd(gg3);
            int bd2 = bd(gg3);
            int n3 = 0;
            final int n4 = -1640531527;
            int n5 = 32;
            while (n5-- > 0) {
                bd += ((bd2 << 4 ^ bd2 >>> 5) + bd2 ^ n3 + array[n3 & 0x3]);
                n3 += n4;
                bd2 += ((bd << 4 ^ bd >>> 5) + bd ^ n3 + array[n3 >>> 11 & 0x3]);
            }
            gg3.v -= 8;
            a(gg3, bd);
            a(gg3, bd2);
        }
        gg3.v = v2;
    }
    
    public static void bi(final Gg3 gg3, final int[] array, final int v, final int n) {
        final int v2 = gg3.v;
        gg3.v = v;
        for (int n2 = (n - v) / 8, i = 0; i < n2; ++i) {
            int bd = bd(gg3);
            int bd2 = bd(gg3);
            int n3 = -957401312;
            final int n4 = -1640531527;
            int n5 = 32;
            while (n5-- > 0) {
                bd2 -= ((bd << 4 ^ bd >>> 5) + bd ^ n3 + array[n3 >>> 11 & 0x3]);
                n3 -= n4;
                bd -= ((bd2 << 4 ^ bd2 >>> 5) + bd2 ^ n3 + array[n3 & 0x3]);
            }
            gg3.v -= 8;
            a(gg3, bd);
            a(gg3, bd2);
        }
        gg3.v = v2;
    }
    
    public void bt(final BigInteger exponent, final BigInteger m) {
        final int v = this.v;
        this.v = 0;
        final byte[] val = new byte[v];
        bx(this, val, 0, v);
        final byte[] byteArray = new BigInteger(val).modPow(exponent, m).toByteArray();
        this.v = 0;
        i(this, byteArray.length);
        aa(this, byteArray, 0, byteArray.length);
    }
    
    static {
        h = new char[] { '\0', '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        Gg3.y = new int[256];
        for (int i = 0; i < 256; ++i) {
            int n = i;
            for (int j = 0; j < 8; ++j) {
                if ((n & 0x1) == 0x1) {
                    n = (n >>> 1 ^ 0xEDB88320);
                }
                else {
                    n >>>= 1;
                }
            }
            Gg3.y[i] = n;
        }
        Gg3.x = new long[256];
        for (int k = 0; k < 256; ++k) {
            long n2 = k;
            for (int l = 0; l < 8; ++l) {
                if ((n2 & 0x1L) == 0x1L) {
                    n2 = (n2 >>> 1 ^ 0xC96C5795D7870F42L);
                }
                else {
                    n2 >>>= 1;
                }
            }
            Gg3.x[k] = n2;
        }
    }
    
    public static void c(final Gg3 gg3, final long n) {
        gg3.r[gg3.v++] = (byte)(n >> 32);
        gg3.r[gg3.v++] = (byte)(n >> 24);
        gg3.r[gg3.v++] = (byte)(n >> 16);
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)n;
    }
    
    public static int bn(final Gg3 gg3) {
        byte b = gg3.r[gg3.v++];
        int n = 0;
        while (b < 0) {
            n = (n | (b & 0x7F)) << 7;
            b = gg3.r[gg3.v++];
        }
        return n | b;
    }
    
    public static String bj(final Gg3 gg3) {
        if (gg3.r[gg3.v] == 0) {
            ++gg3.v;
            return null;
        }
        return bk(gg3);
    }
    
    public static int au(final Gg3 gg3) {
        gg3.v += 2;
        return ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
    }
    
    public static int by(final Gg3 gg3) {
        if ((gg3.r[gg3.v] & 0xFF) < 128) {
            return ar(gg3) - 64;
        }
        return au(gg3) - 49152;
    }
    
    public static int bz(final Gg3 gg3, final int n) {
        final int t = t(gg3.r, n, gg3.v);
        a(gg3, t);
        return t;
    }
    
    public static int ay(final Gg3 gg3) {
        gg3.v += 3;
        return ((gg3.r[gg3.v - 3] & 0xFF) << 16) + ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
    }
    
    public static void as(final Gg3 gg3, final int n) {
        gg3.r[gg3.v - n - 2] = (byte)(n >> 8);
        gg3.r[gg3.v - n - 1] = (byte)n;
    }
    
    public static void o(final Gg3 gg3, final int n) {
        gg3.r[gg3.v++] = (byte)(n >> 16);
        gg3.r[gg3.v++] = (byte)(n >> 8);
        gg3.r[gg3.v++] = (byte)n;
    }
    
    public static int t(final byte[] array, final int n, final int n2) {
        int n3 = -1;
        for (int i = n; i < n2; ++i) {
            n3 = (n3 >>> 8 ^ Gg3.y[(n3 ^ array[i]) & 0xFF]);
        }
        return ~n3;
    }
    
    public static int ad(final Gg3 gg3) {
        gg3.v += 3;
        int n = ((gg3.r[gg3.v - 3] & 0xFF) << 16) + ((gg3.r[gg3.v - 2] & 0xFF) << 8) + (gg3.r[gg3.v - 1] & 0xFF);
        if (n > 8388607) {
            n -= 16777216;
        }
        return n;
    }
    
    public static boolean bc(final Gg3 gg3) {
        gg3.v -= 4;
        return t(gg3.r, 0, gg3.v) == bd(gg3);
    }
}
