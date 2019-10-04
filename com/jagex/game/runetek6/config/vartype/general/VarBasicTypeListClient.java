/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.general;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;

public class VarBasicTypeListClient
extends VarTypeList {
    final js5 configClient;
    private final Eq28 recentUse = new Eq28(64);

    @Override
    public VarBasicType list(int n) {
        VarBasicType varBasicType;
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            varBasicType = (VarBasicType)this.recentUse.g(n);
            if (varBasicType == null) {
                byte[] arrby = this.configClient.getfile(this.variableDomain.getJs5GroupID().id, n);
                varBasicType = new VarBasicType(this.variableDomain, n);
                if (arrby != null) {
                    varBasicType.decode(new Gg3(arrby));
                }
                Eq28.j(this.recentUse, varBasicType, n);
            }
        }
        return varBasicType;
    }

    public void cacheClean(int n) {
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            this.recentUse.h(n);
        }
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

    public VarBasicTypeListClient(Gd27 gd27, VarDomainType varDomainType, Language language, js5 js52) {
        super(gd27, varDomainType, language, js52 != null ? js5.z(js52, varDomainType.getJs5GroupID().id) : 0);
        this.configClient = js52;
    }
}

