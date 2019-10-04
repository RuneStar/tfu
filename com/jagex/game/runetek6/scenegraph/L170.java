/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.jnibindings.runetek6.Light;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class L170
extends SceneGraphNode {
    private static final Logger logger = LoggerFactory.getLogger(L170.class);
    Vector3 k;
    float n;

    private static void j(L170 l170) {
        l170.v = Light.create();
        if (l170.v == 0L) {
            logger.error("Uh-oh, failed to allocate another Light.  Light pool probably full.");
            return;
        }
        Light.setParams(l170.v, 0.0f, 0.0f, 0.0f, l170.n, l170.k.x, l170.k.y, l170.k.z);
    }

    @Override
    public void l() {
        if (this.v != 0L) {
            Light.destroy(this.v);
            this.v = 0L;
        }
    }

    public L170(Vector3 vector3, float f, Vector3 vector32) {
        this.n = f;
        this.k = vector32;
        L170.j(this);
        if (vector3 != null) {
            L170.w(this, vector3);
        }
    }
}

