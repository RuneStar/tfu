// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.invtype;

import tfu.Gg3;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import tfu.Eq28;
import com.jagex.core.constants.Language;
import tfu.Gd27;
import com.jagex.js5.js5;

public class InvTypeList
{
    final js5 configClient;
    final Gd27 game;
    final Language languageId;
    public int num;
    private final Eq28 recentUse;
    
    public InvType list(final int myId) {
        final InvType invType;
        synchronized (this.recentUse) {
            invType = (InvType)this.recentUse.g(myId);
        }
        if (invType != null) {
            return invType;
        }
        final byte[] getfile;
        synchronized (this.configClient) {
            getfile = this.configClient.getfile(Js5ConfigGroup.INVTYPE.id, myId);
        }
        final InvType invType2 = new InvType();
        invType2.myId = myId;
        if (getfile != null) {
            invType2.decode(new Gg3(getfile));
        }
        synchronized (this.recentUse) {
            Eq28.j(this.recentUse, invType2, myId);
        }
        return invType2;
    }
    
    public InvTypeList(final Gd27 game, final Language languageId, final js5 configClient) {
        this.recentUse = new Eq28(64);
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.num = js5.z(this.configClient, Js5ConfigGroup.INVTYPE.id);
    }
}
