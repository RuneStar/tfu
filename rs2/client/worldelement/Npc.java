// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import rs2.shared.movement.Z36;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import rs2.shared.movement.Q40;
import rs2.shared.movement.PhysicsComponent;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import tfu.Bb4;
import com.jagex.game.runetek6.event.EventHandler;
import tfu.Lq191;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import tfu.Kg142;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.core.stringtools.general.StringTools;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.maths.E41;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.Iterator;
import com.jagex.maths.I48;
import rs2.client.client;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.gameentity.GameEntity;
import rs2.shared.movement.E181;
import com.jagex.game.runetek6.xelement.XElement;
import rs2.shared.movement.ScheduledMovementComponent;
import com.jagex.maths.ScaleRotTrans;
import tfu.Jt38;
import tfu.Jg365;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import rs2.client.lua.Q290;

@ScriptEntryClass
public class Npc extends L51 implements Q290
{
    private static final float al = 0.25f;
    public static boolean m;
    private float a;
    private Jg365 af;
    private int ag;
    public String ai;
    Jt38 aq;
    private ScaleRotTrans av;
    private int c;
    private float f;
    public final ScheduledMovementComponent i;
    public XElement k;
    boolean n;
    private E181 o;
    
    @Override
    public String toString() {
        String str = super.toString();
        if (str.lastIndexOf(64) != -1) {
            str = str.substring(str.lastIndexOf(64));
        }
        final String s = (String)GameEntity.ej(this, "NpcName");
        return ((s == null) ? "null-npc-name" : s) + " " + str;
    }
    
    public static void bn(final Npc npc, final float a, final float f, final int c, final int ag) {
        npc.a = a;
        npc.f = f;
        npc.c = c;
        npc.ag = ag;
        if (npc.aq != null) {
            Jt38.f(npc.aq, npc.a, npc.f, npc.c, npc.ag);
        }
    }
    
