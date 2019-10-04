package com.jagex.game.runetek6.config.defaults;

import com.jagex.js5.js5;
import tfu.Gg3;

public class GraphicsDefaults {
   public static final int DEFAULT_MAXHITMARKS = 4;
   public int[] hitmarkpos_x = null;
   public int[] hitmarkpos_y = null;
   public int lobby_interface;
   public int login_interface;
   public int maxhitmarks = 4;
   public int npcChatTimeout = 2;
   public boolean npcShouldDisplayChat = true;
   public int playerChatTimeout = 3;
   public boolean playerShouldDisplayChat = true;

   public GraphicsDefaults(js5 var1) {
      byte[] var2 = js5.v(var1, DefaultsGroup.GRAPHICS.js5GroupId);
      this.decode(new Gg3(var2));
   }

   private void decode(Gg3 var1) {
      boolean var2 = false;

      while(true) {
         while(true) {
            int var3 = Gg3.ar(var1);
            if (var3 == 0) {
               if (!var2) {
                  if (this.hitmarkpos_x == null) {
                     this.maxhitmarks = 4;
                     this.hitmarkpos_x = new int[4];
                     this.hitmarkpos_y = new int[4];
                  }

                  for(var3 = 0; var3 < this.hitmarkpos_x.length; ++var3) {
                     this.hitmarkpos_x[var3] = 0;
                     this.hitmarkpos_y[var3] = var3 * 20;
                  }
               }

               return;
            }

            int var4;
            if (var3 == 1) {
               if (this.hitmarkpos_x == null) {
                  this.maxhitmarks = 4;
                  this.hitmarkpos_x = new int[4];
                  this.hitmarkpos_y = new int[4];
               }

               for(var4 = 0; var4 < this.hitmarkpos_x.length; ++var4) {
                  this.hitmarkpos_x[var4] = Gg3.ak(var1);
                  this.hitmarkpos_y[var4] = Gg3.ak(var1);
               }

               var2 = true;
            } else if (var3 == 2) {
               Gg3.bf(var1);
            } else if (var3 == 3) {
               this.maxhitmarks = Gg3.ar(var1);
               this.hitmarkpos_x = new int[this.maxhitmarks];
               this.hitmarkpos_y = new int[this.maxhitmarks];
            } else if (var3 == 5) {
               this.login_interface = Gg3.ay(var1);
            } else if (var3 == 6) {
               this.lobby_interface = Gg3.ay(var1);
            } else if (var3 != 7) {
               if (var3 == 8) {
                  this.npcShouldDisplayChat = false;
               } else if (var3 == 9) {
                  this.npcChatTimeout = Gg3.ar(var1);
               } else if (var3 == 10) {
                  this.playerShouldDisplayChat = false;
               } else if (var3 == 11) {
                  this.playerChatTimeout = Gg3.ar(var1);
               }
            } else {
               for(var4 = 0; var4 < 10; ++var4) {
                  for(int var5 = 0; var5 < 4; ++var5) {
                     Gg3.au(var1);
                     int var6 = Gg3.au(var1);

                     for(int var7 = 0; var7 < var6; ++var7) {
                        Gg3.au(var1);
                     }
                  }
               }
            }
         }
      }
   }
}
