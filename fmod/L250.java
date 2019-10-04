package fmod;

public class L250 {
   private long g;

   public static int d(L250 var0) {
      return fmod.EventParameter_keyOff(var0.g);
   }

   public static boolean g(L250 var0) {
      return var0.g != 0L;
   }

   public static int q(L250 var0, float var1) {
      return fmod.EventParameter_setValue(var0.g, var1);
   }

   public L250(long var1) {
      this.g = var1;
   }
}
