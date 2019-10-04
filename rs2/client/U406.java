// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import tfu.Gc330;
import rs2.client.inventory.ClientInventory;

final class U406 extends Ag389
{
    final /* synthetic */ ClientInventory g;
    
    @Override
    public String toString() {
        return "INV_TRANSMIT full " + this.g;
    }
    
    U406(final ClientInventory g) {
        this.g = g;
    }
    
    @Override
    protected void d() {
        Gc330.j().eh("INV_TRANSMIT", new Object[] { this.g, true });
    }
    
    @Override
    protected void g() {
    }
}
