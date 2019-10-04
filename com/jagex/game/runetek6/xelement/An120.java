/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.xelement.Am76;
import com.jagex.game.runetek6.xelement.Bk68;
import com.jagex.game.runetek6.xelement.G104;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import tfu.Br121;
import tfu.Hi86;
import tfu.Lb33;

final class An120
implements Br121 {
    final /* synthetic */ XElement[] d;
    final /* synthetic */ GameEntity g;
    final /* synthetic */ boolean j;
    final /* synthetic */ Vector3 q;

    @Override
    public boolean q() {
        return true;
    }

    public static G104 g(An120 an120) throws Exception {
        G104 g104 = XElement.bj(an120.g, an120.d, an120.q, XElement.ai.j, an120.j && XElement.f);
        return g104;
    }

    @Override
    public boolean d() {
        return this.g.getScene() != null;
    }

    public static void j(An120 an120, G104 g104) {
        if (g104 != null) {
            G104.v(g104);
        }
    }

    @Override
    public int e() {
        int n = 0;
        Lb33.g(Lb33.XElement_CalculatePriority);
        try {
            if (this.d.length > 0) {
                Vector3 vector3 = null;
                if (this.d.length > 0 && this.d[0] != null && (vector3 = this.d[0].ah) != null && this.q != null) {
                    vector3 = Vector3.z(vector3, this.q);
                }
                if (vector3 == null) {
                    vector3 = this.g.getWorldTransform().trans;
                }
                n = XElement.ai.h.g(vector3);
            }
            Lb33.d(Lb33.XElement_CalculatePriority);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.XElement_CalculatePriority);
            throw throwable;
        }
        return n;
    }

    An120(GameEntity gameEntity, XElement[] arrxElement, Vector3 vector3, boolean bl) {
        this.d = arrxElement;
        this.q = vector3;
        this.j = bl;
        this.g = gameEntity;
    }
}

