/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public final class Mr366 {
    private int[] g;

    public static int g(Mr366 mr366, int n) {
        int n2 = (mr366.g.length >> 1) - 1;
        int n3 = n & n2;
        int n4;
        while ((n4 = mr366.g[n3 + n3 + 1]) != -1) {
            if (mr366.g[n3 + n3] == n) {
                return n4;
            }
            n3 = n3 + 1 & n2;
        }
        return -1;
    }

    public Mr366(int[] arrn) {
        int n;
        int n2;
        for (n = 1; n <= arrn.length + (arrn.length >> 1); n <<= 1) {
        }
        this.g = new int[n + n];
        for (n2 = 0; n2 < n + n; ++n2) {
            this.g[n2] = -1;
        }
        n2 = 0;
        while (n2 < arrn.length) {
            int n3 = arrn[n2] & n - 1;
            while (this.g[n3 + n3 + 1] != -1) {
                n3 = n3 + 1 & n - 1;
            }
            this.g[n3 + n3] = arrn[n2];
            this.g[n3 + n3 + 1] = n2++;
        }
    }
}

