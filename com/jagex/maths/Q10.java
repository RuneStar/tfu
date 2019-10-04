// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

public final class Q10
{
    public final Matrix4 g;
    
    public static float g(final Q10 q10) {
        return q10.g.f30 + (Math.abs(q10.g.f00) + Math.abs(q10.g.f10) + Math.abs(q10.g.f20));
    }
    
    public static float q(final Q10 q10) {
        return q10.g.f31 + (Math.abs(q10.g.f01) + Math.abs(q10.g.f11) + Math.abs(q10.g.f21));
    }
    
    public static float j(final Q10 q10) {
        return q10.g.f31 - (Math.abs(q10.g.f01) + Math.abs(q10.g.f11) + Math.abs(q10.g.f21));
    }
    
    public Vector3 l() {
        return new Vector3(this.g.f30, this.g.f31, this.g.f32);
    }
    
    public Q10(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        final float n7 = (n4 - n) * 0.5f;
        final float n8 = (n5 - n2) * 0.5f;
        final float n9 = (n6 - n3) * 0.5f;
        this.g = Matrix4.e(n7, n8, n9, 1.0f).v(n + n7, n2 + n8, n3 + n9);
    }
    
    public Q10 s(final ScaleRotTrans scaleRotTrans) {
        return new Q10(this.g.d(scaleRotTrans));
    }
    
    public boolean b(final E41 e41) {
        final X309[] array = { new X309(-1.0f, 0.0f, 0.0f, e41.g), new X309(1.0f, 0.0f, 0.0f, e41.j), new X309(0.0f, -1.0f, 0.0f, e41.d), new X309(0.0f, 1.0f, 0.0f, e41.e), new X309(0.0f, 0.0f, -1.0f, e41.q), new X309(0.0f, 0.0f, 1.0f, e41.h) };
        for (int i = 0; i < 6; ++i) {
            final X309 x309 = array[i];
            final X309 x310 = new X309(x309.d.x * this.g.f00 + x309.d.y * this.g.f01 + x309.d.z * this.g.f02 + x309.g * this.g.f03, x309.d.x * this.g.f10 + x309.d.y * this.g.f11 + x309.d.z * this.g.f12 + x309.g * this.g.f13, x309.d.x * this.g.f20 + x309.d.y * this.g.f21 + x309.d.z * this.g.f22 + x309.g * this.g.f23, x309.d.x * this.g.f30 + x309.d.y * this.g.f31 + x309.d.z * this.g.f32 + x309.g * this.g.f33);
            if (X309.d(x310, -1.0f, -1.0f, -1.0f) < 0.0f) {
                if (X309.d(x310, 1.0f, -1.0f, -1.0f) < 0.0f) {
                    if (X309.d(x310, -1.0f, 1.0f, -1.0f) < 0.0f) {
                        if (X309.d(x310, 1.0f, 1.0f, -1.0f) < 0.0f) {
                            if (X309.d(x310, -1.0f, -1.0f, 1.0f) < 0.0f) {
                                if (X309.d(x310, 1.0f, -1.0f, 1.0f) < 0.0f) {
                                    if (X309.d(x310, -1.0f, 1.0f, 1.0f) < 0.0f) {
                                        if (X309.d(x310, 1.0f, 1.0f, 1.0f) < 0.0f) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public Q10(final Matrix4 g) {
        this.g = g;
    }
    
    public static float e(final Q10 q10) {
        return q10.g.f32 + (Math.abs(q10.g.f02) + Math.abs(q10.g.f12) + Math.abs(q10.g.f22));
    }
    
    public static float h(final Q10 q10) {
        return q10.g.f32 - (Math.abs(q10.g.f02) + Math.abs(q10.g.f12) + Math.abs(q10.g.f22));
    }
    
    public static float d(final Q10 q10) {
        return q10.g.f30 - (Math.abs(q10.g.f00) + Math.abs(q10.g.f10) + Math.abs(q10.g.f20));
    }
}
