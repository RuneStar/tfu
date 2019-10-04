package tfu;

import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ko370 {
   private static Thread d;
   private static Logger logger = LoggerFactory.getLogger(Ko370.class);
   private static ConcurrentLinkedQueue q = new ConcurrentLinkedQueue();

   public static void d() {
      Lb33.g(Lb33.MainThreadExecutor);

      try {
         if (d == null) {
            d = Thread.currentThread();
         }

         if (d != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread!");
         } else {
            while(true) {
               Runnable var0 = (Runnable)q.poll();
               if (var0 == null) {
                  Lb33.d(Lb33.MainThreadExecutor);
                  return;
               }

               try {
                  var0.run();
               } catch (Exception var5) {
                  logger.error("Error running task:", var5);
               }
            }
         }
      } finally {
         Lb33.d(Lb33.MainThreadExecutor);
      }
   }

   public static void g(Runnable var0) {
      q.add(var0);
   }
}
