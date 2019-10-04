/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.paramtype;

import com.jagex.core.constants.E294;
import com.jagex.core.stringtools.general.J173;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;

public class ParamType {
    private static final boolean debug = true;
    private static final Logger logger = LoggerFactory.getLogger(ParamType.class);
    public boolean autodisable = true;
    public int defaultint;
    public String defaultstr;
    public ScriptVarType type;

    protected void decode(Gg3 gg3, int n) {
        if (n == 1) {
            char c = J173.q(Gg3.ax(gg3));
            this.type = c == 'i' ? ScriptVarType.INT : (c == '1' ? ScriptVarType.BOOLEAN : (c == 'i' ? ScriptVarType.INT : (c == 'd' ? ScriptVarType.GRAPHIC : (c == 's' ? ScriptVarType.STRING : (c == '@' ? ScriptVarType.CURSOR : (c == 'v' ? ScriptVarType.INV : (c == 'o' || c == 'O' ? ScriptVarType.STRING : ScriptVarType.LEGACY)))))));
        } else if (n == 2) {
            this.defaultint = Gg3.bd(gg3);
        } else if (n == 4) {
            this.autodisable = false;
        } else if (n == 5) {
            this.defaultstr = Gg3.bk(gg3);
        } else if (n == 6) {
            this.type = (ScriptVarType)E294.g(ScriptVarType.class, Gg3.ax(gg3));
        } else {
            logger.info("Error unrecognised .param config code: {}", n);
        }
    }

    protected void decode(Gg3 gg3) {
        int n;
        while ((n = Gg3.ar(gg3)) != 0) {
            this.decode(gg3, n);
        }
    }
}

