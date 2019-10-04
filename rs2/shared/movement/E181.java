/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.Vector3;

public class E181
implements State {
    public Vector3 d;
    public Q7 g = Q7.q;
    public Vector3 q;

    E181(E181 e181) {
        this.d = Vector3.g;
        this.q = Vector3.g;
        this.g = e181.g;
        this.d = e181.d;
        this.q = e181.q;
    }

    public E181() {
        this.d = Vector3.g;
        this.q = Vector3.g;
    }
}

