package com.jagex.game.runetek6.config.objtype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;
import tfu.Ha262;
import tfu.Ln265;
import tfu.Mk163;

public class ObjTypeList {
   boolean allowMembers;
   final js5 configClient;
   protected final String[] defaultIOps;
   protected final String[] defaultOps;
   final Gd27 game;
   final Language languageId;
   final js5 meshes;
   public int num;
   final ParamTypeList paramTL;
   private final Eq28 recentUse = new Eq28(128);

   public ObjType list(int var1) {
      Eq28 var3 = this.recentUse;
      ObjType var2;
      synchronized(var3) {
         var2 = (ObjType)this.recentUse.g((long)var1);
      }

      if (var2 != null) {
         return var2;
      } else {
         js5 var4 = this.configClient;
         byte[] var11;
         synchronized(var4) {
            var11 = this.configClient.getfile(Js5ConfigGroup.OBJTYPE.getClientGroupId(var1), Js5ConfigGroup.OBJTYPE.getClientFileId(var1));
         }

         var2 = new ObjType();
         var2.myList = this;
         var2.myid = var1;
         var2.op = (String[])this.defaultOps.clone();
         var2.iop = (String[])this.defaultIOps.clone();
         if (var11 != null) {
            var2.decode(new Gg3(var11));
         }

         var2.postDecode();
         if (var2.certtemplate != -1) {
            var2.genCert(this.list(var2.certtemplate), this.list(var2.certlink));
         }

         if (var2.lenttemplate != -1) {
            var2.genLent(this.list(var2.lenttemplate), this.list(var2.lentlink));
         }

         if (var2.boughttemplate != -1) {
            var2.genBought(this.list(var2.boughttemplate), this.list(var2.boughtlink));
         }

         if (!this.allowMembers && var2.members) {
            var2.name = Mk163.g(Mk163.MEMBERS_OBJECT, this.languageId);
            var2.team = 0;
            var2.op = this.defaultOps;
            var2.iop = this.defaultIOps;
            var2.stockmarket = false;
            if (var2.params != null) {
               boolean var12 = false;

               for(Ln265 var5 = Ha262.e(var2.params); var5 != null; var5 = Ha262.h(var2.params)) {
                  ParamType var6 = this.paramTL.list((int)var5.bq);
                  if (var6.autodisable) {
                     Ln265.ef(var5);
                  } else {
                     var12 = true;
                  }
               }

               if (!var12) {
                  var2.params = null;
               }
            }
         }

         Eq28 var13 = this.recentUse;
         synchronized(var13) {
            Eq28.j(this.recentUse, var2, (long)var1);
            return var2;
         }
      }
   }

   public void cacheRemoveSoftReferences() {
      Eq28.b(this.recentUse);
   }

   public void setAllowMembers(boolean var1) {
      if (var1 != this.allowMembers) {
         this.allowMembers = var1;
         this.cacheReset();
      }
   }

   public void cacheReset() {
      Eq28.s(this.recentUse);
   }

   public void cacheClean(int var1) {
      this.recentUse.h(var1);
   }

   public ObjTypeList(Gd27 var1, Language var2, boolean var3, ParamTypeList var4, js5 var5, js5 var6) {
      this.game = var1;
      this.languageId = var2;
      this.allowMembers = var3;
      this.paramTL = var4;
      this.configClient = var5;
      this.meshes = var6;
      if (this.configClient != null) {
         int var7 = js5.t(this.configClient) - 1;
         this.num = var7 * Js5ConfigGroup.OBJTYPE.getGroupSize() + js5.z(this.configClient, var7);
      } else {
         this.num = 0;
      }

      if (this.game == Gd27.RUNESCAPE) {
         this.defaultOps = new String[]{null, null, Mk163.g(Mk163.TAKE, this.languageId), null, null, Mk163.g(Mk163.EXAMINE, this.languageId)};
      } else {
         this.defaultOps = new String[]{null, null, Mk163.g(Mk163.TAKE, this.languageId), null, null, null};
      }

      this.defaultIOps = new String[]{null, null, null, null, Mk163.g(Mk163.DROP, this.languageId)};
   }
}
