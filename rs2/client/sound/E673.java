package rs2.client.sound;

import tfu.Gg3;

final class E673 implements Z674 {
   public void g(String var1, Object var2) {
   }

   public void d(byte[] var1, Object var2) {
      K589.q.clear();
      K589.j.clear();
      Gg3 var3 = new Gg3(var1);
      int var4 = Gg3.au(var3);

      int var5;
      for(var5 = 0; var5 < var4; ++var5) {
         K589.j.add(Gg3.bk(var3));
      }

      var5 = Gg3.au(var3);

      for(int var6 = 0; var6 < var5; ++var6) {
         X675 var7 = new X675();
         var7.p(var3);
         K589.q.add(var7);
      }

      K589.w = System.currentTimeMillis() + 33L;
      K589.d = true;
      if (K589.e != null) {
         K589.h(K589.e, K589.h);
         K589.h = null;
         K589.e = null;
      }

      K589.l = System.currentTimeMillis();
   }

   public void q() {
   }
}
