// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.comms.statestream.State;

public class E181 implements State
{
    public Vector3 d;
    public Q7 g;
    public Vector3 q;
    
    E181(final E181 e181) {
        this.g = Q7.q;
        this.d = Vector3.g;
        this.q = Vector3.g;
        this.g = e181.g;
        this.d = e181.d;
        this.q = e181.q;
    }
    
    public E181() {
        this.g = Q7.q;
        this.d = Vector3.g;
        this.q = Vector3.g;
    }
}
