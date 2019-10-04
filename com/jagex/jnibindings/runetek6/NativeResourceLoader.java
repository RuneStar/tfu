// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

public class NativeResourceLoader
{
    private static Thread g;
    
    private static native void InitNative();
    
    public static void g() {
        InitNative();
        (NativeResourceLoader.g = new Thread(new G211())).setName("Native Data Acquisition Thread");
        NativeResourceLoader.g.start();
    }
    
    public static void d() {
        PurgeNative();
        try {
            NativeResourceLoader.g.join();
        }
        catch (InterruptedException ex) {}
    }
    
    public static native void ComandeerThreadForDataAcquisition();
    
    private static native void PurgeNative();
}
