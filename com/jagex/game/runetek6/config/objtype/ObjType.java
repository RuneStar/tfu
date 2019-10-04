// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.objtype;

import org.slf4j.LoggerFactory;
import tfu.Mk163;
import tfu.Ln265;
import tfu.Kq264;
import tfu.Ld263;
import tfu.Jz233;
import tfu.Gg3;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Ha262;
import org.slf4j.Logger;

public class ObjType
{
    public static final int MAX_IOP_COUNT = 5;
    public static final int MAX_OP_COUNT = 6;
    public static final int SHOWCOUNT_ALWAYS = 1;
    public static final int SHOWCOUNT_IFNOT1 = 2;
    public static final int SHOWCOUNT_NEVER = 0;
    public static short[] clientpalette;
    private static final boolean debug = true;
    private static final Logger logger;
    public int ambient;
    public int boughtlink;
    public int boughttemplate;
    public int certlink;
    public int certtemplate;
    public int contrast;
    public int cost;
    public int[] countco;
    public int[] countobj;
    public int cursor1;
    public int cursor1iop;
    public int cursor1op;
    public int cursor2;
    public int cursor2iop;
    public int cursor2op;
    public int dummyitem;
    public int femaleSkeleton;
    public int icursor1;
    public int icursor2;
    public String[] iop;
    public int lentlink;
    public int lenttemplate;
    public int maleSkeleton;
    public int manhead;
    public int manhead2;
    public int manwear;
    public int manwear2;
    public int manwear3;
    public int manwearxoff;
    public int manwearyoff;
    public int manwearzoff;
    public boolean members;
    public int mesh;
    public int multistacksize;
    protected ObjTypeList myList;
    public int myid;
    public String name;
    public String[] op;
    public Ha262 params;
    public int picksizeshift;
    public short[] recol_d;
    public byte[] recol_d_palette;
    public short[] recol_s;
    public int resizex;
    public int resizey;
    public int resizez;
    public short[] retex_d;
    public short[] retex_s;
    public int skeleton;
    public ObjStackability stackable;
    public boolean stockmarket;
    public int team;
    public int womanhead;
    public int womanhead2;
    public int womanwear;
    public int womanwear2;
    public int womanwear3;
    public int womanwearxoff;
    public int womanwearyoff;
    public int womanwearzoff;
    public int xan2d;
    public int xof2d;
    public int yan2d;
    public int yof2d;
    public int zan2d;
    public int zoom2d;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetName() {
        return this.name;
    }
    
    void postDecode() {
    }
    
    @Override
    public String toString() {
        return "{ ObjType: " + ((this.name == null) ? "null" : this.name) + " }";
    }
    
