// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

public class Q244
{
    public float d;
    public float g;
    public float q;
    
    public Q244(final float g, final float d, final float q) {
        this.g = g;
        this.d = d;
        this.q = q;
    }
    
    public Q244() {
        final float g = 0.0f;
        this.q = g;
        this.d = g;
        this.g = g;
    }
    
    public Q244(final Q244 q244) {
        this.g = q244.g;
        this.d = q244.d;
        this.q = q244.q;
    }
    
    @Override
    public String toString() {
        return "X = " + this.g + ", Y = " + this.d + ", Z = " + this.q;
    }
}
