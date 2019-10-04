/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.cursortype;

import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import com.jagex.js5.js5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Eq28;
import tfu.Fj373;
import tfu.Gg3;

public class CursorType {
    private static final boolean debug = true;
    private static final Logger logger = LoggerFactory.getLogger(CursorType.class);
    public int graphic;
    public int hash32 = 0;
    public int hotspotx;
    public int hotspoty;
    protected CursorTypeList myList;

    protected void decode(Gg3 gg3, int n) {
        if (n == 1) {
            this.graphic = Gg3.bf(gg3);
        } else if (n == 2) {
            this.hotspotx = Gg3.ar(gg3);
            this.hotspoty = Gg3.ar(gg3);
        } else if (n == 127) {
            this.hash32 = Gg3.bd(gg3);
        } else {
            logger.info("Error unrecognised .cursor config code: {}", n);
        }
    }

    protected void decode(Gg3 gg3) {
        int n;
        while ((n = Gg3.ar(gg3)) != 0) {
            this.decode(gg3, n);
        }
    }

    public synchronized Fj373 getCursor() {
        Fj373 fj373 = (Fj373)this.myList.cursorCache.g(this.graphic);
        if (fj373 != null) {
            return fj373;
        }
        fj373 = Fj373.g(this.myList.sprites, this.graphic, 0);
        if (fj373 != null) {
            Eq28.j(this.myList.cursorCache, fj373, this.graphic);
        }
        return fj373;
    }
}

