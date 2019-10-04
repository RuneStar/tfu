/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.maths.E41;
import com.jagex.maths.Q10;
import com.jagex.maths.S318;
import java.util.Collection;
import java.util.HashSet;

public class E254 {
    public Collection d;
    public final E254[] g;

    protected E254(E254[] arre254) {
        this.g = arre254;
    }

    public static final void g(E254 e254, E41 e41, Collection collection) {
        if (E254.j(e254, e41)) {
            if (e254.d != null) {
                for (SceneGraphNode sceneGraphNode : e254.d) {
                    Q10 q10 = SceneGraphNode.i(sceneGraphNode);
                    if (q10 == null || !q10.b(e41)) continue;
                    collection.add(sceneGraphNode);
                }
            }
            if (e254.g != null) {
                for (int i = 0; i < e254.g.length; ++i) {
                    E254.g(e254.g[i], e41, collection);
                }
            }
        }
    }

    final E254 s(SceneGraphNode sceneGraphNode) {
        E254 e254;
        if (E254.h(this, SceneGraphNode.i(sceneGraphNode))) {
            e254 = this;
            if (this.g != null) {
                for (int i = 0; i < this.g.length; ++i) {
                    E254 e2542 = this.g[i].s(sceneGraphNode);
                    if (e2542 == null) continue;
                    e254 = e2542;
                }
            }
            if (e254 == this) {
                if (this.d == null) {
                    this.d = new HashSet();
                }
                this.d.add(sceneGraphNode);
            }
        } else {
            e254 = null;
        }
        return e254;
    }

    public E254() {
        this(null);
    }

    public static boolean j(E254 e254, E41 e41) {
        return true;
    }

    public static boolean e(E254 e254, S318 s318) {
        return true;
    }

    public static boolean h(E254 e254, Q10 q10) {
        return true;
    }

    public static final void d(E254 e254, S318 s318, Collection collection) {
        if (E254.e(e254, s318)) {
            if (e254.d != null) {
                for (SceneGraphNode sceneGraphNode : e254.d) {
                    Q10 q10 = SceneGraphNode.i(sceneGraphNode);
                    if (q10 == null || !S318.g(s318, q10)) continue;
                    collection.add(sceneGraphNode);
                }
            }
            if (e254.g != null) {
                for (int i = 0; i < e254.g.length; ++i) {
                    E254.d(e254.g[i], s318, collection);
                }
            }
        }
    }

    public static final int q(E254 e254, S318 s318, SceneGraphNode[] arrsceneGraphNode, int n) {
        int n2 = 0;
        if (E254.e(e254, s318)) {
            if (e254.d != null) {
                for (SceneGraphNode sceneGraphNode : e254.d) {
                    Q10 q10 = SceneGraphNode.i(sceneGraphNode);
                    if (q10 == null || !S318.g(s318, q10)) continue;
                    arrsceneGraphNode[n++] = sceneGraphNode;
                    ++n2;
                }
            }
            if (e254.g != null) {
                for (int i = 0; i < e254.g.length; ++i) {
                    n2 += E254.q(e254.g[i], s318, arrsceneGraphNode, n);
                }
            }
        }
        return n2;
    }
}

