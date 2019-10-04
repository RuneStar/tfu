package tfu;

import java.io.IOException;
import java.net.Socket;

public abstract class Hx339 {
   public abstract void s();

   public abstract boolean d(int var1) throws IOException;

   public abstract int q() throws IOException;

   public static Hx339 g(Socket var0, int var1) throws IOException {
      return new Hu432(var0, var1);
   }

   public abstract void h();

   public abstract void e(byte[] var1, int var2, int var3) throws IOException;

   public abstract int j(byte[] var1, int var2, int var3) throws IOException;
}
