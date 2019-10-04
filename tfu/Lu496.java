package tfu;

import com.jagex.jnibindings.runetek6.DrawUtilities;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.List;

public class Lu496 {
   public static int e = 0;
   public static int j = 0;
   private int d = -65536;
   private List g = new ArrayList();
   private boolean q = true;

   public static void s(Lu496 var0, boolean var1) {
      var0.q = var1;
   }

   public static boolean h(Lu496 var0) {
      return var0.q;
   }

   public static void e(Lu496 var0, int var1) {
      var0.d = var1;
   }

   private static void q(Lu496 var0, Vector3 var1, Vector3 var2, int var3) {
      DrawUtilities.drawLine(var1.x, var1.y, var1.z, var2.x, var2.y, var2.z, (float)((var3 & 16711680) >> 16) / 255.0F, (float)((var3 & '\uff00') >> 8) / 255.0F, (float)((var3 & 255) >> 0) / 255.0F);
   }

   public static int j(Lu496 var0) {
      return var0.d;
   }

   public static void d(Lu496 var0) {
      Vector3 var1 = (Vector3)g(var0).get(0);
      Vector3 var2 = var1;

      for(int var3 = 1; var3 < var0.g.size(); ++var3) {
         Vector3 var4 = (Vector3)g(var0).get(var3);
         q(var0, var2, var4, j(var0));
         var2 = var4;
      }

      if (h(var0)) {
         q(var0, var2, var1, j(var0));
      }

   }

   public static void b(int var0, int var1) {
      j = var0;
      e = var1;
   }

   public static List g(Lu496 var0) {
      return var0.g;
   }
}
