/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;
import java.io.PrintStream;
import tfu.Be2;
import tfu.Lb33;

@Be2
public class Js5NativeInterface {
    public static boolean g() {
        boolean bl;
        Lb33.g(Lb33.InitNative);
        try {
            bl = Js5NativeInterface.InitNative(js5.class);
            Lb33.d(Lb33.InitNative);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.InitNative);
            throw throwable;
        }
        return bl;
    }

    public static native boolean RegisterAnimationGraphJs5(js5 var0);

    public static native boolean RegisterTextureJs5(js5 var0, boolean var1);

    public static native boolean RegisterScaleformJs5(js5 var0, js5 var1);

    public static native boolean RegisterAnimationJs5(js5 var0);

    public static native boolean RegisterLuaJs5(js5 var0, js5 var1);

    public static native boolean RegisterGroundCoverLayerInstanceJs5(js5 var0);

    public static native boolean BindToThread();

    private static native boolean InitNative(Class var0);

    public static final byte[][] d(js5 js52, String string) {
        int n = js52.getgroupid(string);
        if (n == -1) {
            System.err.println("Group " + string + " missing from js5");
            return null;
        }
        int[] arrn = js5.u(js52, n);
        byte[][] arrarrby = new byte[arrn.length][];
        for (int i = 0; i < arrn.length; ++i) {
            arrarrby[i] = js52.getfile(n, arrn[i]);
        }
        return arrarrby;
    }

    public static native boolean RegisterShaderJs5(js5 var0);
}

