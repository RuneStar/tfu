// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Gg3;
import tfu.Kl267;

public final class V198 implements Kl267, B164
{
    public static final V198 g;
    public final float d;
    public final float e;
    public final float j;
    public final float q;
    
    @Override
    public String toString() {
        return this.d + "," + this.q + "," + this.j + "," + this.e;
    }
    
    public V198(final Gg3 gg3) {
        this.d = Gg3.bl(gg3);
        this.q = Gg3.bl(gg3);
        this.j = Gg3.bl(gg3);
        this.e = Gg3.bl(gg3);
    }
    
    public static void g(final V198 v198, final Gg3 gg3) {
        Gg3.aq(gg3, v198.d);
        Gg3.aq(gg3, v198.q);
        Gg3.aq(gg3, v198.j);
        Gg3.aq(gg3, v198.e);
    }
    
    public static V198 d(final V198 v198) {
        return v198;
    }
    
    static {
        g = new V198(0.0f, 0.0f, 0.0f, 0.0f);
    }
    
    public V198(final float d, final float q, final float j, final float e) {
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
    }
}
