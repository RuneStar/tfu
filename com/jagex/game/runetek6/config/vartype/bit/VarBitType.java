/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.bit;

import com.jagex.core.constants.E294;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeEncodingKey;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;
import tfu.Gp293;

public class VarBitType
implements Gp293 {
    private static final boolean debug = true;
    private static final Logger logger = LoggerFactory.getLogger(VarBitType.class);
    private static int[] masklookup = new int[32];
    public VarType baseVar;
    public String debugName;
    public int debugNameHash32;
    public int endBit;
    public int id;
    public VarBitTypeListClient myList;
    public int startBit;

    protected void decode(Gg3 gg3, int n, boolean bl) {
        VarBitTypeEncodingKey varBitTypeEncodingKey = (VarBitTypeEncodingKey)E294.d(VarBitTypeEncodingKey.values(), n);
        switch (varBitTypeEncodingKey) {
            case BASEVAR: {
                int n2 = Gg3.ar(gg3);
                VarDomainType varDomainType = (VarDomainType)E294.d(VarDomainType.values(), n2);
                if (varDomainType == null) {
                    throw new IllegalStateException("Unknown domain ID loading VarType definition: " + n2);
                }
                int n3 = Gg3.bf(gg3);
                VarTypeList varTypeList = (VarTypeList)this.myList.listContainer.get(varDomainType);
                if (varTypeList != null) {
                    this.baseVar = varTypeList.list(n3);
                    break;
                }
                if (bl) break;
                throw new IllegalStateException("Unlisted domain loading VarBitType definition: " + varDomainType);
            }
            case BITS: {
                this.startBit = Gg3.ar(gg3);
                this.endBit = Gg3.ar(gg3);
                break;
            }
            case VARBITNAME_HASH32: {
                this.debugNameHash32 = Gg3.bd(gg3);
                break;
            }
            default: {
                logger.info("Error unrecognised .varbit config code: {}", n);
            }
        }
    }

    protected void decode(Gg3 gg3, boolean bl) {
        int n;
        while ((n = Gg3.ar(gg3)) != 0) {
            this.decode(gg3, n, bl);
        }
    }

    public int getVarbitValue(int n) {
        int n2 = masklookup[this.endBit - this.startBit];
        return n >> this.startBit & n2;
    }

    public int setVarbitValue(int n, int n2) throws VarBitOverflowException {
        int n3 = masklookup[this.endBit - this.startBit];
        if (n2 < 0 || n2 > n3) {
            throw new VarBitOverflowException(this.debugName, n2, n3);
        }
        return n & ~(n3 <<= this.startBit) | n2 << this.startBit & n3;
    }

    @Override
    public boolean isValidDefinition() {
        return this.myList != null && this.baseVar != null;
    }

    static {
        int n = 2;
        for (int i = 0; i < 32; ++i) {
            VarBitType.masklookup[i] = n - 1;
            n += n;
        }
    }
}

