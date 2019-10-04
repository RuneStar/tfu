package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.MappedEventType;
import com.jagex.game.runetek6.event.PhysicsEventMode;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.scripthelpers.STaskFuture;
import com.jagex.jnibindings.runetek6.Animation;
import com.jagex.jnibindings.runetek6.D91;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.maths.Q10;
import com.jagex.maths.V198;
import com.jagex.maths.Vector3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ai354;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bn279;
import tfu.Bs1;
import tfu.Bu350;
import tfu.Bv351;
import tfu.Fk353;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;
import tfu.Hp62;
import tfu.Ik357;
import tfu.Iz11;
import tfu.Ki358;
import tfu.Lb33;
import tfu.N105;

@ScriptEntryClass("Element")
public class XElement extends Am76 implements Hp62 {
   private static final Bu350 ag = new Bu350("Element Worker Thread (Temporary)");
   public static XElementLibrary ai;
   private static final Bv351 aq = new Bv351();
   private static Object[] c;
   public static boolean f = true;
   public static Bb4 j = null;
   private static final Logger logger = LoggerFactory.getLogger(XElement.class);
   public static boolean q = false;
   private B352 a;
   private XElement b;
   private UUID e;
   private Serializable h;
   private Map i;
   private Set k;
   public Map l = new HashMap();
   private Map m;
   private Map n;
   private Map o;
   public Map p = null;
   private Serializable r = null;
   private Serializable s;
   private Map t;
   public int u = 7;
   private Serializable v = null;
   public Q10 w;
   public PhysicsEventMode x = null;
   private Map y = null;
   public List z;

   public XElement(UUID var1, D80 var2, Serializable var3, Serializable var4) {
      super(var2);
      this.e = var1;
      this.h = var3;
      this.s = var4;
   }

   public XElement(XElement var1) {
      super(var1);
      this.b = var1;
      this.s = var1 != null ? var1.h : null;
   }

   public String toString() {
      return "XElement<" + this.h + ">@" + Integer.toHexString(this.hashCode());
   }

   public static Serializable w(XElement var0) {
      return v(var0, (Serializable)null);
   }

   public void p(Hg85 var1) {
      String var2 = this.r != null ? "Element (" + this.r + ")" : null;

      for(XElement var3 = this; var3 != null; var3 = var3.b) {
         if (var3.r != null && this.r != null && !var3.r.equals(this.r)) {
            throw new RuntimeException("Inconsistent skeleton reference between XElement and Archetype " + var3.h + " (" + this.r + ", " + var3.r + ")");
         }

         Iterator var4;
         Serializable var5;
         if (var3.z != null) {
            for(var4 = var3.z.iterator(); var4.hasNext(); var2 = "Mesh: " + var5 + " (" + this.r + ")") {
               var5 = (Serializable)var4.next();
               this.x(var5, Fk353.class, "Mesh", var2, var1);
            }
         }

         if (var3.t != null) {
            for(var4 = var3.t.values().iterator(); var4.hasNext(); var2 = "Mesh: " + var5 + " (" + this.r + ")") {
               var5 = (Serializable)var4.next();
               this.x(var5, Fk353.class, "Mesh", var2, var1);
            }
         }
      }

   }

   private void x(Serializable var1, Class var2, String var3, String var4, Hg85 var5) {
      Serializable[] var6 = (Serializable[])var5.g(Skeleton.class, var2, var1);
      if (var6.length > 1) {
         throw new RuntimeException("Multiple skeleton references not allowed for resources!");
      } else {
         if (var4 != null) {
            if (this.r != null) {
               if (var6.length != 0) {
                  String var7 = this.r.toString().toLowerCase();
                  String var8 = var6[0].toString().toLowerCase();
                  if (!var7.equals(var8)) {
                     throw new RuntimeException("Inconsistent skeleton reference between " + var7 + " and " + var3 + ": " + var1 + " (" + var8 + ")");
                  }
               }
            } else if (var6.length != 0) {
               throw new RuntimeException("Inconsistent skeleton reference between " + var4 + " and " + var3 + ": " + var1 + " (" + var6[0] + ")");
            }
         } else {
            this.r = var6.length == 1 ? var6[0] : null;
         }

      }
   }

