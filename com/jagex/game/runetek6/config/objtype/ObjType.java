/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.objtype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.objtype.ObjStackability;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.Ha262;
import tfu.Jz233;
import tfu.Kq264;
import tfu.Ld263;
import tfu.Ln265;
import tfu.Mk163;

public class ObjType {
    public static final int MAX_IOP_COUNT = 5;
    public static final int MAX_OP_COUNT = 6;
    public static final int SHOWCOUNT_ALWAYS = 1;
    public static final int SHOWCOUNT_IFNOT1 = 2;
    public static final int SHOWCOUNT_NEVER = 0;
    public static short[] clientpalette;
    private static final boolean debug = true;
    private static final Logger logger;
    public int ambient = 0;
    public int boughtlink = -1;
    public int boughttemplate = -1;
    public int certlink = -1;
    public int certtemplate = -1;
    public int contrast = 0;
    public int cost = 1;
    public int[] countco;
    public int[] countobj;
    public int cursor1 = -1;
    public int cursor1iop = -1;
    public int cursor1op = -1;
    public int cursor2 = -1;
    public int cursor2iop = -1;
    public int cursor2op = -1;
    public int dummyitem = 0;
    public int femaleSkeleton = -1;
    public int icursor1 = -1;
    public int icursor2 = -1;
    public String[] iop;
    public int lentlink = -1;
    public int lenttemplate = -1;
    public int maleSkeleton = -1;
    public int manhead = -1;
    public int manhead2 = -1;
    public int manwear = -1;
    public int manwear2 = -1;
    public int manwear3 = -1;
    public int manwearxoff = 0;
    public int manwearyoff = 0;
    public int manwearzoff = 0;
    public boolean members = false;
    public int mesh = -1;
    public int multistacksize = -1;
    protected ObjTypeList myList;
    public int myid;
    public String name = "null";
    public String[] op;
    public Ha262 params;
    public int picksizeshift = 0;
    public short[] recol_d;
    public byte[] recol_d_palette;
    public short[] recol_s;
    public int resizex = 128;
    public int resizey = 128;
    public int resizez = 128;
    public short[] retex_d;
    public short[] retex_s;
    public int skeleton;
    public ObjStackability stackable = ObjStackability.SOMETIMES;
    public boolean stockmarket = false;
    public int team = 0;
    public int womanhead = -1;
    public int womanhead2 = -1;
    public int womanwear = -1;
    public int womanwear2 = -1;
    public int womanwear3 = -1;
    public int womanwearxoff = 0;
    public int womanwearyoff = 0;
    public int womanwearzoff = 0;
    public int xan2d = 0;
    public int xof2d = 0;
    public int yan2d = 0;
    public int yof2d = 0;
    public int zan2d = 0;
    public int zoom2d = 2000;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetName() {
        return this.name;
    }

    void postDecode() {
    }

    public String toString() {
        return "{ ObjType: " + (this.name == null ? "null" : this.name) + " }";
    }

