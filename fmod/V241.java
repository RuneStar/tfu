// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

public class V241
{
    long g;
    
    public V241(final long g) {
        this.g = 0L;
        this.g = g;
    }
    
    public static int g(final V241 v241, final int n) {
        return fmod.Sound_getLength(v241.g, n);
    }
}
