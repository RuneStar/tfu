/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.general;

import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;

public class VarBasicType
extends VarType {
    private static final Logger logger = LoggerFactory.getLogger(VarBasicType.class);

    @Override
    public void decode(Gg3 gg3, int n) {
        logger.info("{} not supported for {}!", n, (Object)this.domain);
    }

    public VarBasicType(VarDomainType varDomainType, int n) {
        super(varDomainType, n);
    }
}

