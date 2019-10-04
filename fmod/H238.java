package fmod;

public class H238 {
   public long g = 0L;

   public static boolean g(H238 var0) {
      return var0.g != 0L;
   }

   public H238(long var1) {
      this.g = var1;
   }

   public static int q(H238 var0, int var1) {
      return fmod.Channel_getPosition(var0.g, var1);
   }

   public V241 d() {
      return new V241(fmod.Channel_getCurrentSound(this.g));
   }

   public static int j(H238 var0, int var1, int var2) {
      return fmod.Channel_setPosition(var0.g, var1, var2);
   }
}
