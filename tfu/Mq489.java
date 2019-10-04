package tfu;

import com.jagex.game.runetek6.config.vartype.SparseVarDomain;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import java.util.Iterator;

public class Mq489 extends SparseVarDomain implements Iterable {
   int d;
   int g;

   public static int d(Mq489 var0) {
      return var0.g;
   }

   public static int q(Mq489 var0) {
      return var0.d;
   }

   public Iterator iterator() {
      return super.varValues.iterator();
   }

   public static void j(Mq489 var0, int var1) {
      var0.d = var1;
   }

   public Mq489(int var1, int var2, VarTypeList var3) {
      super(var3);
      this.g = var1;
      this.d = var2;
   }
}
