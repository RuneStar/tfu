package com.jagex.game.runetek6.gameentity.components;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.MappedEventType;
import com.jagex.game.runetek6.event.PhysicsEventMode;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Q344;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class MappedEventComponent extends Component {
   public static final int h = StringTools.l(MappedEventComponent.class.getName());
   private PhysicsEventMode d;
   private final Q344 e = new D387(this);
   private Map g;
   Set j;
   Set q;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return h;
   }

   public static void g(MappedEventComponent var0, GameEntity var1) {
      d(var0, MappedEventType.ON_COLLIDE, var1);
   }

   private static void d(MappedEventComponent var0, MappedEventType var1, GameEntity var2) {
      if (var0.g != null && var0.g.containsKey(var1)) {
         var0.getEntity().triggerEvent((Integer)var0.g.get(var1), var2);
      }

   }

   public static boolean q(MappedEventComponent var0) {
      return var0.d != PhysicsEventMode.OFF;
   }

   private static void w(MappedEventComponent var0, Set var1) {
      if (var1 != null) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            GameEntity var3 = (GameEntity)var2.next();
            var2.remove();
            s(var0, var3);
         }
      }

   }

   public static boolean e(MappedEventComponent var0) {
      return var0.d == PhysicsEventMode.VOLUME;
   }

   private static void h(MappedEventComponent var0, GameEntity var1) {
      var1.et(var0.e);
      d(var0, MappedEventType.ON_ENTER, var1);
   }

   static void s(MappedEventComponent var0, GameEntity var1) {
      GameEntity.eu(var1, var0.e);
      d(var0, MappedEventType.ON_EXIT, var1);
   }

   public void b(GameEntity var1) {
      if (this.j == null) {
         if (this.q != null) {
            this.j = new HashSet(this.q.size() * 2);
         } else {
            this.j = new HashSet();
         }
      }

      if (!this.j.contains(var1)) {
         this.j.add(var1);
         if (this.q == null) {
            h(this, var1);
         } else {
            boolean var2 = this.q.remove(var1);
            if (!var2) {
               h(this, var1);
            }
         }

      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setOnExit(@ScriptID Integer var1) {
      if (this.d != PhysicsEventMode.VOLUME) {
         throw new IllegalStateException("Can't set onExit on this entity unless there is a <VolumeEvents /> tag (possibly empty) in the XML file.");
      } else {
         if (var1 == null) {
            if (this.g != null) {
               this.g.remove(MappedEventType.ON_EXIT);
            }
         } else {
            if (this.g == null) {
               this.g = new HashMap();
            }

            this.g.put(MappedEventType.ON_EXIT, var1);
         }

      }
   }

   private static void r(MappedEventComponent var0) {
      w(var0, var0.q);
      w(var0, var0.j);
      var0.q = null;
      var0.j = null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean entityIsInsideMe(GameEntity var1) {
      if (this.d != PhysicsEventMode.VOLUME) {
         throw new IllegalStateException("Can't query entities inside this entity unless this entity has a <VolumeEvents /> tag (possibly empty) in the XML file.");
      } else {
         return this.q != null && this.q.contains(var1) || this.j != null && this.j.contains(var1);
      }
   }

   public static boolean j(MappedEventComponent var0) {
      return var0.d != PhysicsEventMode.VOLUME;
   }

   protected void detachFromEntity() {
      r(this);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setOnCollide(@ScriptID Integer var1) {
      if (this.d != PhysicsEventMode.COLLISION) {
         throw new IllegalStateException("Can't set onCollide on this entity unless there is a <CollisionEvents /> tag (possibly empty) in the XML file.");
      } else {
         if (var1 == null) {
            if (this.g != null) {
               this.g.remove(MappedEventType.ON_COLLIDE);
            }
         } else {
            if (this.g == null) {
               this.g = new HashMap();
            }

            this.g.put(MappedEventType.ON_COLLIDE, var1);
         }

      }
   }

   public static void l(MappedEventComponent var0) {
      w(var0, var0.q);
      var0.q = var0.j;
      var0.j = null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getNumEntitiesInsideMe() {
      if (this.d != PhysicsEventMode.VOLUME) {
         throw new IllegalStateException("Can't query entities inside this entity unless this entity has a <VolumeEvents /> tag (possibly empty) in the XML file.");
      } else {
         int var1 = 0;
         if (this.q != null) {
            var1 += this.q.size();
         }

         if (this.j != null) {
            var1 += this.j.size();
         }

         return var1;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GameEntity[] getAllEntitiesInsideMe() {
      if (this.d != PhysicsEventMode.VOLUME) {
         throw new IllegalStateException("Can't query entities inside this entity unless this entity has a <VolumeEvents /> tag (possibly empty) in the XML file.");
      } else {
         GameEntity[] var1 = new GameEntity[this.getNumEntitiesInsideMe()];
         int var2 = 0;
         Iterator var3;
         GameEntity var4;
         if (this.q != null) {
            for(var3 = this.q.iterator(); var3.hasNext(); var1[var2++] = var4) {
               var4 = (GameEntity)var3.next();
            }
         }

         if (this.j != null) {
            for(var3 = this.j.iterator(); var3.hasNext(); var1[var2++] = var4) {
               var4 = (GameEntity)var3.next();
            }
         }

         return var1;
      }
   }

   public MappedEventComponent(Map var1, PhysicsEventMode var2) {
      this.g = var1;
      this.d = var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setOnEnter(@ScriptID Integer var1) {
      if (this.d != PhysicsEventMode.VOLUME) {
         throw new IllegalStateException("Can't set onEnter on this entity unless there is a <VolumeEvents /> tag (possibly empty) in the XML file.");
      } else {
         if (var1 == null) {
            if (this.g != null) {
               this.g.remove(MappedEventType.ON_ENTER);
            }
         } else {
            if (this.g == null) {
               this.g = new HashMap();
            }

            this.g.put(MappedEventType.ON_ENTER, var1);
         }

      }
   }

   public void bd() {
      r(this);
   }
}
