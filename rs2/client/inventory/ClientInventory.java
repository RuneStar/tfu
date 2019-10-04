// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.inventory;

import com.jagex.game.runetek6.config.objtype.ObjStackability;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptID;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import rs2.client.client;
import tfu.Mq489;
import tfu.Ln265;

public final class ClientInventory extends Ln265
{
    boolean d;
    private final int g;
    private Mq489[] q;
    
    ClientInventory(final int g) {
        this.d = false;
        this.q = new Mq489[] { null };
        this.g = g;
    }
    
    public void g(final int n, final int n2, final int n3) {
        if (this.q.length <= n) {
            final Mq489[] q = new Mq489[n + 1];
            System.arraycopy(this.q, 0, q, 0, this.q.length);
            this.q = q;
        }
        if (this.q[n] == null || Mq489.d(this.q[n]) != n2) {
            this.q[n] = new Mq489(n2, n3, client.fi);
        }
        else {
            Mq489.j(this.q[n], n3);
        }
    }
    
    public static void d(final ClientInventory clientInventory) {
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
    public int GetSlotTotal(final int n) {
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
            if (this.q[i] == null) {
                ++n;
            }
        }
        return n + (client.fv.list(this.g).size - this.q.length);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetTotalParam(final int n, final int n2, @ScriptID @ScriptDefaults(defaultBoolean = true) final boolean b) {
        int n3 = 0;
        for (int i = 0; i < this.q.length; ++i) {
            if (this.q[i] != null && n == Mq489.d(this.q[i])) {
                final int param = client.fa.list(Mq489.d(this.q[i])).getParam(n2, client.fh.list(n2).defaultint);
                if (b) {
                    n3 += Mq489.q(this.q[i]) * param;
                }
                else {
                    n3 += param;
                }
            }
        }
        return n3;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetSize() {
        return client.fv.list(this.g).size;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetItemName(final int n) {
        if (n >= 0 && n < client.fa.num) {
            return client.fa.list(n).name;
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetSlotObjVar(final int i, final String str) {
        if (i < 0 || i >= this.q.length) {
            throw new RuntimeException("GetSlotObjVar: slot out of range 0 >= " + i + " >= " + this.q.length);
        }
        final VarType hashLookup = client.fi.hashLookup(StringTools.l(str));
        if (hashLookup != null) {
            if (hashLookup.domain != VarDomainType.OBJECT) {
                throw new RuntimeException("'" + str + "' is not an object variable, it's a " + hashLookup.domain.name());
            }
            if (this.q[i] == null) {
                return client.fi.getDefaultValue(hashLookup.id);
            }
            return this.q[i].getVarValue(hashLookup);
        }
        else {
            final VarBitType hashLookup2 = client.fl.hashLookup(StringTools.l(str));
            if (hashLookup2 == null) {
                throw new RuntimeException("Object variable '" + str + "' not defined");
            }
            if (hashLookup2.baseVar.domain != VarDomainType.OBJECT) {
                throw new RuntimeException("'" + str + "' is not an object varbit, it's a " + hashLookup2.baseVar.domain.name());
            }
            return this.q[i].getVarBitValue(hashLookup2);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetItemType(final int n) {
        if (n < 0 || n >= this.q.length) {
            return -1;
        }
        return Mq489.d(this.q[n]);
    }
    
    public void q(final int n, final int i, final Object o) {
        if (n >= 0 && n < this.q.length && this.q[n] != null) {
            final VarBasicType list = client.fi.list(i);
            if (list != null) {
                if (list.domain != VarDomainType.OBJECT) {
                    throw new IllegalStateException("'" + i + "' is not an object variable, it's a " + list.domain.name());
                }
                this.q[n].setVarValue(list, o);
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetItemCount(final int n) {
        int n2 = 0;
        for (int i = 0; i < this.q.length; ++i) {
            if (this.q[i] != null && Mq489.d(this.q[i]) == n) {
                n2 += Mq489.q(this.q[i]);
            }
        }
        return n2;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean IsItemStackable(final int n) {
        return n >= 0 && n < client.fa.num && client.fa.list(n).stackable != ObjStackability.NEVER;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean IsMembersItem(final int n) {
        return n >= 0 && n < client.fa.num && client.fa.list(n).IsMembers();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetItemMultiStacksize(final int n) {
        if (n >= 0 && n < client.fa.num) {
            return client.fa.list(n).multistacksize;
        }
        return 0;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetItemCost(final int n) {
        if (n >= 0 && n < client.fa.num) {
            return client.fa.list(n).cost;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        final String string = super.toString();
        return this.g + (this.d ? " [dead]" : "") + " (" + string.substring(string.lastIndexOf(64)) + ")";
    }
}
