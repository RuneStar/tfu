package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class StateManager {
   public static long g;

   public static final native boolean isLoaded();

   public static final native void loadFromMemory(byte[][] var0);

   public static final void g(js5 var0, String var1) {
      loadFromMemory(Js5NativeInterface.d(var0, var1));
   }

   public static final native void sendEvent(String var0);

   public static final native void callStateCommand(long var0, String var2);

   public static final native float callFloatCommand(long var0, String var2);

   public static final native float getOverrideCameraX();

   public static final native boolean callBoolCommand(long var0, String var2);

   public static final native void callMatrixCommand(long var0, String var2, float[] var3);

   public static final native String callStringCommand(long var0, String var2);

   public static final native long getRootState();

   public static final native long getState(String var0);

   public static final native int getNumChildren(long var0);

   public static final native long getChildAtIndex(long var0, int var2);

   public static final native int callIntCommand(long var0, String var2);

   public static final native long getZoneChildAtIndex(long var0, int var2);

   public static final native String getZoneId(long var0);

   public static final native int getNumZoneChildren(long var0);

   public static final native String getStateId(long var0);

   public static final native float getZoneLastTime(long var0);

   public static final native boolean isActive(long var0);

   public static final native long getRootProfileZone();

   public static final native void SetJVM();

   public static final native float getOverrideCameraY();

   public static final native float getOverrideCameraZ();

   public StateManager() {
      g = getState("RootState");
   }

   public static final native void load(String var0);
}
