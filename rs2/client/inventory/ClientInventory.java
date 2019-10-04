/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.inventory;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.invtype.InvType;
import com.jagex.game.runetek6.config.invtype.InvTypeList;
import com.jagex.game.runetek6.config.objtype.ObjStackability;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import rs2.client.client;
import tfu.Be2;
import tfu.Bs1;
import tfu.Ln265;
import tfu.Mq489;

public final class ClientInventory
extends Ln265 {
    boolean d = false;
    private final int g;
    private Mq489[] q = new Mq489[]{null};

    ClientInventory(int n) {
        this.g = n;
    }

    public void g(int n, int n2, int n3) {
        if (this.q.length <= n) {
            Mq489[] arrmq489 = new Mq489[n + 1];
            System.arraycopy(this.q, 0, arrmq489, 0, this.q.length);
            this.q = arrmq489;
        }
        if (this.q[n] == null || Mq489.d(this.q[n]) != n2) {
            this.q[n] = new Mq489(n2, n3, client.fi);
        } else {
            Mq489.j(this.q[n], n3);
        }
    }

    public static void d(ClientInventory clientInventory) {
        for (int i = 0; i < clientInventory.q.length; ++i) {
            clientInventory.q[i] = null;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetID() {
        return this.g;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetSlotTotal(int n) {
        if (n < 0 || n >= this.q.length) {
            return 0;
        }
        return Mq489.d(this.q[n]);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetFreeSpace() {
        int n = 0;
        for (int i = 0; i < this.q.length; ++i) {
            if (this.q[i] != null) continue;
            ++n;
        }
        return n += client.fv.list((int)this.g).size - this.q.length;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetTotalParam(int n, int n2, @ScriptID @ScriptDefaults(defaultBoolean=true) boolean bl) {
        int n3 = 0;
        for (int i = 0; i < this.q.length; ++i) {
            if (this.q[i] == null || n != Mq489.d(this.q[i])) continue;
            ObjType objType = client.fa.list(Mq489.d(this.q[i]));
            int n4 = objType.getParam(n2, client.fh.list((int)n2).defaultint);
            if (bl) {
                n3 += Mq489.q(this.q[i]) * n4;
                continue;
            }
            n3 += n4;
        }
        return n3;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetSize() {
        return client.fv.list((int)this.g).size;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetItemName(int n) {
        if (n >= 0 && n < client.fa.num) {
            return client.fa.list((int)n).name;
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetSlotObjVar(int n, String string) {
        if (n >= 0 && n < this.q.length) {
            VarType varType = client.fi.hashLookup(StringTools.l(string));
            if (varType != null) {
                if (varType.domain != VarDomainType.OBJECT) {
                    throw new RuntimeException("'" + string + "' is not an object variable, it's a " + varType.domain.name());
                }
                if (this.q[n] == null) {
                    return client.fi.getDefaultValue(varType.id);
                }
                return this.q[n].getVarValue(varType);
            }
            VarBitType varBitType = client.fl.hashLookup(StringTools.l(string));
            if (varBitType != null) {
                if (varBitType.baseVar.domain != VarDomainType.OBJECT) {
                    throw new RuntimeException("'" + string + "' is not an object varbit, it's a " + varBitType.baseVar.domain.name());
                }
                return this.q[n].getVarBitValue(varBitType);
            }
            throw new RuntimeException("Object variable '" + string + "' not defined");
        }
        throw new RuntimeException("GetSlotObjVar: slot out of range 0 >= " + n + " >= " + this.q.length);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetItemType(int n) {
        if (n < 0 || n >= this.q.length) {
            return -1;
        }
        return Mq489.d(this.q[n]);
    }

    public void q(int n, int n2, Object object) {
        VarBasicType varBasicType;
        if (n >= 0 && n < this.q.length && this.q[n] != null && (varBasicType = client.fi.list(n2)) != null) {
            if (varBasicType.domain != VarDomainType.OBJECT) {
                throw new IllegalStateException("'" + n2 + "' is not an object variable, it's a " + varBasicType.domain.name());
            }
            this.q[n].setVarValue(varBasicType, object);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetItemCount(int n) {
        int n2 = 0;
        for (int i = 0; i < this.q.length; ++i) {
            if (this.q[i] == null || Mq489.d(this.q[i]) != n) continue;
            n2 += Mq489.q(this.q[i]);
        }
        return n2;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean IsItemStackable(int n) {
        if (n >= 0 && n < client.fa.num) {
            return client.fa.list((int)n).stackable != ObjStackability.NEVER;
        }
        return false;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean IsMembersItem(int n) {
        if (n >= 0 && n < client.fa.num) {
            return client.fa.list(n).IsMembers();
        }
        return false;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetItemMultiStacksize(int n) {
        if (n >= 0 && n < client.fa.num) {
            return client.fa.list((int)n).multistacksize;
        }
        return 0;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetItemCost(int n) {
        if (n >= 0 && n < client.fa.num) {
            return client.fa.list((int)n).cost;
        }
        return 0;
    }

    public String toString() {
        String string = super.toString();
        string = string.substring(string.lastIndexOf(64));
        return this.g + (this.d ? " [dead]" : "") + " (" + string + ")";
    }
}

