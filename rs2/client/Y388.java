// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import tfu.Gc330;
import rs2.client.inventory.ClientInventory;
import java.util.List;

final class Y388 extends Ag389
{
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
        Gc330.j().eh("INV_TRANSMIT", new Object[] { this.g, false, this.d });
    }
    
    Y388(final ClientInventory g, final List d) {
        this.d = d;
        this.g = g;
    }
}
