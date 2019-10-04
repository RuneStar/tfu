/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Iw364 {
    public static final int d = 64;
    private static long[][] e;
    public static final int g = 512;
    private static long[] h;
    private static final String j = "\u1823\uc6e8\u87b8\u014f\u36a6\ud2f5\u796f\u9152\u60bc\u9b8e\ua30c\u7b35\u1de0\ud7c2\u2e4b\ufe57\u1577\u37e5\u9ff0\u4ada\u58c9\u290a\ub1a0\u6b85\ubd5d\u10f4\ucb3e\u0567\ue427\u418b\ua77d\u95d8\ufbee\u7c66\udd17\u479e\uca2d\ubf07\uad5a\u8333\u6302\uaa71\uc819\u49d9\uf2e3\u5b88\u9a26\u32b0\ue90f\ud580\ubecd\u3448\uff7a\u905f\u2068\u1aae\ub454\u9322\u64f1\u7312\u4008\uc3ec\udba1\u8d3d\u9700\ucf2b\u7682\ud61b\ub5af\u6a50\u45f3\u30ef\u3f55\ua2ea\u65ba\u2fc0\ude1c\ufd4d\u9275\u068a\ub2e6\u0e1f\u62d4\ua896\uf9c5\u2559\u8472\u394c\u5e78\u388c\ud1a5\ue261\ub321\u9c1e\u43c7\ufc04\u5199\u6d0d\ufadf\u7e24\u3bab\uce11\u8f4e\ub7eb\u3c81\u94f7\ub913\u2cd3\ue76e\uc403\u5644\u7fa9\u2abb\uc153\udc0b\u9d6c\u3174\uf646\uac89\u14e1\u163a\u6909\u70b6\ud0ed\ucc42\u98a4\u285c\uf886";
    protected static final int q = 10;
    protected byte[] b;
    protected int l = 0;
    protected long[] p;
    protected long[] r;
    protected byte[] s = new byte[32];
    protected long[] v;
    protected int w = 0;
    protected long[] x;
    protected long[] y;

    public static byte[] e(byte[] arrby, int n, int n2) {
        byte[] arrby2;
        if (n > 0) {
            arrby2 = new byte[n2];
            for (int i = 0; i < n2; ++i) {
                arrby2[i] = arrby[n + i];
            }
        } else {
            arrby2 = arrby;
        }
        Iw364 iw364 = new Iw364();
        Iw364.d(iw364);
        iw364.q(arrby2, n2 * 8);
        byte[] arrby3 = new byte[64];
        Iw364.j(iw364, arrby3, 0);
        return arrby3;
    }

    protected static void g(Iw364 iw364) {
        int n = 0;
        int n2 = 0;
        while (n < 8) {
            iw364.p[n] = (long)iw364.b[n2] << 56 ^ ((long)iw364.b[n2 + 1] & 0xFFL) << 48 ^ ((long)iw364.b[n2 + 2] & 0xFFL) << 40 ^ ((long)iw364.b[n2 + 3] & 0xFFL) << 32 ^ ((long)iw364.b[n2 + 4] & 0xFFL) << 24 ^ ((long)iw364.b[n2 + 5] & 0xFFL) << 16 ^ ((long)iw364.b[n2 + 6] & 0xFFL) << 8 ^ (long)iw364.b[n2 + 7] & 0xFFL;
            ++n;
            n2 += 8;
        }
        for (n = 0; n < 8; ++n) {
            iw364.v[n] = iw364.r[n];
            iw364.x[n] = iw364.p[n] ^ iw364.v[n];
        }
        for (n = 1; n <= 10; ++n) {
            int n3;
            int n4;
            for (n2 = 0; n2 < 8; ++n2) {
                iw364.y[n2] = 0L;
                n4 = 0;
                n3 = 56;
                while (n4 < 8) {
                    long[] arrl = iw364.y;
                    int n5 = n2;
                    arrl[n5] = arrl[n5] ^ e[n4][(int)(iw364.v[n2 - n4 & 7] >>> n3) & 0xFF];
                    ++n4;
                    n3 -= 8;
                }
            }
            for (n2 = 0; n2 < 8; ++n2) {
                iw364.v[n2] = iw364.y[n2];
            }
            long[] arrl = iw364.v;
            arrl[0] = arrl[0] ^ h[n];
            for (n2 = 0; n2 < 8; ++n2) {
                iw364.y[n2] = iw364.v[n2];
                n4 = 0;
                n3 = 56;
                while (n4 < 8) {
                    long[] arrl2 = iw364.y;
                    int n6 = n2;
                    arrl2[n6] = arrl2[n6] ^ e[n4][(int)(iw364.x[n2 - n4 & 7] >>> n3) & 0xFF];
                    ++n4;
                    n3 -= 8;
                }
            }
            for (n2 = 0; n2 < 8; ++n2) {
                iw364.x[n2] = iw364.y[n2];
            }
        }
        for (n = 0; n < 8; ++n) {
            long[] arrl = iw364.r;
            int n7 = n;
            arrl[n7] = arrl[n7] ^ (iw364.x[n] ^ iw364.p[n]);
        }
    }

    public static void d(Iw364 iw364) {
        int n;
        for (n = 0; n < 32; ++n) {
            iw364.s[n] = 0;
        }
        iw364.w = 0;
        iw364.l = 0;
        iw364.b[0] = 0;
        for (n = 0; n < 8; ++n) {
            iw364.r[n] = 0L;
        }
    }

    public void q(byte[] arrby, long l) {
        int n;
        int n2 = 0;
        int n3 = 8 - ((int)l & 7) & 7;
        int n4 = this.l & 7;
        long l2 = l;
        int n5 = 0;
        for (int i = 31; i >= 0; --i) {
            this.s[i] = (byte)(n5 += (this.s[i] & 0xFF) + ((int)l2 & 0xFF));
            n5 >>>= 8;
            l2 >>>= 8;
        }
        while (l > 8L) {
            n = arrby[n2] << n3 & 0xFF | (arrby[n2 + 1] & 0xFF) >>> 8 - n3;
            if (n < 0 || n >= 256) {
                throw new RuntimeException();
            }
            byte[] arrby2 = this.b;
            int n6 = this.w++;
            arrby2[n6] = (byte)(arrby2[n6] | n >>> n4);
            this.l += 8 - n4;
            if (this.l == 512) {
                Iw364.g(this);
                this.w = 0;
                this.l = 0;
            }
            this.b[this.w] = (byte)(n << 8 - n4 & 0xFF);
            this.l += n4;
            l -= 8L;
            ++n2;
        }
        if (l > 0L) {
            n = arrby[n2] << n3 & 0xFF;
            byte[] arrby3 = this.b;
            int n7 = this.w;
            arrby3[n7] = (byte)(arrby3[n7] | n >>> n4);
        } else {
            n = 0;
        }
        if ((long)n4 + l < 8L) {
            this.l = (int)((long)this.l + l);
        } else {
            ++this.w;
            this.l += 8 - n4;
            l -= (long)(8 - n4);
            if (this.l == 512) {
                Iw364.g(this);
                this.w = 0;
                this.l = 0;
            }
            this.b[this.w] = (byte)(n << 8 - n4 & 0xFF);
            this.l += (int)l;
        }
    }

    public static void j(Iw364 iw364, byte[] arrby, int n) {
        byte[] arrby2 = iw364.b;
        int n2 = iw364.w++;
        arrby2[n2] = (byte)(arrby2[n2] | 128 >>> (iw364.l & 7));
        if (iw364.w > 32) {
            while (iw364.w < 64) {
                iw364.b[iw364.w++] = 0;
            }
            Iw364.g(iw364);
            iw364.w = 0;
        }
        while (iw364.w < 32) {
            iw364.b[iw364.w++] = 0;
        }
        System.arraycopy(iw364.s, 0, iw364.b, 32, 32);
        Iw364.g(iw364);
        int n3 = 0;
        int n4 = n;
        while (n3 < 8) {
            long l = iw364.r[n3];
            arrby[n4] = (byte)(l >>> 56);
            arrby[n4 + 1] = (byte)(l >>> 48);
            arrby[n4 + 2] = (byte)(l >>> 40);
            arrby[n4 + 3] = (byte)(l >>> 32);
            arrby[n4 + 4] = (byte)(l >>> 24);
            arrby[n4 + 5] = (byte)(l >>> 16);
            arrby[n4 + 6] = (byte)(l >>> 8);
            arrby[n4 + 7] = (byte)l;
            ++n3;
            n4 += 8;
        }
    }

    static {
        int n;
        int n2;
        e = new long[8][256];
        h = new long[11];
        for (n = 0; n < 256; ++n) {
            long l;
            n2 = j.charAt(n / 2);
            long l2 = (n & 1) == 0 ? (long)(n2 >>> 8) : (long)(n2 & 0xFF);
            long l3 = l2 << 1;
            if (l3 >= 256L) {
                l3 ^= 0x11DL;
            }
            if ((l = l3 << 1) >= 256L) {
                l ^= 0x11DL;
            }
            long l4 = l ^ l2;
            long l5 = l << 1;
            if (l5 >= 256L) {
                l5 ^= 0x11DL;
            }
            long l6 = l5 ^ l2;
            Iw364.e[0][n] = l2 << 56 | l2 << 48 | l << 40 | l2 << 32 | l5 << 24 | l4 << 16 | l3 << 8 | l6;
            for (int i = 1; i < 8; ++i) {
                Iw364.e[i][n] = e[i - 1][n] >>> 8 | e[i - 1][n] << 56;
            }
        }
        Iw364.h[0] = 0L;
        for (n = 1; n <= 10; ++n) {
            n2 = 8 * (n - 1);
            Iw364.h[n] = e[0][n2] & 0xFF00000000000000L ^ e[1][n2 + 1] & 0xFF000000000000L ^ e[2][n2 + 2] & 0xFF0000000000L ^ e[3][n2 + 3] & 0xFF00000000L ^ e[4][n2 + 4] & 0xFF000000L ^ e[5][n2 + 5] & 0xFF0000L ^ e[6][n2 + 6] & 0xFF00L ^ e[7][n2 + 7] & 0xFFL;
        }
    }

    public Iw364() {
        this.b = new byte[64];
        this.r = new long[8];
        this.v = new long[8];
        this.y = new long[8];
        this.p = new long[8];
        this.x = new long[8];
    }
}

