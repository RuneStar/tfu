package tfu;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import java.util.Comparator;

final class Lh494 implements Comparator {
   public static int g(Lh494 var0, Integer var1, Integer var2) {
      return LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var1, var2);
   }
}
