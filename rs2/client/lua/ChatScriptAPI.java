// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua;

import tfu.Hf380;
import rs2.client.chat.G232;
import rs2.client.chat.ChatLine;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import rs2.client.N272;
import tfu.Af155;
import tfu.Gg3;
import tfu.El328;
import tfu.Eu326;
import rs2.client.client;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("Chat")
public class ChatScriptAPI
{
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void sendPrivateMessage(final String s, final String s2) {
        if ((client.ic && !client.iw) || client.io) {
            return;
        }
        final N272 i = client.i();
        final El328 d = El328.d(Eu326.MESSAGE_PRIVATE, i.s);
        Gg3.i(d.q, 0);
        final int v = d.q.v;
        d.q.af(s2);
        Af155.d(d.q, s);
        Gg3.as(d.q, d.q.v - v);
        N272.e(i, d);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static ChatLine getChatLine(final int n) {
        if (n < 0 || n >= 100) {
            return null;
        }
        return G232.q[n - 1];
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void sendPublicMessage(final String s) {
        final int n = 0;
        final int n2 = 0;
        final N272 i = client.i();
        final El328 d = El328.d(Eu326.MESSAGE_PUBLIC, i.s);
        Gg3.k(d.q, 0);
        final int v = d.q.v;
        Gg3.k(d.q, n);
        Gg3.k(d.q, n2);
        Af155.d(d.q, s);
        Gg3.ac(d.q, d.q.v - v);
        N272.e(i, d);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void sendFriendMessage(final String s, final String s2) {
        if ((client.ic && !client.iw) || client.io) {
            return;
        }
        final N272 i = client.i();
        final El328 d = El328.d(Eu326.MESSAGE_PRIVATE, i.s);
        Gg3.i(d.q, 0);
        final int v = d.q.v;
        d.q.af(s2);
        Af155.d(d.q, s);
        Gg3.as(d.q, d.q.v - v);
        N272.e(i, d);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void sendAbuseReport(final String s, String substring, final int n, final boolean b) {
        final int n2 = b ? 1 : 0;
        if (substring == null) {
            substring = "";
        }
        if (substring.length() > 80) {
            substring = substring.substring(0, 80);
        }
        final N272 i = client.i();
        final El328 d = El328.d(Eu326.SEND_SNAPSHOT, i.s);
        Gg3.k(d.q, Gg3.al(s) + 2 + Gg3.al(substring));
        d.q.af(s);
        Gg3.k(d.q, n - 1);
        Gg3.k(d.q, n2);
        d.q.af(substring);
        N272.e(i, d);
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
    public static void setFilter(final boolean je, final int n, final boolean jn) {
        client.jz = Hf380.g(n);
        if (client.jz == null) {
            client.jz = Hf380.FRIENDSONLY;
        }
        client.je = (je ? 1 : 0);
        client.jn = (jn ? 1 : 0);
        final N272 i = client.i();
        final El328 d = El328.d(Eu326.SET_CHATFILTERSETTINGS, i.s);
        Gg3.k(d.q, client.je);
        Gg3.k(d.q, client.jz.j);
        Gg3.k(d.q, client.jn);
        N272.e(i, d);
    }
}
