// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public final class Mr366
{
    private int[] g;
    
    public static int g(final Mr366 mr366, final int n) {
        final int n2 = (mr366.g.length >> 1) - 1;
        int n3 = n & n2;
        while (true) {
            final int n4 = mr366.g[n3 + n3 + 1];
            if (n4 == -1) {
                return -1;
            }
            if (mr366.g[n3 + n3] == n) {
                return n4;
            }
            n3 = (n3 + 1 & n2);
        }
    }
    
    public Mr366(final int[] array) {
        int i;
        for (i = 1; i <= array.length + (array.length >> 1); i <<= 1) {}
        this.g = new int[i + i];
        for (int j = 0; j < i + i; ++j) {
            this.g[j] = -1;
        }
        for (int k = 0; k < array.length; ++k) {
            int n;
            for (n = (array[k] & i - 1); this.g[n + n + 1] != -1; n = (n + 1 & i - 1)) {}
            this.g[n + n] = array[k];
            this.g[n + n + 1] = k;
        }
    }
}
