/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import java.nio.ByteBuffer;
import rs2.shared.movement.A207;
import rs2.shared.movement.ScheduledMovementComponent;

final class Az206
implements StateFactory {
    public static A207 g(Az206 az206) {
        return ScheduledMovementComponent.g;
    }

    public static A207 d(Az206 az206, A207 a207) {
        return a207;
    }

    public static void q(Az206 az206, A207 a207, A207 a2072, ByteBuffer byteBuffer) {
        if (a207 == null || !a2072.equals(a207)) {
            byteBuffer.putFloat(a2072.j);
            byteBuffer.putFloat(a2072.e);
            if (!a2072.h) {
                byteBuffer.putFloat(a2072.g);
                byteBuffer.putFloat(a2072.d);
                byteBuffer.putFloat(a2072.q);
                if (a2072.s != 0.0f || a2072.b != 0.0f || a2072.l != 0.0f) {
                    byteBuffer.putFloat(a2072.s);
                    byteBuffer.putFloat(a2072.b);
                    byteBuffer.putFloat(a2072.l);
                }
            }
        }
    }

    public A207 j(A207 a207, ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            float f = byteBuffer.getFloat();
            float f2 = byteBuffer.getFloat();
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            boolean bl = true;
            if (byteBuffer.hasRemaining()) {
                bl = false;
                f3 = byteBuffer.getFloat();
                f4 = byteBuffer.getFloat();
                f5 = byteBuffer.getFloat();
                if (byteBuffer.hasRemaining()) {
                    f6 = byteBuffer.getFloat();
                    f7 = byteBuffer.getFloat();
                    f8 = byteBuffer.getFloat();
                }
            }
            return new A207(f3, f4, f5, f, f2, bl, f6, f7, f8);
        }
        return a207;
    }

    Az206() {
    }
}