    protected void decode(Gg3 gg3, int n) {
        if (n == 1) {
            Gg3.bf(gg3);
        } else if (n == 2) {
            this.name = Gg3.bk(gg3);
        } else if (n == 4) {
            this.zoom2d = Gg3.au(gg3);
        } else if (n == 5) {
            this.xan2d = Gg3.au(gg3);
        } else if (n == 6) {
            this.yan2d = Gg3.au(gg3);
        } else if (n == 7) {
            this.xof2d = Gg3.au(gg3);
            if (this.xof2d > 32767) {
                this.xof2d -= 65536;
            }
        } else if (n == 8) {
            this.yof2d = Gg3.au(gg3);
            if (this.yof2d > 32767) {
                this.yof2d -= 65536;
            }
        } else if (n == 11) {
            this.stackable = ObjStackability.ALWAYS;
        } else if (n == 12) {
            this.cost = Gg3.bd(gg3);
        } else if (n == 16) {
            this.members = true;
        } else if (n == 18) {
            this.multistacksize = Gg3.au(gg3);
        } else if (n == 23) {
            Gg3.bf(gg3);
        } else if (n == 24) {
            Gg3.bf(gg3);
        } else if (n == 25) {
            Gg3.bf(gg3);
        } else if (n == 26) {
            Gg3.bf(gg3);
        } else if (n >= 30 && n < 35) {
            this.op[n - 30] = Gg3.bk(gg3);
        } else if (n >= 35 && n < 40) {
            this.iop[n - 35] = Gg3.bk(gg3);
        } else if (n == 40) {
            int n2 = Gg3.ar(gg3);
            this.recol_s = new short[n2];
            this.recol_d = new short[n2];
            for (int i = 0; i < n2; ++i) {
                this.recol_s[i] = (short)Gg3.au(gg3);
                this.recol_d[i] = (short)Gg3.au(gg3);
            }
        } else if (n == 41) {
            int n3 = Gg3.ar(gg3);
            this.retex_s = new short[n3];
            this.retex_d = new short[n3];
            for (int i = 0; i < n3; ++i) {
                this.retex_s[i] = (short)Gg3.au(gg3);
                this.retex_d[i] = (short)Gg3.au(gg3);
            }
        } else if (n == 42) {
            int n4 = Gg3.ar(gg3);
            this.recol_d_palette = new byte[n4];
            for (int i = 0; i < n4; ++i) {
                this.recol_d_palette[i] = Gg3.ax(gg3);
            }
        } else if (n == 65) {
            this.stockmarket = true;
        } else if (n == 78) {
            Gg3.bf(gg3);
        } else if (n == 79) {
            Gg3.bf(gg3);
        } else if (n == 90) {
            this.manhead = Gg3.bf(gg3);
        } else if (n == 91) {
            this.womanhead = Gg3.bf(gg3);
        } else if (n == 92) {
            this.manhead2 = Gg3.bf(gg3);
        } else if (n == 93) {
            this.womanhead2 = Gg3.bf(gg3);
        } else if (n == 95) {
            this.zan2d = Gg3.au(gg3);
        } else if (n == 96) {
            this.dummyitem = Gg3.ar(gg3);
        } else if (n == 97) {
            this.certlink = Gg3.au(gg3);
        } else if (n == 98) {
            this.certtemplate = Gg3.au(gg3);
        } else if (n >= 100 && n < 110) {
            if (this.countobj == null) {
                this.countobj = new int[10];
                this.countco = new int[10];
            }
            this.countobj[n - 100] = Gg3.au(gg3);
            this.countco[n - 100] = Gg3.au(gg3);
        } else if (n == 110) {
            this.resizex = Gg3.au(gg3);
        } else if (n == 111) {
            this.resizey = Gg3.au(gg3);
        } else if (n == 112) {
            this.resizez = Gg3.au(gg3);
        } else if (n == 113) {
            this.ambient = Gg3.ax(gg3);
        } else if (n == 114) {
            this.contrast = Gg3.ax(gg3) * 5;
        } else if (n == 115) {
            this.team = Gg3.ar(gg3);
        } else if (n == 121) {
            this.lentlink = Gg3.au(gg3);
        } else if (n == 122) {
            this.lenttemplate = Gg3.au(gg3);
        } else if (n == 125) {
            this.manwearxoff = Gg3.ax(gg3) << 2;
            this.manwearyoff = Gg3.ax(gg3) << 2;
            this.manwearzoff = Gg3.ax(gg3) << 2;
        } else if (n == 126) {
            this.womanwearxoff = Gg3.ax(gg3) << 2;
            this.womanwearyoff = Gg3.ax(gg3) << 2;
            this.womanwearzoff = Gg3.ax(gg3) << 2;
        } else if (n == 127) {
            this.cursor1op = Gg3.ar(gg3);
            this.cursor1 = Gg3.au(gg3);
        } else if (n == 128) {
            this.cursor2op = Gg3.ar(gg3);
            this.cursor2 = Gg3.au(gg3);
        } else if (n == 129) {
            this.cursor1iop = Gg3.ar(gg3);
            this.icursor1 = Gg3.au(gg3);
        } else if (n == 130) {
            this.cursor2iop = Gg3.ar(gg3);
            this.icursor2 = Gg3.au(gg3);
        } else if (n == 132) {
            int n5 = Gg3.ar(gg3);
            for (int i = 0; i < n5; ++i) {
                Gg3.au(gg3);
            }
        } else if (n == 134) {
            this.picksizeshift = Gg3.ar(gg3);
        } else if (n == 139) {
            this.boughtlink = Gg3.au(gg3);
        } else if (n == 140) {
            this.boughttemplate = Gg3.au(gg3);
        } else if (n == 141) {
            this.mesh = Gg3.au(gg3);
        } else if (n == 142) {
            this.skeleton = Gg3.au(gg3);
        } else if (n == 143) {
            this.manwear = Gg3.au(gg3);
        } else if (n == 144) {
            this.manwear2 = Gg3.au(gg3);
        } else if (n == 145) {
            this.manwear3 = Gg3.au(gg3);
        } else if (n == 146) {
            this.maleSkeleton = Gg3.au(gg3);
        } else if (n == 147) {
            this.womanwear = Gg3.au(gg3);
        } else if (n == 148) {
            this.womanwear2 = Gg3.au(gg3);
        } else if (n == 149) {
            this.womanwear3 = Gg3.au(gg3);
        } else if (n == 150) {
            this.femaleSkeleton = Gg3.au(gg3);
        } else if (n == 249) {
            int n6;
            int n7 = Gg3.ar(gg3);
            if (this.params == null) {
                n6 = Jz233.j(n7);
                this.params = new Ha262(n6);
            }
            for (n6 = 0; n6 < n7; ++n6) {
                boolean bl = Gg3.ar(gg3) == 1;
                int n8 = Gg3.ay(gg3);
                Ln265 ln265 = bl ? new Ld263(Gg3.bk(gg3)) : new Kq264(Gg3.bd(gg3));
                Ha262.q(this.params, ln265, n8);
            }
        } else {
            logger.info("Error unrecognised .obj config code: {}", n);
        }
    }

    void genCert(ObjType objType, ObjType objType2) {
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

    void genLent(ObjType objType, ObjType objType2) {
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

    void genBought(ObjType objType, ObjType objType2) {
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

    public int getParam(int n, int n2) {
        if (this.params == null) {
            return n2;
        }
        Kq264 kq264 = (Kq264)Ha262.d(this.params, n);
        if (kq264 == null) {
            return n2;
        }
        return kq264.g;
    }

    public final int getMeshAddress(int n) {
        if (this.countobj != null && n > 1) {
            int n2 = -1;
            for (int i = 0; i < 10; ++i) {
                if (n < this.countco[i] || this.countco[i] == 0) continue;
                n2 = this.countobj[i];
            }
            if (n2 != -1) {
                return this.myList.list(n2).getMeshAddress(1);
            }
        }
        return this.mesh;
    }

    static {
        logger = LoggerFactory.getLogger(ObjType.class);
        clientpalette = new short[256];
    }

    protected void decode(Gg3 gg3) {
        int n;
        while ((n = Gg3.ar(gg3)) != 0) {
            this.decode(gg3, n);
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
}

