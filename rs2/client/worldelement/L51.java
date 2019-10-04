// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import tfu.Kf58;
import tfu.Ma57;
import rs2.client.client;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import tfu.Bb4;
import tfu.Kh56;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.gameentity.G55;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.maths.Vector3;
import com.jagex.maths.E41;
import tfu.Mn54;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.variables.G53;
import tfu.An52;
import com.jagex.game.runetek6.gameentity.GameEntity;

public abstract class L51 extends GameEntity implements An52, G53, VarDomain
{
    public int bh;
    public int bj;
    public int bk;
    public int bl;
    public boolean bp;
    public int bw;
    public boolean bx;
    public final Mn54 by;
    
    public abstract E41 bc();
    
    @Override
    public Vector3 e() {
        final E41 bc = this.bc();
        return Vector3.g(bc.j, bc.e, bc.h);
    }
    
    public int bz() {
        return this.bl;
    }
    
    @Override
    public boolean canModifyVarValue(final VarType varType) {
        return true;
    }
    
    @Override
    public int getVarValueInt(final VarType varType) {
        return this.by.d(varType.id);
    }
    
    @Override
    public long getVarValueLong(final VarType varType) {
        return this.by.j(varType.id);
    }
    
    @Override
    public Object getVarValue(final VarType varType) {
        return this.by.h(varType.id);
    }
    
    @Override
    public int getVarBitValue(final VarBitType varBitType) {
        return varBitType.getVarbitValue(this.getVarValueInt(varBitType.baseVar));
    }
    
    @Override
    public void setVarValueInt(final VarType varType, final int i) {
        if (this.by.d(varType.id) != i) {
            this.by.q(varType.id, i);
            final Integer s = G55.s(super.ce, varType.debugNameHash32);
            if (s != null) {
                this.triggerEvent(s, i);
            }
        }
    }
    
    @Override
    public void setVarValueLong(final VarType varType, final long l) {
        if (this.by.d(varType.id) != l) {
            this.by.e(varType.id, l);
            final Integer s = G55.s(super.ce, varType.debugNameHash32);
            if (s != null) {
                this.triggerEvent(s, l);
            }
        }
    }
    
    public static void ez(final L51 l51, final int bl) {
        l51.bl = bl;
    }
    
    @Override
    public Vector3 j() {
        final E41 bc = this.bc();
        return Vector3.g(bc.g, bc.d, bc.q);
    }
    
    @Override
    public void setVarBitValue(final VarBitType varBitType, final int n) throws VarBitOverflowException {
        this.setVarValueInt(varBitType.baseVar, varBitType.setVarbitValue(this.getVarValueInt(varBitType.baseVar), n));
    }
    
    @Override
    public void setVarValue(final VarType varType, final Object o) {
        if (!Kh56.g(this.by.d(varType.id), o)) {
            this.by.s(varType.id, o);
            final Integer s = G55.s(super.ce, varType.debugNameHash32);
            if (s != null) {
                this.triggerEvent(s, o);
            }
        }
    }
    
    public L51(final Bb4 bb4, final VarTypeList list) {
        super(bb4, client.cj);
        this.bl = 1;
        this.bw = -1000;
        this.bp = false;
        this.bx = false;
        GameEntity.ea(this, this);
        this.by = new Ma57(list);
        this.setProperty("targetingVelocity", 1.0f);
        this.setProperty("targetingAcceleration", 0.2f);
        this.setProperty("DesiredVelocity", new Vector3(0.0f, 0.0f, 0.0f));
        this.setProperty("TargetCoord", null);
    }
}
