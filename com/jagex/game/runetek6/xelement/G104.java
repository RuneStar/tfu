// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.ArrayList;
import com.jagex.jnibindings.runetek6.Skeleton;
import tfu.N105;
import com.jagex.game.runetek6.gameentity.GameEntity;

public abstract class G104 extends Ap73
{
    static Thread g;
    GameEntity d;
    private N105 e;
    private Skeleton j;
    private long q;
    
    static N105 q(final G104 g104) {
        final N105 e = g104.e;
        g104.e = null;
        return e;
    }
    
    G104(final ArrayList b, final long q, final Skeleton j, final N105 e) {
        super.b = b;
        this.q = q;
        this.j = j;
        this.e = e;
    }
    
    public GameEntity j() throws Exception {
        if (G104.g != null && Thread.currentThread() != G104.g) {
            throw new IllegalStateException();
        }
        if (this.d.getScene() == null) {
            Ap73.v(this);
            return null;
        }
        this.y();
        Ap73.r(this, this.d);
        return this.d;
    }
    
    static long g(final G104 g104) {
        final long q = g104.q;
        g104.q = 0L;
        return q;
    }
    
    static Skeleton d(final G104 g104) {
        final Skeleton j = g104.j;
        g104.j = null;
        return j;
    }
}
