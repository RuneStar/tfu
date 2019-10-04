// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

final class G211 implements Runnable
{
    @Override
    public void run() {
        Js5NativeInterface.BindToThread();
        NativeResourceLoader.ComandeerThreadForDataAcquisition();
    }
}
