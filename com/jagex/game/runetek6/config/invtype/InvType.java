// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.invtype;

import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Gg3;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import tfu.Kp349;

public class InvType extends Kp349
{
    private static final boolean debug = true;
    private static final Logger logger;
    public int myId;
    public int size;
    
    @Override
    public String toString() {
        return "{ InvType : " + this.myId + " (size=" + this.size + ") }";
    }
    
    static {
        logger = LoggerFactory.getLogger(InvType.class);
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
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetSize() {
        return this.size;
    }
    
    public InvType() {
        this.size = 0;
    }
    
    protected void decode(final Gg3 gg3, final int i) {
        if (i == 2) {
            this.size = Gg3.au(gg3);
        }
        else {
            InvType.logger.info("Error unrecognised .inv config code: {}", i);
        }
    }
}
