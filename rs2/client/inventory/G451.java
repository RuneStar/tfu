// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.inventory;

import tfu.Ln265;
import tfu.Ha262;

public final class G451
{
    private static final Ha262 g;
    
    static {
        g = new Ha262(32);
    }
    
    public static ClientInventory g(final int n, final boolean b) {
        return (ClientInventory)Ha262.d(G451.g, n | (b ? Integer.MIN_VALUE : 0));
    }
    
    public static ClientInventory d(final int n, final boolean b) {
        final long n2 = n | (b ? Integer.MIN_VALUE : 0);
        ClientInventory clientInventory = (ClientInventory)Ha262.d(G451.g, n2);
        if (clientInventory == null) {
            clientInventory = new ClientInventory(n);
            Ha262.q(G451.g, clientInventory, n2);
        }
        return clientInventory;
    }
    
    public static void q(final int n, final boolean b) {
        final ClientInventory g = g(n, b);
        if (g == null) {
            return;
        }
        ClientInventory.d(g);
        g.d = true;
        Ln265.ef(g);
    }
    
    public static void j() {
        for (ClientInventory clientInventory = (ClientInventory)Ha262.e(G451.g); clientInventory != null; clientInventory = (ClientInventory)Ha262.h(G451.g)) {
            ClientInventory.d(clientInventory);
            clientInventory.d = true;
        }
        Ha262.j(G451.g);
    }
}
