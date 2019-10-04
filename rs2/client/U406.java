/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import rs2.client.Ag389;
import rs2.client.inventory.ClientInventory;
import rs2.client.worldelement.player;
import tfu.Gc330;

final class U406
extends Ag389 {
    final /* synthetic */ ClientInventory g;

    @Override
    public String toString() {
        return "INV_TRANSMIT full " + this.g;
    }

    U406(ClientInventory clientInventory) {
        this.g = clientInventory;
    }

    @Override
    protected void d() {
        player player2 = Gc330.j();
        player2.eh("INV_TRANSMIT", new Object[]{this.g, true});
    }

    @Override
    protected void g() {
    }
}

