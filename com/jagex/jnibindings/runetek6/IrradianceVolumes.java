// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class IrradianceVolumes
{
    public static final native void initiateIrradianceBake();
    
    public static final boolean g(final js5 js5, String substring) {
        final int getgroupid = js5.getgroupid("IrradianceVolumes");
        final byte[][] array = { null };
        final int lastIndex = substring.lastIndexOf(46);
        if (lastIndex >= 0) {
            substring = substring.substring(0, lastIndex);
        }
        array[0] = js5.getfile(getgroupid, js5.getfileid(getgroupid, substring));
        return array[0] != null && loadFromFileInMemory(array, array[0].length);
    }
    
    public static final native void destroyAllVolumes();
    
    public static final native boolean loadFromFileInMemory(final byte[][] p0, final int p1);
}
