// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import com.jagex.maths.Vector3;
import tfu.Gg3;

public class S356 extends Bm108
{
    public static S356 g(final Gg3 gg3, final int n) {
        return new S356(new Vector3(gg3));
    }
    
    @Override
    public void d(final Gg3 gg3) {
        Vector3.w((Vector3)super.r, gg3);
    }
    
    S356(final Vector3 vector3) {
        super(Ag97.j, vector3);
    }
}
