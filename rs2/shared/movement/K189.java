/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import rs2.shared.movement.Av190;
import rs2.shared.movement.PlayerPhysicsComponent;

public class K189
implements State {
    public final Map d;
    public final Map g = new HashMap();
    public Av190 j = null;
    public Integer q = null;

    K189(K189 k189) {
        this.d = new HashMap();
        for (Map.Entry entry : k189.g.entrySet()) {
            this.g.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry : k189.d.entrySet()) {
            this.d.put(entry.getKey(), entry.getValue());
        }
        this.q = k189.q;
        this.j = k189.j;
    }

    public K189() {
        this.d = new HashMap();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : this.g.entrySet()) {
            String string = (String)PlayerPhysicsComponent.ab.get(entry.getKey());
            if (string == null) {
                string = "[" + entry.getKey() + "]";
            }
            stringBuilder.append(" {" + string + ":" + entry.getValue() + "}");
        }
        return stringBuilder.toString();
    }
}

