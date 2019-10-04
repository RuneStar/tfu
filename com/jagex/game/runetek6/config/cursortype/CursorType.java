// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.cursortype;

import org.slf4j.LoggerFactory;
import tfu.Eq28;
import tfu.Fj373;
import tfu.Gg3;
import org.slf4j.Logger;

public class CursorType
{
    private static final boolean debug = true;
    private static final Logger logger;
    public int graphic;
    public int hash32;
    public int hotspotx;
    public int hotspoty;
    protected CursorTypeList myList;
    
    protected void decode(final Gg3 gg3, final int i) {
        if (i == 1) {
            this.graphic = Gg3.bf(gg3);
        }
        else if (i == 2) {
            this.hotspotx = Gg3.ar(gg3);
            this.hotspoty = Gg3.ar(gg3);
        }
        else if (i == 127) {
            this.hash32 = Gg3.bd(gg3);
        }
        else {
            CursorType.logger.info("Error unrecognised .cursor config code: {}", i);
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
    
    public CursorType() {
        this.hash32 = 0;
    }
    
    public synchronized Fj373 getCursor() {
        final Fj373 fj373 = (Fj373)this.myList.cursorCache.g(this.graphic);
        if (fj373 != null) {
            return fj373;
        }
        final Fj373 g = Fj373.g(this.myList.sprites, this.graphic, 0);
        if (g != null) {
            Eq28.j(this.myList.cursorCache, g, this.graphic);
        }
        return g;
    }
    
    static {
        logger = LoggerFactory.getLogger(CursorType.class);
    }
}
