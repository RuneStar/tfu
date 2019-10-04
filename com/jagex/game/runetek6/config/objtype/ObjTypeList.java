// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.objtype;

import tfu.Ln265;
import tfu.Ha262;
import tfu.Mk163;
import tfu.Gg3;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import tfu.Eq28;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.core.constants.Language;
import tfu.Gd27;
import com.jagex.js5.js5;

public class ObjTypeList
{
    boolean allowMembers;
    final js5 configClient;
    protected final String[] defaultIOps;
    protected final String[] defaultOps;
    final Gd27 game;
    final Language languageId;
    final js5 meshes;
    public int num;
    final ParamTypeList paramTL;
    private final Eq28 recentUse;
    
    public ObjType list(final int myid) {
        final ObjType objType;
        synchronized (this.recentUse) {
            objType = (ObjType)this.recentUse.g(myid);
        }
        if (objType != null) {
            return objType;
        }
        final byte[] getfile;
        synchronized (this.configClient) {
            getfile = this.configClient.getfile(Js5ConfigGroup.OBJTYPE.getClientGroupId(myid), Js5ConfigGroup.OBJTYPE.getClientFileId(myid));
        }
        final ObjType objType2 = new ObjType();
        objType2.myList = this;
        objType2.myid = myid;
        objType2.op = this.defaultOps.clone();
        objType2.iop = this.defaultIOps.clone();
        if (getfile != null) {
            objType2.decode(new Gg3(getfile));
        }
        objType2.postDecode();
        if (objType2.certtemplate != -1) {
            objType2.genCert(this.list(objType2.certtemplate), this.list(objType2.certlink));
        }
        if (objType2.lenttemplate != -1) {
            objType2.genLent(this.list(objType2.lenttemplate), this.list(objType2.lentlink));
        }
        if (objType2.boughttemplate != -1) {
            objType2.genBought(this.list(objType2.boughttemplate), this.list(objType2.boughtlink));
        }
        if (!this.allowMembers && objType2.members) {
            objType2.name = Mk163.g(Mk163.MEMBERS_OBJECT, this.languageId);
            objType2.team = 0;
            objType2.op = this.defaultOps;
            objType2.iop = this.defaultIOps;
            objType2.stockmarket = false;
            if (objType2.params != null) {
                boolean b = false;
                for (Ln265 ln265 = Ha262.e(objType2.params); ln265 != null; ln265 = Ha262.h(objType2.params)) {
                    if (this.paramTL.list((int)ln265.bq).autodisable) {
                        Ln265.ef(ln265);
                    }
                    else {
                        b = true;
                    }
                }
                if (!b) {
                    objType2.params = null;
                }
            }
        }
        synchronized (this.recentUse) {
            Eq28.j(this.recentUse, objType2, myid);
        }
        return objType2;
    }
    
    public void cacheRemoveSoftReferences() {
        Eq28.b(this.recentUse);
    }
    
    public void setAllowMembers(final boolean allowMembers) {
        if (allowMembers == this.allowMembers) {
            return;
        }
        this.allowMembers = allowMembers;
        this.cacheReset();
    }
    
    public void cacheReset() {
        Eq28.s(this.recentUse);
    }
    
    public void cacheClean(final int n) {
        this.recentUse.h(n);
    }
    
    public ObjTypeList(final Gd27 game, final Language languageId, final boolean allowMembers, final ParamTypeList paramTL, final js5 configClient, final js5 meshes) {
        this.recentUse = new Eq28(128);
        this.game = game;
        this.languageId = languageId;
        this.allowMembers = allowMembers;
        this.paramTL = paramTL;
        this.configClient = configClient;
        this.meshes = meshes;
        if (this.configClient != null) {
            final int n = js5.t(this.configClient) - 1;
            this.num = n * Js5ConfigGroup.OBJTYPE.getGroupSize() + js5.z(this.configClient, n);
        }
        else {
            this.num = 0;
        }
        if (this.game == Gd27.RUNESCAPE) {
            this.defaultOps = new String[] { null, null, Mk163.g(Mk163.TAKE, this.languageId), null, null, Mk163.g(Mk163.EXAMINE, this.languageId) };
        }
        else {
            this.defaultOps = new String[] { null, null, Mk163.g(Mk163.TAKE, this.languageId), null, null, null };
        }
        this.defaultIOps = new String[] { null, null, null, null, Mk163.g(Mk163.DROP, this.languageId) };
    }
}
