package tfu;

public class Ap127 {
   public static final boolean b = false;
   public static boolean d = false;
   public static boolean e = false;
   public static boolean g = false;
   public static int h = 0;
   public static float j = 2.0F;
   public static int q = 50;
   public static final boolean s = false;

   public static void g(long var0, String var2) {
      if (d) {
         float var3 = (float)var0 * 1.0E-6F;
         var3 = (float)((int)(var3 * 10.0F)) / 10.0F;
         int var4 = (int)var3;
         if (var4 > 100) {
            var4 = 100;
         }

         for(int var5 = 1; var5 < var4; ++var5) {
            System.out.print(" ");
         }

         if (var3 > 10.0F) {
            System.out.println("!!! " + var2);
         } else {
            System.out.println(var2);
         }
      }

   }
}
