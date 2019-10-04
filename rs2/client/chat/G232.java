/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.chat;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptManager;
import rs2.client.chat.ChatLine;
import rs2.client.client;
import rs2.client.worldelement.player;
import tfu.Bb4;

public class G232 {
    private static int d;
    public static final int g = 100;
    private static int j;
    public static final ChatLine[] q;

    public static int e() {
        return d;
    }

    public static void d(int n, String string) {
        G232.q(n, 0, "", "", "", string);
    }

    public static void j(int n, int n2, String string, String string2, String string3, String string4, String string5, int n3) {
        Object[] arrobject;
        ChatLine chatLine = q[99];
        for (int i = 99; i > 0; --i) {
            G232.q[i] = q[i - 1];
        }
        if (chatLine == null) {
            chatLine = new ChatLine(n, n2, string, string2, string3, string5, n3, string4);
        } else {
            ChatLine.g(chatLine, n, n2, string, string2, string3, string5, n3, string4);
        }
        G232.q[0] = chatLine;
        ++d;
        player player2 = null;
        if (string.startsWith("PLAYER:")) {
            arrobject = Bb4.g(string2);
            GameEntity gameEntity = GameEntity.es((Bb4)arrobject);
            if (gameEntity == null) {
                string = "Unknown";
            } else if (gameEntity instanceof player) {
                player2 = (player)gameEntity;
                string = player2.aq;
            }
        }
        arrobject = new Object[]{string4, string == null || string.equals("") ? null : string, string5 == null || string5.equals("") ? null : string5, n, n2, player2};
        client.cj.event.triggerEvent("CHAT", (Object)arrobject);
    }

    public static void q(int n, int n2, String string, String string2, String string3, String string4) {
        G232.j(n, n2, string, string2, string3, string4, null, -1);
    }

    static {
        q = new ChatLine[100];
        j = 0;
    }

    public static void h() {
        for (int i = 0; i < 100; ++i) {
            G232.q[i] = null;
        }
        d = 0;
    }

    static int g() {
        return j++;
    }
}

