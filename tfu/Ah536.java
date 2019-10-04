package tfu;

import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.script.resource.proto.ProtocolBufferDefinition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Ah536 {
   private final Map d = new HashMap();
   private final HashMap g = new HashMap();

   public Ah536(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ProtocolBufferDefinition var3 = (ProtocolBufferDefinition)var2.next();
         Iterator var4 = var3.messageProtocolIds.iterator();

         while(var4.hasNext()) {
            Js343 var5 = (Js343)var4.next();
            this.g.put(new Av542(this, var3.name, (String)var5.d), var5.q);
            this.d.put(var5.q, new Js343(var3.name, var5.d));
         }
      }

   }

   public static int d(Ah536 var0, Az399 var1) {
      return 5 + Gg3.av(var1.h) + Gg3.av(var1.e) + 2 + var1.s.length;
   }

   public final Az399 q(Gg3 var1, ScriptManager var2) {
      Az399 var3 = new Az399(var2);
      int var4 = Gg3.ar(var1);
      var3.q = null;
      var3.j = Gg3.bd(var1);
      int var5;
      switch(Gg3.ar(var1)) {
      case 0:
         var5 = Gg3.bd(var1);
         Js343 var6 = (Js343)this.d.get(var5);
         var3.e = (String)var6.d;
         var3.h = (String)var6.q;
         break;
      case 1:
         var3.e = var1.bh();
         var3.h = var1.bh();
         break;
      default:
         throw new IllegalStateException();
      }

      var5 = Gg3.au(var1);
      var3.s = new byte[var5];
      Gg3.bx(var1, var3.s, 0, var5);
      return var3;
   }

   public final void g(Az399 var1, Gg3 var2, boolean var3) {
      Gg3.k(var2, 0);
      Gg3.a(var2, var1.j);
      if (var3) {
         Integer var4 = (Integer)this.g.get(new Av542(this, var1.e, var1.h));
         if (var4 == null) {
            var3 = false;
         } else {
            Gg3.k(var2, 0);
            Gg3.a(var2, var4);
         }
      }

      if (!var3) {
         Gg3.k(var2, 1);
         var2.ap(var1.e);
         var2.ap(var1.h);
      }

      Gg3.i(var2, var1.s.length);
      Gg3.aa(var2, var1.s, 0, var1.s.length);
   }
}
