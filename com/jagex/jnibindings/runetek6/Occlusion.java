/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.js5.js5;

public class Occlusion {
    public static final native void destroyUmbraScene();

    public static final native boolean loadUmbraSceneFromFileInMemory(byte[][] var0, int var1);

    public static final boolean g(js5 js52, String string) {
        int n = js52.getgroupid("Occlusion");
        byte[][] arrarrby = new byte[1][];
        int n2 = string.lastIndexOf(46);
        if (n2 >= 0) {
            string = string.substring(0, n2);
        }
        int n3 = js52.getfileid(n, string);
        arrarrby[0] = js52.getfile(n, n3);
        if (arrarrby[0] != null) {
            return Occlusion.loadUmbraSceneFromFileInMemory(arrarrby, arrarrby[0].length);
        }
        return false;
    }
}

