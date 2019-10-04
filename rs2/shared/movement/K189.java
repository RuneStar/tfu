// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import com.jagex.game.runetek6.comms.statestream.State;

public class K189 implements State
{
    public final Map d;
    public final Map g;
    public Av190 j;
    public Integer q;
    
    K189(final K189 k189) {
        this.g = new HashMap();
        this.d = new HashMap();
        this.q = null;
        this.j = null;
        for (final Map.Entry<Object, V> entry : k189.g.entrySet()) {
            this.g.put(entry.getKey(), entry.getValue());
        }
        for (final Map.Entry<Object, V> entry2 : k189.d.entrySet()) {
            this.d.put(entry2.getKey(), entry2.getValue());
        }
        this.q = k189.q;
        this.j = k189.j;
    }
    
    public K189() {
        this.g = new HashMap();
        this.d = new HashMap();
        this.q = null;
        this.j = null;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<Object, V> entry : this.g.entrySet()) {
            String string = PlayerPhysicsComponent.ab.get(entry.getKey());
            if (string == null) {
                string = "[" + entry.getKey() + "]";
            }
            sb.append(" {" + string + ":" + entry.getValue() + "}");
        }
        return sb.toString();
    }
}
