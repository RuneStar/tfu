package tfu;

import java.util.concurrent.Future;

final class K547 implements Ir421 {
   public boolean resourceNeedsRefCounting() {
      return true;
   }

   public N105 g(Fk353[] var1, Hi86 var2) throws Hh420 {
      N105 var3 = Ai354.d(var1, var2);
      Future var4 = B665.g().d(var3);

      try {
         return (N105)var4.get();
      } catch (Exception var6) {
         throw new Hh420(var6);
      }
   }
}
