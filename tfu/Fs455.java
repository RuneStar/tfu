// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public enum Fs455
{
    TWO_TONE_PPL("TWO_TONE_PPL", 1, 6, "TwoTonePPL"), 
    PPL("PPL", 0, 5, "PPL"), 
    ALWAYS_ON_TOP_PPL("ALWAYS_ON_TOP_PPL", 2, 7, "AlwaysOnTopPPL");
    
    private static final Logger logger;
    public int e;
    public int h;
    public String s;
    
    private Fs455(final String name, final int ordinal, final int e, final String s) {
        this.e = e;
        this.s = s;
    }
    
    static {
        logger = LoggerFactory.getLogger(Fs455.class);
    }
    
    public static Fs455 g(final int n) {
        for (final Fs455 fs455 : values()) {
            if (fs455.e == n) {
                return fs455;
            }
        }
        return Fs455.PPL;
    }
    
    public static boolean d(final Fs455 fs455) {
        return fs455 == Fs455.PPL || fs455 == Fs455.TWO_TONE_PPL || fs455 == Fs455.ALWAYS_ON_TOP_PPL;
    }
}
