package tfu;

import java.util.HashMap;
import java.util.Map;

public class Hg85 {
   private Map d = new HashMap();
   private Map g = new HashMap();

   public Object[] g(Class var1, Class var2, Object var3) {
      Iy427 var4 = (Iy427)this.d.get(var1);
      if (var4 == null) {
         throw new RuntimeException("");
      } else {
         He426 var5 = (He426)this.g.get(var2);
         if (var5 == null) {
            throw new RuntimeException("");
         } else {
            return var5.g(var3, var4);
         }
      }
   }
}
