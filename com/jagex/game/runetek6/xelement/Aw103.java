/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.ScriptEventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.xelement.G104;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.maths.Vector3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tfu.Iz11;
import tfu.N105;

final class Aw103
extends G104 {
    final /* synthetic */ XElement[] l;
    final /* synthetic */ boolean p;
    final /* synthetic */ MappedEventComponent r;
    final /* synthetic */ Iz11 v;
    final /* synthetic */ Vector3 w;
    final /* synthetic */ AnimationGraphComponent y;

    @Override
    void p() {
        GameEntity.fv(Aw103.g(this), Aw103.d(this), Aw103.q(this));
        if (this.y != null) {
            this.y.bd();
        }
    }

    Aw103(ArrayList arrayList, long l, Skeleton skeleton, N105 n105, XElement[] arrxElement, Vector3 vector3, MappedEventComponent mappedEventComponent, Iz11 iz11, AnimationGraphComponent animationGraphComponent, boolean bl) {
        this.w = vector3;
        this.r = mappedEventComponent;
        this.v = iz11;
        this.y = animationGraphComponent;
        this.p = bl;
        super(arrayList, l, skeleton, n105);
        this.l = arrxElement;
    }

    GameEntity k() {
        XElement[] arrxElement = this.l;
        int n = arrxElement.length;
        for (int i = 0; i < n; ++i) {
            XElement xElement = arrxElement[i];
            XElement.bv(xElement, this.d);
        }
        if (this.l.length > 0) {
            XElement.bf(this.l[0], this.d, this.w);
        }
        int n2 = 0;
        for (n = 0; n < this.l.length; ++n) {
            if (XElement.bn(this.l[n]) == null) continue;
            ++n2;
        }
        this.d.bi = new Serializable[n2];
        n2 = 0;
        for (n = 0; n < this.l.length; ++n) {
            if (XElement.bn(this.l[n]) == null) continue;
            this.d.bi[n2++] = XElement.bn(this.l[n]);
        }
        if (XElement.q) {
            this.d.bt = new XElement[this.l.length];
            for (n = 0; n < this.l.length; ++n) {
                this.d.bt[n] = this.l[n];
            }
        }
        if (this.r != null) {
            GameEntity.ep(this.d, this.r);
        }
        if (this.v != null) {
            this.d.cj = this.v;
        }
        GameEntity.eo(this.d, AnimationGraphComponent.class);
        GameEntity.en(this.d, Aw103.g(this), Aw103.d(this), Aw103.q(this));
        HashMap hashMap = new HashMap();
        for (XElement xElement : this.l) {
            Map map = xElement.as();
            for (Integer n3 : map.keySet()) {
                if (hashMap.containsKey(n3)) continue;
                hashMap.put(n3, map.get(n3));
            }
        }
        GameEntity.ef(this.d);
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                ScriptEventHandler scriptEventHandler = this.d.bz.createEventHandler((String)entry.getValue(), null);
                scriptEventHandler.staticallyConfigured = true;
                this.d.addEventHandlerByID((Integer)entry.getKey(), scriptEventHandler);
            }
            catch (Exception exception) {
                XElement.bg().error("Error processing ScriptEventHandler", exception);
            }
        }
        if (this.y != null) {
            GameEntity.ep(this.d, this.y);
        }
        if (this.p) {
            this.d.show(false);
        }
        return this.d;
    }
}

