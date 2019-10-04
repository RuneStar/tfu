// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.maths.E41;
import com.jagex.maths.Vector3;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.Q40;

final class C414 implements Q40
{
    @Override
    public PhysicsWorldWrapper g() {
        return client.gz.d;
    }
    
    @Override
    public int d() {
        throw new IllegalStateException("This is a server-only command!");
    }
    
    @Override
    public void q(final Vector3 vector3) {
        throw new IllegalStateException("This is a server-only command at present!");
    }
    
    @Override
    public E41 j() {
        throw new IllegalStateException("getAabb not supported on this entity");
    }
    
    @Override
    public Vector3 h() {
        return Vector3.g;
    }
    
    @Override
    public Vector3 e() {
        return Vector3.g;
    }
}
