package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.jnibindings.runetek6.Skeleton;
import java.util.ArrayList;
import tfu.N105;

public abstract class G104 extends Ap73 {
   static Thread g;
   GameEntity d;
   private N105 e;
   private Skeleton j;
   private long q;

   static N105 q(G104 var0) {
      N105 var1 = var0.e;
      var0.e = null;
      return var1;
   }

   G104(ArrayList var1, long var2, Skeleton var4, N105 var5) {
      super.b = var1;
      this.q = var2;
      this.j = var4;
      this.e = var5;
   }

   public GameEntity j() throws Exception {
      if (g != null && Thread.currentThread() != g) {
         throw new IllegalStateException();
      } else if (this.d.getScene() == null) {
         v(this);
         return null;
      } else {
         this.y();
         r(this, this.d);
         return this.d;
      }
   }

   static long g(G104 var0) {
      long var1 = var0.q;
      var0.q = 0L;
      return var1;
   }

   static Skeleton d(G104 var0) {
      Skeleton var1 = var0.j;
      var0.j = null;
      return var1;
   }
}
