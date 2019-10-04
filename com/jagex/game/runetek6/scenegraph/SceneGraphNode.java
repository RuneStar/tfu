package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.LuaUserData;
import com.jagex.maths.Q10;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;
import tfu.L253;

@ScriptEntryClass
public class SceneGraphNode implements L253 {
   private static final Logger logger = LoggerFactory.getLogger(SceneGraphNode.class);
   SceneGraphNode b;
   public boolean d = true;
   private ScaleRotTrans e;
   WeakReference h;
   private ScaleRotTrans j;
   SceneGraphNode l;
   private Q10 p;
   private ScaleRotTrans q;
   private E254 r;
   SceneGraphNode s;
   private LinkedHashSet t;
   public boolean u;
   public long v;
   String w;
   public boolean x;
   private Q10 y;
   public boolean z;

   public final long g() {
      return this.v;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final ScaleRotTrans getParentWorldTransform() {
      return this.l != null ? this.l.getWorldTransform() : null;
   }

   public void l() {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final ScaleRotTrans getObjectTransform() {
      return this.q;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void setObjectTransform(ScaleRotTrans var1) {
      if (var1 == null) {
         throw new NullPointerException("argument cannot be null");
      } else {
         this.q = var1;
         p(this);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final float getObjectScale() {
      return this.q.scale;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void setObjectRotation(Quaternion var1) {
      this.q = this.q.b(var1);
      p(this);
   }

   public static final void w(SceneGraphNode var0, Vector3 var1) {
      var0.q = var0.q.w(var1);
      p(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void setObjectTranslation(float var1, float var2, float var3) {
      this.q = this.q.l(var1, var2, var3);
      p(this);
   }

   public static final void r(SceneGraphNode var0, Vector3 var1) {
      var0.q = var0.q.h(var1);
      p(var0);
   }

   public static final ScaleRotTrans v(SceneGraphNode var0) {
      if (var0.e == null) {
         var0.e = var0.getWorldTransform().j();
      }

      return var0.e;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void setWorldTransform(RotTrans var1) {
      float var2 = y(this);
      ScaleRotTrans var3 = new ScaleRotTrans(var1, var2);
      if (this.l != null) {
         var3 = var3.e(v(this.l));
      }

      this.setObjectTransform(var3);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void removeFromScene() {
      Scene var1 = this.getScene();
      if (var1 != null) {
         Scene.w(var1, this);
      }

   }

   private static final void x(SceneGraphNode var0) {
      z(var0);
      if (var0.s != null) {
         u(var0.s);
      }

   }

   public SceneGraphNode() {
      this.q = ScaleRotTrans.g;
      this.j = null;
      this.e = null;
      this.h = null;
      this.s = null;
      this.b = null;
      this.l = null;
      this.w = null;
      this.v = 0L;
      this.x = false;
      this.u = true;
      this.z = false;
      this.t = null;
   }

   private static final void u(SceneGraphNode var0) {
      x(var0);
      if (var0.b != null) {
         u(var0.b);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void attach(SceneGraphNode var1, String var2) {
      if (var1.l == this) {
         logger.warn("this child is already attached to this node - did you mean to attach it twice?", new Throwable());
      } else if (var1.l != null) {
         throw new IllegalStateException("This child is already attached to something!");
      } else if (var1.h != null) {
         throw new IllegalStateException("When attaching entities, the child must not already be in the scene. It will be added automatically if the parent is in the scene (or when the parent is added to the scene).");
      } else {
         Scene var3 = this.getScene();
         if (var3 != null) {
            var3.add(var1);
         }

         var1.ag(this, var2);
      }
   }

   private static final void m(SceneGraphNode var0) {
      t(var0);
      if (var0.b != null) {
         m(var0.b);
      }

   }

   private static void n(SceneGraphNode var0) {
      if (var0.t != null) {
         Iterator var1 = var0.t.iterator();

         while(var1.hasNext()) {
            Runnable var2 = (Runnable)var1.next();
            var2.run();
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final ScaleRotTrans getWorldTransform() {
      if (this.j == null) {
         if (this.l != null) {
            this.j = this.q.e(this.l.getWorldTransform());
         } else {
            this.j = this.q;
         }
      }

      return this.j;
   }

   public static Q10 i(SceneGraphNode var0) {
      if (var0.p == null && var0.y != null) {
         var0.p = var0.y.s(var0.getWorldTransform());
      }

      return var0.p;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void hide(@ScriptDefaults(defaultBoolean = true) boolean var1) {
      this.setVisibility(false, var1);
   }

   public static SceneGraphNode a(SceneGraphNode var0) {
      return var0.l;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final Scene getScene() {
      WeakReference var1 = this.h;
      return var1 == null ? null : (Scene)var1.get();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void setObjectScale(float var1) {
      this.q = this.q.s(var1);
      p(this);
   }

   protected static final void f(SceneGraphNode var0) {
      if (var0.l != null) {
         var0.l.c(var0, var0.w);
      }

      for(SceneGraphNode var1 = var0.s; var1 != null; var1 = var1.b) {
         var0.c(var1, var1.w);
      }

   }

   protected void c(SceneGraphNode var1, String var2) {
   }

   final void ag(SceneGraphNode var1, String var2) {
      SceneGraphNode var3;
      if (this.l != null) {
         var3 = this.l.s;
         if (var3 == this) {
            this.l.s = this.b;
         } else {
            while(var3.b != this) {
               var3 = var3.b;
            }

            var3.b = this.b;
         }
      }

      if (var1 != null) {
         for(var3 = var1; var3 != null; var3 = var3.l) {
            if (var3 == this) {
               throw new RuntimeException();
            }
         }

         this.b = var1.s;
         var1.s = this;
      } else {
         this.b = null;
      }

      this.l = var1;
      this.w = var2;
      if (this.l != null) {
         this.l.c(this, this.w);
      }

      p(this);
   }

   static final void aq(SceneGraphNode var0) {
      if (var0.l != null) {
         SceneGraphNode var1 = var0.l.s;
         if (var1 == var0) {
            var0.l.s = var0.b;
         } else {
            while(var1.b != var0) {
               var1 = var1.b;
            }

            var1.b = var0.b;
         }
      }

      if (var0.s != null) {
         while(var0.s != null) {
            var0.s.q = var0.s.q.e(var0.q);
            var0.s.ag(var0.l, var0.w);
         }
      }

      al(var0, (E254)null);
      var0.b = null;
      var0.l = null;
      var0.s = null;
      p(var0);
   }

   public static void o(SceneGraphNode var0, Q10 var1) {
      var0.y = var1;
      var0.p = null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void show(@ScriptDefaults(defaultBoolean = true) boolean var1) {
      this.setVisibility(true, var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void setVisibility(boolean var1, @ScriptDefaults(defaultBoolean = true) boolean var2) {
      this.af(var1);
      if (var2) {
         for(SceneGraphNode var3 = this.s; var3 != null; var3 = var3.b) {
            var3.setVisibility(var1, var2);
         }
      }

   }

   protected void af(boolean var1) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public LuaUserData getModel() {
      return new LuaUserData(this.v, SceneGraphNode.class.getSimpleName());
   }

   public static Q10 k(SceneGraphNode var0) {
      return var0.y;
   }

   public static final float y(SceneGraphNode var0) {
      if (var0.l == null) {
         return var0.q.scale;
      } else if (var0.j == null) {
         float var1 = y(var0.l);
         var1 *= var0.q.scale;
         return var1;
      } else {
         return var0.j.scale;
      }
   }

   protected static void z(SceneGraphNode var0) {
      var0.j = null;
      var0.p = null;
      var0.e = null;
   }

   public Iterable ai() {
      return new Q255(this);
   }

   public static final void al(SceneGraphNode var0, E254 var1) {
      if (var0.r != null) {
         var0.r.d.remove(var0);
         var0.r = null;
      }

      if (var1 != null) {
         var0.r = var1.s(var0);
      }

   }

   private static final void p(SceneGraphNode var0) {
      x(var0);
      t(var0);
   }

   public static final void b(SceneGraphNode var0) {
      var0.l();

      for(SceneGraphNode var1 = var0.s; var1 != null; var1 = var1.b) {
         b(var1);
      }

   }

   private static final void t(SceneGraphNode var0) {
      n(var0);
      if (var0.s != null) {
         m(var0.s);
      }

   }
}
