// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

public class StateEventManager
{
    public static final native void sendEvent(final String p0);
    
    public static final native void resetOutEventsBuffer();
    
    public static final native void initEventsBuffers(final long p0, final long p1, final int p2);
}
