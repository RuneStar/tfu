// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class Decals
{
    public static final void g(final js5 js5, final String s) {
        populateTemplatesFromMemory(Js5NativeInterface.d(js5, s));
    }
    
    public static final native void freeVehicleTyreTrackDecalSlot(final int p0);
    
    public static final native void populateFromMediaPath();
    
    public static final native void populateTemplatesFromMemory(final byte[][] p0);
    
    public static final native void populateMaterialsFromMemory(final byte[][] p0);
    
    public static final native int allocVehicleTyreTrackDecalSlot(final String p0);
    
    public static final void d(final js5 js5, final String s) {
        populateMaterialsFromMemory(Js5NativeInterface.d(js5, s));
    }
}
