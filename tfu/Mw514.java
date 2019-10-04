package tfu;

import java.util.concurrent.ThreadFactory;

public class Mw514 implements ThreadFactory {
   private static long g = 0L;
   private String d;

   public Thread newThread(Runnable var1) {
      Thread var2 = new Thread(var1);
      var2.setDaemon(true);
      ++g;
      var2.setName(this.d + "/" + g);
      return var2;
   }

   public Mw514(String var1) {
      this.d = var1;
   }

   public String toString() {
      return this.getClass().getName() + " \"" + this.d + "\"";
   }
}
