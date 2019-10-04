// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

public class L250
{
    private long g;
    
    public static int d(final L250 l250) {
        return fmod.EventParameter_keyOff(l250.g);
    }
    
    public static boolean g(final L250 l250) {
        return l250.g != 0L;
    }
    
    public static int q(final L250 l250, final float n) {
        return fmod.EventParameter_setValue(l250.g, n);
    }
    
    public L250(final long g) {
        this.g = g;
    }
}
