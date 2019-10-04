// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Gg3;

public final class Ag566
{
    private static int d;
    private static Ag566[] g;
    private static int q;
    public float[] j;
    
    public Ag566(final Vector3 vector3, final Vector3 vector4, final Vector3 vector5) {
        (this.j = new float[9])[0] = vector3.x;
        this.j[1] = vector4.x;
        this.j[2] = vector5.x;
        this.j[3] = vector3.y;
        this.j[4] = vector4.y;
        this.j[5] = vector5.y;
        this.j[6] = vector3.z;
        this.j[7] = vector4.z;
        this.j[8] = vector5.z;
    }
    
    public Ag566() {
        this.j = new float[9];
        d(this);
    }
    
    public Ag566(final Ag566 ag566) {
        this.j = new float[9];
        System.arraycopy(ag566.j, 0, this.j, 0, 9);
    }
    
    public Ag566(final Gg3 gg3) {
        (this.j = new float[9])[0] = Gg3.bl(gg3);
        this.j[1] = Gg3.bl(gg3);
        this.j[2] = Gg3.bl(gg3);
        this.j[3] = Gg3.bl(gg3);
        this.j[4] = Gg3.bl(gg3);
        this.j[5] = Gg3.bl(gg3);
        this.j[6] = Gg3.bl(gg3);
        this.j[7] = Gg3.bl(gg3);
        this.j[8] = Gg3.bl(gg3);
    }
    
    public static Ag566 d(final Ag566 ag566) {
        ag566.j[0] = 1.0f;
        ag566.j[1] = 0.0f;
        ag566.j[2] = 0.0f;
        ag566.j[3] = 0.0f;
        ag566.j[4] = 1.0f;
        ag566.j[5] = 0.0f;
        ag566.j[6] = 0.0f;
        ag566.j[7] = 0.0f;
        ag566.j[8] = 1.0f;
        return ag566;
    }
    
    @Override
    public String toString() {
        return this.j[0] + "," + this.j[1] + "," + this.j[2] + "\n" + this.j[3] + "," + this.j[4] + "," + this.j[5] + "\n" + this.j[6] + "," + this.j[7] + "," + this.j[8];
    }
    
    static {
        Ag566.g = new Ag566[0];
    }
    
    public static void g(final int d) {
        Ag566.d = d;
        Ag566.g = new Ag566[d];
        Ag566.q = 0;
    }
}
