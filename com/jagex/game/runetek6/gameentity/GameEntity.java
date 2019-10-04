/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.Event;
import com.jagex.game.runetek6.event.EventForwarder;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.D331;
import com.jagex.game.runetek6.gameentity.E333;
import com.jagex.game.runetek6.gameentity.G55;
import com.jagex.game.runetek6.gameentity.J332;
import com.jagex.game.runetek6.gameentity.Q344;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.variables.G53;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.jnibindings.runetek6.LuaUserData;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.jnibindings.runetek6.SkinnedModel;
import com.jagex.jnibindings.runetek6.StaticModel;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.maths.Q10;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Ap127;
import tfu.Ba115;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.H149;
import tfu.Hi86;
import tfu.Iz11;
import tfu.Jy122;
import tfu.Kc180;
import tfu.Lb33;
import tfu.Lc490;
import tfu.Lp301;
import tfu.N105;

@ScriptEntryClass(value="Entity")
@Bs1
@Be2
public class GameEntity
extends SceneGraphNode
implements Lp301,
EventForwarder {
    private static WeakHashMap bc;
    private static final ThreadLocal be;
    public static Ba115 bf;
    public static Ba115 bn;
    private static final WeakHashMap bv;
    private static final EventHandler cq;
    public static J332 cw;
    private static final Logger logger;
    public CollisionObject ba = null;
    public String bb = null;
    public final Bb4 bg;
    public Serializable[] bi;
    private Map bs;
    public XElement[] bt;
    public boolean bu = true;
    public final ScriptManager bz;
    protected final Set ca;
    protected Skeleton cb;
    private Map cd;
    protected final G55 ce;
    public Iz11 cj;
    private LinkedHashSet ck;
    private N105 cl;
    private int cm;
    private final EventHandler cp;
    protected final Map cv;
    public int luaComponentTable = -1;

    private GameEntity(Bb4 bb4, ScriptManager scriptManager, boolean bl) {
        this.bs = new HashMap();
        this.cp = new E333(this);
        this.cd = new HashMap();
        this.ce = new G55(this);
        this.ca = new HashSet();
        this.cv = new HashMap();
        Lb33.g(Lb33.NewGameEntityBody);
        if (bb4 == null) {
            throw new NullPointerException();
        }
        this.bg = bb4;
        Lb33.g(Lb33.UpdateEntitesById);
        WeakHashMap weakHashMap = bv;
        synchronized (weakHashMap) {
            Lb33.g(Lb33.EntitesByIdRemove);
            bv.remove(this.bg);
            Lb33.d(Lb33.EntitesByIdRemove);
            Lb33.g(Lb33.EntitesByIdPut);
            bv.put(this.bg, new WeakReference<GameEntity>(this));
            Lb33.d(Lb33.EntitesByIdPut);
        }
        Lb33.d(Lb33.UpdateEntitesById);
        if (scriptManager == null) {
            throw new NullPointerException();
        }
        this.bz = scriptManager;
        Lb33.g(Lb33.AddCommonEventHandlers);
        GameEntity.ei(this);
        Lb33.d(Lb33.AddCommonEventHandlers);
        Lb33.d(Lb33.NewGameEntityBody);
    }

    public final native void setNativeComponent(long var1, long var3, int var5, Component var6, String var7);

    public final native void clearNativeComponents(long var1);

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object getProperty(String string, Object object) {
        return G55.e(this.ce, string, object);
    }

    public String toString() {
        return this.getClass().getSimpleName() + ":" + this.bg;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public synchronized Component removeComponent(Class class_, @ScriptID @ScriptDefaults(defaultInteger=305419896) int n) {
        Component component;
        if (n == 305419896) {
            n = StringTools.l(class_.getName());
        }
        if ((component = (Component)this.cd.remove(n)) != null) {
            Component.bp(component, null);
            component.bd();
        }
        this.setNativeComponent(this.bz.getScriptManagerNativeRef(), this.bz.getLuaStateNativeRef(), n, null, null);
        return component;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setIsModelStatic(boolean bl) {
        this.bu = bl;
    }

    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public byte[] GetPackedUUID() {
        return this.getPackedID();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public byte[] getPackedID() {
        Gg3 gg3 = new Gg3(3);
        this.bg.q(gg3);
        return gg3.r;
    }

    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getUUID() {
        return this.bg.toString();
    }

    public static void em(Collection collection, Runnable runnable) {
        try {
            be.set(collection);
            runnable.run();
            be.set(null);
        }
        catch (Throwable throwable) {
            be.set(null);
            throw throwable;
        }
    }

    public static GameEntity es(Bb4 bb4) {
        WeakReference weakReference;
        Object object = bv;
        synchronized (object) {
            weakReference = (WeakReference)bv.get(bb4);
        }
        if (weakReference != null) {
            Collection collection;
            object = (GameEntity)weakReference.get();
            if (object != null && (collection = (Collection)be.get()) != null) {
                collection.add(object);
            }
            return object;
        }
        return null;
    }

    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity LookupPackedUUID(Object object, byte[] arrby) {
        return GameEntity.lookupPackedID(arrby);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity lookupPackedID(byte[] arrby) {
        Gg3 gg3 = new Gg3(arrby);
        Bb4 bb4 = Bb4.j(gg3);
        GameEntity gameEntity = GameEntity.es(bb4);
        if (gameEntity == null) {
            logger.debug("Protocol Buffers: packed ID {} doesn't refer to a GameEntity that we know about.", bb4);
        }
        return gameEntity;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity lookupID(String string) {
        Bb4 bb4 = Bb4.g(string);
        GameEntity gameEntity = GameEntity.es(bb4);
        if (gameEntity == null) {
            logger.debug("Protocol Buffers: string ID {} doesn't refer to a GameEntity that we know about.", bb4);
        }
        return gameEntity;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandlerByID(@ScriptID Integer n, EventHandler eventHandler) {
        Event event = (Event)this.bs.get(n);
        if (event == null) {
            event = new Event();
            this.bs.put(n, event);
        }
        event.add(eventHandler);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeEventHandler(String string, EventHandler eventHandler) {
        GameEntity.ec(this, StringTools.l(string), eventHandler);
    }

    public static void ec(@ScriptID GameEntity gameEntity, Integer n, EventHandler eventHandler) {
        Event event = (Event)gameEntity.bs.get(n);
        if (event != null) {
            event.remove(eventHandler);
        }
    }

    public void eh(String string, Object object) {
        if (this.bz.getThread() != Thread.currentThread()) {
            String string2 = "GameEntity.triggerEvent() called from " + Thread.currentThread() + " - main thread is " + this.bz.getThread();
            logger.error(string2, new Ao128());
            throw new IllegalStateException(string2);
        }
        Lb33.g(Lb33.EntityTriggerEventName);
        try {
            long l;
            float f;
            long l2 = System.nanoTime();
            if (Jy122.g(ScriptManager.calltrace)) {
                Jy122.h(ScriptManager.calltrace, "ENTITY EVENT: " + string + "(" + object + ") on " + this);
            }
            this.triggerEvent(StringTools.l(string), object);
            if (Jy122.g(ScriptManager.calltrace)) {
                Jy122.l(ScriptManager.calltrace, "END");
            }
            if (Ap127.d && (f = (float)(l = System.nanoTime() - l2) * 1.0E-6f) > Ap127.j) {
                f = (float)((int)(f * 10.0f)) / 10.0f;
                Ap127.g(l, "Lua handling for the event '" + string + "' took longer than 1 ms: " + f + " ms. Update frame " + Ap127.h);
            }
            Lb33.d(Lb33.EntityTriggerEventName);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.EntityTriggerEventName);
            throw throwable;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void triggerEvent(@ScriptID Integer n, Object object) {
        Lb33.g(Lb33.EntityTriggerEventHash);
        try {
            Event event = (Event)this.bs.get(n);
            if (event != null) {
                event.trigger(this, object);
            }
            Lb33.d(Lb33.EntityTriggerEventHash);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.EntityTriggerEventHash);
            throw throwable;
        }
    }

    public static void ef(GameEntity gameEntity) {
        for (Event event : gameEntity.bs.values()) {
            event.removeStaticallyConfiguredHandlers();
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getModelJointIndex(String string) {
        int n = -1;
        if (this.v == 0L) {
            return n;
        }
        if (this != null) {
            if (this.v == 0L) {
                return n;
            }
            if (this.cb != null && string != null) {
                n = this.cb.d(string);
            }
        }
        return n;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity construct(ScriptManager scriptManager) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        Lb33.g(Lb33.GameEntityIdAllocate);
        Bb4 bb4 = bf.s();
        Lb33.d(Lb33.GameEntityIdAllocate);
        Lb33.g(Lb33.NewGameEntity);
        GameEntity gameEntity = new GameEntity(bb4, scriptManager, false);
        Lb33.d(Lb33.NewGameEntity);
        Lb33.g(Lb33.GameEntityConstructStack);
        Ao128 ao128 = new Ao128();
        Lb33.d(Lb33.GameEntityConstructStack);
        Lb33.g(Lb33.GameEntityConstructBuilder);
        StringBuilder stringBuilder = new StringBuilder();
        Lb33.d(Lb33.GameEntityConstructBuilder);
        for (StackTraceElement stackTraceElement : ao128.getStackTrace()) {
            Lb33.g(Lb33.GameEntityConstructAppend);
            stringBuilder.append(stackTraceElement.toString());
            stringBuilder.append('\n');
            Lb33.d(Lb33.GameEntityConstructAppend);
        }
        Lb33.g(Lb33.GameEntityConstructPut);
        bc.put(gameEntity, stringBuilder.toString());
        Lb33.d(Lb33.GameEntityConstructPut);
        return gameEntity;
    }

    public static Map ek(GameEntity gameEntity) {
        return Collections.unmodifiableMap(gameEntity.cd);
    }

    public static Component eb(GameEntity gameEntity, Class class_) {
        return gameEntity.getComponent(class_, 305419896);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean hasComponent(Class class_, @ScriptID @ScriptDefaults(defaultInteger=305419896) int n) {
        int n2 = n == 305419896 ? StringTools.l(class_.getName()) : n;
        return this.cd.get(n2) != null;
    }

    public static Component ep(GameEntity gameEntity, Component component) {
        return gameEntity.addComponent(component, 305419896);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public synchronized Component addComponent(Component component, @ScriptID @ScriptDefaults(defaultInteger=305419896) int n) {
        Component component2;
        if (n == 305419896) {
            n = StringTools.l(component.getClass().getName());
        }
        if ((component2 = this.cd.put(n, component)) != null) {
            Component.bp(component2, null);
            component2.bd();
        }
        Component.bp(component, this);
        this.setNativeComponent(this.bz.getScriptManagerNativeRef(), this.bz.getLuaStateNativeRef(), n, component, Scripting.typeSig(component));
        return component2;
    }

    public GameEntity(Bb4 bb4, ScriptManager scriptManager) {
        this.bs = new HashMap<K, V>();
        this.cp = new E333(this);
        this.cd = new HashMap<K, V>();
        this.ce = new G55(this);
        this.ca = new HashSet<E>();
        this.cv = new HashMap<K, V>();
        if (bb4 == null) {
            throw new NullPointerException();
        }
        this.bg = bb4;
        WeakHashMap weakHashMap = bv;
        synchronized (weakHashMap) {
            bv.remove(this.bg);
            bv.put(this.bg, new WeakReference<GameEntity>(this));
        }
        if (scriptManager == null) {
            throw new NullPointerException();
        }
        this.bz = scriptManager;
        GameEntity.ei(this);
    }

    public final void et(Q344 q344) {
        if (this.ck == null) {
            this.ck = new LinkedHashSet<E>();
        }
        this.ck.add(q344);
    }

    public static final void eu(GameEntity gameEntity, Q344 q344) {
        if (gameEntity.ck != null) {
            gameEntity.ck.remove(q344);
        }
    }

    private void ey() {
        if (this.ck != null) {
            Q344[] arrq344 = this.ck.toArray(new Q344[this.ck.size()]);
            for (int i = arrq344.length - 1; i >= 0; --i) {
                try {
                    arrq344[i].g(this);
                    continue;
                }
                catch (Exception exception) {
                    System.err.print("Error in release hook for entity " + this + ": ");
                    exception.printStackTrace();
                }
            }
            this.ck = null;
        }
    }

    @Override
    protected void af(boolean bl) {
        Object object = H149.v;
        synchronized (object) {
            Scene scene = this.getScene();
            long l = 0L;
            if (scene != null) {
                l = scene.y;
            }
            if (this.v != 0L && this.cl != null) {
                if (this.cl.d) {
                    if (bl) {
                        SkinnedModel.show(l, this.v);
                    } else {
                        SkinnedModel.hide(l, this.v);
                    }
                } else if (bl) {
                    StaticModel.setIsStatic(this.v, this.bu);
                    StaticModel.show(l, this.v);
                } else {
                    StaticModel.hide(l, this.v);
                }
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void attachTo(GameEntity gameEntity, String string) {
        gameEntity.attach(this, string);
    }

    public static void ea(GameEntity gameEntity, G53 g53) {
        gameEntity.ce.d(g53);
    }

    public static int ev(GameEntity gameEntity, String string, int n) {
        return G55.q(gameEntity.ce, string, n);
    }

    public static void fv(long l, Skeleton skeleton, N105 n105) {
        Object object = H149.v;
        synchronized (object) {
            if (l != 0L) {
                if (n105 != null) {
                    if (n105.d) {
                        SkinnedModel.destroy(l);
                    } else {
                        StaticModel.destroy(l);
                    }
                } else {
                    com.jagex.jnibindings.runetek6.SceneGraphNode.destroy(l);
                }
                l = 0L;
            }
            if (skeleton != null) {
                Hi86.l(skeleton.g, skeleton);
                skeleton = null;
            }
            if (n105 != null) {
                Hi86.l(n105.g, n105);
                n105 = null;
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setProperty(String string, Object object) {
        this.ce.h(string, object);
    }

    public static Object ej(GameEntity gameEntity, String string) {
        return gameEntity.ce.j(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String enablePropertyChangeEvent(String string) {
        return this.ce.g(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Integer hasPropertyChangeEvent(String string) {
        return G55.s(this.ce, StringTools.l(string));
    }

    public static Integer ex(GameEntity gameEntity, int n) {
        return G55.s(gameEntity.ce, n);
    }

    public static void ed(GameEntity gameEntity, int n, int n2, int n3) {
        Integer n4;
        if (n2 != n3 && (n4 = GameEntity.ex(gameEntity, n)) != null) {
            gameEntity.triggerEvent(n4, n2);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean hasSkeleton() {
        return this.cb != null;
    }

    public static Skeleton el(GameEntity gameEntity) {
        return gameEntity.cb;
    }

    @Override
    protected void c(SceneGraphNode sceneGraphNode, String string) {
        if (this.v == 0L || sceneGraphNode.v == 0L) {
            return;
        }
        if (this.cb != null && this.cl != null && string != null) {
            int n = this.cb.d(string);
            if (n != -1) {
                StaticModel.attachNodeToBone(this.v, sceneGraphNode.v, n);
            } else {
                com.jagex.jnibindings.runetek6.SceneGraphNode.setParent(sceneGraphNode.v, this.v);
            }
        } else {
            com.jagex.jnibindings.runetek6.SceneGraphNode.setParent(sceneGraphNode.v, this.v);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isJointValid(int n) {
        return this.hasSkeleton() && n >= 0 && n < this.cb.g();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans getJointWorldTransform(int n) {
        if (!this.hasSkeleton()) {
            logger.warn("Error, no skeleton found on GameEntity during joint transform lookup. Either the entity's skeleton has yet to be constructed or it does not exist.");
            return RotTrans.g;
        }
        if (n == -1) {
            logger.warn("Error, erroneous joint index passed during joint transform lookup. Suspect no joint existed for the previous lookup.");
            return RotTrans.g;
        }
        if (n < 0 || n >= this.cb.g()) {
            logger.warn("Error, out of bound joint index.");
            return RotTrans.g;
        }
        StaticModel.getBoneWorldTransform(this.v, n, H149.j);
        Quaternion quaternion = new Quaternion(Kc180.u(H149.j), Kc180.u(H149.j + 4L), Kc180.u(H149.j + 8L), Kc180.u(H149.j + 12L));
        Vector3 vector3 = new Vector3(Kc180.u(H149.j + 16L), Kc180.u(H149.j + 20L), Kc180.u(H149.j + 24L));
        return new RotTrans(quaternion, vector3);
    }

    public static boolean ee(GameEntity gameEntity, Class class_) {
        return gameEntity.hasComponent(class_, 305419896);
    }

    public static long ew(Skeleton skeleton, N105 n105) {
        Object object = H149.v;
        synchronized (object) {
            long l;
            if (n105 != null) {
                long[] arrl = n105.q;
                int n = Kc180.e();
                long l2 = arrl.length * n;
                long l3 = Kc180.g(l2);
                for (int i = 0; i < arrl.length; ++i) {
                    Kc180.s(l3 + (long)(i * n), arrl[i]);
                }
                long l4 = l = n105.d ? SkinnedModel.create() : StaticModel.create(n105.h);
                if (skeleton != null) {
                    StaticModel.g(l, skeleton);
                } else if (n105.d) {
                    logger.info("Error, skinned model doesn't have a skeleton");
                }
                StaticModel.replaceMeshes(l, l3, arrl.length, n105.s[0]);
                Kc180.d(l3);
            } else {
                l = com.jagex.jnibindings.runetek6.SceneGraphNode.create();
                if (skeleton != null) {
                    logger.warn("Warning, scene graph node has a skeleton");
                    Hi86.l(skeleton.g, skeleton);
                    skeleton = null;
                }
            }
            return l;
        }
    }

    public static void en(GameEntity gameEntity, long l, Skeleton skeleton, N105 n105) {
        Object object = H149.v;
        synchronized (object) {
            boolean bl = gameEntity.v != l;
            GameEntity.fa(gameEntity);
            gameEntity.v = l;
            gameEntity.cb = skeleton;
            gameEntity.cl = n105;
            GameEntity.f(gameEntity);
            if (bl) {
                gameEntity.eh("__modelChanged", null);
            }
        }
    }

    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity LookupUUID(Object object, String string) {
        return GameEntity.lookupID(string);
    }

    public static boolean eq(GameEntity gameEntity) {
        return gameEntity.cl != null && gameEntity.cl.d;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getOBBTop() {
        Vector3 vector3 = this.getWorldTransform().trans;
        Q10 q10 = GameEntity.k(this);
        if (q10 == null) {
            return vector3;
        }
        vector3 = Vector3.m(vector3, 0.0f, Q10.q(q10), 0.0f);
        return vector3;
    }

    public static void fa(GameEntity gameEntity) {
        Object object = H149.v;
        synchronized (object) {
            GameEntity.fv(gameEntity.v, gameEntity.cb, gameEntity.cl);
            gameEntity.cb = null;
            gameEntity.cl = null;
            gameEntity.v = 0L;
        }
    }

    @Override
    public Vector3 j() {
        Q10 q10 = GameEntity.i(this);
        if (q10 == null) {
            return this.getWorldTransform().trans;
        }
        return Vector3.g(Q10.d(q10), Q10.j(q10), Q10.h(q10));
    }

    @Override
    public Vector3 e() {
        Q10 q10 = GameEntity.i(this);
        if (q10 == null) {
            return this.getWorldTransform().trans;
        }
        return Vector3.g(Q10.g(q10), Q10.q(q10), Q10.e(q10));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getID() {
        return this.bg.toString();
    }

    public static Component eo(GameEntity gameEntity, Class class_) {
        return gameEntity.removeComponent(class_, 305419896);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeAllEventHandlers(@ScriptID Integer n) {
        this.bs.remove(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Component getComponent(Class class_, @ScriptID @ScriptDefaults(defaultInteger=305419896) int n) {
        int n2 = n == 305419896 ? StringTools.l(class_.getName()) : n;
        return (Component)this.cd.get(n2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getIDNumber() {
        return this.bg.h();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandler(String string, EventHandler eventHandler) {
        this.addEventHandlerByID(StringTools.l(string), eventHandler);
    }

    static {
        logger = LoggerFactory.getLogger(GameEntity.class);
        bv = new WeakHashMap<K, V>();
        bc = new WeakHashMap<K, V>();
        be = new ThreadLocal<T>();
        cq = new D331();
    }

    protected static void ei(GameEntity gameEntity) {
        gameEntity.addEventHandler("__sound", cq);
        gameEntity.addEventHandler("FootPlaced", gameEntity.cp);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans getJointObjectTransform(int n) {
        if (this.v == 0L) {
            throw new IllegalStateException("GetJointObjectTransform called on entity without a model");
        }
        StaticModel.getBoneObjectTransform(this.v, n, H149.j);
        Quaternion quaternion = new Quaternion(Kc180.u(H149.j), Kc180.u(H149.j + 4L), Kc180.u(H149.j + 8L), Kc180.u(H149.j + 12L));
        Vector3 vector3 = new Vector3(Kc180.u(H149.j + 16L), Kc180.u(H149.j + 20L), Kc180.u(H149.j + 24L));
        return new RotTrans(quaternion, vector3);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public LuaUserData getModel() {
        if (this.v != 0L) {
            String string = this.cl == null ? SceneGraphNode.class.getSimpleName() : (this.cl.d ? SkinnedModel.class.getSimpleName() : StaticModel.class.getSimpleName());
            return new LuaUserData(this.v, string);
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getOBBCentre() {
        Vector3 vector3 = this.getWorldTransform().trans;
        Q10 q10 = GameEntity.k(this);
        if (q10 == null) {
            return vector3;
        }
        vector3 = Vector3.m(vector3, 0.0f, q10.l().y, 0.0f);
        return vector3;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetRange3D(Lp301 lp301) {
        return Lc490.j(this, lp301);
    }

    @Override
    public void l() {
        this.ey();
        for (Map.Entry<K, V> entry : this.cd.entrySet()) {
            Component component = (Component)entry.getValue();
            Component.bp(component, null);
            component.bd();
        }
        GameEntity.fa(this);
        this.clearNativeComponents(this.bz.getLuaStateNativeRef());
        this.cd.clear();
        Bb4.d(this.bg);
    }
}

