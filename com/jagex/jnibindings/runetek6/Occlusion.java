// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class Occlusion
{
    public static final native void destroyUmbraScene();
    
    public static final native boolean loadUmbraSceneFromFileInMemory(final byte[][] p0, final int p1);
    
    public static final boolean g(final js5 js5, String substring) {
        final int getgroupid = js5.getgroupid("Occlusion");
        final byte[][] array = { null };
        final int lastIndex = substring.lastIndexOf(46);
        if (lastIndex >= 0) {
            substring = substring.substring(0, lastIndex);
        }
        array[0] = js5.getfile(getgroupid, js5.getfileid(getgroupid, substring));
        return array[0] != null && loadUmbraSceneFromFileInMemory(array, array[0].length);
    }
}
