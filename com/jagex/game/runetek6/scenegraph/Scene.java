// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.gameentity.ScriptablePickResult;
import tfu.Fi371;
import tfu.Fn87;
import com.jagex.game.runetek6.xelement.Bn70;
import tfu.Bb4;
import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.xelement.W14;
import tfu.Ko370;
import java.util.Collection;
import com.jagex.jnibindings.runetek6.Occlusion;
import tfu.Me312;
import java.util.HashMap;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.WeakHashMap;
import com.jagex.jnibindings.runetek6.IrradianceVolumes;
import com.jagex.js5.js5;
import tfu.H149;
import com.jagex.jnibindings.runetek6.GroundCover;
import com.jagex.maths.Vector3;
import com.jagex.jnibindings.runetek6.Terrain;
import tfu.Lb33;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptDefaults;
import java.util.Iterator;
import com.jagex.game.runetek6.gameentity.Component;
import java.util.Set;
import java.util.ArrayList;
import java.util.Map;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Ao128;
import java.util.List;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("Scene")
public final class Scene
{
    private static final Logger logger;
    private final List b;
    private final Ao128 d;
    public GameEntity e;
    private boolean h;
    public String j;
    private boolean l;
    private final Map p;
    public final E254 q;
    public final Map r;
    private final List s;
    private final ArrayList u;
    public final Set v;
    private boolean w;
    private boolean x;
    public long y;
    
