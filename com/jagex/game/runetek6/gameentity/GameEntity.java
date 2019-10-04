// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity;

import tfu.Lc490;
import com.jagex.jnibindings.runetek6.LuaUserData;
import org.slf4j.LoggerFactory;
import com.jagex.maths.Q10;
import com.jagex.maths.Vector3;
import com.jagex.maths.Quaternion;
import tfu.Kc180;
import com.jagex.maths.RotTrans;
import tfu.Hp62;
import tfu.Hi86;
import com.jagex.game.runetek6.variables.G53;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.jnibindings.runetek6.StaticModel;
import com.jagex.jnibindings.runetek6.SkinnedModel;
import tfu.H149;
import com.jagex.jnibindings.runetek6.Scripting;
import java.util.Collections;
import java.util.Iterator;
import tfu.Ap127;
import tfu.Jy122;
import tfu.Ao128;
import com.jagex.game.runetek6.event.Event;
import java.util.Collection;
import tfu.Gg3;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.lang.ref.WeakReference;
import tfu.Lb33;
import java.util.HashSet;
import java.util.HashMap;
import tfu.N105;
import java.util.LinkedHashSet;
import tfu.Iz11;
import com.jagex.jnibindings.runetek6.Skeleton;
import java.util.Set;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.xelement.XElement;
import java.util.Map;
import java.io.Serializable;
import tfu.Bb4;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import org.slf4j.Logger;
import com.jagex.game.runetek6.event.EventHandler;
import tfu.Ba115;
import java.util.WeakHashMap;
import tfu.Be2;
import tfu.Bs1;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.event.EventForwarder;
import tfu.Lp301;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;

@ScriptEntryClass("Entity")
@Bs1
@Be2
public class GameEntity extends SceneGraphNode implements Lp301, EventForwarder
{
    private static WeakHashMap bc;
    private static final ThreadLocal be;
    public static Ba115 bf;
    public static Ba115 bn;
    private static final WeakHashMap bv;
    private static final EventHandler cq;
    public static J332 cw;
    private static final Logger logger;
    public CollisionObject ba;
    public String bb;
    public final Bb4 bg;
    public Serializable[] bi;
    private Map bs;
    public XElement[] bt;
    public boolean bu;
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
    public int luaComponentTable;
    
    private GameEntity(final Bb4 bg, final ScriptManager bz, final boolean b) {
        this.bu = true;
        this.bb = null;
        this.ba = null;
        this.luaComponentTable = -1;
        this.bs = new HashMap();
        this.cp = new E333(this);
        this.cd = new HashMap();
        this.ce = new G55(this);
        this.ca = new HashSet();
        this.cv = new HashMap();
        Lb33.g(Lb33.NewGameEntityBody);
        if (bg == null) {
            throw new NullPointerException();
        }
        this.bg = bg;
        Lb33.g(Lb33.UpdateEntitesById);
        synchronized (GameEntity.bv) {
            Lb33.g(Lb33.EntitesByIdRemove);
            GameEntity.bv.remove(this.bg);
            Lb33.d(Lb33.EntitesByIdRemove);
            Lb33.g(Lb33.EntitesByIdPut);
            GameEntity.bv.put(this.bg, new WeakReference<GameEntity>(this));
            Lb33.d(Lb33.EntitesByIdPut);
        }
        Lb33.d(Lb33.UpdateEntitesById);
        if (bz == null) {
            throw new NullPointerException();
        }
        this.bz = bz;
        Lb33.g(Lb33.AddCommonEventHandlers);
        ei(this);
        Lb33.d(Lb33.AddCommonEventHandlers);
        Lb33.d(Lb33.NewGameEntityBody);
    }
    
    public final native void setNativeComponent(final long p0, final long p1, final int p2, final Component p3, final String p4);
    