    protected void decode(final Gg3 gg3, final int i) {
        if (i == 1) {
            Gg3.bf(gg3);
        }
        else if (i == 2) {
            this.name = Gg3.bk(gg3);
        }
        else if (i == 4) {
            this.zoom2d = Gg3.au(gg3);
        }
        else if (i == 5) {
            this.xan2d = Gg3.au(gg3);
        }
        else if (i == 6) {
            this.yan2d = Gg3.au(gg3);
        }
        else if (i == 7) {
            this.xof2d = Gg3.au(gg3);
            if (this.xof2d > 32767) {
                this.xof2d -= 65536;
            }
        }
        else if (i == 8) {
            this.yof2d = Gg3.au(gg3);
            if (this.yof2d > 32767) {
                this.yof2d -= 65536;
            }
        }
        else if (i == 11) {
            this.stackable = ObjStackability.ALWAYS;
        }
        else if (i == 12) {
            this.cost = Gg3.bd(gg3);
        }
        else if (i == 16) {
            this.members = true;
        }
        else if (i == 18) {
            this.multistacksize = Gg3.au(gg3);
        }
        else if (i == 23) {
            Gg3.bf(gg3);
        }
        else if (i == 24) {
            Gg3.bf(gg3);
        }
        else if (i == 25) {
            Gg3.bf(gg3);
        }
        else if (i == 26) {
            Gg3.bf(gg3);
        }
        else if (i >= 30 && i < 35) {
            this.op[i - 30] = Gg3.bk(gg3);
        }
        else if (i >= 35 && i < 40) {
            this.iop[i - 35] = Gg3.bk(gg3);
        }
        else if (i == 40) {
            final int ar = Gg3.ar(gg3);
            this.recol_s = new short[ar];
            this.recol_d = new short[ar];
            for (int j = 0; j < ar; ++j) {
                this.recol_s[j] = (short)Gg3.au(gg3);
                this.recol_d[j] = (short)Gg3.au(gg3);
            }
        }
        else if (i == 41) {
            final int ar2 = Gg3.ar(gg3);
            this.retex_s = new short[ar2];
            this.retex_d = new short[ar2];
            for (int k = 0; k < ar2; ++k) {
                this.retex_s[k] = (short)Gg3.au(gg3);
                this.retex_d[k] = (short)Gg3.au(gg3);
            }
        }
        else if (i == 42) {
            final int ar3 = Gg3.ar(gg3);
            this.recol_d_palette = new byte[ar3];
            for (int l = 0; l < ar3; ++l) {
                this.recol_d_palette[l] = Gg3.ax(gg3);
            }
        }
        else if (i == 65) {
            this.stockmarket = true;
        }
        else if (i == 78) {
            Gg3.bf(gg3);
        }
        else if (i == 79) {
            Gg3.bf(gg3);
        }
        else if (i == 90) {
            this.manhead = Gg3.bf(gg3);
        }
        else if (i == 91) {
            this.womanhead = Gg3.bf(gg3);
        }
        else if (i == 92) {
            this.manhead2 = Gg3.bf(gg3);
        }
        else if (i == 93) {
            this.womanhead2 = Gg3.bf(gg3);
        }
        else if (i == 95) {
            this.zan2d = Gg3.au(gg3);
        }
        else if (i == 96) {
            this.dummyitem = Gg3.ar(gg3);
        }
        else if (i == 97) {
            this.certlink = Gg3.au(gg3);
        }
        else if (i == 98) {
            this.certtemplate = Gg3.au(gg3);
        }
        else if (i >= 100 && i < 110) {
            if (this.countobj == null) {
                this.countobj = new int[10];
                this.countco = new int[10];
            }
            this.countobj[i - 100] = Gg3.au(gg3);
            this.countco[i - 100] = Gg3.au(gg3);
        }
        else if (i == 110) {
            this.resizex = Gg3.au(gg3);
        }
        else if (i == 111) {
            this.resizey = Gg3.au(gg3);
        }
        else if (i == 112) {
            this.resizez = Gg3.au(gg3);
        }
        else if (i == 113) {
            this.ambient = Gg3.ax(gg3);
        }
        else if (i == 114) {
            this.contrast = Gg3.ax(gg3) * 5;
        }
        else if (i == 115) {
            this.team = Gg3.ar(gg3);
        }
        else if (i == 121) {
            this.lentlink = Gg3.au(gg3);
        }
        else if (i == 122) {
            this.lenttemplate = Gg3.au(gg3);
        }
        else if (i == 125) {
            this.manwearxoff = Gg3.ax(gg3) << 2;
            this.manwearyoff = Gg3.ax(gg3) << 2;
            this.manwearzoff = Gg3.ax(gg3) << 2;
        }
        else if (i == 126) {
            this.womanwearxoff = Gg3.ax(gg3) << 2;
            this.womanwearyoff = Gg3.ax(gg3) << 2;
            this.womanwearzoff = Gg3.ax(gg3) << 2;
        }
        else if (i == 127) {
            this.cursor1op = Gg3.ar(gg3);
            this.cursor1 = Gg3.au(gg3);
        }
        else if (i == 128) {
            this.cursor2op = Gg3.ar(gg3);
            this.cursor2 = Gg3.au(gg3);
        }
        else if (i == 129) {
            this.cursor1iop = Gg3.ar(gg3);
            this.icursor1 = Gg3.au(gg3);
        }
        else if (i == 130) {
            this.cursor2iop = Gg3.ar(gg3);
            this.icursor2 = Gg3.au(gg3);
        }
        else if (i == 132) {
            for (int ar4 = Gg3.ar(gg3), n = 0; n < ar4; ++n) {
                Gg3.au(gg3);
            }
        }
        else if (i == 134) {
            this.picksizeshift = Gg3.ar(gg3);
        }
        else if (i == 139) {
            this.boughtlink = Gg3.au(gg3);
        }
        else if (i == 140) {
            this.boughttemplate = Gg3.au(gg3);
        }
        else if (i == 141) {
            this.mesh = Gg3.au(gg3);
        }
        else if (i == 142) {
            this.skeleton = Gg3.au(gg3);
        }
        else if (i == 143) {
            this.manwear = Gg3.au(gg3);
        }
        else if (i == 144) {
            this.manwear2 = Gg3.au(gg3);
        }
        else if (i == 145) {
            this.manwear3 = Gg3.au(gg3);
        }
        else if (i == 146) {
            this.maleSkeleton = Gg3.au(gg3);
        }
        else if (i == 147) {
            this.womanwear = Gg3.au(gg3);
        }
        else if (i == 148) {
            this.womanwear2 = Gg3.au(gg3);
        }
        else if (i == 149) {
            this.womanwear3 = Gg3.au(gg3);
        }
        else if (i == 150) {
            this.femaleSkeleton = Gg3.au(gg3);
        }
        else if (i == 249) {
            final int ar5 = Gg3.ar(gg3);
            if (this.params == null) {
                this.params = new Ha262(Jz233.j(ar5));
            }
            for (int n2 = 0; n2 < ar5; ++n2) {
                final boolean b = Gg3.ar(gg3) == 1;
                final int ay = Gg3.ay(gg3);
                Ln265 ln265;
                if (b) {
                    ln265 = new Ld263(Gg3.bk(gg3));
                }
                else {
                    ln265 = new Kq264(Gg3.bd(gg3));
                }
                Ha262.q(this.params, ln265, ay);
            }
        }
        else {
            ObjType.logger.info("Error unrecognised .obj config code: {}", i);
        }
    }
    
