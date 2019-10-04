// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.general;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import tfu.Gd27;
import com.jagex.game.runetek6.config.vartype.VarType;
import tfu.Gg3;
import tfu.Eq28;
import com.jagex.js5.js5;
import com.jagex.game.runetek6.config.vartype.VarTypeList;

public class VarBasicTypeListClient extends VarTypeList
{
    final js5 configClient;
    private final Eq28 recentUse;
    
    @Override
    public VarBasicType list(final int n) {
        VarBasicType varBasicType;
        synchronized (this.recentUse) {
            varBasicType = (VarBasicType)this.recentUse.g(n);
            if (varBasicType == null) {
                final byte[] getfile = this.configClient.getfile(super.variableDomain.getJs5GroupID().id, n);
                varBasicType = new VarBasicType(super.variableDomain, n);
                if (getfile != null) {
                    varBasicType.decode(new Gg3(getfile));
                }
                Eq28.j(this.recentUse, varBasicType, n);
            }
        }
        return varBasicType;
    }
    
    public void cacheClean(final int n) {
        synchronized (this.recentUse) {
            this.recentUse.h(n);
        }
    }
    
    public void cacheReset() {
        synchronized (this.recentUse) {
            Eq28.s(this.recentUse);
        }
    }
    
    public void cacheRemoveSoftReferences() {
        synchronized (this.recentUse) {
            Eq28.b(this.recentUse);
        }
    }
    
    public VarBasicTypeListClient(final Gd27 gd27, final VarDomainType varDomainType, final Language language, final js5 configClient) {
        super(gd27, varDomainType, language, (configClient != null) ? js5.z(configClient, varDomainType.getJs5GroupID().id) : 0);
        this.recentUse = new Eq28(64);
        this.configClient = configClient;
    }
}
