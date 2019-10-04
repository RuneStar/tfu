// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Gg3;

public final class N319
{
    public static final int d = 1;
    public static final int g = 0;
    private float[] j;
    private A307[] q;
    
    public void g(final Vector3 vector3, final Vector3 vector4, final float n) {
        final A307[] q = new A307[this.q.length + 1];
        System.arraycopy(this.q, 0, q, 0, this.q.length);
        final A307 a307 = new A307();
        final A307 a308 = this.q[this.q.length - 1];
        A307.d(a307, 0, A307.q(a308, 3));
        A307.d(a307, 1, Vector3.z(A307.q(a308, 3), Vector3.k(A307.q(a308, 3), A307.q(a308, 2))));
        A307.d(a307, 3, vector3);
        A307.d(a307, 2, vector4);
        q[q.length - 1] = a307;
        this.q = q;
        final float[] j = new float[this.j.length + 1];
        System.arraycopy(this.j, 0, j, 0, this.j.length);
        j[j.length - 1] = n;
        this.j = j;
    }
    
    public N319(final Vector3[] array, final float n, final float n2) {
        this.q = new A307[1];
        this.j = new float[2];
        this.q[0] = new A307();
        for (int i = 0; i < 4; ++i) {
            A307.d(this.q[0], i, array[i]);
        }
        this.j[0] = n;
        this.j[1] = n2;
    }
    
    public N319(final Vector3[] array) {
        this(array, 0.0f, 0.0f);
    }
    
    public N319(final Gg3 gg3) {
        this.q = new A307[1];
        this.j = new float[2];
        final int br = Gg3.br(gg3);
        A307.d(this.q[0] = new A307(), 0, new Vector3(gg3));
        A307.d(this.q[0], 1, new Vector3(gg3));
        this.j[0] = Gg3.bl(gg3);
        A307.d(this.q[0], 3, new Vector3(gg3));
        A307.d(this.q[0], 2, new Vector3(gg3));
        this.j[1] = Gg3.bl(gg3);
        for (int i = 2; i < br; ++i) {
            this.g(new Vector3(gg3), new Vector3(gg3), Gg3.bl(gg3));
        }
    }
}
