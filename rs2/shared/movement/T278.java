// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;

public class T278 implements Ai37
{
    private Vector3 d;
    private Vector3 g;
    
    @Override
    public Vector3 g() {
        return this.d;
    }
    
    @Override
    public RotTrans q() {
        return new RotTrans(Quaternion.g, this.g);
    }
    
    @Override
    public E181 j() {
        final E181 e181 = new E181();
        e181.g = new Q7(M47.g, this.g);
        e181.d = this.d;
        return e181;
    }
    
    @Override
    public void h(final Q7 q7) {
        this.g = q7.g;
    }
    
    public T278(final Vector3 g) {
        this.d = Vector3.g;
        this.g = g;
    }
    
    @Override
    public void d(final Vector3 d, final float n, final boolean b) {
        this.d = d;
        this.g = Vector3.z(this.g, this.d);
    }
}
