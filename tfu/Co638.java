// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class Co638
{
    static final int g = 22050;
    private Cl639[] d;
    private int j;
    private int q;
    
    public static Co638 g(final js5 js5, final int n, final int n2) {
        final byte[] getfile = js5.getfile(n, n2);
        if (getfile == null) {
            return null;
        }
        return new Co638(new Gg3(getfile));
    }
    
    private static final byte[] q(final Co638 co638) {
        int n = 0;
        for (int i = 0; i < 10; ++i) {
            if (co638.d[i] != null && co638.d[i].g && co638.d[i].z + co638.d[i].t > n) {
                n = co638.d[i].z + co638.d[i].t;
            }
        }
        if (n == 0) {
            return new byte[0];
        }
        final byte[] array = new byte[22050 * n / 1000];
        for (int j = 0; j < 10; ++j) {
            if (co638.d[j] != null && co638.d[j].g) {
                final int n2 = co638.d[j].z * 22050 / 1000;
                final int n3 = co638.d[j].t * 22050 / 1000;
                final int[] g = Cl639.g(co638.d[j], n2, co638.d[j].z);
                for (int k = 0; k < n2; ++k) {
                    int n4 = array[k + n3] + (g[k] >> 8);
                    if ((n4 + 128 & 0xFFFFFF00) != 0x0) {
                        n4 = (n4 >> 31 ^ 0x7F);
                    }
                    array[k + n3] = (byte)n4;
                }
            }
        }
        return array;
    }
    
    private Co638() {
        this.d = new Cl639[10];
    }
    
    public Cj551 d() {
        return new Cj551(22050, q(this), 22050 * this.q / 1000, 22050 * this.j / 1000);
    }
    
    public Co638(final Gg3 gg3) {
        this.d = new Cl639[10];
        for (int i = 0; i < 10; ++i) {
            if (Gg3.ar(gg3) != 0) {
                --gg3.v;
                (this.d[i] = new Cl639()).q(gg3);
            }
        }
        this.q = Gg3.au(gg3);
        this.j = Gg3.au(gg3);
    }
}
