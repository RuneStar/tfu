// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;

class A207 implements State
{
    final float b;
    final float d;
    final float e;
    final float g;
    final boolean h;
    final float j;
    final float l;
    final float q;
    final float s;
    
    @Override
    public int hashCode() {
        return (int)(this.g * 65536.0f + this.d * 31.0f + this.q + this.j * 257.0f + this.e * 8191.0f);
    }
    
    @Override
    public String toString() {
        String s = "dpos=(" + this.g + "," + this.d + "," + this.q + ") maxAccelPerTick=" + this.j + " faceAngle=" + this.e;
        if (this.h) {
            s += " isUnpushable=true";
        }
        if (this.s != 0.0f || this.b != 0.0f || this.l != 0.0f) {
            s = s + " impulse=(" + this.s + "," + this.b + "," + this.l + ")";
        }
        return s;
    }
    
    A207(float g, float d, float q, final float j, final float e, final boolean h, float s, float b, float l) {
        if (h) {
            g = 0.0f;
            d = 0.0f;
            q = 0.0f;
            s = 0.0f;
            b = 0.0f;
            l = 0.0f;
        }
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.h = h;
        this.s = s;
        this.b = b;
        this.l = l;
    }
    
    @Override
    public boolean equals(final Object o) {
        final A207 a207 = (A207)o;
        return this.g == a207.g && this.d == a207.d && this.q == a207.q && this.j == a207.j && this.e == a207.e && this.h == a207.h && this.s == a207.s && this.b == a207.b && this.l == a207.l;
    }
}
