/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class Ap73 {
    private static final Logger logger = LoggerFactory.getLogger(Ap73.class);
    ArrayList b;
    String s;

    static final void r(Ap73 ap73, SceneGraphNode sceneGraphNode) {
        if (ap73.b != null) {
            for (Ap73 ap732 : ap73.b) {
                try {
                    SceneGraphNode sceneGraphNode2 = ap732.y();
                    sceneGraphNode.attach(sceneGraphNode2, ap732.s);
                    Ap73.r(ap732, sceneGraphNode2);
                }
                catch (Exception exception) {
                    logger.error("", exception);
                }
            }
        }
    }

    abstract SceneGraphNode y();

    abstract void p();

    public static final void v(Ap73 ap73) {
        ap73.p();
        if (ap73.b != null) {
            for (Ap73 ap732 : ap73.b) {
                Ap73.v(ap732);
            }
        }
    }

    Ap73() {
    }
}

