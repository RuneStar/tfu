// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import java.util.ArrayList;

class Ai683
{
    H591 b;
    public float d;
    int e;
    ArrayList g;
    float h;
    int j;
    float l;
    float q;
    float s;
    float w;
    final /* synthetic */ H591 r;
    
    public Ai683(final H591 r, final H591 b, final int n, final int n2) {
        this.r = r;
        this.g = new ArrayList();
        this.d = 0.0f;
        this.q = 0.25f;
        this.w = (float)n;
        this.l = (float)n2;
        this.b = b;
    }
    
    public static int g(final Ai683 ai683, final String[] array, int n) {
        final String[] split = array[n++].split("\\|");
        ai683.j = Integer.parseInt(split[0]);
        ai683.e = Integer.parseInt(split[1]);
        ai683.h = Float.parseFloat(split[2]);
        ai683.s = Float.parseFloat(split[3]);
        for (int int1 = Integer.parseInt(split[4]), i = 0; i < int1; ++i) {}
        return n;
    }
}
