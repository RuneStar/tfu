// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

public final class S318
{
    public final X309 d;
    public final X309 e;
    public final X309 g;
    public final X309 h;
    public final X309 j;
    public final X309 q;
    
    public S318(final U316 u316) {
        this.g = new X309(u316.g[3] + u316.g[0], u316.g[7] + u316.g[4], u316.g[11] + u316.g[8], u316.g[15] + u316.g[12]).g();
        this.d = new X309(u316.g[3] - u316.g[0], u316.g[7] - u316.g[4], u316.g[11] - u316.g[8], u316.g[15] - u316.g[12]).g();
        this.q = new X309(u316.g[3] + u316.g[1], u316.g[7] + u316.g[5], u316.g[11] + u316.g[9], u316.g[15] + u316.g[13]).g();
        this.j = new X309(u316.g[3] - u316.g[1], u316.g[7] - u316.g[5], u316.g[11] - u316.g[9], u316.g[15] - u316.g[13]).g();
        this.e = new X309(u316.g[3] + u316.g[2], u316.g[7] + u316.g[6], u316.g[11] + u316.g[10], u316.g[15] + u316.g[14]).g();
        this.h = new X309(u316.g[3] - u316.g[2], u316.g[7] - u316.g[6], u316.g[11] - u316.g[10], u316.g[15] - u316.g[14]).g();
    }
    
    public static boolean g(final S318 s318, final Q10 q10) {
        return !d(s318.g, q10) && !d(s318.d, q10) && !d(s318.j, q10) && !d(s318.q, q10) && !d(s318.e, q10) && !d(s318.h, q10);
    }
    
    private static boolean d(final X309 x309, final Q10 q10) {
        final Matrix4 g = q10.g;
        final X309 x310 = new X309(x309.d.x * g.f00 + x309.d.y * g.f01 + x309.d.z * g.f02 + x309.g * g.f03, x309.d.x * g.f10 + x309.d.y * g.f11 + x309.d.z * g.f12 + x309.g * g.f13, x309.d.x * g.f20 + x309.d.y * g.f21 + x309.d.z * g.f22 + x309.g * g.f23, x309.d.x * g.f30 + x309.d.y * g.f31 + x309.d.z * g.f32 + x309.g * g.f33);
        return X309.d(x310, -1.0f, -1.0f, -1.0f) < 0.0f && X309.d(x310, 1.0f, -1.0f, -1.0f) < 0.0f && X309.d(x310, -1.0f, 1.0f, -1.0f) < 0.0f && X309.d(x310, 1.0f, 1.0f, -1.0f) < 0.0f && X309.d(x310, -1.0f, -1.0f, 1.0f) < 0.0f && X309.d(x310, 1.0f, -1.0f, 1.0f) < 0.0f && X309.d(x310, -1.0f, 1.0f, 1.0f) < 0.0f && X309.d(x310, 1.0f, 1.0f, 1.0f) < 0.0f;
    }
}
