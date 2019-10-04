// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Gg3;
import tfu.Kl267;
import tfu.Lp301;

public final class I48 implements G300, Lp301, Kl267
{
    private static int d;
    private static I48[] g;
    private static int q;
    public float e;
    public float h;
    public float j;
    
    public static I48 d() {
        synchronized (I48.g) {
            if (I48.q == 0) {
                return new I48();
            }
            z(I48.g[--I48.q]);
            return I48.g[I48.q];
        }
    }
    
    public static I48 w(final float n, final float n2, final float n3) {
        synchronized (I48.g) {
            if (I48.q == 0) {
                return new I48(n, n2, n3);
            }
            p(I48.g[--I48.q], n, n2, n3);
            return I48.g[I48.q];
        }
    }
    
    public static I48 u(final I48 i48, final I48 i49) {
        p(i48, i49.j, i49.e, i49.h);
        return i48;
    }
    
    public static I48 v(final I48 i48) {
        synchronized (I48.g) {
            if (I48.q == 0) {
                return new I48(i48);
            }
            u(I48.g[--I48.q], i48);
            return I48.g[I48.q];
        }
    }
    
    public static void y(final I48 i48) {
        synchronized (I48.g) {
            if (I48.q < I48.d - 1) {
                I48.g[I48.q++] = i48;
            }
        }
    }
    
    public I48(final float j, final float e, final float h) {
        this.j = j;
        this.e = e;
        this.h = h;
    }
    
    public I48(final Vector3 vector3) {
        this.j = vector3.x;
        this.e = vector3.y;
        this.h = vector3.z;
    }
    
    public I48(final Gg3 gg3, final int n) {
        final float n2 = (float)Math.pow(10.0, n);
        this.j = Gg3.by(gg3) / n2;
        this.e = Gg3.by(gg3) / n2;
        this.h = Gg3.by(gg3) / n2;
    }
    
    public static I48 p(final I48 i48, final float j, final float e, final float h) {
        i48.j = j;
        i48.e = e;
        i48.h = h;
        return i48;
    }
    
    public static I48 x(final I48 i48, final Vector3 vector3) {
        p(i48, vector3.x, vector3.y, vector3.z);
        return i48;
    }
    
    public static final float ag(final I48 i48) {
        return i48.j * i48.j + i48.e * i48.e + i48.h * i48.h;
    }
    
    public static final I48 z(final I48 i48) {
        final float j = 0.0f;
        i48.h = j;
        i48.e = j;
        i48.j = j;
        return i48;
    }
    
    public static final I48 k(final I48 i48, final I48 i49) {
        i48.j += i49.j;
        i48.e += i49.e;
        i48.h += i49.h;
        return i48;
    }
    
    public static final I48 i(final I48 i48, final float n, final float n2, final float n3) {
        i48.j += n;
        i48.e += n2;
        i48.h += n3;
        return i48;
    }
    
    @Override
    public String toString() {
        return String.format("{Vector 3: %f,%f,%f}", this.j, this.e, this.h);
    }
    
    public static final I48 a(final I48 i48, final I48 i49) {
        i48.j -= i49.j;
        i48.e -= i49.e;
        i48.h -= i49.h;
        return i48;
    }
    
    public static I48 r(final Vector3 vector3) {
        synchronized (I48.g) {
            if (I48.q == 0) {
                return new I48(vector3);
            }
            x(I48.g[--I48.q], vector3);
            return I48.g[I48.q];
        }
    }
    
    public static void g(final int d) {
        I48.d = d;
        I48.g = new I48[d];
        I48.q = 0;
    }
    
    public static final I48 aq(final I48 i48, final float n) {
        i48.j *= n;
        i48.e *= n;
        i48.h *= n;
        return i48;
    }
    
    public static final I48 al(final I48 i48, final Quaternion quaternion) {
        final Quaternion g = Quaternion.g(i48.j, i48.e, i48.h, 0.0f);
        final O166 j = O166.j(quaternion.s());
        O166.k(j, g);
        O166.k(j, quaternion);
        p(i48, j.j, j.e, j.h);
        O166.e(j);
        return i48;
    }
    
    public static final I48 af(final I48 i48, final O166 o166) {
        final O166 q = O166.q(i48.j, i48.e, i48.h, 0.0f);
        final O166 j = O166.i(O166.p(o166.c()), q);
        O166.i(j, o166);
        p(i48, j.j, j.e, j.h);
        O166.e(q);
        O166.e(j);
        return i48;
    }
    
    public static final I48 av(final I48 i48, final Vector3 vector3, final float n) {
        aq(i48, 1.0f - n);
        n(i48, Vector3.ai(vector3, n));
        return i48;
    }
    
    public I48(final Gg3 gg3) {
        this.j = Gg3.bl(gg3);
        this.e = Gg3.bl(gg3);
        this.h = Gg3.bl(gg3);
    }
    
    @Override
    public Vector3 j() {
        return this.ao();
    }
    
    public static I48 ap(final I48 i48) {
        return v(i48);
    }
    
    public Vector3 ao() {
        return new Vector3(this.j, this.e, this.h);
    }
    
    static {
        I48.g = new I48[0];
    }
    
    public static final float c(final I48 i48) {
        return (float)Math.sqrt(ag(i48));
    }
    
    public static final I48 o(final I48 i48, final Vector3 vector3) {
        i48.j -= vector3.x;
        i48.e -= vector3.y;
        i48.h -= vector3.z;
        return i48;
    }
    
    public static final I48 m(final I48 i48) {
        final float n = 1.0f / c(i48);
        i48.j *= n;
        i48.e *= n;
        i48.h *= n;
        return i48;
    }
    
    public static final I48 ai(final I48 i48, final float n) {
        i48.j /= n;
        i48.e /= n;
        i48.h /= n;
        return i48;
    }
    
    @Override
    public Vector3 e() {
        return this.ao();
    }
    
    public I48(final I48 i48) {
        this.j = i48.j;
        this.e = i48.e;
        this.h = i48.h;
    }
    
    public static final I48 n(final I48 i48, final Vector3 vector3) {
        i48.j += vector3.x;
        i48.e += vector3.y;
        i48.h += vector3.z;
        return i48;
    }
    
    public I48() {
    }
    
    public static final I48 t(final I48 i48) {
        i48.j = -i48.j;
        i48.e = -i48.e;
        i48.h = -i48.h;
        return i48;
    }
    
    public static final I48 f(final I48 i48, final Vector3 vector3, final float n) {
        i48.j -= vector3.x * n;
        i48.e -= vector3.y * n;
        i48.h -= vector3.z * n;
        return i48;
    }
}
