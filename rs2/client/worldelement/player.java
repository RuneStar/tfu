package rs2.client.worldelement;

import com.jagex.core.constants.D123;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsHub;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTransmission;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerType;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.ScriptEventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.E41;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import java.util.HashMap;
import java.util.Map;
import rs2.client.N272;
import rs2.client.client;
import rs2.client.inventory.ClientInventory;
import rs2.client.inventory.G451;
import rs2.client.lua.Q290;
import rs2.shared.movement.B348;
import rs2.shared.movement.G381;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.R378;
import tfu.At476;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.El328;
import tfu.Eu326;
import tfu.Gc330;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Jy122;
import tfu.Ku323;

@ScriptEntryClass
public class player extends L51 implements Q290 {
   private static Map bo = null;
   private static Map bq = new HashMap();
   public LossyStateStream a;
   public int aa;
   public boolean ab;
   public int ac;
   public boolean ad;
   public boolean ae;
   public String af;
   public LossyStateStream ag;
   public int ah;
   public String ai;
   public int aj;
   public int ak;
   public String al;
   public boolean am;
   public int an;
   public int ao;
   public int ap;
   public String aq;
   public int ar;
   public int as;
   public int at;
   public boolean au;
   public byte av;
   public int aw;
   public int ax;
   public boolean ay;
   public int az;
   public LuaEventHandler bd;
   private boolean bm;
   public LossyStateStream c;
   public LossyStateStream f;
   public final RotTrans i;
   public int k = -1;
   public int m;
   protected int n = -1;
   public final RotTrans o;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void BroadcastableState(BroadcastStateAndEventsTypes$StateDefinition var1, byte[] var2) {
      if (var1.getAutoForwarding()) {
         N272 var3 = client.i();
         El328 var4 = El328.d(Eu326.GENERIC_BROADCAST_STATE, var3.s);
         Gs329.i(var4.q, 0);
         int var5 = var4.q.v;
         BroadcastStateAndEventsTransmission.PackStateMessage(var4.q, var1, new BroadcastStateAndEventsTypes$StatePayload(var2, super.bg));
         Gs329.as(var4.q, var4.q.v - var5);
         N272.e(var3, var4);
      }

   }

   public void ce(String var1, EventHandler var2) {
      if (var1.equals("*")) {
         this.bd.addEventHandler("*", var2);
         this.bm = true;
      } else {
         int var3 = StringTools.l(var1);
         VarType var4 = client.fd.hashLookup(var3);
         if (var4 == null) {
            var4 = client.fo.hashLookup(var3);
         }

         if (var4 == null) {
            VarBitType var5 = client.fl.hashLookup(var3);
            if (var5 == null) {
               VarPlayerType var6 = client.fd.list(0);
               if (var6 != null && var6.debugNameHash32 == 0) {
                  throw new RuntimeException("Player variable domain has no hash lookup");
               }

               throw new RuntimeException("Player variable '" + var1 + "' not defined");
            }

            if (var5.baseVar.domain != VarDomainType.PLAYER) {
               throw new RuntimeException("'" + var1 + "' is not a player varbit, it's a " + var5.baseVar.domain.name());
            }

            if (var5.baseVar.debugNameHash32 == 0) {
               throw new RuntimeException("Player variable domain has no hash lookup");
            }

            ca(var1, var5);
            bq.put(var3, var1);
            this.bd.addEventHandler(var5.baseVar.debugNameHash32, var2);
         } else {
            if (var4.domain != VarDomainType.PLAYER && var4.domain != VarDomainType.CLIENT) {
               throw new RuntimeException("'" + var1 + "' is not a player variable, it's a " + var4.domain.name());
            }

            bq.put(var3, var1);
            this.bd.addEventHandler(var3, var2);
         }
      }

   }

   public static void bs(player var0) {
      if (var0.c != null) {
         if (!client.dq.streamAdded(var0.c)) {
            client.dq.addSlaveStream(var0.c);
            client.dq.addSlaveStream(var0.ag);
            client.dq.addSlaveStream(var0.a);
            if (var0.f instanceof SourceLossyStateStream) {
               client.dq.addMasterStream(var0.f);
            } else {
               client.dq.addSlaveStream(var0.f);
            }
         }

      }
   }

