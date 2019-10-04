/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.xelement.Ap73;
import com.jagex.jnibindings.runetek6.Skeleton;
import java.util.ArrayList;
import tfu.N105;

public abstract class G104
extends Ap73 {
    static Thread g;
    GameEntity d;
    private N105 e;
    private Skeleton j;
    private long q;

    static N105 q(G104 g104) {
        N105 n105 = g104.e;
        g104.e = null;
        return n105;
    }

    G104(ArrayList arrayList, long l, Skeleton skeleton, N105 n105) {
        this.b = arrayList;
        this.q = l;
        this.j = skeleton;
        this.e = n105;
    }

    public GameEntity j() throws Exception {
        if (g != null && Thread.currentThread() != g) {
            throw new IllegalStateException();
        }
        if (this.d.getScene() == null) {
            G104.v(this);
            return null;
        }
        this.y();
        G104.r(this, this.d);
        return this.d;
    }

    static long g(G104 g104) {
        long l = g104.q;
        g104.q = 0L;
        return l;
    }

    static Skeleton d(G104 g104) {
        Skeleton skeleton = g104.j;
        g104.j = null;
        return skeleton;
    }
}

