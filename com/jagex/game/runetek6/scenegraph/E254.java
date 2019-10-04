// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

import com.jagex.maths.S318;
import java.util.HashSet;
import com.jagex.maths.Q10;
import java.util.Iterator;
import com.jagex.maths.E41;
import java.util.Collection;

public class E254
{
    public Collection d;
    public final E254[] g;
    
    protected E254(final E254[] g) {
        this.g = g;
    }
    
    public static final void g(final E254 e254, final E41 e255, final Collection collection) {
        if (j(e254, e255)) {
            if (e254.d != null) {
                for (final SceneGraphNode sceneGraphNode : e254.d) {
                    final Q10 i = SceneGraphNode.i(sceneGraphNode);
                    if (i != null && i.b(e255)) {
                        collection.add(sceneGraphNode);
                    }
                }
            }
            if (e254.g != null) {
                for (int j = 0; j < e254.g.length; ++j) {
                    g(e254.g[j], e255, collection);
                }
            }
        }
    }
    
    final E254 s(final SceneGraphNode sceneGraphNode) {
        E254 e254;
        if (h(this, SceneGraphNode.i(sceneGraphNode))) {
            e254 = this;
            if (this.g != null) {
                for (int i = 0; i < this.g.length; ++i) {
                    final E254 s = this.g[i].s(sceneGraphNode);
                    if (s != null) {
                        e254 = s;
                    }
                }
            }
            if (e254 == this) {
                if (this.d == null) {
                    this.d = new HashSet();
                }
                this.d.add(sceneGraphNode);
            }
        }
        else {
            e254 = null;
        }
        return e254;
    }
    
    public E254() {
        this(null);
    }
    
    public static boolean j(final E254 e254, final E41 e255) {
        return true;
    }
    
    public static boolean e(final E254 e254, final S318 s318) {
        return true;
    }
    
    public static boolean h(final E254 e254, final Q10 q10) {
        return true;
    }
    
    public static final void d(final E254 e254, final S318 s318, final Collection collection) {
        if (e(e254, s318)) {
            if (e254.d != null) {
                for (final SceneGraphNode sceneGraphNode : e254.d) {
                    final Q10 i = SceneGraphNode.i(sceneGraphNode);
                    if (i != null && S318.g(s318, i)) {
                        collection.add(sceneGraphNode);
                    }
                }
            }
            if (e254.g != null) {
                for (int j = 0; j < e254.g.length; ++j) {
                    d(e254.g[j], s318, collection);
                }
            }
        }
    }
    
    public static final int q(final E254 e254, final S318 s318, final SceneGraphNode[] array, int n) {
        int n2 = 0;
        if (e(e254, s318)) {
            if (e254.d != null) {
                for (final SceneGraphNode sceneGraphNode : e254.d) {
                    final Q10 i = SceneGraphNode.i(sceneGraphNode);
                    if (i != null && S318.g(s318, i)) {
                        array[n++] = sceneGraphNode;
                        ++n2;
                    }
                }
            }
            if (e254.g != null) {
                for (int j = 0; j < e254.g.length; ++j) {
                    n2 += q(e254.g[j], s318, array, n);
                }
            }
        }
        return n2;
    }
}
