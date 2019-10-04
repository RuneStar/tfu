// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.Vector3;
import com.jagex.maths.M47;
import com.jagex.game.runetek6.comms.statestream.State;
import java.nio.ByteBuffer;
import com.jagex.game.runetek6.comms.statestream.StateFactory;

public class B348 implements StateFactory
{
    public static void q(final B348 b348, final E181 e181, final E181 e182, final ByteBuffer byteBuffer) {
        byteBuffer.putFloat(e182.g.g.x);
        byteBuffer.putFloat(e182.g.g.y);
        byteBuffer.putFloat(e182.g.g.z);
        byteBuffer.putFloat(e182.g.d.f00);
        byteBuffer.putFloat(e182.g.d.f01);
        byteBuffer.putFloat(e182.g.d.f02);
        byteBuffer.putFloat(e182.g.d.f10);
        byteBuffer.putFloat(e182.g.d.f11);
        byteBuffer.putFloat(e182.g.d.f12);
        byteBuffer.putFloat(e182.g.d.f20);
        byteBuffer.putFloat(e182.g.d.f21);
        byteBuffer.putFloat(e182.g.d.f22);
        byteBuffer.putFloat(e182.d.x);
        byteBuffer.putFloat(e182.d.y);
        byteBuffer.putFloat(e182.d.z);
        byteBuffer.putFloat(e182.q.x);
        byteBuffer.putFloat(e182.q.y);
        byteBuffer.putFloat(e182.q.z);
    }
    
    public E181 d(final E181 e181) {
        return new E181(e181);
    }
    
    public E181 g() {
        return new E181();
    }
    
    public E181 j(final E181 e181, final ByteBuffer byteBuffer) {
        final E181 e182 = new E181();
        e182.g = new Q7(new M47(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat()), new Vector3(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat()));
        e182.d = new Vector3(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
        e182.q = new Vector3(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
        return e182;
    }
}
