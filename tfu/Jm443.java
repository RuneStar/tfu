package tfu;

import java.io.IOException;
import java.net.Socket;

public abstract class Jm443 {
   protected static final boolean q = true;
   protected int e;
   protected String j;

   public static Jm443 s(String var0, int var1) {
      Ix442 var2 = new Ix442();
      var2.j = var0;
      var2.e = var1;
      System.out.println("Created ProxySocket to " + var0 + ":" + var1);
      return var2;
   }

   public abstract Socket g() throws IOException;

   protected Socket b() throws IOException {
      return new Socket(this.j, this.e);
   }
}
