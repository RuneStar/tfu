// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Gs329 extends Gg3
{
    private static final int[] d;
    private Ic327 g;
    private int j;
    private int q;
    
    public static void h(final Gs329 gs329) {
        gs329.j = gs329.v * 8;
    }
    
    public Gs329(final byte[] array) {
        super(array);
    }
    
    public static void g(final Gs329 gs329, final Ic327 g) {
        gs329.g = g;
    }
    
    public static void d(final Gs329 gs329, final int n) {
        gs329.r[gs329.v++] = (byte)(n + Ic327.d(gs329.g));
    }
    
    public static void e(final Gs329 gs329, final byte[] array, final int n, final int n2) {
        for (int i = 0; i < n2; ++i) {
            array[i + n] = (byte)(gs329.r[gs329.v++] - Ic327.d(gs329.g));
        }
    }
    
    public static int j(final Gs329 gs329) {
        final int n = gs329.r[gs329.v++] - Ic327.d(gs329.g) & 0xFF;
        if (n < 128) {
            return n;
        }
        return (n - 128 << 8) + (gs329.r[gs329.v++] - Ic327.d(gs329.g) & 0xFF);
    }
    
    public Gs329(final int n) {
        super(n);
    }
    
    public static void b(final Gs329 gs329) {
        gs329.v = (gs329.j + 7) / 8;
    }
    
    static {
        d = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };
    }
    
    public int s(int i) {
        if (i > 32) {
            throw new IllegalArgumentException();
        }
        int n = this.j >> 3;
        int n2 = 8 - (this.j & 0x7);
        int n3 = 0;
        this.j += i;
        while (i > n2) {
            n3 += (super.r[n++] & Gs329.d[n2]) << i - n2;
            i -= n2;
            n2 = 8;
        }
        int n4;
        if (i == n2) {
            n4 = n3 + (super.r[n] & Gs329.d[n2]);
        }
        else {
            n4 = n3 + (super.r[n] >> n2 - i & Gs329.d[i]);
        }
        return n4;
    }
    
    public static boolean q(final Gs329 gs329) {
        return (gs329.r[gs329.v] - Ic327.q(gs329.g) & 0xFF) >= 128;
    }
}
