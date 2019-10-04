// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.general;

import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import org.slf4j.LoggerFactory;
import tfu.Gg3;
import org.slf4j.Logger;
import com.jagex.game.runetek6.config.vartype.VarType;

public class VarBasicType extends VarType
{
    private static final Logger logger;
    
    @Override
    public void decode(final Gg3 gg3, final int i) {
        VarBasicType.logger.info("{} not supported for {}!", i, super.domain);
    }
    
    static {
        logger = LoggerFactory.getLogger(VarBasicType.class);
    }
    
    public VarBasicType(final VarDomainType varDomainType, final int n) {
        super(varDomainType, n);
    }
}
