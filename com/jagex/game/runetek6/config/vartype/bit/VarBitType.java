// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.bit;

import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.core.constants.J204;
import com.jagex.core.constants.E294;
import tfu.Gg3;
import com.jagex.game.runetek6.config.vartype.VarType;
import org.slf4j.Logger;
import tfu.Gp293;

public class VarBitType implements Gp293
{
    private static final boolean debug = true;
    private static final Logger logger;
    private static int[] masklookup;
    public VarType baseVar;
    public String debugName;
    public int debugNameHash32;
    public int endBit;
    public int id;
    public VarBitTypeListClient myList;
    public int startBit;
    
    protected void decode(final Gg3 gg3, final int i, final boolean b) {
        switch (VarBitType$1.$SwitchMap$com$jagex$game$runetek6$config$vartype$bit$VarBitTypeEncodingKey[((VarBitTypeEncodingKey)E294.d(VarBitTypeEncodingKey.values(), i)).ordinal()]) {
            case 1: {
                final int ar = Gg3.ar(gg3);
                final VarDomainType obj = (VarDomainType)E294.d(VarDomainType.values(), ar);
                if (obj == null) {
                    throw new IllegalStateException("Unknown domain ID loading VarType definition: " + ar);
                }
                final int bf = Gg3.bf(gg3);
                final VarTypeList list = this.myList.listContainer.get(obj);
                if (list != null) {
                    this.baseVar = list.list(bf);
                    break;
                }
                if (!b) {
                    throw new IllegalStateException("Unlisted domain loading VarBitType definition: " + obj);
                }
                break;
            }
            case 2: {
                this.startBit = Gg3.ar(gg3);
                this.endBit = Gg3.ar(gg3);
                break;
            }
            case 3: {
                this.debugNameHash32 = Gg3.bd(gg3);
                break;
            }
            default: {
                VarBitType.logger.info("Error unrecognised .varbit config code: {}", i);
                break;
            }
        }
    }
    
    protected void decode(final Gg3 gg3, final boolean b) {
        while (true) {
            final int ar = Gg3.ar(gg3);
            if (ar == 0) {
                break;
            }
            this.decode(gg3, ar, b);
        }
    }
    
    public int getVarbitValue(final int n) {
        return n >> this.startBit & VarBitType.masklookup[this.endBit - this.startBit];
    }
    
    public int setVarbitValue(final int n, final int n2) throws VarBitOverflowException {
        final int n3 = VarBitType.masklookup[this.endBit - this.startBit];
        if (n2 < 0 || n2 > n3) {
            throw new VarBitOverflowException(this.debugName, n2, n3);
        }
        final int n4 = n3 << this.startBit;
        return (n & ~n4) | (n2 << this.startBit & n4);
    }
    
    @Override
    public boolean isValidDefinition() {
        return this.myList != null && this.baseVar != null;
    }
    
    static {
        logger = LoggerFactory.getLogger(VarBitType.class);
        VarBitType.masklookup = new int[32];
        int n = 2;
        for (int i = 0; i < 32; ++i) {
            VarBitType.masklookup[i] = n - 1;
            n += n;
        }
    }
}
