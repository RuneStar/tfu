// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Ic327
{
    private static final int d = 256;
    private static final int g = 8;
    private static final int q = 1020;
    private int b;
    private int[] e;
    private int[] h;
    private int j;
    private int l;
    private int s;
    
    private static final void j(final Ic327 ic327) {
        ic327.b += ++ic327.l;
        for (int i = 0; i < 256; ++i) {
            final int n = ic327.h[i];
            if ((i & 0x2) == 0x0) {
                if ((i & 0x1) == 0x0) {
                    ic327.s ^= ic327.s << 13;
                }
                else {
                    ic327.s ^= ic327.s >>> 6;
                }
            }
            else if ((i & 0x1) == 0x0) {
                ic327.s ^= ic327.s << 2;
            }
            else {
                ic327.s ^= ic327.s >>> 16;
            }
            ic327.s += ic327.h[i + 128 & 0xFF];
            ic327.e[i] = (ic327.b = ic327.h[((ic327.h[i] = ic327.h[(n & 0x3FC) >> 2] + ic327.s + ic327.b) >> 8 & 0x3FC) >> 2] + n);
        }
    }
    
    public Ic327(final int[] array) {
        this.h = new int[256];
        this.e = new int[256];
        for (int i = 0; i < array.length; ++i) {
            this.e[i] = array[i];
        }
        e(this);
    }
    
    public static int d(final Ic327 ic327) {
        return g(ic327);
    }
    
    public static int q(final Ic327 ic327) {
        if (ic327.j == 0) {
            j(ic327);
            ic327.j = 256;
        }
        return ic327.e[ic327.j - 1];
    }
    
    private Ic327() {
    }
    
    private static final void e(final Ic327 ic327) {
        int n8;
        int n7;
        int n6;
        int n5;
        int n4;
        int n3;
        int n2;
        int n = n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = -1640531527))))));
        for (int i = 0; i < 4; ++i) {
            final int n9 = n2 ^ n << 11;
            final int n10 = n4 + n9;
            final int n11 = n + n3 ^ n3 >>> 2;
            final int n12 = n5 + n11;
            final int n13 = n3 + n10 ^ n10 << 8;
            final int n14 = n6 + n13;
            n4 = (n10 + n12 ^ n12 >>> 16);
            final int n15 = n7 + n4;
            n5 = (n12 + n14 ^ n14 << 10);
            final int n16 = n8 + n5;
            n6 = (n14 + n15 ^ n15 >>> 4);
            final int n17 = n9 + n6;
            n7 = (n15 + n16 ^ n16 << 8);
            n = n11 + n7;
            n8 = (n16 + n17 ^ n17 >>> 9);
            n3 = n13 + n8;
            n2 = n17 + n;
        }
        for (int j = 0; j < 256; j += 8) {
            final int n18 = n2 + ic327.e[j];
            final int n19 = n + ic327.e[j + 1];
            final int n20 = n3 + ic327.e[j + 2];
            final int n21 = n4 + ic327.e[j + 3];
            final int n22 = n5 + ic327.e[j + 4];
            final int n23 = n6 + ic327.e[j + 5];
            final int n24 = n7 + ic327.e[j + 6];
            final int n25 = n8 + ic327.e[j + 7];
            final int n26 = n18 ^ n19 << 11;
            final int n27 = n21 + n26;
            final int n28 = n19 + n20 ^ n20 >>> 2;
            final int n29 = n22 + n28;
            final int n30 = n20 + n27 ^ n27 << 8;
            final int n31 = n23 + n30;
            n4 = (n27 + n29 ^ n29 >>> 16);
            final int n32 = n24 + n4;
            n5 = (n29 + n31 ^ n31 << 10);
            final int n33 = n25 + n5;
            n6 = (n31 + n32 ^ n32 >>> 4);
            final int n34 = n26 + n6;
            n7 = (n32 + n33 ^ n33 << 8);
            n = n28 + n7;
            n8 = (n33 + n34 ^ n34 >>> 9);
            n3 = n30 + n8;
            n2 = n34 + n;
            ic327.h[j] = n2;
            ic327.h[j + 1] = n;
            ic327.h[j + 2] = n3;
            ic327.h[j + 3] = n4;
            ic327.h[j + 4] = n5;
            ic327.h[j + 5] = n6;
            ic327.h[j + 6] = n7;
            ic327.h[j + 7] = n8;
        }
        for (int k = 0; k < 256; k += 8) {
            final int n35 = n2 + ic327.h[k];
            final int n36 = n + ic327.h[k + 1];
            final int n37 = n3 + ic327.h[k + 2];
            final int n38 = n4 + ic327.h[k + 3];
            final int n39 = n5 + ic327.h[k + 4];
            final int n40 = n6 + ic327.h[k + 5];
            final int n41 = n7 + ic327.h[k + 6];
            final int n42 = n8 + ic327.h[k + 7];
            final int n43 = n35 ^ n36 << 11;
            final int n44 = n38 + n43;
            final int n45 = n36 + n37 ^ n37 >>> 2;
            final int n46 = n39 + n45;
            final int n47 = n37 + n44 ^ n44 << 8;
            final int n48 = n40 + n47;
            n4 = (n44 + n46 ^ n46 >>> 16);
            final int n49 = n41 + n4;
            n5 = (n46 + n48 ^ n48 << 10);
            final int n50 = n42 + n5;
            n6 = (n48 + n49 ^ n49 >>> 4);
            final int n51 = n43 + n6;
            n7 = (n49 + n50 ^ n50 << 8);
            n = n45 + n7;
            n8 = (n50 + n51 ^ n51 >>> 9);
            n3 = n47 + n8;
            n2 = n51 + n;
            ic327.h[k] = n2;
            ic327.h[k + 1] = n;
            ic327.h[k + 2] = n3;
            ic327.h[k + 3] = n4;
            ic327.h[k + 4] = n5;
            ic327.h[k + 5] = n6;
            ic327.h[k + 6] = n7;
            ic327.h[k + 7] = n8;
        }
        j(ic327);
        ic327.j = 256;
    }
    
    private static final int g(final Ic327 ic327) {
        if (ic327.j == 0) {
            j(ic327);
            ic327.j = 256;
        }
        final int[] e = ic327.e;
        final int j = ic327.j - 1;
        ic327.j = j;
        return e[j];
    }
}
