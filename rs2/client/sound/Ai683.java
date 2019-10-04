/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import java.util.ArrayList;
import rs2.client.sound.H591;

class Ai683 {
    H591 b;
    public float d = 0.0f;
    int e;
    ArrayList g = new ArrayList();
    float h;
    int j;
    float l;
    float q = 0.25f;
    float s;
    float w;
    final /* synthetic */ H591 r;

    public Ai683(H591 h591, H591 h5912, int n, int n2) {
        this.r = h591;
        this.w = n;
        this.l = n2;
        this.b = h5912;
    }

    public static int g(Ai683 ai683, String[] arrstring, int n) {
        String string = arrstring[n++];
        String[] arrstring2 = string.split("\\|");
        ai683.j = Integer.parseInt(arrstring2[0]);
        ai683.e = Integer.parseInt(arrstring2[1]);
        ai683.h = Float.parseFloat(arrstring2[2]);
        ai683.s = Float.parseFloat(arrstring2[3]);
        int n2 = Integer.parseInt(arrstring2[4]);
        for (int i = 0; i < n2; ++i) {
        }
        return n;
    }
}

