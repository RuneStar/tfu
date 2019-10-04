package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.StateFactory;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public class G381 implements StateFactory {
   public X382 d(X382 var1) {
      return new X382(var1);
   }

   public X382 g() {
      return new X382();
   }

   public static void q(G381 var0, X382 var1, X382 var2, ByteBuffer var3) {
      j(var1 == null ? null : var1.g, var2.g, var3);
   }

   private static void j(List var0, List var1, ByteBuffer var2) {
      var2.mark();
      var2.putInt(0);
      int var3;
      Iterator var4;
      Integer var5;
      int var6;
      if (var0 != null) {
         var3 = 0;
         var4 = var0.iterator();

         while(var4.hasNext()) {
            var5 = (Integer)var4.next();
            if (!var1.contains(var5)) {
               var2.putInt(var5);
               ++var3;
            }
         }

         if (var3 > 0) {
            var6 = var2.position();
            var2.reset();
            var2.putInt(var3);
            var2.position(var6);
         }
      }

      var2.mark();
      var2.putInt(0);
      var3 = 0;
      var4 = var1.iterator();

      while(true) {
         do {
            if (!var4.hasNext()) {
               if (var3 > 0) {
                  var6 = var2.position();
                  var2.reset();
                  var2.putInt(var3);
                  var2.position(var6);
               }

               return;
            }

            var5 = (Integer)var4.next();
         } while(var0 != null && var0.contains(var5));

         var2.putInt(var5);
         ++var3;
      }
   }

   public X382 e(X382 var1, ByteBuffer var2) {
      X382 var3;
      if (var1 != null) {
         var3 = new X382(var1);
      } else {
         var3 = new X382();
      }

      h(var3.g, var2);
      return var3;
   }

   private static void h(List var0, ByteBuffer var1) {
      int var2 = var1.getInt();

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var0.remove(var1.getInt());
      }

      var3 = var1.getInt();

      for(int var4 = 0; var4 < var3; ++var4) {
         var0.add(var1.getInt());
      }

   }
}
