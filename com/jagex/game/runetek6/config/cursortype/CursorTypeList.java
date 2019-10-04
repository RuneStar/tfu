/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.cursortype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.cursortype.CursorType;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;

public class CursorTypeList {
    final js5 configClient;
    final Eq28 cursorCache;
    final Gd27 game;
    final Language languageId;
    public int num;
    private final Eq28 recentUse = new Eq28(64);
    final js5 sprites;

    public void cacheClean(int n) {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            this.recentUse.h(n);
        }
        eq28 = this.cursorCache;
        synchronized (eq28) {
            this.cursorCache.h(n);
        }
    }

    public void cacheRemoveSoftReferences() {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            Eq28.b(this.recentUse);
        }
        eq28 = this.cursorCache;
        synchronized (eq28) {
            Eq28.b(this.cursorCache);
        }
    }

    public void cacheReset() {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            Eq28.s(this.recentUse);
        }
        eq28 = this.cursorCache;
        synchronized (eq28) {
            Eq28.s(this.cursorCache);
        }
    }

    public CursorType list(int n) {
        CursorType cursorType;
        byte[] arrby = this.recentUse;
        synchronized (arrby) {
            cursorType = (CursorType)this.recentUse.g(n);
        }
        if (cursorType != null) {
            return cursorType;
        }
        Object object = this.configClient;
        synchronized (object) {
            arrby = this.configClient.getfile(Js5ConfigGroup.CURSORTYPE.id, n);
        }
        cursorType = new CursorType();
        cursorType.myList = this;
        if (arrby != null) {
            cursorType.decode(new Gg3(arrby));
        }
        object = this.recentUse;
        synchronized (object) {
            Eq28.j(this.recentUse, cursorType, n);
        }
        return cursorType;
    }

    public CursorTypeList(Gd27 gd27, Language language, js5 js52, js5 js53) {
        this.cursorCache = new Eq28(2);
        this.game = gd27;
        this.languageId = language;
        this.configClient = js52;
        this.sprites = js53;
        this.num = js5.z(this.configClient, Js5ConfigGroup.CURSORTYPE.id);
    }
}

