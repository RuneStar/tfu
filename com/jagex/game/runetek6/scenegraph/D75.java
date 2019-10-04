// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import org.slf4j.LoggerFactory;
import com.jagex.jnibindings.runetek6.ParticleEngine;
import org.slf4j.Logger;

public class D75 extends SceneGraphNode
{
    private static final Logger logger;
    String n;
    
    @Override
    public void l() {
        if (super.v != 0L) {
            ParticleEngine.deleteSystem(super.v);
            super.v = 0L;
        }
    }
    
    private static void j(final D75 d75) {
        d75.v = ParticleEngine.createSystem(d75.n);
        if (d75.v == 0L) {
            D75.logger.error("Uh-oh, failed to allocate another Particle System.  Particle System pool probably full.");
        }
    }
    
    @Override
    protected void af(final boolean b) {
        if (super.v != 0L) {
            ParticleEngine.setEnabled(super.v, b);
            ParticleEngine.reset(super.v);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(D75.class);
    }
    
    public D75(final Vector3 vector3, final Quaternion objectRotation, final String n) {
        this.n = n;
        j(this);
        if (vector3 != null) {
            SceneGraphNode.w(this, vector3);
        }
        if (objectRotation != null) {
            this.setObjectRotation(objectRotation);
        }
    }
}
