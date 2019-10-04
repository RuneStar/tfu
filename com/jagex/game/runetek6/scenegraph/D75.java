/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.jnibindings.runetek6.ParticleEngine;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class D75
extends SceneGraphNode {
    private static final Logger logger = LoggerFactory.getLogger(D75.class);
    String n;

    @Override
    public void l() {
        if (this.v != 0L) {
            ParticleEngine.deleteSystem(this.v);
            this.v = 0L;
        }
    }

    private static void j(D75 d75) {
        d75.v = ParticleEngine.createSystem(d75.n);
        if (d75.v == 0L) {
            logger.error("Uh-oh, failed to allocate another Particle System.  Particle System pool probably full.");
        }
    }

    @Override
    protected void af(boolean bl) {
        if (this.v != 0L) {
            ParticleEngine.setEnabled(this.v, bl);
            ParticleEngine.reset(this.v);
        }
    }

    public D75(Vector3 vector3, Quaternion quaternion, String string) {
        this.n = string;
        D75.j(this);
        if (vector3 != null) {
            D75.w(this, vector3);
        }
        if (quaternion != null) {
            this.setObjectRotation(quaternion);
        }
    }
}