    void genCert(final ObjType objType, final ObjType objType2) {
        this.mesh = objType.mesh;
        this.zoom2d = objType.zoom2d;
        this.xan2d = objType.xan2d;
        this.yan2d = objType.yan2d;
        this.zan2d = objType.zan2d;
        this.xof2d = objType.xof2d;
        this.yof2d = objType.yof2d;
        this.recol_s = objType.recol_s;
        this.recol_d = objType.recol_d;
        this.recol_d_palette = objType.recol_d_palette;
        this.retex_s = objType.retex_s;
        this.retex_d = objType.retex_d;
        this.name = objType2.name;
        this.members = objType2.members;
        this.cost = objType2.cost;
        this.stackable = ObjStackability.ALWAYS;
    }
    
    void genLent(final ObjType objType, final ObjType objType2) {
        this.cost = 0;
        this.mesh = objType.mesh;
        this.zoom2d = objType.zoom2d;
        this.xan2d = objType.xan2d;
        this.yan2d = objType.yan2d;
        this.zan2d = objType.zan2d;
        this.xof2d = objType.xof2d;
        this.yof2d = objType.yof2d;
        this.recol_s = objType2.recol_s;
        this.recol_d = objType2.recol_d;
        this.recol_d_palette = objType2.recol_d_palette;
        this.retex_s = objType2.retex_s;
        this.retex_d = objType2.retex_d;
        this.name = objType2.name;
        this.members = objType2.members;
        this.manwear = objType2.manwear;
        this.manwear2 = objType2.manwear2;
        this.manwear3 = objType2.manwear3;
        this.womanwear = objType2.womanwear;
        this.womanwear2 = objType2.womanwear2;
        this.womanwear3 = objType2.womanwear3;
        this.manwearxoff = objType2.manwearxoff;
        this.womanwearxoff = objType2.womanwearxoff;
        this.manwearyoff = objType2.manwearyoff;
        this.womanwearyoff = objType2.womanwearyoff;
        this.manwearzoff = objType2.manwearzoff;
        this.womanwearzoff = objType2.womanwearzoff;
        this.manhead = objType2.manhead;
        this.manhead2 = objType2.manhead2;
        this.womanhead = objType2.womanhead;
        this.womanhead2 = objType2.womanhead2;
        this.team = objType2.team;
        this.op = objType2.op;
        this.params = objType2.params;
        this.iop = new String[5];
        if (objType2.iop != null) {
            for (int i = 0; i < 4; ++i) {
                this.iop[i] = objType2.iop[i];
            }
        }
        this.iop[4] = Mk163.g(Mk163.LENT_ITEM_RETURN, this.myList.languageId);
    }
    
