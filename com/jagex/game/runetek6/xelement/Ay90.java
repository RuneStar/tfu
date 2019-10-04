// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.Arrays;
import com.jagex.jnibindings.runetek6.D91;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;

public class Ay90
{
    private static final Logger logger;
    private Map d;
    private float q;
    
    public Ay90() {
        this.d = new HashMap();
        this.q = 0.0f;
    }
    
    public static float[] g(final Ay90 ay90, final D91 d91) {
        final float[] a = new float[d91.g()];
        Arrays.fill(a, ay90.q);
        for (final Map.Entry<String, V> entry : ay90.d.entrySet()) {
            final String s = entry.getKey();
            final int d92 = d91.d(s);
            if (d92 != -1) {
                a[d92] = (float)entry.getValue();
            }
            else {
                Ay90.logger.info("[blue]Unrecognised joint in skeleton mask: {}[/blue]", s);
            }
        }
        return a;
    }
    
    static {
        logger = LoggerFactory.getLogger(Ay90.class);
    }
}
