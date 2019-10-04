package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import java.util.LinkedList;
import java.util.List;

public class X382 implements State {
   public final List g = new LinkedList();

   X382(X382 var1) {
      this.g.addAll(var1.g);
   }

   public X382() {
   }
}