    void genBought(final ObjType objType, final ObjType objType2) {
        this.cost = 0;
        this.mesh = objType.mesh;
        this.zoom2d = objType.zoom2d;
        this.xan2d = objType.xan2d;
        this.yan2d = objType.yan2d;
        this.zan2d = objType.zan2d;
        this.xof2d = objType.xof2d;
        this.yof2d = objType.yof2d;
        this.recol_s = objType2.recol_s;
        this.recol_d = objType2.recol_d;
        this.recol_d_palette = objType2.recol_d_palette;
        this.retex_s = objType2.retex_s;
        this.retex_d = objType2.retex_d;
        this.name = objType2.name;
        this.members = objType2.members;
        this.manwear = objType2.manwear;
        this.manwear2 = objType2.manwear2;
        this.manwear3 = objType2.manwear3;
        this.womanwear = objType2.womanwear;
        this.womanwear2 = objType2.womanwear2;
        this.womanwear3 = objType2.womanwear3;
        this.manwearxoff = objType2.manwearxoff;
        this.womanwearxoff = objType2.womanwearxoff;
        this.manwearyoff = objType2.manwearyoff;
        this.womanwearyoff = objType2.womanwearyoff;
        this.manwearzoff = objType2.manwearzoff;
        this.womanwearzoff = objType2.womanwearzoff;
        this.manhead = objType2.manhead;
        this.manhead2 = objType2.manhead2;
        this.womanhead = objType2.womanhead;
        this.womanhead2 = objType2.womanhead2;
        this.team = objType2.team;
        this.op = objType2.op;
        this.params = objType2.params;
        this.stackable = objType2.stackable;
        this.iop = new String[5];
        if (objType2.iop != null) {
            for (int i = 0; i < 4; ++i) {
                this.iop[i] = objType2.iop[i];
            }
        }
        this.iop[4] = Mk163.g(Mk163.BOUGHT_ITEM_DISCARD, this.myList.languageId);
    }
    
    public int getParam(final int n, final int n2) {
        if (this.params == null) {
            return n2;
        }
        final Kq264 kq264 = (Kq264)Ha262.d(this.params, n);
        if (kq264 == null) {
            return n2;
        }
        return kq264.g;
    }
    
    public final int getMeshAddress(final int n) {
        if (this.countobj != null && n > 1) {
            int n2 = -1;
            for (int i = 0; i < 10; ++i) {
                if (n >= this.countco[i] && this.countco[i] != 0) {
                    n2 = this.countobj[i];
                }
            }
            if (n2 != -1) {
                return this.myList.list(n2).getMeshAddress(1);
            }
        }
        return this.mesh;
    }
    
    static {
        logger = LoggerFactory.getLogger(ObjType.class);
        ObjType.clientpalette = new short[256];
    }
    
    protected void decode(final Gg3 gg3) {
        while (true) {
            final int ar = Gg3.ar(gg3);
            if (ar == 0) {
                break;
            }
            this.decode(gg3, ar);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean IsStackable() {
        return this.stackable == ObjStackability.ALWAYS;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetMultiStackSize() {
        return this.multistacksize;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetCost() {
        return this.cost;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean IsMembers() {
        return this.members;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean IsStockMarketItem() {
        return this.stockmarket;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetID() {
        return this.myid;
    }
    
    public ObjType() {
        this.mesh = -1;
        this.maleSkeleton = -1;
        this.manwear = -1;
        this.manwear2 = -1;
        this.manwear3 = -1;
        this.femaleSkeleton = -1;
        this.womanwear = -1;
        this.womanwear2 = -1;
        this.womanwear3 = -1;
        this.name = "null";
        this.zoom2d = 2000;
        this.xan2d = 0;
        this.yan2d = 0;
        this.zan2d = 0;
        this.xof2d = 0;
        this.yof2d = 0;
        this.stackable = ObjStackability.SOMETIMES;
        this.multistacksize = -1;
        this.cost = 1;
        this.members = false;
        this.cursor1 = -1;
        this.cursor2 = -1;
        this.icursor1 = -1;
        this.icursor2 = -1;
        this.cursor1op = -1;
        this.cursor2op = -1;
        this.cursor1iop = -1;
        this.cursor2iop = -1;
        this.manwearxoff = 0;
        this.womanwearxoff = 0;
        this.manwearyoff = 0;
        this.womanwearyoff = 0;
        this.manwearzoff = 0;
        this.womanwearzoff = 0;
        this.manhead = -1;
        this.manhead2 = -1;
        this.womanhead = -1;
        this.womanhead2 = -1;
        this.certlink = -1;
        this.certtemplate = -1;
        this.lentlink = -1;
        this.lenttemplate = -1;
        this.resizex = 128;
        this.resizey = 128;
        this.resizez = 128;
        this.ambient = 0;
        this.contrast = 0;
        this.team = 0;
        this.stockmarket = false;
        this.dummyitem = 0;
        this.picksizeshift = 0;
        this.boughtlink = -1;
        this.boughttemplate = -1;
    }
}
