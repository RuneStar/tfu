// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.maths.Quaternion;
import rs2.client.worldelement.Npc;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.event.EventHandler;

final class O396 extends EventHandler
{
    final /* synthetic */ Vector3 d;
    final /* synthetic */ Npc g;
    final /* synthetic */ Quaternion q;
    
    public static void g(final O396 o396, final XElement xElement, final Object o397) {
        o396.g.bi(xElement, o396.d, o396.q);
    }
    
    O396(final Npc g, final Vector3 d, final Quaternion q) {
        this.d = d;
        this.q = q;
        this.g = g;
    }
}
