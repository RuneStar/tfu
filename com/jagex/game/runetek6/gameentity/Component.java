/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

public abstract class Component {
    public static final int ax = 305419896;
    private GameEntity au;

    public void bd() {
    }

    public String toString() {
        return this.au + ":" + this.getClass().getSimpleName();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final GameEntity getEntity() {
        return this.au;
    }

    static void bp(Component component, GameEntity gameEntity) {
        Scene scene;
        if (component.au != null) {
            component.detachFromEntity();
            scene = component.au.getScene();
            if (scene != null) {
                scene.p(component);
            }
        }
        component.au = gameEntity;
        if (component.au != null) {
            component.attachToEntity();
            scene = component.au.getScene();
            if (scene != null) {
                scene.y(component);
            }
        }
    }

    protected void detachFromEntity() {
    }

    protected void attachToEntity() {
    }

    public void addedToScene() {
    }

    public void removingFromScene() {
    }
}

