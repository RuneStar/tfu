package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.ArrayList;
import tfu.Bb4;

abstract class V385 {
   final Bb4 q;

   final void j() {
      try {
         if (!client.ca.isEmpty()) {
            Object var1 = Scene.t(client.mm, this.q);
            if (var1 != null) {
               while(true) {
                  if (SceneGraphNode.a((SceneGraphNode)var1) == null) {
                     if (var1 instanceof GameEntity) {
                        GameEntity var2 = (GameEntity)var1;
                        Ap386 var3 = (Ap386)client.ca.get(var2);
                        if (var3 != null) {
                           if (var3.g == null) {
                              var3.g = new ArrayList();
                           }

                           var3.g.add(this);
                           return;
                        }
                     }
                     break;
                  }

                  var1 = SceneGraphNode.a((SceneGraphNode)var1);
               }
            }
         }

         this.g();
      } catch (Exception var4) {
         System.out.print("Error processing broadcast packet: ");
         var4.printStackTrace(System.out);
      }

   }

   V385(Bb4 var1) {
      this.q = var1;
   }

   abstract void g();
}
