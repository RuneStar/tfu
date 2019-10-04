/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.List;
import rs2.shared.movement.X382;

public class G381
implements StateFactory {
    public X382 d(X382 x382) {
        return new X382(x382);
    }

    public X382 g() {
        return new X382();
    }

    public static void q(G381 g381, X382 x382, X382 x3822, ByteBuffer byteBuffer) {
        G381.j(x382 == null ? null : x382.g, x3822.g, byteBuffer);
    }

    private static void j(List list, List list2, ByteBuffer byteBuffer) {
        int n;
        byteBuffer.mark();
        byteBuffer.putInt(0);
        if (list != null) {
            n = 0;
            for (Integer n2 : list) {
                if (list2.contains(n2)) continue;
                byteBuffer.putInt(n2);
                ++n;
            }
            if (n > 0) {
                int n3 = byteBuffer.position();
                byteBuffer.reset();
                byteBuffer.putInt(n);
                byteBuffer.position(n3);
            }
        }
        byteBuffer.mark();
        byteBuffer.putInt(0);
        n = 0;
        for (Integer n2 : list2) {
            if (list != null && list.contains(n2)) continue;
            byteBuffer.putInt(n2);
            ++n;
        }
        if (n > 0) {
            int n4 = byteBuffer.position();
            byteBuffer.reset();
            byteBuffer.putInt(n);
            byteBuffer.position(n4);
        }
    }

    public X382 e(X382 x382, ByteBuffer byteBuffer) {
        X382 x3822 = x382 != null ? new X382(x382) : new X382();
        G381.h(x3822.g, byteBuffer);
        return x3822;
    }

    private static void h(List list, ByteBuffer byteBuffer) {
        int n;
        int n2 = byteBuffer.getInt();
        for (n = 0; n < n2; ++n) {
            list.remove((Object)byteBuffer.getInt());
        }
        n = byteBuffer.getInt();
        for (int i = 0; i < n; ++i) {
            list.add(byteBuffer.getInt());
        }
    }
}

