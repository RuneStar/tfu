/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.player;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerType;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;

public class VarPlayerTypeListClient
extends VarTypeList {
    final js5 configClient;
    private final Eq28 recentUse = new Eq28(64);

    public VarPlayerTypeListClient(Gd27 gd27, VarDomainType varDomainType, Language language, js5 js52) {
        super(gd27, varDomainType, language, js52 != null ? js5.z(js52, varDomainType.getJs5GroupID().id) : 0);
        this.configClient = js52;
    }

    public void cacheReset() {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            Eq28.s(this.recentUse);
        }
    }

    public void cacheClean(int n) {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            this.recentUse.h(n);
        }
    }

    public void cacheRemoveSoftReferences() {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            Eq28.b(this.recentUse);
        }
    }

    @Override
    public VarPlayerType list(int n) {
        VarPlayerType varPlayerType;
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            varPlayerType = (VarPlayerType)this.recentUse.g(n);
            if (varPlayerType == null) {
                byte[] arrby = this.configClient.getfile(this.variableDomain.getJs5GroupID().id, n);
                varPlayerType = new VarPlayerType(this.variableDomain, n);
                if (arrby != null) {
                    varPlayerType.decode(new Gg3(arrby));
                }
                Eq28.j(this.recentUse, varPlayerType, n);
            }
        }
        return varPlayerType;
    }
}

