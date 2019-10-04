// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import tfu.Kg142;
import tfu.At476;
import tfu.Ku323;
import com.jagex.core.constants.D123;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.event.ScriptEventHandler;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import rs2.client.inventory.G451;
import rs2.client.inventory.ClientInventory;
import java.util.HashMap;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import rs2.shared.movement.Q40;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.R378;
import rs2.shared.movement.G381;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import rs2.shared.movement.B348;
import com.jagex.maths.E41;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import tfu.Bb4;
import com.jagex.maths.Vector3;
import com.jagex.maths.Quaternion;
import tfu.Jy122;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsHub;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.gameentity.GameEntity;
import rs2.shared.movement.PlayerPhysicsComponent;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import tfu.Gc330;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import rs2.client.N272;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTransmission;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import tfu.Gg3;
import tfu.El328;
import tfu.Eu326;
import rs2.client.client;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.maths.RotTrans;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import java.util.Map;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import rs2.client.lua.Q290;

@ScriptEntryClass
public class player extends L51 implements Q290
{
    private static Map bo;
    private static Map bq;
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
    public int k;
    public int m;
    protected int n;
    public final RotTrans o;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void BroadcastableState(final BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition, final byte[] array) {
        if (broadcastStateAndEventsTypes$StateDefinition.getAutoForwarding()) {
            final N272 i = client.i();
            final El328 d = El328.d(Eu326.GENERIC_BROADCAST_STATE, i.s);
            Gg3.i(d.q, 0);
            final int v = d.q.v;
            BroadcastStateAndEventsTransmission.PackStateMessage(d.q, broadcastStateAndEventsTypes$StateDefinition, new BroadcastStateAndEventsTypes$StatePayload(array, super.bg));
            Gg3.as(d.q, d.q.v - v);
            N272.e(i, d);
        }
    }
    
    public void ce(final String str, final EventHandler eventHandler) {
        if (str.equals("*")) {
            this.bd.addEventHandler("*", eventHandler);
            this.bm = true;
        }
        else {
            final int l = StringTools.l(str);
            VarType varType = client.fd.hashLookup(l);
            if (varType == null) {
                varType = client.fo.hashLookup(l);
            }
            if (varType == null) {
                final VarBitType hashLookup = client.fl.hashLookup(l);
                if (hashLookup != null) {
                    if (hashLookup.baseVar.domain != VarDomainType.PLAYER) {
                        throw new RuntimeException("'" + str + "' is not a player varbit, it's a " + hashLookup.baseVar.domain.name());
                    }
                    if (hashLookup.baseVar.debugNameHash32 == 0) {
                        throw new RuntimeException("Player variable domain has no hash lookup");
                    }
                    ca(str, hashLookup);
                    player.bq.put(l, str);
                    this.bd.addEventHandler(hashLookup.baseVar.debugNameHash32, eventHandler);
                }
                else {
                    final VarPlayerType list = client.fd.list(0);
                    if (list != null && list.debugNameHash32 == 0) {
                        throw new RuntimeException("Player variable domain has no hash lookup");
                    }
                    throw new RuntimeException("Player variable '" + str + "' not defined");
                }
            }
            else {
                if (varType.domain != VarDomainType.PLAYER && varType.domain != VarDomainType.CLIENT) {
                    throw new RuntimeException("'" + str + "' is not a player variable, it's a " + varType.domain.name());
                }
                player.bq.put(l, str);
                this.bd.addEventHandler(l, eventHandler);
            }
        }
    }
    
    public static void bs(final player player) {
        if (player.c == null) {
            return;
        }
        if (!client.dq.streamAdded(player.c)) {
            client.dq.addSlaveStream(player.c);
            client.dq.addSlaveStream(player.ag);
            client.dq.addSlaveStream(player.a);
            if (player.f instanceof SourceLossyStateStream) {
                client.dq.addMasterStream(player.f);
            }
            else {
                client.dq.addSlaveStream(player.f);
            }
        }
    }
    
