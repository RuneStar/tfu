package com.jagex.game.runetek6.config.objtype;

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
   public static short[] clientpalette = new short[256];
   private static final boolean debug = true;
   private static final Logger logger = LoggerFactory.getLogger(ObjType.class);
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
   public int femaleSkeleton = -1;
   public int icursor1;
   public int icursor2;
   public String[] iop;
   public int lentlink;
   public int lenttemplate;
   public int maleSkeleton = -1;
   public int manhead;
   public int manhead2;
   public int manwear = -1;
   public int manwear2 = -1;
   public int manwear3 = -1;
   public int manwearxoff;
   public int manwearyoff;
   public int manwearzoff;
   public boolean members;
   public int mesh = -1;
   public int multistacksize;
   protected ObjTypeList myList;
   public int myid;
   public String name = "null";
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
   public int womanwear = -1;
   public int womanwear2 = -1;
   public int womanwear3 = -1;
   public int womanwearxoff;
   public int womanwearyoff;
   public int womanwearzoff;
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

   protected void decode(Gg3 var1, int var2) {
      if (var2 == 1) {
         Gg3.bf(var1);
      } else if (var2 == 2) {
         this.name = Gg3.bk(var1);
      } else if (var2 == 4) {
         this.zoom2d = Gg3.au(var1);
      } else if (var2 == 5) {
         this.xan2d = Gg3.au(var1);
      } else if (var2 == 6) {
         this.yan2d = Gg3.au(var1);
      } else if (var2 == 7) {
         this.xof2d = Gg3.au(var1);
         if (this.xof2d > 32767) {
            this.xof2d -= 65536;
         }
      } else if (var2 == 8) {
         this.yof2d = Gg3.au(var1);
         if (this.yof2d > 32767) {
            this.yof2d -= 65536;
         }
      } else if (var2 == 11) {
         this.stackable = ObjStackability.ALWAYS;
      } else if (var2 == 12) {
         this.cost = Gg3.bd(var1);
      } else if (var2 == 16) {
         this.members = true;
      } else if (var2 == 18) {
         this.multistacksize = Gg3.au(var1);
      } else if (var2 == 23) {
         Gg3.bf(var1);
      } else if (var2 == 24) {
         Gg3.bf(var1);
      } else if (var2 == 25) {
         Gg3.bf(var1);
      } else if (var2 == 26) {
         Gg3.bf(var1);
      } else if (var2 >= 30 && var2 < 35) {
         this.op[var2 - 30] = Gg3.bk(var1);
      } else if (var2 >= 35 && var2 < 40) {
         this.iop[var2 - 35] = Gg3.bk(var1);
      } else {
         int var3;
         int var4;
         if (var2 == 40) {
            var3 = Gg3.ar(var1);
            this.recol_s = new short[var3];
            this.recol_d = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recol_s[var4] = (short)Gg3.au(var1);
               this.recol_d[var4] = (short)Gg3.au(var1);
            }
         } else if (var2 == 41) {
            var3 = Gg3.ar(var1);
            this.retex_s = new short[var3];
            this.retex_d = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retex_s[var4] = (short)Gg3.au(var1);
               this.retex_d[var4] = (short)Gg3.au(var1);
            }
         } else if (var2 == 42) {
            var3 = Gg3.ar(var1);
            this.recol_d_palette = new byte[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recol_d_palette[var4] = Gg3.ax(var1);
            }
         } else if (var2 == 65) {
            this.stockmarket = true;
         } else if (var2 == 78) {
            Gg3.bf(var1);
         } else if (var2 == 79) {
            Gg3.bf(var1);
         } else if (var2 == 90) {
            this.manhead = Gg3.bf(var1);
         } else if (var2 == 91) {
            this.womanhead = Gg3.bf(var1);
         } else if (var2 == 92) {
            this.manhead2 = Gg3.bf(var1);
         } else if (var2 == 93) {
            this.womanhead2 = Gg3.bf(var1);
         } else if (var2 == 95) {
            this.zan2d = Gg3.au(var1);
         } else if (var2 == 96) {
            this.dummyitem = Gg3.ar(var1);
         } else if (var2 == 97) {
            this.certlink = Gg3.au(var1);
         } else if (var2 == 98) {
            this.certtemplate = Gg3.au(var1);
         } else if (var2 >= 100 && var2 < 110) {
            if (this.countobj == null) {
               this.countobj = new int[10];
               this.countco = new int[10];
            }

            this.countobj[var2 - 100] = Gg3.au(var1);
            this.countco[var2 - 100] = Gg3.au(var1);
         } else if (var2 == 110) {
            this.resizex = Gg3.au(var1);
         } else if (var2 == 111) {
            this.resizey = Gg3.au(var1);
         } else if (var2 == 112) {
            this.resizez = Gg3.au(var1);
         } else if (var2 == 113) {
            this.ambient = Gg3.ax(var1);
         } else if (var2 == 114) {
            this.contrast = Gg3.ax(var1) * 5;
         } else if (var2 == 115) {
            this.team = Gg3.ar(var1);
         } else if (var2 == 121) {
            this.lentlink = Gg3.au(var1);
         } else if (var2 == 122) {
            this.lenttemplate = Gg3.au(var1);
         } else if (var2 == 125) {
            this.manwearxoff = Gg3.ax(var1) << 2;
            this.manwearyoff = Gg3.ax(var1) << 2;
            this.manwearzoff = Gg3.ax(var1) << 2;
         } else if (var2 == 126) {
            this.womanwearxoff = Gg3.ax(var1) << 2;
            this.womanwearyoff = Gg3.ax(var1) << 2;
            this.womanwearzoff = Gg3.ax(var1) << 2;
         } else if (var2 == 127) {
            this.cursor1op = Gg3.ar(var1);
            this.cursor1 = Gg3.au(var1);
         } else if (var2 == 128) {
            this.cursor2op = Gg3.ar(var1);
            this.cursor2 = Gg3.au(var1);
         } else if (var2 == 129) {
            this.cursor1iop = Gg3.ar(var1);
            this.icursor1 = Gg3.au(var1);
         } else if (var2 == 130) {
            this.cursor2iop = Gg3.ar(var1);
            this.icursor2 = Gg3.au(var1);
         } else if (var2 == 132) {
            var3 = Gg3.ar(var1);

            for(var4 = 0; var4 < var3; ++var4) {
               Gg3.au(var1);
            }
         } else if (var2 == 134) {
            this.picksizeshift = Gg3.ar(var1);
         } else if (var2 == 139) {
            this.boughtlink = Gg3.au(var1);
         } else if (var2 == 140) {
            this.boughttemplate = Gg3.au(var1);
         } else if (var2 == 141) {
            this.mesh = Gg3.au(var1);
         } else if (var2 == 142) {
            this.skeleton = Gg3.au(var1);
         } else if (var2 == 143) {
            this.manwear = Gg3.au(var1);
         } else if (var2 == 144) {
            this.manwear2 = Gg3.au(var1);
         } else if (var2 == 145) {
            this.manwear3 = Gg3.au(var1);
         } else if (var2 == 146) {
            this.maleSkeleton = Gg3.au(var1);
         } else if (var2 == 147) {
            this.womanwear = Gg3.au(var1);
         } else if (var2 == 148) {
            this.womanwear2 = Gg3.au(var1);
         } else if (var2 == 149) {
            this.womanwear3 = Gg3.au(var1);
         } else if (var2 == 150) {
            this.femaleSkeleton = Gg3.au(var1);
         } else if (var2 == 249) {
            var3 = Gg3.ar(var1);
            if (this.params == null) {
               var4 = Jz233.j(var3);
               this.params = new Ha262(var4);
            }

            for(var4 = 0; var4 < var3; ++var4) {
               boolean var5 = Gg3.ar(var1) == 1;
               int var6 = Gg3.ay(var1);
               Object var7;
               if (var5) {
                  var7 = new Ld263(Gg3.bk(var1));
               } else {
                  var7 = new Kq264(Gg3.bd(var1));
               }

               Ha262.q(this.params, (Ln265)var7, (long)var6);
            }
         } else {
            logger.info("Error unrecognised .obj config code: {}", var2);
         }
      }

   }

   void genCert(ObjType var1, ObjType var2) {
      this.mesh = var1.mesh;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.xof2d = var1.xof2d;
      this.yof2d = var1.yof2d;
      this.recol_s = var1.recol_s;
      this.recol_d = var1.recol_d;
      this.recol_d_palette = var1.recol_d_palette;
      this.retex_s = var1.retex_s;
      this.retex_d = var1.retex_d;
      this.name = var2.name;
      this.members = var2.members;
      this.cost = var2.cost;
      this.stackable = ObjStackability.ALWAYS;
   }

   void genLent(ObjType var1, ObjType var2) {
      this.cost = 0;
      this.mesh = var1.mesh;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.xof2d = var1.xof2d;
      this.yof2d = var1.yof2d;
      this.recol_s = var2.recol_s;
      this.recol_d = var2.recol_d;
      this.recol_d_palette = var2.recol_d_palette;
      this.retex_s = var2.retex_s;
      this.retex_d = var2.retex_d;
      this.name = var2.name;
      this.members = var2.members;
      this.manwear = var2.manwear;
      this.manwear2 = var2.manwear2;
      this.manwear3 = var2.manwear3;
      this.womanwear = var2.womanwear;
      this.womanwear2 = var2.womanwear2;
      this.womanwear3 = var2.womanwear3;
      this.manwearxoff = var2.manwearxoff;
      this.womanwearxoff = var2.womanwearxoff;
      this.manwearyoff = var2.manwearyoff;
      this.womanwearyoff = var2.womanwearyoff;
      this.manwearzoff = var2.manwearzoff;
      this.womanwearzoff = var2.womanwearzoff;
      this.manhead = var2.manhead;
      this.manhead2 = var2.manhead2;
      this.womanhead = var2.womanhead;
      this.womanhead2 = var2.womanhead2;
      this.team = var2.team;
      this.op = var2.op;
      this.params = var2.params;
      this.iop = new String[5];
      if (var2.iop != null) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.iop[var3] = var2.iop[var3];
         }
      }

      this.iop[4] = Mk163.g(Mk163.LENT_ITEM_RETURN, this.myList.languageId);
   }

   void genBought(ObjType var1, ObjType var2) {
      this.cost = 0;
      this.mesh = var1.mesh;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.xof2d = var1.xof2d;
      this.yof2d = var1.yof2d;
      this.recol_s = var2.recol_s;
      this.recol_d = var2.recol_d;
      this.recol_d_palette = var2.recol_d_palette;
      this.retex_s = var2.retex_s;
      this.retex_d = var2.retex_d;
      this.name = var2.name;
      this.members = var2.members;
      this.manwear = var2.manwear;
      this.manwear2 = var2.manwear2;
      this.manwear3 = var2.manwear3;
      this.womanwear = var2.womanwear;
      this.womanwear2 = var2.womanwear2;
      this.womanwear3 = var2.womanwear3;
      this.manwearxoff = var2.manwearxoff;
      this.womanwearxoff = var2.womanwearxoff;
      this.manwearyoff = var2.manwearyoff;
      this.womanwearyoff = var2.womanwearyoff;
      this.manwearzoff = var2.manwearzoff;
      this.womanwearzoff = var2.womanwearzoff;
      this.manhead = var2.manhead;
      this.manhead2 = var2.manhead2;
      this.womanhead = var2.womanhead;
      this.womanhead2 = var2.womanhead2;
      this.team = var2.team;
      this.op = var2.op;
      this.params = var2.params;
      this.stackable = var2.stackable;
      this.iop = new String[5];
      if (var2.iop != null) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.iop[var3] = var2.iop[var3];
         }
      }

      this.iop[4] = Mk163.g(Mk163.BOUGHT_ITEM_DISCARD, this.myList.languageId);
   }

   public int getParam(int var1, int var2) {
      if (this.params == null) {
         return var2;
      } else {
         Kq264 var3 = (Kq264)Ha262.d(this.params, (long)var1);
         return var3 == null ? var2 : var3.g;
      }
   }

   public final int getMeshAddress(int var1) {
      if (this.countobj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if (var1 >= this.countco[var3] && this.countco[var3] != 0) {
               var2 = this.countobj[var3];
            }
         }

         if (var2 != -1) {
            return this.myList.list(var2).getMeshAddress(1);
         }
      }

      return this.mesh;
   }

   protected void decode(Gg3 var1) {
      while(true) {
         int var2 = Gg3.ar(var1);
         if (var2 == 0) {
            return;
         }

         this.decode(var1, var2);
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
