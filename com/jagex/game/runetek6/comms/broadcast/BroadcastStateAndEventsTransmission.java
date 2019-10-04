package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.maths.Quaternion;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import tfu.Bb4;
import tfu.Gg3;

public class BroadcastStateAndEventsTransmission {
   public static BroadcastStateAndEventsTypes$AppearedPayload UnpackAppearedMessage(Gg3 var0) {
      Bb4 var1 = Bb4.j(var0);
      String var2 = Gg3.bk(var0);
      int var3 = Gg3.bn(var0);
      ScaleRotTrans var4 = new ScaleRotTrans(Gg3.bl(var0), Quaternion.d(var0), Vector3.d(var0));
      return new BroadcastStateAndEventsTypes$AppearedPayload(var1, var2, var3, var4);
   }

   private static void PackMessageBody(Gg3 var0, BroadcastStateAndEventsTypes$MessageDefinition var1, BroadcastStateAndEventsTypes$DataMessagePayload var2) {
      var0.af(var1.messageName);
      Gg3.ab(var0, var2.wire_data.length);
      Gg3.aa(var0, var2.wire_data, 0, var2.wire_data.length);
      var2.broadcasterID.q(var0);
      var0.af(var2.wranglerID == null ? "" : var2.wranglerID);
      Gg3.ab(var0, var2.areaID);
   }

   public static void PackEventMessage(Gg3 var0, BroadcastStateAndEventsTypes$EventDefinition var1, BroadcastStateAndEventsTypes$EventPayload var2) {
      PackMessageBody(var0, var1, var2);
   }

   public static void PackStateMessage(Gg3 var0, BroadcastStateAndEventsTypes$StateDefinition var1, BroadcastStateAndEventsTypes$StatePayload var2) {
      PackMessageBody(var0, var1, var2);
   }

   public static BroadcastStateAndEventsTypes$GonePayload UnpackGoneMessage(Gg3 var0) {
      Bb4 var1 = Bb4.j(var0);
      String var2 = Gg3.bk(var0);
      int var3 = Gg3.bn(var0);
      return new BroadcastStateAndEventsTypes$GonePayload(var1, var2, var3);
   }

   public static BroadcastStateAndEventsTypes$EventDefinition UnpackEventMessage(Gg3 var0, BroadcastStateAndEventsTypes$EventPayload var1) {
      String var2 = UnpackMessageBody(var0, var1);
      return BroadcastStateAndEventsTypes.getEventDefinition(var2);
   }

   public static BroadcastStateAndEventsTypes$StateDefinition UnpackStateMessage(Gg3 var0, BroadcastStateAndEventsTypes$StatePayload var1) {
      String var2 = UnpackMessageBody(var0, var1);
      return BroadcastStateAndEventsTypes.getStateDefinition(var2);
   }

   private static String UnpackMessageBody(Gg3 var0, BroadcastStateAndEventsTypes$DataMessagePayload var1) {
      String var2 = Gg3.bk(var0);
      int var3 = Gg3.bn(var0);
      byte[] var4 = new byte[var3];
      Gg3.bx(var0, var4, 0, var3);
      var1.wire_data = var4;
      var1.broadcasterID = Bb4.j(var0);
      var1.wranglerID = Gg3.bk(var0);
      var1.areaID = Gg3.bn(var0);
      return var2;
   }
}
