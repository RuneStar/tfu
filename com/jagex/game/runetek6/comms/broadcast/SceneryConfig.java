/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import tfu.Gg3;

public class SceneryConfig {
    public int collisionMask;
    public int[] originalElementAddresses;

    public static SceneryConfig DeserializeHelper(byte[] arrby) {
        Gg3 gg3 = new Gg3(arrby);
        SceneryConfig sceneryConfig = new SceneryConfig();
        sceneryConfig.collisionMask = Gg3.bv(gg3);
        int n = Gg3.bn(gg3);
        if (n > 0) {
            sceneryConfig.originalElementAddresses = new int[n];
            for (int i = 0; i < n; ++i) {
                sceneryConfig.originalElementAddresses[i] = Gg3.bn(gg3);
            }
        }
        return sceneryConfig;
    }
}