    public static String bt(final player player, final boolean b) {
        if (b) {
            return player.aq;
        }
        return player.ai;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarBit(final int n) {
        final VarBitType list = client.fl.list(n);
        if (list == null) {
            throw new RuntimeException("Player varbit '" + n + "' not defined");
        }
        if (list.baseVar.domain != VarDomainType.PLAYER) {
            throw new RuntimeException("'" + n + "' is not a player varbit, it's a " + list.baseVar.domain.name());
        }
        if (this == Gc330.j()) {
            return client.jw.getVarBitValue(list);
        }
        return this.getVarBitValue(list);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public String GetName() {
        return (this.aq == null) ? "" : this.aq;
    }
    
    public static void cw(final player player) {
        if (player.c != null) {
            client.dq.removeStream(player.c);
        }
        if (player.ag != null) {
            client.dq.removeStream(player.ag);
        }
        if (player.a != null) {
            client.dq.removeStream(player.a);
        }
        if (player.f != null) {
            client.dq.removeStream(player.f);
        }
        player.setProperty("__clientControlStream", null);
        player.setProperty("__serverControlStream", null);
        player.c = null;
        player.ag = null;
        player.a = null;
        player.f = null;
    }
    
    public String bi(final boolean b) {
        String al = "";
        if (this.al != null) {
            al = this.al;
        }
        String str;
        if (b) {
            str = al + this.aq;
        }
        else {
            str = al + this.ai;
        }
        if (this.af != null) {
            str += this.af;
        }
        return str;
    }
    
    public static void cp(final player player, final Q7 q7, final boolean b) {
        PlayerPhysicsComponent.d((PlayerPhysicsComponent)GameEntity.eb(player, PlayerPhysicsComponent.class), q7, b, true);
    }
    
    public void cx(final BroadcastStateAndEventsTypes$GonePayload broadcastStateAndEventsTypes$GonePayload) {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.b(BroadcastStateAndEventsHub.tree, "PLAYER <- 'gone' RECEIVED!  Player=" + this + ", broadcaster=" + broadcastStateAndEventsTypes$GonePayload.broadcasterID + ", wranglerID=" + broadcastStateAndEventsTypes$GonePayload.wranglerID);
        }
        this.eh("__onReceiveGone", new Object[] { broadcastStateAndEventsTypes$GonePayload.broadcasterID.toString(), broadcastStateAndEventsTypes$GonePayload.wranglerID, broadcastStateAndEventsTypes$GonePayload.areaID });
    }
    
    public void cq(final Gg3 gg3) {
        final RotTrans rotTrans = new RotTrans(Quaternion.d(gg3), Vector3.d(gg3));
        cp(this, Q7.g(rotTrans), true);
        this.setWorldTransform(rotTrans.v((float)client.gn, 0.0f, (float)client.gj));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public Object GetVar(final String s) {
        final int l = StringTools.l(s);
        final VarType hashLookup = client.fd.hashLookup(l);
        if (hashLookup != null) {
            return this.ck(s, hashLookup);
        }
        final VarBitType hashLookup2 = client.fl.hashLookup(l);
        if (hashLookup2 == null) {
            throw new RuntimeException("Player variable '" + s + "' not defined");
        }
        if (hashLookup2.baseVar.domain != VarDomainType.PLAYER) {
            throw new RuntimeException("'" + s + "' is not a player varbit, it's a " + hashLookup2.baseVar.domain.name());
        }
        if (this == Gc330.j()) {
            return client.jw.getVarBitValue(hashLookup2);
        }
        return this.getVarBitValue(hashLookup2);
    }
    
    public player(final Bb4 j) {
        super(j, client.fd);
        this.n = -1;
        this.k = -1;
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
        XElement.j = j;
        this.addEventHandler("__PHYSICSFLUSH", new S34(this));
        GameEntity.ep(this, new PlayerComponent(this));
    }
    
    @Override
    public String toString() {
        String str = super.toString();
        if (str.lastIndexOf(64) != -1) {
            str = str.substring(str.lastIndexOf(64));
        }
        return this.aq + " " + str;
    }
    
    @Override
    public int bz() {
        return super.bz();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarByIndex(final int n) {
        final VarPlayerType list = client.fd.list(n);
        if (list != null) {
            return this.ck(n, list);
        }
        throw new RuntimeException("Player variable '" + n + "' not defined");
    }
    
    private Object ck(final Object obj, final VarType varType) {
        if (varType.domain != VarDomainType.PLAYER) {
            throw new RuntimeException("'" + obj + "' is not a player variable, it's a " + varType.domain.name());
        }
        if (this == Gc330.j()) {
            switch (D43.g[varType.dataType.baseType.ordinal()]) {
                case 1: {
                    return client.jw.getVarValueInt(varType);
                }
                case 2: {
                    return client.jw.getVarValueLong(varType);
                }
                case 3: {
                    return client.jw.getVarValue(varType);
                }
                case 4: {
                    return client.jw.getVarValue(varType);
                }
                default: {
                    return client.jw.getVarValue(varType);
                }
            }
        }
        else {
            switch (D43.g[varType.dataType.baseType.ordinal()]) {
                case 1: {
                    return this.getVarValueInt(varType);
                }
                case 2: {
                    return this.getVarValueLong(varType);
                }
                case 3: {
                    return this.getVarValue(varType);
                }
                case 4: {
                    return this.getVarValue(varType);
                }
                default: {
                    return this.getVarValue(varType);
                }
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarBit(final int i, final Object o) throws VarBitOverflowException {
        final VarBitType list = client.fl.list(i);
        if (list == null) {
            throw new RuntimeException("Player varbit '" + i + "' not defined");
        }
        if (list.baseVar.domain != VarDomainType.PLAYER) {
            throw new RuntimeException("'" + i + "' is not a player varbit, it's a " + list.baseVar.domain.name());
        }
        if (!(o instanceof Double)) {
            throw new RuntimeException("Passed non-number type as value to SetVarBit when setting player client variable with index: '" + i + "'.");
        }
        if (this == Gc330.j()) {
            client.jw.setVarBitValue(list, ((Number)o).intValue());
        }
        else {
            this.setVarBitValue(list, ((Number)o).intValue());
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void SetVar(final String str, final Object o) throws VarBitOverflowException {
        final int l = StringTools.l(str);
        final VarType hashLookup = client.fd.hashLookup(l);
        if (hashLookup != null) {
            this.cd(str, hashLookup, o);
            return;
        }
        final VarBitType hashLookup2 = client.fl.hashLookup(l);
        if (hashLookup2 == null) {
            throw new RuntimeException("Player variable '" + str + "' not defined");
        }
        if (hashLookup2.baseVar.domain != VarDomainType.PLAYER) {
            throw new RuntimeException("'" + str + "' is not a player varbit, it's a " + hashLookup2.baseVar.domain.name());
        }
        if (!(o instanceof Number)) {
            throw new RuntimeException("Passed non-number type as value to SetVar when setting player client varbit: '" + str + "'.");
        }
        if (this == Gc330.j()) {
            client.jw.setVarBitValue(hashLookup2, ((Number)o).intValue());
        }
        else {
            this.setVarBitValue(hashLookup2, ((Number)o).intValue());
        }
    }
    
    @Override
    public E41 bc() {
        final E41 b = PlayerPhysicsComponent.b((PlayerPhysicsComponent)GameEntity.eb(this, PlayerPhysicsComponent.class));
        if (b != null) {
            return b;
        }
        final Vector3 trans = this.getWorldTransform().trans;
        return new E41(trans.x, trans.y, trans.z, trans.x, trans.y, trans.z);
    }
    
    public void be(final int i, final boolean b) {
        GameEntity.ep(this, new PlayerPhysicsComponent(client.dc, client.cj, i == Gc330.d()));
        this.c = new LossyStateStream(new B348(), i | 0x4000000, "PlayerDynamicState_" + i);
        this.ag = new LossyStateStream(new G381(), i | 0x6000000, "PlayerDynamicStateContents_" + i);
        this.a = new LossyStateStream(new R378(), i | 0x1000000, "PlayerServerSideControl_" + i);
        if (b) {
            this.f = new SourceLossyStateStream(new R378(), i | 0x2000000, "PlayerClientSideControl_" + i);
            this.setProperty("__clientControlStreamMaster", true);
        }
        else {
            this.f = new LossyStateStream(new R378(), i | 0x2000000, "PlayerClientSideControl_" + i);
            this.setProperty("__clientControlStreamMaster", false);
        }
        this.setProperty("__clientControlStream", this.f);
        this.setProperty("__serverControlStream", this.a);
        GameEntity.ep(this, new PhysicsComponent(new E39(this), null, null));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void onVarTransmitCancel(final String s, final EventHandler eventHandler) {
        if (s.equals("*")) {
            this.bd.removeEventHandler(s, eventHandler);
            this.bm = this.bd.hasEvent(s);
        }
        else {
            this.bd.removeEventHandler(StringTools.l(s), eventHandler);
        }
    }
    
    public static void cv(final player player, final int n, final Object o) {
        final VarPlayerType list = client.fd.list(n);
        cl(player, list.id, list.debugNameHash32, o);
    }
    
    public static void cj(final player player, final VarType varType, final Object o) {
        cl(player, varType.id, varType.debugNameHash32, o);
    }
    
    private static void cl(final player player, final int i, final int j, final Object o) {
        final boolean b = o == null;
        if (j != 0) {
            if (player.bq != null) {
                final String s = player.bq.get(j);
                if (s != null) {
                    if (b) {
                        player.bd.triggerEvent(player, j, s);
                        if (player.bm) {
                            player.bd.triggerEvent(player, "*", s);
                        }
                    }
                    else {
                        final Object[] array = { s, o };
                        player.bd.triggerEvent(player, j, array);
                        if (player.bm) {
                            player.bd.triggerEvent(player, "*", array);
                        }
                    }
                }
            }
        }
        else if (b) {
            player.bd.triggerEvent(player, i, i);
            if (player.bm) {
                player.bd.triggerEvent(player, "*", i);
            }
        }
        else {
            final Object[] array2 = { i, o };
            player.bd.triggerEvent(player, i, array2);
            if (player.bm) {
                player.bd.triggerEvent(player, "*", array2);
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddInventoryHashType(final int i, final int j) {
        if (player.bo == null) {
            player.bo = new HashMap();
        }
        player.bo.put(i, j);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public ClientInventory GetInventory(final String s) {
        if (player.bo != null && this == Gc330.j()) {
            final int l = StringTools.l(s.toLowerCase());
            if (player.bo.containsKey(l)) {
                return G451.g((int)player.bo.get(l), false);
            }
        }
        return null;
    }
    
    @Override
    public boolean br(final String s) {
        final int l = StringTools.l(s);
        VarType varType = client.fd.hashLookup(l);
        if (varType == null) {
            final VarBitType hashLookup = client.fl.hashLookup(l);
            if (hashLookup == null) {
                return false;
            }
            varType = hashLookup.baseVar;
        }
        return varType.domain == VarDomainType.PLAYER;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void BroadcastableEvent(final BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition, final byte[] array) {
        if (broadcastStateAndEventsTypes$EventDefinition.getAutoForwarding()) {
            final N272 i = client.i();
            final El328 d = El328.d(Eu326.GENERIC_BROADCAST_EVENT, i.s);
            Gg3.i(d.q, 0);
            final int v = d.q.v;
            BroadcastStateAndEventsTransmission.PackEventMessage(d.q, broadcastStateAndEventsTypes$EventDefinition, new BroadcastStateAndEventsTypes$EventPayload(array, super.bg));
            Gg3.as(d.q, d.q.v - v);
            N272.e(i, d);
        }
    }
    
    private static void ca(final String s, final VarBitType varBitType) {
        if (player.bq.containsKey(varBitType.baseVar.debugNameHash32)) {
            final String s2 = player.bq.get(varBitType.baseVar.debugNameHash32);
            if (s2.startsWith("[varbit:")) {
                final String[] y = StringTools.y(s2.replace("]", ""), ':');
                final String[] y2 = StringTools.y(y[1], ',');
                boolean b = false;
                for (int i = 0; i < y2.length; ++i) {
                    if (y2[i].equals(s)) {
                        b = true;
                        break;
                    }
                }
                String string = y[1];
                if (!b) {
                    string = string + "," + s;
                }
                player.bq.put(varBitType.baseVar.debugNameHash32, String.format("[varbit:%s]", string));
            }
        }
        else {
            player.bq.put(varBitType.baseVar.debugNameHash32, String.format("[varbit:%s]", s));
        }
    }
    
    public void cm(final String str, final BroadcastStateAndEventsTypes$EventPayload obj) {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.b(BroadcastStateAndEventsHub.tree, "EVENT RECEIVED AT PLAYER OBJ!  Player=" + this + ", messageName=" + str + ", wranglerID=" + obj.wranglerID + ", payload=" + obj);
        }
        this.eh(str, new Object[] { obj.wire_data, GameEntity.es(obj.broadcasterID), obj.wranglerID, obj.areaID });
        this.eh("__onReceiveEvent", new Object[] { str, obj.wire_data, obj.broadcasterID.toString(), obj.wranglerID, obj.areaID });
    }
    
    public void cc(final BroadcastStateAndEventsTypes$AppearedPayload broadcastStateAndEventsTypes$AppearedPayload) {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.b(BroadcastStateAndEventsHub.tree, "PLAYER <- 'appeared' RECEIVED!  Player=" + this + ", broadcaster=" + broadcastStateAndEventsTypes$AppearedPayload.broadcasterID + ", wranglerID=" + broadcastStateAndEventsTypes$AppearedPayload.wranglerID);
        }
        this.eh("__onReceiveAppeared", new Object[] { broadcastStateAndEventsTypes$AppearedPayload.broadcasterID.toString(), broadcastStateAndEventsTypes$AppearedPayload.wranglerID, broadcastStateAndEventsTypes$AppearedPayload.areaID });
    }
    
    public static void cy(final player player) {
        PlayerPhysicsComponent.w((PlayerPhysicsComponent)GameEntity.eb(player, PlayerPhysicsComponent.class));
    }
    
    public static void co(final player player) {
        PlayerPhysicsComponent.l((PlayerPhysicsComponent)GameEntity.eb(player, PlayerPhysicsComponent.class));
    }
    
    static {
        player.bq = new HashMap();
        player.bo = null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler onVarTransmit(final String s, final LuaFunctionRef luaFunctionRef) {
        final ScriptEventHandler scriptEventHandler = new ScriptEventHandler(client.cj, luaFunctionRef, null);
        this.ce(s, scriptEventHandler);
        return scriptEventHandler;
    }
    
    public final void bn(final Gg3 gg3) {
        gg3.v = 0;
        final int ar = Gg3.ar(gg3);
        this.av = (byte)(ar & 0x1);
        final boolean ab = this.ab;
        this.ab = ((ar & 0x2) != 0x0);
        final boolean b = (ar & 0x4) != 0x0;
        final int bz = super.bz();
        L51.ez(this, (ar >> 3 & 0x7) + 1);
        final boolean b2 = (ar & 0x40) != 0x0;
        final boolean b3 = (ar & 0x80) != 0x0;
        SceneGraphNode.w(this, Vector3.m(this.getWorldTransform().trans, (float)(this.bz() - bz << 1), 0.0f, (float)(this.bz() - bz << 1)));
        if (b2) {
            this.al = gg3.bh();
        }
        else {
            this.al = null;
        }
        if (b3) {
            this.af = gg3.bh();
        }
        else {
            this.af = null;
        }
        this.az = Gg3.ax(gg3);
        this.ah = Gg3.ax(gg3);
        this.ad = (Gg3.ax(gg3) == 1);
        if (client.t == D123.LIVE && client.ik >= 2) {
            this.ad = false;
        }
        this.aq = Gg3.bk(gg3);
        super.bb = "Player=" + this.aq;
        this.ai = this.aq;
        if (this == Gc330.j()) {
            Ku323.j = this.aq;
        }
        this.ap = Gg3.ar(gg3);
        if (b) {
            this.an = Gg3.au(gg3);
            if (this.an == 65535) {
                this.an = -1;
            }
            this.ao = this.ap;
            this.aa = -1;
        }
        else {
            this.an = 0;
            this.ao = Gg3.ar(gg3);
            this.aa = Gg3.ar(gg3);
            if (this.aa == 255) {
                this.aa = -1;
            }
        }
        final int aw = this.aw;
        this.aw = Gg3.ar(gg3);
        if (this.aw != 0) {
            final int ac = this.ac;
            final int at = this.at;
            final int ax = this.ax;
            final int ar2 = this.ar;
            this.ac = Gg3.au(gg3);
            this.at = Gg3.au(gg3);
            this.ax = Gg3.ar(gg3);
            this.ar = Gg3.ar(gg3);
            if (ab != this.ab || aw != this.aw || ac != this.ac || at != this.at || ax != this.ax || ar2 != this.ar) {
                At476.e(this);
            }
        }
        else {
            At476.j(this);
        }
        if (Gg3.au(gg3) == 65535) {}
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarByIndex(final int n, final Object o) {
        final VarPlayerType list = client.fd.list(n);
        if (list != null) {
            this.cd(n, list, o);
            return;
        }
        throw new RuntimeException("Player variable '" + n + "' not defined");
    }
    
    public void cb(final String str, final BroadcastStateAndEventsTypes$StatePayload obj) {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.b(BroadcastStateAndEventsHub.tree, "STATE UPDATE RECEIVED AT PLAYER OBJ!  Player=" + this + ", messageName=" + str + ", wranglerID=" + obj.wranglerID + ", payload=" + obj);
        }
        this.eh(str, new Object[] { obj.wire_data, GameEntity.es(obj.broadcasterID), obj.wranglerID, obj.areaID });
        this.eh("__onReceiveState", new Object[] { str, obj.wire_data, obj.broadcasterID.toString(), obj.wranglerID, obj.areaID });
    }
    
    private void cd(final Object obj, final VarType varType, final Object o) {
        if (varType.domain != VarDomainType.PLAYER) {
            throw new RuntimeException("'" + obj + "' is not a player variable, it's a " + varType.domain.name());
        }
        if (this == Gc330.j()) {
            switch (D43.g[varType.dataType.baseType.ordinal()]) {
                case 1: {
                    if (!(o instanceof Number)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting player client variable: '" + obj + "'.");
                    }
                    client.jw.setVarValueInt(varType, ((Number)o).intValue());
                    break;
                }
                case 2: {
                    if (!(o instanceof Number)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting player client variable: '" + obj + "'.");
                    }
                    client.jw.setVarValueLong(varType, ((Number)o).longValue());
                    break;
                }
                case 3: {
                    if (!(o instanceof String)) {
                        throw new RuntimeException("Passed non-string type as value to SetVar when setting player client variable: '" + obj + "'.");
                    }
                    client.jw.setVarValue(varType, o);
                    break;
                }
                case 4: {
                    if (!(o instanceof Vector3) && !(o instanceof Kg142)) {
                        throw new RuntimeException("Passed non-Vector3 type as value to SetVar when setting player client variable: '" + obj + "'.");
                    }
                    if (o instanceof Vector3) {
                        client.jw.setVarValue(varType, new Kg142((Vector3)o));
                        break;
                    }
                    client.jw.setVarValue(varType, o);
                    break;
                }
                default: {
                    throw new RuntimeException("Passed unsupported type as value to SetVar when setting player client variable: '" + obj + "'.");
                }
            }
        }
        else {
            switch (D43.g[varType.dataType.baseType.ordinal()]) {
                case 1: {
                    if (!(o instanceof Number)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting player client variable: '" + obj + "'.");
                    }
                    this.setVarValueInt(varType, ((Number)o).intValue());
                    break;
                }
                case 2: {
                    if (!(o instanceof Number)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting player client variable: '" + obj + "'.");
                    }
                    this.setVarValueLong(varType, ((Number)o).longValue());
                    break;
                }
                case 3: {
                    if (!(o instanceof String)) {
                        throw new RuntimeException("Passed non-string type as value to SetVar when setting player client variable: '" + obj + "'.");
                    }
                    this.setVarValue(varType, o);
                    break;
                }
                case 4: {
                    if (!(o instanceof Vector3) && !(o instanceof Kg142)) {
                        throw new RuntimeException("Passed non-Vector3 type as value to SetVar when setting player client variable: '" + obj + "'.");
                    }
                    if (o instanceof Vector3) {
                        this.setVarValue(varType, new Kg142((Vector3)o));
                        break;
                    }
                    this.setVarValue(varType, o);
                    break;
                }
                default: {
                    throw new RuntimeException("Passed unsupported type as value to SetVar when setting player client variable: '" + obj + "'.");
                }
            }
        }
    }
}
