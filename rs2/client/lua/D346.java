package rs2.client.lua;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.Vector3;
import java.util.Comparator;

class D346 implements Comparator {
   final Vector3 g;

   public static int g(D346 var0, GameEntity var1, GameEntity var2) {
      Vector3 var3 = var1.getWorldTransform().trans;
      Vector3 var4 = var2.getWorldTransform().trans;
      Vector3 var5 = Vector3.k(var3, var0.g);
      Vector3 var6 = Vector3.k(var4, var0.g);
      float var7 = Vector3.c(var5);
      float var8 = Vector3.c(var6);
      return var7 < var8 ? -1 : 1;
   }

   public D346(Vector3 var1) {
      this.g = var1;
   }
}
