package rs2.client;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.jnibindings.runetek6.StateEventManager;
import java.util.Iterator;
import tfu.Lb33;

final class T404 extends EventHandler {
   public static void d(T404 var0, GameEntity var1, Object var2) {
      Lb33.g(Lb33.BuildXMap_XElement_trigger);

      try {
         g(var0, var1);
         Ap386 var3 = (Ap386)client.ca.remove(var1);
         if (var3.g != null) {
            Iterator var4 = var3.g.iterator();

            while(var4.hasNext()) {
               V385 var5 = (V385)var4.next();
               var5.j();
            }
         }

         ++client.nw;
         client.ba();
         long var9 = System.currentTimeMillis();
         if (client.ca.isEmpty() || var9 > client.ng + 100L) {
            client.cj.event.triggerEvent((String)"__onMapBuildPart", client.nw);
            client.nw = 0;
            client.ng = var9;
         }

         if (client.ca.isEmpty()) {
            client.bb();
            client.nw = 0;
            StateEventManager.sendEvent(client.nh);
         }

         Lb33.d(Lb33.BuildXMap_XElement_trigger);
      } finally {
         Lb33.d(Lb33.BuildXMap_XElement_trigger);
      }
   }

   private static void g(T404 var0, GameEntity var1) {
      client.gz.d(var1, (float)client.gn, (float)client.gj, client.ds, (Integer)null);
      Iterator var2 = var1.ai().iterator();

      while(var2.hasNext()) {
         SceneGraphNode var3 = (SceneGraphNode)var2.next();
         if (var3 instanceof GameEntity) {
            g(var0, (GameEntity)var3);
         }
      }

   }
}
