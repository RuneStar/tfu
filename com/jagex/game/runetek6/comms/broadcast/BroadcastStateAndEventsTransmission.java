// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import com.jagex.maths.Quaternion;
import tfu.Bb4;
import tfu.Gg3;

public class BroadcastStateAndEventsTransmission
{
    public static BroadcastStateAndEventsTypes$AppearedPayload UnpackAppearedMessage(final Gg3 gg3) {
        return new BroadcastStateAndEventsTypes$AppearedPayload(Bb4.j(gg3), Gg3.bk(gg3), Gg3.bn(gg3), new ScaleRotTrans(Gg3.bl(gg3), Quaternion.d(gg3), Vector3.d(gg3)));
    }
    
    private static void PackMessageBody(final Gg3 gg3, final BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition, final BroadcastStateAndEventsTypes$DataMessagePayload broadcastStateAndEventsTypes$DataMessagePayload) {
        gg3.af(broadcastStateAndEventsTypes$MessageDefinition.messageName);
        Gg3.ab(gg3, broadcastStateAndEventsTypes$DataMessagePayload.wire_data.length);
        Gg3.aa(gg3, broadcastStateAndEventsTypes$DataMessagePayload.wire_data, 0, broadcastStateAndEventsTypes$DataMessagePayload.wire_data.length);
        broadcastStateAndEventsTypes$DataMessagePayload.broadcasterID.q(gg3);
        gg3.af((broadcastStateAndEventsTypes$DataMessagePayload.wranglerID == null) ? "" : broadcastStateAndEventsTypes$DataMessagePayload.wranglerID);
        Gg3.ab(gg3, broadcastStateAndEventsTypes$DataMessagePayload.areaID);
    }
    
    public static void PackEventMessage(final Gg3 gg3, final BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition, final BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
        PackMessageBody(gg3, broadcastStateAndEventsTypes$EventDefinition, broadcastStateAndEventsTypes$EventPayload);
    }
    
    public static void PackStateMessage(final Gg3 gg3, final BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition, final BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload) {
        PackMessageBody(gg3, broadcastStateAndEventsTypes$StateDefinition, broadcastStateAndEventsTypes$StatePayload);
    }
    
    public static BroadcastStateAndEventsTypes$GonePayload UnpackGoneMessage(final Gg3 gg3) {
        return new BroadcastStateAndEventsTypes$GonePayload(Bb4.j(gg3), Gg3.bk(gg3), Gg3.bn(gg3));
    }
    
    public static BroadcastStateAndEventsTypes$EventDefinition UnpackEventMessage(final Gg3 gg3, final BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
        return BroadcastStateAndEventsTypes.getEventDefinition(UnpackMessageBody(gg3, broadcastStateAndEventsTypes$EventPayload));
    }
    
    public static BroadcastStateAndEventsTypes$StateDefinition UnpackStateMessage(final Gg3 gg3, final BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload) {
        return BroadcastStateAndEventsTypes.getStateDefinition(UnpackMessageBody(gg3, broadcastStateAndEventsTypes$StatePayload));
    }
    
    private static String UnpackMessageBody(final Gg3 gg3, final BroadcastStateAndEventsTypes$DataMessagePayload broadcastStateAndEventsTypes$DataMessagePayload) {
        final String bk = Gg3.bk(gg3);
        final int bn = Gg3.bn(gg3);
        final byte[] wire_data = new byte[bn];
        Gg3.bx(gg3, wire_data, 0, bn);
        broadcastStateAndEventsTypes$DataMessagePayload.wire_data = wire_data;
        broadcastStateAndEventsTypes$DataMessagePayload.broadcasterID = Bb4.j(gg3);
        broadcastStateAndEventsTypes$DataMessagePayload.wranglerID = Gg3.bk(gg3);
        broadcastStateAndEventsTypes$DataMessagePayload.areaID = Gg3.bn(gg3);
        return bk;
    }
}
