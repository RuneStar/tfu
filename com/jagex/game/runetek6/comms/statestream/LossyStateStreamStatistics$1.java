package com.jagex.game.runetek6.comms.statestream;

import java.util.Comparator;
import java.util.Map.Entry;

final class LossyStateStreamStatistics$1 implements Comparator {
   public int compare(Entry var1, Entry var2) {
      int var3 = ((Integer)var2.getValue()).compareTo((Integer)var1.getValue());
      return var3 == 0 ? 1 : var3;
   }
}
