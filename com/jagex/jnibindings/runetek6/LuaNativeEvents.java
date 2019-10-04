/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Lb33;

public class LuaNativeEvents {
    private static boolean d;
    private static final Logger logger;

    public static final native void detachAllEventHandlers(long var0);

    public static final native void invokeOnUpdatePhysicsPost(long var0);

    public static final native void invokeOnClientFriendListUpdate(long var0);

    public static final native double serviceNative(long var0, float var2);

    public static final native void invokeOnUpdatePhysicsPre(long var0);

    public static final void g() {
        d = true;
    }

    public static final void d(long l, float f) {
        Lb33.g(Lb33.LuaNative);
        try {
            block4 : {
                try {
                    if (!d) break block4;
                    LuaNativeEvents.serviceNative(l, f);
                }
                catch (Exception exception) {
                    logger.error("", exception);
                    Lb33.d(Lb33.LuaNative);
                }
            }
            Lb33.d(Lb33.LuaNative);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.LuaNative);
            throw throwable;
        }
    }

    static {
        logger = LoggerFactory.getLogger(LuaNativeEvents.class);
        d = false;
    }
}

