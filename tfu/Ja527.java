/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.RuntimeTool.F511;
import tfu.Jb525;
import tfu.Jj524;

public enum Ja527 {
    JS5_DEFAULTS(Jb525.JS5),
    NL_JAGTHEORA(Jb525.NATIVE_LIBRARY),
    NL_JNIBINDINGS(Jb525.NATIVE_LIBRARY),
    JS5_SHADERS(Jb525.JS5),
    JS5_CONFIG(Jb525.JS5),
    JS5_CONFIG_OBJ(Jb525.JS5),
    JS5_GFX_CONFIG(Jb525.JS5),
    JS5FILE_HUFFMAN(Jb525.JS5_FILE),
    JS5_SCALEFORM(Jb525.JS5),
    JS5_SCALEFORMDDS(Jb525.JS5),
    JS5_FONTMETRICS(Jb525.JS5),
    JS5GROUP_PROPERTYINDEX(Jb525.JS5_GROUP),
    JS5_LUA(Jb525.JS5),
    JS5_STATES(Jb525.JS5),
    JS5_SPRITES(Jb525.JS5);
    
    public F511 m = new F511();
    private Jj524 t;
    public final Jb525 u;
    private int z;

    public static Jj524 q(Ja527 ja527) {
        return ja527.t;
    }

    public static void d(Ja527 ja527, int n) {
        ja527.z = n;
    }

    public void j(Jj524 jj524) {
        if (jj524.d() != this.u) {
            throw new IllegalArgumentException();
        }
        this.t = jj524;
    }

    public static int g(Ja527 ja527) {
        return ja527.z;
    }

    private Ja527(Jb525 jb525) {
        this.u = jb525;
        this.z = 1;
    }
}

