// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Lb33;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Br121;

final class An120 implements Br121
{
    final /* synthetic */ XElement[] d;
    final /* synthetic */ GameEntity g;
    final /* synthetic */ boolean j;
    final /* synthetic */ Vector3 q;
    
    @Override
    public boolean q() {
        return true;
    }
    
    public static G104 g(final An120 an120) throws Exception {
        return XElement.bj(an120.g, an120.d, an120.q, XElement.ai.j, an120.j && XElement.f);
    }
    
    @Override
    public boolean d() {
        return this.g.getScene() != null;
    }
    
    public static void j(final An120 an120, final G104 g104) {
        if (g104 != null) {
            Ap73.v(g104);
        }
    }
    
    @Override
    public int e() {
        int g = 0;
        Lb33.g(Lb33.XElement_CalculatePriority);
        try {
            if (this.d.length > 0) {
                Vector3 vector3 = null;
                if (this.d.length > 0 && this.d[0] != null) {
                    vector3 = this.d[0].ah;
                    if (vector3 != null && this.q != null) {
                        vector3 = Vector3.z(vector3, this.q);
                    }
                }
                if (vector3 == null) {
                    vector3 = this.g.getWorldTransform().trans;
                }
                g = XElement.ai.h.g(vector3);
            }
        }
        finally {
            Lb33.d(Lb33.XElement_CalculatePriority);
        }
        return g;
    }
    
    An120(final GameEntity g, final XElement[] d, final Vector3 q, final boolean j) {
        this.d = d;
        this.q = q;
        this.j = j;
        this.g = g;
    }
}
