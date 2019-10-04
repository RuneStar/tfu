package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.StateFactory;
import java.nio.ByteBuffer;

final class Az206 implements StateFactory {
   public static A207 g(Az206 var0) {
      return ScheduledMovementComponent.g;
   }

   public static A207 d(Az206 var0, A207 var1) {
      return var1;
   }

   public static void q(Az206 var0, A207 var1, A207 var2, ByteBuffer var3) {
      if (var1 == null || !var2.equals(var1)) {
         var3.putFloat(var2.j);
         var3.putFloat(var2.e);
         if (!var2.h) {
            var3.putFloat(var2.g);
            var3.putFloat(var2.d);
            var3.putFloat(var2.q);
            if (var2.s != 0.0F || var2.b != 0.0F || var2.l != 0.0F) {
               var3.putFloat(var2.s);
               var3.putFloat(var2.b);
               var3.putFloat(var2.l);
            }
         }
      }

   }

   public A207 j(A207 var1, ByteBuffer var2) {
      if (var2.hasRemaining()) {
         float var3 = var2.getFloat();
         float var4 = var2.getFloat();
         float var5 = 0.0F;
         float var6 = 0.0F;
         float var7 = 0.0F;
         float var8 = 0.0F;
         float var9 = 0.0F;
         float var10 = 0.0F;
         boolean var11 = true;
         if (var2.hasRemaining()) {
            var11 = false;
            var5 = var2.getFloat();
            var6 = var2.getFloat();
            var7 = var2.getFloat();
            if (var2.hasRemaining()) {
               var8 = var2.getFloat();
               var9 = var2.getFloat();
               var10 = var2.getFloat();
            }
         }

         return new A207(var5, var6, var7, var3, var4, var11, var8, var9, var10);
      } else {
         return var1;
      }
   }
}
