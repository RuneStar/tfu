// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class O546
{
    public final byte[] d;
    public final int g;
    public final float[] q;
    
    public O546(final int g) {
        this.g = g;
        if (g > 0) {
            this.d = new byte[g];
            this.q = new float[g];
        }
        else {
            this.d = null;
            this.q = null;
        }
    }
}
