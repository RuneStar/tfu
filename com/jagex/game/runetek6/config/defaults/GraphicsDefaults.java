/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.defaults;

import com.jagex.game.runetek6.config.defaults.DefaultsGroup;
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

    public GraphicsDefaults(js5 js52) {
        byte[] arrby = js5.v(js52, DefaultsGroup.GRAPHICS.js5GroupId);
        this.decode(new Gg3(arrby));
    }

    private void decode(Gg3 gg3) {
        int n;
        boolean bl = false;
        while ((n = Gg3.ar(gg3)) != 0) {
            int n2;
            if (n == 1) {
                if (this.hitmarkpos_x == null) {
                    this.maxhitmarks = 4;
                    this.hitmarkpos_x = new int[4];
                    this.hitmarkpos_y = new int[4];
                }
                for (n2 = 0; n2 < this.hitmarkpos_x.length; ++n2) {
                    this.hitmarkpos_x[n2] = Gg3.ak(gg3);
                    this.hitmarkpos_y[n2] = Gg3.ak(gg3);
                }
                bl = true;
                continue;
            }
            if (n == 2) {
                Gg3.bf(gg3);
                continue;
            }
            if (n == 3) {
                this.maxhitmarks = Gg3.ar(gg3);
                this.hitmarkpos_x = new int[this.maxhitmarks];
                this.hitmarkpos_y = new int[this.maxhitmarks];
                continue;
            }
            if (n == 5) {
                this.login_interface = Gg3.ay(gg3);
                continue;
            }
            if (n == 6) {
                this.lobby_interface = Gg3.ay(gg3);
                continue;
            }
            if (n == 7) {
                for (n2 = 0; n2 < 10; ++n2) {
                    for (int i = 0; i < 4; ++i) {
                        Gg3.au(gg3);
                        int n3 = Gg3.au(gg3);
                        for (int j = 0; j < n3; ++j) {
                            Gg3.au(gg3);
                        }
                    }
                }
                continue;
            }
            if (n == 8) {
                this.npcShouldDisplayChat = false;
                continue;
            }
            if (n == 9) {
                this.npcChatTimeout = Gg3.ar(gg3);
                continue;
            }
            if (n == 10) {
                this.playerShouldDisplayChat = false;
                continue;
            }
            if (n != 11) continue;
            this.playerChatTimeout = Gg3.ar(gg3);
        }
        if (!bl) {
            if (this.hitmarkpos_x == null) {
                this.maxhitmarks = 4;
                this.hitmarkpos_x = new int[4];
                this.hitmarkpos_y = new int[4];
            }
            for (n = 0; n < this.hitmarkpos_x.length; ++n) {
                this.hitmarkpos_x[n] = 0;
                this.hitmarkpos_y[n] = n * 20;
            }
        }
    }
}

