// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import fmod.Q244;
import fmod.D564;
import com.jagex.maths.Vector3;
import tfu.Gg3;

final class Af685 implements Z674
{
    @Override
    public void g(final String s, final Object o) {
    }
    
    @Override
    public void q() {
        F594.q();
    }
    
    @Override
    public void d(final byte[] array, final Object o) {
        final Gg3 gg3 = new Gg3(array);
        final int au = Gg3.au(gg3);
        F594.q();
        F594.u = (F594.z = 0.0f);
        for (int i = 0; i < au; ++i) {
            final int ar = Gg3.ar(gg3);
            final byte b = (byte)Gg3.ar(gg3);
            final char[] data = new char[b];
            for (byte b2 = 0; b2 < b; ++b2) {
                data[b2] = (char)Gg3.ar(gg3);
            }
            final String value = String.valueOf(data);
            final byte b3 = (byte)Gg3.ar(gg3);
            final char[] data2 = new char[b3];
            for (byte b4 = 0; b4 < b3; ++b4) {
                data2[b4] = (char)Gg3.ar(gg3);
            }
            final String value2 = String.valueOf(data2);
            final F594 f594 = new F594(new Vector3(Gg3.bd(gg3) / 100.0f, Gg3.bd(gg3) / 100.0f, Gg3.bd(gg3) / 100.0f), value);
            f594.h = value2;
            f594.r = (float)Gg3.bd(gg3);
            f594.v = (float)Gg3.bd(gg3);
            f594.w = ar;
            f594.p = true;
            f594.l = (float)Gg3.ar(gg3);
            final F594 f595 = f594;
            f595.l /= 100.0f;
            F594.d(f594);
        }
        if (gg3.v < gg3.r.length) {
            for (int au2 = Gg3.au(gg3), j = 0; j < au2; ++j) {
                final String bk = Gg3.bk(gg3);
                final String bk2 = Gg3.bk(gg3);
                final String[] split = bk.split(",");
                final float float1 = Float.parseFloat(split[1]);
                final float float2 = Float.parseFloat(split[2]);
                final float float3 = Float.parseFloat(split[3]);
                final float float4 = Float.parseFloat(split[4]);
                final float float5 = Float.parseFloat(split[5]);
                final D564 z = SoundManager.c.z(bk2);
                if (D564.g(z)) {
                    D564.j(z, new Q244(float1, float2, float3), float4, float5);
                    D564.q(z, true);
                    F594.m.add(z);
                }
            }
        }
        F594.z = 1.0f;
    }
}
