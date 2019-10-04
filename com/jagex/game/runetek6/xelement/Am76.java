package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;

public class Am76 extends N78 {
   private static final Logger logger = LoggerFactory.getLogger(Am76.class);
   public String aa;
   public Vector3 ah;
   public Float ao;
   public Quaternion ap;

   static void ep(Ap73 var0, ArrayList var1, N78 var2, Hi86 var3, ScriptManager var4, boolean var5) {
      Iterator var6;
      if (var5 && var2.al != null) {
         var6 = var2.al.iterator();

         while(var6.hasNext()) {
            J113 var7 = (J113)var6.next();
            Br114 var8 = new Br114(var7);
            var8.s = var7.aa;
            if (var1 == null) {
               var1 = var0.b = new ArrayList();
            }

            var1.add(var8);
            ep(var8, (ArrayList)null, var7, var3, var4, var5);
         }
      }

      if (var5 && var2.av != null) {
         var6 = var2.av.iterator();

         while(var6.hasNext()) {
            Ao74 var11 = (Ao74)var6.next();
            Bg72 var13 = new Bg72(var11);
            var13.s = var11.aa;
            if (var1 == null) {
               var1 = var0.b = new ArrayList();
            }

            var1.add(var13);
            ep(var13, (ArrayList)null, var11, var3, var4, var5);
         }
      }

      if (var2.af != null) {
         var6 = var2.af.iterator();

         while(var6.hasNext()) {
            XElement var12 = (XElement)var6.next();
            GameEntity var14 = new GameEntity(GameEntity.bn.h(), var4);

            try {
               G104 var9 = XElement.bw(var14, var12, var3, var5);
               var9.s = var12.aa;
               if (var1 == null) {
                  var1 = var0.b = new ArrayList();
               }

               var1.add(var9);
            } catch (Exception var10) {
               logger.error("", var10);
               GameEntity.b(var14);
            }
         }
      }

   }

   public static void eo(Am76 var0, Gg3 var1) throws Au64 {
      // $FF: Couldn't be decompiled
   }

   public void r(Gg3 var1, Hk84 var2, Hg85 var3, Hi86 var4) {
      if (this.aa != null) {
         Gg3.k(var1, Bv116.ATTACHMENT_POINT.s);
         Gg3.a(var1, Gg3.av(this.aa));
         var1.ap(this.aa);
      }

      if (this.ah != null) {
         Gg3.k(var1, Bv116.POSITION.s);
         Gg3.aq(var1, this.ah.x);
         Gg3.aq(var1, this.ah.y);
         Gg3.aq(var1, this.ah.z);
      }

      if (this.ap != null) {
         Gg3.k(var1, Bv116.ORIENTATION.s);
         Gg3.aq(var1, this.ap.x);
         Gg3.aq(var1, this.ap.y);
         Gg3.aq(var1, this.ap.z);
         Gg3.aq(var1, this.ap.w);
      }

      if (this.ao != null) {
         Gg3.k(var1, Bv116.SCALE.s);
         Gg3.aq(var1, this.ao);
      }

      Gg3.k(var1, Bv116.SUPER_TYPE_PROPERTIES.s);
      int var5 = var1.v += 4;
      super.r(var1, var2, var3, var4);
      Gg3.am(var1, var1.v - var5);
      Gg3.k(var1, 0);
   }

   public Am76(D80 var1) {
      super(var1);
   }
}