    public void bt(final Vector3 vector3, final Quaternion quaternion) {
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
    
    static Vector3 be(final Npc npc) {
        final I48 d = I48.d();
        float n = 0.0f;
        for (final H50 h50 : npc.af) {
            I48.n(d, h50.g);
            n += h50.q;
            if (n > 0.25f) {
                I48.f(d, h50.g, (n - 0.25f) / h50.q);
                n = 0.25f;
                break;
            }
        }
        if (n > 0.0f) {
            I48.ai(d, n);
        }
        return d.ao();
    }
    
    static Vector3 bs(final Npc npc) {
        final I48 d = I48.d();
        float n = 0.0f;
        for (final H50 h50 : npc.af) {
            I48.n(d, h50.d);
            n += h50.q;
            if (n > 0.25f) {
                I48.f(d, h50.d, (n - 0.25f) / h50.q);
                n = 0.25f;
                break;
            }
        }
        if (n > 0.0f) {
            I48.ai(d, n);
        }
        return d.ao();
    }
    
    void cq(final float n) {
        final ScaleRotTrans objectTransform = this.getObjectTransform();
        if (this.av == null) {
            this.av = objectTransform;
        }
        final Vector3 k = Vector3.k(objectTransform.trans, this.av.trans);
        final Vector3 x = this.av.rot.s().r(objectTransform.rot).x();
        this.av = objectTransform;
        this.af.addFirst(new H50(k, x, n));
        float n2 = 0.0f;
        int n3 = 0;
        for (final H50 h50 : this.af) {
            if (n2 > 0.25f) {
                ++n3;
            }
            n2 += h50.q;
        }
        for (int i = 0; i < n3; ++i) {
            this.af.removeLast();
        }
        final ScaleRotTrans v = SceneGraphNode.v(this);
        final I48 i2 = new I48(be(this));
        final Vector3 bs = bs(this);
        I48.al(i2, v.rot);
        i2.j = -i2.j;
        i2.h = -i2.h;
        this.setProperty("LinearVelocity", i2.ao());
        this.setProperty("AngularVelocity", bs);
    }
    
    public static void cp(final Npc npc) {
        if (npc.aq == null) {
            return;
        }
        Jt38.i(npc.aq);
    }
    
    public static void cd(final Npc npc) {
        if (npc.aq == null) {
            return;
        }
        Jt38.o(npc.aq, client.gn, client.gj);
        npc.i.b();
    }
    
    @Override
    public E41 bc() {
        return new E41(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarByIndex(final int n) {
        final VarBasicType list = client.fn.list(n);
        if (list != null) {
            return this.ce(n, list);
        }
        throw new RuntimeException("NPC variable '" + n + "' not defined");
    }
    
    @Override
    public boolean br(final String s) {
        final int l = StringTools.l(s);
        VarType varType = client.fn.hashLookup(l);
        if (varType == null) {
            final VarBitType hashLookup = client.fl.hashLookup(l);
            if (hashLookup == null) {
                return false;
            }
            varType = hashLookup.baseVar;
        }
        return varType.domain == VarDomainType.NPC;
    }
    
    private Object ce(final Object obj, final VarType varType) {
        if (varType.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + obj + "' is not an NPC variable, it's a " + varType.domain.name());
        }
        switch (G49.g[varType.dataType.baseType.ordinal()]) {
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
    
    private void ck(final Object o, final VarType varType, final Object o2) {
        if (varType.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + o + "' is not an NPC variable, it's a " + varType.domain.name());
        }
        switch (G49.g[varType.dataType.baseType.ordinal()]) {
            case 1: {
                if (!(o2 instanceof Number)) {
                    throw new RuntimeException("Passed non-number type as value to SetVar when setting NPC client variable: '" + o + "'.");
                }
                this.setVarValueInt(varType, ((Number)o2).intValue());
                break;
            }
            case 2: {
                if (!(o2 instanceof Number)) {
                    throw new RuntimeException("Passed non-number type as value to SetVar when setting NPC client variable: '" + o + "'.");
                }
                this.setVarValueLong(varType, ((Number)o2).longValue());
                break;
            }
            case 3: {
                if (!(o2 instanceof String)) {
                    throw new RuntimeException("Passed non-string type as value to SetVar when setting NPC client variable: '" + o + "'.");
                }
                this.setVarValue(varType, o2);
                break;
            }
            case 4: {
                if (!(o2 instanceof Vector3) && !(o2 instanceof Kg142)) {
                    throw new RuntimeException("Passed non-Vector3 type as value to SetVar when setting NPC client variable: '" + o + "'.");
                }
                if (o2 instanceof Vector3) {
                    this.setVarValue(varType, new Kg142((Vector3)o2));
                    break;
                }
                this.setVarValue(varType, o2);
                break;
            }
            default: {
                throw new RuntimeException("Passed unsupported type as value to SetVar when setting NPC client variable: '" + o + "'.");
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarBit(final int i, final Object o) throws VarBitOverflowException {
        final VarBitType list = client.fl.list(i);
        if (list == null) {
            throw new RuntimeException("NPC varbit '" + i + "' not defined");
        }
        if (list.baseVar.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + i + "' is not an NPC varbit, it's a " + list.baseVar.domain.name());
        }
        if (!(o instanceof Double)) {
            throw new RuntimeException("Passed non-number type as value to SetVarBit when setting NPC client variable with index: '" + i + "'.");
        }
        this.setVarBitValue(list, ((Number)o).intValue());
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public Object GetVar(final String s) {
        final int l = StringTools.l(s);
        final VarType hashLookup = client.fn.hashLookup(l);
        if (hashLookup != null) {
            return this.ce(s, hashLookup);
        }
        final VarBitType hashLookup2 = client.fl.hashLookup(l);
        if (hashLookup2 == null) {
            throw new RuntimeException("NPC variable '" + s + "' not defined");
        }
        if (hashLookup2.baseVar.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + s + "' is not an NPC varbit, it's a " + hashLookup2.baseVar.domain.name());
        }
        return this.getVarBitValue(hashLookup2);
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
    public Object GetVarBit(final int n) {
        final VarBitType list = client.fl.list(n);
        if (list == null) {
            throw new RuntimeException("NPC varbit '" + n + "' not defined");
        }
        if (list.baseVar.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + n + "' is not an NPC varbit, it's a " + list.baseVar.domain.name());
        }
        return this.getVarBitValue(list);
    }
    
    public static void ca(final Npc npc) {
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
    public int getCollisionMask(@ScriptDefaults(defaultBoolean = false) final boolean b) {
        return Jt38.a(this.aq);
    }
    
    static {
        Npc.m = false;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void SetVar(final String str, final Object o) throws VarBitOverflowException {
        final int l = StringTools.l(str);
        final VarType hashLookup = client.fn.hashLookup(l);
        if (hashLookup != null) {
            this.ck(str, hashLookup, o);
            return;
        }
        final VarBitType hashLookup2 = client.fl.hashLookup(l);
        if (hashLookup2 == null) {
            throw new RuntimeException("NPC variable '" + str + "' not defined");
        }
        if (hashLookup2.baseVar.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + str + "' is not an NPC varbit, it's a " + hashLookup2.baseVar.domain.name());
        }
        if (!(o instanceof Number)) {
            throw new RuntimeException("Passed non-number type as value to SetVar when setting NPC client varbit: '" + str + "'.");
        }
        this.setVarBitValue(hashLookup2, ((Number)o).intValue());
    }
    
    void cw() {
        this.av = this.getObjectTransform();
        this.af.clear();
        this.af.addFirst(new H50(Vector3.ai(this.aq.g(), 0.25f / Lq191.d()), Vector3.g, 0.25f));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarByIndex(final int n, final Object o) {
        final VarBasicType list = client.fn.list(n);
        if (list != null) {
            this.ck(n, list, o);
            return;
        }
        throw new RuntimeException("NPC variable '" + n + "' not defined");
    }
    
    public void bi(final XElement k, final Vector3 vector3, final Quaternion quaternion) {
        XElement.bq(this.k = k, this, new Q32(this, vector3, quaternion));
    }
    
    public Npc(final Bb4 bb4) {
        super(bb4, client.fn);
        this.n = false;
        this.af = new Jg365();
        GameEntity.ep(this, new NpcComponent(this));
        GameEntity.ep(this, new PhysicsComponent(new J44(this), null, null));
        GameEntity.ep(this, this.i = ScheduledMovementComponent.g(super.bg, new B35(this)));
        this.ai = "#PLACEHOLDER#";
    }
}
