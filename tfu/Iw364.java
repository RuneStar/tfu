// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Iw364
{
    public static final int d = 64;
    private static long[][] e;
    public static final int g = 512;
    private static long[] h;
    private static final String j = "\u1823\uc6e8\u87b8\u014f\u36a6\ud2f5\u796f\u9152\u60bc\u9b8e\ua30c\u7b35\u1de0\ud7c2\u2e4b\ufe57\u1577\u37e5\u9ff0\u4ada\u58c9\u290a\ub1a0\u6b85\ubd5d\u10f4\ucb3e\u0567\ue427\u418b\ua77d\u95d8\ufbee\u7c66\udd17\u479e\uca2d\ubf07\uad5a\u8333\u6302\uaa71\uc819\u49d9\uf2e3\u5b88\u9a26\u32b0\ue90f\ud580\ubecd\u3448\uff7a\u905f\u2068\u1aae\ub454\u9322\u64f1\u7312\u4008\uc3ec\udba1\u8d3d\u9700\ucf2b\u7682\ud61b\ub5af\u6a50\u45f3\u30ef\u3f55\ua2ea\u65ba\u2fc0\ude1c\ufd4d\u9275\u068a\ub2e6\u0e1f\u62d4\ua896\uf9c5\u2559\u8472\u394c\u5e78\u388c\ud1a5\ue261\ub321\u9c1e\u43c7\ufc04\u5199\u6d0d\ufadf\u7e24\u3bab\uce11\u8f4e\ub7eb\u3c81\u94f7\ub913\u2cd3\ue76e\uc403\u5644\u7fa9\u2abb\uc153\udc0b\u9d6c\u3174\uf646\uac89\u14e1\u163a\u6909\u70b6\ud0ed\ucc42\u98a4\u285c\uf886";
    protected static final int q = 10;
    protected byte[] b;
    protected int l;
    protected long[] p;
    protected long[] r;
    protected byte[] s;
    protected long[] v;
    protected int w;
    protected long[] x;
    protected long[] y;
    
    public static byte[] e(final byte[] array, final int n, final int n2) {
        byte[] array2;
        if (n > 0) {
            array2 = new byte[n2];
            for (int i = 0; i < n2; ++i) {
                array2[i] = array[n + i];
            }
        }
        else {
            array2 = array;
        }
        final Iw364 iw364 = new Iw364();
        d(iw364);
        iw364.q(array2, n2 * 8);
        final byte[] array3 = new byte[64];
        j(iw364, array3, 0);
        return array3;
    }
    
    protected static void g(final Iw364 iw364) {
        for (int i = 0, n = 0; i < 8; ++i, n += 8) {
            iw364.p[i] = ((long)iw364.b[n] << 56 ^ ((long)iw364.b[n + 1] & 0xFFL) << 48 ^ ((long)iw364.b[n + 2] & 0xFFL) << 40 ^ ((long)iw364.b[n + 3] & 0xFFL) << 32 ^ ((long)iw364.b[n + 4] & 0xFFL) << 24 ^ ((long)iw364.b[n + 5] & 0xFFL) << 16 ^ ((long)iw364.b[n + 6] & 0xFFL) << 8 ^ ((long)iw364.b[n + 7] & 0xFFL));
        }
        for (int j = 0; j < 8; ++j) {
            iw364.x[j] = (iw364.p[j] ^ (iw364.v[j] = iw364.r[j]));
        }
        for (int k = 1; k <= 10; ++k) {
            for (int l = 0; l < 8; ++l) {
                iw364.y[l] = 0L;
                for (int n2 = 0, n3 = 56; n2 < 8; ++n2, n3 -= 8) {
                    final long[] y = iw364.y;
                    final int n4 = l;
                    y[n4] ^= Iw364.e[n2][(int)(iw364.v[l - n2 & 0x7] >>> n3) & 0xFF];
                }
            }
            for (int n5 = 0; n5 < 8; ++n5) {
                iw364.v[n5] = iw364.y[n5];
            }
            final long[] v = iw364.v;
            final int n6 = 0;
            v[n6] ^= Iw364.h[k];
            for (int n7 = 0; n7 < 8; ++n7) {
                iw364.y[n7] = iw364.v[n7];
                for (int n8 = 0, n9 = 56; n8 < 8; ++n8, n9 -= 8) {
                    final long[] y2 = iw364.y;
                    final int n10 = n7;
                    y2[n10] ^= Iw364.e[n8][(int)(iw364.x[n7 - n8 & 0x7] >>> n9) & 0xFF];
                }
            }
            for (int n11 = 0; n11 < 8; ++n11) {
                iw364.x[n11] = iw364.y[n11];
            }
        }
        for (int n12 = 0; n12 < 8; ++n12) {
            final long[] r = iw364.r;
            final int n13 = n12;
            r[n13] ^= (iw364.x[n12] ^ iw364.p[n12]);
        }
    }
    
    public static void d(final Iw364 iw364) {
        for (int i = 0; i < 32; ++i) {
            iw364.s[i] = 0;
        }
        final int n = 0;
        iw364.w = n;
        iw364.l = n;
        iw364.b[0] = 0;
        for (int j = 0; j < 8; ++j) {
            iw364.r[j] = 0L;
        }
    }
    
    public void q(final byte[] array, long n) {
        int n2 = 0;
        final int n3 = 8 - ((int)n & 0x7) & 0x7;
        final int n4 = this.l & 0x7;
        long n5 = n;
        int i = 31;
        int n6 = 0;
        while (i >= 0) {
            final int n7 = n6 + ((this.s[i] & 0xFF) + ((int)n5 & 0xFF));
            this.s[i] = (byte)n7;
            n6 = n7 >>> 8;
            n5 >>>= 8;
            --i;
        }
        while (n > 8L) {
            final int n8 = (array[n2] << n3 & 0xFF) | (array[n2 + 1] & 0xFF) >>> 8 - n3;
            if (n8 < 0 || n8 >= 256) {
                throw new RuntimeException();
            }
            final byte[] b = this.b;
            final int w = this.w;
            b[w] |= (byte)(n8 >>> n4);
            ++this.w;
            this.l += 8 - n4;
            if (this.l == 512) {
                g(this);
                final int n9 = 0;
                this.w = n9;
                this.l = n9;
            }
            this.b[this.w] = (byte)(n8 << 8 - n4 & 0xFF);
            this.l += n4;
            n -= 8L;
            ++n2;
        }
        int n10;
        if (n > 0L) {
            n10 = (array[n2] << n3 & 0xFF);
            final byte[] b2 = this.b;
            final int w2 = this.w;
            b2[w2] |= (byte)(n10 >>> n4);
        }
        else {
            n10 = 0;
        }
        if (n4 + n < 8L) {
            this.l += (int)n;
        }
        else {
            ++this.w;
            this.l += 8 - n4;
            n -= 8 - n4;
            if (this.l == 512) {
                g(this);
                final int n11 = 0;
                this.w = n11;
                this.l = n11;
            }
            this.b[this.w] = (byte)(n10 << 8 - n4 & 0xFF);
            this.l += (int)n;
        }
    }
    
    public static void j(final Iw364 iw364, final byte[] array, final int n) {
        final byte[] b = iw364.b;
        final int w = iw364.w;
        b[w] |= (byte)(128 >>> (iw364.l & 0x7));
        ++iw364.w;
        if (iw364.w > 32) {
            while (iw364.w < 64) {
                iw364.b[iw364.w++] = 0;
            }
            g(iw364);
            iw364.w = 0;
        }
        while (iw364.w < 32) {
            iw364.b[iw364.w++] = 0;
        }
        System.arraycopy(iw364.s, 0, iw364.b, 32, 32);
        g(iw364);
        for (int i = 0, n2 = n; i < 8; ++i, n2 += 8) {
            final long n3 = iw364.r[i];
            array[n2] = (byte)(n3 >>> 56);
            array[n2 + 1] = (byte)(n3 >>> 48);
            array[n2 + 2] = (byte)(n3 >>> 40);
            array[n2 + 3] = (byte)(n3 >>> 32);
            array[n2 + 4] = (byte)(n3 >>> 24);
            array[n2 + 5] = (byte)(n3 >>> 16);
            array[n2 + 6] = (byte)(n3 >>> 8);
            array[n2 + 7] = (byte)n3;
        }
    }
    
    static {
        Iw364.e = new long[8][256];
        Iw364.h = new long[11];
        for (int i = 0; i < 256; ++i) {
            final char char1 = "\u1823\uc6e8\u87b8\u014f\u36a6\ud2f5\u796f\u9152\u60bc\u9b8e\ua30c\u7b35\u1de0\ud7c2\u2e4b\ufe57\u1577\u37e5\u9ff0\u4ada\u58c9\u290a\ub1a0\u6b85\ubd5d\u10f4\ucb3e\u0567\ue427\u418b\ua77d\u95d8\ufbee\u7c66\udd17\u479e\uca2d\ubf07\uad5a\u8333\u6302\uaa71\uc819\u49d9\uf2e3\u5b88\u9a26\u32b0\ue90f\ud580\ubecd\u3448\uff7a\u905f\u2068\u1aae\ub454\u9322\u64f1\u7312\u4008\uc3ec\udba1\u8d3d\u9700\ucf2b\u7682\ud61b\ub5af\u6a50\u45f3\u30ef\u3f55\ua2ea\u65ba\u2fc0\ude1c\ufd4d\u9275\u068a\ub2e6\u0e1f\u62d4\ua896\uf9c5\u2559\u8472\u394c\u5e78\u388c\ud1a5\ue261\ub321\u9c1e\u43c7\ufc04\u5199\u6d0d\ufadf\u7e24\u3bab\uce11\u8f4e\ub7eb\u3c81\u94f7\ub913\u2cd3\ue76e\uc403\u5644\u7fa9\u2abb\uc153\udc0b\u9d6c\u3174\uf646\uac89\u14e1\u163a\u6909\u70b6\ud0ed\ucc42\u98a4\u285c\uf886".charAt(i / 2);
            final long n = ((i & 0x1) == 0x0) ? (char1 >>> 8) : ((long)(char1 & '\u00ff'));
            long n2 = n << 1;
            if (n2 >= 256L) {
                n2 ^= 0x11DL;
            }
            long n3 = n2 << 1;
            if (n3 >= 256L) {
                n3 ^= 0x11DL;
            }
            final long n4 = n3 ^ n;
            long n5 = n3 << 1;
            if (n5 >= 256L) {
                n5 ^= 0x11DL;
            }
            Iw364.e[0][i] = (n << 56 | n << 48 | n3 << 40 | n << 32 | n5 << 24 | n4 << 16 | n2 << 8 | (n5 ^ n));
            for (int j = 1; j < 8; ++j) {
                Iw364.e[j][i] = (Iw364.e[j - 1][i] >>> 8 | Iw364.e[j - 1][i] << 56);
            }
        }
        Iw364.h[0] = 0L;
        for (int k = 1; k <= 10; ++k) {
            final int n6 = 8 * (k - 1);
            Iw364.h[k] = ((Iw364.e[0][n6] & 0xFF00000000000000L) ^ (Iw364.e[1][n6 + 1] & 0xFF000000000000L) ^ (Iw364.e[2][n6 + 2] & 0xFF0000000000L) ^ (Iw364.e[3][n6 + 3] & 0xFF00000000L) ^ (Iw364.e[4][n6 + 4] & 0xFF000000L) ^ (Iw364.e[5][n6 + 5] & 0xFF0000L) ^ (Iw364.e[6][n6 + 6] & 0xFF00L) ^ (Iw364.e[7][n6 + 7] & 0xFFL));
        }
    }
    
    public Iw364() {
        this.s = new byte[32];
        this.b = new byte[64];
        this.l = 0;
        this.w = 0;
        this.r = new long[8];
        this.v = new long[8];
        this.y = new long[8];
        this.p = new long[8];
        this.x = new long[8];
    }
}
