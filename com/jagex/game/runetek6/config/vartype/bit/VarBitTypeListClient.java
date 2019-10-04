/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.bit;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.js5.js5;
import java.util.HashMap;
import java.util.Map;
import tfu.Eq28;
import tfu.Ff259;
import tfu.Gd27;
import tfu.Gg3;

public class VarBitTypeListClient
extends Ff259 {
    public static final int DEFAULT_CACHE_SIZE = 64;
    final js5 configClient;
    private Map hashLookup = null;
    final Map listContainer;
    private Eq28 recentUse = new Eq28(64);

    public VarBitTypeListClient(Gd27 gd27, Language language, js5 js52, Map map) {
        super(gd27, language, js52 != null ? js5.z(js52, Js5ConfigGroup.VAR_BIT.id) : 0);
        this.configClient = js52;
        this.listContainer = map;
    }

    public VarBitType list(int n) {
        VarBitType varBitType;
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            varBitType = (VarBitType)this.recentUse.g(n);
            if (varBitType == null) {
                byte[] arrby = this.configClient.getfile(Js5ConfigGroup.VAR_BIT.id, n);
                varBitType = new VarBitType();
                varBitType.id = n;
                varBitType.myList = this;
                if (arrby != null) {
                    varBitType.decode(new Gg3(arrby), false);
                }
                Eq28.j(this.recentUse, varBitType, n);
            }
        }
        return varBitType;
    }

    public void createHashMapLookup() {
        this.hashLookup = new HashMap();
        for (int i = 0; i < this.q; ++i) {
            VarBitType varBitType = this.list_uncached(i);
            if (varBitType.debugNameHash32 == 0) continue;
            this.hashLookup.put(varBitType.debugNameHash32, i);
        }
    }

    public VarBitType list_uncached(int n) {
        VarBitType varBitType;
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            varBitType = (VarBitType)this.recentUse.g(n);
            if (varBitType == null) {
                byte[] arrby = this.configClient.getfile(Js5ConfigGroup.VAR_BIT.id, n);
                varBitType = new VarBitType();
                varBitType.id = n;
                varBitType.myList = this;
                if (arrby != null) {
                    varBitType.decode(new Gg3(arrby), true);
                    if (varBitType.myList == null) {
                        return null;
                    }
                }
            }
        }
        return varBitType;
    }

    public VarBitType hashLookup(int n) {
        if (this.hashLookup.containsKey(n)) {
            return this.list((Integer)this.hashLookup.get(n));
        }
        return null;
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
}

