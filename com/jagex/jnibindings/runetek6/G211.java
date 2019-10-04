/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.Js5NativeInterface;
import com.jagex.jnibindings.runetek6.NativeResourceLoader;

final class G211
implements Runnable {
    @Override
    public void run() {
        Js5NativeInterface.BindToThread();
        NativeResourceLoader.ComandeerThreadForDataAcquisition();
    }

    G211() {
    }
}

