// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.paramtype;

import tfu.Gg3;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import tfu.Eq28;
import com.jagex.core.constants.Language;
import tfu.Gd27;
import com.jagex.js5.js5;

public class ParamTypeList
{
    final js5 configClient;
    final Gd27 game;
    final Language languageId;
    public int num;
    private final Eq28 recentUse;
    
    public void cacheClean(final int n) {
        synchronized (this.recentUse) {
            this.recentUse.h(n);
        }
    }
    
    public ParamType list(final int n) {
        final ParamType paramType;
        synchronized (this.recentUse) {
            paramType = (ParamType)this.recentUse.g(n);
        }
        if (paramType != null) {
            return paramType;
        }
        final byte[] getfile;
        synchronized (this.configClient) {
            getfile = this.configClient.getfile(Js5ConfigGroup.PARAMTYPE.id, n);
        }
        final ParamType paramType2 = new ParamType();
        if (getfile != null) {
            paramType2.decode(new Gg3(getfile));
        }
        synchronized (this.recentUse) {
            Eq28.j(this.recentUse, paramType2, n);
        }
        return paramType2;
    }
    
    public ParamTypeList(final Gd27 game, final Language languageId, final js5 configClient) {
        this.recentUse = new Eq28(64);
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        if (this.configClient != null) {
            this.num = js5.z(this.configClient, Js5ConfigGroup.PARAMTYPE.id);
        }
        else {
            this.num = 0;
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
}
