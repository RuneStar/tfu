package tfu;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class Kc180 {
   private static long d;
   public static final Unsafe g;

   public static void b(long var0, byte var2) {
      g.putByte(var0, var2);
   }

   public static long g(long var0) {
      var0 += 8L;
      long var2 = g.allocateMemory(var0);
      g.putLong(var2, var0);
      var2 += 8L;
      d += var0;
      return var2;
   }

   public static void d(long var0) {
      var0 -= 8L;
      long var2 = g.getLong(var0);
      g.freeMemory(var0);
      d -= var2;
   }

   public static long q() {
      return d;
   }

   public static void j(long var0, long var2, int var4) {
      g.copyMemory(var0, var2, (long)var4);
   }

   public static int e() {
      return g.addressSize();
   }

   static {
      try {
         Field var0 = Unsafe.class.getDeclaredField("theUnsafe");
         var0.setAccessible(true);
         g = (Unsafe)var0.get((Object)null);
      } catch (Exception var1) {
         throw new RuntimeException(var1);
      }
   }

   public static byte y(long var0) {
      return g.getByte(var0);
   }

   public static void l(long var0, char var2) {
      g.putChar(var0, var2);
   }

   public static void r(long var0, int var2) {
      g.putInt(var0, var2);
   }

   public static void v(long var0, float var2) {
      g.putFloat(var0, var2);
   }

   private Kc180() {
   }

   public static short p(long var0) {
      return g.getShort(var0);
   }

   public static int x(long var0) {
      return g.getInt(var0);
   }

   public static float u(long var0) {
      return g.getFloat(var0);
   }

   public static void s(long var0, long var2) {
      g.putAddress(var0, var2);
   }

   public static void w(long var0, short var2) {
      g.putShort(var0, var2);
   }

   public static long h(long var0) {
      return g.getAddress(var0);
   }
}
