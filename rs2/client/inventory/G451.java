/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.inventory;

import rs2.client.inventory.ClientInventory;
import tfu.Ha262;

public final class G451 {
    private static final Ha262 g = new Ha262(32);

    public static ClientInventory g(int n, boolean bl) {
        long l = n | (bl ? Integer.MIN_VALUE : 0);
        return (ClientInventory)Ha262.d(g, l);
    }

    public static ClientInventory d(int n, boolean bl) {
        long l = n | (bl ? Integer.MIN_VALUE : 0);
        ClientInventory clientInventory = (ClientInventory)Ha262.d(g, l);
        if (clientInventory == null) {
            clientInventory = new ClientInventory(n);
            Ha262.q(g, clientInventory, l);
        }
        return clientInventory;
    }

    public static void q(int n, boolean bl) {
        ClientInventory clientInventory = G451.g(n, bl);
        if (clientInventory == null) {
            return;
        }
        ClientInventory.d(clientInventory);
        clientInventory.d = true;
        ClientInventory.ef(clientInventory);
    }

    public static void j() {
        ClientInventory clientInventory = (ClientInventory)Ha262.e(g);
        while (clientInventory != null) {
            ClientInventory.d(clientInventory);
            clientInventory.d = true;
            clientInventory = (ClientInventory)Ha262.h(g);
        }
        Ha262.j(g);
    }
}

