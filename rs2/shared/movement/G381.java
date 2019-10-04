// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import java.util.Iterator;
import java.util.List;
import java.nio.ByteBuffer;
import com.jagex.game.runetek6.comms.statestream.StateFactory;

public class G381 implements StateFactory
{
    public X382 d(final X382 x382) {
        return new X382(x382);
    }
    
    public X382 g() {
        return new X382();
    }
    
    public static void q(final G381 g381, final X382 x382, final X382 x383, final ByteBuffer byteBuffer) {
        j((x382 == null) ? null : x382.g, x383.g, byteBuffer);
    }
    
    private static void j(final List list, final List list2, final ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byteBuffer.putInt(0);
        if (list != null) {
            int n = 0;
            for (final Integer n2 : list) {
                if (!list2.contains(n2)) {
                    byteBuffer.putInt(n2);
                    ++n;
                }
            }
            if (n > 0) {
                final int position = byteBuffer.position();
                byteBuffer.reset();
                byteBuffer.putInt(n);
                byteBuffer.position(position);
            }
        }
        byteBuffer.mark();
        byteBuffer.putInt(0);
        int n3 = 0;
        for (final Integer n4 : list2) {
            if (list == null || !list.contains(n4)) {
                byteBuffer.putInt(n4);
                ++n3;
            }
        }
        if (n3 > 0) {
            final int position2 = byteBuffer.position();
            byteBuffer.reset();
            byteBuffer.putInt(n3);
            byteBuffer.position(position2);
        }
    }
    
    public X382 e(final X382 x382, final ByteBuffer byteBuffer) {
        X382 x383;
        if (x382 != null) {
            x383 = new X382(x382);
        }
        else {
            x383 = new X382();
        }
        h(x383.g, byteBuffer);
        return x383;
    }
    
    private static void h(final List list, final ByteBuffer byteBuffer) {
        for (int int1 = byteBuffer.getInt(), i = 0; i < int1; ++i) {
            list.remove((Object)byteBuffer.getInt());
        }
        for (int int2 = byteBuffer.getInt(), j = 0; j < int2; ++j) {
            list.add(byteBuffer.getInt());
        }
    }
}
