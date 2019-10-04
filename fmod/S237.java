// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

public class S237
{
    public long g;
    
    public S237(final long g) {
        this.g = g;
    }
    
    public static boolean g(final S237 s237) {
        return s237.g != 0L;
    }
    
    public H238 d(final int n) {
        return new H238(fmod.ChannelGroup_getChannel(this.g, n));
    }
    
    public static int q(final S237 s237) {
        return fmod.ChannelGroup_getNumChannels(s237.g);
    }
}
