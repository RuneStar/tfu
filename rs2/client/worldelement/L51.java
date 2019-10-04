/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.worldelement;

import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.gameentity.G55;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.variables.G53;
import com.jagex.maths.E41;
import com.jagex.maths.Vector3;
import rs2.client.client;
import tfu.An52;
import tfu.Bb4;
import tfu.Kf58;
import tfu.Kh56;
import tfu.Ma57;
import tfu.Mn54;

public abstract class L51
extends GameEntity
implements An52,
G53,
VarDomain {
    public int bh;
    public int bj;
    public int bk;
    public int bl = 1;
    public boolean bp = false;
    public int bw = -1000;
    public boolean bx = false;
    public final Mn54 by;

    public abstract E41 bc();

    @Override
    public Vector3 e() {
        E41 e41 = this.bc();
        return Vector3.g(e41.j, e41.e, e41.h);
    }

    public int bz() {
        return this.bl;
    }

    @Override
    public boolean canModifyVarValue(VarType varType) {
        return true;
    }

    @Override
    public int getVarValueInt(VarType varType) {
        return this.by.d(varType.id);
    }

    @Override
    public long getVarValueLong(VarType varType) {
        return this.by.j(varType.id);
    }

    @Override
    public Object getVarValue(VarType varType) {
        return this.by.h(varType.id);
    }

    @Override
    public int getVarBitValue(VarBitType varBitType) {
        return varBitType.getVarbitValue(this.getVarValueInt(varBitType.baseVar));
    }

    @Override
    public void setVarValueInt(VarType varType, int n) {
        int n2 = this.by.d(varType.id);
        if (n2 != n) {
            this.by.q(varType.id, n);
            Integer n3 = G55.s(this.ce, varType.debugNameHash32);
            if (n3 != null) {
                this.triggerEvent(n3, n);
            }
        }
    }

    @Override
    public void setVarValueLong(VarType varType, long l) {
        long l2 = this.by.d(varType.id);
        if (l2 != l) {
            this.by.e(varType.id, l);
            Integer n = G55.s(this.ce, varType.debugNameHash32);
            if (n != null) {
                this.triggerEvent(n, l);
            }
        }
    }

    public static void ez(L51 l51, int n) {
        l51.bl = n;
    }

    @Override
    public Vector3 j() {
        E41 e41 = this.bc();
        return Vector3.g(e41.g, e41.d, e41.q);
    }

    @Override
    public void setVarBitValue(VarBitType varBitType, int n) throws VarBitOverflowException {
        this.setVarValueInt(varBitType.baseVar, varBitType.setVarbitValue(this.getVarValueInt(varBitType.baseVar), n));
    }

    @Override
    public void setVarValue(VarType varType, Object object) {
        Integer n = this.by.d(varType.id);
        if (!Kh56.g(n, object)) {
            this.by.s(varType.id, object);
            Integer n2 = G55.s(this.ce, varType.debugNameHash32);
            if (n2 != null) {
                this.triggerEvent(n2, object);
            }
        }
    }

    public L51(Bb4 bb4, VarTypeList varTypeList) {
        super(bb4, client.cj);
        L51.ea(this, this);
        this.by = new Ma57(varTypeList);
        this.setProperty("targetingVelocity", Float.valueOf(1.0f));
        this.setProperty("targetingAcceleration", Float.valueOf(0.2f));
        this.setProperty("DesiredVelocity", new Vector3(0.0f, 0.0f, 0.0f));
        this.setProperty("TargetCoord", null);
    }
}

