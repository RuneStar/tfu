/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$DataMessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessageDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.maths.Quaternion;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import tfu.Bb4;
import tfu.Gg3;

public class BroadcastStateAndEventsTransmission {
    public static BroadcastStateAndEventsTypes$AppearedPayload UnpackAppearedMessage(Gg3 gg3) {
        Bb4 bb4 = Bb4.j(gg3);
        String string = Gg3.bk(gg3);
        int n = Gg3.bn(gg3);
        ScaleRotTrans scaleRotTrans = new ScaleRotTrans(Gg3.bl(gg3), Quaternion.d(gg3), Vector3.d(gg3));
        return new BroadcastStateAndEventsTypes$AppearedPayload(bb4, string, n, scaleRotTrans);
    }

    private static void PackMessageBody(Gg3 gg3, BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition, BroadcastStateAndEventsTypes$DataMessagePayload broadcastStateAndEventsTypes$DataMessagePayload) {
        gg3.af(broadcastStateAndEventsTypes$MessageDefinition.messageName);
        Gg3.ab(gg3, broadcastStateAndEventsTypes$DataMessagePayload.wire_data.length);
        Gg3.aa(gg3, broadcastStateAndEventsTypes$DataMessagePayload.wire_data, 0, broadcastStateAndEventsTypes$DataMessagePayload.wire_data.length);
        broadcastStateAndEventsTypes$DataMessagePayload.broadcasterID.q(gg3);
        gg3.af(broadcastStateAndEventsTypes$DataMessagePayload.wranglerID == null ? "" : broadcastStateAndEventsTypes$DataMessagePayload.wranglerID);
        Gg3.ab(gg3, broadcastStateAndEventsTypes$DataMessagePayload.areaID);
    }

    public static void PackEventMessage(Gg3 gg3, BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition, BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
        BroadcastStateAndEventsTransmission.PackMessageBody(gg3, broadcastStateAndEventsTypes$EventDefinition, broadcastStateAndEventsTypes$EventPayload);
    }

    public static void PackStateMessage(Gg3 gg3, BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition, BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload) {
        BroadcastStateAndEventsTransmission.PackMessageBody(gg3, broadcastStateAndEventsTypes$StateDefinition, broadcastStateAndEventsTypes$StatePayload);
    }

    public static BroadcastStateAndEventsTypes$GonePayload UnpackGoneMessage(Gg3 gg3) {
        Bb4 bb4 = Bb4.j(gg3);
        String string = Gg3.bk(gg3);
        int n = Gg3.bn(gg3);
        return new BroadcastStateAndEventsTypes$GonePayload(bb4, string, n);
    }

    public static BroadcastStateAndEventsTypes$EventDefinition UnpackEventMessage(Gg3 gg3, BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload) {
        String string = BroadcastStateAndEventsTransmission.UnpackMessageBody(gg3, broadcastStateAndEventsTypes$EventPayload);
        return BroadcastStateAndEventsTypes.getEventDefinition(string);
    }

    public static BroadcastStateAndEventsTypes$StateDefinition UnpackStateMessage(Gg3 gg3, BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload) {
        String string = BroadcastStateAndEventsTransmission.UnpackMessageBody(gg3, broadcastStateAndEventsTypes$StatePayload);
        return BroadcastStateAndEventsTypes.getStateDefinition(string);
    }

    private static String UnpackMessageBody(Gg3 gg3, BroadcastStateAndEventsTypes$DataMessagePayload broadcastStateAndEventsTypes$DataMessagePayload) {
        String string = Gg3.bk(gg3);
        int n = Gg3.bn(gg3);
        byte[] arrby = new byte[n];
        Gg3.bx(gg3, arrby, 0, n);
        broadcastStateAndEventsTypes$DataMessagePayload.wire_data = arrby;
        broadcastStateAndEventsTypes$DataMessagePayload.broadcasterID = Bb4.j(gg3);
        broadcastStateAndEventsTypes$DataMessagePayload.wranglerID = Gg3.bk(gg3);
        broadcastStateAndEventsTypes$DataMessagePayload.areaID = Gg3.bn(gg3);
        return string;
    }
}

