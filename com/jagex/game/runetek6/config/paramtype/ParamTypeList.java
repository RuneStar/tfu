package com.jagex.game.runetek6.config.paramtype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;

public class ParamTypeList {
   final js5 configClient;
   final Gd27 game;
   final Language languageId;
   public int num;
   private final Eq28 recentUse = new Eq28(64);

   public void cacheClean(int var1) {
      Eq28 var2 = this.recentUse;
      synchronized(var2) {
         this.recentUse.h(var1);
      }
   }

   public ParamType list(int var1) {
      Eq28 var3 = this.recentUse;
      ParamType var2;
      synchronized(var3) {
         var2 = (ParamType)this.recentUse.g((long)var1);
      }

      if (var2 != null) {
         return var2;
      } else {
         js5 var4 = this.configClient;
         byte[] var10;
         synchronized(var4) {
            var10 = this.configClient.getfile(Js5ConfigGroup.PARAMTYPE.id, var1);
         }

         var2 = new ParamType();
         if (var10 != null) {
            var2.decode(new Gg3(var10));
         }

         Eq28 var11 = this.recentUse;
         synchronized(var11) {
            Eq28.j(this.recentUse, var2, (long)var1);
            return var2;
         }
      }
   }

   public ParamTypeList(Gd27 var1, Language var2, js5 var3) {
      this.game = var1;
      this.languageId = var2;
      this.configClient = var3;
      if (this.configClient != null) {
         this.num = js5.z(this.configClient, Js5ConfigGroup.PARAMTYPE.id);
      } else {
         this.num = 0;
      }

   }

   public void cacheReset() {
      Eq28 var1 = this.recentUse;
      synchronized(var1) {
         Eq28.s(this.recentUse);
      }
   }

   public void cacheRemoveSoftReferences() {
      Eq28 var1 = this.recentUse;
      synchronized(var1) {
         Eq28.b(this.recentUse);
      }
   }
}
