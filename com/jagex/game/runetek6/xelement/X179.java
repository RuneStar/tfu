// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

public class X179
{
    public float d;
    public float e;
    public int g;
    public By167[] h;
    public float j;
    public int q;
    final /* synthetic */ Bn70 s;
    
    public X179(final Bn70 s) {
        this.s = s;
        this.g = 512;
        this.d = 1.0f;
        this.q = 64;
        this.j = 20.0f;
        this.e = 2.0f;
        this.h = new By167[3];
        for (int i = 0; i < 3; ++i) {
            this.h[i] = new By167(s);
        }
    }
}
