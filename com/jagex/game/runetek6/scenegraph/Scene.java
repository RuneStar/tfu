package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.ScriptablePickResult;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.xelement.Bn70;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.jnibindings.runetek6.GroundCover;
import com.jagex.jnibindings.runetek6.IrradianceVolumes;
import com.jagex.jnibindings.runetek6.Occlusion;
import com.jagex.jnibindings.runetek6.Terrain;
import com.jagex.js5.js5;
import com.jagex.maths.Vector3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Fi371;
import tfu.Fn87;
import tfu.H149;
import tfu.Ko370;
import tfu.Lb33;
import tfu.Me312;

@ScriptEntryClass("Scene")
public final class Scene {
   private static final Logger logger = LoggerFactory.getLogger(Scene.class);
   private final List b = new ArrayList();
   private final Ao128 d = new Ao128("Instantiated here");
   public GameEntity e;
   private boolean h = true;
   public String j = "Game";
   private boolean l = false;
   private final Map p = new HashMap();
   public final E254 q;
   public final Map r = new HashMap();
   private final List s = new ArrayList();
   private final ArrayList u = new ArrayList();
   public final Set v = new Me312();
   private boolean w = false;
   private boolean x = false;
   public long y = 0L;

   private static void v(Scene var0, SceneGraphNode var1) {
      var1.hide(false);
      SceneGraphNode.al(var1, (E254)null);
      if (var1 instanceof GameEntity) {
         GameEntity var2 = (GameEntity)var1;
         Iterator var3 = GameEntity.ek(var2).values().iterator();

         while(var3.hasNext()) {
            Component var4 = (Component)var3.next();
            var4.removingFromScene();
            var0.p(var4);
         }

         var0.r.remove(var2.bg);
      }

      var0.v.remove(var1);
      var1.h = null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void remove(SceneGraphNode var1, @ScriptDefaults(defaultBoolean = true) boolean var2, @ScriptDefaults(defaultBoolean = true) boolean var3) {
      Scene var4 = var1.getScene();
      if (var4 != null) {
         if (var4 != this) {
            throw new IllegalStateException("This node is in a different scene!");
         } else if (this.x) {
            this.u.add(new J367(this, var1, var2, var3));
         } else {
            v(this, var1);
            if (var2) {
               var1.ag((SceneGraphNode)null, (String)null);
               r(this, var1);
            } else {
               SceneGraphNode.aq(var1);
            }

            if (var3) {
               SceneGraphNode.b(var1);
            }

         }
      }
   }

   public static final void d(Scene var0) {
      Lb33.g(Lb33.LoadHeightmaps);

      try {
         Iterator var1 = var0.s.iterator();

         while(var1.hasNext()) {
            long var2 = (Long)var1.next();
            Terrain.loadHeightmapIfNotLoadedYet(var2);
         }

         Lb33.d(Lb33.LoadHeightmaps);
      } finally {
         Lb33.d(Lb33.LoadHeightmaps);
      }
   }

   public final void q(String var1, Vector3 var2, String var3) {
      long var4 = GroundCover.createGrid();
      this.b.add(var4);
      GroundCover.setGridWorldOrigin(var4, var2.x, var2.y, var2.z);
      String var6 = H149.z + var3;
      GroundCover.loadLayerInstancesFromMemory(H149.u, var4, var1, var6);
   }

   public static final void j(Scene var0, js5 var1, String var2, String var3) {
      if (IrradianceVolumes.g(var1, var2)) {
         var0.l = true;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object[] pickElementsFromSelection(int var1, int var2) {
      byte var3 = 10;
      ArrayList var4 = new ArrayList();
      this.b(var1, var2, var3, var4);
      return var4.toArray();
   }

   public static final void s(Scene var0, List var1, Map var2) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         long var4 = (Long)var3.next();
         Iterator var6 = var0.r.values().iterator();

         while(var6.hasNext()) {
            GameEntity var7 = (GameEntity)var6.next();
            if (var7.g() == var4) {
               var2.put(var4, var7);
            }
         }
      }

   }

   public void y(Component var1) {
      Set var2 = (Set)this.p.get(var1.getClass());
      if (var2 == null) {
         this.p.put(var1.getClass(), var2 = Collections.newSetFromMap(new WeakHashMap()));
      }

      var2.add(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object[] pickElements(int var1, int var2) {
      byte var3 = 10;
      ArrayList var4 = new ArrayList();
      this.b(var1, var2, var3, var4);
      return var4.toArray();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setActiveCamera(GameEntity var1) {
      this.e = var1;
   }

   private void l(SceneGraphNode var1) {
      var1.h = new WeakReference(this);
      SceneGraphNode.al(var1, this.q);
      this.v.add(var1);
      if (var1 instanceof GameEntity) {
         GameEntity var2 = (GameEntity)var1;
         if (this.r.containsKey(var2.bg)) {
            throw new IllegalStateException("Duplicate GameEntityId! PANIC!");
         }

         this.r.put(var2.bg, var2);
         Iterator var3 = GameEntity.ek(var2).values().iterator();

         while(var3.hasNext()) {
            Component var4 = (Component)var3.next();
            this.y(var4);
            var4.addedToScene();
         }
      }

      var1.show(false);
      Iterator var5 = var1.ai().iterator();

      while(var5.hasNext()) {
         SceneGraphNode var6 = (SceneGraphNode)var5.next();
         this.l(var6);
      }

   }

   public Scene(E254 var1) {
      this.q = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void removeChildren(SceneGraphNode var1, @ScriptDefaults(defaultBoolean = true) boolean var2) {
      Iterator var3 = var1.ai().iterator();

      while(var3.hasNext()) {
         SceneGraphNode var4 = (SceneGraphNode)var3.next();
         this.remove(var4, true, var2);
      }

   }

   private static final void r(Scene var0, SceneGraphNode var1) {
      Iterator var2 = var1.ai().iterator();

      while(var2.hasNext()) {
         SceneGraphNode var3 = (SceneGraphNode)var2.next();
         v(var0, var3);
         r(var0, var3);
      }

   }

   public static final void e(Scene var0, js5 var1, String var2, String var3) {
      if (Occlusion.g(var1, var2)) {
         var0.w = true;
      }

   }

   public static final void w(Scene var0, SceneGraphNode var1) {
      var0.remove(var1, true, true);
   }

   public void p(Component var1) {
      Set var2 = (Set)this.p.get(var1.getClass());
      boolean var3 = false;
      if (var2 != null) {
         var3 = var2.remove(var1);
      }

      if (!var3) {
         logger.warn("Called unindexComponent on " + var1.getClass().getSimpleName() + ", but it wasn't indexed!");
      }

   }

   public Collection x(Class var1) {
      Set var2 = (Set)this.p.get(var1);
      if (var2 == null) {
         return Collections.emptySet();
      } else {
         Iterator var3 = var2.iterator();

         while(true) {
            GameEntity var5;
            do {
               if (!var3.hasNext()) {
                  if (var2.isEmpty()) {
                     return Collections.emptySet();
                  }

                  Component[] var6 = (Component[])var2.toArray(new Component[var2.size()]);
                  if (var6.length > 0 && var6[var6.length - 1] == null) {
                     logger.warn("Set shrank (or contained nulls) while we were building the array!");
                  }

                  return new S368(this, var6);
               }

               Component var4 = (Component)var3.next();
               var5 = var4.getEntity();
            } while(var5 != null && var5.getScene() == this);

            var3.remove();
         }
      }
   }

   public static final void u(Scene var0) {
      var0.h = false;
      Iterator var1 = var0.v.iterator();

      while(var1.hasNext()) {
         SceneGraphNode var2 = (SceneGraphNode)var1.next();
         SceneGraphNode.al(var2, (E254)null);
         var2.h = null;
         var2.l();
      }

      var1 = var0.r.values().iterator();

      while(var1.hasNext()) {
         GameEntity var5 = (GameEntity)var1.next();
         Iterator var3 = GameEntity.ek(var5).values().iterator();

         while(var3.hasNext()) {
            Component var4 = (Component)var3.next();
            var0.p(var4);
         }
      }

      var0.v.clear();
      var0.r.clear();
      var1 = var0.s.iterator();

      long var6;
      while(var1.hasNext()) {
         var6 = (Long)var1.next();
         Terrain.destroy(var6);
      }

      var0.s.clear();
      var1 = var0.b.iterator();

      while(var1.hasNext()) {
         var6 = (Long)var1.next();
         GroundCover.destroyGrid(var6, H149.u);
      }

      var0.b.clear();
      if (var0.l) {
         IrradianceVolumes.destroyAllVolumes();
         var0.l = false;
      }

      if (var0.w) {
         Occlusion.destroyUmbraScene();
         var0.w = false;
      }

   }

   protected void finalize() {
      try {
         if (this.h) {
            logger.error("Native memory leak - " + this.getClass().getSimpleName() + " garbage-collected without release()!", this.d);
            Ko370.g(new H369(this));
         }
      } catch (Throwable var2) {
         logger.error("", var2);
      }

   }

   public static void z(Scene var0, float var1) {
      Iterator var2 = var0.b.iterator();

      while(var2.hasNext()) {
         long var3 = (Long)var2.next();
         GroundCover.updateGrid(var3, var1);
      }

   }

   public static int m(Scene var0) {
      return var0.v.size();
   }

   public static final void g(Scene var0, W14 var1, Vector3 var2) {
      long var3 = Terrain.create();
      Terrain.loadFromXMLString(var3, var1.g);
      Terrain.setWorldPosition(var3, var2.x, var2.y, var2.z);
      var0.s.add(var3);
   }

   public static void k(Scene var0) {
      var0.x = true;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GameEntity getActiveCamera() {
      return this.e;
   }

   public static int n(Scene var0) {
      return var0.r.size();
   }

   public static GameEntity t(Scene var0, Bb4 var1) {
      return (GameEntity)var0.r.get(var1);
   }

   public static void i(Scene var0) {
      var0.x = false;
      Iterator var1 = var0.u.iterator();

      while(var1.hasNext()) {
         Runnable var2 = (Runnable)var1.next();
         var2.run();
      }

      var0.u.clear();
   }

   public static final void h(Scene var0, Bn70 var1) {
      Bn70.q(var1, var0.y);
   }

   public void b(int var1, int var2, int var3, List var4) {
      ArrayList var5 = new ArrayList();
      Fi371.d(var1, var2, var3, var5);
      if (!var5.isEmpty()) {
         ArrayList var6 = new ArrayList();
         Iterator var7 = var5.iterator();

         while(var7.hasNext()) {
            Fn87 var8 = (Fn87)var7.next();
            var6.add(var8.g);
         }

         HashMap var11 = new HashMap();
         s(this, var6, var11);
         Iterator var12 = var5.iterator();

         while(var12.hasNext()) {
            Fn87 var9 = (Fn87)var12.next();
            ScriptablePickResult var10 = new ScriptablePickResult(var9);
            var10.g = var11.get(var9.g);
            var4.add(var10);
         }

      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void add(SceneGraphNode var1) {
      if (!this.h) {
         throw new IllegalStateException();
      } else if (var1.l != null) {
         throw new IllegalStateException("This node has a parent - please add the parent, not the child! (Its children will be added for you.)");
      } else {
         Scene var2 = var1.getScene();
         if (var2 == this) {
            logger.warn("this node is already in the scene - did you mean to add it twice?", new Throwable());
         } else if (var2 != null) {
            throw new IllegalStateException("This node is already in another scene!");
         } else {
            if (var1 instanceof GameEntity) {
               GameEntity var3 = (GameEntity)var1;
               GameEntity var4 = (GameEntity)this.r.get(var3.bg);
               if (var4 != null && var4 != var1) {
                  throw new IllegalStateException("A node with this GameEntityId (" + var4.bg + ") is already in the scene (but not this node) - PANIC!  Existing is " + var4);
               }

               logger.trace("adding a node with GameEntityId " + ((GameEntity)var1).bg);
            }

            this.l(var1);
         }
      }
   }
}
