// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import org.slf4j.LoggerFactory;
import tfu.Lb33;
import org.slf4j.Logger;

public class LuaNativeEvents
{
    private static boolean d;
    private static final Logger logger;
    
    public static final native void detachAllEventHandlers(final long p0);
    
    public static final native void invokeOnUpdatePhysicsPost(final long p0);
    
    public static final native void invokeOnClientFriendListUpdate(final long p0);
    
    public static final native double serviceNative(final long p0, final float p1);
    
    public static final native void invokeOnUpdatePhysicsPre(final long p0);
    
    public static final void g() {
        LuaNativeEvents.d = true;
    }
    
    public static final void d(final long n, final float n2) {
        Lb33.g(Lb33.LuaNative);
        try {
            if (LuaNativeEvents.d) {
                serviceNative(n, n2);
            }
        }
        catch (Exception ex) {
            LuaNativeEvents.logger.error("", ex);
        }
        finally {
            Lb33.d(Lb33.LuaNative);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(LuaNativeEvents.class);
        LuaNativeEvents.d = false;
    }
}
