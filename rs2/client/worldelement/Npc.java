/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.worldelement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.constants.BaseVarType;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.E41;
import com.jagex.maths.I48;
import com.jagex.maths.Quaternion;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import rs2.client.client;
import rs2.client.lua.Q290;
import rs2.client.worldelement.B35;
import rs2.client.worldelement.H50;
import rs2.client.worldelement.J44;
import rs2.client.worldelement.L51;
import rs2.client.worldelement.NpcComponent;
import rs2.client.worldelement.Q32;
import rs2.shared.movement.E181;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.Q40;
import rs2.shared.movement.ScheduledMovementComponent;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Jg365;
import tfu.Jt38;
import tfu.Kg142;
import tfu.Ll42;
import tfu.Lq191;

@ScriptEntryClass
public class Npc
extends L51
implements Q290 {
    private static final float al = 0.25f;
    public static boolean m = false;
    private float a;
    private Jg365 af = new Jg365();
    private int ag;
    public String ai;
    Jt38 aq;
    private ScaleRotTrans av;
    private int c;
    private float f;
    public final ScheduledMovementComponent i;
    public XElement k;
    boolean n = false;
    private E181 o;

    @Override
    public String toString() {
        String string;
        String string2 = super.toString();
        int n = string2.lastIndexOf(64);
        if (n != -1) {
            string2 = string2.substring(string2.lastIndexOf(64));
        }
        return ((string = (String)Npc.ej(this, "NpcName")) == null ? "null-npc-name" : string) + " " + string2;
    }

    public static void bn(Npc npc, float f, float f2, int n, int n2) {
        npc.a = f;
        npc.f = f2;
        npc.c = n;
        npc.ag = n2;
        if (npc.aq != null) {
            Jt38.f(npc.aq, npc.a, npc.f, npc.c, npc.ag);
        }
    }

    public void bt(Vector3 vector3, Quaternion quaternion) {
        if (this.aq != null) {
            return;
        }
        this.aq = new Jt38(this, client.gz.d, client.gn, client.gj, this.a, this.f, this.c, this.ag, vector3, quaternion);
        if (this.o != null) {
            this.aq.e(this.o);
            this.o = null;
        }
        this.i.b();
    }

    static Vector3 be(Npc npc) {
        I48 i48 = I48.d();
        float f = 0.0f;
        for (H50 h50 : npc.af) {
            I48.n(i48, h50.g);
            if (!((f += h50.q) > 0.25f)) continue;
            I48.f(i48, h50.g, (f - 0.25f) / h50.q);
            f = 0.25f;
            break;
        }
        if (f > 0.0f) {
            I48.ai(i48, f);
        }
        return i48.ao();
    }

    static Vector3 bs(Npc npc) {
        I48 i48 = I48.d();
        float f = 0.0f;
        for (H50 h50 : npc.af) {
            I48.n(i48, h50.d);
            if (!((f += h50.q) > 0.25f)) continue;
            I48.f(i48, h50.d, (f - 0.25f) / h50.q);
            f = 0.25f;
            break;
        }
        if (f > 0.0f) {
            I48.ai(i48, f);
        }
        return i48.ao();
    }

    void cq(float f) {
        Object object2;
        ScaleRotTrans scaleRotTrans = this.getObjectTransform();
        if (this.av == null) {
            this.av = scaleRotTrans;
        }
        Vector3 vector3 = Vector3.k(scaleRotTrans.trans, this.av.trans);
        Quaternion quaternion = this.av.rot.s();
        quaternion = quaternion.r(scaleRotTrans.rot);
        Vector3 vector32 = quaternion.x();
        this.av = scaleRotTrans;
        this.af.addFirst(new H50(vector3, vector32, f));
        float f2 = 0.0f;
        int n = 0;
        for (Object object2 : this.af) {
            if (f2 > 0.25f) {
                ++n;
            }
            f2 += ((H50)object2).q;
        }
        for (int i = 0; i < n; ++i) {
            this.af.removeLast();
        }
        ScaleRotTrans scaleRotTrans2 = Npc.v(this);
        object2 = new I48(Npc.be(this));
        Vector3 vector33 = Npc.bs(this);
        I48.al((I48)object2, scaleRotTrans2.rot);
        ((I48)object2).j = -((I48)object2).j;
        ((I48)object2).h = -((I48)object2).h;
        this.setProperty("LinearVelocity", ((I48)object2).ao());
        this.setProperty("AngularVelocity", vector33);
    }

    public static void cp(Npc npc) {
        if (npc.aq == null) {
            return;
        }
        Jt38.i(npc.aq);
    }

    public static void cd(Npc npc) {
        if (npc.aq == null) {
            return;
        }
        Jt38.o(npc.aq, client.gn, client.gj);
        npc.i.b();
    }

    @Override
    public E41 bc() {
        E41 e41 = new E41(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        return e41;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarByIndex(int n) {
        VarBasicType varBasicType = client.fn.list(n);
        if (varBasicType != null) {
            return this.ce(n, varBasicType);
        }
        throw new RuntimeException("NPC variable '" + n + "' not defined");
    }

    @Override
    public boolean br(String string) {
        int n = StringTools.l(string);
        VarType varType = client.fn.hashLookup(n);
        if (varType == null) {
            VarBitType varBitType = client.fl.hashLookup(n);
            if (varBitType == null) {
                return false;
            }
            varType = varBitType.baseVar;
        }
        return varType.domain == VarDomainType.NPC;
    }

    private Object ce(Object object, VarType varType) {
        if (varType.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + object + "' is not an NPC variable, it's a " + varType.domain.name());
        }
        switch (varType.dataType.baseType) {
            case INTEGER: {
                return this.getVarValueInt(varType);
            }
            case LONG: {
                return this.getVarValueLong(varType);
            }
            case STRING: {
                return this.getVarValue(varType);
            }
            case VECTOR3: {
                return this.getVarValue(varType);
            }
        }
        return this.getVarValue(varType);
    }

    private void ck(Object object, VarType varType, Object object2) {
        if (varType.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + object + "' is not an NPC variable, it's a " + varType.domain.name());
        }
        switch (varType.dataType.baseType) {
            case INTEGER: {
                if (!(object2 instanceof Number)) {
                    throw new RuntimeException("Passed non-number type as value to SetVar when setting NPC client variable: '" + object + "'.");
                }
                this.setVarValueInt(varType, ((Number)object2).intValue());
                break;
            }
            case LONG: {
                if (!(object2 instanceof Number)) {
                    throw new RuntimeException("Passed non-number type as value to SetVar when setting NPC client variable: '" + object + "'.");
                }
                this.setVarValueLong(varType, ((Number)object2).longValue());
                break;
            }
            case STRING: {
                if (!(object2 instanceof String)) {
                    throw new RuntimeException("Passed non-string type as value to SetVar when setting NPC client variable: '" + object + "'.");
                }
                this.setVarValue(varType, object2);
                break;
            }
            case VECTOR3: {
                if (!(object2 instanceof Vector3) && !(object2 instanceof Kg142)) {
                    throw new RuntimeException("Passed non-Vector3 type as value to SetVar when setting NPC client variable: '" + object + "'.");
                }
                if (object2 instanceof Vector3) {
                    this.setVarValue(varType, new Kg142((Vector3)object2));
                    break;
                }
                this.setVarValue(varType, object2);
                break;
            }
            default: {
                throw new RuntimeException("Passed unsupported type as value to SetVar when setting NPC client variable: '" + object + "'.");
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarBit(int n, Object object) throws VarBitOverflowException {
        VarBitType varBitType = client.fl.list(n);
        if (varBitType != null) {
            if (varBitType.baseVar.domain != VarDomainType.NPC) {
                throw new RuntimeException("'" + n + "' is not an NPC varbit, it's a " + varBitType.baseVar.domain.name());
            }
            if (!(object instanceof Double)) {
                throw new RuntimeException("Passed non-number type as value to SetVarBit when setting NPC client variable with index: '" + n + "'.");
            }
            this.setVarBitValue(varBitType, ((Number)object).intValue());
            return;
        }
        throw new RuntimeException("NPC varbit '" + n + "' not defined");
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public Object GetVar(String string) {
        int n = StringTools.l(string);
        VarType varType = client.fn.hashLookup(n);
        if (varType != null) {
            return this.ce(string, varType);
        }
        VarBitType varBitType = client.fl.hashLookup(n);
        if (varBitType != null) {
            if (varBitType.baseVar.domain != VarDomainType.NPC) {
                throw new RuntimeException("'" + string + "' is not an NPC varbit, it's a " + varBitType.baseVar.domain.name());
            }
            return this.getVarBitValue(varBitType);
        }
        throw new RuntimeException("NPC variable '" + string + "' not defined");
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public String GetName() {
        return this.ai;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarBit(int n) {
        VarBitType varBitType = client.fl.list(n);
        if (varBitType != null) {
            if (varBitType.baseVar.domain != VarDomainType.NPC) {
                throw new RuntimeException("'" + n + "' is not an NPC varbit, it's a " + varBitType.baseVar.domain.name());
            }
            return this.getVarBitValue(varBitType);
        }
        throw new RuntimeException("NPC varbit '" + n + "' not defined");
    }

    public static void ca(Npc npc) {
        npc.n = true;
        ScheduledMovementComponent.z(npc.i, client.dq);
        if (npc.aq != null) {
            Jt38.al(npc.aq);
            npc.aq = null;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getCollisionMask(@ScriptDefaults(defaultBoolean=false) boolean bl) {
        return Jt38.a(this.aq);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void SetVar(String string, Object object) throws VarBitOverflowException {
        int n = StringTools.l(string);
        VarType varType = client.fn.hashLookup(n);
        if (varType != null) {
            this.ck(string, varType, object);
            return;
        }
        VarBitType varBitType = client.fl.hashLookup(n);
        if (varBitType != null) {
            if (varBitType.baseVar.domain != VarDomainType.NPC) {
                throw new RuntimeException("'" + string + "' is not an NPC varbit, it's a " + varBitType.baseVar.domain.name());
            }
            if (!(object instanceof Number)) {
                throw new RuntimeException("Passed non-number type as value to SetVar when setting NPC client varbit: '" + string + "'.");
            }
            this.setVarBitValue(varBitType, ((Number)object).intValue());
            return;
        }
        throw new RuntimeException("NPC variable '" + string + "' not defined");
    }

    void cw() {
        ScaleRotTrans scaleRotTrans;
        this.av = scaleRotTrans = this.getObjectTransform();
        this.af.clear();
        Vector3 vector3 = this.aq.g();
        vector3 = Vector3.ai(vector3, 0.25f / Lq191.d());
        this.af.addFirst(new H50(vector3, Vector3.g, 0.25f));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarByIndex(int n, Object object) {
        VarBasicType varBasicType = client.fn.list(n);
        if (varBasicType != null) {
            this.ck(n, varBasicType, object);
            return;
        }
        throw new RuntimeException("NPC variable '" + n + "' not defined");
    }

    public void bi(XElement xElement, Vector3 vector3, Quaternion quaternion) {
        this.k = xElement;
        XElement.bq(this.k, this, new Q32(this, vector3, quaternion));
    }

    public Npc(Bb4 bb4) {
        super(bb4, client.fn);
        Npc.ep(this, new NpcComponent(this));
        Npc.ep(this, new PhysicsComponent(new J44(this), null, null));
        this.i = ScheduledMovementComponent.g(this.bg, new B35(this));
        Npc.ep(this, this.i);
        this.ai = "#PLACEHOLDER#";
    }
}

