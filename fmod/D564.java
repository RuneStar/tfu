// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

public class D564
{
    public String d;
    public long g;
    
    public static void d(final D564 d564) {
        if (g(d564)) {
            fmod.EventReverb_release(d564.g);
        }
    }
    
    @Override
    public String toString() {
        return this.d;
    }
    
    public static void q(final D564 d564, final boolean b) {
        if (g(d564)) {
            fmod.EventReverb_setActive(d564.g, b);
        }
    }
    
    public static void j(final D564 d564, final Q244 q244, final float n, final float n2) {
        if (g(d564)) {
            fmod.EventReverb_set3DAttributes(d564.g, q244.g, q244.d, q244.q, n, n2);
        }
    }
    
    public D564(final long g) {
        this.g = 0L;
        this.d = "";
        this.g = g;
    }
    
    public static boolean g(final D564 d564) {
        return d564.g != 0L;
    }
}
