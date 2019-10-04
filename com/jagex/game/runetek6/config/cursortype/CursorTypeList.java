package com.jagex.game.runetek6.config.cursortype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;

public class CursorTypeList {
   final js5 configClient;
   final Eq28 cursorCache = new Eq28(2);
   final Gd27 game;
   final Language languageId;
   public int num;
   private final Eq28 recentUse = new Eq28(64);
   final js5 sprites;

   public void cacheClean(int var1) {
      Eq28 var2 = this.recentUse;
      synchronized(var2) {
         this.recentUse.h(var1);
      }

      var2 = this.cursorCache;
      synchronized(var2) {
         this.cursorCache.h(var1);
      }
   }

   public void cacheRemoveSoftReferences() {
      Eq28 var1 = this.recentUse;
      synchronized(var1) {
         Eq28.b(this.recentUse);
      }

      var1 = this.cursorCache;
      synchronized(var1) {
         Eq28.b(this.cursorCache);
      }
   }

   public void cacheReset() {
      Eq28 var1 = this.recentUse;
      synchronized(var1) {
         Eq28.s(this.recentUse);
      }

      var1 = this.cursorCache;
      synchronized(var1) {
         Eq28.s(this.cursorCache);
      }
   }

   public CursorType list(int var1) {
      Eq28 var3 = this.recentUse;
      CursorType var2;
      synchronized(var3) {
         var2 = (CursorType)this.recentUse.g((long)var1);
      }

      if (var2 != null) {
         return var2;
      } else {
         js5 var4 = this.configClient;
         byte[] var10;
         synchronized(var4) {
            var10 = this.configClient.getfile(Js5ConfigGroup.CURSORTYPE.id, var1);
         }

         var2 = new CursorType();
         var2.myList = this;
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

   public CursorTypeList(Gd27 var1, Language var2, js5 var3, js5 var4) {
      this.game = var1;
      this.languageId = var2;
      this.configClient = var3;
      this.sprites = var4;
      this.num = js5.z(this.configClient, Js5ConfigGroup.CURSORTYPE.id);
   }
}
