package com.jagex.game.runetek6.gameentity;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.Event;
import com.jagex.game.runetek6.event.EventForwarder;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.variables.G53;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.jnibindings.runetek6.LuaUserData;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.jnibindings.runetek6.SkinnedModel;
import com.jagex.jnibindings.runetek6.StaticModel;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.maths.Q10;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Ap127;
import tfu.Ba115;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.H149;
import tfu.Hi86;
import tfu.Iz11;
import tfu.Jy122;
import tfu.Kc180;
import tfu.Lb33;
import tfu.Lc490;
import tfu.Lp301;
import tfu.N105;

@ScriptEntryClass("Entity")
@Bs1
@Be2
public class GameEntity extends SceneGraphNode implements Lp301, EventForwarder {
   private static WeakHashMap bc = new WeakHashMap();
   private static final ThreadLocal be = new ThreadLocal();
   public static Ba115 bf;
   public static Ba115 bn;
   private static final WeakHashMap bv = new WeakHashMap();
   private static final EventHandler cq = new D331();
   public static J332 cw;
   private static final Logger logger = LoggerFactory.getLogger(GameEntity.class);
   public CollisionObject ba = null;
   public String bb = null;
   public final Bb4 bg;
   public Serializable[] bi;
   private Map bs = new HashMap();
   public XElement[] bt;
   public boolean bu = true;
   public final ScriptManager bz;
   protected final Set ca = new HashSet();
   protected Skeleton cb;
   private Map cd = new HashMap();
   protected final G55 ce = new G55(this);
   public Iz11 cj;
   private LinkedHashSet ck;
   private N105 cl;
   private int cm;
   private final EventHandler cp = new E333(this);
   protected final Map cv = new HashMap();
   public int luaComponentTable = -1;