   public static void bd() {
      Lb33.g(Lb33.XElementQueue);

      try {
         if (G104.g == null) {
            G104.g = Thread.currentThread();
         }

         while(true) {
            Bn279 var0 = aq.g();
            if (var0 == null) {
               c = Bu350.q(ag, c);
               Lb33.d(Lb33.XElementQueue);
               return;
            }

            try {
               G104 var1 = (G104)var0.d();
               if (var1 != null) {
                  GameEntity var2 = var1.j();
                  if (var2 != null && var0.j != null) {
                     ((EventHandler)var0.j).trigger(var2, (Object)null);
                  }
               }
            } catch (Exception var6) {
               logger.error("", var6);
            }
         }
      } finally {
         Lb33.d(Lb33.XElementQueue);
      }
   }

   public static void z(XElement var0, Map var1) {
      if (var0.b != null) {
         z(var0.b, var1);
      }

      if (var0.o != null && !var0.o.isEmpty()) {
         var1.putAll(var0.o);
      }

   }

   public static Map t(XElement[] var0) {
      HashMap var1 = new HashMap();
      m(var0, var1);
      return var1;
   }

   public static void m(XElement[] var0, Map var1) {
      for(int var2 = var0.length - 1; var2 >= 0; --var2) {
         z(var0[var2], var1);
      }

   }

   public void n(Integer var1, float[] var2) {
      if (this.o == null) {
         this.o = new HashMap();
      }

      this.o.put(var1, var2);
   }

