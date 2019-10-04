package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.State;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class K189 implements State {
   public final Map d = new HashMap();
   public final Map g = new HashMap();
   public Av190 j = null;
   public Integer q = null;

   K189(K189 var1) {
      Iterator var2 = var1.g.entrySet().iterator();

      Entry var3;
      while(var2.hasNext()) {
         var3 = (Entry)var2.next();
         this.g.put(var3.getKey(), var3.getValue());
      }

      var2 = var1.d.entrySet().iterator();

      while(var2.hasNext()) {
         var3 = (Entry)var2.next();
         this.d.put(var3.getKey(), var3.getValue());
      }

      this.q = var1.q;
      this.j = var1.j;
   }

   public K189() {
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();

      Entry var3;
      String var4;
      for(Iterator var2 = this.g.entrySet().iterator(); var2.hasNext(); var1.append(" {" + var4 + ":" + var3.getValue() + "}")) {
         var3 = (Entry)var2.next();
         var4 = (String)PlayerPhysicsComponent.ab.get(var3.getKey());
         if (var4 == null) {
            var4 = "[" + var3.getKey() + "]";
         }
      }

      return var1.toString();
   }
}
