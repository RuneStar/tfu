package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.Vector3;

public class E181 implements State {
   public Vector3 d;
   public Q7 g;
   public Vector3 q;

   E181(E181 var1) {
      this.g = Q7.q;
      this.d = Vector3.g;
      this.q = Vector3.g;
      this.g = var1.g;
      this.d = var1.d;
      this.q = var1.q;
   }

   public E181() {
      this.g = Q7.q;
      this.d = Vector3.g;
      this.q = Vector3.g;
   }
}
