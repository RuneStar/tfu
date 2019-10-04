package com.jagex.jnibindings.runetek6;

public class StateEventManager {
   public static final native void sendEvent(String var0);

   public static final native void resetOutEventsBuffer();

   public static final native void initEventsBuffers(long var0, long var2, int var4);
}
