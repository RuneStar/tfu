/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.ScriptablePickResult;
import com.jagex.game.runetek6.scenegraph.E254;
import com.jagex.game.runetek6.scenegraph.H369;
import com.jagex.game.runetek6.scenegraph.J367;
import com.jagex.game.runetek6.scenegraph.S368;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.xelement.Bn70;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.jnibindings.runetek6.GroundCover;
import com.jagex.jnibindings.runetek6.IrradianceVolumes;
import com.jagex.jnibindings.runetek6.Occlusion;
import com.jagex.jnibindings.runetek6.Terrain;
import com.jagex.js5.js5;
import com.jagex.maths.Vector3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Fi371;
import tfu.Fn87;
import tfu.H149;
import tfu.Ko370;
import tfu.Lb33;
import tfu.Me312;

@ScriptEntryClass(value="Scene")
public final class Scene {
    private static final Logger logger = LoggerFactory.getLogger(Scene.class);
    private final List b;
    private final Ao128 d = new Ao128("Instantiated here");
    public GameEntity e;
    private boolean h = true;
    public String j = "Game";
    private boolean l = false;
    private final Map p;
    public final E254 q;
    public final Map r;
    private final List s = new ArrayList();
    private final ArrayList u;
    public final Set v;
    private boolean w = false;
    private boolean x = false;
    public long y = 0L;

