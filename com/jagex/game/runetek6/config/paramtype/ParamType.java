// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.paramtype;

import org.slf4j.LoggerFactory;
import com.jagex.core.constants.E294;
import com.jagex.core.stringtools.general.J173;
import tfu.Gg3;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import org.slf4j.Logger;

public class ParamType
{
    private static final boolean debug = true;
    private static final Logger logger;
    public boolean autodisable;
    public int defaultint;
    public String defaultstr;
    public ScriptVarType type;
    
    protected void decode(final Gg3 gg3, final int i) {
        if (i == 1) {
            final char q = J173.q(Gg3.ax(gg3));
            if (q == 'i') {
                this.type = ScriptVarType.INT;
            }
            else if (q == '1') {
                this.type = ScriptVarType.BOOLEAN;
            }
            else if (q == 'i') {
                this.type = ScriptVarType.INT;
            }
            else if (q == 'd') {
                this.type = ScriptVarType.GRAPHIC;
            }
            else if (q == 's') {
                this.type = ScriptVarType.STRING;
            }
            else if (q == '@') {
                this.type = ScriptVarType.CURSOR;
            }
            else if (q == 'v') {
                this.type = ScriptVarType.INV;
            }
            else if (q == 'o' || q == 'O') {
                this.type = ScriptVarType.STRING;
            }
            else {
                this.type = ScriptVarType.LEGACY;
            }
        }
        else if (i == 2) {
            this.defaultint = Gg3.bd(gg3);
        }
        else if (i == 4) {
            this.autodisable = false;
        }
        else if (i == 5) {
            this.defaultstr = Gg3.bk(gg3);
        }
        else if (i == 6) {
            this.type = (ScriptVarType)E294.g(ScriptVarType.class, Gg3.ax(gg3));
        }
        else {
            ParamType.logger.info("Error unrecognised .param config code: {}", i);
        }
    }
    
    protected void decode(final Gg3 gg3) {
        while (true) {
            final int ar = Gg3.ar(gg3);
            if (ar == 0) {
                break;
            }
            this.decode(gg3, ar);
        }
    }
    
    public ParamType() {
        this.autodisable = true;
    }
    
    static {
        logger = LoggerFactory.getLogger(ParamType.class);
    }
}
