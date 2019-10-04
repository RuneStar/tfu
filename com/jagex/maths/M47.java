// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Gg3;
import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public class M47
{
    static ThreadLocal d;
    public static final M47 g;
    public final float f00;
    public final float f01;
    public final float f02;
    public final float f10;
    public final float f11;
    public final float f12;
    public final float f20;
    public final float f21;
    public final float f22;
    
    public M47 e(final M47 m47) {
        return new M47(m47.f00 * this.f00 + m47.f10 * this.f01 + m47.f20 * this.f02, m47.f01 * this.f00 + m47.f11 * this.f01 + m47.f21 * this.f02, m47.f02 * this.f00 + m47.f12 * this.f01 + m47.f22 * this.f02, m47.f00 * this.f10 + m47.f10 * this.f11 + m47.f20 * this.f12, m47.f01 * this.f10 + m47.f11 * this.f11 + m47.f21 * this.f12, m47.f02 * this.f10 + m47.f12 * this.f11 + m47.f22 * this.f12, m47.f00 * this.f20 + m47.f10 * this.f21 + m47.f20 * this.f22, m47.f01 * this.f20 + m47.f11 * this.f21 + m47.f21 * this.f22, m47.f02 * this.f20 + m47.f12 * this.f21 + m47.f22 * this.f22);
    }
    
    public M47(final float f00, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7, final float f8, final float f9) {
        this.f00 = f00;
        this.f01 = f2;
        this.f02 = f3;
        this.f10 = f4;
        this.f11 = f5;
        this.f12 = f6;
        this.f20 = f7;
        this.f21 = f8;
        this.f22 = f9;
    }
    
    public static M47 g(final Vector3 vector3, final float n) {
        return Quaternion.j(vector3, n).m();
    }
    
    public static M47 d(final float n, final float n2, final float n3, final float n4) {
        return Quaternion.e(n, n2, n3, n4).m();
    }
    
    public Quaternion q() {
        final float n = this.f00 + this.f11 + this.f22;
        float[] value = M47.d.get();
        if (value == null) {
            value = new float[4];
            M47.d.set(value);
        }
        if (n > 0.0f) {
            final float n2 = (float)Math.sqrt(n + 1.0f);
            value[3] = n2 * 0.5f;
            final float n3 = 0.5f / n2;
            value[0] = (this.f12 - this.f21) * n3;
            value[1] = (this.f20 - this.f02) * n3;
            value[2] = (this.f01 - this.f10) * n3;
        }
        else {
            final int n4 = (this.f00 < this.f11) ? ((this.f11 < this.f22) ? 2 : 1) : ((this.f00 < this.f22) ? 2 : 0);
            final int n5 = (n4 + 1) % 3;
            final int n6 = (n4 + 2) % 3;
            final float n7 = (float)Math.sqrt(this.j(n4, n4) - this.j(n5, n5) - this.j(n6, n6) + 1.0f);
            value[n4] = n7 * 0.5f;
            final float n8 = 0.5f / n7;
            value[3] = (this.j(n5, n6) - this.j(n6, n5)) * n8;
            value[n5] = (this.j(n4, n5) + this.j(n5, n4)) * n8;
            value[n6] = (this.j(n4, n6) + this.j(n6, n4)) * n8;
        }
        return new Quaternion(value[0], value[1], value[2], value[3]);
    }
    
    private float j(final int n, final int n2) {
        Label_0159: {
            switch (n) {
                case 0: {
                    switch (n2) {
                        case 0: {
                            return this.f00;
                        }
                        case 1: {
                            return this.f01;
                        }
                        case 2: {
                            return this.f02;
                        }
                        default: {
                            break Label_0159;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (n2) {
                        case 0: {
                            return this.f10;
                        }
                        case 1: {
                            return this.f11;
                        }
                        case 2: {
                            return this.f12;
                        }
                        default: {
                            break Label_0159;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (n2) {
                        case 0: {
                            return this.f20;
                        }
                        case 1: {
                            return this.f21;
                        }
                        case 2: {
                            return this.f22;
                        }
                        default: {
                            break Label_0159;
                        }
                    }
                    break;
                }
            }
        }
        throw new IllegalArgumentException();
    }
    
    public M47(final Vector3 vector3, final Vector3 vector4, final Vector3 vector5) {
        this.f00 = vector3.x;
        this.f01 = vector4.x;
        this.f02 = vector5.x;
        this.f10 = vector3.y;
        this.f11 = vector4.y;
        this.f12 = vector5.y;
        this.f20 = vector3.z;
        this.f21 = vector4.z;
        this.f22 = vector5.z;
    }
    
    @Override
    public String toString() {
        return this.f00 + "," + this.f01 + "," + this.f02 + "\n" + this.f10 + "," + this.f11 + "," + this.f12 + "\n" + this.f20 + "," + this.f21 + "," + this.f22;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof M47)) {
            return false;
        }
        final M47 m47 = (M47)o;
        return this.f00 == m47.f00 && this.f01 == m47.f01 && this.f02 == m47.f02 && this.f10 == m47.f10 && this.f11 == m47.f11 && this.f12 == m47.f12 && this.f20 == m47.f20 && this.f21 == m47.f21 && this.f22 == m47.f22;
    }
    
    static {
        g = new M47(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
        M47.d = new ThreadLocal();
    }
    
    public M47 h(final M47 m47) {
        return new M47(this.f00 * m47.f00 + this.f10 * m47.f01 + this.f20 * m47.f02, this.f01 * m47.f00 + this.f11 * m47.f01 + this.f21 * m47.f02, this.f02 * m47.f00 + this.f12 * m47.f01 + this.f22 * m47.f02, this.f00 * m47.f10 + this.f10 * m47.f11 + this.f20 * m47.f12, this.f01 * m47.f10 + this.f11 * m47.f11 + this.f21 * m47.f12, this.f02 * m47.f10 + this.f12 * m47.f11 + this.f22 * m47.f12, this.f00 * m47.f20 + this.f10 * m47.f21 + this.f20 * m47.f22, this.f01 * m47.f20 + this.f11 * m47.f21 + this.f21 * m47.f22, this.f02 * m47.f20 + this.f12 * m47.f21 + this.f22 * m47.f22);
    }
    
    public static M47 s(final M47 m47, final I48 i48) {
        final float j = i48.j;
        final float e = i48.e;
        final float h = i48.h;
        i48.j = m47.f00 * j + m47.f10 * e + m47.f20 * h;
        i48.e = m47.f01 * j + m47.f11 * e + m47.f21 * h;
        i48.h = m47.f02 * j + m47.f12 * e + m47.f22 * h;
        return m47;
    }
    
    public static M47 b(final M47 m47, final Gg3 gg3) {
        Gg3.aq(gg3, m47.f00);
        Gg3.aq(gg3, m47.f01);
        Gg3.aq(gg3, m47.f02);
        Gg3.aq(gg3, m47.f10);
        Gg3.aq(gg3, m47.f11);
        Gg3.aq(gg3, m47.f12);
        Gg3.aq(gg3, m47.f20);
        Gg3.aq(gg3, m47.f21);
        Gg3.aq(gg3, m47.f22);
        return m47;
    }
}
