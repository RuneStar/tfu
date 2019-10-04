package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import java.util.Iterator;
import java.util.NoSuchElementException;

class B478 implements Iterator {
   private int g;
   // $FF: synthetic field
   final S368 d;

   public Object next() {
      Component var1 = g(this);
      if (var1 == null) {
         throw new NoSuchElementException();
      } else {
         ++this.g;
         return var1;
      }
   }

   public boolean hasNext() {
      return g(this) != null;
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   private static Component g(B478 var0) {
      for(; var0.g < var0.d.g.length; ++var0.g) {
         Component var1 = var0.d.g[var0.g];
         if (var1 != null) {
            GameEntity var2 = var1.getEntity();
            if (var2 != null && var2.getScene() == var0.d.d) {
               return var1;
            }
         }
      }

      return null;
   }

   B478(S368 var1) {
      this.d = var1;
      this.g = 0;
   }
}
