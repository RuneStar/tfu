// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class ParticleEngine
{
    public static final native void populateMaterialsFromMemory(final byte[][] p0);
    
    public static final native long createSystem(final String p0);
    
    public static final native void deleteSystem(final long p0);
    
    public static final void g(final js5 js5, final String s) {
        populateFromMemory(Js5NativeInterface.d(js5, s));
    }
    
    public static final native void populateFromMediaPath();
    
    public static final native void populateFromMemory(final byte[][] p0);
    
    public static final native void populateMeshesFromMemory(final byte[][] p0);
    
    public static final native void reset(final long p0);
    
    public static final native void setEnabled(final long p0, final boolean p1);
    
    public static final void d(final js5 js5, final String s) {
        populateMeshesFromMemory(Js5NativeInterface.d(js5, s));
    }
    
    public static final void q(final js5 js5, final String s) {
        populateMaterialsFromMemory(Js5NativeInterface.d(js5, s));
    }
}
