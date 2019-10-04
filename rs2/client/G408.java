package rs2.client;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.maths.Vector3;
import rs2.shared.movement.I187;
import rs2.shared.movement.PhysicsWorldWrapper;
import tfu.Lz409;

final class G408 implements I187 {
   public PhysicsWorldWrapper g(Vector3 var1) {
      return client.gz.d;
   }

   public boolean q() {
      return client.do_;
   }

   public int e() {
      int var1 = Lz409.p(Lz409.d);
      return var1 >= 0 && LossyStateStream.TIMESTAMP_WIDTH.diffIDs(client.df, var1) > 0 ? var1 : LossyStateStream.TIMESTAMP_WIDTH.sumIDs(client.df, -client.dz);
   }

   public int j() {
      return client.df;
   }

   public boolean d() {
      return true;
   }
}