   private GameEntity(Bb4 var1, ScriptManager var2, boolean var3) {
      Lb33.g(Lb33.NewGameEntityBody);
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.bg = var1;
         Lb33.g(Lb33.UpdateEntitesById);
         WeakHashMap var4 = bv;
         synchronized(var4) {
            Lb33.g(Lb33.EntitesByIdRemove);
            bv.remove(this.bg);
            Lb33.d(Lb33.EntitesByIdRemove);
            Lb33.g(Lb33.EntitesByIdPut);
            bv.put(this.bg, new WeakReference(this));
            Lb33.d(Lb33.EntitesByIdPut);
         }

         Lb33.d(Lb33.UpdateEntitesById);
         if (var2 == null) {
            throw new NullPointerException();
         } else {
            this.bz = var2;
            Lb33.g(Lb33.AddCommonEventHandlers);
            ei(this);
            Lb33.d(Lb33.AddCommonEventHandlers);
            Lb33.d(Lb33.NewGameEntityBody);
         }
      }
   }

   public final native void setNativeComponent(long var1, long var3, int var5, Component var6, String var7);

   public final native void clearNativeComponents(long var1);

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object getProperty(String var1, Object var2) {
      return G55.e(this.ce, var1, var2);
   }

   public String toString() {
      return this.getClass().getSimpleName() + ":" + this.bg;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public synchronized Component removeComponent(Class var1, @ScriptID @ScriptDefaults(defaultInteger = 305419896) int var2) {
      if (var2 == 305419896) {
         var2 = StringTools.l(var1.getName());
      }

      Component var3 = (Component)this.cd.remove(var2);
      if (var3 != null) {
         Component.bp(var3, (GameEntity)null);
         var3.bd();
      }

      this.setNativeComponent(this.bz.getScriptManagerNativeRef(), this.bz.getLuaStateNativeRef(), var2, (Component)null, (String)null);
      return var3;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setIsModelStatic(boolean var1) {
      this.bu = var1;
   }

   /** @deprecated */
   @Deprecated
   @ScriptEntryPoint
   @Be2
   @Bs1
   public byte[] GetPackedUUID() {
      return this.getPackedID();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public byte[] getPackedID() {
      Gg3 var1 = new Gg3(3);
      this.bg.q(var1);
      return var1.r;
   }

   /** @deprecated */
   @Deprecated
   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getUUID() {
      return this.bg.toString();
   }

   public static void em(Collection var0, Runnable var1) {
      try {
         be.set(var0);
         var1.run();
         be.set((Object)null);
      } finally {
         be.set((Object)null);
      }
   }

   public static GameEntity es(Bb4 var0) {
      WeakHashMap var2 = bv;
      WeakReference var1;
      synchronized(var2) {
         var1 = (WeakReference)bv.get(var0);
      }

      if (var1 != null) {
         GameEntity var5 = (GameEntity)var1.get();
         if (var5 != null) {
            Collection var3 = (Collection)be.get();
            if (var3 != null) {
               var3.add(var5);
            }
         }

         return var5;
      } else {
         return null;
      }
   }

   /** @deprecated */
   @Deprecated
   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GameEntity LookupPackedUUID(Object var0, byte[] var1) {
      return lookupPackedID(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GameEntity lookupPackedID(byte[] var0) {
      Gg3 var1 = new Gg3(var0);
      Bb4 var2 = Bb4.j(var1);
      GameEntity var3 = es(var2);
      if (var3 == null) {
         logger.debug("Protocol Buffers: packed ID {} doesn't refer to a GameEntity that we know about.", var2);
      }

      return var3;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GameEntity lookupID(String var0) {
      Bb4 var1 = Bb4.g(var0);
      GameEntity var2 = es(var1);
      if (var2 == null) {
         logger.debug("Protocol Buffers: string ID {} doesn't refer to a GameEntity that we know about.", var1);
      }

      return var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void addEventHandlerByID(@ScriptID Integer var1, EventHandler var2) {
      Event var3 = (Event)this.bs.get(var1);
      if (var3 == null) {
         var3 = new Event();
         this.bs.put(var1, var3);
      }

      var3.add(var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeEventHandler(String var1, EventHandler var2) {
      ec(this, StringTools.l(var1), var2);
   }

   public static void ec(@ScriptID GameEntity var0, Integer var1, EventHandler var2) {
      Event var3 = (Event)var0.bs.get(var1);
      if (var3 != null) {
         var3.remove(var2);
      }

   }

   public void eh(String var1, Object var2) {
      if (this.bz.getThread() != Thread.currentThread()) {
         String var11 = "GameEntity.triggerEvent() called from " + Thread.currentThread() + " - main thread is " + this.bz.getThread();
         logger.error(var11, new Ao128());
         throw new IllegalStateException(var11);
      } else {
         Lb33.g(Lb33.EntityTriggerEventName);

         try {
            long var3 = System.nanoTime();
            if (Jy122.g(ScriptManager.calltrace)) {
               Jy122.h(ScriptManager.calltrace, "ENTITY EVENT: " + var1 + "(" + var2 + ") on " + this);
            }

            this.triggerEvent(StringTools.l(var1), var2);
            if (Jy122.g(ScriptManager.calltrace)) {
               Jy122.l(ScriptManager.calltrace, "END");
            }

            if (Ap127.d) {
               long var5 = System.nanoTime() - var3;
               float var7 = (float)var5 * 1.0E-6F;
               if (var7 > Ap127.j) {
                  var7 = (float)((int)(var7 * 10.0F)) / 10.0F;
                  Ap127.g(var5, "Lua handling for the event '" + var1 + "' took longer than 1 ms: " + var7 + " ms. Update frame " + Ap127.h);
               }
            }

            Lb33.d(Lb33.EntityTriggerEventName);
         } finally {
            Lb33.d(Lb33.EntityTriggerEventName);
         }
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void triggerEvent(@ScriptID Integer var1, Object var2) {
      Lb33.g(Lb33.EntityTriggerEventHash);

      try {
         Event var3 = (Event)this.bs.get(var1);
         if (var3 != null) {
            var3.trigger(this, var2);
         }

         Lb33.d(Lb33.EntityTriggerEventHash);
      } finally {
         Lb33.d(Lb33.EntityTriggerEventHash);
      }
   }

   public static void ef(GameEntity var0) {
      Iterator var1 = var0.bs.values().iterator();

      while(var1.hasNext()) {
         Event var2 = (Event)var1.next();
         var2.removeStaticallyConfiguredHandlers();
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getModelJointIndex(String var1) {
      int var2 = -1;
      if (super.v == 0L) {
         return var2;
      } else {
         if (this != null) {
            if (super.v == 0L) {
               return var2;
            }

            if (this.cb != null && var1 != null) {
               var2 = this.cb.d(var1);
            }
         }

         return var2;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GameEntity construct(ScriptManager var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         Lb33.g(Lb33.GameEntityIdAllocate);
         Bb4 var1 = bf.s();
         Lb33.d(Lb33.GameEntityIdAllocate);
         Lb33.g(Lb33.NewGameEntity);
         GameEntity var2 = new GameEntity(var1, var0, false);
         Lb33.d(Lb33.NewGameEntity);
         Lb33.g(Lb33.GameEntityConstructStack);
         Ao128 var3 = new Ao128();
         Lb33.d(Lb33.GameEntityConstructStack);
         Lb33.g(Lb33.GameEntityConstructBuilder);
         StringBuilder var4 = new StringBuilder();
         Lb33.d(Lb33.GameEntityConstructBuilder);
         StackTraceElement[] var5 = var3.getStackTrace();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            StackTraceElement var8 = var5[var7];
            Lb33.g(Lb33.GameEntityConstructAppend);
            var4.append(var8.toString());
            var4.append('\n');
            Lb33.d(Lb33.GameEntityConstructAppend);
         }

         Lb33.g(Lb33.GameEntityConstructPut);
         bc.put(var2, var4.toString());
         Lb33.d(Lb33.GameEntityConstructPut);
         return var2;
      }
   }

   public static Map ek(GameEntity var0) {
      return Collections.unmodifiableMap(var0.cd);
   }

   public static Component eb(GameEntity var0, Class var1) {
      return var0.getComponent(var1, 305419896);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean hasComponent(Class var1, @ScriptID @ScriptDefaults(defaultInteger = 305419896) int var2) {
      int var3 = var2 == 305419896 ? StringTools.l(var1.getName()) : var2;
      return this.cd.get(var3) != null;
   }

   public static Component ep(GameEntity var0, Component var1) {
      return var0.addComponent(var1, 305419896);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public synchronized Component addComponent(Component var1, @ScriptID @ScriptDefaults(defaultInteger = 305419896) int var2) {
      if (var2 == 305419896) {
         var2 = StringTools.l(var1.getClass().getName());
      }

      Component var3 = (Component)this.cd.put(var2, var1);
      if (var3 != null) {
         Component.bp(var3, (GameEntity)null);
         var3.bd();
      }

      Component.bp(var1, this);
      this.setNativeComponent(this.bz.getScriptManagerNativeRef(), this.bz.getLuaStateNativeRef(), var2, var1, Scripting.typeSig(var1));
      return var3;
   }

   public GameEntity(Bb4 var1, ScriptManager var2) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.bg = var1;
         WeakHashMap var3 = bv;
         synchronized(var3) {
            bv.remove(this.bg);
            bv.put(this.bg, new WeakReference(this));
         }

         if (var2 == null) {
            throw new NullPointerException();
         } else {
            this.bz = var2;
            ei(this);
         }
      }
   }

   public final void et(Q344 var1) {
      if (this.ck == null) {
         this.ck = new LinkedHashSet();
      }

      this.ck.add(var1);
   }

   public static final void eu(GameEntity var0, Q344 var1) {
      if (var0.ck != null) {
         var0.ck.remove(var1);
      }

   }

   private void ey() {
      if (this.ck != null) {
         Q344[] var1 = (Q344[])this.ck.toArray(new Q344[this.ck.size()]);

         for(int var2 = var1.length - 1; var2 >= 0; --var2) {
            try {
               var1[var2].g(this);
            } catch (Exception var4) {
               System.err.print("Error in release hook for entity " + this + ": ");
               var4.printStackTrace();
            }
         }

         this.ck = null;
      }

   }

   protected void af(boolean var1) {
      Object var2 = H149.v;
      synchronized(var2) {
         Scene var3 = this.getScene();
         long var4 = 0L;
         if (var3 != null) {
            var4 = var3.y;
         }

         if (super.v != 0L && this.cl != null) {
            if (this.cl.d) {
               if (var1) {
                  SkinnedModel.show(var4, super.v);
               } else {
                  SkinnedModel.hide(var4, super.v);
               }
            } else if (var1) {
               StaticModel.setIsStatic(super.v, this.bu);
               StaticModel.show(var4, super.v);
            } else {
               StaticModel.hide(var4, super.v);
            }
         }

      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void attachTo(GameEntity var1, String var2) {
      var1.attach(this, var2);
   }

   public static void ea(GameEntity var0, G53 var1) {
      var0.ce.d(var1);
   }

   public static int ev(GameEntity var0, String var1, int var2) {
      return G55.q(var0.ce, var1, var2);
   }

   public static void fv(long var0, Skeleton var2, N105 var3) {
      Object var4 = H149.v;
      synchronized(var4) {
         if (var0 != 0L) {
            if (var3 != null) {
               if (var3.d) {
                  SkinnedModel.destroy(var0);
               } else {
                  StaticModel.destroy(var0);
               }
            } else {
               com.jagex.jnibindings.runetek6.SceneGraphNode.destroy(var0);
            }

            var0 = 0L;
         }

         if (var2 != null) {
            Hi86.l(var2.g, var2);
            var2 = null;
         }

         if (var3 != null) {
            Hi86.l(var3.g, var3);
            var3 = null;
         }

      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setProperty(String var1, Object var2) {
      this.ce.h(var1, var2);
   }

   public static Object ej(GameEntity var0, String var1) {
      return var0.ce.j(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String enablePropertyChangeEvent(String var1) {
      return this.ce.g(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Integer hasPropertyChangeEvent(String var1) {
      return G55.s(this.ce, StringTools.l(var1));
   }

   public static Integer ex(GameEntity var0, int var1) {
      return G55.s(var0.ce, var1);
   }

   public static void ed(GameEntity var0, int var1, int var2, int var3) {
      if (var2 != var3) {
         Integer var4 = ex(var0, var1);
         if (var4 != null) {
            var0.triggerEvent(var4, var2);
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean hasSkeleton() {
      return this.cb != null;
   }

   public static Skeleton el(GameEntity var0) {
      return var0.cb;
   }

   protected void c(SceneGraphNode var1, String var2) {
      if (super.v != 0L && var1.v != 0L) {
         if (this.cb != null && this.cl != null && var2 != null) {
            int var3 = this.cb.d(var2);
            if (var3 != -1) {
               StaticModel.attachNodeToBone(super.v, var1.v, var3);
            } else {
               com.jagex.jnibindings.runetek6.SceneGraphNode.setParent(var1.v, super.v);
            }
         } else {
            com.jagex.jnibindings.runetek6.SceneGraphNode.setParent(var1.v, super.v);
         }

      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean isJointValid(int var1) {
      return this.hasSkeleton() && var1 >= 0 && var1 < this.cb.g();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public RotTrans getJointWorldTransform(int var1) {
      if (!this.hasSkeleton()) {
         logger.warn("Error, no skeleton found on GameEntity during joint transform lookup. Either the entity's skeleton has yet to be constructed or it does not exist.");
         return RotTrans.g;
      } else if (var1 == -1) {
         logger.warn("Error, erroneous joint index passed during joint transform lookup. Suspect no joint existed for the previous lookup.");
         return RotTrans.g;
      } else if (var1 >= 0 && var1 < this.cb.g()) {
         StaticModel.getBoneWorldTransform(super.v, var1, H149.j);
         Quaternion var2 = new Quaternion(Kc180.u(H149.j), Kc180.u(H149.j + 4L), Kc180.u(H149.j + 8L), Kc180.u(H149.j + 12L));
         Vector3 var3 = new Vector3(Kc180.u(H149.j + 16L), Kc180.u(H149.j + 20L), Kc180.u(H149.j + 24L));
         return new RotTrans(var2, var3);
      } else {
         logger.warn("Error, out of bound joint index.");
         return RotTrans.g;
      }
   }

   public static boolean ee(GameEntity var0, Class var1) {
      return var0.hasComponent(var1, 305419896);
   }

   public static long ew(Skeleton var0, N105 var1) {
      Object var2 = H149.v;
      synchronized(var2) {
         long var3;
         if (var1 != null) {
            long[] var5 = var1.q;
            int var6 = Kc180.e();
            long var7 = (long)(var5.length * var6);
            long var9 = Kc180.g(var7);

            for(int var11 = 0; var11 < var5.length; ++var11) {
               Kc180.s(var9 + (long)(var11 * var6), var5[var11]);
            }

            var3 = var1.d ? SkinnedModel.create() : StaticModel.create(var1.h);
            if (var0 != null) {
               StaticModel.g(var3, var0);
            } else if (var1.d) {
               logger.info("Error, skinned model doesn't have a skeleton");
            }

            StaticModel.replaceMeshes(var3, var9, var5.length, var1.s[0]);
            Kc180.d(var9);
         } else {
            var3 = com.jagex.jnibindings.runetek6.SceneGraphNode.create();
            if (var0 != null) {
               logger.warn("Warning, scene graph node has a skeleton");
               Hi86.l(var0.g, var0);
               var0 = null;
            }
         }

         return var3;
      }
   }

   public static void en(GameEntity var0, long var1, Skeleton var3, N105 var4) {
      Object var5 = H149.v;
      synchronized(var5) {
         boolean var6 = var0.v != var1;
         fa(var0);
         var0.v = var1;
         var0.cb = var3;
         var0.cl = var4;
         f(var0);
         if (var6) {
            var0.eh("__modelChanged", (Object)null);
         }

      }
   }

   /** @deprecated */
   @Deprecated
   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GameEntity LookupUUID(Object var0, String var1) {
      return lookupID(var1);
   }

   public static boolean eq(GameEntity var0) {
      return var0.cl != null && var0.cl.d;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getOBBTop() {
      Vector3 var1 = this.getWorldTransform().trans;
      Q10 var2 = k(this);
      if (var2 == null) {
         return var1;
      } else {
         var1 = Vector3.m(var1, 0.0F, Q10.q(var2), 0.0F);
         return var1;
      }
   }

   public static void fa(GameEntity var0) {
      Object var1 = H149.v;
      synchronized(var1) {
         fv(var0.v, var0.cb, var0.cl);
         var0.cb = null;
         var0.cl = null;
         var0.v = 0L;
      }
   }

   public Vector3 j() {
      Q10 var1 = i(this);
      return var1 == null ? this.getWorldTransform().trans : Vector3.g(Q10.d(var1), Q10.j(var1), Q10.h(var1));
   }

   public Vector3 e() {
      Q10 var1 = i(this);
      return var1 == null ? this.getWorldTransform().trans : Vector3.g(Q10.g(var1), Q10.q(var1), Q10.e(var1));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getID() {
      return this.bg.toString();
   }

   public static Component eo(GameEntity var0, Class var1) {
      return var0.removeComponent(var1, 305419896);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeAllEventHandlers(@ScriptID Integer var1) {
      this.bs.remove(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Component getComponent(Class var1, @ScriptID @ScriptDefaults(defaultInteger = 305419896) int var2) {
      int var3 = var2 == 305419896 ? StringTools.l(var1.getName()) : var2;
      return (Component)this.cd.get(var3);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getIDNumber() {
      return this.bg.h();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void addEventHandler(String var1, EventHandler var2) {
      this.addEventHandlerByID(StringTools.l(var1), var2);
   }

   protected static void ei(GameEntity var0) {
      var0.addEventHandler("__sound", cq);
      var0.addEventHandler("FootPlaced", var0.cp);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public RotTrans getJointObjectTransform(int var1) {
      if (super.v == 0L) {
         throw new IllegalStateException("GetJointObjectTransform called on entity without a model");
      } else {
         StaticModel.getBoneObjectTransform(super.v, var1, H149.j);
         Quaternion var2 = new Quaternion(Kc180.u(H149.j), Kc180.u(H149.j + 4L), Kc180.u(H149.j + 8L), Kc180.u(H149.j + 12L));
         Vector3 var3 = new Vector3(Kc180.u(H149.j + 16L), Kc180.u(H149.j + 20L), Kc180.u(H149.j + 24L));
         return new RotTrans(var2, var3);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public LuaUserData getModel() {
      if (super.v != 0L) {
         String var1;
         if (this.cl == null) {
            var1 = SceneGraphNode.class.getSimpleName();
         } else {
            var1 = this.cl.d ? SkinnedModel.class.getSimpleName() : StaticModel.class.getSimpleName();
         }

         return new LuaUserData(super.v, var1);
      } else {
         return null;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getOBBCentre() {
      Vector3 var1 = this.getWorldTransform().trans;
      Q10 var2 = k(this);
      if (var2 == null) {
         return var1;
      } else {
         var1 = Vector3.m(var1, 0.0F, var2.l().y, 0.0F);
         return var1;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetRange3D(Lp301 var1) {
      return Lc490.j(this, var1);
   }

   public void l() {
      this.ey();
      Iterator var1 = this.cd.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         Component var3 = (Component)var2.getValue();
         Component.bp(var3, (GameEntity)null);
         var3.bd();
      }

      fa(this);
      this.clearNativeComponents(this.bz.getLuaStateNativeRef());
      this.cd.clear();
      Bb4.d(this.bg);
   }
}
