/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.paramtype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;

public class ParamTypeList {
    final js5 configClient;
    final Gd27 game;
    final Language languageId;
    public int num;
    private final Eq28 recentUse = new Eq28(64);

    public void cacheClean(int n) {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            this.recentUse.h(n);
        }
    }

    public ParamType list(int n) {
        ParamType paramType;
        byte[] arrby = this.recentUse;
        synchronized (arrby) {
            paramType = (ParamType)this.recentUse.g(n);
        }
        if (paramType != null) {
            return paramType;
        }
        Object object = this.configClient;
        synchronized (object) {
            arrby = this.configClient.getfile(Js5ConfigGroup.PARAMTYPE.id, n);
        }
        paramType = new ParamType();
        if (arrby != null) {
            paramType.decode(new Gg3(arrby));
        }
        object = this.recentUse;
        synchronized (object) {
            Eq28.j(this.recentUse, paramType, n);
        }
        return paramType;
    }

    public ParamTypeList(Gd27 gd27, Language language, js5 js52) {
        this.game = gd27;
        this.languageId = language;
        this.configClient = js52;
        this.num = this.configClient != null ? js5.z(this.configClient, Js5ConfigGroup.PARAMTYPE.id) : 0;
    }

    public void cacheReset() {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            Eq28.s(this.recentUse);
        }
    }

    public void cacheRemoveSoftReferences() {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            Eq28.b(this.recentUse);
        }
    }
}

