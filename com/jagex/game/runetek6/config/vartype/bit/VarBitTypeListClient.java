// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.bit;

import java.util.HashMap;
import tfu.Gg3;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.core.constants.Language;
import tfu.Gd27;
import tfu.Eq28;
import java.util.Map;
import com.jagex.js5.js5;
import tfu.Ff259;

public class VarBitTypeListClient extends Ff259
{
    public static final int DEFAULT_CACHE_SIZE = 64;
    final js5 configClient;
    private Map hashLookup;
    final Map listContainer;
    private Eq28 recentUse;
    
    public VarBitTypeListClient(final Gd27 gd27, final Language language, final js5 configClient, final Map listContainer) {
        super(gd27, language, (configClient != null) ? js5.z(configClient, Js5ConfigGroup.VAR_BIT.id) : 0);
        this.recentUse = new Eq28(64);
        this.hashLookup = null;
        this.configClient = configClient;
        this.listContainer = listContainer;
    }
    
    public VarBitType list(final int id) {
        VarBitType varBitType;
        synchronized (this.recentUse) {
            varBitType = (VarBitType)this.recentUse.g(id);
            if (varBitType == null) {
                final byte[] getfile = this.configClient.getfile(Js5ConfigGroup.VAR_BIT.id, id);
                varBitType = new VarBitType();
                varBitType.id = id;
                varBitType.myList = this;
                if (getfile != null) {
                    varBitType.decode(new Gg3(getfile), false);
                }
                Eq28.j(this.recentUse, varBitType, id);
            }
        }
        return varBitType;
    }
    
    public void createHashMapLookup() {
        this.hashLookup = new HashMap();
        for (int i = 0; i < super.q; ++i) {
            final VarBitType list_uncached = this.list_uncached(i);
            if (list_uncached.debugNameHash32 != 0) {
                this.hashLookup.put(list_uncached.debugNameHash32, i);
            }
        }
    }
    
    public VarBitType list_uncached(final int id) {
        VarBitType varBitType;
        synchronized (this.recentUse) {
            varBitType = (VarBitType)this.recentUse.g(id);
            if (varBitType == null) {
                final byte[] getfile = this.configClient.getfile(Js5ConfigGroup.VAR_BIT.id, id);
                varBitType = new VarBitType();
                varBitType.id = id;
                varBitType.myList = this;
                if (getfile != null) {
                    varBitType.decode(new Gg3(getfile), true);
                    if (varBitType.myList == null) {
                        return null;
                    }
                }
            }
        }
        return varBitType;
    }
    
    public VarBitType hashLookup(final int n) {
        if (this.hashLookup.containsKey(n)) {
            return this.list(this.hashLookup.get(n));
        }
        return null;
    }
    
    public void cacheReset() {
        synchronized (this.recentUse) {
            Eq28.s(this.recentUse);
        }
    }
    
    public void cacheClean(final int n) {
        synchronized (this.recentUse) {
            this.recentUse.h(n);
        }
    }
    
    public void cacheRemoveSoftReferences() {
        synchronized (this.recentUse) {
            Eq28.b(this.recentUse);
        }
    }
}