   public static String bt(player var0, boolean var1) {
      return var1 ? var0.aq : var0.ai;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVarBit(int var1) {
      VarBitType var2 = client.fl.list(var1);
      if (var2 != null) {
         if (var2.baseVar.domain != VarDomainType.PLAYER) {
            throw new RuntimeException("'" + var1 + "' is not a player varbit, it's a " + var2.baseVar.domain.name());
         } else {
            return this == Gc330.j() ? client.jw.getVarBitValue(var2) : this.getVarBitValue(var2);
         }
      } else {
         throw new RuntimeException("Player varbit '" + var1 + "' not defined");
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String GetName() {
      return this.aq == null ? "" : this.aq;
   }

   public static void cw(player var0) {
      if (var0.c != null) {
         client.dq.removeStream(var0.c);
      }

      if (var0.ag != null) {
         client.dq.removeStream(var0.ag);
      }

      if (var0.a != null) {
         client.dq.removeStream(var0.a);
      }

      if (var0.f != null) {
         client.dq.removeStream(var0.f);
      }

      var0.setProperty("__clientControlStream", (Object)null);
      var0.setProperty("__serverControlStream", (Object)null);
      var0.c = null;
      var0.ag = null;
      var0.a = null;
      var0.f = null;
   }

   public String bi(boolean var1) {
      String var2 = "";
      if (this.al != null) {
         var2 = this.al;
      }

      if (var1) {
         var2 = var2 + this.aq;
      } else {
         var2 = var2 + this.ai;
      }

      if (this.af != null) {
         var2 = var2 + this.af;
      }

      return var2;
   }

   public static void cp(player var0, Q7 var1, boolean var2) {
      PlayerPhysicsComponent var3 = (PlayerPhysicsComponent)eb(var0, PlayerPhysicsComponent.class);
      PlayerPhysicsComponent.d(var3, var1, var2, true);
   }

   public void cx(BroadcastStateAndEventsTypes$GonePayload var1) {
      if (BroadcastStateAndEventsHub.debug) {
         Jy122.b(BroadcastStateAndEventsHub.tree, "PLAYER <- 'gone' RECEIVED!  Player=" + this + ", broadcaster=" + var1.broadcasterID + ", wranglerID=" + var1.wranglerID);
      }

      this.eh("__onReceiveGone", new Object[]{var1.broadcasterID.toString(), var1.wranglerID, var1.areaID});
   }

   public void cq(Gg3 var1) {
      Quaternion var2 = Quaternion.d(var1);
      Vector3 var3 = Vector3.d(var1);
      RotTrans var4 = new RotTrans(var2, var3);
      cp(this, Q7.g(var4), true);
      var4 = var4.v((float)client.gn, 0.0F, (float)client.gj);
      this.setWorldTransform(var4);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVar(String var1) {
      int var2 = StringTools.l(var1);
      VarType var3 = client.fd.hashLookup(var2);
      if (var3 != null) {
         return this.ck(var1, var3);
      } else {
         VarBitType var4 = client.fl.hashLookup(var2);
         if (var4 != null) {
            if (var4.baseVar.domain != VarDomainType.PLAYER) {
               throw new RuntimeException("'" + var1 + "' is not a player varbit, it's a " + var4.baseVar.domain.name());
            } else {
               return this == Gc330.j() ? client.jw.getVarBitValue(var4) : this.getVarBitValue(var4);
            }
         } else {
            throw new RuntimeException("Player variable '" + var1 + "' not defined");
         }
      }
   }

   public player(Bb4 var1) {
      super(var1, client.fd);
      this.i = RotTrans.g;
      this.o = RotTrans.g;
      this.av = 0;
      this.az = -1;
      this.ah = -1;
      this.ap = 0;
      this.ao = 0;
      this.aa = -1;
      this.an = 0;
      this.am = false;
      this.ac = -1;
      this.at = -1;
      this.ab = false;
      this.aw = 0;
      this.ar = 0;
      this.ax = 255;
      this.au = false;
      this.ay = false;
      this.ad = false;
      this.ae = false;
      this.bd = new LuaEventHandler();
      this.bm = false;
      XElement.j = var1;
      this.addEventHandler("__PHYSICSFLUSH", new S34(this));
      ep(this, new PlayerComponent(this));
   }

   public String toString() {
      String var1 = super.toString();
      int var2 = var1.lastIndexOf(64);
      if (var2 != -1) {
         var1 = var1.substring(var1.lastIndexOf(64));
      }

      return this.aq + " " + var1;
   }

   public int bz() {
      return super.bz();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVarByIndex(int var1) {
      VarPlayerType var2 = client.fd.list(var1);
      if (var2 != null) {
         return this.ck(var1, var2);
      } else {
         throw new RuntimeException("Player variable '" + var1 + "' not defined");
      }
   }

   private Object ck(Object var1, VarType var2) {
      // $FF: Couldn't be decompiled
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVarBit(int var1, Object var2) throws VarBitOverflowException {
      VarBitType var3 = client.fl.list(var1);
      if (var3 != null) {
         if (var3.baseVar.domain != VarDomainType.PLAYER) {
            throw new RuntimeException("'" + var1 + "' is not a player varbit, it's a " + var3.baseVar.domain.name());
         } else if (!(var2 instanceof Double)) {
            throw new RuntimeException("Passed non-number type as value to SetVarBit when setting player client variable with index: '" + var1 + "'.");
         } else {
            if (this == Gc330.j()) {
               client.jw.setVarBitValue(var3, ((Number)var2).intValue());
            } else {
               this.setVarBitValue(var3, ((Number)var2).intValue());
            }

         }
      } else {
         throw new RuntimeException("Player varbit '" + var1 + "' not defined");
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVar(String var1, Object var2) throws VarBitOverflowException {
      int var3 = StringTools.l(var1);
      VarType var4 = client.fd.hashLookup(var3);
      if (var4 != null) {
         this.cd(var1, var4, var2);
      } else {
         VarBitType var5 = client.fl.hashLookup(var3);
         if (var5 != null) {
            if (var5.baseVar.domain != VarDomainType.PLAYER) {
               throw new RuntimeException("'" + var1 + "' is not a player varbit, it's a " + var5.baseVar.domain.name());
            } else if (!(var2 instanceof Number)) {
               throw new RuntimeException("Passed non-number type as value to SetVar when setting player client varbit: '" + var1 + "'.");
            } else {
               if (this == Gc330.j()) {
                  client.jw.setVarBitValue(var5, ((Number)var2).intValue());
               } else {
                  this.setVarBitValue(var5, ((Number)var2).intValue());
               }

            }
         } else {
            throw new RuntimeException("Player variable '" + var1 + "' not defined");
         }
      }
   }

   public E41 bc() {
      E41 var1 = PlayerPhysicsComponent.b((PlayerPhysicsComponent)eb(this, PlayerPhysicsComponent.class));
      if (var1 != null) {
         return var1;
      } else {
         Vector3 var2 = this.getWorldTransform().trans;
         return new E41(var2.x, var2.y, var2.z, var2.x, var2.y, var2.z);
      }
   }

   public void be(int var1, boolean var2) {
      ep(this, new PlayerPhysicsComponent(client.dc, client.cj, var1 == Gc330.d()));
      this.c = new LossyStateStream(new B348(), var1 | 67108864, "PlayerDynamicState_" + var1);
      this.ag = new LossyStateStream(new G381(), var1 | 100663296, "PlayerDynamicStateContents_" + var1);
      this.a = new LossyStateStream(new R378(), var1 | 16777216, "PlayerServerSideControl_" + var1);
      if (var2) {
         this.f = new SourceLossyStateStream(new R378(), var1 | 33554432, "PlayerClientSideControl_" + var1);
         this.setProperty("__clientControlStreamMaster", true);
      } else {
         this.f = new LossyStateStream(new R378(), var1 | 33554432, "PlayerClientSideControl_" + var1);
         this.setProperty("__clientControlStreamMaster", false);
      }

      this.setProperty("__clientControlStream", this.f);
      this.setProperty("__serverControlStream", this.a);
      ep(this, new PhysicsComponent(new E39(this), (RigidBody)null, (RigidBody)null));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void onVarTransmitCancel(String var1, EventHandler var2) {
      if (var1.equals("*")) {
         this.bd.removeEventHandler(var1, var2);
         this.bm = this.bd.hasEvent(var1);
      } else {
         int var3 = StringTools.l(var1);
         this.bd.removeEventHandler(var3, var2);
      }

   }

   public static void cv(player var0, int var1, Object var2) {
      VarPlayerType var3 = client.fd.list(var1);
      cl(var0, var3.id, var3.debugNameHash32, var2);
   }

   public static void cj(player var0, VarType var1, Object var2) {
      cl(var0, var1.id, var1.debugNameHash32, var2);
   }

   private static void cl(player var0, int var1, int var2, Object var3) {
      boolean var4 = var3 == null;
      if (var2 != 0) {
         if (bq != null) {
            String var5 = (String)bq.get(var2);
            if (var5 != null) {
               if (var4) {
                  var0.bd.triggerEvent(var0, (Integer)var2, var5);
                  if (var0.bm) {
                     var0.bd.triggerEvent(var0, (String)"*", var5);
                  }
               } else {
                  Object[] var6 = new Object[]{var5, var3};
                  var0.bd.triggerEvent(var0, (Integer)var2, var6);
                  if (var0.bm) {
                     var0.bd.triggerEvent(var0, (String)"*", var6);
                  }
               }
            }
         }
      } else if (var4) {
         var0.bd.triggerEvent(var0, (Integer)var1, var1);
         if (var0.bm) {
            var0.bd.triggerEvent(var0, (String)"*", var1);
         }
      } else {
         Object[] var7 = new Object[]{var1, var3};
         var0.bd.triggerEvent(var0, (Integer)var1, var7);
         if (var0.bm) {
            var0.bd.triggerEvent(var0, (String)"*", var7);
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void AddInventoryHashType(int var1, int var2) {
      if (bo == null) {
         bo = new HashMap();
      }

      bo.put(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public ClientInventory GetInventory(String var1) {
      if (bo != null && this == Gc330.j()) {
         int var2 = StringTools.l(var1.toLowerCase());
         if (bo.containsKey(var2)) {
            int var3 = (Integer)bo.get(var2);
            return G451.g(var3, false);
         }
      }

      return null;
   }

   public boolean br(String var1) {
      int var2 = StringTools.l(var1);
      VarType var3 = client.fd.hashLookup(var2);
      if (var3 == null) {
         VarBitType var4 = client.fl.hashLookup(var2);
         if (var4 == null) {
            return false;
         }

         var3 = var4.baseVar;
      }

      return var3.domain == VarDomainType.PLAYER;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void BroadcastableEvent(BroadcastStateAndEventsTypes$EventDefinition var1, byte[] var2) {
      if (var1.getAutoForwarding()) {
         N272 var3 = client.i();
         El328 var4 = El328.d(Eu326.GENERIC_BROADCAST_EVENT, var3.s);
         Gs329.i(var4.q, 0);
         int var5 = var4.q.v;
         BroadcastStateAndEventsTransmission.PackEventMessage(var4.q, var1, new BroadcastStateAndEventsTypes$EventPayload(var2, super.bg));
         Gs329.as(var4.q, var4.q.v - var5);
         N272.e(var3, var4);
      }

   }

   private static void ca(String var0, VarBitType var1) {
      String var2;
      if (bq.containsKey(var1.baseVar.debugNameHash32)) {
         var2 = (String)bq.get(var1.baseVar.debugNameHash32);
         if (var2.startsWith("[varbit:")) {
            String[] var3 = StringTools.y(var2.replace("]", ""), ':');
            String[] var4 = StringTools.y(var3[1], ',');
            boolean var5 = false;

            for(int var6 = 0; var6 < var4.length; ++var6) {
               if (var4[var6].equals(var0)) {
                  var5 = true;
                  break;
               }
            }

            String var8 = var3[1];
            if (!var5) {
               var8 = var8 + "," + var0;
            }

            String var7 = String.format("[varbit:%s]", var8);
            bq.put(var1.baseVar.debugNameHash32, var7);
         }
      } else {
         var2 = String.format("[varbit:%s]", var0);
         bq.put(var1.baseVar.debugNameHash32, var2);
      }

   }

   public void cm(String var1, BroadcastStateAndEventsTypes$EventPayload var2) {
      if (BroadcastStateAndEventsHub.debug) {
         Jy122.b(BroadcastStateAndEventsHub.tree, "EVENT RECEIVED AT PLAYER OBJ!  Player=" + this + ", messageName=" + var1 + ", wranglerID=" + var2.wranglerID + ", payload=" + var2);
      }

      this.eh(var1, new Object[]{var2.wire_data, GameEntity.es(var2.broadcasterID), var2.wranglerID, var2.areaID});
      this.eh("__onReceiveEvent", new Object[]{var1, var2.wire_data, var2.broadcasterID.toString(), var2.wranglerID, var2.areaID});
   }

   public void cc(BroadcastStateAndEventsTypes$AppearedPayload var1) {
      if (BroadcastStateAndEventsHub.debug) {
         Jy122.b(BroadcastStateAndEventsHub.tree, "PLAYER <- 'appeared' RECEIVED!  Player=" + this + ", broadcaster=" + var1.broadcasterID + ", wranglerID=" + var1.wranglerID);
      }

      this.eh("__onReceiveAppeared", new Object[]{var1.broadcasterID.toString(), var1.wranglerID, var1.areaID});
   }

   public static void cy(player var0) {
      PlayerPhysicsComponent.w((PlayerPhysicsComponent)eb(var0, PlayerPhysicsComponent.class));
   }

   public static void co(player var0) {
      PlayerPhysicsComponent.l((PlayerPhysicsComponent)eb(var0, PlayerPhysicsComponent.class));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public EventHandler onVarTransmit(String var1, LuaFunctionRef var2) {
      ScriptEventHandler var3 = new ScriptEventHandler(client.cj, var2, (Object[])null);
      this.ce(var1, var3);
      return var3;
   }

   public final void bn(Gg3 var1) {
      var1.v = 0;
      int var2 = Gg3.ar(var1);
      this.av = (byte)(var2 & 1);
      boolean var3 = this.ab;
      this.ab = (var2 & 2) != 0;
      boolean var4 = (var2 & 4) != 0;
      int var5 = super.bz();
      ez(this, (var2 >> 3 & 7) + 1);
      boolean var6 = (var2 & 64) != 0;
      boolean var7 = (var2 & 128) != 0;
      Vector3 var8 = this.getWorldTransform().trans;
      var8 = Vector3.m(var8, (float)(this.bz() - var5 << 1), 0.0F, (float)(this.bz() - var5 << 1));
      w(this, var8);
      if (var6) {
         this.al = var1.bh();
      } else {
         this.al = null;
      }

      if (var7) {
         this.af = var1.bh();
      } else {
         this.af = null;
      }

      this.az = Gg3.ax(var1);
      this.ah = Gg3.ax(var1);
      this.ad = Gg3.ax(var1) == 1;
      if (client.t == D123.LIVE && client.ik >= 2) {
         this.ad = false;
      }

      this.aq = Gg3.bk(var1);
      super.bb = "Player=" + this.aq;
      this.ai = this.aq;
      if (this == Gc330.j()) {
         Ku323.j = this.aq;
      }

      this.ap = Gg3.ar(var1);
      if (var4) {
         this.an = Gg3.au(var1);
         if (this.an == 65535) {
            this.an = -1;
         }

         this.ao = this.ap;
         this.aa = -1;
      } else {
         this.an = 0;
         this.ao = Gg3.ar(var1);
         this.aa = Gg3.ar(var1);
         if (this.aa == 255) {
            this.aa = -1;
         }
      }

      int var9 = this.aw;
      this.aw = Gg3.ar(var1);
      int var10;
      if (this.aw != 0) {
         var10 = this.ac;
         int var11 = this.at;
         int var12 = this.ax;
         int var13 = this.ar;
         this.ac = Gg3.au(var1);
         this.at = Gg3.au(var1);
         this.ax = Gg3.ar(var1);
         this.ar = Gg3.ar(var1);
         if (var3 != this.ab || var9 != this.aw || var10 != this.ac || var11 != this.at || var12 != this.ax || var13 != this.ar) {
            At476.e(this);
         }
      } else {
         At476.j(this);
      }

      var10 = Gg3.au(var1);
      if (var10 == 65535) {
         boolean var14 = true;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVarByIndex(int var1, Object var2) {
      VarPlayerType var3 = client.fd.list(var1);
      if (var3 != null) {
         this.cd(var1, var3, var2);
      } else {
         throw new RuntimeException("Player variable '" + var1 + "' not defined");
      }
   }

   public void cb(String var1, BroadcastStateAndEventsTypes$StatePayload var2) {
      if (BroadcastStateAndEventsHub.debug) {
         Jy122.b(BroadcastStateAndEventsHub.tree, "STATE UPDATE RECEIVED AT PLAYER OBJ!  Player=" + this + ", messageName=" + var1 + ", wranglerID=" + var2.wranglerID + ", payload=" + var2);
      }

      this.eh(var1, new Object[]{var2.wire_data, GameEntity.es(var2.broadcasterID), var2.wranglerID, var2.areaID});
      this.eh("__onReceiveState", new Object[]{var1, var2.wire_data, var2.broadcasterID.toString(), var2.wranglerID, var2.areaID});
   }

   private void cd(Object var1, VarType var2, Object var3) {
      // $FF: Couldn't be decompiled
   }
}
