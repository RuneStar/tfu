// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;
import tfu.Lb33;
import tfu.Be2;

@Be2
public class Js5NativeInterface
{
    public static boolean g() {
        Lb33.g(Lb33.InitNative);
        boolean initNative;
        try {
            initNative = InitNative(js5.class);
        }
        finally {
            Lb33.d(Lb33.InitNative);
        }
        return initNative;
    }
    
    public static native boolean RegisterAnimationGraphJs5(final js5 p0);
    
    public static native boolean RegisterTextureJs5(final js5 p0, final boolean p1);
    
    public static native boolean RegisterScaleformJs5(final js5 p0, final js5 p1);
    
    public static native boolean RegisterAnimationJs5(final js5 p0);
    
    public static native boolean RegisterLuaJs5(final js5 p0, final js5 p1);
    
    public static native boolean RegisterGroundCoverLayerInstanceJs5(final js5 p0);
    
    public static native boolean BindToThread();
    
    private static native boolean InitNative(final Class p0);
    
    public static final byte[][] d(final js5 js5, final String str) {
        final int getgroupid = js5.getgroupid(str);
        if (getgroupid == -1) {
            System.err.println("Group " + str + " missing from js5");
            return null;
        }
        final int[] u = js5.u(js5, getgroupid);
        final byte[][] array = new byte[u.length][];
        for (int i = 0; i < u.length; ++i) {
            array[i] = js5.getfile(getgroupid, u[i]);
        }
        return array;
    }
    
    public static native boolean RegisterShaderJs5(final js5 p0);
}
