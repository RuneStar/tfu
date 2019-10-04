// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.comms.statestream.State;
import java.util.Iterator;
import java.util.Map;
import java.nio.ByteBuffer;
import com.jagex.game.runetek6.comms.statestream.StateFactory;

public class R378 implements StateFactory
{
    public K189 g() {
        return new K189();
    }
    
    public K189 d(final K189 k189) {
        return new K189(k189);
    }
    
    public static void q(final R378 r378, final K189 k189, final K189 k190, final ByteBuffer byteBuffer) {
        final int position = byteBuffer.position();
        int n = 0;
        if (k189 != null) {
            byteBuffer.mark();
            byteBuffer.put((byte)0);
            for (final Integer n2 : k189.g.keySet()) {
                if (!k190.g.containsKey(n2)) {
                    byteBuffer.putInt(n2);
                    ++n;
                }
            }
            if (n > 0) {
                final int position2 = byteBuffer.position();
                byteBuffer.reset();
                byteBuffer.put((byte)n);
                byteBuffer.position(position2);
            }
        }
        else {
            byteBuffer.put((byte)0);
        }
        int n3 = 0;
        byteBuffer.mark();
        byteBuffer.put((byte)0);
        for (final Map.Entry<K, Object> entry : k190.g.entrySet()) {
            final Double value = entry.getValue();
            if (k189 != null && value.equals(k189.g.get(entry.getKey()))) {
                continue;
            }
            byteBuffer.putInt((int)entry.getKey());
            byteBuffer.putInt((int)k190.d.get(entry.getKey()));
            if (value instanceof Boolean) {
                byteBuffer.put((byte)(((boolean)(Object)value) ? 1 : 0));
            }
            else if (value instanceof Double) {
                final Double n4 = value;
                byteBuffer.put((byte)2);
                byteBuffer.putDouble(n4);
            }
            ++n3;
        }
        if (n3 > 0) {
            final int position3 = byteBuffer.position();
            byteBuffer.reset();
            byteBuffer.put((byte)n3);
            byteBuffer.position(position3);
        }
        boolean b = false;
        if (k189 == null) {
            b = true;
        }
        else if (k189.q == null) {
            if (k190.q != null) {
                b = true;
            }
        }
        else if (!k189.q.equals(k190.q)) {
            b = true;
        }
        boolean b2 = false;
        if (k189 == null) {
            b2 = true;
        }
        else if (k189.j == null) {
            if (k190.j != null) {
                b2 = true;
            }
        }
        else if (!Av190.g(k189.j, k190.j)) {
            b2 = true;
        }
        if (n == 0 && n3 == 0 && !b && !b2) {
            byteBuffer.position(position);
            return;
        }
        if (!b) {
            byteBuffer.put((byte)0);
        }
        else if (k190.q == null) {
            byteBuffer.put((byte)1);
        }
        else {
            byteBuffer.put((byte)2);
            byteBuffer.putInt(k190.q);
        }
        if (!b2) {
            byteBuffer.put((byte)0);
        }
        else if (k190.j == null) {
            byteBuffer.put((byte)1);
        }
        else {
            byteBuffer.put((byte)2);
            byteBuffer.putFloat(k190.j.g.x);
            byteBuffer.putFloat(k190.j.g.y);
            byteBuffer.putFloat(k190.j.g.z);
            byteBuffer.putFloat(k190.j.d);
            byteBuffer.putInt(k190.j.j);
            byteBuffer.putFloat(k190.j.q);
        }
    }
    
    public K189 j(final K189 k189, final ByteBuffer byteBuffer) {
        K189 k190;
        if (k189 == null) {
            k190 = new K189();
        }
        else {
            k190 = new K189(k189);
        }
        if (byteBuffer.remaining() == 0) {
            return k190;
        }
        for (int n = byteBuffer.get() & 0xFF, i = 0; i < n; ++i) {
            final int int1 = byteBuffer.getInt();
            k190.g.remove(int1);
            k190.d.remove(int1);
        }
        for (int n2 = byteBuffer.get() & 0xFF, j = 0; j < n2; ++j) {
            final int int2 = byteBuffer.getInt();
            final int int3 = byteBuffer.getInt();
            switch (byteBuffer.get()) {
                case 0: {
                    k190.g.put(int2, Boolean.FALSE);
                    k190.d.put(int2, int3);
                    break;
                }
                case 1: {
                    k190.g.put(int2, Boolean.TRUE);
                    k190.d.put(int2, int3);
                    break;
                }
                case 2: {
                    k190.g.put(int2, byteBuffer.getDouble());
                    k190.d.put(int2, int3);
                    break;
                }
            }
        }
        final int n3 = byteBuffer.get() & 0xFF;
        if (n3 == 0) {
            k190.q = ((k189 == null) ? null : k189.q);
        }
        else if (n3 == 1) {
            k190.q = null;
        }
        else {
            k190.q = byteBuffer.getInt();
        }
        final int n4 = byteBuffer.get() & 0xFF;
        if (n4 == 0) {
            k190.j = ((k189 == null) ? null : k189.j);
        }
        else if (n4 == 1) {
            k190.j = null;
        }
        else {
            k190.j = new Av190(new Vector3(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat()), byteBuffer.getFloat(), byteBuffer.getInt(), byteBuffer.getFloat());
        }
        return k190;
    }
}