    private static void v(Scene scene, SceneGraphNode sceneGraphNode) {
        sceneGraphNode.hide(false);
        SceneGraphNode.al(sceneGraphNode, null);
        if (sceneGraphNode instanceof GameEntity) {
            GameEntity gameEntity = (GameEntity)sceneGraphNode;
            for (Component component : GameEntity.ek(gameEntity).values()) {
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
    public final void remove(SceneGraphNode sceneGraphNode, @ScriptDefaults(defaultBoolean=true) boolean bl, @ScriptDefaults(defaultBoolean=true) boolean bl2) {
        Scene scene = sceneGraphNode.getScene();
        if (scene == null) {
            return;
        }
        if (scene != this) {
            throw new IllegalStateException("This node is in a different scene!");
        }
        if (this.x) {
            this.u.add(new J367(this, sceneGraphNode, bl, bl2));
            return;
        }
        Scene.v(this, sceneGraphNode);
        if (bl) {
            sceneGraphNode.ag(null, null);
            Scene.r(this, sceneGraphNode);
        } else {
            SceneGraphNode.aq(sceneGraphNode);
        }
        if (bl2) {
            SceneGraphNode.b(sceneGraphNode);
        }
    }

    public static final void d(Scene scene) {
        Lb33.g(Lb33.LoadHeightmaps);
        try {
            Iterator iterator = scene.s.iterator();
            while (iterator.hasNext()) {
                long l = (Long)iterator.next();
                Terrain.loadHeightmapIfNotLoadedYet(l);
            }
            Lb33.d(Lb33.LoadHeightmaps);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.LoadHeightmaps);
            throw throwable;
        }
    }

    public final void q(String string, Vector3 vector3, String string2) {
        long l = GroundCover.createGrid();
        this.b.add(l);
        GroundCover.setGridWorldOrigin(l, vector3.x, vector3.y, vector3.z);
        String string3 = H149.z + string2;
        GroundCover.loadLayerInstancesFromMemory(H149.u, l, string, string3);
    }

    public static final void j(Scene scene, js5 js52, String string, String string2) {
        if (IrradianceVolumes.g(js52, string)) {
            scene.l = true;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object[] pickElementsFromSelection(int n, int n2) {
        int n3 = 10;
        ArrayList arrayList = new ArrayList();
        this.b(n, n2, n3, arrayList);
        return arrayList.toArray();
    }

    public static final void s(Scene scene, List list, Map map) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            long l = (Long)iterator.next();
            for (GameEntity gameEntity : scene.r.values()) {
                if (gameEntity.g() != l) continue;
                map.put(l, gameEntity);
            }
        }
    }

    public void y(Component component) {
        Set set = (Set)this.p.get(component.getClass());
        if (set == null) {
            set = Collections.newSetFromMap(new WeakHashMap());
            this.p.put(component.getClass(), set);
        }
        set.add(component);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object[] pickElements(int n, int n2) {
        int n3 = 10;
        ArrayList arrayList = new ArrayList();
        this.b(n, n2, n3, arrayList);
        return arrayList.toArray();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setActiveCamera(GameEntity gameEntity) {
        this.e = gameEntity;
    }

    private void l(SceneGraphNode sceneGraphNode) {
        sceneGraphNode.h = new WeakReference<Scene>(this);
        SceneGraphNode.al(sceneGraphNode, this.q);
        this.v.add(sceneGraphNode);
        if (sceneGraphNode instanceof GameEntity) {
            GameEntity gameEntity = (GameEntity)sceneGraphNode;
            if (this.r.containsKey(gameEntity.bg)) {
                throw new IllegalStateException("Duplicate GameEntityId! PANIC!");
            }
            this.r.put(gameEntity.bg, gameEntity);
            for (Component component : GameEntity.ek(gameEntity).values()) {
                this.y(component);
                component.addedToScene();
            }
        }
        sceneGraphNode.show(false);
        for (Object object : sceneGraphNode.ai()) {
            this.l((SceneGraphNode)object);
        }
    }

    public Scene(E254 e254) {
        this.b = new ArrayList();
        this.r = new HashMap();
        this.v = new Me312();
        this.p = new HashMap();
        this.u = new ArrayList();
        this.q = e254;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void removeChildren(SceneGraphNode sceneGraphNode, @ScriptDefaults(defaultBoolean=true) boolean bl) {
        for (SceneGraphNode sceneGraphNode2 : sceneGraphNode.ai()) {
            this.remove(sceneGraphNode2, true, bl);
        }
    }

    private static final void r(Scene scene, SceneGraphNode sceneGraphNode) {
        for (SceneGraphNode sceneGraphNode2 : sceneGraphNode.ai()) {
            Scene.v(scene, sceneGraphNode2);
            Scene.r(scene, sceneGraphNode2);
        }
    }

    public static final void e(Scene scene, js5 js52, String string, String string2) {
        if (Occlusion.g(js52, string)) {
            scene.w = true;
        }
    }

    public static final void w(Scene scene, SceneGraphNode sceneGraphNode) {
        scene.remove(sceneGraphNode, true, true);
    }

    public void p(Component component) {
        Set set = (Set)this.p.get(component.getClass());
        boolean bl = false;
        if (set != null) {
            bl = set.remove(component);
        }
        if (!bl) {
            logger.warn("Called unindexComponent on " + component.getClass().getSimpleName() + ", but it wasn't indexed!");
        }
    }

    public Collection x(Class class_) {
        Set set = (Set)this.p.get(class_);
        if (set == null) {
            return Collections.emptySet();
        }
        Component[] arrcomponent = set.iterator();
        while (arrcomponent.hasNext()) {
            Component component = (Component)arrcomponent.next();
            GameEntity gameEntity = component.getEntity();
            if (gameEntity != null && gameEntity.getScene() == this) continue;
            arrcomponent.remove();
        }
        if (set.isEmpty()) {
            return Collections.emptySet();
        }
        arrcomponent = set.toArray(new Component[set.size()]);
        if (arrcomponent.length > 0 && arrcomponent[arrcomponent.length - 1] == null) {
            logger.warn("Set shrank (or contained nulls) while we were building the array!");
        }
        return new S368(this, arrcomponent);
    }

    public static final void u(Scene scene) {
        scene.h = false;
        for (SceneGraphNode sceneGraphNode : scene.v) {
            SceneGraphNode.al(sceneGraphNode, null);
            sceneGraphNode.h = null;
            sceneGraphNode.l();
        }
        for (SceneGraphNode sceneGraphNode : scene.r.values()) {
            for (Component component : GameEntity.ek((GameEntity)sceneGraphNode).values()) {
                scene.p(component);
            }
        }
        scene.v.clear();
        scene.r.clear();
        Iterator<Object> iterator = scene.s.iterator();
        while (iterator.hasNext()) {
            long l = (Long)iterator.next();
            Terrain.destroy(l);
        }
        scene.s.clear();
        iterator = scene.b.iterator();
        while (iterator.hasNext()) {
            long l = (Long)iterator.next();
            GroundCover.destroyGrid(l, H149.u);
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

    protected void finalize() {
        try {
            if (this.h) {
                logger.error("Native memory leak - " + this.getClass().getSimpleName() + " garbage-collected without release()!", this.d);
                Ko370.g(new H369(this));
            }
        }
        catch (Throwable throwable) {
            logger.error("", throwable);
        }
    }

    public static void z(Scene scene, float f) {
        Iterator iterator = scene.b.iterator();
        while (iterator.hasNext()) {
            long l = (Long)iterator.next();
            GroundCover.updateGrid(l, f);
        }
    }

    public static int m(Scene scene) {
        return scene.v.size();
    }

    public static final void g(Scene scene, W14 w14, Vector3 vector3) {
        long l = Terrain.create();
        Terrain.loadFromXMLString(l, w14.g);
        Terrain.setWorldPosition(l, vector3.x, vector3.y, vector3.z);
        scene.s.add(l);
    }

    public static void k(Scene scene) {
        scene.x = true;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity getActiveCamera() {
        return this.e;
    }

    public static int n(Scene scene) {
        return scene.r.size();
    }

    public static GameEntity t(Scene scene, Bb4 bb4) {
        return (GameEntity)scene.r.get(bb4);
    }

    public static void i(Scene scene) {
        scene.x = false;
        for (Runnable runnable : scene.u) {
            runnable.run();
        }
        scene.u.clear();
    }

    public static final void h(Scene scene, Bn70 bn70) {
        Bn70.q(bn70, scene.y);
    }

    public void b(int n, int n2, int n3, List list) {
        ArrayList arrayList = new ArrayList();
        Fi371.d(n, n2, n3, arrayList);
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        for (Object object : arrayList) {
            arrayList2.add(((Fn87)object).g);
        }
        HashMap hashMap = new HashMap();
        Scene.s(this, arrayList2, hashMap);
        for (Fn87 fn87 : arrayList) {
            ScriptablePickResult scriptablePickResult = new ScriptablePickResult(fn87);
            scriptablePickResult.g = hashMap.get(fn87.g);
            list.add(scriptablePickResult);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void add(SceneGraphNode sceneGraphNode) {
        if (!this.h) {
            throw new IllegalStateException();
        }
        if (sceneGraphNode.l != null) {
            throw new IllegalStateException("This node has a parent - please add the parent, not the child! (Its children will be added for you.)");
        }
        Scene scene = sceneGraphNode.getScene();
        if (scene == this) {
            logger.warn("this node is already in the scene - did you mean to add it twice?", new Throwable());
            return;
        }
        if (scene != null) {
            throw new IllegalStateException("This node is already in another scene!");
        }
        if (sceneGraphNode instanceof GameEntity) {
            GameEntity gameEntity = (GameEntity)sceneGraphNode;
            GameEntity gameEntity2 = (GameEntity)this.r.get(gameEntity.bg);
            if (gameEntity2 != null && gameEntity2 != sceneGraphNode) {
                throw new IllegalStateException("A node with this GameEntityId (" + gameEntity2.bg + ") is already in the scene (but not this node) - PANIC!  Existing is " + gameEntity2);
            }
            logger.trace("adding a node with GameEntityId " + ((GameEntity)sceneGraphNode).bg);
        }
        this.l(sceneGraphNode);
    }
}

