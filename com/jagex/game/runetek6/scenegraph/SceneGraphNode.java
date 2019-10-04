// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

import com.jagex.jnibindings.runetek6.LuaUserData;
import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.script.ScriptDefaults;
import java.util.Iterator;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import com.jagex.maths.Quaternion;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.LinkedHashSet;
import com.jagex.maths.Q10;
import java.lang.ref.WeakReference;
import com.jagex.maths.ScaleRotTrans;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import tfu.L253;

@ScriptEntryClass
public class SceneGraphNode implements L253
{
    private static final Logger logger;
    SceneGraphNode b;
    public boolean d;
    private ScaleRotTrans e;
    WeakReference h;
    private ScaleRotTrans j;
    SceneGraphNode l;
    private Q10 p;
    private ScaleRotTrans q;
    private E254 r;
    SceneGraphNode s;
    private LinkedHashSet t;
    public boolean u;
    public long v;
    String w;
    public boolean x;
    private Q10 y;
    public boolean z;
    
    @Override
    public final long g() {
        return this.v;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final ScaleRotTrans getParentWorldTransform() {
        if (this.l != null) {
            return this.l.getWorldTransform();
        }
        return null;
    }
    
    public void l() {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public final ScaleRotTrans getObjectTransform() {
        return this.q;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setObjectTransform(final ScaleRotTrans q) {
        if (q == null) {
            throw new NullPointerException("argument cannot be null");
        }
        this.q = q;
        p(this);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final float getObjectScale() {
        return this.q.scale;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setObjectRotation(final Quaternion quaternion) {
        this.q = this.q.b(quaternion);
        p(this);
    }
    
    public static final void w(final SceneGraphNode sceneGraphNode, final Vector3 vector3) {
        sceneGraphNode.q = sceneGraphNode.q.w(vector3);
        p(sceneGraphNode);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setObjectTranslation(final float n, final float n2, final float n3) {
        this.q = this.q.l(n, n2, n3);
        p(this);
    }
    
    public static final void r(final SceneGraphNode sceneGraphNode, final Vector3 vector3) {
        sceneGraphNode.q = sceneGraphNode.q.h(vector3);
        p(sceneGraphNode);
    }
    
    public static final ScaleRotTrans v(final SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.e == null) {
            sceneGraphNode.e = sceneGraphNode.getWorldTransform().j();
        }
        return sceneGraphNode.e;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setWorldTransform(final RotTrans rotTrans) {
        ScaleRotTrans e = new ScaleRotTrans(rotTrans, y(this));
        if (this.l != null) {
            e = e.e(v(this.l));
        }
        this.setObjectTransform(e);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void removeFromScene() {
        final Scene scene = this.getScene();
        if (scene != null) {
            Scene.w(scene, this);
        }
    }
    
    private static final void x(final SceneGraphNode sceneGraphNode) {
        z(sceneGraphNode);
        if (sceneGraphNode.s != null) {
            u(sceneGraphNode.s);
        }
    }
    
    public SceneGraphNode() {
        this.d = true;
        this.q = ScaleRotTrans.g;
        this.j = null;
        this.e = null;
        this.h = null;
        this.s = null;
        this.b = null;
        this.l = null;
        this.w = null;
        this.v = 0L;
        this.x = false;
        this.u = true;
        this.z = false;
        this.t = null;
    }
    
    private static final void u(final SceneGraphNode sceneGraphNode) {
        x(sceneGraphNode);
        if (sceneGraphNode.b != null) {
            u(sceneGraphNode.b);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void attach(final SceneGraphNode sceneGraphNode, final String s) {
        if (sceneGraphNode.l == this) {
            SceneGraphNode.logger.warn("this child is already attached to this node - did you mean to attach it twice?", new Throwable());
            return;
        }
        if (sceneGraphNode.l != null) {
            throw new IllegalStateException("This child is already attached to something!");
        }
        if (sceneGraphNode.h != null) {
            throw new IllegalStateException("When attaching entities, the child must not already be in the scene. It will be added automatically if the parent is in the scene (or when the parent is added to the scene).");
        }
        final Scene scene = this.getScene();
        if (scene != null) {
            scene.add(sceneGraphNode);
        }
        sceneGraphNode.ag(this, s);
    }
    
    private static final void m(final SceneGraphNode sceneGraphNode) {
        t(sceneGraphNode);
        if (sceneGraphNode.b != null) {
            m(sceneGraphNode.b);
        }
    }
    
    private static void n(final SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.t != null) {
            final Iterator iterator = sceneGraphNode.t.iterator();
            while (iterator.hasNext()) {
                iterator.next().run();
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final ScaleRotTrans getWorldTransform() {
        if (this.j == null) {
            if (this.l != null) {
                this.j = this.q.e(this.l.getWorldTransform());
            }
            else {
                this.j = this.q;
            }
        }
        return this.j;
    }
    
    public static Q10 i(final SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.p == null && sceneGraphNode.y != null) {
            sceneGraphNode.p = sceneGraphNode.y.s(sceneGraphNode.getWorldTransform());
        }
        return sceneGraphNode.p;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void hide(@ScriptDefaults(defaultBoolean = true) final boolean b) {
        this.setVisibility(false, b);
    }
    
    public static SceneGraphNode a(final SceneGraphNode sceneGraphNode) {
        return sceneGraphNode.l;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final Scene getScene() {
        final WeakReference h = this.h;
        if (h == null) {
            return null;
        }
        return h.get();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setObjectScale(final float n) {
        this.q = this.q.s(n);
        p(this);
    }
    
    protected static final void f(final SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.l != null) {
            sceneGraphNode.l.c(sceneGraphNode, sceneGraphNode.w);
        }
        for (SceneGraphNode sceneGraphNode2 = sceneGraphNode.s; sceneGraphNode2 != null; sceneGraphNode2 = sceneGraphNode2.b) {
            sceneGraphNode.c(sceneGraphNode2, sceneGraphNode2.w);
        }
    }
    
    protected void c(final SceneGraphNode sceneGraphNode, final String s) {
    }
    
    final void ag(final SceneGraphNode l, final String w) {
        if (this.l != null) {
            SceneGraphNode sceneGraphNode = this.l.s;
            if (sceneGraphNode != this) {
                while (sceneGraphNode.b != this) {
                    sceneGraphNode = sceneGraphNode.b;
                }
                sceneGraphNode.b = this.b;
            }
            else {
                this.l.s = this.b;
            }
        }
        if (l != null) {
            for (SceneGraphNode i = l; i != null; i = i.l) {
                if (i == this) {
                    throw new RuntimeException();
                }
            }
            this.b = l.s;
            l.s = this;
        }
        else {
            this.b = null;
        }
        this.l = l;
        this.w = w;
        if (this.l != null) {
            this.l.c(this, this.w);
        }
        p(this);
    }
    
    static final void aq(final SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.l != null) {
            SceneGraphNode sceneGraphNode2 = sceneGraphNode.l.s;
            if (sceneGraphNode2 != sceneGraphNode) {
                while (sceneGraphNode2.b != sceneGraphNode) {
                    sceneGraphNode2 = sceneGraphNode2.b;
                }
                sceneGraphNode2.b = sceneGraphNode.b;
            }
            else {
                sceneGraphNode.l.s = sceneGraphNode.b;
            }
        }
        if (sceneGraphNode.s != null) {
            while (sceneGraphNode.s != null) {
                sceneGraphNode.s.q = sceneGraphNode.s.q.e(sceneGraphNode.q);
                sceneGraphNode.s.ag(sceneGraphNode.l, sceneGraphNode.w);
            }
        }
        al(sceneGraphNode, null);
        sceneGraphNode.b = null;
        sceneGraphNode.l = null;
        sceneGraphNode.s = null;
        p(sceneGraphNode);
    }
    
    public static void o(final SceneGraphNode sceneGraphNode, final Q10 y) {
        sceneGraphNode.y = y;
        sceneGraphNode.p = null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void show(@ScriptDefaults(defaultBoolean = true) final boolean b) {
        this.setVisibility(true, b);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setVisibility(final boolean b, @ScriptDefaults(defaultBoolean = true) final boolean b2) {
        this.af(b);
        if (b2) {
            for (SceneGraphNode sceneGraphNode = this.s; sceneGraphNode != null; sceneGraphNode = sceneGraphNode.b) {
                sceneGraphNode.setVisibility(b, b2);
            }
        }
    }
    
    protected void af(final boolean b) {
    }
    
    static {
        logger = LoggerFactory.getLogger(SceneGraphNode.class);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public LuaUserData getModel() {
        return new LuaUserData(this.v, SceneGraphNode.class.getSimpleName());
    }
    
    public static Q10 k(final SceneGraphNode sceneGraphNode) {
        return sceneGraphNode.y;
    }
    
    public static final float y(final SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.l == null) {
            return sceneGraphNode.q.scale;
        }
        if (sceneGraphNode.j == null) {
            return y(sceneGraphNode.l) * sceneGraphNode.q.scale;
        }
        return sceneGraphNode.j.scale;
    }
    
    protected static void z(final SceneGraphNode sceneGraphNode) {
        sceneGraphNode.j = null;
        sceneGraphNode.p = null;
        sceneGraphNode.e = null;
    }
    
    public Iterable ai() {
        return new Q255(this);
    }
    
    public static final void al(final SceneGraphNode sceneGraphNode, final E254 e254) {
        if (sceneGraphNode.r != null) {
            sceneGraphNode.r.d.remove(sceneGraphNode);
            sceneGraphNode.r = null;
        }
        if (e254 != null) {
            sceneGraphNode.r = e254.s(sceneGraphNode);
        }
    }
    
    private static final void p(final SceneGraphNode sceneGraphNode) {
        x(sceneGraphNode);
        t(sceneGraphNode);
    }
    
    public static final void b(final SceneGraphNode sceneGraphNode) {
        sceneGraphNode.l();
        for (SceneGraphNode sceneGraphNode2 = sceneGraphNode.s; sceneGraphNode2 != null; sceneGraphNode2 = sceneGraphNode2.b) {
            b(sceneGraphNode2);
        }
    }
    
    private static final void t(final SceneGraphNode sceneGraphNode) {
        n(sceneGraphNode);
        if (sceneGraphNode.s != null) {
            m(sceneGraphNode.s);
        }
    }
}
