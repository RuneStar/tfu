package com.jagex.game.runetek6.scenegraph;

import com.jagex.maths.E41;
import com.jagex.maths.Q10;
import com.jagex.maths.S318;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class E254 {
   public Collection d;
   public final E254[] g;

   protected E254(E254[] var1) {
      this.g = var1;
   }

   public static final void g(E254 var0, E41 var1, Collection var2) {
      if (j(var0, var1)) {
         if (var0.d != null) {
            Iterator var3 = var0.d.iterator();

            while(var3.hasNext()) {
               SceneGraphNode var4 = (SceneGraphNode)var3.next();
               Q10 var5 = SceneGraphNode.i(var4);
               if (var5 != null && var5.b(var1)) {
                  var2.add(var4);
               }
            }
         }

         if (var0.g != null) {
            for(int var6 = 0; var6 < var0.g.length; ++var6) {
               g(var0.g[var6], var1, var2);
            }
         }
      }

   }

   final E254 s(SceneGraphNode var1) {
      E254 var2;
      if (h(this, SceneGraphNode.i(var1))) {
         var2 = this;
         if (this.g != null) {
            for(int var3 = 0; var3 < this.g.length; ++var3) {
               E254 var4 = this.g[var3].s(var1);
               if (var4 != null) {
                  var2 = var4;
               }
            }
         }

         if (var2 == this) {
            if (this.d == null) {
               this.d = new HashSet();
            }

            this.d.add(var1);
         }
      } else {
         var2 = null;
      }

      return var2;
   }

   public E254() {
      this((E254[])null);
   }

   public static boolean j(E254 var0, E41 var1) {
      return true;
   }

   public static boolean e(E254 var0, S318 var1) {
      return true;
   }

   public static boolean h(E254 var0, Q10 var1) {
      return true;
   }

   public static final void d(E254 var0, S318 var1, Collection var2) {
      if (e(var0, var1)) {
         if (var0.d != null) {
            Iterator var3 = var0.d.iterator();

            while(var3.hasNext()) {
               SceneGraphNode var4 = (SceneGraphNode)var3.next();
               Q10 var5 = SceneGraphNode.i(var4);
               if (var5 != null && S318.g(var1, var5)) {
                  var2.add(var4);
               }
            }
         }

         if (var0.g != null) {
            for(int var6 = 0; var6 < var0.g.length; ++var6) {
               d(var0.g[var6], var1, var2);
            }
         }
      }

   }

   public static final int q(E254 var0, S318 var1, SceneGraphNode[] var2, int var3) {
      int var4 = 0;
      if (e(var0, var1)) {
         if (var0.d != null) {
            Iterator var5 = var0.d.iterator();

            while(var5.hasNext()) {
               SceneGraphNode var6 = (SceneGraphNode)var5.next();
               Q10 var7 = SceneGraphNode.i(var6);
               if (var7 != null && S318.g(var1, var7)) {
                  var2[var3++] = var6;
                  ++var4;
               }
            }
         }

         if (var0.g != null) {
            for(int var8 = 0; var8 < var0.g.length; ++var8) {
               var4 += q(var0.g[var8], var1, var2, var3);
            }
         }
      }

      return var4;
   }
}
