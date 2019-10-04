package tfu;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class If31 {
   public static byte[] d(File var0, int var1) {
      try {
         byte[] var2 = new byte[var1];
         g(var0, var2, var1);
         return var2;
      } catch (IOException var3) {
         return null;
      }
   }

   public static void g(File var0, byte[] var1, int var2) throws IOException {
      DataInputStream var3 = new DataInputStream(new BufferedInputStream(new FileInputStream(var0)));

      try {
         var3.readFully(var1, 0, var2);
      } catch (EOFException var5) {
      }

      var3.close();
   }

   public static byte[] q(File var0) {
      return d(var0, (int)var0.length());
   }
}
