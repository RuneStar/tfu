package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.scripthelpers.STaskFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bn279;
import tfu.Bs1;
import tfu.Bv351;
import tfu.Hi86;
import tfu.Hk84;
import tfu.Ia63;
import tfu.Ik357;
import tfu.Lb33;

@ScriptEntryClass("ElementLibrary")
public class XElementLibrary extends D80 {
   private static final Logger logger = LoggerFactory.getLogger(XElementLibrary.class);
   private final Bv351 b = new Bv351();
   public final Hk84 e;
   final Bk68 h;
   public final Hi86 j;
   private Q79 q;
   public final Ia63 s = new Ab205(this);

   public XElementLibrary(Hi86 var1, Hk84 var2, Q79 var3, Bk68 var4) {
      super((D80)null);
      this.e = var2;
      this.j = var1;
      this.q = var3;
      this.h = var4;
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public STaskFuture getElementForEntity(GameEntity var1, String var2, EventHandler var3) {
      return new STaskFuture(this.r(var1, Hk84.g(this.e, XElement.class, var2), var3));
   }

   public void j(String var1) {
      Q79.g(this.q, var1);
   }

   public static void y(XElementLibrary var0) {
      Hi86.w(var0.j);
   }

   public int d(String var1) {
      return Q79.d(this.q, var1);
   }

   public String q(int var1) {
      return Q79.q(this.q, var1);
   }

   public static void v(XElementLibrary var0) {
      Lb33.g(Lb33.XElementLibraryQueue);

      try {
         while(true) {
            Bn279 var1 = var0.b.g();
            if (var1 == null) {
               Lb33.d(Lb33.XElementLibraryQueue);
               return;
            }

            try {
               GameEntity var2 = ((Bf71)var1.j).g;
               if (var2.getScene() != null) {
                  ((Bf71)var1.j).d.trigger(var1.d(), (Object)null);
               }
            } catch (Exception var6) {
               logger.error("", var6);
            }
         }
      } finally {
         Lb33.d(Lb33.XElementLibraryQueue);
      }
   }

   public static XElement w(XElementLibrary var0, Integer var1) {
      try {
         return (XElement)var0.j.j(XElement.class, var1);
      } catch (Ik357 var3) {
         return null;
      }
   }

   public Bn279 r(GameEntity var1, Integer var2, EventHandler var3) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (var1.getScene() == null) {
         throw new IllegalArgumentException("GetElementForEntity() must be called with an entity already added to a scene - this entity has not been added");
      } else {
         Bf71 var4 = new Bf71();
         var4.g = var1;
         var4.d = var3;
         return this.j.h(XElement.class, var2, new Ad199(this, var1), this.b, var4);
      }
   }
}
