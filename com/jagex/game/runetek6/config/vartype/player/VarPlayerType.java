/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.player;

import com.jagex.core.constants.E294;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeEncodingKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;

public class VarPlayerType
extends VarType {
    private static final Logger logger = LoggerFactory.getLogger(VarPlayerType.class);
    public int clientCode;

    @Override
    public void decode(Gg3 gg3, int n) {
        VarPlayerTypeEncodingKey varPlayerTypeEncodingKey = (VarPlayerTypeEncodingKey)E294.d(VarPlayerTypeEncodingKey.values(), n);
        if (varPlayerTypeEncodingKey == VarPlayerTypeEncodingKey.CLIENTCODE) {
            this.clientCode = Gg3.au(gg3);
        } else {
            logger.info("Error: Unrecognised config code: {} for domain {}", n, (Object)this.domain);
        }
    }

    public VarPlayerType(VarDomainType varDomainType, int n) {
        super(varDomainType, n);
    }
}

