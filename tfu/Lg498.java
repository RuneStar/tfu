package tfu;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import java.util.Comparator;

final class Lg498 implements Comparator {
   public static int g(Lg498 var0, Integer var1, Integer var2) {
      return LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var1, var2);
   }
}
