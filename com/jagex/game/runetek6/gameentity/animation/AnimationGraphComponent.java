package com.jagex.game.runetek6.gameentity.animation;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.AnimationGraph;
import com.jagex.jnibindings.runetek6.LuaUserData;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.jnibindings.runetek6.SkinnedModel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import tfu.Be2;
import tfu.Bs1;
import tfu.Kc180;

@ScriptEntryClass("AnimGraph")
public class AnimationGraphComponent extends Component {
   private static final int g = 1024;
   public static final int w = StringTools.l(AnimationGraphComponent.class.getName());
   private int b;
   public Integer d;
   private final Skeleton e;
   private final AnimationGraph h;
   public Integer j;
   private long l;
   public Integer q;
   private long s;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public LuaUserData getAnimationGraph() {
      return new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph");
   }

   public void bd() {
      if (this.s != 0L) {
         Kc180.d(this.s);
         this.s = 0L;
      }

      AnimationGraph.e(this.h);
   }

   public AnimationGraphComponent(String var1, Skeleton var2, Map var3, Map var4) {
      this.e = var2;
      int var5 = var3.size();
      int var6 = 8 + var5 * (4 + Kc180.e());

      Entry var8;
      for(Iterator var7 = var4.entrySet().iterator(); var7.hasNext(); var6 += 8 + ((float[])var8.getValue()).length * 4) {
         var8 = (Entry)var7.next();
      }

      long var18 = Kc180.g((long)var6);
      Kc180.r(var18, var5);
      long var9 = var18 + 4L;

      Iterator var11;
      Entry var12;
      for(var11 = var3.entrySet().iterator(); var11.hasNext(); var9 += 4L) {
         var12 = (Entry)var11.next();
         Kc180.r(var9, (Integer)var12.getKey());
         var9 += 4L;
         Kc180.r(var9, (Integer)var12.getValue());
      }

      Kc180.r(var9, var4.size());
      var9 += 4L;
      var11 = var4.entrySet().iterator();

      while(var11.hasNext()) {
         var12 = (Entry)var11.next();
         float[] var13 = (float[])var12.getValue();
         Kc180.r(var9, (Integer)var12.getKey());
         var9 += 4L;
         Kc180.r(var9, var13.length);
         var9 += 4L;
         float[] var14 = var13;
         int var15 = var13.length;

         for(int var16 = 0; var16 < var15; ++var16) {
            float var17 = var14[var16];
            Kc180.v(var9, var17);
            var9 += 4L;
         }
      }

      this.h = new AnimationGraph();
      AnimationGraph.g(this.h, var1, var2, var18, var6);
      Kc180.d(var18);
      this.s = Kc180.g(1024L);
      this.b = 1024;
   }

   protected void detachFromEntity() {
      GameEntity var1 = this.getEntity();
      if (GameEntity.eq(var1)) {
         SkinnedModel.clearAnimations(var1.g());
         if (this.j != null) {
            var1.triggerEvent(this.j, new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph"));
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return w;
   }

   private String d() {
      int var1 = Kc180.x(this.l);
      this.l += 4L;
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = Kc180.y((long)(this.l++));
      }

      return new String(var2, Charset.forName("UTF-8"));
   }

   public void g(float var1) {
      GameEntity var2 = this.getEntity();
      if (this.d != null) {
         var2.triggerEvent(this.d, new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph"));
      }

      int var3 = AnimationGraph.q(this.h, var1, this.s, this.b);
      this.l = this.s;
      int var4 = Kc180.x(this.l);
      this.l += 4L;

      int var5;
      String var6;
      String var7;
      for(var5 = 0; var5 < var3; ++var5) {
         var6 = this.d();
         var7 = this.d();
         var2.eh(var6, var7);
      }

      while(true) {
         while(var3 < var4) {
            var5 = var3;
            var3 = AnimationGraph.j(this.h, var3, this.s, this.b);
            if (var3 == var5) {
               if (this.b > 1000000) {
                  throw new IllegalStateException();
               }

               Kc180.d(this.s);
               this.b *= 2;
               this.s = Kc180.g((long)this.b);
            } else {
               for(this.l = this.s; var5 < var3; ++var5) {
                  var6 = this.d();
                  var7 = this.d();
                  var2.eh(var6, var7);
               }
            }
         }

         return;
      }
   }

   protected void attachToEntity() {
      GameEntity var1 = this.getEntity();
      if (GameEntity.eq(var1) && GameEntity.el(var1) == this.e) {
         AnimationGraph.d(this.h, var1.g());
         if (this.q != null) {
            var1.triggerEvent(this.q, new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph"));
         }
      }

   }
}
