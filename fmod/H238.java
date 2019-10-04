// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

public class H238
{
    public long g;
    
    public static boolean g(final H238 h238) {
        return h238.g != 0L;
    }
    
    public H238(final long g) {
        this.g = 0L;
        this.g = g;
    }
    
    public static int q(final H238 h238, final int n) {
        return fmod.Channel_getPosition(h238.g, n);
    }
    
    public V241 d() {
        return new V241(fmod.Channel_getCurrentSound(this.g));
    }
    
    public static int j(final H238 h238, final int n, final int n2) {
        return fmod.Channel_setPosition(h238.g, n, n2);
    }
}
