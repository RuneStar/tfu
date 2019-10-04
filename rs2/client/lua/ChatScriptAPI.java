/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import rs2.client.N272;
import rs2.client.chat.ChatLine;
import rs2.client.chat.G232;
import rs2.client.client;
import tfu.Af155;
import tfu.Be2;
import tfu.Bs1;
import tfu.El328;
import tfu.Eu326;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Hf380;
import tfu.Ic327;

@ScriptEntryClass(value="Chat")
public class ChatScriptAPI {
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void sendPrivateMessage(String string, String string2) {
        if (client.ic && !client.iw || client.io) {
            return;
        }
        N272 n272 = client.i();
        El328 el328 = El328.d(Eu326.MESSAGE_PRIVATE, n272.s);
        Gs329.i(el328.q, 0);
        int n = el328.q.v;
        el328.q.af(string2);
        Af155.d(el328.q, string);
        Gs329.as(el328.q, el328.q.v - n);
        N272.e(n272, el328);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static ChatLine getChatLine(int n) {
        if (n < 0 || n >= 100) {
            return null;
        }
        return G232.q[n - 1];
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void sendPublicMessage(String string) {
        int n = 0;
        int n2 = 0;
        N272 n272 = client.i();
        El328 el328 = El328.d(Eu326.MESSAGE_PUBLIC, n272.s);
        Gs329.k(el328.q, 0);
        int n3 = el328.q.v;
        Gs329.k(el328.q, n);
        Gs329.k(el328.q, n2);
        Af155.d(el328.q, string);
        Gs329.ac(el328.q, el328.q.v - n3);
        N272.e(n272, el328);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void sendFriendMessage(String string, String string2) {
        if (client.ic && !client.iw || client.io) {
            return;
        }
        N272 n272 = client.i();
        El328 el328 = El328.d(Eu326.MESSAGE_PRIVATE, n272.s);
        Gs329.i(el328.q, 0);
        int n = el328.q.v;
        el328.q.af(string2);
        Af155.d(el328.q, string);
        Gs329.as(el328.q, el328.q.v - n);
        N272.e(n272, el328);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void sendAbuseReport(String string, String string2, int n, boolean bl) {
        int n2;
        int n3 = n2 = bl ? 1 : 0;
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() > 80) {
            string2 = string2.substring(0, 80);
        }
        N272 n272 = client.i();
        El328 el328 = El328.d(Eu326.SEND_SNAPSHOT, n272.s);
        Gs329.k(el328.q, Gg3.al(string) + 2 + Gg3.al(string2));
        el328.q.af(string);
        Gs329.k(el328.q, n - 1);
        Gs329.k(el328.q, n2);
        el328.q.af(string2);
        N272.e(n272, el328);
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
        if (client.jz == null) {
            return Hf380.OFF.j;
        }
        return client.jz.j;
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
    public static void setFilter(boolean bl, int n, boolean bl2) {
        client.jz = Hf380.g(n);
        if (client.jz == null) {
            client.jz = Hf380.FRIENDSONLY;
        }
        client.je = bl ? 1 : 0;
        client.jn = bl2 ? 1 : 0;
        N272 n272 = client.i();
        El328 el328 = El328.d(Eu326.SET_CHATFILTERSETTINGS, n272.s);
        Gs329.k(el328.q, client.je);
        Gs329.k(el328.q, client.jz.j);
        Gs329.k(el328.q, client.jn);
        N272.e(n272, el328);
    }
}

