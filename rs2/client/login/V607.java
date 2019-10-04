package rs2.client.login;

import tfu.Mf509;

// $FF: synthetic class
class V607 {
   // $FF: synthetic field
   static final int[] d = new int[L606.values().length];
   // $FF: synthetic field
   static final int[] g;

   static {
      try {
         d[L606.DELAY.ordinal()] = 1;
      } catch (NoSuchFieldError var22) {
      }

      try {
         d[L606.CONNECT_UDP.ordinal()] = 2;
      } catch (NoSuchFieldError var21) {
      }

      try {
         d[L606.CONNECT_TCP.ordinal()] = 3;
      } catch (NoSuchFieldError var20) {
      }

      try {
         d[L606.WAIT_FOR_CONNECTION_ACK.ordinal()] = 4;
      } catch (NoSuchFieldError var19) {
      }

      try {
         d[L606.SEND_LOGIN_REQUEST.ordinal()] = 5;
      } catch (NoSuchFieldError var18) {
      }

      try {
         d[L606.WAIT_FOR_LOGIN_RESPONSE.ordinal()] = 6;
      } catch (NoSuchFieldError var17) {
      }

      try {
         d[L606.WAIT_FOR_HOP_BLOCK_DURATION.ordinal()] = 7;
      } catch (NoSuchFieldError var16) {
      }

      try {
         d[L606.WAIT_FOR_QUEUE_POSITION.ordinal()] = 8;
      } catch (NoSuchFieldError var15) {
      }

      try {
         d[L606.WAIT_FOR_SCRIPT_DISALLOW_REASON.ordinal()] = 9;
      } catch (NoSuchFieldError var14) {
      }

      try {
         d[L606.WAIT_FOR_LOGIN_OK_LENGTH.ordinal()] = 10;
      } catch (NoSuchFieldError var13) {
      }

      try {
         d[L606.WAIT_FOR_LOGIN_DETAILS.ordinal()] = 11;
      } catch (NoSuchFieldError var12) {
      }

      try {
         d[L606.WAIT_FOR_PLAYER_PACKET_LENGTH1.ordinal()] = 12;
      } catch (NoSuchFieldError var11) {
      }

      try {
         d[L606.WAIT_FOR_PLAYER_PACKET_LENGTH2.ordinal()] = 13;
      } catch (NoSuchFieldError var10) {
      }

      try {
         d[L606.WAIT_FOR_UDP_LOGIN_RECONNECT.ordinal()] = 14;
      } catch (NoSuchFieldError var9) {
      }

      try {
         d[L606.WAIT_FOR_PLAYER_PACKET.ordinal()] = 15;
      } catch (NoSuchFieldError var8) {
      }

      try {
         d[L606.WAIT_FOR_UDP_LOGIN.ordinal()] = 16;
      } catch (NoSuchFieldError var7) {
      }

      g = new int[Mf509.values().length];

      try {
         g[Mf509.OK.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
      }

      try {
         g[Mf509.RECONNECT_OK.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
      }

      try {
         g[Mf509.DISALLOWED_BY_SCRIPT.ordinal()] = 3;
      } catch (NoSuchFieldError var4) {
      }

      try {
         g[Mf509.HOP_BLOCKED.ordinal()] = 4;
      } catch (NoSuchFieldError var3) {
      }

      try {
         g[Mf509.IN_QUEUE.ordinal()] = 5;
      } catch (NoSuchFieldError var2) {
      }

      try {
         g[Mf509.INVALID_SINGLE_SIGNON.ordinal()] = 6;
      } catch (NoSuchFieldError var1) {
      }

   }
}
