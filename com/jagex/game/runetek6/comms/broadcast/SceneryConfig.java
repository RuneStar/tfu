// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import tfu.Gg3;

public class SceneryConfig
{
    public int collisionMask;
    public int[] originalElementAddresses;
    
    public static SceneryConfig DeserializeHelper(final byte[] array) {
        final Gg3 gg3 = new Gg3(array);
        final SceneryConfig sceneryConfig = new SceneryConfig();
        sceneryConfig.collisionMask = Gg3.bv(gg3);
        final int bn = Gg3.bn(gg3);
        if (bn > 0) {
            sceneryConfig.originalElementAddresses = new int[bn];
            for (int i = 0; i < bn; ++i) {
                sceneryConfig.originalElementAddresses[i] = Gg3.bn(gg3);
            }
        }
        return sceneryConfig;
    }
}
