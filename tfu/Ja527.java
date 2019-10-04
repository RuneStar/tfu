// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.jnibindings.runetek6.RuntimeTool.F511;

public enum Ja527
{
    JS5FILE_HUFFMAN("JS5FILE_HUFFMAN", 7, Jb525.JS5_FILE), 
    NL_JAGTHEORA("NL_JAGTHEORA", 1, Jb525.NATIVE_LIBRARY), 
    JS5_CONFIG("JS5_CONFIG", 4, Jb525.JS5), 
    JS5_DEFAULTS("JS5_DEFAULTS", 0, Jb525.JS5), 
    JS5_CONFIG_OBJ("JS5_CONFIG_OBJ", 5, Jb525.JS5), 
    JS5_SHADERS("JS5_SHADERS", 3, Jb525.JS5), 
    JS5_SCALEFORM("JS5_SCALEFORM", 8, Jb525.JS5), 
    JS5_STATES("JS5_STATES", 13, Jb525.JS5), 
    NL_JNIBINDINGS("NL_JNIBINDINGS", 2, Jb525.NATIVE_LIBRARY), 
    JS5_FONTMETRICS("JS5_FONTMETRICS", 10, Jb525.JS5), 
    JS5_GFX_CONFIG("JS5_GFX_CONFIG", 6, Jb525.JS5), 
    JS5GROUP_PROPERTYINDEX("JS5GROUP_PROPERTYINDEX", 11, Jb525.JS5_GROUP), 
    JS5_SCALEFORMDDS("JS5_SCALEFORMDDS", 9, Jb525.JS5), 
    JS5_SPRITES("JS5_SPRITES", 14, Jb525.JS5), 
    JS5_LUA("JS5_LUA", 12, Jb525.JS5);
    
    public F511 m;
    private Jj524 t;
    public final Jb525 u;
    private int z;
    
    public static Jj524 q(final Ja527 ja527) {
        return ja527.t;
    }
    
    public static void d(final Ja527 ja527, final int z) {
        ja527.z = z;
    }
    
    public void j(final Jj524 t) {
        if (t.d() != this.u) {
            throw new IllegalArgumentException();
        }
        this.t = t;
    }
    
    public static int g(final Ja527 ja527) {
        return ja527.z;
    }
    
    private Ja527(final String name, final int ordinal, final Jb525 u) {
        this.m = new F511();
        this.u = u;
        this.z = 1;
    }
}