    public final native void clearNativeComponents(final long p0);
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object getProperty(final String s, final Object o) {
        return G55.e(this.ce, s, o);
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + this.bg;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public synchronized Component removeComponent(final Class clazz, @ScriptID @ScriptDefaults(defaultInteger = 305419896) int l) {
        if (l == 305419896) {
            l = StringTools.l(clazz.getName());
        }
        final Component component = this.cd.remove(l);
        if (component != null) {
            Component.bp(component, null);
            component.bd();
        }
        this.setNativeComponent(this.bz.getScriptManagerNativeRef(), this.bz.getLuaStateNativeRef(), l, null, null);
        return component;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setIsModelStatic(final boolean bu) {
        this.bu = bu;
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
        final Gg3 gg3 = new Gg3(3);
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
    
    public static void em(final Collection value, final Runnable runnable) {
        try {
            GameEntity.be.set(value);
            runnable.run();
        }
        finally {
            GameEntity.be.set(null);
        }
    }
    
    public static GameEntity es(final Bb4 key) {
        final WeakReference<GameEntity> weakReference;
        synchronized (GameEntity.bv) {
            weakReference = GameEntity.bv.get(key);
        }
        if (weakReference != null) {
            final GameEntity gameEntity = weakReference.get();
            if (gameEntity != null) {
                final Collection<GameEntity> collection = GameEntity.be.get();
                if (collection != null) {
                    collection.add(gameEntity);
                }
            }
            return gameEntity;
        }
        return null;
    }
    
    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity LookupPackedUUID(final Object o, final byte[] array) {
        return lookupPackedID(array);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity lookupPackedID(final byte[] array) {
        final Bb4 j = Bb4.j(new Gg3(array));
        final GameEntity es = es(j);
        if (es == null) {
            GameEntity.logger.debug("Protocol Buffers: packed ID {} doesn't refer to a GameEntity that we know about.", j);
        }
        return es;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity lookupID(final String s) {
        final Bb4 g = Bb4.g(s);
        final GameEntity es = es(g);
        if (es == null) {
            GameEntity.logger.debug("Protocol Buffers: string ID {} doesn't refer to a GameEntity that we know about.", g);
        }
        return es;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandlerByID(@ScriptID final Integer n, final EventHandler eventHandler) {
        Event event = this.bs.get(n);
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
    public void removeEventHandler(final String s, final EventHandler eventHandler) {
        ec(this, StringTools.l(s), eventHandler);
    }
    
    public static void ec(@ScriptID final GameEntity gameEntity, final Integer n, final EventHandler o) {
        final Event event = gameEntity.bs.get(n);
        if (event != null) {
            event.remove(o);
        }
    }
    
    public void eh(final String s, final Object obj) {
        if (this.bz.getThread() != Thread.currentThread()) {
            final String string = "GameEntity.triggerEvent() called from " + Thread.currentThread() + " - main thread is " + this.bz.getThread();
            GameEntity.logger.error(string, new Ao128());
            throw new IllegalStateException(string);
        }
        Lb33.g(Lb33.EntityTriggerEventName);
        try {
            final long nanoTime = System.nanoTime();
            if (Jy122.g(ScriptManager.calltrace)) {
                Jy122.h(ScriptManager.calltrace, "ENTITY EVENT: " + s + "(" + obj + ") on " + this);
            }
            this.triggerEvent(StringTools.l(s), obj);
            if (Jy122.g(ScriptManager.calltrace)) {
                Jy122.l(ScriptManager.calltrace, "END");
            }
            if (Ap127.d) {
                final long n = System.nanoTime() - nanoTime;
                final float n2 = n * 1.0E-6f;
                if (n2 > Ap127.j) {
                    Ap127.g(n, "Lua handling for the event '" + s + "' took longer than 1 ms: " + (int)(n2 * 10.0f) / 10.0f + " ms. Update frame " + Ap127.h);
                }
            }
        }
        finally {
            Lb33.d(Lb33.EntityTriggerEventName);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void triggerEvent(@ScriptID final Integer n, final Object o) {
        Lb33.g(Lb33.EntityTriggerEventHash);
        try {
            final Event event = this.bs.get(n);
            if (event != null) {
                event.trigger(this, o);
            }
        }
        finally {
            Lb33.d(Lb33.EntityTriggerEventHash);
        }
    }
    
    public static void ef(final GameEntity gameEntity) {
        final Iterator<Event> iterator = gameEntity.bs.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().removeStaticallyConfiguredHandlers();
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getModelJointIndex(final String s) {
        int d = -1;
        if (super.v == 0L) {
            return d;
        }
        if (this != null) {
            if (super.v == 0L) {
                return d;
            }
            if (this.cb != null && s != null) {
                d = this.cb.d(s);
            }
        }
        return d;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity construct(final ScriptManager scriptManager) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        Lb33.g(Lb33.GameEntityIdAllocate);
        final Bb4 s = GameEntity.bf.s();
        Lb33.d(Lb33.GameEntityIdAllocate);
        Lb33.g(Lb33.NewGameEntity);
        final GameEntity key = new GameEntity(s, scriptManager, false);
        Lb33.d(Lb33.NewGameEntity);
        Lb33.g(Lb33.GameEntityConstructStack);
        final Ao128 ao128 = new Ao128();
        Lb33.d(Lb33.GameEntityConstructStack);
        Lb33.g(Lb33.GameEntityConstructBuilder);
        final StringBuilder sb = new StringBuilder();
        Lb33.d(Lb33.GameEntityConstructBuilder);
        for (final StackTraceElement stackTraceElement : ao128.getStackTrace()) {
            Lb33.g(Lb33.GameEntityConstructAppend);
            sb.append(stackTraceElement.toString());
            sb.append('\n');
            Lb33.d(Lb33.GameEntityConstructAppend);
        }
        Lb33.g(Lb33.GameEntityConstructPut);
        GameEntity.bc.put(key, sb.toString());
        Lb33.d(Lb33.GameEntityConstructPut);
        return key;
    }
    
    public static Map ek(final GameEntity gameEntity) {
        return Collections.unmodifiableMap((Map<?, ?>)gameEntity.cd);
    }
    
    public static Component eb(final GameEntity gameEntity, final Class clazz) {
        return gameEntity.getComponent(clazz, 305419896);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean hasComponent(final Class clazz, @ScriptID @ScriptDefaults(defaultInteger = 305419896) final int n) {
        return this.cd.get((n == 305419896) ? StringTools.l(clazz.getName()) : n) != null;
    }
    
    public static Component ep(final GameEntity gameEntity, final Component component) {
        return gameEntity.addComponent(component, 305419896);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public synchronized Component addComponent(final Component component, @ScriptID @ScriptDefaults(defaultInteger = 305419896) int l) {
        if (l == 305419896) {
            l = StringTools.l(component.getClass().getName());
        }
        final Component component2 = this.cd.put(l, component);
        if (component2 != null) {
            Component.bp(component2, null);
            component2.bd();
        }
        Component.bp(component, this);
        this.setNativeComponent(this.bz.getScriptManagerNativeRef(), this.bz.getLuaStateNativeRef(), l, component, Scripting.typeSig(component));
        return component2;
    }
    
    public GameEntity(final Bb4 bg, final ScriptManager bz) {
        this.bu = true;
        this.bb = null;
        this.ba = null;
        this.luaComponentTable = -1;
        this.bs = new HashMap();
        this.cp = new E333(this);
        this.cd = new HashMap();
        this.ce = new G55(this);
        this.ca = new HashSet();
        this.cv = new HashMap();
        if (bg == null) {
            throw new NullPointerException();
        }
        this.bg = bg;
        synchronized (GameEntity.bv) {
            GameEntity.bv.remove(this.bg);
            GameEntity.bv.put(this.bg, new WeakReference<GameEntity>(this));
        }
        if (bz == null) {
            throw new NullPointerException();
        }
        this.bz = bz;
        ei(this);
    }
    
    public final void et(final Q344 e) {
        if (this.ck == null) {
            this.ck = new LinkedHashSet();
        }
        this.ck.add(e);
    }
    
    public static final void eu(final GameEntity gameEntity, final Q344 o) {
        if (gameEntity.ck != null) {
            gameEntity.ck.remove(o);
        }
    }
    
    private void ey() {
        if (this.ck != null) {
            final Q344[] array = (Q344[])this.ck.toArray(new Q344[this.ck.size()]);
            for (int i = array.length - 1; i >= 0; --i) {
                try {
                    array[i].g(this);
                }
                catch (Exception ex) {
                    System.err.print("Error in release hook for entity " + this + ": ");
                    ex.printStackTrace();
                }
            }
            this.ck = null;
        }
    }
    
    @Override
    protected void af(final boolean b) {
        synchronized (H149.v) {
            final Scene scene = this.getScene();
            long y = 0L;
            if (scene != null) {
                y = scene.y;
            }
            if (super.v != 0L && this.cl != null) {
                if (this.cl.d) {
                    if (b) {
                        SkinnedModel.show(y, super.v);
                    }
                    else {
                        SkinnedModel.hide(y, super.v);
                    }
                }
                else if (b) {
                    StaticModel.setIsStatic(super.v, this.bu);
                    StaticModel.show(y, super.v);
                }
                else {
                    StaticModel.hide(y, super.v);
                }
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void attachTo(final GameEntity gameEntity, final String s) {
        gameEntity.attach(this, s);
    }
    
    public static void ea(final GameEntity gameEntity, final G53 g53) {
        gameEntity.ce.d(g53);
    }
    
    public static int ev(final GameEntity gameEntity, final String s, final int n) {
        return G55.q(gameEntity.ce, s, n);
    }
    
    public static void fv(long n, final Skeleton skeleton, final N105 n2) {
        synchronized (H149.v) {
            if (n != 0L) {
                if (n2 != null) {
                    if (n2.d) {
                        SkinnedModel.destroy(n);
                    }
                    else {
                        StaticModel.destroy(n);
                    }
                }
                else {
                    com.jagex.jnibindings.runetek6.SceneGraphNode.destroy(n);
                }
                n = 0L;
            }
            if (skeleton != null) {
                Hi86.l(skeleton.g, skeleton);
            }
            if (n2 != null) {
                Hi86.l(n2.g, n2);
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setProperty(final String s, final Object o) {
        this.ce.h(s, o);
    }
    
    public static Object ej(final GameEntity gameEntity, final String s) {
        return gameEntity.ce.j(s);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public String enablePropertyChangeEvent(final String s) {
        return this.ce.g(s);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Integer hasPropertyChangeEvent(final String s) {
        return G55.s(this.ce, StringTools.l(s));
    }
    
    public static Integer ex(final GameEntity gameEntity, final int n) {
        return G55.s(gameEntity.ce, n);
    }
    
    public static void ed(final GameEntity gameEntity, final int n, final int i, final int n2) {
        if (i != n2) {
            final Integer ex = ex(gameEntity, n);
            if (ex != null) {
                gameEntity.triggerEvent(ex, i);
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean hasSkeleton() {
        return this.cb != null;
    }
    
    public static Skeleton el(final GameEntity gameEntity) {
        return gameEntity.cb;
    }
    
    @Override
    protected void c(final SceneGraphNode sceneGraphNode, final String s) {
        if (super.v == 0L || sceneGraphNode.v == 0L) {
            return;
        }
        if (this.cb != null && this.cl != null && s != null) {
            final int d = this.cb.d(s);
            if (d != -1) {
                StaticModel.attachNodeToBone(super.v, sceneGraphNode.v, d);
            }
            else {
                com.jagex.jnibindings.runetek6.SceneGraphNode.setParent(sceneGraphNode.v, super.v);
            }
        }
        else {
            com.jagex.jnibindings.runetek6.SceneGraphNode.setParent(sceneGraphNode.v, super.v);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isJointValid(final int n) {
        return this.hasSkeleton() && n >= 0 && n < this.cb.g();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans getJointWorldTransform(final int n) {
        if (!this.hasSkeleton()) {
            GameEntity.logger.warn("Error, no skeleton found on GameEntity during joint transform lookup. Either the entity's skeleton has yet to be constructed or it does not exist.");
            return RotTrans.g;
        }
        if (n == -1) {
            GameEntity.logger.warn("Error, erroneous joint index passed during joint transform lookup. Suspect no joint existed for the previous lookup.");
            return RotTrans.g;
        }
        if (n < 0 || n >= this.cb.g()) {
            GameEntity.logger.warn("Error, out of bound joint index.");
            return RotTrans.g;
        }
        StaticModel.getBoneWorldTransform(super.v, n, H149.j);
        return new RotTrans(new Quaternion(Kc180.u(H149.j), Kc180.u(H149.j + 4L), Kc180.u(H149.j + 8L), Kc180.u(H149.j + 12L)), new Vector3(Kc180.u(H149.j + 16L), Kc180.u(H149.j + 20L), Kc180.u(H149.j + 24L)));
    }
    
    public static boolean ee(final GameEntity gameEntity, final Class clazz) {
        return gameEntity.hasComponent(clazz, 305419896);
    }
    
    public static long ew(final Skeleton skeleton, final N105 n105) {
        synchronized (H149.v) {
            long create;
            if (n105 != null) {
                final long[] q = n105.q;
                final int e = Kc180.e();
                final long g = Kc180.g(q.length * e);
                for (int i = 0; i < q.length; ++i) {
                    Kc180.s(g + i * e, q[i]);
                }
                create = (n105.d ? SkinnedModel.create() : StaticModel.create(n105.h));
                if (skeleton != null) {
                    StaticModel.g(create, skeleton);
                }
                else if (n105.d) {
                    GameEntity.logger.info("Error, skinned model doesn't have a skeleton");
                }
                StaticModel.replaceMeshes(create, g, q.length, n105.s[0]);
                Kc180.d(g);
            }
            else {
                create = com.jagex.jnibindings.runetek6.SceneGraphNode.create();
                if (skeleton != null) {
                    GameEntity.logger.warn("Warning, scene graph node has a skeleton");
                    Hi86.l(skeleton.g, skeleton);
                }
            }
            return create;
        }
    }
    
    public static void en(final GameEntity gameEntity, final long v, final Skeleton cb, final N105 cl) {
        synchronized (H149.v) {
            final boolean b = gameEntity.v != v;
            fa(gameEntity);
            gameEntity.v = v;
            gameEntity.cb = cb;
            gameEntity.cl = cl;
            SceneGraphNode.f(gameEntity);
            if (b) {
                gameEntity.eh("__modelChanged", null);
            }
        }
    }
    
    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity LookupUUID(final Object o, final String s) {
        return lookupID(s);
    }
    
    public static boolean eq(final GameEntity gameEntity) {
        return gameEntity.cl != null && gameEntity.cl.d;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getOBBTop() {
        final Vector3 trans = this.getWorldTransform().trans;
        final Q10 k = SceneGraphNode.k(this);
        if (k == null) {
            return trans;
        }
        return Vector3.m(trans, 0.0f, Q10.q(k), 0.0f);
    }
    
    public static void fa(final GameEntity gameEntity) {
        synchronized (H149.v) {
            fv(gameEntity.v, gameEntity.cb, gameEntity.cl);
            gameEntity.cb = null;
            gameEntity.cl = null;
            gameEntity.v = 0L;
        }
    }
    
    @Override
    public Vector3 j() {
        final Q10 i = SceneGraphNode.i(this);
        if (i == null) {
            return this.getWorldTransform().trans;
        }
        return Vector3.g(Q10.d(i), Q10.j(i), Q10.h(i));
    }
    
    @Override
    public Vector3 e() {
        final Q10 i = SceneGraphNode.i(this);
        if (i == null) {
            return this.getWorldTransform().trans;
        }
        return Vector3.g(Q10.g(i), Q10.q(i), Q10.e(i));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getID() {
        return this.bg.toString();
    }
    
    public static Component eo(final GameEntity gameEntity, final Class clazz) {
        return gameEntity.removeComponent(clazz, 305419896);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeAllEventHandlers(@ScriptID final Integer n) {
        this.bs.remove(n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Component getComponent(final Class clazz, @ScriptID @ScriptDefaults(defaultInteger = 305419896) final int n) {
        return this.cd.get((n == 305419896) ? StringTools.l(clazz.getName()) : n);
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
    public void addEventHandler(final String s, final EventHandler eventHandler) {
        this.addEventHandlerByID(StringTools.l(s), eventHandler);
    }
    
    static {
        logger = LoggerFactory.getLogger(GameEntity.class);
        bv = new WeakHashMap();
        GameEntity.bc = new WeakHashMap();
        be = new ThreadLocal();
        cq = new D331();
    }
    
    protected static void ei(final GameEntity gameEntity) {
        gameEntity.addEventHandler("__sound", GameEntity.cq);
        gameEntity.addEventHandler("FootPlaced", gameEntity.cp);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans getJointObjectTransform(final int n) {
        if (super.v == 0L) {
            throw new IllegalStateException("GetJointObjectTransform called on entity without a model");
        }
        StaticModel.getBoneObjectTransform(super.v, n, H149.j);
        return new RotTrans(new Quaternion(Kc180.u(H149.j), Kc180.u(H149.j + 4L), Kc180.u(H149.j + 8L), Kc180.u(H149.j + 12L)), new Vector3(Kc180.u(H149.j + 16L), Kc180.u(H149.j + 20L), Kc180.u(H149.j + 24L)));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public LuaUserData getModel() {
        if (super.v != 0L) {
            String simpleName;
            if (this.cl == null) {
                simpleName = SceneGraphNode.class.getSimpleName();
            }
            else {
                simpleName = (this.cl.d ? SkinnedModel.class.getSimpleName() : StaticModel.class.getSimpleName());
            }
            return new LuaUserData(super.v, simpleName);
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getOBBCentre() {
        final Vector3 trans = this.getWorldTransform().trans;
        final Q10 k = SceneGraphNode.k(this);
        if (k == null) {
            return trans;
        }
        return Vector3.m(trans, 0.0f, k.l().y, 0.0f);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetRange3D(final Lp301 lp301) {
        return Lc490.j(this, lp301);
    }
    
    @Override
    public void l() {
        this.ey();
        final Iterator<Map.Entry<K, Component>> iterator = this.cd.entrySet().iterator();
        while (iterator.hasNext()) {
            final Component component = iterator.next().getValue();
            Component.bp(component, null);
            component.bd();
        }
        fa(this);
        this.clearNativeComponents(this.bz.getLuaStateNativeRef());
        this.cd.clear();
        Bb4.d(this.bg);
    }
}
