// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.defaults;

import tfu.Gg3;
import com.jagex.js5.js5;

public class GraphicsDefaults
{
    public static final int DEFAULT_MAXHITMARKS = 4;
    public int[] hitmarkpos_x;
    public int[] hitmarkpos_y;
    public int lobby_interface;
    public int login_interface;
    public int maxhitmarks;
    public int npcChatTimeout;
    public boolean npcShouldDisplayChat;
    public int playerChatTimeout;
    public boolean playerShouldDisplayChat;
    
    public GraphicsDefaults(final js5 js5) {
        this.maxhitmarks = 4;
        this.hitmarkpos_x = null;
        this.hitmarkpos_y = null;
        this.npcShouldDisplayChat = true;
        this.npcChatTimeout = 2;
        this.playerShouldDisplayChat = true;
        this.playerChatTimeout = 3;
        this.decode(new Gg3(js5.v(js5, DefaultsGroup.GRAPHICS.js5GroupId)));
    }
    
    private void decode(final Gg3 gg3) {
        boolean b = false;
        while (true) {
            final int ar = Gg3.ar(gg3);
            if (ar == 0) {
                break;
            }
            if (ar == 1) {
                if (this.hitmarkpos_x == null) {
                    this.maxhitmarks = 4;
                    this.hitmarkpos_x = new int[4];
                    this.hitmarkpos_y = new int[4];
                }
                for (int i = 0; i < this.hitmarkpos_x.length; ++i) {
                    this.hitmarkpos_x[i] = Gg3.ak(gg3);
                    this.hitmarkpos_y[i] = Gg3.ak(gg3);
                }
                b = true;
            }
            else if (ar == 2) {
                Gg3.bf(gg3);
            }
            else if (ar == 3) {
                this.maxhitmarks = Gg3.ar(gg3);
                this.hitmarkpos_x = new int[this.maxhitmarks];
                this.hitmarkpos_y = new int[this.maxhitmarks];
            }
            else if (ar == 5) {
                this.login_interface = Gg3.ay(gg3);
            }
            else if (ar == 6) {
                this.lobby_interface = Gg3.ay(gg3);
            }
            else if (ar == 7) {
                for (int j = 0; j < 10; ++j) {
                    for (int k = 0; k < 4; ++k) {
                        Gg3.au(gg3);
                        for (int au = Gg3.au(gg3), l = 0; l < au; ++l) {
                            Gg3.au(gg3);
                        }
                    }
                }
            }
            else if (ar == 8) {
                this.npcShouldDisplayChat = false;
            }
            else if (ar == 9) {
                this.npcChatTimeout = Gg3.ar(gg3);
            }
            else if (ar == 10) {
                this.playerShouldDisplayChat = false;
            }
            else {
                if (ar != 11) {
                    continue;
                }
                this.playerChatTimeout = Gg3.ar(gg3);
            }
        }
        if (!b) {
            if (this.hitmarkpos_x == null) {
                this.maxhitmarks = 4;
                this.hitmarkpos_x = new int[4];
                this.hitmarkpos_y = new int[4];
            }
            for (int n = 0; n < this.hitmarkpos_x.length; ++n) {
                this.hitmarkpos_x[n] = 0;
                this.hitmarkpos_y[n] = n * 20;
            }
        }
    }
}
