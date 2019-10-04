/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.maths.Vector3;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Set;
import rs2.shared.movement.Av190;
import rs2.shared.movement.K189;

public class R378
implements StateFactory {
    public K189 g() {
        return new K189();
    }

    public K189 d(K189 k189) {
        return new K189(k189);
    }

    public static void q(R378 r378, K189 k189, K189 k1892, ByteBuffer byteBuffer) {
        int n = byteBuffer.position();
        int n2 = 0;
        if (k189 != null) {
            byteBuffer.mark();
            byteBuffer.put((byte)0);
            for (Object object : k189.g.keySet()) {
                if (k1892.g.containsKey(object)) continue;
                byteBuffer.putInt((Integer)object);
                ++n2;
            }
            if (n2 > 0) {
                int n3 = byteBuffer.position();
                byteBuffer.reset();
                byteBuffer.put((byte)n2);
                byteBuffer.position(n3);
            }
        } else {
            byteBuffer.put((byte)0);
        }
        int n4 = 0;
        byteBuffer.mark();
        byteBuffer.put((byte)0);
        for (Map.Entry entry : k1892.g.entrySet()) {
            Object object;
            Object v = entry.getValue();
            if (k189 != null && v.equals(object = k189.g.get(entry.getKey()))) continue;
            byteBuffer.putInt((Integer)entry.getKey());
            byteBuffer.putInt((Integer)k1892.d.get(entry.getKey()));
            if (v instanceof Boolean) {
                object = (Boolean)v;
                byteBuffer.put((byte)(((Boolean)object).booleanValue() ? 1 : 0));
            } else if (v instanceof Double) {
                object = (Double)v;
                byteBuffer.put((byte)2);
                byteBuffer.putDouble((Double)object);
            }
            ++n4;
        }
        if (n4 > 0) {
            int n5 = byteBuffer.position();
            byteBuffer.reset();
            byteBuffer.put((byte)n4);
            byteBuffer.position(n5);
        }
        boolean bl = false;
        if (k189 == null) {
            bl = true;
        } else if (k189.q == null) {
            if (k1892.q != null) {
                bl = true;
            }
        } else if (!k189.q.equals(k1892.q)) {
            bl = true;
        }
        boolean bl2 = false;
        if (k189 == null) {
            bl2 = true;
        } else if (k189.j == null) {
            if (k1892.j != null) {
                bl2 = true;
            }
        } else if (!Av190.g(k189.j, k1892.j)) {
            bl2 = true;
        }
        if (n2 == 0 && n4 == 0 && !bl && !bl2) {
            byteBuffer.position(n);
            return;
        }
        if (!bl) {
            byteBuffer.put((byte)0);
        } else if (k1892.q == null) {
            byteBuffer.put((byte)1);
        } else {
            byteBuffer.put((byte)2);
            byteBuffer.putInt(k1892.q);
        }
        if (!bl2) {
            byteBuffer.put((byte)0);
        } else if (k1892.j == null) {
            byteBuffer.put((byte)1);
        } else {
            byteBuffer.put((byte)2);
            byteBuffer.putFloat(k1892.j.g.x);
            byteBuffer.putFloat(k1892.j.g.y);
            byteBuffer.putFloat(k1892.j.g.z);
            byteBuffer.putFloat(k1892.j.d);
            byteBuffer.putInt(k1892.j.j);
            byteBuffer.putFloat(k1892.j.q);
        }
    }

    public K189 j(K189 k189, ByteBuffer byteBuffer) {
        int n;
        int n2;
        int n3;
        K189 k1892 = k189 == null ? new K189() : new K189(k189);
        if (byteBuffer.remaining() == 0) {
            return k1892;
        }
        int n4 = byteBuffer.get() & 0xFF;
        for (n2 = 0; n2 < n4; ++n2) {
            n = byteBuffer.getInt();
            k1892.g.remove(n);
            k1892.d.remove(n);
        }
        n2 = byteBuffer.get() & 0xFF;
        block6 : for (n = 0; n < n2; ++n) {
            n3 = byteBuffer.getInt();
            int n5 = byteBuffer.getInt();
            byte by = byteBuffer.get();
            switch (by) {
                case 0: {
                    k1892.g.put(n3, Boolean.FALSE);
                    k1892.d.put(n3, n5);
                    continue block6;
                }
                case 1: {
                    k1892.g.put(n3, Boolean.TRUE);
                    k1892.d.put(n3, n5);
                    continue block6;
                }
                case 2: {
                    double d = byteBuffer.getDouble();
                    k1892.g.put(n3, d);
                    k1892.d.put(n3, n5);
                }
            }
        }
        n = byteBuffer.get() & 0xFF;
        k1892.q = n == 0 ? (k189 == null ? null : k189.q) : (n == 1 ? null : Integer.valueOf(byteBuffer.getInt()));
        n3 = byteBuffer.get() & 0xFF;
        if (n3 == 0) {
            k1892.j = k189 == null ? null : k189.j;
        } else if (n3 == 1) {
            k1892.j = null;
        } else {
            float f = byteBuffer.getFloat();
            float f2 = byteBuffer.getFloat();
            float f3 = byteBuffer.getFloat();
            float f4 = byteBuffer.getFloat();
            int n6 = byteBuffer.getInt();
            float f5 = byteBuffer.getFloat();
            k1892.j = new Av190(new Vector3(f, f2, f3), f4, n6, f5);
        }
        return k1892;
    }
}

