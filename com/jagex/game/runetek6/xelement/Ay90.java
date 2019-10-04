/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.jnibindings.runetek6.D91;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ay90 {
    private static final Logger logger = LoggerFactory.getLogger(Ay90.class);
    private Map d = new HashMap();
    private float q = 0.0f;

    public static float[] g(Ay90 ay90, D91 d91) {
        float[] arrf = new float[d91.g()];
        Arrays.fill(arrf, ay90.q);
        for (Map.Entry entry : ay90.d.entrySet()) {
            String string = (String)entry.getKey();
            int n = d91.d(string);
            if (n != -1) {
                arrf[n] = ((Float)entry.getValue()).floatValue();
                continue;
            }
            logger.info("[blue]Unrecognised joint in skeleton mask: {}[/blue]", (Object)string);
        }
        return arrf;
    }
}

