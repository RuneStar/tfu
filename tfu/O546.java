/*
 * Decompiled with CFR 0.146.
 */
package tfu;

class O546 {
    public final byte[] d;
    public final int g;
    public final float[] q;

    public O546(int n) {
        this.g = n;
        if (n > 0) {
            this.d = new byte[n];
            this.q = new float[n];
        } else {
            this.d = null;
            this.q = null;
        }
    }
}

