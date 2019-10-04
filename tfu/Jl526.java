// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Jl526
{
    private String d;
    private final Logger logger;
    
    public static boolean g(final Jl526 jl526, final String d) {
        if (!d.equals(jl526.d)) {
            jl526.d = d;
            return true;
        }
        return false;
    }
    
    public Jl526() {
        this.logger = LoggerFactory.getLogger(Jl526.class);
        this.d = new String();
    }
}
