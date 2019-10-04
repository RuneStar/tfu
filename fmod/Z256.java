// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Z256
{
    private static final Logger logger;
    long d;
    
    public J251 d(final int n, final boolean b) {
        return new J251(fmod.EventProject_getGroupByIndex(this.d, n, b));
    }
    
    public W242 j() {
        final W242 w242 = new W242();
        if (this.d == 0L) {
            return null;
        }
        for (final R257 r257 : fmod.j(fmod.EventProject_getInfo(this.d))) {
            if (r257.g.equals("index")) {
                w242.g = Integer.parseInt((String)r257.d);
            }
            if (r257.g.equals("name")) {
                w242.d = (String)r257.d;
            }
            if (r257.g.equals("numevents")) {
                w242.q = Integer.parseInt((String)r257.d);
            }
            if (r257.g.equals("maxwavebanks")) {
                w242.e = Integer.parseInt((String)r257.d);
            }
            if (r257.g.equals("numinstances")) {
                w242.j = Integer.parseInt((String)r257.d);
            }
            if (r257.g.equals("numplayingevents")) {
                w242.h = Integer.parseInt((String)r257.d);
            }
        }
        return w242;
    }
    
    public String[] e() {
        if (g(this)) {
            final String[] split = fmod.EventProject_getWaveBanksNeeded(this.d).split("\\|");
            for (int i = 0; i < split.length; ++i) {
                final StringBuilder sb = new StringBuilder();
                final String[] array = split;
                final int n = i;
                array[n] = sb.append(array[n]).append(".fsb").toString();
            }
            return split;
        }
        return null;
    }
    
    public static int h(final Z256 z256) {
        return fmod.EventProject_getNumGroups(z256.d);
    }
    
    public static void s(final Z256 z256, final boolean b) {
        fmod.EventProject_stopAllEvents(z256.d, b);
    }
    
    static {
        logger = LoggerFactory.getLogger(Z256.class);
    }
    
    public Z256(final long d) {
        this.d = d;
    }
    
    public static boolean g(final Z256 z256) {
        return z256.d != 0L;
    }
    
    public static J251[] q(final Z256 z256) {
        final int h = h(z256);
        final J251[] array = new J251[h];
        for (int i = 0; i < h; ++i) {
            array[i] = z256.d(i, false);
        }
        return array;
    }
}
