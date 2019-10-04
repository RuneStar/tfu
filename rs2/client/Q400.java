package rs2.client;

import com.jagex.jnibindings.runetek6.Ping;
import java.io.IOException;

final class Q400 implements Runnable {
   public void run() {
      while(Al161.j()) {
         synchronized(this) {
            if (Al161.e() != null) {
               try {
                  Al161.d = Ping.g(Al161.e(), 1000L);
               } catch (IOException var5) {
                  Al161.d = -1;
               }
            }
         }

         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var4) {
         }
      }

      Ping.quit();
   }
}
