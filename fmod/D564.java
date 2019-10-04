package fmod;

public class D564 {
   public String d = "";
   public long g = 0L;

   public static void d(D564 var0) {
      if (g(var0)) {
         fmod.EventReverb_release(var0.g);
      }

   }

   public String toString() {
      return this.d;
   }

   public static void q(D564 var0, boolean var1) {
      if (g(var0)) {
         fmod.EventReverb_setActive(var0.g, var1);
      }

   }

   public static void j(D564 var0, Q244 var1, float var2, float var3) {
      if (g(var0)) {
         fmod.EventReverb_set3DAttributes(var0.g, var1.g, var1.d, var1.q, var2, var3);
      }

   }

   public D564(long var1) {
      this.g = var1;
   }

   public static boolean g(D564 var0) {
      return var0.g != 0L;
   }
}
