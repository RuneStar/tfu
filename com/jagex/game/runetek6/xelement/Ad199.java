/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.xelement.Bk68;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import tfu.Mz200;

class Ad199
implements Mz200 {
    final /* synthetic */ XElementLibrary d;
    final /* synthetic */ GameEntity g;

    @Override
    public int g() {
        return this.d.h.g(this.g.getWorldTransform().trans);
    }

    Ad199(XElementLibrary xElementLibrary, GameEntity gameEntity) {
        this.g = gameEntity;
        this.d = xElementLibrary;
    }
}

