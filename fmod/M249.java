package fmod;

public class M249 {
   private long g;

   public M249(long var1) {
      this.g = var1;
   }

   public B561 g() {
      B561 var1 = new B561();
      fmod.EventCategory_getInfo(this.g, var1);
      return var1;
   }

   public String toString() {
      return this.g().g;
   }

   public static int d(M249 var0, float var1) {
      return fmod.EventCategory_setVolume(var0.g, var1);
   }
}
