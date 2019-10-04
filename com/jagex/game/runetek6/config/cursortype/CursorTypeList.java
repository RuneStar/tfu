// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.cursortype;

import tfu.Gg3;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.core.constants.Language;
import tfu.Gd27;
import tfu.Eq28;
import com.jagex.js5.js5;

public class CursorTypeList
{
    final js5 configClient;
    final Eq28 cursorCache;
    final Gd27 game;
    final Language languageId;
    public int num;
    private final Eq28 recentUse;
    final js5 sprites;
    
    public void cacheClean(final int n) {
        synchronized (this.recentUse) {
            this.recentUse.h(n);
        }
        synchronized (this.cursorCache) {
            this.cursorCache.h(n);
        }
    }
    
    public void cacheRemoveSoftReferences() {
        synchronized (this.recentUse) {
            Eq28.b(this.recentUse);
        }
        synchronized (this.cursorCache) {
            Eq28.b(this.cursorCache);
        }
    }
    
    public void cacheReset() {
        synchronized (this.recentUse) {
            Eq28.s(this.recentUse);
        }
        synchronized (this.cursorCache) {
            Eq28.s(this.cursorCache);
        }
    }
    
    public CursorType list(final int n) {
        final CursorType cursorType;
        synchronized (this.recentUse) {
            cursorType = (CursorType)this.recentUse.g(n);
        }
        if (cursorType != null) {
            return cursorType;
        }
        final byte[] getfile;
        synchronized (this.configClient) {
            getfile = this.configClient.getfile(Js5ConfigGroup.CURSORTYPE.id, n);
        }
        final CursorType cursorType2 = new CursorType();
        cursorType2.myList = this;
        if (getfile != null) {
            cursorType2.decode(new Gg3(getfile));
        }
        synchronized (this.recentUse) {
            Eq28.j(this.recentUse, cursorType2, n);
        }
        return cursorType2;
    }
    
    public CursorTypeList(final Gd27 game, final Language languageId, final js5 configClient, final js5 sprites) {
        this.recentUse = new Eq28(64);
        this.cursorCache = new Eq28(2);
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.sprites = sprites;
        this.num = js5.z(this.configClient, Js5ConfigGroup.CURSORTYPE.id);
    }
}
