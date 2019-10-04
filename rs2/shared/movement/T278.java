/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import rs2.shared.movement.Ai37;
import rs2.shared.movement.E181;

public class T278
implements Ai37 {
    private Vector3 d = Vector3.g;
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
        E181 e181 = new E181();
        e181.g = new Q7(M47.g, this.g);
        e181.d = this.d;
        return e181;
    }

    @Override
    public void h(Q7 q7) {
        this.g = q7.g;
    }

    public T278(Vector3 vector3) {
        this.g = vector3;
    }

    @Override
    public void d(Vector3 vector3, float f, boolean bl) {
        this.d = vector3;
        this.g = Vector3.z(this.g, this.d);
    }
}

