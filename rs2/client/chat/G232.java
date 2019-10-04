// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.chat;

import rs2.client.client;
import rs2.client.worldelement.player;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Bb4;

public class G232
{
    private static int d;
    public static final int g = 100;
    private static int j;
    public static final ChatLine[] q;
    
    public static int e() {
        return G232.d;
    }
    
    public static void d(final int n, final String s) {
        q(n, 0, "", "", "", s);
    }
    
    public static void j(final int i, final int j, String aq, final String s, final String s2, final String s3, final String s4, final int n) {
        ChatLine chatLine = G232.q[99];
        for (int k = 99; k > 0; --k) {
            G232.q[k] = G232.q[k - 1];
        }
        if (chatLine == null) {
            chatLine = new ChatLine(i, j, aq, s, s2, s4, n, s3);
        }
        else {
            ChatLine.g(chatLine, i, j, aq, s, s2, s4, n, s3);
        }
        G232.q[0] = chatLine;
        ++G232.d;
        player player = null;
        if (aq.startsWith("PLAYER:")) {
            final GameEntity es = GameEntity.es(Bb4.g(s));
            if (es == null) {
                aq = "Unknown";
            }
            else if (es instanceof player) {
                player = (player)es;
                aq = player.aq;
            }
        }
        client.cj.event.triggerEvent("CHAT", new Object[] { s3, (aq == null || aq.equals("")) ? null : aq, (s4 == null || s4.equals("")) ? null : s4, i, j, player });
    }
    
    public static void q(final int n, final int n2, final String s, final String s2, final String s3, final String s4) {
        j(n, n2, s, s2, s3, s4, null, -1);
    }
    
    static {
        q = new ChatLine[100];
        G232.j = 0;
    }
    
    public static void h() {
        for (int i = 0; i < 100; ++i) {
            G232.q[i] = null;
        }
        G232.d = 0;
    }
    
    static int g() {
        return G232.j++;
    }
}
