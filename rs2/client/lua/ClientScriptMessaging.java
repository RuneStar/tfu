package rs2.client.lua;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.N272;
import rs2.client.client;
import rs2.shared.lua.G284;
import tfu.Ah536;
import tfu.Az399;
import tfu.Be2;
import tfu.Bs1;
import tfu.El328;
import tfu.Eu326;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Lb33;

@ScriptEntryClass("ScriptMessaging")
public final class ClientScriptMessaging {
   private static boolean d;
   public static List j = new LinkedList();
   private static final Logger logger = LoggerFactory.getLogger(ClientScriptMessaging.class);
   private static Ah536 q;

   public static Az399 q(Gg3 var0) {
      return q.q(var0, client.cj);
   }

   public static void d(N272 var0) {
      Lb33.g(Lb33.SendScriptMessages);

      try {
         while(!j.isEmpty()) {
            El328 var1 = El328.d(Eu326.SCRIPT_MESSAGE, var0.s);
            Gs329.i(var1.q, 0);
            int var2 = var1.q.v;
            Gs329 var10000 = var1.q;
            var10000.v += 2;
            Iterator var3 = j.iterator();
            int var4 = 0;

            while(var3.hasNext()) {
               Az399 var5 = (Az399)var3.next();
               int var6 = Ah536.d(q, var5);
               G284.g(client.ls, (long)var6);
               if (6 + var6 > 1350) {
                  logger.error("Dropping script message of type " + var5.e + ":" + var5.h + " and size " + var6 + " as it too long for buffer!");
                  var3.remove();
               } else {
                  if (2 + var1.q.v + var6 > 1350) {
                     break;
                  }

                  q.g(var5, var1.q, d);
                  var3.remove();
                  ++var4;
               }
            }

            int var10 = var1.q.v;
            var1.q.v = var2;
            Gs329.i(var1.q, var4);
            var1.q.v = var10;
            Gs329.as(var1.q, var1.q.v - var2);
            N272.e(var0, var1);
         }

         Lb33.d(Lb33.SendScriptMessages);
      } finally {
         Lb33.d(Lb33.SendScriptMessages);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void Send(Object var0, @ScriptID Integer var1, String var2, String var3, byte[] var4) {
      j.add(new Az399(client.cj, var0, var1, var3, var2, var4));
   }

   public static void g(List var0, boolean var1) {
      q = new Ah536(var0);
      d = var1;
   }
}
