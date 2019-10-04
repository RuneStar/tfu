// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import com.jagex.game.runetek6.comms.statestream.State;

public class X382 implements State
{
    public final List g;
    
    X382(final X382 x382) {
        (this.g = new LinkedList()).addAll(x382.g);
    }
    
    public X382() {
        this.g = new LinkedList();
    }
}
