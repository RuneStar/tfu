/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.invtype;

import com.jagex.game.runetek6.script.ScriptEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.Kp349;

public class InvType
extends Kp349 {
    private static final boolean debug = true;
    private static final Logger logger = LoggerFactory.getLogger(InvType.class);
    public int myId;
    public int size = 0;

    public String toString() {
        return "{ InvType : " + this.myId + " (size=" + this.size + ") }";
    }

    protected void decode(Gg3 gg3) {
        int n;
        while ((n = Gg3.ar(gg3)) != 0) {
            this.decode(gg3, n);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetSize() {
        return this.size;
    }

    protected void decode(Gg3 gg3, int n) {
        if (n == 2) {
            this.size = Gg3.au(gg3);
        } else {
            logger.info("Error unrecognised .inv config code: {}", n);
        }
    }
}

