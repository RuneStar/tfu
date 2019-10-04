/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.objtype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.js5.js5;
import tfu.Eq28;
import tfu.Gd27;
import tfu.Gg3;
import tfu.Ha262;
import tfu.Ln265;
import tfu.Mk163;

public class ObjTypeList {
    boolean allowMembers;
    final js5 configClient;
    protected final String[] defaultIOps;
    protected final String[] defaultOps;
    final Gd27 game;
    final Language languageId;
    final js5 meshes;
    public int num;
    final ParamTypeList paramTL;
    private final Eq28 recentUse = new Eq28(128);

    public ObjType list(int n) {
        ObjType objType;
        byte[] arrby = this.recentUse;
        synchronized (arrby) {
            objType = (ObjType)this.recentUse.g(n);
        }
        if (objType != null) {
            return objType;
        }
        js5 js52 = this.configClient;
        synchronized (js52) {
            arrby = this.configClient.getfile(Js5ConfigGroup.OBJTYPE.getClientGroupId(n), Js5ConfigGroup.OBJTYPE.getClientFileId(n));
        }
        objType = new ObjType();
        objType.myList = this;
        objType.myid = n;
        objType.op = (String[])this.defaultOps.clone();
        objType.iop = (String[])this.defaultIOps.clone();
        if (arrby != null) {
            objType.decode(new Gg3(arrby));
        }
        objType.postDecode();
        if (objType.certtemplate != -1) {
            objType.genCert(this.list(objType.certtemplate), this.list(objType.certlink));
        }
        if (objType.lenttemplate != -1) {
            objType.genLent(this.list(objType.lenttemplate), this.list(objType.lentlink));
        }
        if (objType.boughttemplate != -1) {
            objType.genBought(this.list(objType.boughttemplate), this.list(objType.boughtlink));
        }
        if (!this.allowMembers && objType.members) {
            objType.name = Mk163.g(Mk163.MEMBERS_OBJECT, this.languageId);
            objType.team = 0;
            objType.op = this.defaultOps;
            objType.iop = this.defaultIOps;
            objType.stockmarket = false;
            if (objType.params != null) {
                boolean bl = false;
                Ln265 ln265 = Ha262.e(objType.params);
                while (ln265 != null) {
                    ParamType paramType = this.paramTL.list((int)ln265.bq);
                    if (paramType.autodisable) {
                        Ln265.ef(ln265);
                    } else {
                        bl = true;
                    }
                    ln265 = Ha262.h(objType.params);
                }
                if (!bl) {
                    objType.params = null;
                }
            }
        }
        Eq28 eq28 = this.recentUse;
        synchronized (eq28) {
            Eq28.j(this.recentUse, objType, n);
        }
        return objType;
    }

    public void cacheRemoveSoftReferences() {
        Eq28.b(this.recentUse);
    }

    public void setAllowMembers(boolean bl) {
        if (bl == this.allowMembers) {
            return;
        }
        this.allowMembers = bl;
        this.cacheReset();
    }

    public void cacheReset() {
        Eq28.s(this.recentUse);
    }

    public void cacheClean(int n) {
        this.recentUse.h(n);
    }

    public ObjTypeList(Gd27 gd27, Language language, boolean bl, ParamTypeList paramTypeList, js5 js52, js5 js53) {
        this.game = gd27;
        this.languageId = language;
        this.allowMembers = bl;
        this.paramTL = paramTypeList;
        this.configClient = js52;
        this.meshes = js53;
        if (this.configClient != null) {
            int n = js5.t(this.configClient) - 1;
            this.num = n * Js5ConfigGroup.OBJTYPE.getGroupSize() + js5.z(this.configClient, n);
        } else {
            this.num = 0;
        }
        this.defaultOps = this.game == Gd27.RUNESCAPE ? new String[]{null, null, Mk163.g(Mk163.TAKE, this.languageId), null, null, Mk163.g(Mk163.EXAMINE, this.languageId)} : new String[]{null, null, Mk163.g(Mk163.TAKE, this.languageId), null, null, null};
        this.defaultIOps = new String[]{null, null, null, null, Mk163.g(Mk163.DROP, this.languageId)};
    }
}

