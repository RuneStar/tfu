package rs2.shared.sound;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.Event;
import com.jagex.game.runetek6.event.EventForwarder;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import rs2.shared.movement.PlayerPhysicsComponent;
import tfu.Be2;
import tfu.Bs1;
import tfu.Ko370;

@ScriptEntryClass
public class SoundAdapter implements EventForwarder {
   private GameEntity b;
   private String d;
   private boolean e;
   private String g;
   private Vector3 h;
   private int j;
   private SoundComponent l;
   private float q;
   private Hashtable r;
   private Vector3 s;
   private RotTrans w;

   protected void finalize() {
      Ko370.g(new D377(this));
   }

   SoundAdapter(SoundComponent var1, String var2, String var3, RotTrans var4) {
      this(var2, var3);
      this.b = null;
      this.setWorldTransform(var4);
      this.l = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeAllEventHandlers(@ScriptID Integer var1) {
      this.r.remove(var1);
   }

   public static void g(SoundAdapter var0, float var1) {
      if (var0.b != null) {
         if (var0.e) {
            RotTrans var2 = var0.b.getWorldTransform().q();
            PlayerPhysicsComponent var5 = (PlayerPhysicsComponent)GameEntity.eb(var0.b, PlayerPhysicsComponent.class);
            Vector3 var3;
            Vector3 var4;
            if (var5 != null) {
               var3 = var5.getLinearVelocity(true);
               var4 = var5.getAngularVelocity(true);
            } else {
               Vector3 var6 = Vector3.k(var2.trans, var0.w.trans);
               var3 = Vector3.ai(var6, var1);
               var4 = Vector3.g;
               float var7 = 100.0F;
               if (Vector3.f(var0.h) * (1.0F / var1) > 100.0F) {
                  var0.h = Vector3.g;
               }

               if (Vector3.f(var0.s) * (1.0F / var1) > 100.0F) {
                  var0.s = Vector3.g;
               }
            }

            boolean var9 = !RotTrans.q(var0.w, var2, 0.001F);
            boolean var10 = !Vector3.p(var0.h, var3, 0.001F);
            boolean var8 = !Vector3.p(var0.s, var4, 0.001F);
            if (var9) {
               var0.w = var2;
               e(var0, "SoundTransformChangedEvent", var0);
            }

            if (var10) {
               var0.h = var3;
               e(var0, "SoundLinearVelocityChangedEvent", var0);
            }

            if (var8) {
               var0.s = var4;
               e(var0, "SoundAngularVelocityChangedEvent", var0);
            }

         }
      }
   }

   public static void d(SoundAdapter var0, String var1, int var2) {
      var0.d = var1;
      var0.j = var2;
      var0.e = true;
      e(var0, "SoundStartedEvent", var0);
   }

   public static void q(SoundAdapter var0) {
      var0.e = false;
      e(var0, "SoundStoppedEvent", var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getVolume() {
      return this.q;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getName() {
      return this.g;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public RotTrans getWorldTransform() {
      return this.w;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public SoundComponent getComponent() {
      return this.l;
   }

   public void s(String var1) {
      assert var1 != null;

      this.d = var1;
      e(this, "SoundParamsChangedEvent", this);
   }

   SoundAdapter(SoundComponent var1, String var2, String var3) {
      this(var2, var3);
      this.l = var1;
      this.b = this.l.getEntity();
      this.w = this.b.getWorldTransform().q();
   }

   private SoundAdapter(String var1, String var2) {
      this.d = "";
      this.q = 1.0F;
      this.j = -1;
      this.e = false;
      this.h = Vector3.g;
      this.s = Vector3.g;
      this.w = RotTrans.g;
      this.r = new Hashtable();

      assert var1 != null;

      this.g = new String(var1);

      assert var2 != null;

      this.d = new String(var2);
      this.r.put(StringTools.l("SoundStartedEvent"), new Event());
      this.r.put(StringTools.l("SoundStoppedEvent"), new Event());
      this.r.put(StringTools.l("SoundRemovedEvent"), new Event());
      this.r.put(StringTools.l("SoundLinearVelocityChangedEvent"), new Event());
      this.r.put(StringTools.l("SoundAngularVelocityChangedEvent"), new Event());
      this.r.put(StringTools.l("SoundTransformChangedEvent"), new Event());
      this.r.put(StringTools.l("SoundParamsChangedEvent"), new Event());
      this.r.put(StringTools.l("SoundVolumeChangedEvent"), new Event());
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getObservedLinearVelocity() {
      return this.h;
   }

   public void h(float var1) {
      if (var1 >= 0.0F && var1 <= 1.0F) {
         this.q = var1;
         e(this, "SoundVolumeChangedEvent", this);
      } else {
         throw new NumberFormatException("Volume expected value between 0 and 1.");
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void addEventHandler(String var1, EventHandler var2) {
      this.addEventHandlerByID(StringTools.l(var1), var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeEventHandler(String var1, EventHandler var2) {
      this.removeEventHandlerByID(StringTools.l(var1), var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void addEventHandlerByID(@ScriptID Integer var1, EventHandler var2) {
      Event var3 = (Event)this.r.get(var1);
      if (var3 == null) {
         throw new RuntimeException("Could remove SoundAdapter event handle. Specified event does not exist.");
      } else {
         var3.add(var2);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getParams() {
      return this.d;
   }

   public static void j(SoundAdapter var0) {
      Collection var1 = var0.r.values();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Event var3 = (Event)var2.next();
         var3.clear();
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void triggerEvent(@ScriptID Integer var1, Object var2) {
      Event var3 = (Event)this.r.get(var1);
      if (var3 == null) {
         throw new RuntimeException("Could not trigger SoundAdapter event. Specified event does not exist.");
      } else {
         var3.trigger(this, var2);
      }
   }

   static void e(SoundAdapter var0, String var1, Object var2) {
      var0.triggerEvent(StringTools.l(var1), var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GameEntity getParent() {
      return this.b;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeEventHandlerByID(@ScriptID Integer var1, EventHandler var2) {
      Event var3 = (Event)this.r.get(var1);
      if (var3 == null) {
         throw new RuntimeException("Could remove SoundAdapter event handle. Specified event does not exist.");
      } else {
         var3.remove(var2);
      }
   }

   public static void b(SoundAdapter var0) {
      var0.b = var0.l.getEntity();
      var0.w = var0.b.getWorldTransform().q();
   }

   public static void l(SoundAdapter var0) {
      var0.b = null;
      var0.h = Vector3.g;
      var0.s = Vector3.g;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setWorldTransform(RotTrans var1) {
      if (var1 == null) {
         throw new IllegalStateException();
      } else if (this.b != null) {
         throw new UnsupportedOperationException("Tried to override the transform of a sound when it was already attached to a SceneGraphNode.");
      } else {
         this.w = var1;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getHandle() {
      return this.j;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getObservedAngularVelocity() {
      return this.s;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean isPlaying() {
      return this.e;
   }
}
