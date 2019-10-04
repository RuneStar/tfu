// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import java.io.IOException;
import rs2.client.client;
import com.jagex.game.runetek6.event.EventHandler;

class S34 extends EventHandler
{
    final /* synthetic */ player g;
    
    @Override
    public void trigger(final Object o, final Object o2) {
        try {
            client.dq.sendOutgoingPackets();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    S34(final player g) {
        this.g = g;
    }
}
