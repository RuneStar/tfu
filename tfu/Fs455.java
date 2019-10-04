/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Fs455 {
    PPL(5, "PPL"),
    TWO_TONE_PPL(6, "TwoTonePPL"),
    ALWAYS_ON_TOP_PPL(7, "AlwaysOnTopPPL");
    
    private static final Logger logger;
    public int e;
    public int h;
    public String s;

    private Fs455(int n2, String string2) {
        this.e = n2;
        this.s = string2;
    }

    static {
        logger = LoggerFactory.getLogger(Fs455.class);
    }

    public static Fs455 g(int n) {
        for (Fs455 fs455 : Fs455.values()) {
            if (fs455.e != n) continue;
            return fs455;
        }
        return PPL;
    }

    public static boolean d(Fs455 fs455) {
        return fs455 == PPL || fs455 == TWO_TONE_PPL || fs455 == ALWAYS_ON_TOP_PPL;
    }
}

