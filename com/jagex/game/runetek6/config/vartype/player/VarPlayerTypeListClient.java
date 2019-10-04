package com.jagex.game.runetek6.config.vartype.player;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;

public class VarPlayerTypeListClient extends VarTypeList {
   final js5 configClient;
   private final Eq28 recentUse = new Eq28(64);

   public VarPlayerTypeListClient(Gd27 var1, VarDomainType var2, Language var3, js5 var4) {
      super(var1, var2, var3, var4 != null ? js5.z(var4, var2.getJs5GroupID().id) : 0);
      this.configClient = var4;
   }

   public void cacheReset() {
      Eq28 var1 = this.recentUse;
      synchronized(var1) {
         Eq28.s(this.recentUse);
      }
   }

   public void cacheClean(int var1) {
      Eq28 var2 = this.recentUse;
      synchronized(var2) {
         this.recentUse.h(var1);
      }
   }

   public void cacheRemoveSoftReferences() {
      Eq28 var1 = this.recentUse;
      synchronized(var1) {
         Eq28.b(this.recentUse);
      }
   }

   public VarPlayerType list(int var1) {
      Eq28 var3 = this.recentUse;
      synchronized(var3) {
         VarPlayerType var2 = (VarPlayerType)this.recentUse.g((long)var1);
         if (var2 == null) {
            byte[] var4 = this.configClient.getfile(super.variableDomain.getJs5GroupID().id, var1);
            var2 = new VarPlayerType(super.variableDomain, var1);
            if (var4 != null) {
               var2.decode(new Gg3(var4));
            }

            Eq28.j(this.recentUse, var2, (long)var1);
         }

         return var2;
      }
   }
}
