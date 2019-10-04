// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import java.nio.ByteBuffer;
import com.jagex.game.runetek6.comms.statestream.StateFactory;

final class Az206 implements StateFactory
{
    public static A207 g(final Az206 az206) {
        return ScheduledMovementComponent.g;
    }
    
    public static A207 d(final Az206 az206, final A207 a207) {
        return a207;
    }
    
    public static void q(final Az206 az206, final A207 a207, final A207 a208, final ByteBuffer byteBuffer) {
        if (a207 == null || !a208.equals(a207)) {
            byteBuffer.putFloat(a208.j);
            byteBuffer.putFloat(a208.e);
            if (!a208.h) {
                byteBuffer.putFloat(a208.g);
                byteBuffer.putFloat(a208.d);
                byteBuffer.putFloat(a208.q);
                if (a208.s != 0.0f || a208.b != 0.0f || a208.l != 0.0f) {
                    byteBuffer.putFloat(a208.s);
                    byteBuffer.putFloat(a208.b);
                    byteBuffer.putFloat(a208.l);
                }
            }
        }
    }
    
    public A207 j(final A207 a207, final ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            final float float1 = byteBuffer.getFloat();
            final float float2 = byteBuffer.getFloat();
            float float3 = 0.0f;
            float float4 = 0.0f;
            float float5 = 0.0f;
            float float6 = 0.0f;
            float float7 = 0.0f;
            float float8 = 0.0f;
            boolean b = true;
            if (byteBuffer.hasRemaining()) {
                b = false;
                float3 = byteBuffer.getFloat();
                float4 = byteBuffer.getFloat();
                float5 = byteBuffer.getFloat();
                if (byteBuffer.hasRemaining()) {
                    float6 = byteBuffer.getFloat();
                    float7 = byteBuffer.getFloat();
                    float8 = byteBuffer.getFloat();
                }
            }
            return new A207(float3, float4, float5, float1, float2, b, float6, float7, float8);
        }
        return a207;
    }
}
