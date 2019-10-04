package tfu;

public class Ln265 {
   public Ln265 bl;
   public Ln265 bo;
   public long bq;

   public static boolean ek(Ln265 var0) {
      return var0.bl != null;
   }

   public static void ef(Ln265 var0) {
      if (var0.bl != null) {
         var0.bl.bo = var0.bo;
         var0.bo.bl = var0.bl;
         var0.bo = null;
         var0.bl = null;
      }
   }
}
