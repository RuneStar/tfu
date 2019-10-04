package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.event.ScriptEventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.maths.Vector3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import tfu.Iz11;
import tfu.N105;

final class Aw103 extends G104 {
   // $FF: synthetic field
   final XElement[] l;
   // $FF: synthetic field
   final boolean p;
   // $FF: synthetic field
   final MappedEventComponent r;
   // $FF: synthetic field
   final Iz11 v;
   // $FF: synthetic field
   final Vector3 w;
   // $FF: synthetic field
   final AnimationGraphComponent y;

   void p() {
      GameEntity.fv(g(this), d(this), q(this));
      if (this.y != null) {
         this.y.bd();
      }

   }

   Aw103(ArrayList var1, long var2, Skeleton var4, N105 var5, XElement[] var6, Vector3 var7, MappedEventComponent var8, Iz11 var9, AnimationGraphComponent var10, boolean var11) {
      super(var1, var2, var4, var5);
      this.w = var7;
      this.r = var8;
      this.v = var9;
      this.y = var10;
      this.p = var11;
      this.l = var6;
   }

   GameEntity k() {
      XElement[] var1 = this.l;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         XElement var4 = var1[var3];
         XElement.bv(var4, super.d);
      }

      if (this.l.length > 0) {
         XElement.bf(this.l[0], super.d, this.w);
      }

      int var11 = 0;

      for(var2 = 0; var2 < this.l.length; ++var2) {
         if (XElement.bn(this.l[var2]) != null) {
            ++var11;
         }
      }

      super.d.bi = new Serializable[var11];
      var11 = 0;

      for(var2 = 0; var2 < this.l.length; ++var2) {
         if (XElement.bn(this.l[var2]) != null) {
            super.d.bi[var11++] = XElement.bn(this.l[var2]);
         }
      }

      if (XElement.q) {
         super.d.bt = new XElement[this.l.length];

         for(var2 = 0; var2 < this.l.length; ++var2) {
            super.d.bt[var2] = this.l[var2];
         }
      }

      if (this.r != null) {
         GameEntity.ep(super.d, this.r);
      }

      if (this.v != null) {
         super.d.cj = this.v;
      }

      GameEntity.eo(super.d, AnimationGraphComponent.class);
      GameEntity.en(super.d, g(this), d(this), q(this));
      HashMap var14 = new HashMap();
      XElement[] var12 = this.l;
      int var15 = var12.length;

      for(int var5 = 0; var5 < var15; ++var5) {
         XElement var6 = var12[var5];
         Map var7 = var6.as();
         Iterator var8 = var7.keySet().iterator();

         while(var8.hasNext()) {
            Integer var9 = (Integer)var8.next();
            if (!var14.containsKey(var9)) {
               var14.put(var9, var7.get(var9));
            }
         }
      }

      GameEntity.ef(super.d);
      Iterator var13 = var14.entrySet().iterator();

      while(var13.hasNext()) {
         Entry var16 = (Entry)var13.next();

         try {
            ScriptEventHandler var17 = super.d.bz.createEventHandler((String)((String)var16.getValue()), (Object[])null);
            var17.staticallyConfigured = true;
            super.d.addEventHandlerByID((Integer)var16.getKey(), var17);
         } catch (Exception var10) {
            XElement.bg().error("Error processing ScriptEventHandler", var10);
         }
      }

      if (this.y != null) {
         GameEntity.ep(super.d, this.y);
      }

      if (this.p) {
         super.d.show(false);
      }

      return super.d;
   }
}
