// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.event.ScriptEventHandler;
import java.util.Iterator;
import com.jagex.game.runetek6.event.EventHandler;
import java.util.Map;
import java.util.HashMap;
import com.jagex.game.runetek6.gameentity.Component;
import java.io.Serializable;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import tfu.N105;
import com.jagex.jnibindings.runetek6.Skeleton;
import java.util.ArrayList;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.maths.Vector3;
import tfu.Iz11;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;

final class Aw103 extends G104
{
    final /* synthetic */ XElement[] l;
    final /* synthetic */ boolean p;
    final /* synthetic */ MappedEventComponent r;
    final /* synthetic */ Iz11 v;
    final /* synthetic */ Vector3 w;
    final /* synthetic */ AnimationGraphComponent y;
    
    @Override
    void p() {
        GameEntity.fv(G104.g(this), G104.d(this), G104.q(this));
        if (this.y != null) {
            this.y.bd();
        }
    }
    
    Aw103(final ArrayList list, final long n, final Skeleton skeleton, final N105 n2, final XElement[] l, final Vector3 w, final MappedEventComponent r, final Iz11 v, final AnimationGraphComponent y, final boolean p10) {
        this.w = w;
        this.r = r;
        this.v = v;
        this.y = y;
        this.p = p10;
        super(list, n, skeleton, n2);
        this.l = l;
    }
    
    GameEntity k() {
        final XElement[] l = this.l;
        for (int length = l.length, i = 0; i < length; ++i) {
            bp(l[i], super.d);
        }
        if (this.l.length > 0) {
            bx(this.l[0], super.d, this.w);
        }
        int n = 0;
        for (int j = 0; j < this.l.length; ++j) {
            if (this.l[j].h != null) {
                ++n;
            }
        }
        super.d.bi = new Serializable[n];
        int n2 = 0;
        for (int k = 0; k < this.l.length; ++k) {
            if (this.l[k].h != null) {
                super.d.bi[n2++] = this.l[k].h;
            }
        }
        if (XElement.q) {
            super.d.bt = new XElement[this.l.length];
            for (int n3 = 0; n3 < this.l.length; ++n3) {
                super.d.bt[n3] = this.l[n3];
            }
        }
        if (this.r != null) {
            GameEntity.ep(super.d, this.r);
        }
        if (this.v != null) {
            super.d.cj = this.v;
        }
        GameEntity.eo(super.d, AnimationGraphComponent.class);
        GameEntity.en(super.d, G104.g(this), G104.d(this), G104.q(this));
        final HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
        final XElement[] m = this.l;
        for (int length2 = m.length, n4 = 0; n4 < length2; ++n4) {
            final Map as = m[n4].as();
            for (final Integer n5 : as.keySet()) {
                if (!hashMap.containsKey(n5)) {
                    hashMap.put(n5, as.get(n5));
                }
            }
        }
        GameEntity.ef(super.d);
        for (final Map.Entry<Integer, Object> entry : hashMap.entrySet()) {
            try {
                final ScriptEventHandler eventHandler = super.d.bz.createEventHandler(entry.getValue(), null);
                eventHandler.staticallyConfigured = true;
                super.d.addEventHandlerByID(entry.getKey(), eventHandler);
            }
            catch (Exception ex) {
                XElement.logger.error("Error processing ScriptEventHandler", ex);
            }
        }
        if (this.y != null) {
            GameEntity.ep(super.d, this.y);
        }
        if (this.p) {
            super.d.show(false);
        }
        return super.d;
    }
}
