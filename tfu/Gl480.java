package tfu;

import java.nio.ByteBuffer;
import java.util.Arrays;

public abstract class Gl480 {
   public static boolean d = false;
   private static final boolean g = true;

   public static byte[] d(Object var0, boolean var1) {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof byte[]) {
         byte[] var4 = (byte[])var0;
         return var1 ? Arrays.copyOf(var4, var4.length) : var4;
      } else if (var0 instanceof ByteBuffer) {
         ByteBuffer var2 = (ByteBuffer)var0;
         byte[] var3 = new byte[var2.capacity()];
         var2.position(0);
         var2.get(var3);
         return var3;
      } else {
         throw new IllegalArgumentException("Not a ByteBuffer!");
      }
   }

   public static Object g(byte[] var0, boolean var1) {
      if (var0 == null) {
         return null;
      } else if (var0.length > 136 && !d) {
         ByteBuffer var2 = ByteBuffer.allocateDirect(var0.length);
         var2.position(0);
         var2.put(var0);
         return var2;
      } else {
         return var1 ? Arrays.copyOf(var0, var0.length) : var0;
      }
   }

   private Gl480() {
   }
}
