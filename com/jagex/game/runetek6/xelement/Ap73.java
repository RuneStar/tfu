package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.ArrayList;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class Ap73 {
   private static final Logger logger = LoggerFactory.getLogger(Ap73.class);
   ArrayList b;
   String s;

   static final void r(Ap73 var0, SceneGraphNode var1) {
      if (var0.b != null) {
         Iterator var2 = var0.b.iterator();

         while(var2.hasNext()) {
            Ap73 var3 = (Ap73)var2.next();

            try {
               SceneGraphNode var4 = var3.y();
               var1.attach(var4, var3.s);
               r(var3, var4);
            } catch (Exception var5) {
               logger.error("", var5);
            }
         }
      }

   }

   abstract SceneGraphNode y();

   abstract void p();

   public static final void v(Ap73 var0) {
      var0.p();
      if (var0.b != null) {
         Iterator var1 = var0.b.iterator();

         while(var1.hasNext()) {
            Ap73 var2 = (Ap73)var1.next();
            v(var2);
         }
      }

   }
}