   public void i(int var1, Serializable var2) {
      if (this.t == null) {
         this.t = new HashMap();
      }

      this.t.put(var1, var2);
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public void setMeshVisibility(@ScriptID Integer var1, boolean var2) {
      if (this.m == null) {
         this.m = new HashMap();
      }

      this.m.put(var1, var2);
   }

   private static void ab(XElement var0, EnumMap var1) {
      if (var0.b != null) {
         ab(var0.b, var1);
      }

      if (var0.p != null) {
         var1.putAll(var0.p);
      }

   }

   public static XElement by(Gg3 var0, D80 var1) throws Au64 {
      // $FF: Couldn't be decompiled
   }

   public static void c(XElement[] var0, Set var1) {
      HashMap var2 = new HashMap();

      for(int var3 = 0; var3 < var0.length; ++var3) {
         var0[var3].o(var1, var2);
      }

   }

   public static void aq(XElement var0, Serializable var1) {
      var0.v = var1;
   }

   public static void al(XElement var0, Map var1, Hi86 var2) {
      if (var0.b != null) {
         al(var0.b, var1, var2);
      }

      if (var0.k != null) {
         Iterator var3 = var0.k.iterator();

         while(var3.hasNext()) {
            Serializable var4 = (Serializable)var3.next();

            try {
               Bj61 var5 = (Bj61)var2.j(Bj61.class, var4);
               Bj61.g(var5, var1);
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }
      }

      if (var0.n != null && !var0.n.isEmpty()) {
         var1.putAll(var0.n);
      }

   }

   public static void av(XElement[] var0, Map var1, Hi86 var2) {
      for(int var3 = var0.length - 1; var3 >= 0; --var3) {
         al(var0[var3], var1, var2);
      }

   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public static XElement construct(XElement var0) {
      return new XElement(var0);
   }

   public void ap(int var1, Serializable var2) {
      if (this.n == null) {
         this.n = new HashMap();
      }

      this.n.put(var1, var2);
   }

   public static void ao(XElement var0, Set var1) {
      if (var0.b != null) {
         ao(var0.b, var1);
      }

      if (var0.k != null) {
         var1.addAll(var0.k);
      }

   }

   public void aa(Serializable var1) {
      if (this.k == null) {
         this.k = new HashSet();
      }

      this.k.add(var1);
   }

   public static B352 an(XElement var0) {
      return var0.a == null && var0.b != null ? an(var0.b) : var0.a;
   }

   public static B352 am(XElement[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         B352 var2 = an(var0[var1]);
         if (var2 != null) {
            return var2;
         }
      }

      return null;
   }

   public Map as() {
      HashMap var1 = new HashMap();
      ac(this, var1);
      return var1;
   }

   private static void ac(XElement var0, Map var1) {
      if (var0.b != null) {
         ac(var0.b, var1);
      }

      if (var0.y != null) {
         var1.putAll(var0.y);
      }

   }

   public Map at() {
      EnumMap var1 = new EnumMap(MappedEventType.class);
      ab(this, var1);
      return var1;
   }

   public static PhysicsEventMode aw(XElement var0) {
      if (var0.x != null) {
         return var0.x;
      } else {
         return var0.b != null ? aw(var0.b) : PhysicsEventMode.OFF;
      }
   }

   public static void ar(XElement var0, Map var1) {
      if (var0.b != null) {
         ar(var0.b, var1);
      }

      var1.putAll(var0.l);
   }

   public static String ax(XElement var0, String var1, String var2) {
      Bm108 var3 = (Bm108)var0.l.get(var1);
      return var3 != null && var3.w == Ag97.g ? (String)var3.r : (var0.b != null ? ax(var0.b, var1, var2) : var2);
   }

   public static double au(XElement var0, String var1, double var2) {
      Bm108 var4 = (Bm108)var0.l.get(var1);
      return var4 != null && var4.w == Ag97.d ? (Double)var4.r : (var0.b != null ? au(var0.b, var1, var2) : var2);
   }

   public static boolean aj(XElement var0, String var1, boolean var2) {
      Bm108 var3 = (Bm108)var0.l.get(var1);
      return var3 != null && var3.w == Ag97.q ? (Boolean)var3.r : (var0.b != null ? aj(var0.b, var1, var2) : var2);
   }

   public static Vector3 ak(XElement var0, String var1, Vector3 var2) {
      Bm108 var3 = (Bm108)var0.l.get(var1);
      return var3 != null && var3.w == Ag97.j ? (Vector3)var3.r : (var0.b != null ? ak(var0.b, var1, var2) : var2);
   }

   public static V198 ay(XElement var0, String var1, V198 var2) {
      Bm108 var3 = (Bm108)var0.l.get(var1);
      return var3 != null && var3.w == Ag97.e ? (V198)var3.r : (var0.b != null ? ay(var0.b, var1, var2) : var2);
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public static STaskFuture configureEntityFromElements(XElement[] var0, GameEntity var1, EventHandler var2, @ScriptDefaults(defaultBoolean = true) boolean var3) {
      return bl(var0, var1, (Vector3)null, var2, var3);
   }

   private static Serializable v(XElement var0, Serializable var1) {
      if (var1 != null) {
         if (!var1.equals(var0.r)) {
            logger.info("Archetype hierarchy skeleton inconsistency!");
            return var1;
         }
      } else {
         var1 = var0.r;
      }

      if (var0.b != null) {
         var1 = v(var0.b, var1);
      }

      return var1;
   }

   public static void bm() {
      ag.d();
   }

   public static STaskFuture bq(XElement var0, GameEntity var1, EventHandler var2) {
      return configureEntityFromElements(new XElement[]{var0}, var1, var2, true);
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public static STaskFuture configureEntity(XElement var0, GameEntity var1, EventHandler var2, @ScriptDefaults(defaultBoolean = true) boolean var3) {
      return configureEntityFromElements(new XElement[]{var0}, var1, var2, var3);
   }

   public static STaskFuture bo(XElement var0, GameEntity var1, Vector3 var2, EventHandler var3) {
      return bl(new XElement[]{var0}, var1, var2, var3, true);
   }

   public static Serializable ag(XElement var0) {
      if (var0.v != null) {
         return var0.v;
      } else {
         return var0.b != null ? ag(var0.b) : null;
      }
   }

   public static STaskFuture bl(XElement[] var0, GameEntity var1, Vector3 var2, EventHandler var3, boolean var4) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (var1.getScene() == null) {
         throw new IllegalStateException("ConfigureEntity() or ConfigureEntityFromElements() must be called with an entity already added to a scene - this entity has not been added");
      } else {
         An120 var5 = new An120(var1, var0, var2, var4);
         return new STaskFuture(ag.g(var5, aq, var3));
      }
   }

   static G104 bw(GameEntity var0, XElement var1, Hi86 var2, boolean var3) throws Exception {
      return bj(var0, new XElement[]{var1}, (Vector3)null, var2, var3);
   }

   public static G104 bj(GameEntity var0, XElement[] var1, Vector3 var2, Hi86 var3, boolean var4) throws Exception {
      G104 var5 = bk(var1, var2, var3, var0.bz, var4);
      var5.d = var0;
      return var5;
   }

   private static G104 bk(XElement[] var0, Vector3 var1, Hi86 var2, ScriptManager var3, boolean var4) throws Exception {
      if (var3 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         Serializable var5 = null;
         int var6 = 0;
         XElement[] var7 = var0;
         int var8 = var0.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            XElement var10 = var7[var9];
            Serializable var11 = w(var10);
            if (var11 != null) {
               if (var6 > 0 && var11 != var5 && (var11 == null || var5 == null || !var11.equals(var5))) {
                  throw new Exception("Elements contained more than one different skeleton, " + var11 + " vs " + var5);
               }

               ++var6;
               var5 = var11;
            }
         }

         Bn279 var26;
         if (var4 && var5 != null && var2 != null) {
            var26 = var2.e(Skeleton.class, var5, Integer.MAX_VALUE, (Bv351)null, (Object)null);
         } else {
            var26 = null;
         }

         Bn279 var27;
         if (var4) {
            Set var28 = f(var0);
            var27 = Ai354.s(var28, var2, Integer.MAX_VALUE);
         } else {
            var27 = null;
         }

         Serializable var30 = ai(var0);
         Bn279 var29;
         if (var30 != null) {
            var29 = var2.e(Iz11.class, var30, Integer.MAX_VALUE, (Bv351)null, (Object)null);
         } else {
            var29 = null;
         }

         Skeleton var31 = null;
         if (var26 != null) {
            try {
               var31 = (Skeleton)var26.d();
            } catch (Exception var25) {
               logger.error("Error loading skeleton", var25);
            }
         }

         AnimationGraphComponent var12;
         if (var4 && var31 != null) {
            B352 var13 = am(var0);
            if (var13 != null) {
               Map var14 = af(var0, var2);
               if (!var14.isEmpty()) {
                  var12 = new AnimationGraphComponent(var13.g, var31, var14, t(var0));
                  var12.d = var13.j;
                  var12.q = var13.d;
                  var12.j = var13.q;
               } else {
                  var12 = null;
               }
            } else {
               var12 = null;
            }
         } else {
            var12 = null;
         }

         MappedEventComponent var32 = null;
         XElement[] var33 = var0;
         int var15 = var0.length;

         for(int var16 = 0; var16 < var15; ++var16) {
            XElement var17 = var33[var16];
            Map var18 = var17.at();
            PhysicsEventMode var19 = aw(var17);
            if (var18.size() > 0 || var19 != PhysicsEventMode.OFF) {
               if (var18.isEmpty()) {
                  var18 = null;
               }

               var32 = new MappedEventComponent(var18, var19);
               break;
            }
         }

         N105 var34 = null;
         if (var27 != null) {
            try {
               var34 = (N105)var27.d();
            } catch (Exception var24) {
               logger.error("Error loading mesh", var24);
            }
         }

         Iz11 var35 = null;
         if (var29 != null) {
            try {
               var35 = (Iz11)var29.d();
            } catch (Exception var23) {
               logger.error("Error loading physical geometry", var23);
            }
         }

         ArrayList var36 = new ArrayList();
         int var20;
         int var21;
         XElement var22;
         XElement[] var40;
         if (var34 != null) {
            int var37 = 0;
            UUID var39 = null;
            var40 = var0;
            var20 = var0.length;

            for(var21 = 0; var21 < var20; ++var21) {
               var22 = var40[var21];
               N105.e(var34, var37, var22.u);
               ++var37;
               if (var22.e != null && var39 == null) {
                  var39 = var22.e;
               }
            }

            if (var39 != null) {
               N105.s(var34, var39);
            }
         }

         long var38 = var4 ? GameEntity.ew(var31, var34) : 0L;
         var40 = var0;
         var20 = var0.length;

         for(var21 = 0; var21 < var20; ++var21) {
            var22 = var40[var21];
            var22.bh(var36, var2, var3, var4);
         }

         return new Aw103(var36, var38, var31, var34, var0, var1, var32, var35, var12, var4);
      }
   }

   private static void bx(XElement var0, GameEntity var1, Vector3 var2) {
      if (var0.w == null) {
         GameEntity.o(var1, (Q10)null);
      }

      if (var0.b != null) {
         bx(var0.b, var1, var2);
      }

      if (var0.ah != null) {
         GameEntity.w(var1, var0.ah);
      }

      if (var2 != null) {
         GameEntity.r(var1, var2);
      }

      if (var0.ap != null) {
         var1.setObjectRotation(var0.ap);
      }

      if (var0.ao != null) {
         var1.setObjectScale(var0.ao);
      }

      if (j != null && var1.bg == j) {
      }

      if (var0.w != null) {
         GameEntity.o(var1, var0.w);
      }

   }

   public void r(Gg3 var1, Hk84 var2, Hg85 var3, Hi86 var4) {
      if (this.h != null && this.h.equals("desoldier_ex01_sniperriflebase")) {
         System.out.println("WHAT!?");
      }

      boolean var5 = false;
      boolean var6 = false;
      int var7;
      if (this.e != null) {
         Gg3.k(var1, Bw168.ID.a);
         var7 = var1.v += 4;
         var1.af(this.e.toString());
         Gg3.am(var1, var1.v - var7);
      }

      if (this.h != null) {
         Gg3.k(var1, Bw168.NAME.a);
         Gg3.a(var1, Hk84.g(var2, XElement.class, this.h));
      }

      if (this.s != null) {
         Gg3.k(var1, Bw168.INHERITS.a);
         Gg3.a(var1, Hk84.g(var2, XElement.class, this.s));
      }

      if (this.w != null) {
         Gg3.k(var1, Bw168.OBB.a);
         Gg3.aq(var1, this.w.g.f00);
         Gg3.aq(var1, this.w.g.f01);
         Gg3.aq(var1, this.w.g.f02);
         Gg3.aq(var1, this.w.g.f03);
         Gg3.aq(var1, this.w.g.f10);
         Gg3.aq(var1, this.w.g.f11);
         Gg3.aq(var1, this.w.g.f12);
         Gg3.aq(var1, this.w.g.f13);
         Gg3.aq(var1, this.w.g.f20);
         Gg3.aq(var1, this.w.g.f21);
         Gg3.aq(var1, this.w.g.f22);
         Gg3.aq(var1, this.w.g.f23);
         Gg3.aq(var1, this.w.g.f30);
         Gg3.aq(var1, this.w.g.f31);
         Gg3.aq(var1, this.w.g.f32);
         Gg3.aq(var1, this.w.g.f33);
      }

      Iterator var16;
      if (this.z != null && !this.z.isEmpty()) {
         Gg3.k(var1, Bw168.MESHES.a);
         Gg3.a(var1, this.z.size() * 4);
         var16 = this.z.iterator();

         while(var16.hasNext()) {
            Serializable var8 = (Serializable)var16.next();
            Gg3.a(var1, Hk84.g(var2, Fk353.class, var8));
         }
      }

      Serializable var9;
      if (this.t != null && !this.t.isEmpty()) {
         Gg3.k(var1, Bw168.NAMED_MESHES.a);
         Gg3.a(var1, this.t.size() * 9);
         var16 = this.t.entrySet().iterator();

         while(var16.hasNext()) {
            Entry var17 = (Entry)var16.next();
            var9 = (Serializable)var17.getValue();
            Gg3.a(var1, (Integer)var17.getKey());
            Gg3.a(var1, Hk84.g(var2, Fk353.class, var9));
            Gg3.k(var1, Boolean.TRUE.equals(this.m.get(var17.getKey())) ? 1 : 0);
         }
      }

      Iterator var18;
      Entry var20;
      if (this.n != null && !this.n.isEmpty()) {
         Gg3.k(var1, Bw168.ANIMATIONS.a);
         var7 = var1.v += 4;
         var18 = this.n.entrySet().iterator();

         while(var18.hasNext()) {
            var20 = (Entry)var18.next();
            Gg3.a(var1, (Integer)var20.getKey());
            Gg3.a(var1, Hk84.g(var2, Animation.class, var20.getValue()));
         }

         Gg3.am(var1, var1.v - var7);
         var6 = true;
      }

      if (this.k != null && !this.k.isEmpty()) {
         Gg3.k(var1, Bw168.ANIMATION_SETS.a);
         var7 = var1.v += 4;
         Gg3.a(var1, this.k.size());
         var18 = this.k.iterator();

         while(var18.hasNext()) {
            var9 = (Serializable)var18.next();
            Gg3.a(var1, Hk84.g(var2, Bj61.class, var9));
         }

         Gg3.am(var1, var1.v - var7);
         var6 = true;
      }

      if (this.v != null) {
         boolean var19 = true;

         try {
            var7 = Hk84.g(var2, Iz11.class, this.v);
            Gg3.k(var1, Bw168.PHYSICS_COLLISION_GEOMETRY.a);
            Gg3.a(var1, var7);
         } catch (Exception var15) {
            logger.error("[red]Warning: Reference to a unrecognised (non-existant) collision geometry {}[/red]", this.v);
            logger.error("[red]       This instance of collision geometry will be ignored.[/red]");
         }
      }

      Gg3.k(var1, Bw168.RENDER_FLAGS.a);
      Gg3.a(var1, this.u);
      br(this, var1, Bw168.STRING_PROPERTIES.a, Ag97.g);
      br(this, var1, Bw168.NUMERIC_PROPERTIES.a, Ag97.d);
      br(this, var1, Bw168.BOOLEAN_PROPERTIES.a, Ag97.q);
      br(this, var1, Bw168.VECTOR3_PROPERTIES.a, Ag97.j);
      br(this, var1, Bw168.VECTOR4_PROPERTIES.a, Ag97.e);
      if (this.y != null && !this.y.isEmpty()) {
         Gg3.k(var1, Bw168.EVENT_HANDLERS.a);
         var7 = var1.v += 4;
         var18 = this.y.entrySet().iterator();

         while(var18.hasNext()) {
            var20 = (Entry)var18.next();
            Gg3.a(var1, (Integer)var20.getKey());
            var1.ap((String)var20.getValue());
         }

         Gg3.am(var1, var1.v - var7);
      }

      if (this.p != null && !this.p.isEmpty()) {
         Gg3.k(var1, Bw168.EVENT_MAPPINGS.a);
         var7 = var1.v += 4;
         var18 = this.p.entrySet().iterator();

         while(var18.hasNext()) {
            var20 = (Entry)var18.next();
            Gg3.i(var1, ((MappedEventType)var20.getKey()).getId());
            Gg3.a(var1, (Integer)var20.getValue());
         }

         Gg3.am(var1, var1.v - var7);
      }

      if (this.x != null) {
         Gg3.k(var1, Bw168.PHYSICS_EVENT_MODE.a);
         Gg3.k(var1, this.x.getId());
      }

      if (this.a != null) {
         Gg3.k(var1, Bw168.ANIMATION_GRAPH.a);
         var7 = var1.v += 4;
         Gg3.ao(var1, this.a.g);
         if (this.a.d != null) {
            Gg3.k(var1, 1);
            Gg3.a(var1, this.a.d);
         } else {
            Gg3.k(var1, 0);
         }

         if (this.a.q != null) {
            Gg3.k(var1, 1);
            Gg3.a(var1, this.a.q);
         } else {
            Gg3.k(var1, 0);
         }

         if (this.a.j != null) {
            Gg3.k(var1, 1);
            Gg3.a(var1, this.a.j);
         } else {
            Gg3.k(var1, 0);
         }

         Gg3.am(var1, var1.v - var7);
      }

      this.p(var3);
      if (this.r != null) {
         var7 = Hk84.g(var2, Skeleton.class, this.r);
         Gg3.k(var1, Bw168.SKELETON.a);
         Gg3.a(var1, var7);
         if (this.i != null) {
            D91 var21;
            try {
               var21 = (D91)var4.j(D91.class, var7);
            } catch (Ik357 var14) {
               throw new RuntimeException("Exception occured whilst loading skeleton", var14);
            }

            Iterator var23 = this.i.entrySet().iterator();

            while(var23.hasNext()) {
               Entry var10 = (Entry)var23.next();
               Ay90 var11 = (Ay90)var10.getValue();
               this.n((Integer)var10.getKey(), Ay90.g(var11, var21));
            }

            Gg3.k(var1, Bw168.SKELETON_MASKS.a);
            int var24 = var1.v += 4;
            Gg3.a(var1, this.o.size());
            Gg3.a(var1, var21.g());
            Iterator var22 = this.o.entrySet().iterator();

            while(true) {
               if (!var22.hasNext()) {
                  Gg3.am(var1, var1.v - var24);
                  break;
               }

               Entry var25 = (Entry)var22.next();
               float[] var12 = (float[])var25.getValue();
               Gg3.a(var1, (Integer)var25.getKey());

               for(int var13 = 0; var13 < var12.length; ++var13) {
                  Gg3.aq(var1, var12[var13]);
               }
            }
         }

         var5 = true;
      } else if (this.i != null) {
         throw new RuntimeException("Skeleton mask specified with-out implicit or explicit skeleton");
      }

      Gg3.k(var1, Bw168.SUPER_TYPE_PROPERTIES.a);
      var7 = var1.v += 4;
      super.r(var1, var2, var3, var4);
      Gg3.am(var1, var1.v - var7);
      Gg3.k(var1, 0);
      if (var6 && !var5) {
         logger.warn("[red]Element has animation but cannot find a skeleton[/red]");
      }

   }

   private static void br(XElement var0, Gg3 var1, int var2, Ag97 var3) {
      Map var4 = var0.ad(var3);
      if (!var4.isEmpty()) {
         Gg3.k(var1, var2);
         int var5 = var1.v += 4;
         Iterator var6 = var4.entrySet().iterator();

         while(var6.hasNext()) {
            Entry var7 = (Entry)var6.next();
            String var8 = (String)var7.getKey();
            Bm108 var9 = (Bm108)var7.getValue();
            Gg3.i(var1, var0.d(var8));
            var9.d(var1);
         }

         Gg3.am(var1, var1.v - var5);
      }

   }

   private Map ad(Ag97 var1) {
      HashMap var2 = new HashMap();
      Iterator var3 = this.l.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         Bm108 var5 = (Bm108)var4.getValue();
         if (var5.w == var1) {
            var2.put(var4.getKey(), var5);
         }
      }

      return var2;
   }

   public void onAllRefsReleased() {
   }

   // $FF: synthetic method
   static void bv(XElement var0, GameEntity var1) {
      bp(var0, var1);
   }

   // $FF: synthetic method
   static void bf(XElement var0, GameEntity var1, Vector3 var2) {
      bx(var0, var1, var2);
   }

   // $FF: synthetic method
   static Serializable bn(XElement var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static Logger bg() {
      return logger;
   }

   public static Set f(XElement[] var0) {
      HashSet var1 = new HashSet();
      c(var0, var1);
      return var1;
   }

   public void o(Set var1, Map var2) {
      HashMap var3 = new HashMap();
      a(this, var1, var3, var2);
      var1.addAll(var3.values());
   }

   public static Serializable ai(XElement[] var0) {
      XElement[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         XElement var4 = var1[var3];
         Serializable var5 = ag(var4);
         if (var5 != null) {
            return var5;
         }
      }

      return null;
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public static XElementLibrary getLibrary() {
      return ai;
   }

   public static Map af(XElement[] var0, Hi86 var1) {
      HashMap var2 = new HashMap();
      av(var0, var2, var1);
      return var2;
   }

   private void bh(ArrayList var1, Hi86 var2, ScriptManager var3, boolean var4) {
      if (var3 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         ep((Ap73)null, var1, this, var2, var3, var4);
         if (this.b != null) {
            this.b.bh(var1, var2, var3, var4);
         }

      }
   }

   public XElement(D80 var1) {
      super(var1);
   }

   public void k(Serializable var1) {
      if (this.z == null) {
         this.z = new ArrayList();
      }

      this.z.add(var1);
   }

   private static void a(XElement var0, Set var1, Map var2, Map var3) {
      Iterator var4;
      Entry var5;
      if (var0.m != null) {
         var4 = var0.m.entrySet().iterator();

         while(var4.hasNext()) {
            var5 = (Entry)var4.next();
            if (!var3.containsKey(var5.getKey())) {
               var3.put(var5.getKey(), var5.getValue());
            }
         }
      }

      if (var0.z != null && !var0.z.isEmpty()) {
         var1.addAll(var0.z);
      }

      if (var0.t != null && !var0.t.isEmpty()) {
         var4 = var0.t.entrySet().iterator();

         while(var4.hasNext()) {
            var5 = (Entry)var4.next();
            Integer var6 = (Integer)var5.getKey();
            if (!var2.containsKey(var6) && Boolean.TRUE.equals(var3.get(var6))) {
               var2.put(var6, var5.getValue());
            }
         }
      }

      if (var0.b != null) {
         a(var0.b, var1, var2, var3);
      }

   }

   public static float[] u(XElement var0, Integer var1) {
      float[] var2 = var0.o != null ? (float[])var0.o.get(var1) : null;
      return var2 == null && var0.b != null ? u(var0.b, var1) : var2;
   }

   private static void bp(XElement var0, GameEntity var1) {
      if (var0.b != null) {
         bp(var0.b, var1);
      }

      if (var0.l != null) {
         Iterator var2 = var0.l.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            Bm108 var4 = (Bm108)var3.getValue();
            var1.setProperty((String)var3.getKey(), Ki358.g(var4.r));
         }
      }

   }
}
