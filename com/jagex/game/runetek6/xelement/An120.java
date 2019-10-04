package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.Vector3;
import tfu.Br121;
import tfu.Lb33;

final class An120 implements Br121 {
   // $FF: synthetic field
   final XElement[] d;
   // $FF: synthetic field
   final GameEntity g;
   // $FF: synthetic field
   final boolean j;
   // $FF: synthetic field
   final Vector3 q;

   public boolean q() {
      return true;
   }

   public static G104 g(An120 var0) throws Exception {
      G104 var1 = XElement.bj(var0.g, var0.d, var0.q, XElement.ai.j, var0.j && XElement.f);
      return var1;
   }

   public boolean d() {
      return this.g.getScene() != null;
   }

   public static void j(An120 var0, G104 var1) {
      if (var1 != null) {
         G104.v(var1);
      }

   }

   public int e() {
      int var1 = 0;
      Lb33.g(Lb33.XElement_CalculatePriority);

      try {
         if (this.d.length > 0) {
            Vector3 var2 = null;
            if (this.d.length > 0 && this.d[0] != null) {
               var2 = this.d[0].ah;
               if (var2 != null && this.q != null) {
                  var2 = Vector3.z(var2, this.q);
               }
            }

            if (var2 == null) {
               var2 = this.g.getWorldTransform().trans;
            }

            var1 = XElement.ai.h.g(var2);
         }

         Lb33.d(Lb33.XElement_CalculatePriority);
         return var1;
      } finally {
         Lb33.d(Lb33.XElement_CalculatePriority);
      }
   }

   An120(GameEntity var1, XElement[] var2, Vector3 var3, boolean var4) {
      this.d = var2;
      this.q = var3;
      this.j = var4;
      this.g = var1;
   }
}
