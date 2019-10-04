package rs2.client.lua;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import rs2.client.N272;
import rs2.client.client;
import rs2.client.chat.ChatLine;
import rs2.client.chat.G232;
import tfu.Af155;
import tfu.Be2;
import tfu.Bs1;
import tfu.El328;
import tfu.Eu326;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Hf380;

@ScriptEntryClass("Chat")
public class ChatScriptAPI {
   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void sendPrivateMessage(String var0, String var1) {
      if ((!client.ic || client.iw) && !client.io) {
         N272 var2 = client.i();
         El328 var3 = El328.d(Eu326.MESSAGE_PRIVATE, var2.s);
         Gs329.i(var3.q, 0);
         int var4 = var3.q.v;
         var3.q.af(var1);
         Af155.d(var3.q, var0);
         Gs329.as(var3.q, var3.q.v - var4);
         N272.e(var2, var3);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static ChatLine getChatLine(int var0) {
      return var0 >= 0 && var0 < 100 ? G232.q[var0 - 1] : null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void sendPublicMessage(String var0) {
      byte var1 = 0;
      byte var2 = 0;
      N272 var3 = client.i();
      El328 var4 = El328.d(Eu326.MESSAGE_PUBLIC, var3.s);
      Gs329.k(var4.q, 0);
      int var5 = var4.q.v;
      Gs329.k(var4.q, var1);
      Gs329.k(var4.q, var2);
      Af155.d(var4.q, var0);
      Gs329.ac(var4.q, var4.q.v - var5);
      N272.e(var3, var4);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void sendFriendMessage(String var0, String var1) {
      if ((!client.ic || client.iw) && !client.io) {
         N272 var2 = client.i();
         El328 var3 = El328.d(Eu326.MESSAGE_PRIVATE, var2.s);
         Gs329.i(var3.q, 0);
         int var4 = var3.q.v;
         var3.q.af(var1);
         Af155.d(var3.q, var0);
         Gs329.as(var3.q, var3.q.v - var4);
         N272.e(var2, var3);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void sendAbuseReport(String var0, String var1, int var2, boolean var3) {
      int var4 = var3 ? 1 : 0;
      if (var1 == null) {
         var1 = "";
      }

      if (var1.length() > 80) {
         var1 = var1.substring(0, 80);
      }

      N272 var5 = client.i();
      El328 var6 = El328.d(Eu326.SEND_SNAPSHOT, var5.s);
      Gs329.k(var6.q, Gg3.al(var0) + 2 + Gg3.al(var1));
      var6.q.af(var0);
      Gs329.k(var6.q, var2 - 1);
      Gs329.k(var6.q, var4);
      var6.q.af(var1);
      N272.e(var5, var6);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean getFilterPublic() {
      return client.je == 1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getFilterPrivate() {
      return client.jz == null ? Hf380.OFF.j : client.jz.j;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean getFilterTrade() {
      return client.jn == 1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getHistorySize() {
      return G232.e();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setFilter(boolean var0, int var1, boolean var2) {
      client.jz = Hf380.g(var1);
      if (client.jz == null) {
         client.jz = Hf380.FRIENDSONLY;
      }

      client.je = var0 ? 1 : 0;
      client.jn = var2 ? 1 : 0;
      N272 var3 = client.i();
      El328 var4 = El328.d(Eu326.SET_CHATFILTERSETTINGS, var3.s);
      Gs329.k(var4.q, client.je);
      Gs329.k(var4.q, client.jz.j);
      Gs329.k(var4.q, client.jn);
      N272.e(var3, var4);
   }
}
