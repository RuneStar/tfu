// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity;

import com.jagex.game.runetek6.scenegraph.Scene;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;

public abstract class Component
{
    public static final int ax = 305419896;
    private GameEntity au;
    
    public void bd() {
    }
    
    @Override
    public String toString() {
        return this.au + ":" + this.getClass().getSimpleName();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final GameEntity getEntity() {
        return this.au;
    }
    
    static void bp(final Component component, final GameEntity au) {
        if (component.au != null) {
            component.detachFromEntity();
            final Scene scene = component.au.getScene();
            if (scene != null) {
                scene.p(component);
            }
        }
        component.au = au;
        if (component.au != null) {
            component.attachToEntity();
            final Scene scene2 = component.au.getScene();
            if (scene2 != null) {
                scene2.y(component);
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
