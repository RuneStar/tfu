/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.scenegraph.E254;
import com.jagex.game.runetek6.scenegraph.Q255;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.LuaUserData;
import com.jagex.maths.Q10;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;
import tfu.L253;

@ScriptEntryClass
public class SceneGraphNode
implements L253 {
    private static final Logger logger = LoggerFactory.getLogger(SceneGraphNode.class);
    SceneGraphNode b = null;
    public boolean d = true;
    private ScaleRotTrans e = null;
    WeakReference h = null;
    private ScaleRotTrans j = null;
    SceneGraphNode l = null;
    private Q10 p;
    private ScaleRotTrans q = ScaleRotTrans.g;
    private E254 r;
    SceneGraphNode s = null;
    private LinkedHashSet t = null;
    public boolean u = true;
    public long v = 0L;
    String w = null;
    public boolean x = false;
    private Q10 y;
    public boolean z = false;

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
    public final void setObjectTransform(ScaleRotTrans scaleRotTrans) {
        if (scaleRotTrans == null) {
            throw new NullPointerException("argument cannot be null");
        }
        this.q = scaleRotTrans;
        SceneGraphNode.p(this);
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
    public final void setObjectRotation(Quaternion quaternion) {
        this.q = this.q.b(quaternion);
        SceneGraphNode.p(this);
    }

    public static final void w(SceneGraphNode sceneGraphNode, Vector3 vector3) {
        sceneGraphNode.q = sceneGraphNode.q.w(vector3);
        SceneGraphNode.p(sceneGraphNode);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setObjectTranslation(float f, float f2, float f3) {
        this.q = this.q.l(f, f2, f3);
        SceneGraphNode.p(this);
    }

    public static final void r(SceneGraphNode sceneGraphNode, Vector3 vector3) {
        sceneGraphNode.q = sceneGraphNode.q.h(vector3);
        SceneGraphNode.p(sceneGraphNode);
    }

    public static final ScaleRotTrans v(SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.e == null) {
            sceneGraphNode.e = sceneGraphNode.getWorldTransform().j();
        }
        return sceneGraphNode.e;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setWorldTransform(RotTrans rotTrans) {
        float f = SceneGraphNode.y(this);
        ScaleRotTrans scaleRotTrans = new ScaleRotTrans(rotTrans, f);
        if (this.l != null) {
            scaleRotTrans = scaleRotTrans.e(SceneGraphNode.v(this.l));
        }
        this.setObjectTransform(scaleRotTrans);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void removeFromScene() {
        Scene scene = this.getScene();
        if (scene != null) {
            Scene.w(scene, this);
        }
    }

    private static final void x(SceneGraphNode sceneGraphNode) {
        SceneGraphNode.z(sceneGraphNode);
        if (sceneGraphNode.s != null) {
            SceneGraphNode.u(sceneGraphNode.s);
        }
    }

    private static final void u(SceneGraphNode sceneGraphNode) {
        SceneGraphNode.x(sceneGraphNode);
        if (sceneGraphNode.b != null) {
            SceneGraphNode.u(sceneGraphNode.b);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void attach(SceneGraphNode sceneGraphNode, String string) {
        if (sceneGraphNode.l == this) {
            logger.warn("this child is already attached to this node - did you mean to attach it twice?", new Throwable());
            return;
        }
        if (sceneGraphNode.l != null) {
            throw new IllegalStateException("This child is already attached to something!");
        }
        if (sceneGraphNode.h != null) {
            throw new IllegalStateException("When attaching entities, the child must not already be in the scene. It will be added automatically if the parent is in the scene (or when the parent is added to the scene).");
        }
        Scene scene = this.getScene();
        if (scene != null) {
            scene.add(sceneGraphNode);
        }
        sceneGraphNode.ag(this, string);
    }

    private static final void m(SceneGraphNode sceneGraphNode) {
        SceneGraphNode.t(sceneGraphNode);
        if (sceneGraphNode.b != null) {
            SceneGraphNode.m(sceneGraphNode.b);
        }
    }

    private static void n(SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.t != null) {
            for (Runnable runnable : sceneGraphNode.t) {
                runnable.run();
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final ScaleRotTrans getWorldTransform() {
        if (this.j == null) {
            this.j = this.l != null ? this.q.e(this.l.getWorldTransform()) : this.q;
        }
        return this.j;
    }

    public static Q10 i(SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.p == null && sceneGraphNode.y != null) {
            sceneGraphNode.p = sceneGraphNode.y.s(sceneGraphNode.getWorldTransform());
        }
        return sceneGraphNode.p;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void hide(@ScriptDefaults(defaultBoolean=true) boolean bl) {
        this.setVisibility(false, bl);
    }

    public static SceneGraphNode a(SceneGraphNode sceneGraphNode) {
        return sceneGraphNode.l;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final Scene getScene() {
        WeakReference weakReference = this.h;
        if (weakReference == null) {
            return null;
        }
        return (Scene)weakReference.get();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setObjectScale(float f) {
        this.q = this.q.s(f);
        SceneGraphNode.p(this);
    }

    protected static final void f(SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.l != null) {
            sceneGraphNode.l.c(sceneGraphNode, sceneGraphNode.w);
        }
        SceneGraphNode sceneGraphNode2 = sceneGraphNode.s;
        while (sceneGraphNode2 != null) {
            sceneGraphNode.c(sceneGraphNode2, sceneGraphNode2.w);
            sceneGraphNode2 = sceneGraphNode2.b;
        }
    }

    protected void c(SceneGraphNode sceneGraphNode, String string) {
    }

    final void ag(SceneGraphNode sceneGraphNode, String string) {
        SceneGraphNode sceneGraphNode2;
        if (this.l != null) {
            sceneGraphNode2 = this.l.s;
            if (sceneGraphNode2 != this) {
                while (sceneGraphNode2.b != this) {
                    sceneGraphNode2 = sceneGraphNode2.b;
                }
                sceneGraphNode2.b = this.b;
            } else {
                this.l.s = this.b;
            }
        }
        if (sceneGraphNode != null) {
            sceneGraphNode2 = sceneGraphNode;
            while (sceneGraphNode2 != null) {
                if (sceneGraphNode2 == this) {
                    throw new RuntimeException();
                }
                sceneGraphNode2 = sceneGraphNode2.l;
            }
            this.b = sceneGraphNode.s;
            sceneGraphNode.s = this;
        } else {
            this.b = null;
        }
        this.l = sceneGraphNode;
        this.w = string;
        if (this.l != null) {
            this.l.c(this, this.w);
        }
        SceneGraphNode.p(this);
    }

    static final void aq(SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.l != null) {
            SceneGraphNode sceneGraphNode2 = sceneGraphNode.l.s;
            if (sceneGraphNode2 != sceneGraphNode) {
                while (sceneGraphNode2.b != sceneGraphNode) {
                    sceneGraphNode2 = sceneGraphNode2.b;
                }
                sceneGraphNode2.b = sceneGraphNode.b;
            } else {
                sceneGraphNode.l.s = sceneGraphNode.b;
            }
        }
        if (sceneGraphNode.s != null) {
            while (sceneGraphNode.s != null) {
                sceneGraphNode.s.q = sceneGraphNode.s.q.e(sceneGraphNode.q);
                sceneGraphNode.s.ag(sceneGraphNode.l, sceneGraphNode.w);
            }
        }
        SceneGraphNode.al(sceneGraphNode, null);
        sceneGraphNode.b = null;
        sceneGraphNode.l = null;
        sceneGraphNode.s = null;
        SceneGraphNode.p(sceneGraphNode);
    }

    public static void o(SceneGraphNode sceneGraphNode, Q10 q10) {
        sceneGraphNode.y = q10;
        sceneGraphNode.p = null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void show(@ScriptDefaults(defaultBoolean=true) boolean bl) {
        this.setVisibility(true, bl);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void setVisibility(boolean bl, @ScriptDefaults(defaultBoolean=true) boolean bl2) {
        this.af(bl);
        if (bl2) {
            SceneGraphNode sceneGraphNode = this.s;
            while (sceneGraphNode != null) {
                sceneGraphNode.setVisibility(bl, bl2);
                sceneGraphNode = sceneGraphNode.b;
            }
        }
    }

    protected void af(boolean bl) {
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public LuaUserData getModel() {
        return new LuaUserData(this.v, SceneGraphNode.class.getSimpleName());
    }

    public static Q10 k(SceneGraphNode sceneGraphNode) {
        return sceneGraphNode.y;
    }

    public static final float y(SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.l == null) {
            return sceneGraphNode.q.scale;
        }
        if (sceneGraphNode.j == null) {
            float f = SceneGraphNode.y(sceneGraphNode.l);
            return f *= sceneGraphNode.q.scale;
        }
        return sceneGraphNode.j.scale;
    }

    protected static void z(SceneGraphNode sceneGraphNode) {
        sceneGraphNode.j = null;
        sceneGraphNode.p = null;
        sceneGraphNode.e = null;
    }

    public Iterable ai() {
        return new Q255(this);
    }

    public static final void al(SceneGraphNode sceneGraphNode, E254 e254) {
        if (sceneGraphNode.r != null) {
            sceneGraphNode.r.d.remove(sceneGraphNode);
            sceneGraphNode.r = null;
        }
        if (e254 != null) {
            sceneGraphNode.r = e254.s(sceneGraphNode);
        }
    }

    private static final void p(SceneGraphNode sceneGraphNode) {
        SceneGraphNode.x(sceneGraphNode);
        SceneGraphNode.t(sceneGraphNode);
    }

    public static final void b(SceneGraphNode sceneGraphNode) {
        sceneGraphNode.l();
        SceneGraphNode sceneGraphNode2 = sceneGraphNode.s;
        while (sceneGraphNode2 != null) {
            SceneGraphNode.b(sceneGraphNode2);
            sceneGraphNode2 = sceneGraphNode2.b;
        }
    }

    private static final void t(SceneGraphNode sceneGraphNode) {
        SceneGraphNode.n(sceneGraphNode);
        if (sceneGraphNode.s != null) {
            SceneGraphNode.m(sceneGraphNode.s);
        }
    }
}

