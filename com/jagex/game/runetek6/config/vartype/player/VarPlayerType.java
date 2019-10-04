// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.player;

import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.core.constants.J204;
import com.jagex.core.constants.E294;
import tfu.Gg3;
import org.slf4j.Logger;
import com.jagex.game.runetek6.config.vartype.VarType;

public class VarPlayerType extends VarType
{
    private static final Logger logger;
    public int clientCode;
    
    @Override
    public void decode(final Gg3 gg3, final int i) {
        if (E294.d(VarPlayerTypeEncodingKey.values(), i) == VarPlayerTypeEncodingKey.CLIENTCODE) {
            this.clientCode = Gg3.au(gg3);
        }
        else {
            VarPlayerType.logger.info("Error: Unrecognised config code: {} for domain {}", i, super.domain);
        }
    }
    
    public VarPlayerType(final VarDomainType varDomainType, final int n) {
        super(varDomainType, n);
    }
    
    static {
        logger = LoggerFactory.getLogger(VarPlayerType.class);
    }
}
