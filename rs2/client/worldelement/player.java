/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.worldelement;

import com.jagex.core.constants.D123;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsHub;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTransmission;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$DataMessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.constants.BaseVarType;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.ScriptEventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.E41;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.HashMap;
import java.util.Map;
import rs2.client.N272;
import rs2.client.client;
import rs2.client.inventory.ClientInventory;
import rs2.client.inventory.G451;
import rs2.client.lua.Q290;
import rs2.client.worldelement.E39;
import rs2.client.worldelement.L51;
import rs2.client.worldelement.PlayerComponent;
import rs2.client.worldelement.S34;
import rs2.shared.movement.B348;
import rs2.shared.movement.G381;
import rs2.shared.movement.I187;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.Q40;
import rs2.shared.movement.R378;
import tfu.At476;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.El328;
import tfu.Eu326;
import tfu.Fw152;
import tfu.Gc330;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Ic327;
import tfu.Jy122;
import tfu.Kg142;
import tfu.Ku323;

@ScriptEntryClass
public class player
extends L51
implements Q290 {
    private static Map bo;
    private static Map bq;
    public LossyStateStream a;
    public int aa = -1;
    public boolean ab = false;
    public int ac = -1;
    public boolean ad = false;
    public boolean ae = false;
    public String af;
    public LossyStateStream ag;
    public int ah = -1;
    public String ai;
    public int aj;
    public int ak;
    public String al;
    public boolean am = false;
    public int an = 0;
    public int ao = 0;
    public int ap = 0;
    public String aq;
    public int ar = 0;
    public int as;
    public int at = -1;
    public boolean au = false;
    public byte av = 0;
    public int aw = 0;
    public int ax = 255;
    public boolean ay = false;
    public int az = -1;
    public LuaEventHandler bd;
    private boolean bm = false;
    public LossyStateStream c;
    public LossyStateStream f;
    public final RotTrans i = RotTrans.g;
    public int k = -1;
    public int m;
    protected int n = -1;
    public final RotTrans o = RotTrans.g;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void BroadcastableState(BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition, byte[] arrby) {
        if (broadcastStateAndEventsTypes$StateDefinition.getAutoForwarding()) {
            N272 n272 = client.i();
            El328 el328 = El328.d(Eu326.GENERIC_BROADCAST_STATE, n272.s);
            Gs329.i(el328.q, 0);
            int n = el328.q.v;
            BroadcastStateAndEventsTransmission.PackStateMessage(el328.q, broadcastStateAndEventsTypes$StateDefinition, new BroadcastStateAndEventsTypes$StatePayload(arrby, this.bg));
            Gs329.as(el328.q, el328.q.v - n);
            N272.e(n272, el328);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void ce(String string, EventHandler eventHandler) {
        if (string.equals("*")) {
            this.bd.addEventHandler("*", eventHandler);
            this.bm = true;
            return;
        }
        int n = StringTools.l(string);
        VarType varType = client.fd.hashLookup(n);
        if (varType == null) {
            varType = client.fo.hashLookup(n);
        }
        if (varType == null) {
            VarBitType varBitType = client.fl.hashLookup(n);
            if (varBitType != null) {
                if (varBitType.baseVar.domain != VarDomainType.PLAYER) throw new RuntimeException("'" + string + "' is not a player varbit, it's a " + varBitType.baseVar.domain.name());
                if (varBitType.baseVar.debugNameHash32 == 0) throw new RuntimeException("Player variable domain has no hash lookup");
                player.ca(string, varBitType);
                bq.put(n, string);
                this.bd.addEventHandler(varBitType.baseVar.debugNameHash32, eventHandler);
                return;
            }
            varType = client.fd.list(0);
            if (varType == null) throw new RuntimeException("Player variable '" + string + "' not defined");
            if (varType.debugNameHash32 != 0) throw new RuntimeException("Player variable '" + string + "' not defined");
            throw new RuntimeException("Player variable domain has no hash lookup");
        }
        if (varType.domain != VarDomainType.PLAYER) {
            if (varType.domain != VarDomainType.CLIENT) throw new RuntimeException("'" + string + "' is not a player variable, it's a " + varType.domain.name());
        }
        bq.put(n, string);
        this.bd.addEventHandler(n, eventHandler);
    }

    public static void bs(player player2) {
        if (player2.c == null) {
            return;
        }
        if (!client.dq.streamAdded(player2.c)) {
            client.dq.addSlaveStream(player2.c);
            client.dq.addSlaveStream(player2.ag);
            client.dq.addSlaveStream(player2.a);
            if (player2.f instanceof SourceLossyStateStream) {
                client.dq.addMasterStream(player2.f);
            } else {
                client.dq.addSlaveStream(player2.f);
            }
        }
    }

    public static String bt(player player2, boolean bl) {
        if (bl) {
            return player2.aq;
        }
        return player2.ai;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarBit(int n) {
        VarBitType varBitType = client.fl.list(n);
        if (varBitType != null) {
            if (varBitType.baseVar.domain != VarDomainType.PLAYER) {
                throw new RuntimeException("'" + n + "' is not a player varbit, it's a " + varBitType.baseVar.domain.name());
            }
            if (this == Gc330.j()) {
                return client.jw.getVarBitValue(varBitType);
            }
            return this.getVarBitValue(varBitType);
        }
        throw new RuntimeException("Player varbit '" + n + "' not defined");
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public String GetName() {
        return this.aq == null ? "" : this.aq;
    }

    public static void cw(player player2) {
        if (player2.c != null) {
            client.dq.removeStream(player2.c);
        }
        if (player2.ag != null) {
            client.dq.removeStream(player2.ag);
        }
        if (player2.a != null) {
            client.dq.removeStream(player2.a);
        }
        if (player2.f != null) {
            client.dq.removeStream(player2.f);
        }
        player2.setProperty("__clientControlStream", null);
        player2.setProperty("__serverControlStream", null);
        player2.c = null;
        player2.ag = null;
        player2.a = null;
        player2.f = null;
    }

    public String bi(boolean bl) {
        String string = "";
        if (this.al != null) {
            string = this.al;
        }
        string = bl ? string + this.aq : string + this.ai;
        if (this.af != null) {
            string = string + this.af;
        }
        return string;
    }

    public static void cp(player player2, Q7 q7, boolean bl) {
        PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)player.eb(player2, PlayerPhysicsComponent.class);
        PlayerPhysicsComponent.d(playerPhysicsComponent, q7, bl, true);
    }

    public void cx(BroadcastStateAndEventsTypes$GonePayload broadcastStateAndEventsTypes$GonePayload) {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.b(BroadcastStateAndEventsHub.tree, "PLAYER <- 'gone' RECEIVED!  Player=" + this + ", broadcaster=" + broadcastStateAndEventsTypes$GonePayload.broadcasterID + ", wranglerID=" + broadcastStateAndEventsTypes$GonePayload.wranglerID);
        }
        this.eh("__onReceiveGone", new Object[]{broadcastStateAndEventsTypes$GonePayload.broadcasterID.toString(), broadcastStateAndEventsTypes$GonePayload.wranglerID, broadcastStateAndEventsTypes$GonePayload.areaID});
    }

    public void cq(Gg3 gg3) {
        Quaternion quaternion = Quaternion.d(gg3);
        Vector3 vector3 = Vector3.d(gg3);
        RotTrans rotTrans = new RotTrans(quaternion, vector3);
        player.cp(this, Q7.g(rotTrans), true);
        rotTrans = rotTrans.v(client.gn, 0.0f, client.gj);
        this.setWorldTransform(rotTrans);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public Object GetVar(String string) {
        int n = StringTools.l(string);
        VarType varType = client.fd.hashLookup(n);
        if (varType != null) {
            return this.ck(string, varType);
        }
        VarBitType varBitType = client.fl.hashLookup(n);
        if (varBitType != null) {
            if (varBitType.baseVar.domain != VarDomainType.PLAYER) {
                throw new RuntimeException("'" + string + "' is not a player varbit, it's a " + varBitType.baseVar.domain.name());
            }
            if (this == Gc330.j()) {
                return client.jw.getVarBitValue(varBitType);
            }
            return this.getVarBitValue(varBitType);
        }
        throw new RuntimeException("Player variable '" + string + "' not defined");
    }

    public player(Bb4 bb4) {
        super(bb4, client.fd);
        this.bd = new LuaEventHandler();
        XElement.j = bb4;
        this.addEventHandler("__PHYSICSFLUSH", new S34(this));
        player.ep(this, new PlayerComponent(this));
    }

    @Override
    public String toString() {
        String string = super.toString();
        int n = string.lastIndexOf(64);
        if (n != -1) {
            string = string.substring(string.lastIndexOf(64));
        }
        return this.aq + " " + string;
    }

    @Override
    public int bz() {
        return super.bz();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarByIndex(int n) {
        VarType varType = client.fd.list(n);
        if (varType != null) {
            return this.ck(n, varType);
        }
        throw new RuntimeException("Player variable '" + n + "' not defined");
    }

    private Object ck(Object object, VarType varType) {
        if (varType.domain != VarDomainType.PLAYER) {
            throw new RuntimeException("'" + object + "' is not a player variable, it's a " + varType.domain.name());
        }
        if (this == Gc330.j()) {
            switch (varType.dataType.baseType) {
                case INTEGER: {
                    return client.jw.getVarValueInt(varType);
                }
                case LONG: {
                    return client.jw.getVarValueLong(varType);
                }
                case STRING: {
                    return (String)client.jw.getVarValue(varType);
                }
                case VECTOR3: {
                    return (Vector3)client.jw.getVarValue(varType);
                }
            }
            return client.jw.getVarValue(varType);
        }
        switch (varType.dataType.baseType) {
            case INTEGER: {
                return this.getVarValueInt(varType);
            }
            case LONG: {
                return this.getVarValueLong(varType);
            }
            case STRING: {
                return (String)this.getVarValue(varType);
            }
            case VECTOR3: {
                return (Vector3)this.getVarValue(varType);
            }
        }
        return this.getVarValue(varType);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarBit(int n, Object object) throws VarBitOverflowException {
        VarBitType varBitType = client.fl.list(n);
        if (varBitType != null) {
            if (varBitType.baseVar.domain != VarDomainType.PLAYER) {
                throw new RuntimeException("'" + n + "' is not a player varbit, it's a " + varBitType.baseVar.domain.name());
            }
            if (!(object instanceof Double)) {
                throw new RuntimeException("Passed non-number type as value to SetVarBit when setting player client variable with index: '" + n + "'.");
            }
            if (this == Gc330.j()) {
                client.jw.setVarBitValue(varBitType, ((Number)object).intValue());
            } else {
                this.setVarBitValue(varBitType, ((Number)object).intValue());
            }
            return;
        }
        throw new RuntimeException("Player varbit '" + n + "' not defined");
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void SetVar(String string, Object object) throws VarBitOverflowException {
        int n = StringTools.l(string);
        VarType varType = client.fd.hashLookup(n);
        if (varType != null) {
            this.cd(string, varType, object);
            return;
        }
        VarBitType varBitType = client.fl.hashLookup(n);
        if (varBitType != null) {
            if (varBitType.baseVar.domain != VarDomainType.PLAYER) {
                throw new RuntimeException("'" + string + "' is not a player varbit, it's a " + varBitType.baseVar.domain.name());
            }
            if (!(object instanceof Number)) {
                throw new RuntimeException("Passed non-number type as value to SetVar when setting player client varbit: '" + string + "'.");
            }
            if (this == Gc330.j()) {
                client.jw.setVarBitValue(varBitType, ((Number)object).intValue());
            } else {
                this.setVarBitValue(varBitType, ((Number)object).intValue());
            }
            return;
        }
        throw new RuntimeException("Player variable '" + string + "' not defined");
    }

    @Override
    public E41 bc() {
        E41 e41 = PlayerPhysicsComponent.b((PlayerPhysicsComponent)player.eb(this, PlayerPhysicsComponent.class));
        if (e41 != null) {
            return e41;
        }
        Vector3 vector3 = this.getWorldTransform().trans;
        return new E41(vector3.x, vector3.y, vector3.z, vector3.x, vector3.y, vector3.z);
    }

    public void be(int n, boolean bl) {
        player.ep(this, new PlayerPhysicsComponent(client.dc, client.cj, n == Gc330.d()));
        this.c = new LossyStateStream(new B348(), n | 0x4000000, "PlayerDynamicState_" + n);
        this.ag = new LossyStateStream(new G381(), n | 0x6000000, "PlayerDynamicStateContents_" + n);
        this.a = new LossyStateStream(new R378(), n | 0x1000000, "PlayerServerSideControl_" + n);
        if (bl) {
            this.f = new SourceLossyStateStream(new R378(), n | 0x2000000, "PlayerClientSideControl_" + n);
            this.setProperty("__clientControlStreamMaster", true);
        } else {
            this.f = new LossyStateStream(new R378(), n | 0x2000000, "PlayerClientSideControl_" + n);
            this.setProperty("__clientControlStreamMaster", false);
        }
        this.setProperty("__clientControlStream", this.f);
        this.setProperty("__serverControlStream", this.a);
        player.ep(this, new PhysicsComponent(new E39(this), null, null));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void onVarTransmitCancel(String string, EventHandler eventHandler) {
        if (string.equals("*")) {
            this.bd.removeEventHandler(string, eventHandler);
            this.bm = this.bd.hasEvent(string);
        } else {
            int n = StringTools.l(string);
            this.bd.removeEventHandler(n, eventHandler);
        }
    }

    public static void cv(player player2, int n, Object object) {
        VarType varType = client.fd.list(n);
        player.cl(player2, varType.id, varType.debugNameHash32, object);
    }

    public static void cj(player player2, VarType varType, Object object) {
        player.cl(player2, varType.id, varType.debugNameHash32, object);
    }

    private static void cl(player player2, int n, int n2, Object object) {
        boolean bl;
        boolean bl2 = bl = object == null;
        if (n2 != 0) {
            String string;
            if (bq != null && (string = (String)bq.get(n2)) != null) {
                if (bl) {
                    player2.bd.triggerEvent((Object)player2, n2, (Object)string);
                    if (player2.bm) {
                        player2.bd.triggerEvent((Object)player2, "*", (Object)string);
                    }
                } else {
                    Object[] arrobject = new Object[]{string, object};
                    player2.bd.triggerEvent((Object)player2, n2, (Object)arrobject);
                    if (player2.bm) {
                        player2.bd.triggerEvent((Object)player2, "*", (Object)arrobject);
                    }
                }
            }
        } else if (bl) {
            player2.bd.triggerEvent((Object)player2, n, (Object)n);
            if (player2.bm) {
                player2.bd.triggerEvent((Object)player2, "*", (Object)n);
            }
        } else {
            Object[] arrobject = new Object[]{n, object};
            player2.bd.triggerEvent((Object)player2, n, (Object)arrobject);
            if (player2.bm) {
                player2.bd.triggerEvent((Object)player2, "*", (Object)arrobject);
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddInventoryHashType(int n, int n2) {
        if (bo == null) {
            bo = new HashMap();
        }
        bo.put(n, n2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public ClientInventory GetInventory(String string) {
        int n;
        if (bo != null && this == Gc330.j() && bo.containsKey(n = StringTools.l(string.toLowerCase()))) {
            int n2 = (Integer)bo.get(n);
            return G451.g(n2, false);
        }
        return null;
    }

    @Override
    public boolean br(String string) {
        int n = StringTools.l(string);
        VarType varType = client.fd.hashLookup(n);
        if (varType == null) {
            VarBitType varBitType = client.fl.hashLookup(n);
            if (varBitType == null) {
                return false;
            }
            varType = varBitType.baseVar;
        }
        return varType.domain == VarDomainType.PLAYER;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void BroadcastableEvent(BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition, byte[] arrby) {
        if (broadcastStateAndEventsTypes$EventDefinition.getAutoForwarding()) {
            N272 n272 = client.i();
            El328 el328 = El328.d(Eu326.GENERIC_BROADCAST_EVENT, n272.s);
            Gs329.i(el328.q, 0);
            int n = el328.q.v;
            BroadcastStateAndEventsTransmission.PackEventMessage(el328.q, broadcastStateAndEventsTypes$EventDefinition, new BroadcastStateAndEventsTypes$EventPayload(arrby, this.bg));
            Gs329.as(el328.q, el328.q.v - n);
            N272.e(n272, el328);
        }
    }

    private static void ca(String string, VarBitType varBitType) {
        if (bq.containsKey(varBitType.baseVar.debugNameHash32)) {
            String string2 = (String)bq.get(varBitType.baseVar.debugNameHash32);
            if (string2.startsWith("[varbit:")) {
                String[] arrstring = StringTools.y(string2.replace("]", ""), ':');
                String[] arrstring2 = StringTools.y(arrstring[1], ',');
                boolean bl = false;
                for (int i = 0; i < arrstring2.length; ++i) {
                    if (!arrstring2[i].equals(string)) continue;
                    bl = true;
                    break;
                }
                String string3 = arrstring[1];
                if (!bl) {
                    string3 = string3 + "," + string;
                }
                String string4 = String.format("[varbit:%s]", string3);
                bq.put(varBitType.baseVar.debugNameHash32, string4);
            }
        } else {
            String string5 = String.format("[varbit:%s]", string);
            bq.put(varBitType.baseVar.debugNameHash32, string5);
        }
    }

    public void cm(String string, BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.b(BroadcastStateAndEventsHub.tree, "EVENT RECEIVED AT PLAYER OBJ!  Player=" + this + ", messageName=" + string + ", wranglerID=" + broadcastStateAndEventsTypes$EventPayload.wranglerID + ", payload=" + broadcastStateAndEventsTypes$EventPayload);
        }
        this.eh(string, new Object[]{broadcastStateAndEventsTypes$EventPayload.wire_data, GameEntity.es(broadcastStateAndEventsTypes$EventPayload.broadcasterID), broadcastStateAndEventsTypes$EventPayload.wranglerID, broadcastStateAndEventsTypes$EventPayload.areaID});
        this.eh("__onReceiveEvent", new Object[]{string, broadcastStateAndEventsTypes$EventPayload.wire_data, broadcastStateAndEventsTypes$EventPayload.broadcasterID.toString(), broadcastStateAndEventsTypes$EventPayload.wranglerID, broadcastStateAndEventsTypes$EventPayload.areaID});
    }

    public void cc(BroadcastStateAndEventsTypes$AppearedPayload broadcastStateAndEventsTypes$AppearedPayload) {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.b(BroadcastStateAndEventsHub.tree, "PLAYER <- 'appeared' RECEIVED!  Player=" + this + ", broadcaster=" + broadcastStateAndEventsTypes$AppearedPayload.broadcasterID + ", wranglerID=" + broadcastStateAndEventsTypes$AppearedPayload.wranglerID);
        }
        this.eh("__onReceiveAppeared", new Object[]{broadcastStateAndEventsTypes$AppearedPayload.broadcasterID.toString(), broadcastStateAndEventsTypes$AppearedPayload.wranglerID, broadcastStateAndEventsTypes$AppearedPayload.areaID});
    }

    public static void cy(player player2) {
        PlayerPhysicsComponent.w((PlayerPhysicsComponent)player.eb(player2, PlayerPhysicsComponent.class));
    }

    public static void co(player player2) {
        PlayerPhysicsComponent.l((PlayerPhysicsComponent)player.eb(player2, PlayerPhysicsComponent.class));
    }

    static {
        bq = new HashMap();
        bo = null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler onVarTransmit(String string, LuaFunctionRef luaFunctionRef) {
        ScriptEventHandler scriptEventHandler = new ScriptEventHandler(client.cj, luaFunctionRef, null);
        this.ce(string, scriptEventHandler);
        return scriptEventHandler;
    }

    public final void bn(Gg3 gg3) {
        int n;
        gg3.v = 0;
        int n2 = Gg3.ar(gg3);
        this.av = (byte)(n2 & 1);
        boolean bl = this.ab;
        this.ab = (n2 & 2) != 0;
        boolean bl2 = (n2 & 4) != 0;
        int n3 = super.bz();
        player.ez(this, (n2 >> 3 & 7) + 1);
        boolean bl3 = (n2 & 0x40) != 0;
        boolean bl4 = (n2 & 0x80) != 0;
        Vector3 vector3 = this.getWorldTransform().trans;
        vector3 = Vector3.m(vector3, this.bz() - n3 << 1, 0.0f, this.bz() - n3 << 1);
        player.w(this, vector3);
        this.al = bl3 ? gg3.bh() : null;
        this.af = bl4 ? gg3.bh() : null;
        this.az = Gg3.ax(gg3);
        this.ah = Gg3.ax(gg3);
        boolean bl5 = this.ad = Gg3.ax(gg3) == 1;
        if (client.t == D123.LIVE && client.ik >= 2) {
            this.ad = false;
        }
        this.aq = Gg3.bk(gg3);
        this.bb = "Player=" + this.aq;
        this.ai = this.aq;
        if (this == Gc330.j()) {
            Ku323.j = this.aq;
        }
        this.ap = Gg3.ar(gg3);
        if (bl2) {
            this.an = Gg3.au(gg3);
            if (this.an == 65535) {
                this.an = -1;
            }
            this.ao = this.ap;
            this.aa = -1;
        } else {
            this.an = 0;
            this.ao = Gg3.ar(gg3);
            this.aa = Gg3.ar(gg3);
            if (this.aa == 255) {
                this.aa = -1;
            }
        }
        int n4 = this.aw;
        this.aw = Gg3.ar(gg3);
        if (this.aw != 0) {
            n = this.ac;
            int n5 = this.at;
            int n6 = this.ax;
            int n7 = this.ar;
            this.ac = Gg3.au(gg3);
            this.at = Gg3.au(gg3);
            this.ax = Gg3.ar(gg3);
            this.ar = Gg3.ar(gg3);
            if (bl != this.ab || n4 != this.aw || n != this.ac || n5 != this.at || n6 != this.ax || n7 != this.ar) {
                At476.e(this);
            }
        } else {
            At476.j(this);
        }
        n = Gg3.au(gg3);
        if (n == 65535) {
            n = -1;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarByIndex(int n, Object object) {
        VarType varType = client.fd.list(n);
        if (varType != null) {
            this.cd(n, varType, object);
            return;
        }
        throw new RuntimeException("Player variable '" + n + "' not defined");
    }

    public void cb(String string, BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload) {
        if (BroadcastStateAndEventsHub.debug) {
            Jy122.b(BroadcastStateAndEventsHub.tree, "STATE UPDATE RECEIVED AT PLAYER OBJ!  Player=" + this + ", messageName=" + string + ", wranglerID=" + broadcastStateAndEventsTypes$StatePayload.wranglerID + ", payload=" + broadcastStateAndEventsTypes$StatePayload);
        }
        this.eh(string, new Object[]{broadcastStateAndEventsTypes$StatePayload.wire_data, GameEntity.es(broadcastStateAndEventsTypes$StatePayload.broadcasterID), broadcastStateAndEventsTypes$StatePayload.wranglerID, broadcastStateAndEventsTypes$StatePayload.areaID});
        this.eh("__onReceiveState", new Object[]{string, broadcastStateAndEventsTypes$StatePayload.wire_data, broadcastStateAndEventsTypes$StatePayload.broadcasterID.toString(), broadcastStateAndEventsTypes$StatePayload.wranglerID, broadcastStateAndEventsTypes$StatePayload.areaID});
    }

    private void cd(Object object, VarType varType, Object object2) {
        block25 : {
            block24 : {
                if (varType.domain != VarDomainType.PLAYER) {
                    throw new RuntimeException("'" + object + "' is not a player variable, it's a " + varType.domain.name());
                }
                if (this != Gc330.j()) break block24;
                switch (varType.dataType.baseType) {
                    case INTEGER: {
                        if (!(object2 instanceof Number)) {
                            throw new RuntimeException("Passed non-number type as value to SetVar when setting player client variable: '" + object + "'.");
                        }
                        client.jw.setVarValueInt(varType, ((Number)object2).intValue());
                        break block25;
                    }
                    case LONG: {
                        if (!(object2 instanceof Number)) {
                            throw new RuntimeException("Passed non-number type as value to SetVar when setting player client variable: '" + object + "'.");
                        }
                        client.jw.setVarValueLong(varType, ((Number)object2).longValue());
                        break block25;
                    }
                    case STRING: {
                        if (!(object2 instanceof String)) {
                            throw new RuntimeException("Passed non-string type as value to SetVar when setting player client variable: '" + object + "'.");
                        }
                        client.jw.setVarValue(varType, (String)object2);
                        break block25;
                    }
                    case VECTOR3: {
                        if (!(object2 instanceof Vector3) && !(object2 instanceof Kg142)) {
                            throw new RuntimeException("Passed non-Vector3 type as value to SetVar when setting player client variable: '" + object + "'.");
                        }
                        if (object2 instanceof Vector3) {
                            client.jw.setVarValue(varType, new Kg142((Vector3)object2));
                        } else {
                            client.jw.setVarValue(varType, (Kg142)object2);
                        }
                        break block25;
                    }
                    default: {
                        throw new RuntimeException("Passed unsupported type as value to SetVar when setting player client variable: '" + object + "'.");
                    }
                }
            }
            switch (varType.dataType.baseType) {
                case INTEGER: {
                    if (!(object2 instanceof Number)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting player client variable: '" + object + "'.");
                    }
                    this.setVarValueInt(varType, ((Number)object2).intValue());
                    break;
                }
                case LONG: {
                    if (!(object2 instanceof Number)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting player client variable: '" + object + "'.");
                    }
                    this.setVarValueLong(varType, ((Number)object2).longValue());
                    break;
                }
                case STRING: {
                    if (!(object2 instanceof String)) {
                        throw new RuntimeException("Passed non-string type as value to SetVar when setting player client variable: '" + object + "'.");
                    }
                    this.setVarValue(varType, (String)object2);
                    break;
                }
                case VECTOR3: {
                    if (!(object2 instanceof Vector3) && !(object2 instanceof Kg142)) {
                        throw new RuntimeException("Passed non-Vector3 type as value to SetVar when setting player client variable: '" + object + "'.");
                    }
                    if (object2 instanceof Vector3) {
                        this.setVarValue(varType, new Kg142((Vector3)object2));
                        break;
                    }
                    this.setVarValue(varType, (Kg142)object2);
                    break;
                }
                default: {
                    throw new RuntimeException("Passed unsupported type as value to SetVar when setting player client variable: '" + object + "'.");
                }
            }
        }
    }
}

