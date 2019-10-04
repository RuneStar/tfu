// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

public class M249
{
    private long g;
    
    public M249(final long g) {
        this.g = g;
    }
    
    public B561 g() {
        final B561 b561 = new B561();
        fmod.EventCategory_getInfo(this.g, b561);
        return b561;
    }
    
    @Override
    public String toString() {
        return this.g().g;
    }
    
    public static int d(final M249 m249, final float n) {
        return fmod.EventCategory_setVolume(m249.g, n);
    }
}
