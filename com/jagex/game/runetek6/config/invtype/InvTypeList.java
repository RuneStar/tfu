/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.invtype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.invtype.InvType;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;

public class InvTypeList {
    final js5 configClient;
    final Gd27 game;
    final Language languageId;
    public int num;
    private final Eq28 recentUse = new Eq28(64);

    public InvType list(int n) {
        InvType invType;
        byte[] arrby = this.recentUse;
        synchronized (arrby) {
            invType = (InvType)this.recentUse.g(n);
        }
        if (invType != null) {
            return invType;
        }
        Object object = this.configClient;
        synchronized (object) {
            arrby = this.configClient.getfile(Js5ConfigGroup.INVTYPE.id, n);
        }
        invType = new InvType();
        invType.myId = n;
        if (arrby != null) {
            invType.decode(new Gg3(arrby));
        }
        object = this.recentUse;
        synchronized (object) {
            Eq28.j(this.recentUse, invType, n);
        }
        return invType;
    }

    public InvTypeList(Gd27 gd27, Language language, js5 js52) {
        this.game = gd27;
        this.languageId = language;
        this.configClient = js52;
        this.num = js5.z(this.configClient, Js5ConfigGroup.INVTYPE.id);
    }
}

