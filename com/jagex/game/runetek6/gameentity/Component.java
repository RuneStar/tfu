package com.jagex.game.runetek6.gameentity;

import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

public abstract class Component {
   public static final int ax = 305419896;
   private GameEntity au;

   public void bd() {
   }

   public String toString() {
      return this.au + ":" + this.getClass().getSimpleName();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final GameEntity getEntity() {
      return this.au;
   }

   static void bp(Component var0, GameEntity var1) {
      Scene var2;
      if (var0.au != null) {
         var0.detachFromEntity();
         var2 = var0.au.getScene();
         if (var2 != null) {
            var2.p(var0);
         }
      }

      var0.au = var1;
      if (var0.au != null) {
         var0.attachToEntity();
         var2 = var0.au.getScene();
         if (var2 != null) {
            var2.y(var0);
         }
      }

   }

   protected void detachFromEntity() {
   }

   protected void attachToEntity() {
   }

   public void addedToScene() {
   }

   public void removingFromScene() {
   }
}
