package rs2.client.sound;

import tfu.Gg3;

final class V696 implements Z674 {
   public void d(byte[] var1, Object var2) {
      Gg3 var3 = new Gg3(var1);
      int var4 = Gg3.au(var3);
      Ag588.e.clear();

      for(int var5 = 0; var5 < var4; ++var5) {
         Ag588 var6 = new Ag588();
         int var7 = Gg3.au(var3);
         var6.d = Gg3.bk(var3);
         var6.q = Gg3.bk(var3);
         var6.j = Gg3.bk(var3);
         int var8 = Gg3.au(var3);

         for(int var9 = 0; var9 < var8; ++var9) {
            String var10 = Gg3.bk(var3);
            String var11 = Gg3.bk(var3);
            var6.g.put(var10, var11);
            if (var9 == 22) {
               byte var12 = 0;
               int var13 = var12 + 1;
            }
         }

         Ag588.e.put(var7, var6);
      }

   }

   public void g(String var1, Object var2) {
   }

   public void q() {
      Ag588.e.clear();
   }
}
