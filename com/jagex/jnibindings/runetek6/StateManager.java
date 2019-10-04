// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class StateManager
{
    public static long g;
    
    public static final native boolean isLoaded();
    
    public static final native void loadFromMemory(final byte[][] p0);
    
    public static final void g(final js5 js5, final String s) {
        loadFromMemory(Js5NativeInterface.d(js5, s));
    }
    
    public static final native void sendEvent(final String p0);
    
    public static final native void callStateCommand(final long p0, final String p1);
    
    public static final native float callFloatCommand(final long p0, final String p1);
    
    public static final native float getOverrideCameraX();
    
    public static final native boolean callBoolCommand(final long p0, final String p1);
    
    public static final native void callMatrixCommand(final long p0, final String p1, final float[] p2);
    
    public static final native String callStringCommand(final long p0, final String p1);
    
    public static final native long getRootState();
    
    public static final native long getState(final String p0);
    
    public static final native int getNumChildren(final long p0);
    
    public static final native long getChildAtIndex(final long p0, final int p1);
    
    public static final native int callIntCommand(final long p0, final String p1);
    
    public static final native long getZoneChildAtIndex(final long p0, final int p1);
    
    public static final native String getZoneId(final long p0);
    
    public static final native int getNumZoneChildren(final long p0);
    
    public static final native String getStateId(final long p0);
    
    public static final native float getZoneLastTime(final long p0);
    
    public static final native boolean isActive(final long p0);
    
    public static final native long getRootProfileZone();
    
    public static final native void SetJVM();
    
    public static final native float getOverrideCameraY();
    
    public static final native float getOverrideCameraZ();
    
    public StateManager() {
        StateManager.g = getState("RootState");
    }
    
    public static final native void load(final String p0);
}
