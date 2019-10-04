// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import tfu.Bb4;
import com.jagex.maths.ScaleRotTrans;

public class BroadcastStateAndEventsTypes$AppearedPayload extends BroadcastStateAndEventsTypes$MessagePayload
{
    public ScaleRotTrans transform;
    
    public BroadcastStateAndEventsTypes$AppearedPayload(final Bb4 bb4, final String s, final int n, final ScaleRotTrans transform) {
        super(bb4, s, n);
        this.transform = transform;
    }
}