    private static void v(final Scene scene, final SceneGraphNode sceneGraphNode) {
        sceneGraphNode.hide(false);
        SceneGraphNode.al(sceneGraphNode, null);
        if (sceneGraphNode instanceof GameEntity) {
            final GameEntity gameEntity = (GameEntity)sceneGraphNode;
            for (final Component component : GameEntity.ek(gameEntity).values()) {
                component.removingFromScene();
                scene.p(component);
            }
            scene.r.remove(gameEntity.bg);
        }
        scene.v.remove(sceneGraphNode);
        sceneGraphNode.h = null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void remove(final SceneGraphNode sceneGraphNode, @ScriptDefaults(defaultBoolean = true) final boolean b, @ScriptDefaults(defaultBoolean = true) final boolean b2) {
        final Scene scene = sceneGraphNode.getScene();
        if (scene == null) {
            return;
        }
        if (scene != this) {
            throw new IllegalStateException("This node is in a different scene!");
        }
        if (this.x) {
            this.u.add(new J367(this, sceneGraphNode, b, b2));
            return;
        }
        v(this, sceneGraphNode);
        if (b) {
            sceneGraphNode.ag(null, null);
            r(this, sceneGraphNode);
        }
        else {
            SceneGraphNode.aq(sceneGraphNode);
        }
        if (b2) {
            SceneGraphNode.b(sceneGraphNode);
        }
    }
    
    public static final void d(final Scene scene) {
        Lb33.g(Lb33.LoadHeightmaps);
        try {
            final Iterator<Long> iterator = scene.s.iterator();
            while (iterator.hasNext()) {
                Terrain.loadHeightmapIfNotLoadedYet(iterator.next());
            }
        }
        finally {
            Lb33.d(Lb33.LoadHeightmaps);
        }
    }
    
    public final void q(final String s, final Vector3 vector3, final String str) {
        final long grid = GroundCover.createGrid();
        this.b.add(grid);
        GroundCover.setGridWorldOrigin(grid, vector3.x, vector3.y, vector3.z);
        GroundCover.loadLayerInstancesFromMemory(H149.u, grid, s, H149.z + str);
    }
    
    public static final void j(final Scene scene, final js5 js5, final String s, final String s2) {
        if (IrradianceVolumes.g(js5, s)) {
            scene.l = true;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object[] pickElementsFromSelection(final int n, final int n2) {
        final int n3 = 10;
        final ArrayList list = new ArrayList();
        this.b(n, n2, n3, list);
        return list.toArray();
    }
    
    public static final void s(final Scene scene, final List list, final Map map) {
        for (final long longValue : list) {
            for (final GameEntity gameEntity : scene.r.values()) {
                if (gameEntity.g() == longValue) {
                    map.put(longValue, gameEntity);
                }
            }
        }
    }
    
    public void y(final Component component) {
        Set<Component> setFromMap = this.p.get(component.getClass());
        if (setFromMap == null) {
            this.p.put(component.getClass(), setFromMap = Collections.newSetFromMap(new WeakHashMap<Component, Boolean>()));
        }
        setFromMap.add(component);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object[] pickElements(final int n, final int n2) {
        final int n3 = 10;
        final ArrayList list = new ArrayList();
        this.b(n, n2, n3, list);
        return list.toArray();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setActiveCamera(final GameEntity e) {
        this.e = e;
    }
    
    private void l(final SceneGraphNode sceneGraphNode) {
        sceneGraphNode.h = new WeakReference((T)this);
        SceneGraphNode.al(sceneGraphNode, this.q);
        this.v.add(sceneGraphNode);
        if (sceneGraphNode instanceof GameEntity) {
            final GameEntity gameEntity = (GameEntity)sceneGraphNode;
            if (this.r.containsKey(gameEntity.bg)) {
                throw new IllegalStateException("Duplicate GameEntityId! PANIC!");
            }
            this.r.put(gameEntity.bg, gameEntity);
            for (final Component component : GameEntity.ek(gameEntity).values()) {
                this.y(component);
                component.addedToScene();
            }
        }
        sceneGraphNode.show(false);
        final Iterator<SceneGraphNode> iterator2 = sceneGraphNode.ai().iterator();
        while (iterator2.hasNext()) {
            this.l(iterator2.next());
        }
    }
    
    public Scene(final E254 q) {
        this.d = new Ao128("Instantiated here");
        this.j = "Game";
        this.h = true;
        this.s = new ArrayList();
        this.b = new ArrayList();
        this.l = false;
        this.w = false;
        this.r = new HashMap();
        this.v = new Me312();
        this.y = 0L;
        this.p = new HashMap();
        this.x = false;
        this.u = new ArrayList();
        this.q = q;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void removeChildren(final SceneGraphNode sceneGraphNode, @ScriptDefaults(defaultBoolean = true) final boolean b) {
        final Iterator<SceneGraphNode> iterator = sceneGraphNode.ai().iterator();
        while (iterator.hasNext()) {
            this.remove(iterator.next(), true, b);
        }
    }
    
    private static final void r(final Scene scene, final SceneGraphNode sceneGraphNode) {
        for (final SceneGraphNode sceneGraphNode2 : sceneGraphNode.ai()) {
            v(scene, sceneGraphNode2);
            r(scene, sceneGraphNode2);
        }
    }
    
    public static final void e(final Scene scene, final js5 js5, final String s, final String s2) {
        if (Occlusion.g(js5, s)) {
            scene.w = true;
        }
    }
    
    public static final void w(final Scene scene, final SceneGraphNode sceneGraphNode) {
        scene.remove(sceneGraphNode, true, true);
    }
    
    public void p(final Component component) {
        final Set set = this.p.get(component.getClass());
        boolean remove = false;
        if (set != null) {
            remove = set.remove(component);
        }
        if (!remove) {
            Scene.logger.warn("Called unindexComponent on " + component.getClass().getSimpleName() + ", but it wasn't indexed!");
        }
    }
    
    public Collection x(final Class clazz) {
        final Set<Component> set = this.p.get(clazz);
        if (set == null) {
            return Collections.emptySet();
        }
        final Iterator<Component> iterator = set.iterator();
        while (iterator.hasNext()) {
            final GameEntity entity = iterator.next().getEntity();
            if (entity == null || entity.getScene() != this) {
                iterator.remove();
            }
        }
        if (set.isEmpty()) {
            return Collections.emptySet();
        }
        final Component[] array = set.toArray(new Component[set.size()]);
        if (array.length > 0 && array[array.length - 1] == null) {
            Scene.logger.warn("Set shrank (or contained nulls) while we were building the array!");
        }
        return new S368(this, array);
    }
    
    public static final void u(final Scene scene) {
        scene.h = false;
        for (final SceneGraphNode sceneGraphNode : scene.v) {
            SceneGraphNode.al(sceneGraphNode, null);
            sceneGraphNode.h = null;
            sceneGraphNode.l();
        }
        final Iterator<GameEntity> iterator2 = scene.r.values().iterator();
        while (iterator2.hasNext()) {
            final Iterator<Component> iterator3 = GameEntity.ek(iterator2.next()).values().iterator();
            while (iterator3.hasNext()) {
                scene.p(iterator3.next());
            }
        }
        scene.v.clear();
        scene.r.clear();
        final Iterator<Long> iterator4 = scene.s.iterator();
        while (iterator4.hasNext()) {
            Terrain.destroy(iterator4.next());
        }
        scene.s.clear();
        final Iterator<Long> iterator5 = scene.b.iterator();
        while (iterator5.hasNext()) {
            GroundCover.destroyGrid(iterator5.next(), H149.u);
        }
        scene.b.clear();
        if (scene.l) {
            IrradianceVolumes.destroyAllVolumes();
            scene.l = false;
        }
        if (scene.w) {
            Occlusion.destroyUmbraScene();
            scene.w = false;
        }
    }
    
    @Override
    protected void finalize() {
        try {
            if (this.h) {
                Scene.logger.error("Native memory leak - " + this.getClass().getSimpleName() + " garbage-collected without release()!", this.d);
                Ko370.g(new H369(this));
            }
        }
        catch (Throwable t) {
            Scene.logger.error("", t);
        }
    }
    
    public static void z(final Scene scene, final float n) {
        final Iterator<Long> iterator = scene.b.iterator();
        while (iterator.hasNext()) {
            GroundCover.updateGrid(iterator.next(), n);
        }
    }
    
    public static int m(final Scene scene) {
        return scene.v.size();
    }
    
    public static final void g(final Scene scene, final W14 w14, final Vector3 vector3) {
        final long create = Terrain.create();
        Terrain.loadFromXMLString(create, w14.g);
        Terrain.setWorldPosition(create, vector3.x, vector3.y, vector3.z);
        scene.s.add(create);
    }
    
    public static void k(final Scene scene) {
        scene.x = true;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity getActiveCamera() {
        return this.e;
    }
    
    public static int n(final Scene scene) {
        return scene.r.size();
    }
    
    static {
        logger = LoggerFactory.getLogger(Scene.class);
    }
    
    public static GameEntity t(final Scene scene, final Bb4 bb4) {
        return scene.r.get(bb4);
    }
    
    public static void i(final Scene scene) {
        scene.x = false;
        final Iterator<Runnable> iterator = scene.u.iterator();
        while (iterator.hasNext()) {
            iterator.next().run();
        }
        scene.u.clear();
    }
    
    public static final void h(final Scene scene, final Bn70 bn70) {
        Bn70.q(bn70, scene.y);
    }
    
    public void b(final int n, final int n2, final int n3, final List list) {
        final ArrayList<Fn87> list2 = new ArrayList<Fn87>();
        Fi371.d(n, n2, n3, list2);
        if (list2.isEmpty()) {
            return;
        }
        final ArrayList<Object> list3 = new ArrayList<Object>();
        final Iterator<Fn87> iterator = list2.iterator();
        while (iterator.hasNext()) {
            list3.add(iterator.next().g);
        }
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        s(this, list3, hashMap);
        for (final Fn87 fn87 : list2) {
            final ScriptablePickResult scriptablePickResult = new ScriptablePickResult(fn87);
            scriptablePickResult.g = hashMap.get(fn87.g);
            list.add(scriptablePickResult);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void add(final SceneGraphNode sceneGraphNode) {
        if (!this.h) {
            throw new IllegalStateException();
        }
        if (sceneGraphNode.l != null) {
            throw new IllegalStateException("This node has a parent - please add the parent, not the child! (Its children will be added for you.)");
        }
        final Scene scene = sceneGraphNode.getScene();
        if (scene == this) {
            Scene.logger.warn("this node is already in the scene - did you mean to add it twice?", new Throwable());
            return;
        }
        if (scene != null) {
            throw new IllegalStateException("This node is already in another scene!");
        }
        if (sceneGraphNode instanceof GameEntity) {
            final GameEntity obj = this.r.get(((GameEntity)sceneGraphNode).bg);
            if (obj != null && obj != sceneGraphNode) {
                throw new IllegalStateException("A node with this GameEntityId (" + obj.bg + ") is already in the scene (but not this node) - PANIC!  Existing is " + obj);
            }
            Scene.logger.trace("adding a node with GameEntityId " + ((GameEntity)sceneGraphNode).bg);
        }
        this.l(sceneGraphNode);
    }
}
