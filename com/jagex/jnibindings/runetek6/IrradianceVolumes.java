/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class IrradianceVolumes {
    public static final native void initiateIrradianceBake();

    public static final boolean g(js5 js52, String string) {
        int n = js52.getgroupid("IrradianceVolumes");
        byte[][] arrarrby = new byte[1][];
        int n2 = string.lastIndexOf(46);
        if (n2 >= 0) {
            string = string.substring(0, n2);
        }
        int n3 = js52.getfileid(n, string);
        arrarrby[0] = js52.getfile(n, n3);
        if (arrarrby[0] != null) {
            return IrradianceVolumes.loadFromFileInMemory(arrarrby, arrarrby[0].length);
        }
        return false;
    }

    public static final native void destroyAllVolumes();

    public static final native boolean loadFromFileInMemory(byte[][] var0, int var1);
}

