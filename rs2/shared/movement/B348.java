/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import rs2.shared.movement.E181;

public class B348
implements StateFactory {
    public static void q(B348 b348, E181 e181, E181 e1812, ByteBuffer byteBuffer) {
        byteBuffer.putFloat(e1812.g.g.x);
        byteBuffer.putFloat(e1812.g.g.y);
        byteBuffer.putFloat(e1812.g.g.z);
        byteBuffer.putFloat(e1812.g.d.f00);
        byteBuffer.putFloat(e1812.g.d.f01);
        byteBuffer.putFloat(e1812.g.d.f02);
        byteBuffer.putFloat(e1812.g.d.f10);
        byteBuffer.putFloat(e1812.g.d.f11);
        byteBuffer.putFloat(e1812.g.d.f12);
        byteBuffer.putFloat(e1812.g.d.f20);
        byteBuffer.putFloat(e1812.g.d.f21);
        byteBuffer.putFloat(e1812.g.d.f22);
        byteBuffer.putFloat(e1812.d.x);
        byteBuffer.putFloat(e1812.d.y);
        byteBuffer.putFloat(e1812.d.z);
        byteBuffer.putFloat(e1812.q.x);
        byteBuffer.putFloat(e1812.q.y);
        byteBuffer.putFloat(e1812.q.z);
    }

    public E181 d(E181 e181) {
        return new E181(e181);
    }

    public E181 g() {
        return new E181();
    }

    public E181 j(E181 e181, ByteBuffer byteBuffer) {
        E181 e1812 = new E181();
        Vector3 vector3 = new Vector3(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
        float f = byteBuffer.getFloat();
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        float f4 = byteBuffer.getFloat();
        float f5 = byteBuffer.getFloat();
        float f6 = byteBuffer.getFloat();
        float f7 = byteBuffer.getFloat();
        float f8 = byteBuffer.getFloat();
        float f9 = byteBuffer.getFloat();
        M47 m47 = new M47(f, f2, f3, f4, f5, f6, f7, f8, f9);
        e1812.g = new Q7(m47, vector3);
        e1812.d = new Vector3(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
        e1812.q = new Vector3(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
        return e1812;
    }
}

