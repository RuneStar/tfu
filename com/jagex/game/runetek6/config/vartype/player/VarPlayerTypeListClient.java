// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.player;

import tfu.Gg3;
import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import tfu.Gd27;
import com.jagex.game.runetek6.config.vartype.VarType;
import tfu.Eq28;
import com.jagex.js5.js5;
import com.jagex.game.runetek6.config.vartype.VarTypeList;

public class VarPlayerTypeListClient extends VarTypeList
{
    final js5 configClient;
    private final Eq28 recentUse;
    
    public VarPlayerTypeListClient(final Gd27 gd27, final VarDomainType varDomainType, final Language language, final js5 configClient) {
        super(gd27, varDomainType, language, (configClient != null) ? js5.z(configClient, varDomainType.getJs5GroupID().id) : 0);
        this.recentUse = new Eq28(64);
        this.configClient = configClient;
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
    
    @Override
    public VarPlayerType list(final int n) {
        VarPlayerType varPlayerType;
        synchronized (this.recentUse) {
            varPlayerType = (VarPlayerType)this.recentUse.g(n);
            if (varPlayerType == null) {
                final byte[] getfile = this.configClient.getfile(super.variableDomain.getJs5GroupID().id, n);
                varPlayerType = new VarPlayerType(super.variableDomain, n);
                if (getfile != null) {
                    varPlayerType.decode(new Gg3(getfile));
                }
                Eq28.j(this.recentUse, varPlayerType, n);
            }
        }
        return varPlayerType;
    }
}
