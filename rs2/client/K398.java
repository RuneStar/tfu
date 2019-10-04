// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import tfu.Gc330;
import java.util.Collection;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Az399;
import com.jagex.jnibindings.runetek6.LuaRef;

final class K398 extends Ag389
{
    LuaRef g;
    final /* synthetic */ Az399 d;
    
    @Override
    protected void g() {
        GameEntity.em(super.q, new P397(this));
    }
    
    @Override
    protected void d() {
        Gc330.j().triggerEvent(this.d.j, this.g);
    }
    
    @Override
    public String toString() {
        return "script message " + this.d.e + ":" + this.d.h;
    }
    
    K398(final Az399 d) {
        this.d = d;
    }
}
