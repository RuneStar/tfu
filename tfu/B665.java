package tfu;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

public final class B665 {
   private static B665 g;
   final ConcurrentLinkedQueue d = new ConcurrentLinkedQueue();

   public Future d(S671 var1) {
      E670 var2 = new E670(var1);
      this.d.add(var2);
      return var2;
   }

   public static B665 g() {
      if (g == null) {
         g = new B665();
      }

      return g;
   }

   private B665() {
   }

   public static void q(B665 var0) {
      Lb33.g(Lb33.GraphicsResourceFactory);

      try {
         E670 var1;
         while((var1 = (E670)var0.d.poll()) != null) {
            E670.q(var1);
         }

         Lb33.d(Lb33.GraphicsResourceFactory);
      } finally {
         Lb33.d(Lb33.GraphicsResourceFactory);
      }
   }
}
