/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import java.util.List;
import rs2.client.Ag389;
import rs2.client.inventory.ClientInventory;
import rs2.client.worldelement.player;
import tfu.Gc330;

final class Y388
extends Ag389 {
    final /* synthetic */ List d;
    final /* synthetic */ ClientInventory g;

    @Override
    public String toString() {
        return "INV_TRANSMIT partial " + this.g;
    }

    @Override
    protected void g() {
    }

    @Override
    protected void d() {
        player player2 = Gc330.j();
        player2.eh("INV_TRANSMIT", new Object[]{this.g, false, this.d});
    }

    Y388(ClientInventory clientInventory, List list) {
        this.d = list;
        this.g = clientInventory;
    }
}

