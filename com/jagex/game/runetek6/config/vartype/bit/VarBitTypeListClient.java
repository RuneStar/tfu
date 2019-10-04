package com.jagex.game.runetek6.config.vartype.bit;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import java.util.HashMap;
import java.util.Map;
import tfu.Eq28;
import tfu.Ff259;
import tfu.Gd27;
import tfu.Gg3;

public class VarBitTypeListClient extends Ff259 {
   public static final int DEFAULT_CACHE_SIZE = 64;
   final js5 configClient;
   private Map hashLookup = null;
   final Map listContainer;
   private Eq28 recentUse = new Eq28(64);

   public VarBitTypeListClient(Gd27 var1, Language var2, js5 var3, Map var4) {
      super(var1, var2, var3 != null ? js5.z(var3, Js5ConfigGroup.VAR_BIT.id) : 0);
      this.configClient = var3;
      this.listContainer = var4;
   }

   public VarBitType list(int var1) {
      Eq28 var3 = this.recentUse;
      synchronized(var3) {
         VarBitType var2 = (VarBitType)this.recentUse.g((long)var1);
         if (var2 == null) {
            byte[] var4 = this.configClient.getfile(Js5ConfigGroup.VAR_BIT.id, var1);
            var2 = new VarBitType();
            var2.id = var1;
            var2.myList = this;
            if (var4 != null) {
               var2.decode(new Gg3(var4), false);
            }

            Eq28.j(this.recentUse, var2, (long)var1);
         }

         return var2;
      }
   }

   public void createHashMapLookup() {
      this.hashLookup = new HashMap();

      for(int var1 = 0; var1 < super.q; ++var1) {
         VarBitType var2 = this.list_uncached(var1);
         if (var2.debugNameHash32 != 0) {
            this.hashLookup.put(var2.debugNameHash32, var1);
         }
      }

   }

   public VarBitType list_uncached(int var1) {
      Eq28 var3 = this.recentUse;
      synchronized(var3) {
         VarBitType var2 = (VarBitType)this.recentUse.g((long)var1);
         if (var2 == null) {
            byte[] var4 = this.configClient.getfile(Js5ConfigGroup.VAR_BIT.id, var1);
            var2 = new VarBitType();
            var2.id = var1;
            var2.myList = this;
            if (var4 != null) {
               var2.decode(new Gg3(var4), true);
               if (var2.myList == null) {
                  return null;
               }
            }
         }

         return var2;
      }
   }

   public VarBitType hashLookup(int var1) {
      return this.hashLookup.containsKey(var1) ? this.list((Integer)this.hashLookup.get(var1)) : null;
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
}
